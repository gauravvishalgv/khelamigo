pipeline {
    agent any

    tools{
        jdk 'jdk17'
        maven 'maven'
    }
    
    environment {
        
        PROJECT_DIR = 'user-service' 
    }

    stages {
        stage('Code Checkout') {
            steps {
                git branch: 'main', changelog: false, poll: false, url: 'https://github.com/gauravvishalgv/khelamigo/'
            }
        }
        
        stage('OWASP Dependency Check'){
            steps{
                dependencyCheck additionalArguments: '--scan ./user-service/ --format XML --format HTML', odcInstallation: 'db-check'
                dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
            }
        }

        stage('Sonarqube Analysis') {
            steps {
                dir("${env.PROJECT_DIR}"){
                    sh ''' mvn sonar:sonar \
                    -Dsonar.host.url=http://52.64.182.209:10001/ \
                    -Dsonar.login=sqa_f5a39cda4f77a4f415bf9b5187e48e3384a2eadb '''
                }
            }
        }

        stage('Clean & Package') {
            steps {
                // Change directory to project dir
                dir("${env.PROJECT_DIR}") {
                    sh "mvn clean package -DskipTests"
                }
            }
        }

        
      stage('Docker Build & Push') {
            steps {
                dir("${env.PROJECT_DIR}") {
                    script {
                        withDockerRegistry(url: 'http://52.64.182.209:9090', credentialsId: 'DockerHub-Token', toolName: 'docker') {
                            
                            sh "docker build -t 52.64.182.209:9090/${env.PROJECT_DIR}:${BUILD_NUMBER} ."
                            def buildTag = "${env.PROJECT_DIR}:${BUILD_NUMBER}"

                            sh "docker push 52.64.182.209:9090/${env.PROJECT_DIR}:${BUILD_NUMBER}"
                            env.BUILD_TAG = buildTag
                        }
                    }
                }
            }
        }
        
        stage('Vulnerability scanning'){
            steps{
                sh " trivy image 52.64.182.209:9090/${env.PROJECT_DIR}:${BUILD_NUMBER}"
            }
        }

        // stage("Staging"){
        //     steps{
        //         sh 'docker-compose up -d'
        //     }
        // }
    }
}