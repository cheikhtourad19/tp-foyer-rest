pipeline {
    agent any

    environment {
        JAVA_HOME = '/usr/lib/jvm/java-21-openjdk-arm64'
        PATH = "${JAVA_HOME}/bin:${env.PATH}"
        SONAR_SERVER = 'SonarServer'  // <-- Must match Jenkins SonarQube server name
    
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'echo "JAVA_HOME: $JAVA_HOME"'
                sh 'java -version'
                sh 'mvn -version'
                sh 'mvn clean package -DskipTests'
            }
        }

       stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv("${SONAR_SERVER}") {
                    sh 'mvn sonar:sonar'
                }
            }
        }
    }

    post {
        success {
            echo '✅ Build Spring Boot réussi'
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
        }
        failure {
            echo '❌ Échec du build Spring Boot'
        }
    }
}
