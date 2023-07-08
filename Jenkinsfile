pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building'
            }
        }
        stage('Test') {
            steps {
                echo 'Test'
            }
        }
        stage('Integration Test') {
            steps {
                echo 'Integration Test'
            }
        }
    }

    post {
        always {
            echo 'I am awesome. I run always'
        }
        success {
            echo 'I run when you are successful'
        }
        failure {
            echo 'I run when you fail'
        }
        // There is another several other statuses like unstable or changed. 
        // Read more status here : https://www.jenkins.io/doc/book/pipeline/syntax/#post 
    }
}