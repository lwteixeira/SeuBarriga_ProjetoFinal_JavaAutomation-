package TestCases;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import Framework.TestBase;
import Report.Report;
import Report.ReportType;
import Report.Screenshot;
import Task.LoginTask;



public class RealizaCadastroUsuarioExistenteTest extends TestBase {

	private WebDriver driver = getDriverManager();
	LoginTask loginTask = new LoginTask(driver);
	
	@Test
	public void realizarCadastroUsuarioExistente() {
		try {
			Report.createTest("Realizar cadastro de usuário existente.", ReportType.SINGLE);
			Report.createStep("Realizar Cadastro novo Usuário");
			loginTask.efetuarCadastroUserExistent();
		} catch (Exception e) {
			// TODO: handle exception
			Report.log(Status.FAIL, e.getMessage(), Screenshot.capture(driver));
		}
	}
}
