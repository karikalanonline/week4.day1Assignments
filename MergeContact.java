package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;

//import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MergeContact {


	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");

		driver.findElement(By.id("password")).sendKeys("crmsfa");

		driver.findElement(By.className("decorativeSubmit")).click();

		driver.findElement(By.linkText("CRM/SFA")).click();

		driver.findElement(By.xpath("//div[@class='x-panel-header']/a[contains(text(),'Contacts')]")).click();

		driver.findElement(By.xpath("//ul[@class='shortcuts']//a[contains(text(), 'Merge Contacts')]")).click();

		//String mainWindow = driver.getWindowHandle();

		driver.findElement(By.xpath("(//a/img[@alt='Lookup'])[1]")).click();
		Set <String > set = driver.getWindowHandles();
		List<String> list = new ArrayList<>(set);
		String window1 = list.get(1);
		driver.switchTo().window(window1);
		driver.manage().window().maximize();
        driver.findElement(By.xpath("(//div[@class ='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
        driver.switchTo().window(list.get(0));

		driver.findElement(By.xpath("(//a/img[@alt='Lookup'])[2]")).click();
		Set <String > set1 = driver.getWindowHandles();
		List<String> list1 = new ArrayList<>(set1);
		String window2 = list1.get(1); 
		driver.switchTo().window(window2);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//div[@class ='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click();
		 driver.switchTo().window(list.get(0));
		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		String title = driver.getTitle();
		System.out.println("Page Tile is " + title);
		if (title.equals("View Contact | opentaps CRM")) {
			System.out.println("True");
		}else{
			System.out.println("False");
		}


	}

}
