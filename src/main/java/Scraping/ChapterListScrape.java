package Scraping;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.ListIterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ChapterListScrape {

	
	public LinkedHashMap<String, String> getChapterListFromURL(String url) {
		
		LinkedHashMap<String, String> result=new LinkedHashMap<String, String>();
		String chapterListUrl=url+"chapter-list/";
		HttpClient  client = HttpClient.newHttpClient();
		HttpRequest  request = HttpRequest.newBuilder(
			       URI.create(chapterListUrl))
			   .header("accept", "application/html")
			   .build();
		
		try {
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			//System.out.println(response.body());
			Document doc=Jsoup.parse(response.body());
			Elements chapterElements=doc.getElementsByClass("ch-link");
			ListIterator<Element> iterator = chapterElements.listIterator(chapterElements.size());
			
			while(iterator.hasPrevious()) {
				Element temp=iterator.previous();
				String chapterLink=temp.attr("href");
				String chapterName=chapterLink.replace(url, "").replaceAll("-", " ").replace("/", "");
				result.put(chapterName,chapterLink);
				
			}
			return result;
			
		} catch (IOException | InterruptedException e) {
			return result;
		}
		

	}
	
	
}
