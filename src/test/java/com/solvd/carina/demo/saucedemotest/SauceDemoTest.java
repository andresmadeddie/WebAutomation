package com.solvd.carina.demo.saucedemotest;

import com.solvd.carina.demo.gui.saucedemo.*;
import com.solvd.carina.demo.gui.saucedemo.components.CatalogProductItem;
import com.solvd.carina.demo.gui.saucedemo.components.LeftSideMenu;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SauceDemoTest extends AbstractSauceDemoTest {

    @Test
    @MethodOwner(owner = "Andres")
    public void loginTest() {
        String username = R.TESTDATA.get("standard_username");
        String password = R.TESTDATA.get("standard_password");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        loginPage.assertPageOpened();
        loginPage.typeUsername(username);
        loginPage.typePassword(password);
        ProductsPage productsPage = loginPage.clickLoginButton();
        Assert.assertTrue(productsPage.isPageOpened(), "Product page is not opened");
    }

    @Test
    @MethodOwner(owner = "Andres")
    public void productAddedToTheCartTest() {
        String productTitle = R.TESTDATA.get("product_name");

        ProductsPage productsPage = authUtils.loginStandardUser();
        Assert.assertTrue(productsPage.isPageOpened(), "Product page is not opened");
        List<CatalogProductItem> productItems = productsPage.getProductItems();

        for (CatalogProductItem productItem : productItems) {
            if (productTitle.equals(productItem.getProductTitle())) {
                productItem.clickAddToCartButton();
            }
        }

        CartPage cartPage = productsPage.clickCartButton();
        Assert.assertTrue(cartPage.isPageOpened(), "CartPage page is not opened");
        Assert.assertTrue(cartPage.isProductDisplayed(productTitle), "Product title is not displayed in the cart");
    }

    @Test
    @MethodOwner(owner = "Andres")
    public void aboutButtonInHamburgerMenuTest() throws InterruptedException {
        ProductsPage productsPage = authUtils.loginStandardUser();
        Assert.assertTrue(productsPage.isPageOpened(), "Product page is not opened");
        productsPage.clickHamburgerMenu();
        LeftSideMenu leftSideMenu = productsPage.getLeftSideMenu();
        AboutPage aboutPage = leftSideMenu.clickAboutButton();
        Assert.assertTrue(aboutPage.isPageOpened(), "AboutPage page is not opened");
    }

    @Test
    @MethodOwner(owner = "Andres")
    public void logOutButtonInHamburgerMenuTest() {
        ProductsPage productsPage = authUtils.loginStandardUser();
        productsPage.clickHamburgerMenu();
        LeftSideMenu leftSideMenu = productsPage.getLeftSideMenu();
        LoginPage loginPage = leftSideMenu.clickLogOutButton();
        Assert.assertTrue(loginPage.isPageOpened(), "LoginPage page is not opened");
    }

    @Test
    @MethodOwner(owner = "Andres")
    public void checkoutButtonInCartPage() {
        ProductsPage productsPage = authUtils.loginStandardUser();
        productsPage.assertPageOpened();
        CartPage cartPage = productsPage.clickCartButton();
        Assert.assertTrue(cartPage.isPageOpened(), "CartPage page is not opened");
        CheckOutYourInformationPage checkOutYourInformationPage = cartPage.clickCheckOutButton();
        Assert.assertTrue(checkOutYourInformationPage.isPageOpened(), "CheckOutYourInformationPage page is not opened");
    }

    @Test
    @MethodOwner(owner = "Andres")
    public void checkOutTest() {
        String productTitle = R.TESTDATA.get("product_name");
        String firstName = R.TESTDATA.get("first_name");
        String lastName = R.TESTDATA.get("last_name");
        String zip = R.TESTDATA.get("zip");

        ProductsPage productsPage = authUtils.loginStandardUser();
        Assert.assertTrue(productsPage.isPageOpened(), "Product page is not opened");
        List<CatalogProductItem> productItems = productsPage.getProductItems();

        for (CatalogProductItem productItem : productItems) {
            if (productTitle.equals(productItem.getProductTitle())) {
                productItem.clickAddToCartButton();
            }
        }

        CartPage cartPage = productsPage.clickCartButton();
        Assert.assertTrue(cartPage.isPageOpened(), "CartPage page is not opened");
        Assert.assertTrue(cartPage.isProductDisplayed(productTitle), "Product title is not displayed in the cart");
        CheckOutYourInformationPage checkOutYourInformationPage = cartPage.clickCheckOutButton();
        Assert.assertTrue(checkOutYourInformationPage.isPageOpened(), "CheckOutYourInformationPage page is not opened");
        checkOutYourInformationPage.typeFirstName(firstName);
        checkOutYourInformationPage.typeLastName(lastName);
        checkOutYourInformationPage.typeZipcode(zip);
        CheckOutOverViewPage checkOutOverViewPage = checkOutYourInformationPage.clickContinueButton();
        Assert.assertTrue(checkOutOverViewPage.isPageOpened(), "checkOut Overview page is not opened");
        ThanksForYourOrderPage thanksForYourOrderPage = checkOutOverViewPage.clickFinishButton();
        Assert.assertTrue(thanksForYourOrderPage.isPageOpened(), "Thank for your order page is not opened");
        productsPage = thanksForYourOrderPage.clickBackHomeButton();
        Assert.assertTrue(productsPage.isPageOpened(), "Product Page is not opened after clicking Back Home");
    }
}