
def mavenInstallation = 'Maven'

timestamps {
    node () {
        stage ('Checkout') {
          checkout([$class: 'GitSCM', branches: [[name: '**']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '', url: 'https://github.com/TalaatHarb/project-euler-100']]]) 
        } // stage ('Checkout')

        stage('java-test'){
            withMaven(maven : mavenInstallation) {
                // Run the maven build
                sh """
                mvn clean test verify
                """
                step( [ $class: 'JacocoPublisher' ] )
            } // withMaven
        } // stage('java-test')
    } // node
} // timestamps
