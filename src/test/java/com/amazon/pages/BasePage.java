package com.amazon.pages;

import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id = "sp-cc-accept")
    public WebElement cookiesBtn;

    @FindBy(id = "nav-link-accountList-nav-line-1")
    public WebElement merhabaElement;

    @FindBy(css = "#nav-flyout-ya-signin>a")
    public WebElement girisYapBtn;

    public void acceptCookies(){
        cookiesBtn.click();
    }

    public void navigateToLoginPage(){
        BrowserUtils.hover(merhabaElement);
        girisYapBtn.click();
    }

}
