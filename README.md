# circles-life-assignment
NOTE: I have separated the assignment in to two repositories so anyone can clone core of the framework and start working.
* `silenium` contains core of the automation framework. 
* `circles-life-assignment` contains `silenium` + assignment tests.

# silenium

A simple framework where you can start working on your tests right away.
(Just wanted to prove myself to companies that I'm capable of creating a Selenium framework. :D)

## Features
* Parallel execution 
* Supports Linux & Windows (You can override or extend supported platforms easily)
* Supports Chrome & Firefox (You can override or extend supported browsers easily)
* Do you want to run different test cases on different browsers using different driver versions, concurrently? You can do that (Guide will be updated soon... :))

## Prerequisite
* Java 10 or higher (some Java 10 features are being used)
* You may have to update web drivers if they are too old or doesn't match your browser version. Current versions are as follows
	* `ChromeDriver 86.0.4240.22`
	* `geckodriver 0.28.0`
* Eclipse with TestNG plugin will make things so much easier.

# Running
* Clone or download the project
* Import the project to Eclipse as a Gradle project
* Open command prompt in the project file and run `>.\gradlew.bat cleanEclipse eclipse` to configure eclipse settings
* Right click on the project and click on Gradle -> Refresh Gradle Project
* Right click on `circles-life-assignment-test-plan.xml` test plan
* Run As -> TestNG Test
