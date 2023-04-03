package Validation;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import PageObjects.LoginPage;
import Report.Report;
import Report.Screenshot;

public class LoginValidation {

	private WebDriver driver;
	private LoginPage loginPage;

	public LoginValidation(WebDriver driver) {
		this.driver = driver;
		loginPage = new LoginPage(this.driver);
	}
	
	
    public void validationLoginOK(String nome) {
        try {
            Assertions.assertTrue(loginPage.getAlertLoginOK(nome).isDisplayed());
            Report.log(Status.PASS, "Login efetuado com sucesso.", Screenshot.captureBase64(driver));
        } catch (Exception e) {
            Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));
        }
    }
    
    public void validationAlertCadUserOK() {
        try {
            Assertions.assertTrue(loginPage.getAlertCadNewUserOK().isDisplayed());
            Report.log(Status.PASS, "Usuario cadastrado com sucesso.", Screenshot.captureBase64(driver));
        } catch (Exception e) {
            Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));
        }
    }
    
    public void validationLogoSeuBarriga() {
        try {
            Assertions.assertTrue(loginPage.getLogoSeuBarriga().isDisplayed());
            Report.log(Status.PASS, "Você está na pagina de login.", Screenshot.captureBase64(driver));
        } catch (Exception e) {
            Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));
        }
    }
    
    public void validationAlertUserExisting() {
        try {
            Assertions.assertTrue(loginPage.getAlertUserExisting().isDisplayed());
            Report.log(Status.PASS, "Usuário existente.", Screenshot.captureBase64(driver));
        } catch (Exception e) {
            Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));
        }
    }
    
    public void validationAlertLoginUserInvalid() {
        try {
            Assertions.assertTrue(loginPage.getAlertLoginUserInvalido().isDisplayed());
            Report.log(Status.PASS, "Usuário Inválido OK.", Screenshot.captureBase64(driver));
        } catch (Exception e) {
            Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));
        }
    }
}
