package com.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DwsRegister {
public DwsRegister(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(className = "ico-register")
 private	WebElement register_Link;
@FindBy(id = "gender-male")
private WebElement male;

@FindBy(id = "gender-female")
private WebElement female;

@FindBy(name = "FirstName")
private WebElement firstName;

@FindBy(name = "LastName")
private WebElement lastName;

@FindBy(id = "Email")
private WebElement email;

@FindBy(id = "Password")
private WebElement password;

@FindBy(id = "ConfirmPassword")
private WebElement confirmPassword;

@FindBy(id = "register-button")
private WebElement register_button;

public void register(String fName,String LastName,String  email1,String pass) {
	register_Link.click();
	male.click();
	firstName.sendKeys(fName);
	lastName.sendKeys(LastName);
	email.sendKeys(email1);
	password.sendKeys(pass);
	confirmPassword.sendKeys(pass);
	register_button.click();

}
}
