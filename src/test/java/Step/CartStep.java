package Step;

import Config.Env;
import Pages.DashboardPage;
import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;


public class CartStep extends Env {
    int prev_amount;
    LoginPage elementLogin = new LoginPage();
    DashboardPage elementDashboard = new DashboardPage();

    @When("I add first product to cart")
    public void iAddFirstProductToCart() {
        List<WebElement> btn_addToCart = driver.findElements(elementDashboard.getBtn_addToCart());
        btn_addToCart.get(0).click();
        Assert.assertTrue(btn_addToCart.size() == 6);
    }

    @And("I see initial amount")
    public void iSeeInitialAmount() {
        WebElement text_amountInCart = driver.findElement(elementDashboard.getBadge_amountProduct());
        prev_amount = Integer.valueOf(text_amountInCart.getText());
    }

    @And("I add second product to cart")
    public void iAddSecondProductToCart() {
        driver.findElement(elementDashboard.getBtn_addToCart()).click();
    }

    @Then("user verify amount of product in cart incremented")
    public void userVerifyAmountOfProductInCartIncremented() {
        WebElement text_amountInCart = driver.findElement(elementDashboard.getBadge_amountProduct());
        int curr_amount = Integer.valueOf(text_amountInCart.getText());
        Assert.assertTrue(curr_amount - prev_amount == 1);
    }
}
