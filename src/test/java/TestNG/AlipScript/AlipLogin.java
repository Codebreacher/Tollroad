package TestNG.AlipScript;

import java.awt.Robot;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import javax.xml.datatype.DatatypeConstants.Field;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
/*import org.openqa.selenium.remote.Command;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.HttpCommandExecutor;
//import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.Response;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.remote.http.W3CHttpCommandCodec;
import org.openqa.selenium.remote.http.W3CHttpResponseCodec;*/
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import TestNG.AlipOR.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AlipLogin {
	
	public void login(String URL,WebDriver driver,String un,String pwd) {
		//driver.get(URL);
		AlipLoginPage al = new AlipLoginPage();
		al.txt_uname(driver).sendKeys(un);
		al.txt_pword(driver).sendKeys(pwd);
		al.btn_login(driver).click();
		
		
	}

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		/*---------------------------------- to reuse same session for debugging ------------------*/
/*		   java.net.URL url = new java.net.URL("http://localhost:9428");
		   String session = "93f14ad67f01e20445fa251da3d8d282";
		   SessionId session_id = new SessionId(session);
		   RemoteWebDriver driver = Generic.createDriverFromSession(session_id, url);
		  // driver.findElement(By.xpath(".//img[@alt='Accenture Life Insurance Platform']")).click();
		  driver.switchTo().frame(0);
*/		//WebDriver driver = new FirefoxDriver();   
		WebDriver driver = new ChromeDriver();
		
		  // ---------------getting sesssion ID -------------------
		  new Generic().getSessionInfo(driver);
		  //---------------------------------------------------------
		  
		  
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		ProxyLogin pl = new ProxyLogin();
		pl.pxyLogin(driver);
		Thread.sleep(1000);
		AlipLogin alo = new AlipLogin();
		alo.login("a", driver, "SUPERVIS", "123456");
		Thread.sleep(2000);
		GenericOb go = new GenericOb();
		//hp.btn_Application(driver).click();
		
		  Point coordinates = go.btn_Application(driver).getLocation();
		  Robot robot = new Robot();
		  robot.mouseMove(coordinates.getX(),coordinates.getY()+120);
		  

	//	Actions builder = new Actions(driver);
	//	builder.moveToElement(hp.btn_Application(driver)).build().perform();
	//	builder.perform();
	//	hp.btn_NewApplication(driver).click();
		  
		//WebDriverWait wait = new WebDriverWait(driver, 5);
		//wait.until(ExpectedConditions.elementToBeClickable(go.btn_NewApplication(driver)));
		go.btn_NewApplication(driver).click();
		Thread.sleep(3000);
		//driver.switchTo().frame("containerIframe");
	
		new ProductSelection_TP(driver).execute(driver);
		
		
		
		}
}
	
















/* **************** CreateDriverFromSession implementation *****************************************************************
	public static RemoteWebDriver createDriverFromSession(final SessionId sessionId, java.net.URL command_executor){
	    CommandExecutor executor = new HttpCommandExecutor(command_executor) {

	    @Override
	    public Response execute(Command command) throws IOException {
	        Response response = null;
	        if (command.getName() == "newSession") {
	            response = new Response();
	            response.setSessionId(sessionId.toString());
	            response.setStatus(0);
	            response.setValue(Collections.<String, String>emptyMap());

	            try {
	                java.lang.reflect.Field commandCodec = null;
	                commandCodec = this.getClass().getSuperclass().getDeclaredField("commandCodec");
	                commandCodec.setAccessible(true);
	                commandCodec.set(this, new W3CHttpCommandCodec());

	                java.lang.reflect.Field responseCodec = null;
	                responseCodec = this.getClass().getSuperclass().getDeclaredField("responseCodec");
	                responseCodec.setAccessible(true);
	                responseCodec.set(this, new W3CHttpResponseCodec());
	            } catch (NoSuchFieldException e) {
	                e.printStackTrace();
	            } catch (IllegalAccessException e) {
	                e.printStackTrace();
	            }

	        } else {
	            response = super.execute(command);
	        }
	        return response;
	    }
	    };

	    return new RemoteWebDriver(executor, new DesiredCapabilities());
	}
*************************************************************************************************************/
/*	public static void main(String [] args) throws MalformedURLException {
		WebDriverManager.chromedriver().setup();
/* ********* while running for first time **********************************************************
  
		ChromeDriver driver = new ChromeDriver();
		HttpCommandExecutor executor = (HttpCommandExecutor) driver.getCommandExecutor();
		java.net.URL url = executor.getAddressOfRemoteServer();
		SessionId session_id = driver.getSessionId();
		System.out.println("URL: "+url);
	    System.out.println("sessiond_id: "+session_id);
		
*****************************************************************************************************/	
/* --------------------------------------------------------------------------------------------------*/		
/* ******** while running second time use the SessionId and URL displayed in First run **************		
	   java.net.URL url = new java.net.URL("http://localhost:23901");
	   String session = "4f101193bbf390d33500dd6980471b02";
	   SessionId session_id = new SessionId(session);
	    System.out.println("URL"+url);
	    System.out.println("sessiond_id"+session_id);
******************************************************************************************************/	    

/* *******************~~ Required both times ~~ *****************************************************
	    RemoteWebDriver driver2 = createDriverFromSession(session_id, url);
	    driver2.get("http://google.com");
	}

******************************************************************************************************/
	



