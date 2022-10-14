package delphi.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {

    private WebDriver webDriver;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[2]/div[1]/header[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/button[1]")
    WebElement loginBtn;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[2]/div[1]/header[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[1]/form[1]/ul[2]/li[2]/a[1]")
    WebElement registrationBtn;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/section[2]/div[2]/h2[1]")
    WebElement registrationForm;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/section[2]/div[2]/div[1]/form[1]/div[1]/div[1]/input[1]")
    WebElement name;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/section[2]/div[2]/div[1]/form[1]/div[4]/div[1]/input[1]")
    WebElement street;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/section[2]/div[2]/div[1]/form[1]/div[5]/div[1]/input[1]")
    WebElement streetNumber;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/section[2]/div[2]/div[1]/form[1]/div[8]/div[1]/input[1]")
    WebElement phoneNumber;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/section[2]/div[2]/div[1]/form[1]/div[9]/div[1]/input[1]")
    WebElement dateOfBirth;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/section[2]/div[2]/div[1]/form[1]/div[10]/label[1]")
    WebElement emailImput;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/section[2]/div[2]/div[1]/form[1]/div[10]/div[1]/input[1]")
    WebElement emailAddress;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/section[2]/div[2]/div[1]/form[1]/div[11]/div[1]/input[1]")
    WebElement password;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/section[2]/div[2]/div[1]/form[1]/div[12]/div[1]/input[1]")
    WebElement confirmPassword;
    @FindBy(xpath ="/html[1]/body[1]/div[2]/section[2]/div[2]/div[1]/form[1]/div[14]/div[1]/div[1]/label[1]/input[1]")
    WebElement confirmBtn;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/section[2]/div[2]/div[1]/form[1]/div[13]/div[1]/button[1]")
    WebElement confirmRegistrationBtn;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[2]/div[1]/header[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[1]/form[1]/div[1]/input[1]")
    WebElement membershipNumber;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[2]/div[1]/header[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[1]/form[1]/div[2]/input[1]")
    WebElement membershipPassword;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[2]/div[1]/header[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[1]/form[1]/button[1]")
    WebElement signInBtn;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[2]/div[1]/header[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/button[1]/span[1]")
    WebElement corectLoginInformation;
    @FindBy(xpath = "/html[1]/body[1]/footer[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/input[1]")
    WebElement newsletter;
    @FindBy(xpath = "/html[1]/body[1]/footer[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/button[1]")
    WebElement newsletterSignIn;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/h1[1]")
    WebElement newsletterTextIsVisible;
    @FindBy(xpath = "/html[1]/body[1]/footer[1]/div[1]/div[1]/div[2]/div[1]/a[1]/div[1]/img[1]")
    WebElement footerSectionNews;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[5]/h1[1]")
    WebElement newsPage;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/section[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[2]/div[5]/div[1]/div[2]/h3[1]/a[1]")
    WebElement newsAboutEvent;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/section[1]/div[1]/div[1]/div[1]/div[3]/div[1]/a[1]")
    WebElement titleOfTheBookInTheEvent;
    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }
    public void clickOnLoginBtn(){
        loginBtn.click();
    }
    public void clickOnRegistrationBtn(){
        registrationBtn.click();
    }
    public void scrollToRegistrationForm (){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", registrationForm);
    }
    public void inputNameField(String name) {
        this.name.sendKeys(name);
    }
    public void inputStreet (String street){
        this.street.sendKeys(street);
    }
    public void inputStreetNumber (String number){
        this.streetNumber.sendKeys(number);
    }
    public static WebElement getElementById(WebDriver webDriver, String id){
        return webDriver.findElement(By.id(id));
    }
    public void selectPostalCode(WebDriver webDriver, String postalCode){
        WebElement postOffice = getElementById(webDriver,"mesto-selectized");
        postOffice.sendKeys(postalCode);
        postOffice.sendKeys(Keys.ENTER);

    }
    public void inputPhoneNumber(String number){
        this.phoneNumber.clear();
        this.phoneNumber.sendKeys(number);
    }
    public void inputDateOfBirth(String date){
        this.dateOfBirth.sendKeys(date);

    }
    public void closeDateOfBirthAndClickOnEmail(){
        this.emailImput.click();
    }
    public void inputEmail(String email){
        this.emailAddress.sendKeys(email);
    }
    public void inputPassword(String password){
        this.password.sendKeys(password);
    }
    public void confirmPassword(String password){
        this.confirmPassword.sendKeys(password);
    }
    public void clickOnConfirmBtn(){
        confirmBtn.click();
    }
    public void confirmRegistrationBtn(){
        confirmRegistrationBtn.click();
    }
    public void inputMembershipNumber(String number){
        this.membershipNumber.sendKeys(number);
    }
    public void inputMembershipPassword(String password){
        this.membershipPassword.sendKeys(password);
    }
    public void clickOnSignInBtn(){
        signInBtn.click();
    }
    public String corectInformation(){
        return this.corectLoginInformation.getText();
    }
    public void scrollToNewsletter(){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", newsletter);
        javascriptExecutor.executeScript("scroll(0,-100);");
    }
    public void inputEmailInNewsLetter(String email){
        this.newsletter.sendKeys(email);
    }
    public void newsletterSignIn(){
        newsletterSignIn.click();
    }
    public String successfulSignInToNewsletter(){
        return newsletterTextIsVisible.getText();
    }
    public void scrollToFooter(){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", footerSectionNews);
        javascriptExecutor.executeScript("scroll(0,-100);");
    }
    public void clickOnFooterSectionNews(){
        footerSectionNews.click();
    }
    public String newsPageIsVisible(){
        return newsPage.getText();
    }
    public void scrollAndClickOnNews(){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", newsAboutEvent);
        javascriptExecutor.executeScript("scroll(0,-100);");
        newsAboutEvent.click();
    }
    public String titleOfTheBookInEvent(){
        return titleOfTheBookInTheEvent.getText();
    }



}
