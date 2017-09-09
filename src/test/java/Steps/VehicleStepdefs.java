package Steps;

import Base.BaseUtil;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.omg.CORBA.DATA_CONVERSION;
import org.openqa.selenium.By;

import java.util.List;

public class VehicleStepdefs extends BaseUtil{

    private BaseUtil base;

    public VehicleStepdefs(BaseUtil base) {
        this.base = base;
    }

    @Given("^I navigate to the vehicle inquiry page of DVLA$")
    public void iNavigateToTheVehicleInformationPageOfDVLA() throws Throwable {
        base.Driver.navigate().to("https://vehicleenquiry.service.gov.uk/");
    }

    @When("^I enter ([^\"]*)$")
    public void iEnterCarReg(String CarReg) throws Throwable {
        base.Driver.findElement(By.name("Vrm")).sendKeys(CarReg);
        base.Driver.findElement(By.name("Continue")).click();
    }

    @Then("^I should see ([^\"]*) and ([^\"]*)$")
    public void iShouldSeeMakeAndColour(String Make, String Colour) throws Throwable {
        String carMake = base.Driver.findElement(By.xpath("//div[@id='pr3']/div/ul/li[2]/span[2]")).getText();
        String carColour = base.Driver.findElement(By.xpath("//div[@id='pr3']/div/ul/li[3]/span[2]")).getText();

        System.out.println(carMake);
        System.out.println(carColour);

        Assert.assertTrue(carMake.contains(Make));
        Assert.assertTrue(carColour.contains(Colour));
    }
}
