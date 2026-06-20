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
                bat 'dir ExtentReport'
            }
        }
    }

    post {

        always {

            junit 'target/surefire-reports/*.xml'

            script {
                sleep(time: 2, unit: 'SECONDS')
            }

            publishHTML(target: [
                allowMissing: false,
                alwaysLinkToLastBuild: true,
                keepAll: false,
                reportDir: 'ExtentReport',
                reportFiles: '*.html',
                reportName: "ICaffe_Project_Report"
            ])

            emailext(
                to: 'akash.varun@hanssupport.com',
                subject: "iCaffe Automation Report | ${currentBuild.currentResult} | Build #${env.BUILD_NUMBER}",
                mimeType: 'text/html',
                body: """
                <html>
                <body style="font-family: Arial, sans-serif; background-color:#f4f6f7; padding:20px;">

                <div style="max-width:750px;margin:auto;background:white;border-radius:10px;overflow:hidden;box-shadow:0 2px 8px rgba(0,0,0,0.1);">

                    <div style="background:#2E86C1;color:white;padding:15px;text-align:center;">
                        <h2 style="margin:0;">iCaffe Automation Execution Report</h2>
                    </div>

                    <div style="padding:20px;">

                        <table style="width:100%;border-collapse:collapse;font-size:14px;">

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
                                <td>
                                    <span style="
                                        padding:5px 12px;
                                        border-radius:5px;
                                        color:white;
                                        background-color:${currentBuild.currentResult == 'SUCCESS' ? '#28a745' : '#dc3545'};
                                    ">
                                    ${currentBuild.currentResult}
                                    </span>
                                </td>
                            </tr>

                        </table>

                        <br>

                        <h3>📊 Reports</h3>

                        <div style="display:flex;gap:10px;flex-wrap:wrap;">

                            <a href="${env.BUILD_URL}testReport"
                               style="background:#17a2b8;color:white;padding:10px 15px;
                                      text-decoration:none;border-radius:5px;">
                                View JUnit Report
                            </a>

                            <!-- 🔥 FIXED EXTENT LINK -->
                            <a href="${env.BUILD_URL}ICaffe_Project_Report/"
                               style="background:#28a745;color:white;padding:10px 15px;
                                      text-decoration:none;border-radius:5px;">
                                View Extent Report
                            </a>

                        </div>

                        <br><br>

                        <div style="text-align:center;color:#777;font-size:12px;">
                            Regards,<br>
                            Jenkins Automation Server
                        </div>

                    </div>

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