package delphi.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchBar {
    private WebDriver webDriver;

    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[2]/div[1]/header[1]/div[2]/div[1]/div[4]/form[1]/input[2]")
    WebElement searchBar;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[2]/div[1]/header[1]/div[2]/div[1]/div[4]/form[1]/div[1]/button[2]")
    WebElement searchLogo;
    @FindBy(xpath = "/html[1]/body[1]/div[3]/section[1]/div[1]/div[1]/div[1]/div[2]/div[5]/div[1]/div[1]/a[1]/img[1]")
    WebElement bookSearchByAuthor;
    @FindBy(xpath = "/html[1]/body[1]/div[22]/section[2]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/a[1]/span[1]")
    WebElement aboutTheBook;
    @FindBy(xpath = "/html[1]/body[1]/div[22]/section[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/em[2]")
    WebElement bookQuote;

    public SearchBar(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }
    public void inputInSearchBar(String input){
        this.searchBar.sendKeys(input);
    }
    public void clickOnSearchLogo(){
        this.searchLogo.click();
    }
    public void scrollToBookSearch(){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", bookSearchByAuthor);
        javascriptExecutor.executeScript("scroll(0,-100);");
        bookSearchByAuthor.click();
    }
    public void scrollToAboutTheBook(){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", aboutTheBook);
       // javascriptExecutor.executeScript("scroll(0,-100);");
    }
    public String getBookQuote(){
        return bookQuote.getText();
    }

}