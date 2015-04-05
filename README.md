## Synopsis
Weather Underground Web Application is a small web application. The application take user input zip codes and display the location and temperature at the location. The application utilize Weather Underground API 

## Motivation
The application is created to demonstrate the following designs/techniques
* MVC design
* Input validation
* Unit Test

## Requirements
You'll need the following software to be able to run this web application:
* JDK 8
* Maven 3.2.2
* An IDE (Eclipse/IntelliJ IDEA)

The application is complied, tested and run under the above versions.

## Compilation
Run the following statement in command line under the project directory to compile the application:

    mvn clean

    mvn package

## Tests
The unit tests are run in compilation phase. There are two unit tests:
1. Zip Code format validation.
2. A real location exists with a given zip code. 

## Run
Run the following statement in the command line under the project directory to run the application:

    mvn tomcat7:run

Note that Tomcat 7 is required in order to run the application correctly.