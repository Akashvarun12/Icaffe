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
            allowMissing: true,
            alwaysLinkToLastBuild: true,
            keepAll: true,
            reportDir: 'ExtentReport',
            reportFiles: '*.html',
            reportName: 'ICaffe Project Report'
        ])

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
                        <td><b>Build Status</b></td>
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
                            JUnit Test Report
                        </a>
                    </li>

                    <li>
                        <a href="${env.BUILD_URL}ICaffe_20Project_20Report">
                            Extent Report
                        </a>
                    </li>
                </ul>

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

    cleanup {
        cleanWs(deleteDirs: true, disableDeferredWipeout: true)
    }
}


}
