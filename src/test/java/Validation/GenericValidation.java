package Validation;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import PageObjects.GenericPage;
import Report.Report;
import Report.Screenshot;

public class GenericValidation {

	
	private WebDriver driver;
	private GenericPage genericPage;

	public GenericValidation(WebDriver driver) {
		this.driver = driver;
		genericPage = new GenericPage(this.driver);
	}
	
    public void validationAlertSuccess() {
        try {
            Assertions.assertTrue(genericPage.getAlertSuccessMessage().isDisplayed());
            Report.log(Status.PASS, "Cadastro efetuado com Sucesso.", Screenshot.captureBase64(driver));
        } catch (Exception e) {
            Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));
        }
    }
    
    public void validationAlertError() {
        try {
            Assertions.assertTrue(genericPage.getAlertErrorMessage().isDisplayed());
            Report.log(Status.PASS, "Nome ou e-mail ja existente.", Screenshot.captureBase64(driver));
        } catch (Exception e) {
            // TODO: handle exception
            Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));
        }
         
    }
}
