package Step;

import Config.Env;
import Pages.DashboardPage;
import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class LogoutStep extends Env {

    LoginPage elementLogin = new LoginPage();
    DashboardPage elementDashboard = new DashboardPage();

    @Given("I am on logged account")
    public void iAmOnLoggedAccount() {
    ExpectedConditions.visibilityOfElementLocated(elementLogin.getBtn_login());
    WebElement field_userName = driver.findElement(elementLogin.getField_username());
    field_userName.sendKeys("standard_user");
    WebElement field_password = driver.findElement(elementLogin.getField_password());
    field_password.sendKeys("secret_sauce");
    field_password.sendKeys(Keys.ENTER);
    String success = driver.findElement(By.xpath("//div[@class='header_secondary_container']/span[@class='title']")).getText();
    Assert.assertEquals(success, "Products");
    }

    @When("I Click Sidebar menu in top left corner")
    public void iClickSidebarMenuInTopLeftCorner() {
        WebElement button_sidebar = driver.findElement(elementDashboard.getBtn_sidebar());
        button_sidebar.click();
    }

    @And("I click button logout")
    public void iClickButtonLogout() {
       driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
       WebElement button_logout = driver.findElement(elementDashboard.getBtn_logout());
       button_logout.click();
    }

    @Then("I successfully to logout account")
    public void iSuccessfullyToLogoutAccount() {
      ExpectedConditions.visibilityOfElementLocated(elementLogin.getBtn_login());
    }
}
