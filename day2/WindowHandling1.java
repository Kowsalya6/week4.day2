package week4.day2;

	import java.io.File;
	import java.io.IOException;
	import java.time.Duration;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Set;

	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class WindowHandling1 {

		public static void main(String[] args) throws InterruptedException, IOException {
			ChromeDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.get("http://leaftaps.com/opentaps/control/login");
			driver.findElement(By.id("username")).sendKeys("demosalesmanager");
			driver.findElement(By.id("password")).sendKeys("crmsfa");
			driver.findElement(By.className("decorativeSubmit")).click();
			driver.findElement(By.partialLinkText("CRM/SFA")).click();
			driver.findElement(By.xpath("//a[text()='Contacts']")).click();
			driver.findElement(By.xpath("//a[text()='Merge Contacts'] ")).click();
			String windowHandle = driver.getWindowHandle();
			System.out.println(windowHandle);
			System.out.println(driver.getTitle());
			driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
			Set<String> windowHandles = driver.getWindowHandles();
			List<String> lst = new ArrayList<String>(windowHandles);
			driver.switchTo().window(lst.get(1));
			System.out.println(driver.getTitle());
			driver.manage().window().maximize();
			driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();
			driver.switchTo().window(lst.get(0));
			driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
			Set<String> windowHandles2 = driver.getWindowHandles();
			List<String> lst1= new ArrayList<String>(windowHandles2);
			driver.switchTo().window(lst1.get(1));
			driver.findElement(By.xpath("(//a[@class='linktext'])[6]")).click();
			driver.switchTo().window(lst1.get(0));
			driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
			Alert alert = driver.switchTo().alert();
			alert.accept();
			String title = driver.getTitle();
			System.out.println(title);	
			if(title.contains("View Contact"))
			{
				System.out.println("Successfully print the correct title");
			}
			else
			{
				System.out.println("Incorrect title");
			}
			
			File source = driver.getScreenshotAs(OutputType.FILE);
			File dest = new File("./snap/frame.png");
			FileUtils.copyFile(source, dest);
			
		}

	}

