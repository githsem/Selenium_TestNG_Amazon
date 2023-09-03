package com.amazon.pages;

import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class YourListPage extends BasePage {
    @FindBy(className = "a-button-input")
    public WebElement aNewListLink;

    @FindBy(id = "list-name")
    public WebElement listNameBox;

    @FindBy(xpath = "(//input[@class='a-button-input a-declarative'])[3]")
    public WebElement listeOlusturBtn;

    @FindBy(css = "[alt='Daha fazlası']")
    public WebElement dahaFazlasiLink;

    @FindBy(id = "editYourList")
    public WebElement listeyiYonetLink;

    @FindBy(xpath = "//span[text()='Listeyi sil']/../input")
    public WebElement listeyiSilLink;

    @FindBy(css = "[name='submit.save']")
    public WebElement deleteListEvetBtn;

    @FindBy(css = "[id^='wl-list-entry-title']")
    public WebElement currentListElement;

    public void createANewListMethod(String listName) {
        aNewListLink.click();
        BrowserUtils.waitForClickablility(By.id("list-name"), 7);
        BrowserUtils.clearAndSendKeys(listNameBox, listName);
        BrowserUtils.waitForVisibility(listeOlusturBtn, 7);
        Actions actions = new Actions(Driver.get());
        actions.click(listeOlusturBtn).build().perform();
    }

    public void verificationOfCreatedList(String listName) {
        String actualListName = currentListElement.getText();
        Assert.assertEquals(actualListName, listName);
    }

    public void deleteList() {
        BrowserUtils.waitForVisibility(dahaFazlasiLink, 5);
        dahaFazlasiLink.click();
        BrowserUtils.hover(dahaFazlasiLink);
        BrowserUtils.waitForClickablility(listeyiYonetLink, 5).click();
        BrowserUtils.scrollToElement(listeyiSilLink);
        BrowserUtils.waitForClickablility(listeyiSilLink, 5).click();
        BrowserUtils.waitFor(3);
        deleteListEvetBtn.click();
    }
}
