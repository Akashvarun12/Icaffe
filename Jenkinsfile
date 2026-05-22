pipeline {

    agent any

    triggers {

        cron('0 17 * * *')
    }

    stages {

        stage('Checkout') {

            steps {

                git branch: 'Akash-varun',
                url: 'https://github.com/Akashvarun12/project_iCaffe.git'
            }
        }
        
stage('Clean Old Reports One Time') {
    steps {
        bat 'if exist ExtentReport rmdir /s /q ExtentReport'
    }
}

        stage('Build & Test') {

            steps {

                bat 'mvn clean install || exit /b 0'
            }
        }
    }

    post {

        always {
			
			junit 'target/surefire-reports/*.xml'

            publishHTML(target: [
                allowMissing: true,
                alwaysLinkToLastBuild: true,
                keepAll: false,
                reportDir: 'ExtentReport',
                reportFiles: '*.html',
                reportName: 'ICaffe Project Report'
            ])
        }
    }
}