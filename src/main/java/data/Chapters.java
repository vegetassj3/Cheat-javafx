package data;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import Scraping.ChapterListScrape;

public class Chapters {

	private String url=null;
	private Map<String, String> chapters=new LinkedHashMap<String, String>();
	private List<String> chapterKeys=new ArrayList<String>();
	private ChapterListScrape scrape = new ChapterListScrape();
	
	public String getUrl() {
		return url;
	}
	
	public Map<String, String> getChapters() {
		return chapters;
	}
	
	public int getNumOfChapters() {
		return chapterKeys.size();
	}
	
	public String getTitleOnIndex(int index) {
		return chapterKeys.get(index);
	}
	
	public String getUrlOnIndex(int index) {
		return chapters.get(chapterKeys.get(index));
	}

	public void setUrl(String url) {
		if(url.startsWith("https://www.mtlnovel.com/")) {
			this.url = url;
		}
	}
	
	public void loadChapterList() {
		if(url!=null) {
			chapters=scrape.getChapterListFromURL(url);
			chapterKeys=new ArrayList<String>(chapters.keySet()) ;
			
		}
	}
	

	
}
