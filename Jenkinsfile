pipeline {
    agent any
    tools {
        maven 'M3'
        jdk 'jdk8'
    }
    stages {
        stage("Build") {
            steps {
                sh 'mvn clean package'
            }
        }
    }
}
