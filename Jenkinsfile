jenkins file
pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Parallel Testing') {
            parallel {
                stage('Desktop UI Tests') {
                    steps {
                        sh 'mvn test -Dtest=HomePageTest -Dbrowser.type=desktop'
                    }
                }
                stage('Mobile UI Tests') {
                    steps {
                        sh 'mvn test -Dtest=HomePageTest -Dbrowser.type=mobile'
                    }
                }
            }
        }
    }
}