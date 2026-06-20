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

        stage('Delete Old Reports (Hard Clean)') {
            steps {
                bat '''
                echo Cleaning old reports...

                if exist ExtentReport rmdir /s /q ExtentReport
                if exist test-output rmdir /s /q test-output
                if exist target rmdir /s /q target

                mkdir ExtentReport
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

            // ✅ JUnit Report
            junit 'target/surefire-reports/*.xml'

            // ✅ HTML Report (ONLY CURRENT BUILD FIX)
            publishHTML(target: [
                allowMissing: false,
                alwaysLinkToLastBuild: true,
                keepAll: false,
                reportDir: 'ExtentReport',
                reportFiles: 'index.html',
                reportName: "ICaffe Report - Build ${env.BUILD_NUMBER}"
            ])

            // ✅ Email Report (Simple + Stable)
            emailext(
                to: 'akash.varun@hanssupport.com',
                subject: "iCaffe Automation Report | ${currentBuild.currentResult} | Build #${env.BUILD_NUMBER}",
                mimeType: 'text/html',
                body: """
                <html>
                <body style="font-family: Arial;">

                    <h2>iCaffe Test Execution Report</h2>

                    <p><b>Build Number:</b> ${env.BUILD_NUMBER}</p>
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