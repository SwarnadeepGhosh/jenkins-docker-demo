pipeline {
    agent any
	// agent { docker { image 'maven:3.6.3' }} // build using docker image, this build will happen within container
    
    environment {
        dockerHome = tool 'myDocker'
        mavenHome = tool 'myMaven'
        PATH = "$dockerHome/bin:$mavenHome/bin:$PATH"
    }

    stages {
        stage('Checkout') {
            steps {
                sh 'mvn --version'
                sh 'docker version'
                echo "PATH - $PATH"
                echo "BUILD_NUMBER - $env.BUILD_NUMBER"
                echo "BUILD_ID - $env.BUILD_ID"
                echo "BUILD_TAG - $env.BUILD_TAG"
                echo "BUILD_URL - $env.BUILD_URL"
                echo "JOB_NAME - $env.JOB_NAME"

            }
        }
        stage('Compile') {
            steps {
                sh 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Package') {
            steps {
                sh 'mvn package -DskipTests'
            }
        }
        stage('Build docker image') {
            steps {
                sh 'docker build -t swarnadeepghosh/docker-demo-java:$env.BUILD_TAG'
                script {
                    dockerImage = docker.build("swarnadeepghosh/docker-demo-java:{$env.BUILD_TAG}")
                }
            }
        }
        stage('Push docker image') {
            steps {
                script {
                    docker.withRegistry('', 'dockerhub_creds'){
                        dockerImage.push('latest');
                    }
                }
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