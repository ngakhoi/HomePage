package page;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.cert.X509Certificate;
import java.util.List;

public class HomePage extends PageFactory {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Shop Menu
    @FindBy(xpath = "//nav[@id = 'main-nav-wrap']//a[text() = 'Shop']")
    WebElement shopMenu;

    //Home menu button
    @FindBy(xpath = "//nav[@class = 'woocommerce-breadcrumb']/a")
    WebElement homeMenubutton;

    //List Sliders
    @FindBy(xpath = "//div[@class='row_inner']//div[@data-slide-duration = '0']//img")
    List<WebElement> listSliders;

    //List Arrivals
    @FindBy(xpath = "//div[@class='woocommerce']//a/img")
    List<WebElement> listArrivals;

    //Add to basket
    @FindBy(xpath = "//div[@class='summary entry-summary']//button[text()='Add to basket']")
    WebElement addToBasket;

    //Description tab
    @FindBy(xpath = "//div[@class='woocommerce-tabs wc-tabs-wrapper']//a[text()='Description']")
    WebElement description_tab;

    //Product Description
    @FindBy(xpath = "//div[@class='woocommerce-tabs wc-tabs-wrapper']//h2[text()='Product Description']")
    WebElement product_Description;

    //Product Reviews
    @FindBy(xpath = "//div[@class='woocommerce-tabs wc-tabs-wrapper']//a[text()='Reviews (0)']")
    WebElement reviews_tab;

    //Reviews Title
    @FindBy(xpath = "//div[@id='tab-reviews']//h2[text()='Reviews']")
    WebElement reviews_title;

    //Menu Item
    @FindBy(xpath = "//ul//li[@class = 'wpmenucartli wpmenucart-display-standard menu-item']")
    WebElement menuitem;

    // Quantity
    @FindBy(xpath = "//tr[@class = 'cart_item']//input[@class='input-text qty text']")
    WebElement quantity;

    //Update Basket
    @FindBy(xpath = "//div[@class='woocommerce']//td[@class='actions']/input[@name='update_cart']")
    WebElement update_Basket;

    //Proceed to check out button
    @FindBy(xpath = "//div[@class='wc-proceed-to-checkout']//a")
    WebElement proceedToCheckOut;

    //check out page
    @FindBy(xpath = "//div[@class='woocommerce-billing-fields']//h3")
    WebElement billingDetails;

    //clickEntercoupon
    @FindBy(xpath = "//div[@class='woocommerce-info']/a[text()='Click here to enter your code']")
    WebElement clickEntercoupon;

    //input coupon_code
    @FindBy(xpath = "//div[@class='page-content entry-content']//p/input[@id='coupon_code']")
    WebElement coupon_code;

    // button Apply Coupon
    @FindBy(xpath = "//div[@class='woocommerce']//input[@name='apply_coupon']")
    WebElement applyCouponButton;

    // Cart discount Coupon
    @FindBy(xpath = "//div[@id='order_review']//tr[@class='cart-discount coupon-krishnasakinala']//span[text()='50.00']")
    WebElement discountCoupon;

    //minimum coupon
    @FindBy(xpath = "//div[@class='woocommerce']//ul[@class='woocommerce-error']/li")
    WebElement minimumCoupon;

    //button remove book
    @FindBy(xpath = "//div[@class='woocommerce']//tr[@class = 'cart_item']//td[@class='product-remove']/a")
    WebElement removeButton;

    // Cart Empty
    @FindBy(xpath = "//div[@class='woocommerce']//p[@class='cart-empty']")
    WebElement cartEmpty;

    // Total Price
    @FindBy(xpath = "//div[@id='order_review']//tr[@class='order-total']//span")
    WebElement totalPrice;

    //Total
    @FindBy(xpath = "//tr[@class='order-total']//span[@class = 'woocommerce-Price-amount amount']")
    WebElement total;

    //SubTotal
    @FindBy(xpath = "//tr[@class='cart-subtotal']//span[@class = 'woocommerce-Price-amount amount']")
    WebElement subTotal;

    //Basket Totals
    @FindBy(xpath = "//div[@class='cart-collaterals']//div[@class='cart_totals calculated_shipping']//h2")
    WebElement basketTotals;

    //Place Order
    @FindBy(xpath = "//div[@class='woocommerce-billing-fields']//input[@name='billing_first_name']")
    WebElement firstName;

