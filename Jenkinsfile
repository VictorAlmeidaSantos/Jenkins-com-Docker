pipeline {
    agent any // O agente principal continua sendo o do Windows

    stages {
        stage('Build') {
            agent {
                docker {
                    image 'openjdk:17'
                    // ADICIONE ESTA LINHA PARA CORRIGIR O ERRO DE CAMINHO
                    args '-w /app'
                }
            }
            steps {
                // Estes comandos 'sh' estão corretos, pois rodam DENTRO do contêiner Linux.
                sh 'mkdir -p out'
                sh 'javac -d out src/*.java'
            }
        }

        stage('Test') {
            agent {
                docker {
                    image 'openjdk:17'
                    // ADICIONE A MESMA LINHA AQUI
                    args '-w /app'
                }
            }
            steps {
                sh 'java -cp out org.junit.runner.JUnitCore ConversorTest'
            }
        }
    }
}