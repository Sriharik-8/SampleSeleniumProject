package selenium_Part_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Fullstack_Interview {

	public static void main(String[] args) throws InterruptedException

	{

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://movie-reviews-psi.vercel.app/");
		driver.manage().window().maximize();

		WebElement ele = driver.findElement(By.xpath(".//input[@placeholder='Search for your favorite movie']"));
		try {
			ele.sendKeys("Dhoom2");
			if (ele.isDisplayed()) {
				driver.findElement(By.xpath(".//div[@class='absolute bottom-4 right-4']//button")).click();
			}

			WebElement popup = driver.findElement(By.xpath("//div[@id='movie-add-modal']"));
			if (popup.isDisplayed()) {
				WebElement name = popup.findElement(By.xpath(".//input[@type='text']"));
				name.clear();
				name.sendKeys("Dhoom1");
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				String output = driver.findElement(By.xpath(".//div")).getText();
				System.out.println("Completed " + output);

			}
		} catch (Exception e) {
			System.out.println("printing the exception"+e);
		}
	}

}
