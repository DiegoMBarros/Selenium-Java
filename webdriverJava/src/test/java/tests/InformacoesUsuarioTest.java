package tests;

import org.apache.xmlbeans.impl.tool.Extension.Param;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import suporte.Generator;
import suporte.Screenshot;
import suporte.Web;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InformacoesUsuarioTestData.csv")
public class InformacoesUsuarioTest {
	private WebDriver navegador;
	
	@Rule
	public TestName test = new TestName();
	
	@Before
	public void setUp() {
////		Abrindo o navegador
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\f413378\\drivers\\chromedriver.exe");
////		WebDriver navegador = new ChromeDriver();
//		navegador = new ChromeDriver();
////		navegador.manage().window().maximize();
//		navegador.manage().window().setSize(new Dimension(1280, 800));
//		navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //Configuração do tempo de espera para encontrar os elementos
//		
////		Navegando para a página do Taskit
//		navegador.get("http://www.juliodelima.com.br/taskit");
//		
//		navegador = Web.createChrome();
//		
////		Clicar no link que possui o texto "Sign in"
//		navegador.findElement(By.linkText("Sign in")).click();
//		
////		Identificando o formulário de login
//		WebElement formularioSignInBox = navegador.findElement(By.id("signinbox"));
//
////		Digitar no campo com name "login" que está dentro do formulário de id "signinbox" o texto "diego0001"
//		formularioSignInBox.findElement(By.name("login")).sendKeys("julio0001");
		
//		Clicar no campo com name "password" que está dentro do formulário de id "signinbox" o texto "123456"
		formularioSignInBox.findElement(By.name("password")).sendKeys("123456");
		
//		Clicar no link que possui o texto "SIGN IN"
		navegador.findElement(By.linkText("SIGN IN")).click();
		
//		Validar que dentro do elemento com class "me" está o texto "Hi, Diego"
		WebElement me = navegador.findElement(By.className("me"));
		String textoNoElementoMe = me.getText();
		assertEquals("Hi, Julio", textoNoElementoMe);
		
//		Clicar em um link que tenha a class "me"
		navegador.findElement(By.className("me")).click();
		
//		Clicar em um link que possua "MORE DATA ABOUT YOU"
		navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
	}
	
	@Test
	public void testAdicionarUmaInformacaoDoUsuario(@org.easetech.easytest.annotation.Param(name="tipo")String tipo,@org.easetech.easytest.annotation.Param(name="contato")String contato, @org.easetech.easytest.annotation.Param(name="mensagem")String mensagem_esperada) {

////		Clicar no link que possui o texto "Sign in"
//		navegador.findElement(By.linkText("Sign in")).click();
////		WebElement linkSignIn = navegador.findElement(By.linkText("Sign in"));
////		linkSignIn.click();
//		
////		Identificando o formulário de login
//		WebElement formularioSignInBox = navegador.findElement(By.id("signinbox"));
//
////		Digitar no campo com name "login" que está dentro do formulário de id "signinbox" o texto "diego0001"
//		formularioSignInBox.findElement(By.name("login")).sendKeys("julio0001");
//		
////		Clicar no campo com name "password" que está dentro do formulário de id "signinbox" o texto "123456"
//		formularioSignInBox.findElement(By.name("password")).sendKeys("123456");
//		
////		Clicar no link que possui o texto "SIGN IN"
//		navegador.findElement(By.linkText("SIGN IN")).click();
//		
////		Validar que dentro do elemento com class "me" está o texto "Hi, Diego"
////		WebElement me = navegador.findElement(By.className("me"));
////		String textoNoElementoMe = me.getText();
////		assertEquals("Hi, Julio", textoNoElementoMe);
//		
////		Clicar em um link que tenha a class "me"
//		navegador.findElement(By.className("me")).click();
//		
////		Clicar em um link que possua "MORE DATA ABOUT YOU"
//		navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
		
//		Clicar no botão através do seu xpath //button[@data-target="addmoredata"]
		navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();
//		navegador.findElement(By.xpath("//button[@data-target='addmoredata']")).click(); (pode ser usado com aspas simples)
		
//		Identificar a popup onde está o formulário de id addmoredata
		WebElement popupAddMoreData = navegador.findElement(By.id("addmoredata"));
		
//		Na combo de name "type" escolher a opção "Phone"
		WebElement campoType = popupAddMoreData.findElement(By.name("type"));
//		new Select(campoType).selectByVisibleText("Phone");
		new Select(campoType).selectByVisibleText(tipo);
		
//		No campo de name "contact" digitar "+5561999999999"
//		popupAddMoreData.findElement(By.name("contact")).sendKeys("+5561999999999");
		popupAddMoreData.findElement(By.name("contact")).sendKeys(contato);
		
//		Clicar no link de text "SAVE" que está na popup
		popupAddMoreData.findElement(By.linkText("SAVE")).click();
		
//		Na mensagem de id "toast-container" validar que o texto é "Your contact has been added"
		WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
		String mensagem = mensagemPop.getText();
//		assertEquals("Your contact has been added!", mensagem);
		assertEquals(mensagem_esperada, mensagem);
		
//		Validação Exemplo
		assertEquals(1, 1);
	}
	
	@Test
	public void removerUmContatoDeUmUsuario() {
//		Clicar no elemeto pelo seu xpath //span[text()="+551133334444"]/following-sibling::a (Excluir)
		navegador.findElement(By.xpath("//span[text()='+551133334444']/following-sibling::a")).click();
		
//		Confirmar a janela javascript
		navegador.switchTo().alert().accept();
		
//		Validar que a mensagem apresentada foi Rest in peace, dear phone!
		WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
		String mensagem = mensagemPop.getText();
		assertEquals("Rest in peace, dear phone!", mensagem);
		
		String screenshotArquivo = "/Users/f413378/Documents/Estudo/test-report/taskit/" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
		Screenshot.tirar(navegador, screenshotArquivo);
				
//		Aguardar até 10 segundos para que a janela desapareça
		WebDriverWait aguardar = new WebDriverWait(navegador, 10);
		aguardar.until(ExpectedConditions.stalenessOf(mensagemPop));
		
//		Clicar no link com texto "Logout
		navegador.findElement(By.linkText("Logout")).click();
	}
	
	@After
	public void tearDown() throws InterruptedException {
//		Clicar no link com texto "Logout
		navegador.findElement(By.linkText("Logout")).click();
		Thread.sleep(3000);
//		fechar o navegador
		navegador.quit(); //Fecham todas as abas
//		navegador.close(); //Fecha apenas uma aba
	}
}
