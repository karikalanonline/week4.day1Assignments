package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class WaitForTwoNewTabs {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/window.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));

		String mainWindow = driver.getWindowHandle();
		String mainWindowTitle = driver.getTitle();
		System.out.println("mainWindowTitle is " + mainWindowTitle);
		driver.findElement(By.xpath("//span[normalize-space()='Open with delay']")).click();
		Thread.sleep(4000);
        Set<String> allWindows = driver.getWindowHandles();
        List<String> list = new ArrayList<>(allWindows);
        list.addAll(allWindows);
        driver.switchTo().window(list.get(1));
        driver.manage().window().maximize();
	}

}
