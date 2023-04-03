package Task;

import org.openqa.selenium.WebDriver;

import Framework.Utils.FakersGeneration;
import Framework.Utils.FileOperation;
import PageObjects.GenericPage;
import PageObjects.LoginPage;
import Validation.LoginValidation;

public class LoginTask {

	private WebDriver driver;
	private LoginPage loginPage;
	private FakersGeneration faker;
	private LoginValidation loginValidation;
	private GenericPage genericPage;

	public LoginTask(WebDriver driver) {
		this.driver = driver;
		loginPage = new LoginPage(this.driver);
		faker = new FakersGeneration();
		loginValidation = new LoginValidation(this.driver);
		genericPage = new GenericPage(this.driver);
	}

	public void efetuarCadastro() {

		String nome = faker.getName();
		String email = faker.getEmail();
		String senha = faker.getSenha();
		FileOperation.setProperties("form", "nome", nome);
		FileOperation.setProperties("form", "email", email);
		FileOperation.setProperties("form", "senha", senha);

		loginPage.getButtonNovoUsuario().click();
		genericPage.getInputNome().sendKeys(nome);
		loginPage.getInputEmail().sendKeys(email);
		loginPage.getInputPassword().sendKeys(senha);
		loginPage.getButtonCadastrar().click();
		loginValidation.validationAlertCadUserOK();
	}

	public void efetuarLogin() {
		String email = FileOperation.getProperties("form").getProperty("email");
		String senha = FileOperation.getProperties("form").getProperty("senha");
		String nome = FileOperation.getProperties("form").getProperty("nome");
		loginPage.getInputEmail().sendKeys(email);
		loginPage.getInputPassword().sendKeys(senha);
		genericPage.getButtonSubmit().click();
		loginValidation.validationLoginOK(nome);
	}

	public void efetuarCadastroUserExistent() {

		String nome = FileOperation.getProperties("login").getProperty("nome");
		String email = FileOperation.getProperties("login").getProperty("email");
		String senha = FileOperation.getProperties("login").getProperty("senha");
		loginPage.getButtonNovoUsuario().click();
		genericPage.getInputNome().sendKeys(nome);
		loginPage.getInputEmail().sendKeys(email);
		loginPage.getInputPassword().sendKeys(senha);
		loginPage.getButtonCadastrar().click();
		loginValidation.validationAlertUserExisting();
	}
	
	public void efetuarLoginUsuarioInvalido() {
		String email = FileOperation.getProperties("login").getProperty("emailInvalid");
		String senha = FileOperation.getProperties("login").getProperty("senhaInvalid");
		loginPage.getInputEmail().sendKeys(email);
		loginPage.getInputPassword().sendKeys(senha);
		genericPage.getButtonSubmit().click();
		loginValidation.validationAlertLoginUserInvalid();
	}

}
