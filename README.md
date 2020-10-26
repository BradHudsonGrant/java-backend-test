# java-backend-test
 Robot Sea Clean Task Grid Based Cleaner 


Spring Boot Project that tackles the task below:
"Your task is to write a Java based web service that navigates an imaginary robotic cleaner through an oil spill in the sea."

Installation:

To ensure that the build target is removed before a new build, add the clean target.
In the terminal or cmd run the follow lines
"mvn clean install"

Once built run the application. 
Enter the following
"mvn spring-boot:run"

*Be sure to have nothing running on port 8080


Using the project:
To hit the endpoint use a post request to "localhost:8080/oil-spill"

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
