pipeline {
    agent none
    options {
        timeout(time: 1, unit: 'MINUTES')
        //quietPeriod(1)
        retry(0)
        //disableConcurrentBuilds abortPrevious: true
        buildDiscarder logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '', numToKeepStr: '5')
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
    stages {
        stage('Test git') {
            agent {
                label 'deb'
            }
            //tools {
            //    git 'git'
            //}
            steps {
                git 'https://github.com/olgierdxyz/hello-html.git'
            }
        }
        
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
        

        stage('Prepare environment') {
            agent {
                label 'deb'
            }
            steps {
                tool 'docker', 'Default'
                sh 'systemctl start docker'
            }
        }
        stage('Build with Docker') {
            //tools {
            //    dockerTool "my-docker-debian-11"
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

    }
}
