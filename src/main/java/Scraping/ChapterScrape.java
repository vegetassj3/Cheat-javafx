package Scraping;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.ListIterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ChapterScrape {

	public ArrayList<String> getChapterFromURL(String url) {
		
		ArrayList<String> result=new ArrayList<String>();
		HttpClient  client = HttpClient.newHttpClient();
		HttpRequest  request = HttpRequest.newBuilder(
			       URI.create(url))
			   .header("accept", "application/html")
			   .build();
		
		try {
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			
			Document doc=Jsoup.parse(response.body());
			
			Elements chapterElements=doc.getElementsByClass("par fontsize-16");
			if(chapterElements.size()==1) {
				Elements paras=chapterElements.get(0).getElementsByTag("p");
				Iterator<Element> iterator = paras.iterator();
				
				while(iterator.hasNext()) {
					Element temp=iterator.next();
					result.add(temp.html());
				}
				
			}
			return result;
			
		} catch (IOException | InterruptedException e) {
			return null;
			
		}
		
	}
	
}
