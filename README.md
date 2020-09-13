- The framework was designed with the concept of the page object model.
- The framework has "elementlocator" package, it's used to keep safe all the location and & it's value.
- The framework has "ExtentReportListner" package, it's created to generate the extent report.
- The framework has "framework", it's the heart of the framework. It's used to initialize the web driver & other commonly
 used method is defined here, like findElements, explicitWait, etc.
- The framework has "gojek.assigment" package, we implemented all the test cases in this pacakge.
- In "comm.gojek" we defined the test cases.

Note:- One place we used static wait beacuse explicit wait is not working properlly, and due to time contraint I used
 static wait.

- The frame work is capable to run the test cases in operating system such as macbook & windows, ans also it's capable
 to run the test cases in google chrome & mozilla firefox.
 
Config file details:
- In the "browser" filed the user can provide two value for chrome such as chrome or google chrome, for mozilla they can
provide multiple values such as mozilla, mozilla firefox, firefox, gecko.
- Capitialization is not mandatory, they can use small as well as capital letters.

Steps to run from terminal or commond prompt
- In terminal move to the project directory, like inside the project "Gojek".
- Once the user inside the project directory run the commands as "mvn test".
- mvn test command will run the 2 test cases, one is verifyPaymentSuccess & second is verifyPaymentFailure.

Note:- Other the two above mentioned test cases all the test cases marked as enabled = false. So, with mvn test those
 test cases will not going for execution