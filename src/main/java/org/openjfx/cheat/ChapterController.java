package org.openjfx.cheat;

import java.io.IOException;


import data.Chapter;
import data.Chapters;
import data.Context;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;



public class ChapterController {

	private Chapters chapters= Context.getInstance().getChaptersObj();
	private Chapter chapter= Context.getInstance().getChapterObj();
	
	final KeyCombination leftCombination = new KeyCodeCombination(
			KeyCode.LEFT, KeyCombination.CONTROL_DOWN);
	
	final KeyCombination rightCombination = new KeyCodeCombination(
			KeyCode.RIGHT, KeyCombination.CONTROL_DOWN);
	
	@FXML
	Button all_chapters;
	
	@FXML
	Label title;
	
	@FXML
	Label content;
	
	@FXML
	ScrollPane scroll;
	
	@FXML
	VBox vbox;
	
	 @FXML
	 private void allChapters() throws IOException {
		 
	      App.setRoot("primary");
	      
	 }
	 
	 @FXML
		private void handleOnKeyPressed(KeyEvent event) throws IOException {
			
			if(leftCombination.match(event)) {
				
				chapter.decIndex();
					
			}
			if(rightCombination.match(event)) {
				
				chapter.incIndex();
					
			}
			initialize();
		}
	 
	 public void initialize() {
		 
		 int index=chapter.getIndex();
		 scroll.requestFocus();
		 if(!title.getText().equals(chapters.getTitleOnIndex(index))) {
			 
			 scroll.setFitToWidth(true);
			 scroll.setVvalue(0);
			 title.setWrapText(true);
			 content.setWrapText(true);
			 content.prefWidthProperty().bind(vbox.widthProperty());
			 title.setText(chapters.getTitleOnIndex(index));
			 chapter.loadChapter(chapters.getUrlOnIndex(index));
			 content.setText(chapter.getChapterContent());
		 }
		
		 
		 
	 }
	
}
