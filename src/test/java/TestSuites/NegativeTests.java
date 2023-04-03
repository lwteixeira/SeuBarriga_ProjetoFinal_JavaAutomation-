package TestSuites;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import TestCases.RealizaCadastroUsuarioExistenteTest;
import TestCases.RealizarLoginComUserInvalidoTest;

@Suite
@SelectClasses({RealizaCadastroUsuarioExistenteTest.class,RealizarLoginComUserInvalidoTest.class})
public class NegativeTests {

	
}
