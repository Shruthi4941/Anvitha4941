package com.trello.qsp.pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloCreateBoardsPage {
	WebDriver driver;

	public TrelloCreateBoardsPage(WebDriver driver) {
		this.driver = driver;
	PageFactory.initElements(driver, this);
	}	

	@FindBy(xpath = "//button[@aria-label='Show menu']")
	private WebElement showMenuOpt;
	
    public WebElement getShowMenuOpt() {
		return showMenuOpt;
	}

	public WebElement getCloseLink() {
		return closeLink;
	}

	public WebElement getCloseOpt() {
		return closeOpt;
	}

	public WebElement getPermanentlyDeleteBoard() {
		return permanentlyDeleteBoard;
	}

	public WebElement getDeleteOpt() {
		return deleteOpt;
	}

	public WebElement getConfirmDeleteButton() {
		return confirmDeleteButton;
	}

	@FindBy(xpath = "//a[contains(@class,'close-board')]") 
    private WebElement closeLink;
    
    @FindBy(xpath = "//input[@value='Close']") 
    private WebElement closeOpt;
    
    @FindBy(xpath = "//button[@data-testid='close-board-delete-board-button']") 
    private WebElement permanentlyDeleteBoard;
    
    @FindBy(xpath = "//button[text()='Delete']") 
    private WebElement deleteOpt;

    @FindBy(xpath = "//input[@value='Delete']") 
    private WebElement confirmDeleteButton;

}
