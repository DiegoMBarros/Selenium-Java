package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecretaPage extends BasePage {
//	private WebDriver navegador;
//	
//	public SecretaPage(WebDriver navegador) {
//		this.navegador = navegador;
//	}
	
	public SecretaPage(WebDriver navegador) {
		super(navegador);
		// TODO Auto-generated constructor stub
	}

	public MePage clicarMe() {
		navegador.findElement(By.className("me")).click();
		
		return new MePage(navegador);
	}

}
