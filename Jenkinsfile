pipeline {
    agent any

    stages {
        stage('Build') {
            agent {
                docker {
                    image 'openjdk:17'
                }
            }
            steps {
                sh 'mkdir -p out'
                sh 'javac -d out src/*.java'
            }
        }

        stage('Test') {
            agent {
                docker {
                    image 'openjdk:17'
                }
            }
            steps {
                sh 'java -cp out org.junit.runner.JUnitCore ConversorTest'
            }
        }
    }
}
