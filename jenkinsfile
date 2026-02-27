pipeline { 
  agent any
  tools { maven "M3" }
  
  stages {
    stage("Build and Test") {
      steps {
        checkout scm
        sh 'mvn -B -ntp -Dmaven.test.failure.ignore verify'
        junit '**/target/surefire-reports/TEST-*.xml'
      }
    }
  }
}
