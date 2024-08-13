package com.trello.qsp.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloLogoutPage {
	WebDriver driver;

	public TrelloLogoutPage(WebDriver driver) {
		this.driver = driver;
	PageFactory.initElements(driver, this);
	}	
    

	public WebElement getAccountIcon() {
		return accountIcon;
	}

	public WebElement getLogoutOpt() {
		return logoutOpt;
	}

	public WebElement getLastLogout() {
		return lastLogout;
	}
	@FindBy(xpath = "//button[@data-test-id='header-member-menu-button']")
    private WebElement accountIcon;

    @FindBy(xpath = "//button[@data-test-id='header-member-menu-logout']")
    private WebElement logoutOpt;

    @FindBy(xpath = "//button[@id='logout-submit']")
    private WebElement lastLogout;
}
