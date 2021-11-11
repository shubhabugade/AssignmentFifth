package fifthScenario;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Datatable1 {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeTest
	public void beforeTest() {

		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);
	}

	@Test(priority = 1)
	// a.Fetch 1st 25 entries from the table.
	public void entries() throws InterruptedException {
		driver.get("https://datatables.net/");
		List<WebElement> entries = driver.findElements(By.xpath("//select[@name='example_length']/option"));
		System.out.println("total dropdown values " + entries.size());
		entries.get(1).click();
		System.out.println("clicked on dropdown and selected first 25 entries " + entries.get(1));

		// b. Do sort on Age column young to old
		driver.findElement(By.xpath("//table[@id='example']//th[4]")).click();
		System.out.println("25 entries sorted as per the age young to old");

		// find employee name from name column
		List<WebElement> Name = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[1]"));
		Name.size();
		// find software engg position from postion column

		List<WebElement> Position = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[2]"));
		Position.size();
		// find employee name from name column

		List<WebElement> Office = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[3]"));
		Office.size();
		// finding the Age of employeee
		List<WebElement> Age = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[4]"));
		Age.size();

		List<WebElement> StartDate = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[5]"));
		StartDate.size();

		for (int i = 0; i < Name.size(); i++) {
			System.out.println("Employee Name:" + Name.get(i).getText() + " Position:" + Position.get(i).getText()
					+ " Officelocation:" + Office.get(i).getText() + " Age:" + Age.get(i).getText() + "  StartDate "
					+ StartDate.get(i).getText());
	
			
			}
		
		System.out.println("All 25 entries are printed on console First test executed");

		}


	@Test(priority = 2)
	// Fetch name, position, office, age and salary details of the Software
	// Engineers of below 30 years
	public void dataofSoftengg() {
		// clicking on dropdown to fetch all entries from datatable
		List<WebElement> entries1 = driver.findElements(By.xpath("//select[@name='example_length']/option"));
		System.out.println("Execution of 2nd case started");

		entries1.get(3).click();
		System.out.println("clicked on dropdown and fetched all entries in one page " + entries1.get(3));

		// find employee name from name column
		
		List<WebElement> Name = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[1]"));
		Name.size();
		
		// find software engg position from postion column

		List<WebElement> Position = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[2]"));
		Position.size();
		String expectedposition = "Software Engineer";
		// find employee name from name column

		List<WebElement> Office = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[3]"));
		Office.size();
		// finding the Age of employeee
		List<WebElement> Age = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[4]"));
		Age.size();

		for (int i = 0; i < Position.size(); i++) {
			if (Position.get(i).getText().equalsIgnoreCase(expectedposition))
			
			{
				if (Integer.parseInt( Age.get(i).getText()) < 30)
				{

				System.out.println("Employee Name:" + Name.get(i).getText() + " Position:" + Position.get(i).getText()
				+ " Officelocation:" + Office.get(i).getText() + " Age:" + Age.get(i).getText());
			}}
		}

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
