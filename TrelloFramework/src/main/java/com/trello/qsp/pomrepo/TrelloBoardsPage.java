package com.trello.qsp.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloBoardsPage {
	WebDriver driver;

	public TrelloBoardsPage(WebDriver driver) {
		this.driver = driver;
	PageFactory.initElements(driver, this);
	}	

	@FindBy(xpath = "//span[text() ='Create new board']")
	private WebElement createNewBoardOpt;
	
	public WebElement getCreateNewBoardOpt() {
		return createNewBoardOpt;
	}


	public WebElement getBoardTitleTextField() {
		return boardTitleTextField;
	}


	public WebElement getCreateButton() {
		return createButton;
	}

	@FindBy(xpath = "//input[@data-testid='create-board-title-input']")
	private WebElement boardTitleTextField;
	
	
	@FindBy(xpath = "//button[@data-testid='create-board-submit-button']")
	private WebElement createButton;
	
	@FindBy(xpath = "//div[@data-testid='header-member-menu-avatar']")
	private WebElement accountIcon;
	
	public WebElement getAccountIcon() {
		return accountIcon;
	}


	public WebElement getLogoutOpt() {
		return logoutOpt;
	}

	@FindBy(xpath = "//span[text() = 'Log out']")
	private WebElement logoutOpt;
	
	
	}
	
