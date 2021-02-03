package data;

import java.util.Map;

import Logger.FileLogger;
import Scraping.ChapterScrape;

public class Chapter {
	private Chapters chapters;
	
	public Chapter(Chapters chapters) {
	this.chapters=chapters;
	}
	private String chapterContent = null;
	private int index=0;
	private ChapterScrape scrape= new ChapterScrape();
	
	
	public int getIndex() {
		return index;
	}
	
	public void setIndex(int index) {
		this.index=index;
	}
	
	public void incIndex() {
		if(chapters.getNumOfChapters()-1>index) {
			index++;
		}
	}
	
	public void decIndex() {
		if(index>0) {
			index--;
		}
	}
	
	public String getChapterContent() {
		return chapterContent;
	}
	
	
	public void setChapterContent(String chapterContent) {
		this.chapterContent=chapterContent;
	}
	
	public void loadChapter(String url) {
		if(url!=null) {
			FileLogger.log(url);
			chapterContent=scrape.getChapterFromURL(url);
			
		}
	}
	
}
