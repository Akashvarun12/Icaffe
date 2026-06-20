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

        stage('Checkout') {
            steps {
                git branch: 'Akash-varun',
                url: 'https://github.com/Akashvarun12/project_iCaffe.git'
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn clean test'

                // 🔥 IMPORTANT: check report generated or not
                bat 'dir ExtentReport'
            }
        }
    }

    post {

        always {

            // ✅ JUnit Report
            junit 'target/surefire-reports/*.xml'

            // 🔥 FIX: wait ensures report is ready before publish
            script {
                sleep(time: 3, unit: 'SECONDS')
            }

            // ✅ HTML Extent Report (CURRENT BUILD ONLY)
            publishHTML(target: [
                allowMissing: false,
                alwaysLinkToLastBuild: true,
                keepAll: false,
                reportDir: 'ExtentReport',
                reportFiles: 'index.html',
                reportName: "ICaffe Project Report #${env.BUILD_NUMBER}"
            ])

            // ✅ Email
            emailext(
                to: 'akash.varun@hanssupport.com',
                subject: "iCaffe Automation Execution Report | ${currentBuild.currentResult} | Build #${env.BUILD_NUMBER}",
                mimeType: 'text/html',
                body: """
                <html>
                <body style="font-family: Arial, Helvetica, sans-serif;">

                <div style="width:700px;border:1px solid #ddd;padding:20px;">

                    <h2 style="color:#2E86C1;">
                        iCaffe Automation Test Execution Report
                    </h2>

                    <hr>

                    <table style="border-collapse:collapse;" cellpadding="8">

                        <tr>
                            <td><b>Project</b></td>
                            <td>iCaffe</td>
                        </tr>

                        <tr>
                            <td><b>Build Number</b></td>
                            <td>${env.BUILD_NUMBER}</td>
                        </tr>

                        <tr>
                            <td><b>Status</b></td>
                            <td>${currentBuild.currentResult}</td>
                        </tr>

                        <tr>
                            <td><b>Build URL</b></td>
                            <td>
                                <a href="${env.BUILD_URL}">
                                    Open Jenkins Build
                                </a>
                            </td>
                        </tr>

                    </table>

                    <br>

                    <h3>Reports</h3>

                    <ul>
                        <li>
                            <a href="${env.BUILD_URL}testReport">
                                JUnit Report
                            </a>
                        </li>

                        <li>
                            <a href="${env.BUILD_URL}ICaffe_20Project_20Report">
                                Extent Report
                            </a>
                        </li>
                    </ul>

                    <br>

                    <p>Regards,<br>Jenkins Automation Server</p>

                </div>

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