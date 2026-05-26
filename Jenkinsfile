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

                bat 'mvn clean install'
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

            emailext(
                to: 'akash.varun@hanssupport.com',

                subject: "iCaffe Automation Result : ${currentBuild.currentResult}",

                mimeType: 'text/html',

                body: """
                    <h2>Automation Execution Summary</h2>

                    <p><b>Project:</b> iCaffe</p>

                    <p><b>Status:</b> ${currentBuild.currentResult}</p>

                    <p><b>Build Number:</b> ${env.BUILD_NUMBER}</p>

                    <p><b>Total Tests:</b>
                    ${currentBuild.rawBuild.getAction(hudson.tasks.junit.TestResultAction.class).totalCount}</p>

                    <p><b>Failed Tests:</b>
                    ${currentBuild.rawBuild.getAction(hudson.tasks.junit.TestResultAction.class).failCount}</p>

                    <p>
                    <a href="${env.BUILD_URL}">
                    Open Jenkins Build
                    </a>
                    </p>

                    <p>
                    <a href="${env.BUILD_URL}ICaffe_20Project_20Report">
                    Open Extent Report
                    </a>
                    </p>
                """
            )
        }

        cleanup {
            cleanWs(deleteDirs: true, disableDeferredWipeout: true)
        }
    }
}