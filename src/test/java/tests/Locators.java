package tests;

import org.openqa.selenium.By;

public class Locators {

    public static final By LOGIN_USERNAME_ID = By.id("user-name");

    public static final By LOGIN_PASSWORD_NAME = By.name("password");

    public static final By ADD_TO_CART_BUTTON_CLASS = By.className("btn_inventory");

    public static final By FOOTER_LINK_TAG = By.tagName("a");

    public static final By TWITTER_LINK_TEXT = By.linkText("Twitter");

    public static final By LINKEDIN_PARTIAL_LINK = By.partialLinkText("Linked");

    public static final By XPATH_BY_ATTR = By.xpath("//input[@id='user-name']");

    public static final By XPATH_BY_TEXT = By.xpath("//div[text()='Swag Labs']");

    public static final By XPATH_BY_PARTIAL_ATTR = By.xpath("//button[contains(@id,'add-to-cart')]");

    public static final By XPATH_BY_PARTIAL_TEXT = By.xpath("//div[contains(text(),'Sauce')]");

    public static final By XPATH_ANCESTOR = By.xpath("//div[@class='inventory_item_price']/ancestor::div[@class='inventory_item']");

    public static final By XPATH_DESCENDANT = By.xpath("//div[@id='inventory_container']//descendant::button");

    public static final By XPATH_FOLLOWING = By.xpath("//div[@class='inventory_item_name']/following::button[1]");

    public static final By XPATH_PARENT = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']/parent::div");

    public static final By XPATH_PRECEDING = By.xpath("//div[@class='inventory_item_price']/preceding::div[@class='inventory_item_name'][1]");

    public static final By XPATH_AND = By.xpath("//input[@id='user-name' and @type='text']");

    public static final By CSS_CLASS = By.cssSelector(".btn_inventory");

    public static final By CSS_TWO_CLASSES = By.cssSelector(".btn.btn_primary");

    public static final By CSS_DESCENDANT_CLASS = By.cssSelector(".inventory_list .inventory_item");

    public static final By CSS_ID = By.cssSelector("#user-name");

    public static final By CSS_TAG = By.cssSelector("input");

    public static final By CSS_TAG_CLASS = By.cssSelector("input.form_input");

    public static final By CSS_ATTR_EQUALS = By.cssSelector("[data-test='username']");

    public static final By CSS_ATTR_CONTAINS_WORD = By.cssSelector("[class~='btn_inventory']");

    public static final By CSS_ATTR_PREFIX_DASH = By.cssSelector("[class|='btn']");

    public static final By CSS_ATTR_STARTS_WITH = By.cssSelector("[id^='add-to-cart']");

    public static final By CSS_ATTR_ENDS_WITH = By.cssSelector("[id$='backpack']");

    public static final By CSS_ATTR_CONTAINS = By.cssSelector("[id*='sauce-labs']");
}
