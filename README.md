# FinalProject
Final Project for the course Object-Oriented Software Development

### Shopping Application (Java Project): 



**Requirements:
Eclipse, Java, JUnit, EclEmma plugin



**How to OPEN the Java project using Eclipse:

-> The Shopping Application is a Java Project created using Eclipse platform and the root folder or project is named as 'FinalProject'.

-> To open this Java project, first goto Eclipse and open the platform by launching the eclipse-workspace.

-> Once Eclipse is open, then in order to load and open this Java project, goto File -> Import -> General -> Existing Projects into Workspace -> Next. 

-> Then a window pops up asking to select root directory. Use the Browse option to choose the Java project root folder named 'FinalProject' and click on Finish.

-> The Java project then loads into Eclipse and can be seen in the Package Explorer.



**Contents of the Java project:

-> The root folder 'FinalProject' has '.settings' folder, 'bin' folder, 'src' folder, '.classpath' file, '.project' file and a 'log.txt' file.

-> But in Eclipse, only the 'src' folder will be visible. The rest of the folders and the files are only visible when opened using File Explorer.

-> The 'src' folder has the following .java files:
   - MainClass.java
   - ShoppingApplication.java
   - UserAuthentication.java
   - Product.java
   - ElectronicProduct.java
   - ClothingProduct.java
   - ProductFactory.java
   - ProductCatalog.java
   - ShoppingCart.java
   - CartBuilder.java
   - Order.java
   - PaymentProcessor.java
   - MockPaymentGateway.java
   - Logger.java
     
-> The 'src' folder has the following test files:
   - UserAuthenticationTest.java
   - ElectronicProductTest.java
   - ClothingProductTest.java
   - ProductFactoryTest.java
   - ProductCatalogTest.java
   - ShoppingCartTest.java
   - CartBuilderTest.java
   - OrderTest.java
   - PaymentProcessorTest.java
   - 
-> The 'log.txt' file is used to store the important events and transactions generated while the Java Project is running.



**How to RUN the Java project/application using Eclipse:

-> To run the java project, click on MainClass.java file and then click on the Run button.

-> Once the project runs successfully, a console window opens up and will prompt to provide username and password for login.

-> Please provide the username as 'user1' and password as 'password1' or username as 'user2' and password as 'password2' to login to the Shopping Application successfully. (As these   credentials are stored in the memory for successful user authentication)

-> If user authentication fails, the console will continuously prompt to provide correct username and password until the user successfully logins to the application.

-> Providing the given correct user credentials will result in successful user authentication and the user will be logged in as user1 (or user2 based on the provided input during login).

-> Now the logged in user is provided with various options to choose from in order to perform some activity inside the Shopping Application.

-> The options inlcude:
   - 1. Browse available products
   - 2. Add a product to the shopping cart
   - 3. View shopping cart
   - 4. Checkout the shopping cart
   - 5. Exit the shopping application
        
-> If the user wants to browse through the available products, provide the input as 1 and click on enter button on the keyboard.

-> Then all the available products in the shopping application are displayed along with their prices and again all the user options are provided to choose from.

-> If the user wants to add a product to the shopping cart, provide the input as 2 and click enter.

-> It will then prompt to enter the product name to add it to the shopping cart. Please provide a name from the available products and click on enter.

-> On providing the correct product name from the available products, it gets added to the cart and a message is displayed saying that the particular product is added to the cart.

-> On providing the incorrect product name which is not available in the product catalog, the console will display a message saying that the product is not found in the catalog.

-> If the user wants to view the shopping cart, provide the input as 3 and click enter.

-> The console then displays all the products that were added to the shopping cart.

-> If the user wants to checkout the shopping cart and place the order, provide the input as 4 and click enter.

-> The console then prompts to enter the shipping address to deliver the order.

-> Once the shipping address is entered, the console then prompts to select the payment type.

-> User can enter either creditcard or debitcard as the payment type. If an incorrect payment type is provided, the console will display a message saying Invalid payment type, Payment processing failed. Please try again.

-> On entering the right payment type successfully, the console will prompt to provide name on the credit/debit card, credit/debit card number and CVV.

-> On providing these details successfully, the console will display messages saying that the Payment is successful and order is placed and it will also show the order details.

-> If the user wants to exit the application, provide the input as 5 and click enter.

-> The shopping application is exited successfully.

-> NOTE: Providing inputs other than the given user options (1/2/3/4/5) will lead to the console prompting a message saying that the provided choice is invalid, please try again by entering a valid choice.


 
**How to run the tests in Eclipse:
-> To run the tests, right click on the package name (depaul.edu) -> Coverage As -> JUnit Test. 

