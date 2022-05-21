package week5.day1;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class LearnAttributes {
	@Test
	public void b() {
		System.out.println("Test 1");
	}
	
	@Test
	public void a() {
		System.out.println("Test 2");
	}
	
	@Test(invocationCount = 7,invocationTimeOut = 5000,threadPoolSize = 2 )
	public void c() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Test 3");
	}
	/*
	 * (enabled = false) -> @Ignore
	 * (priority = -1)
	 */
}
