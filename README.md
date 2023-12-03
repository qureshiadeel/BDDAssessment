Automated Testing Documentation

Project Setup Requirements:
Java: Install the latest version of Java on your machine. You can download it from Oracle's Java Downloads page.
Maven: Make sure Maven is installed. You can download it from Maven's official website.
Git: Install Git to clone the project. You can download it from Git's official website.
Allure: Install Allure for test reporting. Follow the instructions available on the Allure website.
IntelliJ IDEA: Download and install IntelliJ IDEA from JetBrains' official website.

Project Setup Instructions:

Open a terminal and navigate to the folder where you want to clone the project.
git clone <repository_url>

Open the project in IntelliJ IDEA and wait for the project to load.
Open a terminal in the root project folder and run the following command:
mvn clean test
This command will execute the test cases.

After the test execution is complete, an Allure result folder will be generated. Copy the address of the folder.
Run the following command, replacing <address> with the copied address:
allure serve <address>
The Allure report will be opened in your default browser.

Test Cases:

Valid Login Test Case:
Description: This test case validates successful login functionality with valid credentials.
Steps:
Open the application.
Enter valid username and password.
Click on the login button.
Expected Result: User should be successfully logged in.

Invalid Login Test Case:
Description: This test case validates the handling of invalid login attempts.
Steps:
Open the application.
Enter invalid username or password.
Click on the login button.
Expected Result: User should see an error message.

Checkout Process Test Case:
Description: This test case validates the end-to-end checkout process.
Steps:
Login with valid credentials.
Add items to the cart.
Proceed to checkout.
Enter shipping details.
Make payment.
Verify the order confirmation.
Expected Result: Order should be successfully placed.




