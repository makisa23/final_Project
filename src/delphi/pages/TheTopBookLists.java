package delphi.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TheTopBookLists {
    private WebDriver webDriver;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[4]/a[1]")
    WebElement foreignTitles;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]")
    WebElement viewAll;
    @FindBy(xpath = "/html[1]/body[1]/div[3]/section[1]/div[1]/div[1]/div[1]/section[3]/div[1]/div[1]/div[1]/div[1]/div[1]/h2[1]/a[1]")
    WebElement topLists;
    @FindBy(xpath = "/html[1]/body[1]/div[3]/section[1]/div[1]/div[1]/div[1]/div[2]/div[12]/div[1]/div[1]/a[1]/img[1]")
    WebElement bookFireAndBlood;
    @FindBy(xpath = "/html[1]/body[1]/div[4]/section[2]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/a[1]")
    WebElement aboutBook;
    @FindBy(xpath = "/html[1]/body[1]/div[4]/section[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/em[1]")
    WebElement textIsVisible;

    public TheTopBookLists(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }
    public void  clickOnForeignTitles(){
        this.foreignTitles.click();
    }
    public void viewAll(){
        this.viewAll.click();
    }
    public void scrollToTopList(){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", topLists);
        javascriptExecutor.executeScript("scroll(0,-100);");
        topLists.click();
    }
    public void scrollToForeignTitlesBook(){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", bookFireAndBlood);
        javascriptExecutor.executeScript("scroll(0,-100);");
        this.bookFireAndBlood.click();
    }

    public void scrollToAboutBook(){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", aboutBook);
        javascriptExecutor.executeScript("scroll(0,-100);");
    }
    public String confirmTextIsVisible (){
        return textIsVisible.getText();
    }
}
