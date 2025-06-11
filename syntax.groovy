pipeline {
    agent any 

    stages {
        stage('Clone Repository') {
            steps {
                git branch: 'main', url: 'https://github.com/Rutuja-Dharmale/jenkins-java-maven-cicd-demo.git'
            }
        }

        stage('Build') {
            steps {
                sh 'echo "Building application"'
            }
        }

        stage('Test') {
            steps {
                sh 'echo "Running tests"'
            }
        }

        stage('Deploy') {
            steps {
                sh 'echo "Deploying application"'
            }
        }

        stage('Docker Build & Push') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                    sh 'docker build -t $DOCKER_USER/httpd:latest .'
                    sh 'echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin'
                    sh 'docker push $DOCKER_USER/httpd:latest'
                }
            }
        }
    }
}
