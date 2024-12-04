package com.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DwsLogin {
	public DwsLogin(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "ico-login")
	private WebElement login_link;
	
	@FindBy(id = "Email")
	private WebElement email;
	
	@FindBy(id = "Password")
	private WebElement password;
	
	@FindBy(css = "input[id='RememberMe']")
	private WebElement rememberme;
	
	@FindBy(xpath = "//input[@value='Log in']")
	private WebElement login_button;
	
//	public void login_link() {
//		login_link.click();
//	}
//	
//	public void email(String data) {
//		email.sendKeys(data);
//	}
//	
//	public void password(String data) {
//		password.sendKeys(data);
//	}
//	
//	public void rememberme() {
//		rememberme.click();
//	}
//	
//	public void login_Button() {
//		login_button.click();
//	}
	
	public void login(String email1,String pass) {
		login_link.click();
		email.sendKeys(email1);
		password.sendKeys(pass);
		rememberme.click();
		login_button.click();
	}
}
