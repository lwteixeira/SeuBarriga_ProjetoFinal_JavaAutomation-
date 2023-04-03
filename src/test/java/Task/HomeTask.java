package Task;

import org.openqa.selenium.WebDriver;


import Framework.Utils.FileOperation;
import PageObjects.GenericPage;
import PageObjects.HomePage;
import Validation.HomeValidation;


public class HomeTask {

	private WebDriver driver;
	private HomePage homePage;
	private GenericPage genericPage;

	private HomeValidation homeValidation;
	private static String alertMessage;

	public HomeTask(WebDriver driver) {
		this.driver = driver;
		homePage = new HomePage(this.driver);
		genericPage = new GenericPage(this.driver);
		homeValidation = new HomeValidation(this.driver);
		alertMessage = FileOperation.getProperties("home").getProperty("alertValid");
	}
	
	public void adicionarContas(String conta) {
	    homePage.getButtonContas().click();
	    homePage.getLinkAddContas().click();
	    homePage.getInputNomeConta().sendKeys(conta);
	    genericPage.getButtonSubmit().click();
	    homeValidation.validationAlertContaAddOK(alertMessage);
	}
	
	public void verificaListaConta() {
		homePage.getButtonContas().click();
		homePage.getLinkListarContas().click();
		homeValidation.validationListContasAdd();
	}
	

}