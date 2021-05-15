# Tree Survey_SpringBoot_API
This API is developed using Spring boot .


# Software versions required :
Maven 3.2.5+
JDK 1.8+
Spring Boot
Mockito

# To run this example:
First compile run unit tests package install  :
mvn clean install

To start rest service:
mvn spring-boot:run


This will start embedded tomcat on port : 9090
The API endpoint can then be accessed at : http://localhost:9090/api/v1/surveys

If this port is already in use please change the port in application.properties 




# H2 in memory details
To access h2 in memory db :
http://localhost:9090/h2-console

Make sure that following are the values entered :
Driver class = org.h2.Driver
JDBC URL     = jdbc:h2:mem:survey
user name    = sa
password     = no password is required 

# Notes on API Key
Please substitute your own api key in properties file.

