package org.semenova.tests;

import org.semenova.driver.WebDriverHolder;
import org.semenova.enums.MainMenuItems;
import org.semenova.pages.BasePage;
import org.semenova.pages.LogInPage;
import org.semenova.utils.PropertiesReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInLogOutTests extends BaseTestClass {

    private String messageErrorExpected = "Login was unsuccessful. Please correct the errors and try again." +
             "\n" + "The credentials provided are incorrect";
    private String emailErrorExpected = "Wrong email";


    @BeforeMethod
    public void logout() {
            WebDriverHolder.getInstance().getDriver().manage().deleteAllCookies();
            WebDriverHolder.getInstance().getDriver().get(PropertiesReader.getInstance().getProperty("app.url"));
    }

    @Test
    public void loginWithValidCredentials(){
       BasePage basePage = new BasePage()
               .getMainMenu()
               .selectLoginMenuItem();

        ((LogInPage)basePage).successfulLogin(PropertiesReader.getInstance().getProperty("user.name"),
                PropertiesReader.getInstance().getProperty("user.password"));

        boolean loggedIn = new BasePage().isUserLoggedIn();
        Assert.assertTrue(loggedIn);
    }

    @Test
    public void logoutFromAccount() {
        BasePage basePage = new BasePage()
                .getMainMenu()
                .selectLoginMenuItem();

        ((LogInPage)basePage).successfulLogin(PropertiesReader.getInstance().getProperty("user.name"),
                PropertiesReader.getInstance().getProperty("user.password"));

       basePage.getMainMenu().selectMenuItem(MainMenuItems.LOG_OUT);

        boolean logout = new BasePage().getMainMenu().isMainMenuElementVisible(MainMenuItems.lOG_IN);
        Assert.assertTrue(logout);
    }

    @Test
    public void logInWithInvalidPassword(){
        BasePage basePage = new BasePage()
                .getMainMenu()
                .selectLoginMenuItem();

        ((LogInPage)basePage).unsuccessfulLogin(PropertiesReader.getInstance().getProperty("user.name"),
                PropertiesReader.getInstance().getProperty("user.invalidpass"));

        boolean isMessageErrorDisplayed = new LogInPage().getMessageErrorText().contentEquals(messageErrorExpected);

        Assert.assertTrue(isMessageErrorDisplayed);
   }

    @Test
    public void logInWithInvalidEmail(){
        BasePage basePage = new BasePage()
                .getMainMenu()
                .selectLoginMenuItem();

        ((LogInPage)basePage).unsuccessfulLogin(PropertiesReader.getInstance().getProperty("user.invalidname"),
                PropertiesReader.getInstance().getProperty("user.password"));

        boolean isEmailErrorMessageDisplayed = new LogInPage().getEmailErrorText().contentEquals(emailErrorExpected);

        Assert.assertTrue(isEmailErrorMessageDisplayed);
    }
        


}
