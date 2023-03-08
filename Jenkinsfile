pipeline {
    agent any
    options {
        retry(0)
        timeout(time: 1, unit: 'MINUTES')
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
        // Scan for SCM changes
        pollSCM('H 3-5 * * *')
        // Start a pipeline at some time
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
