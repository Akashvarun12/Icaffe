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

            junit 'target/surefire-reports/*.xml'

            publishHTML(target: [
                allowMissing: false,
                alwaysLinkToLastBuild: true,
                keepAll: false,
                reportDir: 'ExtentReport',
                reportFiles: '*.html',
                reportName: 'ICaffe Project Report'
            ])

            script {

                def totalTests = 0
                def totalFailures = 0
                def totalSkipped = 0
                def failedTestsHtml = ""

                def reports = findFiles(glob: 'target/surefire-reports/*.xml')

                reports.each { report ->

                    def xml = new XmlSlurper().parseText(readFile(report.path))

                    totalTests += xml.@tests.toInteger()
                    totalFailures += xml.@failures.toInteger()
                    totalSkipped += xml.@skipped.toInteger()

                    xml.testcase.each { tc ->

                        if (tc.failure.size() > 0 || tc.error.size() > 0) {

                            failedTestsHtml += """
                            <tr>
                                <td>${tc.@classname}</td>
                                <td>${tc.@name}</td>
                            </tr>
                            """
                        }
                    }
                }

                def totalPassed = totalTests - totalFailures - totalSkipped

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

                    <table border="1" cellpadding="5" cellspacing="0">
                        <tr style="background-color:#f2f2f2">
                            <th>Total</th>
                            <th>Passed</th>
                            <th>Failed</th>
                            <th>Skipped</th>
                        </tr>
                        <tr>
                            <td>${totalTests}</td>
                            <td style="color:green"><b>${totalPassed}</b></td>
                            <td style="color:red"><b>${totalFailures}</b></td>
                            <td>${totalSkipped}</td>
                        </tr>
                    </table>

                    <br>

                    <h3>Failed Test Cases</h3>

                    <table border="1" cellpadding="5" cellspacing="0">
                        <tr style="background-color:#f2f2f2">
                            <th>Class Name</th>
                            <th>Test Case</th>
                        </tr>

                        ${failedTestsHtml ?: '<tr><td colspan="2">No Failed Tests</td></tr>'}

                    </table>

                    <br><br>

                    <p>
                        <a href="${env.BUILD_URL}">
                        Open Jenkins Build
                        </a>
                    </p>

                    <p>
                        <a href="${env.BUILD_URL}testReport">
                        Open Test Report
                        </a>
                    </p>

                    <p>
                        <a href="${env.BUILD_URL}ICaffe_20Project_20Report">
                        Open Extent Report
                        </a>
                    </p>

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