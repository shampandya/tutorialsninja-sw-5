package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.LoginPage;
import com.tutorialsninja.demo.pages.MyAccountPage;
import com.tutorialsninja.demo.pages.RegisterPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.UUID;

@Listeners(CustomListeners.class)
public class MyAccountsTest extends BaseTest {

    String email;
    HomePage homePage;
    RegisterPage registerPage;
    MyAccountPage myAccountPage;
    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        registerPage = new RegisterPage();
        myAccountPage = new MyAccountPage();
        loginPage = new LoginPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        //1.1 Click on My Account Link.
        homePage.clickOnMyAccountLink();
        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        homePage.selectMyAccountOptions("Register");
        //1.3 Verify the text “Register Account”.
        String expectedMessage = "Register Account";
        String actualMessage = registerPage.getRegisterAccountText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        //1.1 Click on My Account Link.
        homePage.clickOnMyAccountLink();
        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        homePage.selectMyAccountOptions("Login");
        //1.3 Verify the text “Returning Customer”.
        String expectedMessage = "Returning Customer";
        String actualMessage = loginPage.getReturningCustomerText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }


    @Test(groups = "regression")
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
        //3.1 Click on My Account Link.
        homePage.clickOnMyAccountLink();
        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        homePage.selectMyAccountOptions("Register");
        //3.3 Enter First Name
        registerPage.enterFirstName("sara");
        //3.4 Enter Last Name
        registerPage.enterLastName("sara");
        //3.5 Enter Email
        String name = UUID.randomUUID().toString();
        email = name + "@gmail.com";
        registerPage.enterEmail(email);
        //3.6 Enter Telephone
        registerPage.enterPhoneNumber("0791777777777");
        //3.7 Enter Password
        registerPage.enterPassword("123456789@sara");
        //3.8 Enter Password Confirm
        registerPage.enterConfirmPassword("123456789@sara");
        //3.9 Select Subscribe Yes radio button
        registerPage.selectSubscribeButton("Yes");
        //3.10 Click on Privacy Policy check box
        registerPage.clickOnAgree();
        //3.11 Click on Continue button
        registerPage.clickOnContinue();
        //3.12 Verify the message “Your Account Has Been Created!”
        String expectedMessage = "Your Account Has Been Created!";
        String actualMessage = registerPage.getAccountCreatedText();
        Assert.assertEquals(expectedMessage, actualMessage);
        //3.13 Click on Continue button
        registerPage.clickOnContinueAfterCreation();
        //3.14 Click on My Account Link.
        homePage.clickOnMyAccountAfterLogin();
        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        //String option = "Logout";
        myAccountPage.selectMyAccountOptions("Logout");
        //3.16 Verify the text “Account Logout”
        expectedMessage = "Account Logout";
        actualMessage = homePage.getAccountLogoutText();
        Assert.assertEquals(expectedMessage, actualMessage);
        //registerPage.clickOnContinueAfterCreation();
    }

    @Test(groups = "regression")
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        //4.1 Click on My Account Link.
        homePage.clickOnMyAccountLink();
        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        homePage.selectMyAccountOptions("Login");
        //4.3 Enter Email address
        loginPage.enterEmailId("sarasara@gmail.com");
        //4.5 Enter Password
        loginPage.enterPassword("123456789@sara");
        //4.6 Click on Login button
        loginPage.clickOnLogin();
        //4.7 Verify text “My Account”
        String expectedMessage = "My Account";
        String actualMessage = loginPage.getMyAccountText();
        Assert.assertEquals(expectedMessage, actualMessage);
        //4.8 Click on My Account Link.
        homePage.clickOnMyAccountAfterLogin();
        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        String option = "Logout";
        myAccountPage.selectMyAccountOptions(option);
        //4.10 Verify the text “Account Logout”
        expectedMessage = "Account Logout";
        actualMessage = homePage.getAccountLogoutText();
        Assert.assertEquals(expectedMessage, actualMessage);
        //4.11 Click on Continue button
        registerPage.clickOnContinueAfterCreation();
    }

}
