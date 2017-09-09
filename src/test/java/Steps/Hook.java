package Steps;

import Base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hook extends BaseUtil{

    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void InitializeTest()

    {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); //please set path to chromedriver
        base.Driver = new ChromeDriver();;
    }

    @After
    public void TearDownTest(Scenario scenario)
    {
        base.Driver.quit();
    }
}
