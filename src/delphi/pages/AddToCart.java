package delphi.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCart {
    private WebDriver webDriver;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[6]/a[1]")
    WebElement booksForKids;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]")
    WebElement seeAll;
    @FindBy(xpath ="/html[1]/body[1]/div[3]/section[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/a[1]/img[1]")
    WebElement childrensBook;
    @FindBy(xpath = "/html[1]/body[1]/div[9]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[5]/div[1]/div[1]")
    WebElement addToCartBtn;
    @FindBy(xpath = "/html[1]/body[1]/div[9]/div[2]/div[1]/header[1]/div[2]/div[1]/div[5]/div[1]/div[2]/button[1]")
    WebElement myCart;
    @FindBy(xpath = "/html[1]/body[1]/div[9]/div[2]/div[1]/header[1]/div[2]/div[1]/div[5]/div[1]/div[2]/ul[1]/li[2]/div[2]/div[1]/a[1]")
    WebElement myCartBtn;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/a[1]/img[1]")
    WebElement bookInTheCart;
    public AddToCart(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }
    public void clickOnBooksForKids(){
        this.booksForKids.click();
    }
    public void clickOnSeeAll(){
        this.seeAll.click();
    }
    public void scrollToBook(){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", childrensBook);
        javascriptExecutor.executeScript("scroll(0,-100);");
        childrensBook.click();
    }
    public void clickAddToCart(){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", addToCartBtn);
        javascriptExecutor.executeScript("scroll(0,100);");
        this.addToCartBtn.click();

    }
    public void clickOnMyCart (){
        this.myCart.click();
    }
    public void clickToOpenCartPage(){
        this.myCartBtn.click();
    }
    public String verifyThatTheBookIsInTheCart(){
        return bookInTheCart.getAttribute("src");
    }
}

