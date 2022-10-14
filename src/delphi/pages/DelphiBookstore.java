package delphi.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DelphiBookstore {
    private WebDriver webDriver;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[5]/a[1]/span[1]")
    WebElement starway;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/section[1]/div[1]/div[1]/div[1]/div[3]/div[5]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/a[1]/img[1]")
    WebElement babyJodaMug;
    @FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/div[1]/header[1]/div[2]/div[1]/div[1]/a[1]/div[1]")
    WebElement delphiLogoBtn;

    public DelphiBookstore(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }
    public void clickOnStarway(){
      this.starway.click();
    }
    public void scrollAndClickToMug(){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", babyJodaMug);
        javascriptExecutor.executeScript("scroll(0,-100);");
        babyJodaMug.click();
    }
    public void clickOnLogo(){
        this.delphiLogoBtn.click();
    }
}
