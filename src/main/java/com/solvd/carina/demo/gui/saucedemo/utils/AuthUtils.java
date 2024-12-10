package com.solvd.carina.demo.gui.saucedemo.utils;

import com.solvd.carina.demo.gui.saucedemo.LoginPage;
import com.solvd.carina.demo.gui.saucedemo.ProductsPage;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;

public class AuthUtils implements ICustomTypePageFactory {

    public ProductsPage login(String username, String password) {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        loginPage.typeUsername(username);
        loginPage.typePassword(password);
        return loginPage.clickLoginButton();
    }

    public ProductsPage loginStandardUser() {
        return login(R.TESTDATA.get("standard_username"), R.TESTDATA.get("standard_password"));
    }
}