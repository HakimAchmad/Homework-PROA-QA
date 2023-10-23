package Pages;

import Config.Env;
import org.openqa.selenium.By;

public class DashboardPage extends Env {
    By btn_sidebar = By.xpath("//button[@id='react-burger-menu-btn']");
    By btn_logout = By.id("logout_sidebar_link");
    By btn_addToCart = By.xpath("//button[contains(text(),'Add to cart')]");
    By badge_amountProduct = By.className("shopping_cart_badge");


    public By getBtn_sidebar() {return btn_sidebar;}
    public By getBtn_logout() {return btn_logout;}
    public By getBtn_addToCart() {
        return btn_addToCart;
    }

    public By getBadge_amountProduct() {
        return badge_amountProduct;
    }

}
