package testng;

import org.testng.annotations.Test;

@Test(groups = "Integration")
public class ClassB {
	public void boardsPage()
	{
		System.out.println("boardspage has been executed");
	}
	@Test(groups = "Functionality")
	public void loginToContinuePage()
	{
		System.out.println("loginToContinuePage has been executed");
	}

}
