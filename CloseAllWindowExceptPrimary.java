package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseAllWindowExceptPrimary {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/window.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		
		String mainWindow = driver.getWindowHandle();
		String mainWindowTitle = driver.getTitle();
		System.out.println("mainWindowTitle is " + mainWindowTitle);
		driver.findElement(By.xpath("//span[normalize-space()='Close Windows']")).click();
		
		Set<String> allWindows = driver.getWindowHandles();
		for (String h: allWindows) {
			driver.switchTo().window(h);
			String title = driver.getTitle();
			System.out.println("title1 is " + title);
			if(!title.equalsIgnoreCase(mainWindowTitle)) {
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow);
		

	}

}
