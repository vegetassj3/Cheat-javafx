package org.openjfx.cheat;


import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import javafx.geometry.Insets;


public class PrimaryController {
	
	@FXML
	VBox vbox;
	
	@FXML
	ScrollPane scroll;
	
	@FXML
	Button button;
	
	final KeyCombination combination = new KeyCodeCombination(
			KeyCode.N, KeyCombination.CONTROL_DOWN);
	
	
	private Chapters chapters= Context.getInstance().getChaptersObj();
	private Chapter chapter= Context.getInstance().getChapterObj();
	
	
	public void initialize() {
		scroll.requestFocus();
		int numOfChapters=chapters.getNumOfChapters();
		Insets spacing=new Insets(2, 0, 2, 0);
		for(int i=0;i<numOfChapters;i++) {
			String title=chapters.getTitleOnIndex(i);
			addLabel(title, i, spacing);
		}
		
		
		
		
	};
	
	private void mouseEventHandler(MouseEvent args) {
		Label clicked=(Label)args.getSource();
		try {
			int index=(Integer) clicked.getProperties().get("index");
			chapter.setIndex(index);
			App.setRoot("chapter");
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	private void  addLabel(String chapterName,int index,Insets spacing) {
		
		Label tempLabel=new Label(chapterName);
		tempLabel.setFont(new Font("Arial", 15));
		tempLabel.setPadding(spacing);
		tempLabel.getProperties().put("index", index);
		tempLabel.setOnMouseClicked(this::mouseEventHandler);
		vbox.getChildren().add(tempLabel);
	}
	
	@FXML
	private void handleOnKeyPressed(KeyEvent event) throws IOException {
		if(combination.match(event)) {
			
			App.setRoot("secondary");
				
		}
	}

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
