package testng;

import org.testng.annotations.Test;

public class ClassA {
@Test(groups = "Smoke")
public void login()
{
	System.out.println("login has been executed");
}
@Test(groups = "Functionality")
public void logout()
{
	System.out.println("logout has been executed");
}
@Test(groups = {"Smoke" , "Functionality"})
public void home()
{
	System.out.println("home has been executed");
}

}
