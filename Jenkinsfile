pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('TestNG') {
            steps {
                bat 'mvn test -DsuiteXmlFile=Masters.xml'
            }
        }
    }
}