package data;

import database.Database;

public class Context {
	private Chapters chapters;
	private Chapter chapter;
	private Database database; 
	Context(){
		this.chapters =new Chapters();
		this.chapter =new Chapter(chapters);
		this.database = new Database();
	}
	
	private final static Context instance = new Context();
    
    
    public static Context getInstance() {
        return instance;
    }
    
    
    public Chapters getChaptersObj() {
    	return chapters;
    }
    
    public Database getDatabase() {
    	return database;
    }
    
    public Chapter getChapterObj() {
    	return chapter;
    }

}
