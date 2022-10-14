package delphi.tests;


import delphi.pages.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestDelphiBookstore {
    private WebDriver webDriver;
    HomePage homePage;
    TheTopBookLists topList;
    AddToCart addToCart;
    Locations locations;
    WishList wishList;
    SearchBar searchBar;
    DelphiBookstore delphiBookstore;
    @BeforeMethod
    public void configure() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Ivan96\\Desktop\\chromedriver_win32\\chromedriver.exe");
        webDriver = new ChromeDriver();
        homePage  = new HomePage(webDriver);
        topList = new TheTopBookLists(webDriver);
        addToCart = new AddToCart(webDriver);
        locations = new Locations(webDriver);
        wishList = new WishList(webDriver);
        searchBar = new SearchBar(webDriver);
        delphiBookstore = new DelphiBookstore(webDriver);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        webDriver.get("https://www.delfi.rs");
        webDriver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        WebElement clickOK = homePage.getElementById(webDriver,"uslovi");
        js.executeScript("arguments[0].scrollIntoView();",clickOK );
        clickOK.click();
    }
    @Test
    public void testRegistrationForm()  {
        homePage.clickOnLoginBtn();
        homePage.clickOnRegistrationBtn();
        homePage.scrollToRegistrationForm();
        homePage.inputNameField("Pera Peric");
        homePage.inputStreet("Ustanicka");
        homePage.inputStreetNumber("256B");
        homePage.selectPostalCode(webDriver,"24430 Ada");
        homePage.inputPhoneNumber("+381651231234");
        homePage.inputDateOfBirth("12.10.1997");
        homePage.closeDateOfBirthAndClickOnEmail();
        homePage.inputEmail("pera1peric@gmail.com");
        homePage.inputPassword("Peraa123");
        homePage.confirmPassword("Peraa123");
        homePage.clickOnConfirmBtn();
        homePage.confirmRegistrationBtn();

    }
    @Test
    public void testSignIn(){
        homePage.clickOnLoginBtn();
        homePage.inputMembershipNumber("1798");
        homePage.inputMembershipPassword("PeraDelphi123");
        homePage.clickOnSignInBtn();



    }
    @Test
    public void testTopLists(){
        topList.clickOnForeignTitles();
        topList.viewAll();
        topList.scrollToTopList();
        topList.scrollToForeignTitlesBook();
        topList.scrollToAboutBook();
        Assert.assertEquals(topList.confirmTextIsVisible(),"A Game of Thrones",
                "Text should be the same");
    }
    @Test(dataProvider = "emailForNewsletter")
    public void testSignInToNewsletter(String email){
        homePage.scrollToNewsletter();
        homePage.inputEmailInNewsLetter(email);
        homePage.newsletterSignIn();
        Assert.assertEquals(homePage.successfulSignInToNewsletter(),"Newsletter",
                "Text should be the same");
    }
    @DataProvider(name = "emailForNewsletter")
    public Object[][] getEmailForNewsletter() {
        return new Object[][]{
                {"peradelphi12@gmail.com"},
                {"peradelphi21@gmail.com"},
                {"peradelphi31@gmail.com"},
                {"peradelphi41@gmail.com"}

        };
    }
    @Test
    public void testFooterSection(){
        homePage.scrollToFooter();
        homePage.clickOnFooterSectionNews();
        Assert.assertEquals(homePage.newsPageIsVisible(),"Vesti",
                "Text should be the same");
        homePage.scrollAndClickOnNews();
        Assert.assertEquals(homePage.titleOfTheBookInEvent(),"Nebeska dvorišta",
                "Text should be the same");
    }
    @Test
    public void testAddToCart(){
        addToCart.clickOnBooksForKids();
        addToCart.clickOnSeeAll();
        addToCart.scrollToBook();
        addToCart.clickAddToCart();
        addToCart.clickOnMyCart();
        addToCart.clickToOpenCartPage();
        Assert.assertEquals(addToCart.verifyThatTheBookIsInTheCart(),"https://www.delfi.rs/_img/artikli/2022/10/andjela_levorukic_i_aleksa_desnjakovic_v.jpg",
                "Should be the same book in the cart");
    }
    @Test
    public void testLocationsOfTheBookStores(){
        locations.clickOnLocations();
        locations.findTheStore();
        Assert.assertEquals(locations.verifyThatStoreIsTheRightOne(),"Knjižara Laguna Galerija",
                "The text should be the same");
    }
    @Test
    public void testAddToWishList(){
        wishList.clickOnGift();
        wishList.scrollToBag();
        wishList.hoverBag();
        wishList.clickAddToAWishList();
        wishList.clickOnWishList();
        Assert.assertEquals(wishList.confirmThatThePageIsOpen(),"Moja lista želja",
                "Text should be the same");
        Assert.assertEquals(wishList.confirmThatTheBagIsInTheWishList(),"https://www.delfi.rs/_img/artikli/2022/09/torba_-_anekke_canada_black_short_handle_31x23x13_cm_v.jpg",
                "Url should be the same");
    }
    @Test
    public void testSearchBar(){
        searchBar.inputInSearchBar("Tolstoj");
        searchBar.clickOnSearchLogo();
        searchBar.scrollToBookSearch();
        searchBar.scrollToAboutTheBook();
        Assert.assertEquals(searchBar.getBookQuote(),"Sve srećne porodice liče jedna na drugu, svaka nesrećna porodica nesrećna je na svoj način.",
                "Text should be the same");
    }
    @Test
    public void testDelphiLogoBtn(){
        delphiBookstore.clickOnStarway();
        delphiBookstore.scrollAndClickToMug();
        delphiBookstore.clickOnLogo();
        Assert.assertEquals(webDriver.getCurrentUrl(),"https://www.delfi.rs/",
                "The logo button should bring us back to homepage");

    }
    @AfterMethod
    public void close() {
        webDriver.close();
    }
}
