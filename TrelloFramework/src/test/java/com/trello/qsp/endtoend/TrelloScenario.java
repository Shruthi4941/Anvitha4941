package com.trello.qsp.endtoend;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.trello.qsp.genericutility.BaseClass;
import com.trello.qsp.genericutility.ListenerClass;
import com.trello.qsp.pomrepo.TrelloBoardsPage;
import com.trello.qsp.pomrepo.TrelloCreateBoardsPage;
import com.trello.qsp.pomrepo.TrelloHomePage;
import com.trello.qsp.pomrepo.TrelloLoginPage;
import com.trello.qsp.pomrepo.TrelloLogoutPage;
@Listeners(ListenerClass.class)
public class TrelloScenario extends BaseClass {
@Test
public void createAndDeleteBoard() throws IOException, InterruptedException {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	TrelloHomePage homepage = new TrelloHomePage(driver);
	TrelloLoginPage loginpage = new TrelloLoginPage(driver); 
	TrelloBoardsPage boardspage = new TrelloBoardsPage(driver);
	TrelloCreateBoardsPage createBoardsPage = new TrelloCreateBoardsPage(driver);
	TrelloLogoutPage logoutpage = new TrelloLogoutPage(driver);
	
	homepage.getLoginLink().click();
	Thread.sleep(3000);
	loginpage.getUsernameTextField().sendKeys(fileutils.readTheDataFromPropertyFile("username"));
	loginpage.getContinueButton().submit();
	
	loginpage.getPasswordTextField().sendKeys(fileutils.readTheDataFromPropertyFile("password"));
	loginpage.getLoginButton().submit();
	
	boardspage.getCreateNewBoardOpt().click();
	boardspage.getBoardTitleTextField().sendKeys(fileutils.readTheDataFromPropertyFile("boardtitle"));
	
	//wait.until(ExpectedConditions.visibilityOf(boardspage.getCreateButton));
	wait.until(ExpectedConditions.elementToBeClickable(boardspage.getCreateButton())).click();
	
	createBoardsPage.getShowMenuOpt().click();
	createBoardsPage.getCloseLink().click();
	createBoardsPage.getCloseOpt().click();
	createBoardsPage.getPermanentlyDeleteBoard().click();
	createBoardsPage.getDeleteOpt().click();
	
	boardspage.getAccountIcon().click();
	boardspage.getLogoutOpt().click();
	
	logoutpage.getLastLogout().submit();
	//Assert.assertEquals(driver.getTitle(), "Manage Your Team's Projects From Anywhere | Trello", "HomePage is not verified");
	Assert.assertEquals(driver.getTitle(), "Manage Your Team's Projects From Anywhere | Trello", "HomePage is not verified");
	
}
}
