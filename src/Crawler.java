import java.io.IOException;
import java.util.HashMap;
 
import org.jsoup.Jsoup;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;

public class Crawler {
	
	public static void main(String[] args) throws Exception {
	    
		System.out.println(login().parse().html());
	    
	}
	
	public static Response login() throws Exception {
		final String USER_AGENT = "\"Mozilla/5.0 (Windows NT\" +\n" +  
	            "          \" 6.1; WOW64) AppleWebKit/535.2 (KHTML, like Gecko) Chrome/15.0.874.120 Safari/535.2\"";  
	    String loginFormUrl = "https://mangadex.org/search";  
	    String loginActionUrl = "https://mangadex.org//ajax/actions.ajax.php?function=login&nojs=1";  
	    
	    HashMap<String, String> cookies = new HashMap<>();  
	    HashMap<String, String> formData = new HashMap<>(); 
	    
	    Response loginForm = Jsoup.connect(loginFormUrl).
	    		method(Method.GET).
	    		userAgent(USER_AGENT).execute(); 
	    
	    cookies.putAll(loginForm.cookies());
	    
	    formData.put("login_username", Environments.username);  
	    formData.put("login_password", Environments.password);  
	    formData.put("two_factor", "");  

	    return 	Jsoup.connect(loginActionUrl)  
	            .cookies(cookies)  
	            .data(formData)  
	            .method(Method.POST)  
	            .userAgent(USER_AGENT)  
	            .execute();  
	}
}
