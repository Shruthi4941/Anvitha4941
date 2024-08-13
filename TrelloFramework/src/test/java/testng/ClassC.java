package testng;

import org.testng.annotations.Test;

public class ClassC {
	@Test(groups = "Smoke")
	public void createBoardsPage()
	{
		System.out.println("createBoardsPage has been executed");
	}
	@Test(groups = "Smoke")
	public void deleteBoardsPage()
	{
		System.out.println("deleteBoardsPage has been executed");
	}

}
