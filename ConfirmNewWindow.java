package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConfirmNewWindow {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/window.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));

		driver.findElement(By.xpath("//span[normalize-space()='Open']")).click();

		Set<String> set = driver.getWindowHandles();
		System.out.println("set is " + set);
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		List<String> list = new ArrayList<>(set);
		list.addAll(set);
		System.out.println("list is " + list);
		String firstWindow = list.get(1);
		driver.switchTo().window(firstWindow);
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		if (driver.getCurrentUrl().equals("https://leafground.com/dashboard.xhtml")) {
			System.out.println("new window is opened");
		}else {
			System.out.println("new window is not opened");
		}
		
		
		


	}




}
