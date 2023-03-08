pipeline {
    agent any
    options {
        timeout(time: 1, unit: 'MINUTES')
        quietPeriod(0)
        retry(0)
        disableConcurrentBuilds abortPrevious: true
        buildDiscarder logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '', numToKeepStr: '10')
        timestamps()
        ansiColor('xterm')
    }
    tools {
        maven "M3"
    }
    triggers {
        githubPush()
        pollSCM('H H(3-5) * * *')
        cron('H H(5-6) * * *')
    }
    stages {
        stage('Build') {
            steps {
                sh "mvn -Dmaven.test.failure.ignore=true clean compile package"
            }
            post {
                success {
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
    }
}
