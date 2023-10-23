package Step;

import Config.Env;
import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginStep extends Env {

    LoginPage elementLogin = new LoginPage();

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        ExpectedConditions.visibilityOfElementLocated(elementLogin.getBtn_login());
    }

    @When("I input (.*) as username$")
    public void user_input_username(String username) {
        WebElement field_userName = driver.findElement(elementLogin.getField_username());
        field_userName.isDisplayed();
        field_userName.sendKeys(username);
    }

    @And("I input (.*) as password$")
    public void user_input_password(String password) {
        WebElement field_password = driver.findElement(elementLogin.getField_password());
        Assert.assertTrue(field_password.isEnabled());
        field_password.sendKeys(password);
    }

    @And("I click button login")
    public void user_click_button_login() {
        WebElement field_password = driver.findElement(elementLogin.getField_password());
        field_password.sendKeys(Keys.ENTER);
    }

    @Then("I verify {string} login success result")
    public void i_verify_success_login_result(String status) {
        if (status.contains("success")) {
            String success = driver.findElement(By.xpath("//div[@class='header_secondary_container']/span[@class='title']")).getText();
            Assert.assertEquals(success, "Products");
        } else {
            driver.findElement(By.className("error-button"));
        }
    }

    @Then("I verify {string} login failed result")
    public void i_verify_failed_login_result(String result) {
        switch (result) {
            case "blank_username" -> {
                String blank_username = driver.findElement(By.xpath("//h3[.='Epic sadface: Username is required']")).getText();
                Assert.assertEquals(blank_username, "Epic sadface: Username is required");
            }
            case "blank_password" -> {
                String blank_password = driver.findElement(By.xpath("//h3[.='Epic sadface: Password is required']")).getText();
                Assert.assertEquals(blank_password, "Epic sadface: Password is required");
            }
        }
    }
}