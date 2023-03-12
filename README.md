# Jawwy Test Automation Framework

#### This is a Java-based test automation framework for testing the Jawwy website. It uses Selenium WebDriver to interact with the website, and TestNG to organize and run test cases.

### Pre-requisites

- Java JDK 11 or higher
- Maven
- Edge browser

### Installation

- Clone this repository to your local machine.
- Open a terminal window and navigate to the root directory of the project.
- Run the following command to install the required dependencies:
- Copy code
- mvn install
- No need Download and install the Edge browser on your machine.

### Usage

To run the test cases, execute the following command in the project root directory:

bash

- mvn clean test

#### The test results will be displayed in the terminal window, and a detailed HTML report will be generated in the target/surefire-reports directory.

### Framework Structure

- BaseTest: This class sets up the WebDriver and initializes the page objects for the test cases to use.
- Actions: This class contains helper methods for interacting with the WebDriver.
- EyesWrapper: This class contains the configuration for the Applitools Eyes visual testing tool.
- MainHeader: This class represents the header section of the website.
- CountryModal: This class represents the country selection modal.
- SubscriptionPage: This class represents the subscription page of the website.
  