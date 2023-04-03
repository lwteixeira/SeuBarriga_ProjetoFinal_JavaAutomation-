package Validation;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;
import PageObjects.MovimentacaoPage;
import Report.Report;
import Report.Screenshot;

public class MovimentacaoValidation {

	private WebDriver driver;
	private MovimentacaoPage moviPage;

	public MovimentacaoValidation(WebDriver driver) {
		this.driver = driver;
		moviPage = new MovimentacaoPage(this.driver);
	}
	
	
	
	public void validationAlertSuccess(String message) {
        try {        	
            Assertions.assertEquals(message, moviPage.getAlertMoviAdd().getText());
            Report.log(Status.PASS, "Cadastro efetuado com Sucesso.", Screenshot.captureBase64(driver));
        } catch (Exception e) {
            Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));
        }
    }
}
