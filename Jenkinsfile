@Library('spring') _

pipeline{
    agent any
    stages {
        stage('build') {
            steps{
              script {
                  pwd
                  build.build("mavenimage")
                }
            }
        }
         stage('run') {
            steps{
                 script {
                  pwd
                  build.run("mavenimage")
                }
              }
        }
        stage('Upload War To Nexus'){
            steps{
                script{

                    nexusArtifactUploader artifacts: [
                        [
                            artifactId: 'spring-boot-complete', 
                            classifier: '', 
                            file: "app.jar", 
                            type: 'war'
                        ]
                    ], 
                    credentialsId: 'nexus', 
                    groupId: 'com.example', 
                    nexusUrl: 'localhost:8081', 
                    nexusVersion: 'nexus3', 
                    protocol: 'http', 
                    repository: 'maven-snapshots', 
                    version: "0.0.1-SNAPSHOT"
                    }
            }
        }
        
    }
}
