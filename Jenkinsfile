pipeline {
    agent any

    environment {
        // Java installé dans la VM
        JAVA_HOME = '/usr/lib/jvm/java-17-openjdk-arm64'
        PATH = "${JAVA_HOME}/bin:${MAVEN_HOME}/bin:${env.PATH}"
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
                sh 'echo "MAVEN_HOME: $MAVEN_HOME"'
                sh 'java -version'
                sh 'mvn -version'
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('SonarQube') {
            steps {
                sh 'mvn sonar:sonar'
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
