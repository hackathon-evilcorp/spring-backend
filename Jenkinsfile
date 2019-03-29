pipeline {
 agent any
 environment {
   registry = "foxyfox/evil-backend"
   registryCredential = 'docker-technical-foxyfox'
   dockerImage = ''
 }
 stages {
   stage('Stage 1 - Gradle build') {
     when {
       anyOf {
         branch 'dev'
         branch 'master'
         changeRequest target: 'dev'
         changeRequest target: 'master'
       }
     }
     steps {
       slackSend (
             channel: '#rueppellii-jenkins',
             message: "${currentBuild.fullDisplayName} has started."
             )
       sh 'chmod +x gradlew'
       sh './gradlew bootJar'
     }
   }
   stage('Stage 2 - Gradle test') {
     when {
       anyOf {
         branch 'dev'
         branch 'master'
         changeRequest target: 'dev'
         changeRequest target: 'master'
       }
     }
     steps {
       sh './gradlew test'
     }
   }
   stage('Deploy MASTER docker image') {
     when {
       branch 'master'
     }
     steps {
       script {
         dockerImage = docker.build registry + ":$BUILD_NUMBER"
       }
       script {
         docker.withRegistry( '', registryCredential ) {
            dockerImage.push()
            dockerImage.push('latest')
         }
       }
     }
   }
 }
 post {
   failure {
     slackSend (
       channel: '#rueppellii-jenkins',
       color: 'danger',
       message: "${currentBuild.fullDisplayName} has failed. (<${env.BUILD_URL}|Open>)"
      )
   }
 }
}
