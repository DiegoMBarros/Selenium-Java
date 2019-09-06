package suporte;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Web {
	 public static final String USERNAME = "diegomacdo1";
	  public static final String AUTOMATE_KEY = "kjjeTrrPcyVvofNSBeDB";
	  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
	public static WebDriver createChrome() {
//		Abrindo o navegador
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\f413378\\drivers\\chromedriver.exe");
//		WebDriver navegador = new ChromeDriver();
		WebDriver navegador = new ChromeDriver();
//		navegador.manage().window().maximize();
		navegador.manage().window().setSize(new Dimension(1280, 800));
		navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //Configuração do tempo de espera para encontrar os elementos
		
//		Navegando para a página do Taskit
		navegador.get("http://www.juliodelima.com.br/taskit");
		
		return navegador;
	}
	
	public static WebDriver createBrowserStack() {
		 DesiredCapabilities caps = new DesiredCapabilities();
		 caps.setCapability("browser", "Chrome");
		 caps.setCapability("browser_version", "60.0");
		 caps.setCapability("os", "Windows");
		 caps.setCapability("os_version", "10");
		 caps.setCapability("resolution", "1280x800");
		 caps.setCapability("browserstack.debug", "true");
		 
		 WebDriver navegador = null;
		 
		 try {
			 navegador = new RemoteWebDriver(new java.net.URL(URL), caps);
			 navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //Configuração do tempo de espera para encontrar os elementos
				
//			Navegando para a página do Taskit
			 navegador.get("http://www.juliodelima.com.br/taskit");
		 } catch (MalformedURLException e) {
			 System.out.println("Houveram problemas com a URL: "+e.getMessage());
		 }
		 
		
		 return navegador;
	}
}
