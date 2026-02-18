pipeline {
   agent { label 'slave_build_spring' }

   environment {
        // CORRECTED: JAVA_HOME should point to the directory, not the executable
        JAVA_HOME = '/usr/lib/jvm/java-17-openjdk-arm64'
        PATH = "${JAVA_HOME}/bin:${env.PATH}"
    }
    tools {
        maven 'M2_HOME'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'java -version'
                sh 'echo "JAVA_HOME is: $JAVA_HOME"'
                sh 'mvn -version'
                sh 'mvn clean package -DskipTests'
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
