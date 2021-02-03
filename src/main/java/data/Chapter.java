package data;

import java.util.ArrayList;
import java.util.Map;

import Logger.FileLogger;
import Scraping.ChapterScrape;

public class Chapter {
	private Chapters chapters;
	
	public Chapter(Chapters chapters) {
	this.chapters=chapters;
	}
	private ArrayList<String> chapterContent = new ArrayList<String>();
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
	
	public ArrayList<String> getChapterContent() {
		return chapterContent;
	}
	
	
	public void setChapterContent(ArrayList<String> chapterContent) {
		this.chapterContent=chapterContent;
	}
	
	public void loadChapter(String url) {
		if(url!=null) {
			FileLogger.log(url);
			chapterContent=scrape.getChapterFromURL(url);
			
		}
	}
	
}
