pipeline {

    agent any

    stages {

        stage('Build') {
            steps {
                sh '/usr/local/bin/mvn clean'
            }
        }

        stage('Test') {
            steps {
                sh '/usr/local/bin/mvn test'
            }
        }
    }
}