    @FindBy(xpath = "//div[@class='woocommerce-billing-fields']//input[@name='billing_last_name']")
    WebElement lastName;

    @FindBy(xpath = "//div[@class='woocommerce-billing-fields']//input[@name='billing_company']")
    WebElement companyName;

    @FindBy(xpath = "//div[@class='woocommerce-billing-fields']//input[@name='billing_email']")
    WebElement email;

    @FindBy(xpath = "//div[@class='woocommerce-billing-fields']//input[@name='billing_phone']")
    WebElement phone;

    @FindBy(xpath = "//div[@class='woocommerce-billing-fields']//input[@name='billing_address_1']")
    WebElement Address;

    @FindBy(xpath = "//div[@class='woocommerce-billing-fields']//input[@name='billing_city']")
    WebElement city;

    @FindBy(xpath = "//div[@class='form-row place-order']//input[@name='woocommerce_checkout_place_order']")
    WebElement placeOrderButton;

    //order-received
    @FindBy(xpath = "//div[@class='woocommerce']//p[@class='woocommerce-thankyou-order-received']")
    WebElement orderReceived;

    public void verifyPlaceOrder() {
        Assert.assertEquals("Thank you. Your order has been received.", orderReceived.getText());
    }

    public void fillDetails() {
        firstName.sendKeys("Khôi");
        lastName.sendKeys("Đặng");
        companyName.sendKeys("Paraline");
        email.sendKeys("khoidt@paraline.com.vn");
        phone.sendKeys("0388885708");
        Address.sendKeys("Cầu Giấy");
        city.sendKeys("Hà Nội");
        placeOrderButton.click();
    }

    public void verifyTotalSubTotal() {
        //Chưa biết cách lấy giá trị text chuyển về giá trị số để so sánh
        System.out.println("Total: " + total.getText());
        System.out.println("SubTotal: " + subTotal.getText());
    }

    public void totalPrice() {
        System.out.println("Total price = " + totalPrice.getText());
    }

    public void clearQuantity() {
        quantity.clear();
    }

    public void verifyUpdateBasket() {
        Assert.assertEquals("100", quantity.getText());
    }

    public void clickRemove() {
        removeButton.click();
    }

    public void verifyCartEmpty() {
        Assert.assertEquals("Your basket is currently empty.", cartEmpty.getText());
    }

    public void clickEnterCoupon() {
        clickEntercoupon.click();
    }

    public void inputCouponCode(String couponcode) {
        coupon_code.sendKeys(couponcode);
    }

    public void clickApplyCoupon() {
        applyCouponButton.click();
    }

    public void verifyDiscountCoupon() {
        Assert.assertEquals("₹50.00", discountCoupon.getText());
    }

    public void clickProceedToCheckOut() {
        proceedToCheckOut.click();
    }

    public void verifyCheckoutPage() {
        Assert.assertEquals("Basket Totals", basketTotals.getText());
    }

    public void verifyPaymentGatewayPage() {
        Assert.assertEquals("Billing Details", billingDetails.getText());
    }

    public void verifyMinimumCoupon() {
        Assert.assertEquals("The minimum spend for this coupon is ₹450.00.", minimumCoupon.getText());
    }

    public void product_quantity(String quantitys) {
        quantity.sendKeys(quantitys);
    }

    public void updateBasket() {
        update_Basket.click();
    }

    public void verifyOverstock() {
        //Chưa tìm dc Element cảnh báo
    }

    public void clickMenuItem() {
        menuitem.click();
    }

    public void clickShopMenu() {
        shopMenu.click();
    }

    public void clickHomeMenuButton() {
        homeMenubutton.click();
    }

    public void clickArrrivals(int i) {
        listArrivals.get(i).click();
    }

    public void verifyListSliders() {
        Assert.assertEquals(3, listSliders.size());
    }

    public void verifyListArrivals() {
        Assert.assertEquals(3, listArrivals.size());
    }

    public void addToBasket() {
        addToBasket.click();
    }

    public void clickDescriptionTab() {
        description_tab.click();
    }

    public void clickReviewsTab() {
        reviews_tab.click();
    }

    public void verifyDescriptionTab() {
        Assert.assertTrue("Product Description", product_Description.isDisplayed());
    }

    public void verifyReviewsTab() {
        Assert.assertTrue("Reviews", reviews_title.isDisplayed());
    }

}
