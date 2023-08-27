# My Test Project with Rest Assured

This project showcases API testing using the Rest Assured framework, along with TestNG for test execution and Extent Reports for reporting.

## Prerequisites

Before you can run and work on this project, you need to have the following tools and libraries installed on your machine:

Java Development Kit (JDK): Ensure you have JDK 8 or later installed on your machine. You can download it from the official Oracle JDK website or use an OpenJDK distribution.

Java IDE: Choose a Java Integrated Development Environment (IDE) such as Eclipse or IntelliJ IDEA. Make sure your IDE is properly set up and configured.

Maven: Maven is used for project dependency management and build automation. You can download it from the official Maven website and follow the installation instructions.

Git (Optional): While not strictly required, having Git installed on your machine can make it easier to clone the project repository and manage code changes.

## Dependencies

- [TestNG](https://testng.org/)
- [Rest Assured](https://rest-assured.io/)
- [Jackson Databind](https://github.com/FasterXML/jackson-databind)
- [SLF4J API](https://www.slf4j.org/)
- [Extent Reports](http://extentreports.com/)
- [JavaFaker](https://github.com/DiUS/java-faker)

## Features

- **GET Request Test:** Demonstrates sending a GET request and validating response data types.

- **POST Request Test:** Illustrates sending a POST request and verifying the response against the inputted payload.

## How to Run

1. Clone the repository to your local machine.
2. Open the project in your preferred Java IDE.
3. Configure project dependencies as listed in the POM.xml file.
4. Navigate to the test class, for example, `ApiTests.java`.
5. Run the tests by right-clicking on the class and selecting "Run" or "Run TestNG Test."

Alternatively, you can run all tests using Maven in the command line:
```bash
mvn test -DsuiteXmlFile=testng.xml

# Reporting

The project utilizes Extent Reports for generating detailed HTML test reports. After running the tests, you can find the report in the `test-output` directory.
