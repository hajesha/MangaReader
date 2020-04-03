
public class MangaOverview {

	private String title; 
	private String imageURL;
	private String description;
	private String url;
	
	MangaOverview(String title, String imageURL, String description, String url){
		this.title = title;
		this.imageURL = imageURL;
		this.description = description;
		this.url = url;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getImageURL() {
		return imageURL;
	}
	
	public String getDescription() {
		return description;
	}
}
