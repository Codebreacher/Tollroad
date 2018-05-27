package TestNG.AlipScript;

import java.io.IOException;
import java.util.Collections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.Response;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.remote.http.W3CHttpCommandCodec;
import org.openqa.selenium.remote.http.W3CHttpResponseCodec;

public class Generic {
	
	public void hoverAppandClick(WebDriver driver) {
		
	}
    public void getSessionInfo(WebDriver cdDriver) {
    	ChromeDriver cDriver = (ChromeDriver) cdDriver;
    	HttpCommandExecutor executor = (HttpCommandExecutor) cDriver.getCommandExecutor();
		java.net.URL url = executor.getAddressOfRemoteServer();
		SessionId session_id = cDriver.getSessionId();
		System.out.println("/*-----------------------------------------------*/");
		System.out.println("URL: "+url);
	    System.out.println("sessiond_id: "+session_id);	
	    System.out.println("/*-----------------------------------------------*/");

    }
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
    
}
