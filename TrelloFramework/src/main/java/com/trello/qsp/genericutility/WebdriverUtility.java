package com.trello.qsp.genericutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

public class WebdriverUtility {
public void implicitWait(WebDriver driver) {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
}
}