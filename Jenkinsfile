pipeline {

    agent any

    options {
        buildDiscarder(logRotator(numToKeepStr: '1'))
    }

    stages {

        stage('Clean Workspace') {
            steps {
                cleanWs(deleteDirs: true, disableDeferredWipeout: true)
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

            // ✅ JUnit Report (NO manual parsing needed)
            junit 'target/surefire-reports/*.xml'

            // ✅ HTML Extent Report
            publishHTML(target: [
                allowMissing: false,
                alwaysLinkToLastBuild: true,
                keepAll: false,
                reportDir: 'ExtentReport',
                reportFiles: '*.html',
                reportName: 'ICaffe Project Report'
            ])

            // ✅ Email (Simple + Stable)
            emailext(
                to: 'akash.varun@hanssupport.com',
                subject: "iCaffe Automation Result : ${currentBuild.currentResult}",
                mimeType: 'text/html',

                body: """
                <html>
                <body>

                <h2>Automation Execution Summary</h2>

                <p><b>Project:</b> iCaffe</p>
                <p><b>Status:</b> ${currentBuild.currentResult}</p>
                <p><b>Build Number:</b> ${env.BUILD_NUMBER}</p>

                <br>

                <h3>Reports</h3>

                <p>
                    <a href="${env.BUILD_URL}testReport">JUnit Test Report</a>
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