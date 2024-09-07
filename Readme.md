To run the code on Jenkins - 

Run the jenkins.war file by using command - 
java -jar jenkins.war
Start the jenkins portal at - http://localhost:8080/
Create a pipeline project in jenkins. 
Provide the git url along with the amazon website credentials that needs to be used.
The pipeline will read the Jenkinsfile and run the project accordingly.
Currently, code is reading the password using the Jenkins Credentials Manager. Once it reads the credentials, it rewrites them back to the config file in the repository and then the project is run according to the credentials value.
