package Test.Olenick.AlMundo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//@RunWith(value = Parameterized.class)

public class firstFlightTest {

	public WebDriver driver;

	/*
	 * @Parameters public static Iterable<Object[]> getData() {
	 * 
	 * return Arrays.asList(new Object[][] { {"1","2","3"} });
	 * 
	 * List<Object[]> obj = new ArrayList<Object[][]>();
	 * 
	 * obj.add(new Object[] { "Aca van los parametros" }); obj.add(new Object[] {
	 * "Aca van los parametros" }); obj.add(new Object[] { "Aca van los parametros"
	 * }); obj.add(new Object[] { "Aca van los parametros" }); obj.add(new Object[]
	 * { "Aca van los parametros" });
	 * 
	 * return obj; }
	 */
	@Before
	public void setUp() throws Exception {

		System.setProperty("webdriver.chrome.driver", "./src/resources/chromedriver/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.almundo.com.ar");

	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {

		alMundoFlightsHomePage alMundoHome;
		alMundoResultsPage alMundoResults;

		alMundoHome = new alMundoFlightsHomePage(driver);
		alMundoResults = new alMundoResultsPage(driver);
		

		Flight newTest = new FlightBuilder().flightOrigin("Río de Janeiro, Brasil")
				.flightDestination("Buenos Aires, Argentina").flightTypeFrom("city").flightMonthFrom("Junio 2020")
				.flightDateFrom("10").flightTypeTo("city").flightMonthTo("Septiembre 2020").flightDateTo("20")
				.flightAdultNumber(3).flightChildrenNumber(4).flightAgeIndex(2).flightClass("Business").build();

		alMundoHome.waitForHomePage();
		alMundoHome.searchForFlight(newTest);
		Thread.sleep(6000);
		assertTrue(alMundoResults.isDisplayed());
	}

}
