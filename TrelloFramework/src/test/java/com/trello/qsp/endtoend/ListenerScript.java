package com.trello.qsp.endtoend;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.trello.qsp.genericutility.BaseClass;
import com.trello.qsp.genericutility.ListenerClass;
@Listeners(ListenerClass.class)
public class ListenerScript extends BaseClass {
@Test
public void method1() {
	Assert.assertEquals(false, false);
}
@Test
public void method2() {
	Assert.assertEquals(false, false);
}

@Test
public void method3() {
	Assert.assertEquals(false, true);
}

@Test
public void method4() {
	Assert.assertEquals(true, false);
}
@Test
public void method5() {
	Assert.assertEquals(false, false);
}

}
