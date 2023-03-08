pipeline {
    agent any
    options {
        buildDiscarder logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '', numToKeepStr: '10')
        ansiColor('xterm')
    }
    tools {
        maven "M3"
    }
    triggers {
        githubPush()
        // Scan for SCM changes
        pollSCM('H 3 * * *')
        // Start a pipeline at some time
        cron('H H(4,6) * * *')
    }
    stages {
        stage('Build') {
            steps {
                sh "mvn -Dmaven.test.failure.ignore=true -Dmaven.color=false clean package"
            }
            post {
                success {
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
    }
}
