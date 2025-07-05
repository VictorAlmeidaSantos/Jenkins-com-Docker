pipeline {
    agent any // O agente principal continua sendo o do Windows

    stages {
        stage('Build') {
            agent {
                docker {
                    image 'openjdk:17'
                    // ADICIONADO: Define o diretório de trabalho dentro do contêiner Docker como '/app'.
                    // Isso resolve o erro de "invalid working directory" ao garantir que o Docker
                    // use um caminho absoluto e consistente dentro do próprio contêiner.
                    // O Jenkins automaticamente mapeará o workspace do host para este caminho.
                    args '-w /app'
                }
            }
            steps {
                // Estes comandos 'sh' estão corretos, pois rodam DENTRO do contêiner Linux.
                // Eles serão executados no diretório /app dentro do contêiner.
                sh 'mkdir -p out'
                sh 'javac -d out src/*.java'
            }
        }

        stage('Test') {
            agent {
                docker {
                    image 'openjdk:17'
                    // ADICIONADO: Mesma correção para a stage de Teste.
                    // É importante que ambas as stages que usam Docker tenham esta configuração
                    // para garantir consistência e evitar o mesmo erro.
                    args '-w /app'
                }
            }
            steps {
                // Estes comandos também serão executados no diretório /app dentro do contêiner.
                sh 'java -cp out org.junit.runner.JUnitCore ConversorTest'
            }
        }
    }
}
