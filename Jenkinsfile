pipeline {

    agent any

    options {
        buildDiscarder(logRotator(numToKeepStr: '1'))
        disableConcurrentBuilds()
    }

    stages {

        stage('Clean Workspace') {
            steps {
                cleanWs(deleteDirs: true, disableDeferredWipeout: true)
            }
        }

        stage('Hard Delete Old Reports') {
            steps {
                bat '''
                echo Cleaning old reports...

                if exist ExtentReport rmdir /s /q ExtentReport
                if exist test-output rmdir /s /q test-output
                if exist target rmdir /s /q target

                echo Clean completed
                '''
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
                bat 'mvn clean test'
            }
        }
    }

    post {

        always {

            junit 'target/surefire-reports/*.xml'

            // 🔥 IMPORTANT FIX: stop storing old HTML builds
            publishHTML(target: [
                allowMissing: true,
                alwaysLinkToLastBuild: true,
                keepAll: false,
                reportDir: 'ExtentReport',
                reportFiles: 'index.html',
                reportName: 'ICaffe Project Report'
            ])

            emailext(
                to: 'akash.varun@hanssupport.com',
                subject: "iCaffe Automation Report | ${currentBuild.currentResult} | Build #${env.BUILD_NUMBER}",
                mimeType: 'text/html',
                body: """
                <html>
                <body style="font-family: Arial;">

                <h2>iCaffe Test Report</h2>

                <p><b>Build:</b> ${env.BUILD_NUMBER}</p>
                <p><b>Status:</b> ${currentBuild.currentResult}</p>

                <p>
                    <a href="${env.BUILD_URL}">Open Build</a>
                </p>

                <p>
                    <a href="${env.BUILD_URL}testReport">JUnit Report</a>
                </p>

                <p>
                    <a href="${env.BUILD_URL}ICaffe_20Project_20Report">Extent Report</a>
                </p>

                </body>
                </html>
                """
            )
        }

        cleanup {
            cleanWs(deleteDirs: true, disableDeferredWipeout: true)
        }
    }
}