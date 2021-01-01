
import java.io.IOException;
import java.util.ArrayList;

public class WebPage {
	public String url;
	public String name;
	public String content;
	public WordCounter counter;
	public double score;
	public ArrayList<Keyword> keywords;
	public WebPage(String url,String name) throws IOException{
		this.url = url;
		this.name = name;
		this.setContent("");
		this.counter = new WordCounter(url);
	}
	
	public void setScore(ArrayList<Keyword> keywords) throws IOException{
		score = 0;
		for(Keyword k : keywords){		
			score += k.weight*counter.countKeyword(k.name);
		}
	}

	public double getScore(){
		return score;
	}

	public String getUrl() {
		return url;
	}

	public String getName() {
		return name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	
}