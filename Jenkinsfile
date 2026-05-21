pipeline {

    agent any

    triggers {

        cron('0 15 * * *')
    }

    stages {

        stage('Checkout') {

            steps {

                git branch: 'Akash-varun',
                url: 'https://github.com/Akashvarun12/project_iCaffe.git'
            }
        }

        stage('Build & Test') {

            steps {

                bat 'mvn clean install'
            }
        }
    }

    post {

        always {

            publishHTML(target: [
                allowMissing: false,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'ICaffeResult',
                reportFiles: '*.html',
                reportName: 'Extent Report'
            ])
        }
    }
}