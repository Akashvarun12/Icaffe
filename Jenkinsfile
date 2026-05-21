pipeline {

    agent any

    stages {

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

        publishHTML(target: [
            allowMissing: false,
            alwaysLinkToLastBuild: true,
            keepAll: true,
            reportDir: 'target/ICaffeResult',
            reportFiles: 'index.html',
            reportName: 'Extent Report'
        ])
    }
}
}