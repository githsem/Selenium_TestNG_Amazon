package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class BookPage extends BasePage {
    @FindBy(css = "h1 .a-color-state.a-text-bold")
    public WebElement searchedProduct;

    public void verificationOfSearchingResult(String productName) {
        String actualProductName = searchedProduct.getText();
        Assert.assertTrue(actualProductName.contains(productName));
    }
}
