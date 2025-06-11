pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/YOUR_USERNAME/jenkins-java-maven-cicd-demo.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                echo 'Tests would run here (add unit tests if any)'
            }
        }

        stage('Package') {
            steps {
                echo 'Packaging complete!'
            }
        }
    }
}
