pipeline {
    //agent any
                agent {
                docker {
                    image 'gradle:latest'
                    //args '--user 1000:1000'
                    reuseNode true
                }
            }
    options {
        timeout(time: 1, unit: 'MINUTES')
        quietPeriod(1)
        retry(0)
        //disableConcurrentBuilds abortPrevious: true
        buildDiscarder logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '', numToKeepStr: '5')
        //timestamps()
        ansiColor('xterm')
    }
    tools {
        maven "M3"
        gradle "G8"
    }
    triggers {
        githubPush()
        //pollSCM('H H(3-5) * * *')
        //cron('H H(5-6) * * *')
        //
    }
    stages {
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
        stage('Build with Docker') {

            steps {
                //lock('hello-java-build-lock') {                    
                    //sh "mvn -Dmaven.test.failure.ignore=true clean compile package"
                timestamps {
                    //sh "mvn clean compile package"
                    sh "gradle clean classes build"
                }
            }
        }
    }
}
