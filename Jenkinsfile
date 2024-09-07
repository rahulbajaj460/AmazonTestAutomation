pipeline {
    agent any

    //environment {
        // Retrieve credentials from Jenkins (replace with your actual credentials ID)
    //    WEBSITE_CREDENTIALS = credentials('amazon_credentials')
    //}

    stages {
       
       
       // stage('Checkout Code') {
       //     steps {
                // Pull the latest code from your Git repository
       //         git url: 'https://github.com/rahulbajaj460/AmazonTestAutomation.git'
       //     }
       // }

        stage('Update Config Properties') {
            steps {
                // Update config.properties with the credentials from Jenkins
                sh "echo 'Here'"
                sh '''
                echo "Updating config.properties with Jenkins credentials"

                # Replace the existing username and password in the config.properties file
                sed -i 's/mobile=.*/mobile='${WEBSITE_CREDENTIALS_USR}'/' src/test/resources/config.properties
                sed -i 's/password=.*/password='${WEBSITE_CREDENTIALS_PSW}'/' src/test/resources/config.properties
                '''
            }
        }

        stage('Run Tests') {
            steps {
                // Run the tests after updating the config file
                sh 'mvn clean test'
            }
        }
    }

    post {
        always {
            // Optionally, collect test reports and artifacts
            junit '**/target/surefire-reports/*.xml'
            archiveArtifacts artifacts: '**/target/*.jar', allowEmptyArchive: true
        }
    }
}