import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawler {
	
	public static void main(String[] args) throws Exception {
		getTitlesOnPage(searchPage());
	}
	
	public static ArrayList<MangaOverview> getTitlesOnPage(Document page){
		Elements mangas = page.body().select("div.manga-entry");
		ArrayList<MangaOverview> listOfManga = new ArrayList<MangaOverview>();
		
		for (Element manga: mangas) {
			Element imageElement = manga.selectFirst("div.rounded");
			String imageURL = manga.selectFirst("img").attr("src");
			Element titleElement = manga.selectFirst("a.manga_title");
	
			//String url = image.absUrl("src"); absolute path
			String description = manga.select("div").last().text();
			String title = manga.selectFirst("a.manga_title").attr("title");
			String url = titleElement.attr("href");
			listOfManga.add(new MangaOverview(title,imageURL,description,url));
		}
		return listOfManga;
	}
	
	public static Document searchPage() throws Exception {
		boolean loggedIn = false;
		boolean bypass = false;
		Response home = null;
		Document landingPage = null;
		while (!loggedIn) {
			home = Jsoup.connect(Consts.searchPage)
					.cookies(login(bypass))
					.userAgent(Consts.userAgent)
					.execute();
			
			 landingPage = home.parse();
			if (landingPage.selectFirst("#login")!= null) {
				bypass = !bypass;
			} else {
				loggedIn = true;
			}
		}

		//TODO: add null check
		return landingPage;
	}
	
	public static Map<String, String> login(boolean byPassSavedCookie) throws Exception {
		if (!byPassSavedCookie) {
			Map<String,String> cookies = getCookie();
			if (cookies != null) {
				return cookies;
			}
		}
		
	    HashMap<String, String> cookies = new HashMap<>();  
	    HashMap<String, String> formData = new HashMap<>(); 
	    
	    Response loginForm = Jsoup.connect(Consts.searchPage).
	    		method(Method.GET).
	    		userAgent(Consts.userAgent).execute(); 
	    
	    cookies.putAll(loginForm.cookies());
	    
	    formData.put("login_username", Environments.username);  
	    formData.put("login_password", Environments.password);  
	    formData.put("two_factor", "");  
	    formData.put("remember_me", "1");  

	    Response loginResponse = 
	    		Jsoup.connect(Consts.loginPage)  
	            .cookies(cookies)  
	            .data(formData)  
	            .method(Method.POST)  
	            .userAgent(Consts.userAgent)  
	            .execute();
	    if (loginResponse.cookies().containsKey(Consts.rememberMeTokenName)) {
	    	saveCookieFile(loginResponse.cookies());
	    }
	    
	    return loginResponse.cookies();   
	}
	
	public static void saveCookieFile(Map<String, String> cookies) {
		try {
	         FileOutputStream fileOut =
	         new FileOutputStream(Consts.fileName);
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(cookies);
	         out.close();
	         fileOut.close();
	      } catch (IOException i) {
	         i.printStackTrace();
	      }
	}
	
	public static Map<String, String> getCookie() {
		Map<String, String> cookies = null;
	      try {
	         FileInputStream fileIn = new FileInputStream(Consts.fileName);
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         cookies = (Map<String, String>) in.readObject();
	         in.close();
	         fileIn.close();
	      } catch (Exception i) {
	         //do nothing
	      }
	      
	      return cookies;
	}
}
