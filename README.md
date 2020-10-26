# java-backend-test
 Robot Sea Clean Task Grid Based Cleaner 


Spring Boot Project that tackles the task below:
"Your task is to write a Java based web service that navigates an imaginary robotic cleaner through an oil spill in the sea."

Installation:

Running the Code with Maven in Exploded Form:
To ensure that the build target is removed before a new build, add the clean target.
In the terminal or cmd run the follow lines
"mvn clean install"
Once built run the application. 
Enter the following
"mvn spring-boot:run"

OR

To run the Code as a Stand-Alone Packaged Application
mvn clean package spring-boot:repackage
java -jar .\target\java-backend-test-0.0.1-SNAPSHOT.jar

*Be sure to have nothing running on port 8080


Using the project:
I personally used Postman to hit the server but to hit the endpoint use a POST request to "localhost:8080/oil-spill"

Example JSON Request Body
{
  "areaSize" : [5, 5],
  "startingPosition" : [0, 0],
  "oilPatches" : [[0,0], [1, 4],[2, 2],[2, 3]],
  "navigationInstructions" : "NNNN"
}

Known issues:
- Exceptions not handled gracefully (Custom exceptions and implement an exception handler)
- Not 100% Lines Covered in tests
