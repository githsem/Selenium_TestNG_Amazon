package com.amazon.pages;

import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "sp-cc-accept")
    public WebElement cookiesBtn;

    @FindBy(id = "nav-link-accountList-nav-line-1")
    public WebElement merhabaElement;

    @FindBy(css = "#nav-flyout-ya-signin>a")
    public WebElement girisYapBtn;

    @FindBy(css = "#nav-link-accountList-nav-line-1")
    public WebElement username;

    @FindBy(linkText = "Liste Oluşturun")
    public WebElement listeOlusturLink;

    @FindBy(id = "searchDropdownBox")
    public WebElement selectCategoryDropDown;

    @FindBy(id = "nav-search-submit-button")
    public WebElement searchButton;

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBox;

    public void acceptCookies() {
        cookiesBtn.click();
    }

    public void navigateToLoginPage() {
        BrowserUtils.hover(merhabaElement);
        girisYapBtn.click();
    }

    public String getUsername() {
        return username.getText();
    }

    public void createANewList() {
        BrowserUtils.hover(username);
        listeOlusturLink.click();
    }

    public void selectCategory(String categoryName) {
        BrowserUtils.waitFor(2);
        Select select = new Select(selectCategoryDropDown);
        select.selectByVisibleText(categoryName);
    }

    public void verificationOfSelectedCategory(String categoryName) {
        Select select = new Select(selectCategoryDropDown);
        String actualCategory = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actualCategory, categoryName);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void searchingProduct(String productName) {
        searchBox.sendKeys(productName + Keys.ENTER);
    }
}