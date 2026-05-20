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
}