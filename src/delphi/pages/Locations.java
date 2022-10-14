package delphi.pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Locations {
    private WebDriver webDriver;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[2]/div[1]/header[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/a[1]")
    WebElement location;
    @FindBy(xpath = "/html[1]/body[1]/div[3]/section[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[2]/div[5]/div[1]/div[2]/div[1]/h3[1]/a[1]")
    WebElement store;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/section[1]/div[1]/div[1]/div[2]/section[1]/div[1]/div[1]/div[1]/h4[1]")
    WebElement lagunaStore;

    public Locations(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }
    public void clickOnLocations(){
        this.location.click();
    }
    public void findTheStore(){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", store);
        javascriptExecutor.executeScript("scroll(0,-100);");
        store.click();
    }
    public String verifyThatStoreIsTheRightOne(){
        return lagunaStore.getText();
    }
}
