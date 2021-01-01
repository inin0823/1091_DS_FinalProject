import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStream;

import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element;

import org.jsoup.select.Elements;



public class GoogleQuery 

{

	public String searchKeyword;

	public String url;

	public String content;
	
	public URL urlContent;
	
	public  ArrayList<URL> webList;

	public GoogleQuery(String searchKeyword) throws  UnsupportedEncodingException, MalformedURLException

	{
		//this.searchKeyword = new String(searchKeyword.getBytes("UTF-8"),"UTF-8");
		this.searchKeyword = searchKeyword;
		this.url = "http://www.google.com/search?q="+searchKeyword+"&ie=UTF-8&num=30";
	    urlContent = new URL("http://www.google.com/search?q="+searchKeyword+"&ie=UTF-8&num=20");
	    
	}
	private String fetchContent() throws IOException

	{
		String retVal = "";

		URL u = new URL(url);
				
		URLConnection conn = u.openConnection();

		conn.setRequestProperty("User-agent", "Chrome/7.0.517.44");

		InputStream in = conn.getInputStream();

		InputStreamReader inReader = new InputStreamReader(in,"utf-8");

		BufferedReader bufReader = new BufferedReader(inReader);
		String line = null;

		while((line=bufReader.readLine())!=null){
			retVal += line;
		}
		return retVal;	
	}
	public Map<String, String> query() throws IOException{
		if(content==null){
			content= fetchContent();
		}
		Map<String, String> retVal = new LinkedHashMap<String, String>();
		
		Document doc = Jsoup.parse(content);
		System.out.println(doc.text());
		Elements lis = doc.select("div");
		//System.out.println(lis);
		lis = lis.select(".kCrYT");
		//System.out.println(lis.size());
		
		for(Element li : lis)
		{
			try 

			{
				String citeUrl = li.select("a").get(0).attr("href");
				String title = li.select("a").get(0).select(".vvjwJb").text();

				//System.out.println(title + ","+citeUrl);
				retVal.put(title, citeUrl);
		
			} catch (IndexOutOfBoundsException e) {
//				e.printStackTrace();
			}			
		}
		return retVal;	
	}
	/*public Map<String, String> summarize() throws IOException{
		if(content==null){
			content= fetchContent();
		}
		Map<String, String> retVal = new LinkedHashMap<String, String>();
		Document doc = Jsoup.parse(content);
		Document doc1 = Jsoup.parse(urlContent,3000);
		System.out.println(doc.text());
		Elements lis = doc.select("div");
		//System.out.println(lis);
		lis = lis.select(".kCrYT");
		//System.out.println(lis.size());
	    Elements contents = doc1.select("span").select(".aCOpRe");
	    ArrayList<String> titleList = new ArrayList<String>(); 
		ArrayList<String> contentList = new ArrayList<String>(); 
		for(Element li : lis)
		{
			try 

			{
			//	String content = li.select(".BNeawe").text();;
				String title = li.select("a").get(0).select(".vvjwJb").text();
				titleList.add(title);
				//System.out.println(title + ","+citeUrl);
		
			} catch (IndexOutOfBoundsException e) {
//				e.printStackTrace();
			}			
		}
		for(Element content : contents)
  		{
  				String span = content.getElementsByTag("span").get(0).html();
  				span = span.replaceAll("<span>","");
  				span =span.replaceAll("</span>","");
  				span = span.replaceAll("<em>","");
  				span =span.replaceAll("</em>","");
  				span =span.replaceAll("<wbr>","");
  				span =span.replaceAll("&nbsp","");
  				span =span.replaceAll("<span class=\"f\">","");
	 	     	//System.out.println(span);
  				String[] spanArray = span.split(";...");
 	     		for (String e :spanArray) {
 	     			System.out.println(e);
 	     			contentList.add(e+"...");	     			
 	     		}
 	     		for(int i=0;i<contentList.size();i++) {
 					retVal.put(titleList.get(i), contentList.get(i));
 	   	     }
  		}
		return retVal;	
		
	}*/
	public Map<Integer, String> content() throws IOException{
		 Document doc = Jsoup.parse(urlContent,3000);
 		 //System.out.println(doc.text());
		 Map<Integer, String> retVal = new LinkedHashMap<Integer, String>();
	     Elements contents = doc.select("span.aCOpRe");
		ArrayList<String> list = new ArrayList<String>();
	     for(Element content : contents)
 		{
	    	 	String span= content.getElementsByTag("span").get(0).html();
 				span = span.replaceAll("<span>","");
 				span =span.replaceAll("</span>","");
 				span = span.replaceAll("<em>","");
 				span =span.replaceAll("</em>","");
 				span =span.replaceAll("<wbr>","");
 				span =span.replaceAll("&nbsp","");
 				span =span.replaceAll("<span class=\"f\">","");
	 	     	//System.out.println(span);   
 				String[] spanArray = span.split(";...");
 		  		for (String e :spanArray) {
 		  			list.add(e);	
 		  		}
 		}
	     for(int i=0;i<list.size();i++) {
	  			retVal.put(i,list.get(i));
			}

	     return retVal;
	}
}