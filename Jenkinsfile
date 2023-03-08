pipeline {
    agent any
    options {
        buildDiscarder logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '', numToKeepStr: '3')
        ansiColor('xterm')
    }
    tools {
        maven "M3"
    }
    triggers {
        githubPush()
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
