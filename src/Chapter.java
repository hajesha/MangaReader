import java.util.ArrayList;

public class Chapter {

	private String title; 
	private ArrayList<String> listOfUrl;
	
	Chapter(String title){
		this.title = title;
	}
	
	public void addUrl(String url) {
		listOfUrl.add(url);
	}
}
