package com.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DwsHomePage {
public DwsHomePage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(className = "header-logo")
private WebElement dwsIcon;

@FindBy(className = "ico-register")
private	WebElement register_Link;

@FindBy(className = "ico-login")
private WebElement login_link;

@FindBy(xpath = "//span[text()='Wishlist']")
private WebElement wishList;

@FindBy(xpath = "//span[text()='Shopping cart']")
private WebElement cart;

@FindBy(id = "small-searchterms")
private WebElement search;

@FindBy(xpath = "//input[@value='Search']")
private WebElement search_button;

@FindBy(xpath = "//a[contains(text(),'Books')]")
private WebElement books_link;

@FindBy(xpath = "//a[contains(text(),'Computers')]")
private WebElement computers_link;

@FindBy(xpath = "//a[contains(text(),'Electronics')]")
private WebElement Electronics_link;

@FindBy(xpath = "//a[contains(text(),'Apparel & Shoes')]")
private WebElement shoes_link;

@FindBy(xpath = "//a[contains(text(),'Digital downloads')]")
private WebElement digitalDownload_link;

@FindBy(xpath = "//a[contains(text(),'Jewelry')]")
private WebElement jewelry_link;

@FindBy(xpath = "//a[contains(text(),'Gift Cards')]")
private WebElement GiftCards_link;

@FindBy(xpath = "//a[contains(text(),'Facebook')]")
private WebElement facebook_link;

@FindBy(id = "pollanswers-1")
private WebElement excellent;

@FindBy(id = "pollanswers-2")
private WebElement good;

@FindBy(id = "pollanswers-3")
private WebElement poor;

@FindBy(id = "pollanswers-4")
private WebElement very_bad;

@FindBy(xpath = "//a[contains(text(),'Twitter')]")
private WebElement twitter_link;

@FindBy(xpath = "//a[contains(text(),'RSS')]")
private WebElement rss_link;

@FindBy(xpath = "//a[contains(text(),'YouTube')]")
private WebElement youTube_link;

@FindBy(xpath = "//a[contains(text(),'Google+')]")
private WebElement google_link;


}
