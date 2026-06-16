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

            // ✅ JUnit Report (current build)
            junit 'target/surefire-reports/*.xml'

            // ✅ HTML Extent Report (current build only)
            publishHTML(target: [
                allowMissing: false,
                alwaysLinkToLastBuild: false,
                keepAll: false,
                reportDir: 'ExtentReport',
                reportFiles: 'index.html',
                reportName: 'ICaffe Project Report'
            ])

            // ✅ Test Result Fetch
            script {
                def testResult = currentBuild.rawBuild.getAction(hudson.tasks.junit.TestResultAction.class)

                def totalTests = testResult?.totalCount ?: 0
                def failedTests = testResult?.failCount ?: 0
                def skippedTests = testResult?.skipCount ?: 0
                def passedTests = totalTests - failedTests - skippedTests

                // ✅ Email
                emailext(
                    to: 'akash.varun@hanssupport.com',

                    subject: "iCaffe Automation Execution Report | ${currentBuild.currentResult} | Build #${env.BUILD_NUMBER}",

                    mimeType: 'text/html',

                    body: """
                    <html>
                    <body style="font-family: Arial, Helvetica, sans-serif;">

                    <div style="width: 700px; border:1px solid #ddd; padding:20px;">

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
                                <td><b>Build URL</b></td>
                                <td>
                                    <a href="${env.BUILD_URL}">
                                        Open Jenkins Build
                                    </a>
                                </td>
                            </tr>

                            <tr>
                                <td><b>Status</b></td>
                                <td>
                                    <span style="
                                        padding:5px 10px;
                                        color:white;
                                        background-color:${currentBuild.currentResult == 'SUCCESS' ? '#28a745' : '#dc3545'};
                                        border-radius:4px;">
                                        ${currentBuild.currentResult}
                                    </span>
                                </td>
                            </tr>

                            <tr>
                                <td><b>Test Summary</b></td>
                                <td>
                                    Total: ${totalTests} |
                                    Passed: ${passedTests} |
                                    Failed: ${failedTests} |
                                    <span style="
                                        padding:3px 8px;
                                        color:black;
                                        background-color:#ffc107;
                                        border-radius:4px;">
                                        Skipped: ${skippedTests}
                                    </span>
                                </td>
                            </tr>

                        </table>

                        <br>

                        <h3>Reports</h3>

                        <table border="1"
                               cellpadding="10"
                               cellspacing="0"
                               style="border-collapse:collapse;">

                            <tr style="background-color:#f2f2f2;">
                                <th>Report Name</th>
                                <th>Link</th>
                            </tr>

                            <tr>
                                <td>JUnit Test Report</td>
                                <td>
                                    <a href="${env.BUILD_URL}testReport">
                                        View Report
                                    </a>
                                </td>
                            </tr>

                            <tr>
                                <td>Extent Report</td>
                                <td>
                                    <a href="${env.BUILD_URL}ICaffe_20Project_20Report">
                                        View Report
                                    </a>
                                </td>
                            </tr>

                        </table>

                        <br>

                        <p>
                            Regards,<br>
                            Jenkins Automation Server
                        </p>

                    </div>

                    </body>
                    </html>
                    """
                )
            }
        }

        cleanup {
            cleanWs(deleteDirs: true, disableDeferredWipeout: true)
        }
    }
}