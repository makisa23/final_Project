package delphi.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WishList {
    private WebDriver webDriver;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]")
    WebElement gift;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/section[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/a[1]/img[1]")
    WebElement bagAnekke;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/section[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/span[1]/a[1]/img[1]")
    WebElement addToAWishList;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[2]/div[1]/header[1]/div[2]/div[1]/div[5]/div[1]/div[1]/a[1]/img[1]")
    WebElement wishList;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[5]/h1[1]")
    WebElement myWishListPage;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]/img[1]")
    WebElement bagAnekkeInTheWishList;

    public WishList(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }
    public void clickOnGift(){
        this.gift.click();
    }
    public void scrollToBag(){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", bagAnekke);
        javascriptExecutor.executeScript("scroll(0,-100);");

    }
    public void hoverBag(){
        Actions actions = new Actions(webDriver);
        actions.moveToElement(bagAnekke).perform();
    }
    public void clickAddToAWishList(){
        addToAWishList = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html[1]/body[1]/div[2]/section[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/span[1]/a[1]/img[1]")));
        addToAWishList.click();
    }
    public void clickOnWishList(){
        this.wishList.click();
    }
    public String confirmThatThePageIsOpen(){
        return myWishListPage.getText();
    }
    public String confirmThatTheBagIsInTheWishList(){
        return bagAnekkeInTheWishList.getAttribute("src");
    }

}
