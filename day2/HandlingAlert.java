package week4.day2;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAlert {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.leafground.com/alert.xhtml");
		driver.findElement(By.xpath("(//span[text()='Show'])[1]")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		String text2 = driver.findElement(By.xpath("//span[@id='simple_result']")).getText();
		System.out.println(text2);
		driver.findElement(By.xpath("(//span[text()='Show'])[2]")).click();
        Alert alert2 = driver.switchTo().alert();
        alert2.accept();
        String text = driver.findElement(By.xpath("//span[@id='result']")).getText();
        System.out.println(text);
        driver.findElement(By.xpath("(//span[text()='Show'])[5]")).click();
        Alert alert3 = driver.switchTo().alert();
        alert3.sendKeys("Hi TestLeaf");
        alert.accept();
        String text3 = driver.findElement(By.xpath("//span[@id='confirm_result']")).getText();
        System.out.println(text3);
        driver.findElement(By.xpath("//span[text()='Delete']")).click();
        driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
        
	}

}
