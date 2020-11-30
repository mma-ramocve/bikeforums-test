1.	INTRODUCTION

1.1.	Purpose
The Test Plan describes the testing approach, scope, schedule and testing activities. The plan will identify the website to be tested, its basic functionalities, menus, theme and structural parts.
The plan identifies the https://www.bikeforums.net website to be tested, the features to be tested, tests for basic functionalities, features not to be tested, the types of testing to be performed, the person responsible for testing, the resources and schedule required to complete testing, and the risks associated with the plan.

1.2.	Project description and website overview
Bike Forums is the leading online discussion site for avid cyclists.
The forum is open to unregistered visitors for reading all contents and topics. The visitor has to be registered and logged in to join the conversation.
The tests will be focused on basic functionalities, menus, submenus, sorting posts and threads, search, registration and login process. Test cases should be executed in three different browsers (Chrome, Firefox and Edge) and in one mobile browser (Chrome).

1.3.	Testing methods to apply 
1.3.1. Exploratory testing – manual, for the website home page, logo visibility, top menus, submenus, bottom menus
1.3.2. Functional testing – manual and automated, for the user interface, basic API testing, basic database testing, security testing, basic functionalities
1.3.3. Usability testing – manual and automated, for site navigation, menus, buttons, links
1.3.4. Compatibility testing – manual, for different browsers (Chrome, Firefox and Edge) and mobile browser (Chrome)
1.3.5. Security testing – manual, for unauthorized access to create and publish content




2.	TEST STRATEGY

2.1.	Scope of Testing
The tests include basic functionalities without any editing or adding content to posts, themes and threads. The tests will not deal with performance and security.

2.1.1. 	Functionalities to be tested
2.1.1.1. – Registration process
Test registration with valid email and password (respecting the password requirements) manually.
Test registration with invalid emails, username and invalid passwords.

2.1.1.2. – Login process
Test login process with valid credentials (registered user), manually and automatically.

2.1.1.3. – Test starting a new thread as registered and unregistered user
Test starting a new thread as registered and unregistered user. Do not finish the process, just test option availability manually.

2.1.1.4. – Test reply to an existing post as registered and unregistered user
Test reply to an existing post as registered and unregistered user. Do not finish the process, just test option availability manually.

2.1.1.5. – Test menu navigation, submenus levels
Test menu, check submenus, and check if all menu levels are links, manually and automatically.

2.1.1.6. – Test display options, sort posts by different criteria, check time determination
Test sorting the posts by different criteria (number of replies, number of views…), ascending, descending, and time determination. Use manual and automated tests.

2.1.1.7. – Test finding and opening the oldest post in a theme
Test finding and opening the oldest post in a theme automatically.

2.1.1.8. – Test URLs changing in browser for clicks on different parts of forum
Test URLs changing in browser for clicks on different parts of forum, manually and automatically.

2.1.1.9. – Test search forum
Test forum search, manually and automatically. Search bike manufacturer name from Serbia. Open post from search results.

2.1.1.10. – Specific automatic test
Login and check if number of posts in General Cycling is greater than number of days in this year till today.


2.1.2. 	Functionalities not to be tested
The tests will not deal with performance and security.
The tests will not add or edit content to posts, themes and threads.



2.2.	Risks and issues
2.2.1. Risk – The project schedule is too tight 
-	Solution – Plan to set test priority 


2.3.	Test logistics
2.3.1. 	Who will test?
One tester will test.

2.3.2. 	When will test occur?
The testing will start when the following conditions are ready:
-	Test plan, test scenarios and test cases are created and approved
-	Test environment is prepared


3.	TEST OBJECTIVE
3.1.	Test scenarios
Manual tests:
•	Add content as unregistered user
•	Search site - unregistered user
•	User registration - negative scenarios
•	User registration - valid input
•	Add content as registered user
•	Search site - registered user

Automated tests:
•	Home page options - unregistered user
•	Find theme, sort posts, find and open oldest post - logged in user
•	Log in registered user and compare number of posts and day in year
•	Test forum search


4.	TEST CRITERIA
4.1.	Test cycles
There will be one cycle of testing in 3 different desktop browsers (Chrome, Firefox and Edge) and in one mobile browser (Chrome).
There will be manual and automated tests.

4.2.	Test cases execution order
Test cases should be conducted in logical order which will be followed in the numbering of test cases.
Each test case should be defined as it might be executed as a single unit.
4.3.	Exit criteria
 Specifies the criteria that denote a successful completion of a test phase
•	100% test cases executed


5.	RESOURCE PLANING
5.1.	System resource
The tester will use the following desktop application during testing:
•	Chrome browser – version 87.0.4280.66
•	Firefox browser – version 83.0
•	Microsoft Edge – version 87.0.664.47
The following mobile browser will be used:
•	Chrome mobile browser – version 86.0.4240.198
For automated test scripts the following will be used:
•	IntelliJ IDEA 2020.2.3 (Community Edition)
•	Chrome web driver – version 87.0.4280.20
•	Libraries:
o	activation-1.1.1.jar
o	commons-codec-1.13.jar
o	commons-collections4-4.4.jar
o	commons-compress-1.19.jar
o	commons-logging-1.2.jar
o	commons-math3-3.6.1.jar
o	curvesapi-1.06.jar
o	jaxb-api-2.3.1.jar
o	jaxb-core-2.3.0.1.jar
o	jaxb-impl-2.3.2.jar
o	junit-4.12.jar
o	log4j-1.2.17.jar
o	poi-4.1.1.jar
o	poi-examples-4.1.1.jar
o	poi-excelant-4.1.1.jar
o	poi-ooxml-4.1.1.jar
o	poi-ooxml-schemas-4.1.1.jar
o	poi-scratchpad-4.1.1.jar
o	xmlbeans-3.1.0.jar

5.2.	Human resource
One tester will execute all tests.
6.	SCHEDULE & ESTIMATION
6.1.	Testing project tasks and time estimation
The schedule refers to the process after the acceptance of this document and test scenario and test cases written in details.
•	Manual testing – 2 days
•	Automated tests, scripts – 2 days

6.2.	After the testing
•	Test results, analyze reports


