pipeline {
   agent { label 'slave_build_spring' }

   environment {
        JAVA_HOME = '/usr/lib/jvm/java-17-openjdk-arm64/bin/java'
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
