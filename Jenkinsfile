pipeline {

    agent any

    stages {

        stage('Clean Old Reports') {
            steps {
                bat 'if exist ExtentReport rmdir /s /q ExtentReport'
                bat 'if exist target rmdir /s /q target'
            }
        }

        stage('Checkout') {
            steps {

                git branch: 'Akash-varun',
                url: 'https://github.com/Akashvarun12/project_iCaffe.git'
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
                allowMissing: false,
                alwaysLinkToLastBuild: false,
                keepAll: false,
                reportDir: 'ExtentReport',
                reportFiles: '*.html',
                reportName: 'ICaffe Project Report'
            ])

            withCredentials([usernamePassword(
                credentialsId: 'akash.varun@hanssupport.com',
                usernameVariable: 'admin',
                passwordVariable: 'admin@1234'
            )]) {

                emailext(
                    to: 'akash.varun@hanssupport.com',

                    subject: "iCaffe Automation Result : ${currentBuild.currentResult}",

                    body: """
                        <h2>Automation Execution Summary</h2>

                        <p><b>Project:</b> iCaffe</p>

                        <p><b>Status:</b> ${currentBuild.currentResult}</p>

                        <p><b>Build Number:</b> ${env.BUILD_NUMBER}</p>

                        <p>
                        <a href="${env.BUILD_URL}">
                        Open Jenkins Build
                        </a>
                        </p>
                    """
                )
            }
        }
    }
}