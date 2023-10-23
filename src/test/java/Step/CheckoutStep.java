package Step;

import Config.Env;
import Pages.DashboardPage;
import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutStep extends Env {
    LoginPage elementLogin = new LoginPage();
    DashboardPage elementDashboard = new DashboardPage();

    @Given("I is on cart page")
    public void iIsOnCartPage() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("shopping_cart_container")).click();
        String cartPge = driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span")).getText();
        Assert.assertEquals(cartPge, "Your Cart");
    }

    @When("I click checkout button")
    public void iClickCheckoutButton() {
        driver.findElement(By.id("checkout")).click();
    }

    @And("I input identity")
    public void iInputIdentity() {
        driver.findElement(By.id("first-name")).sendKeys("Hakim");
        driver.findElement(By.id("last-name")).sendKeys("Ahmad");
        driver.findElement(By.id("postal-code")).sendKeys("17424");
    }

    @And("I tap continue button")
    public void iTapContinueButton() {
        driver.findElement(By.id("continue")).click();
        String checkoutOverviewPage;
        checkoutOverviewPage = driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span")).getText();
        Assert.assertEquals(checkoutOverviewPage, "Checkout: Overview");
    }

    @And("I tap finish button")
    public void iTapFinishButton() {
        driver.findElement(By.id("finish")).click();
    }

    @Then("I is on checkout complete page")
    public void iIsOnCheckoutCompletePage() {
        String checkoutCompletePage;
        checkoutCompletePage = driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span")).getText();
        Assert.assertEquals(checkoutCompletePage, "Checkout: Complete!");
    }

    @And("I input identity without postal code")
    public void iInputIdentityWithoutPostalCode() {
        driver.findElement(By.id("first-name")).sendKeys("Ahmad");
        driver.findElement(By.id("last-name")).sendKeys("Hakim");
        driver.findElement(By.id("postal-code")).sendKeys("");
    }

    @And("I Click Continue Button to next process")
    public void iClickContinueButtonToNextProcess() {
        driver.findElement(By.id("continue")).click();
    }

    @Then("I get error message postal code is required")
    public void iGetErrorMessagePostalCodeIsRequired() {
        String errorPostalCode = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assert.assertEquals(errorPostalCode, "Error: Postal Code is required");
    }
}
