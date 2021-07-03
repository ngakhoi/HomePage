package runner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.HomePage;

import java.util.concurrent.TimeUnit;

public class HomePage_TestSuite {
    WebDriver driver;
    HomePage homePage;

    @Before
    public void setupDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        driver.get("http://practice.automationtesting.in/");
        driver.manage().window().maximize();
    }

    @Test
    //1. Home Page with three Sliders only
    public void verify_sliders_number() {
        homePage.clickShopMenu();
        homePage.clickHomeMenuButton();
        homePage.verifyListSliders();
    }

    //2. Home page with three Arrivals only
    @Test
    public void verify_arrivals_number() {
        homePage.clickShopMenu();
        homePage.clickHomeMenuButton();
        homePage.verifyListArrivals();
    }

    //3. Home page - Images in Arrivals should navigate
    @Test
    public void arrivals_should_navigate() {
        homePage.clickShopMenu();
        homePage.clickHomeMenuButton();
        homePage.clickArrrivals(0);
        homePage.addToBasket();
    }

    //4. Home page - Arrivals-Images-Description
    @Test
    public void verify_arrivals_description() {
        homePage.clickShopMenu();
        homePage.clickHomeMenuButton();
        homePage.clickArrrivals(0);
        homePage.clickDescriptionTab();
        homePage.verifyDescriptionTab();
    }

    //5. Home page - Arrivals-Images-Reviews
    @Test
    public void verify_arrivals_reviews() {
        homePage.clickShopMenu();
        homePage.clickHomeMenuButton();
        homePage.clickArrrivals(0);
        homePage.clickReviewsTab();
        homePage.verifyReviewsTab();
    }

    //6. Home page - Arrivals-Images-Add to Basket
    @Test
    public void view_shopping_cart() {
        homePage.clickShopMenu();
        homePage.clickHomeMenuButton();
        homePage.clickArrrivals(0);
        homePage.addToBasket();
        homePage.clickMenuItem();
    }

    //7. Home page - Arrivals-Add to Basket with more books
    @Test
    public void over_stock() {
        homePage.clickShopMenu();
        homePage.clickHomeMenuButton();
        homePage.clickArrrivals(0);
        homePage.addToBasket();
        homePage.clickMenuItem();
        homePage.product_quantity("10000");
        homePage.updateBasket();
    }

    //8. Home-Arrivals-Add to Basket-Items --> Sửa lại
    @Test
    public void checkout_page() {
        homePage.clickShopMenu();
        homePage.clickHomeMenuButton();
        homePage.clickArrrivals(0);
        homePage.addToBasket();
        homePage.clickMenuItem();
        //homePage.verifyCheckoutPage();
    }

    @Test
    //9. Home-Arrivals-Add to Basket-Items-Coupon --> Sửa lại
    public void verifyCouponCode() {
        homePage.clickShopMenu();
        homePage.clickHomeMenuButton();
        homePage.clickArrrivals(0);
        homePage.addToBasket();
        homePage.clickMenuItem();
        homePage.clickProceedToCheckOut();
        homePage.clickEnterCoupon();
        homePage.inputCouponCode("krishnasakinala");
        homePage.clickApplyCoupon();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePage.verifyDiscountCoupon();
    }

    //10. Home-Arrivals-Add to Basket-Items-Coupon value<450 -> Sửa lại
    @Test
    public void minimumCoupon() {
        homePage.clickShopMenu();
        homePage.clickHomeMenuButton();
        homePage.clickArrrivals(2);
        homePage.addToBasket();
        homePage.clickMenuItem();
        homePage.clickProceedToCheckOut();
        homePage.clickEnterCoupon();
        homePage.inputCouponCode("krishnasakinala");
        homePage.clickApplyCoupon();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePage.verifyMinimumCoupon();
    }

    //11. Home-Arrivals-Add to Basket-Items-Remove book
    @Test
    public void verifyRemoveTheBook() {
        homePage.clickShopMenu();
        homePage.clickHomeMenuButton();
        homePage.clickArrrivals(2);
        homePage.addToBasket();
        homePage.clickMenuItem();
        homePage.clickRemove();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePage.verifyCartEmpty();
    }

    //12. Home-Arrivals-Add to Basket-Items-Add book
    @Test
    public void verifyUpdateBasket() {
        homePage.clickShopMenu();
        homePage.clickHomeMenuButton();
        homePage.clickArrrivals(2);
        homePage.addToBasket();
        homePage.clickMenuItem();
        homePage.clearQuantity();
        homePage.product_quantity("100");
        homePage.updateBasket();
        homePage.verifyUpdateBasket();
    }

    //13. Home-Arrivals-Add to Basket-Items-Check-out-Book Final price
    @Test
    public void totalPrice() {
        homePage.clickShopMenu();
        homePage.clickHomeMenuButton();
        homePage.clickArrrivals(2);
        homePage.addToBasket();
        homePage.clickMenuItem();
        homePage.clickProceedToCheckOut();
        homePage.totalPrice();
    }

    //14. Home-Arrivals-Add to Basket-Items-Check-out-Update Basket
    @Test
    public void checkout_Update_Basket() {
        homePage.clickShopMenu();
        homePage.clickHomeMenuButton();
        homePage.clickArrrivals(2);
        homePage.addToBasket();
        homePage.clickMenuItem();
        homePage.clearQuantity();
        homePage.product_quantity("100");
        homePage.updateBasket();
    }

    //15. Home-Arrivals-Add to Basket-Items-Check-out-Total & Sub-total condition
    @Test
    public void verifyTotal_Subtotal() {
        homePage.clickShopMenu();
        homePage.clickHomeMenuButton();
        homePage.clickArrrivals(2);
        homePage.addToBasket();
        homePage.clickMenuItem();
        homePage.verifyTotalSubTotal();
    }

    //16. Home-Arrivals-Add to Basket-Items-Check-out functionality
    @Test
    public void checkOut_functionality() {
        homePage.clickShopMenu();
        homePage.clickHomeMenuButton();
        homePage.clickArrrivals(2);
        homePage.addToBasket();
        homePage.clickMenuItem();
        homePage.verifyTotalSubTotal();
        homePage.clickProceedToCheckOut();
    }

    //17. Home-Arrivals-Add to Basket-Items-Check-out-Payment Gateway
    @Test
    public void verifyPaymentGatewayPage() {
        homePage.clickShopMenu();
        homePage.clickHomeMenuButton();
        homePage.clickArrrivals(0);
        homePage.addToBasket();
        homePage.clickMenuItem();
        homePage.clickProceedToCheckOut();
        homePage.verifyPaymentGatewayPage();
    }

    //18. Home-Arrivals-Add to Basket-Items-Check-out-Payment Gateway-Place order
    @Test
    public void verifyPlaceOrder() {
        homePage.clickShopMenu();
        homePage.clickHomeMenuButton();
        homePage.clickArrrivals(0);
        homePage.addToBasket();
        homePage.clickMenuItem();
        homePage.clickProceedToCheckOut();
        homePage.fillDetails();
        //homePage.verifyPlaceOrder();
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}
