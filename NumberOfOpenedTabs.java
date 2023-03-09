package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class NumberOfOpenedTabs {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/window.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));

		driver.findElement(By.xpath("//span[normalize-space()='Open Multiple']")).click();
		Set<String> allWindows = driver.getWindowHandles();
		List<String> list = new ArrayList<>(allWindows);
		list.addAll(allWindows);
		int count = list.size();
		System.out.println("No of opened tabs " + count);
		

	}

}
