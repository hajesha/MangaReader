import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
 
import org.jsoup.Jsoup;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawler {
	
	public static void main(String[] args) throws Exception {
		getTitlesOnPage(login());
		
	}
	public static ArrayList<MangaOverview> getTitlesOnPage(Document page){
		Elements mangas = page.body().select("div.manga-entry");
		ArrayList listOfManga = new ArrayList();
		
		for (Element manga: mangas) {
			listOfManga.add(new Manga());
		}
		return listOfManga;
	}
	
	public static Document login() throws Exception {
		final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:74.0) Gecko/20100101 Firefox/74.0";  
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

	    Response loginResponse = 
	    		Jsoup.connect(loginActionUrl)  
	            .cookies(cookies)  
	            .data(formData)  
	            .method(Method.POST)  
	            .userAgent(USER_AGENT)  
	            .execute();
	    System.out.println(loginResponse.url());
	    
	    Response home = Jsoup.connect(loginFormUrl)
		.cookies(loginResponse.cookies())
		.userAgent(USER_AGENT)
		.execute();
	    
	    System.out.println(home.url());
	    
	    return home.parse();
	}
}
