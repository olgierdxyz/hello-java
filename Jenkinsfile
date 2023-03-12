pipeline {
    agent any
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
        stage('Build') {
            steps {
                step('Step build') {
                    sh 'pwd'
                }

            }
            post {
                success {
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
    }
}
