package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling2 {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.leafground.com/window.xhtml");
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> lst = new ArrayList<String>(windowHandles);
		driver.switchTo().window(lst.get(1));
		driver.close();
		driver.switchTo().window(lst.get(0));
		String title = driver.getTitle();
		driver.findElement(By.xpath("//span[text()='Close Windows']")).click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> lst1 = new ArrayList<String>(windowHandles2);
		driver.switchTo().window(lst1.get(1));
		driver.close();
		driver.switchTo().window(lst1.get(2));
		driver.close();
		driver.switchTo().window(lst1.get(3));
		driver.close();
		driver.switchTo().window(lst1.get(0));
		driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
		Set<String> windowHandles3 = driver.getWindowHandles();
		List<String> lst2=new ArrayList<String>(windowHandles3);
		driver.switchTo().window(lst2.get(1));
		driver.close();
		driver.switchTo().window(lst2.get(2));
		driver.close();
		driver.switchTo().window(lst2.get(0));
		driver.findElement(By.xpath("//span[text()='Open with delay']")).click();
		Set<String> windowHandles4 = driver.getWindowHandles();
		List<String> lst3=new ArrayList<String>(windowHandles4);
		driver.switchTo().window(lst3.get(1));
		driver.close();
		driver.switchTo().window(lst3.get(2));
		driver.close();
		driver.switchTo().window(lst2.get(0));
		String title1 = driver.getTitle();
		if(title1.equals(title))
		{
			System.out.println("Matched");
		}
		else
		{
			System.out.println("Not matched");
		}

	}

}

