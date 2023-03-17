#!/usr/bin/env groovy

pipeline {
    agent none
    options {
        timeout(time: 1, unit: 'MINUTES')
        quietPeriod(0)
        retry(0)
        disableConcurrentBuilds abortPrevious: true
        buildDiscarder(logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '', numToKeepStr: '5'))
        skipStagesAfterUnstable()
        //timestamps()
        ansiColor('xterm')
    }
    environment {
        TIMEZONE = "Europe/Warsaw"
        TIMEZONE_DS = "${TIMEZONE}_daylight_savings"
        //ADMIN_USER = credentials('admin-user')
    }
    // "Tools" directive requires agent other than "none". Othervise has no effect.
    //tools {
        //dockerTool "my-docker-debian-11"
        //maven "M3"
        //gradle "G8"
        //dockerTool "my-docker-debian-11"
        //tool name: 'my-docker-debian-11', type: 'dockerTool'
        //tool name: 'my-docker-centos-8', type: 'dockerTool'
    //}

    triggers {
        githubPush()
        //pollSCM('H H(3-5) * * *')
        //cron('H H(5-6) * * *')
    }

    //
    stages {
        stage('Test') {
            agent any
            steps {
                //sh script: 'echo Hello', returnStdout: true
                //sh script: 'ls -la /', returnStdout:true
                script {
                    def listing = sh script: 'ls -la /', returnStdout:true
                    echo listing
                }
                script {
                    sh 'export NAME=Jenkins; echo Hello, $NAME from shell!'
                    sh '''#!/usr/bin/perl
                    my $name = "Jenkins";
                    print "Hello, $name from Perl!\n";'''

                    // Example of dealing with leading whitespaces for sensitive in this regard scripts, like Python:
                    sh '''\
                    #!/usr/bin/env /usr/bin/python3
                    name="Jenkins"
                    print('Hello {} from Python!'.format(name))'''.stripIndent()

                    sh 'pwd'

                    def myExternalScript = libraryResource 'test.sh'
                    sh myExternalScript
                }
                sh "${libraryResource 'test.sh'}"

            }
        }
        /*
        stage('Build') {
            agent {
                label 'deb'
            }
            options {
                skipDefaultCheckout()
            }
            tools {
                gradle "G8"
            }
            steps {
                // Jenkinsfile is checked out separately via "Pipeline script from SCM"
                // Checks out entire repository (not only Jenkinsfile!)
                checkout scm
                //sh "gradle clean classes build"
                tool 'make-deb'
                sh 'make build'
            }
        }
        */

        //
        /*
        stage('Test git') {
            agent {
                label 'deb'
            }
            //tools {
            //    git 'git'
            //    git 'git-default'
            //}
            steps {
                //tool 'git-default'
                git 'https://github.com/olgierdxyz/hello-html.git'
            }
        }
        */
        /*
        stage('Build') {
            steps {
                //lock('hello-java-build-lock') {                    
                    //sh "mvn -Dmaven.test.failure.ignore=true clean compile package"
                timestamps {
                    //sh "mvn clean compile package"
                    sh "gradle clean classes build"
                }
                //}
            }
            post {
                success {
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
        */

        /*
        stage('Prepare environment') {
            agent {
                label 'deb'
            }
            tools {
                dockerTool 'docker-deb'
            }
            steps {
                sh 'docker --version'
            }
        }

        stage('Build with Docker') {
            //tools {
            //    dockerTool 'docker-deb'
            //}
            agent {
                docker {
                    image 'gradle:latest'
                    //args '--user 1000:1000'
                    reuseNode true
                }
            }
            steps {
                //lock('hello-java-build-lock') {                    
                    //sh "mvn -Dmaven.test.failure.ignore=true clean compile package"
                //timestamps {
                    //sh "mvn clean compile package"
                    sh "gradle clean classes build"
                //}
            }
            post {
                success {
                    stash name: 'artifacts', includes: 'build/libs/*.jar'
                    //archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint: true
                }
            }
        }
        */
    }
}
