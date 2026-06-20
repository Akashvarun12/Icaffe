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

            // JUnit Report
            junit 'target/surefire-reports/*.xml'

            // Small wait to ensure reports are generated
            script {
                sleep(time: 2, unit: 'SECONDS')
            }

            // Publish HTML report
            publishHTML(target: [
                allowMissing: false,
                alwaysLinkToLastBuild: true,
                keepAll: false,
                reportDir: 'ExtentReport',
                reportFiles: 'index.html',
                reportName: "ICaffe_Project_Report"
            ])

            // Email Notification (Dashboard Style)
            emailext(
                to: 'akash.varun@hanssupport.com',
                subject: "iCaffe Automation Report | ${currentBuild.currentResult} | Build #${env.BUILD_NUMBER}",
                mimeType: 'text/html',
                body: """
<html>
<body style="font-family:Arial;background:#f5f7fa;padding:20px;">

<div style="max-width:800px;margin:auto;background:white;border-radius:12px;overflow:hidden;box-shadow:0 3px 10px rgba(0,0,0,0.1);">

<!-- HEADER -->
<div style="background:linear-gradient(90deg,#2E86C1,#1B4F72);color:white;text-align:center;padding:18px;">
    <h2 style="margin:0;">🚀 iCaffe Automation Dashboard</h2>
</div>

<!-- BODY -->
<div style="padding:20px;">

<table style="width:100%;border-collapse:collapse;font-size:14px;">

<tr>
<td><b>Project</b></td>
<td>iCaffe</td>
</tr>

<tr>
<td><b>Build No</b></td>
<td>#${env.BUILD_NUMBER}</td>
</tr>

<tr>
<td><b>Status</b></td>
<td>
<span style="
    padding:6px 14px;
    border-radius:6px;
    color:white;
    background:${currentBuild.currentResult == 'SUCCESS' ? '#28a745' : '#e74c3c'};
">
${currentBuild.currentResult ?: 'SUCCESS'}
</span>
</td>
</tr>

</table>

<br>

<h3>📊 Reports Dashboard</h3>

<div style="display:flex;gap:12px;flex-wrap:wrap;">

<a href="${env.BUILD_URL}testReport/"
   style="background:#17a2b8;color:white;padding:10px 14px;border-radius:6px;text-decoration:none;">
   📄 JUnit Report
</a>

<a href="${env.BUILD_URL}ExtentReport/index.html"
   style="background:#28a745;color:white;padding:10px 14px;border-radius:6px;text-decoration:none;">
   📈 Extent Report
</a>

</div>

<br>

<div style="text-align:center;color:#888;font-size:12px;margin-top:20px;">
Regards,<br>
Jenkins CI Server
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