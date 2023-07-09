pipeline {
    agent any
	// agent { docker { image 'maven:3.6.3' }} // build using docker image, this build will happen within container
    
    environment {
        dockerHome = tool 'myDocker'
        mavenHome = tool 'myMaven'
        PATH = "$dockerHome/bin:$mavenHome/bin:$PATH"
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building'
                sh 'mvn --version'
                sh 'docker version'
                echo "PATH - $PATH"
                echo "BUILD_NUMBER - $env.BUILD_NUMBER"
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
            echo 'I run always'
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