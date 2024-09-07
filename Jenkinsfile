pipeline {
    agent any

    environment {
        // Retrieve credentials from Jenkins (replace with your actual credentials ID)
        WEBSITE_CREDENTIALS = credentials('amazon_credentials')
    }

    stages {
        stage('Update Config Properties') {
            steps {
                echo "Username: ${WEBSITE_CREDENTIALS_USR}"
                echo "Password: ${WEBSITE_CREDENTIALS_PSW}"

                // Update config.properties with Jenkins credentials for Windows
                bat '''
                echo Updating config.properties with Jenkins credentials

                # Use PowerShell or find another command to replace sed (Windows doesn't have sed by default)
                powershell -Command "(Get-Content src/test/resources/config.properties) -replace 'mobile=.*', 'mobile=${WEBSITE_CREDENTIALS_USR}' | Set-Content src/test/resources/config.properties"
                powershell -Command "(Get-Content src/test/resources/config.properties) -replace 'password=.*', 'password=${WEBSITE_CREDENTIALS_PSW}' | Set-Content src/test/resources/config.properties"
                '''
            }
        }

        stage('Run Tests') {
            steps {
                // Run the tests after updating the config file on Windows
                bat 'mvn clean test'
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
