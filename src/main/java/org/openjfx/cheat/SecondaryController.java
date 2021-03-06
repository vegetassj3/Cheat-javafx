package org.openjfx.cheat;

import java.io.IOException;

import data.Context;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;

public class SecondaryController {

	 @FXML
	    private TextField url;
	 
	
	
	@FXML
    private void cancel() throws IOException {
    	App.setRoot("primary");
    }
	
    @FXML
    private void switchToPrimary() throws IOException {
    	Context.getInstance().getChaptersObj().setUrl(url.getText());
    	Context.getInstance().getChaptersObj().loadChapterList();
    	App.setRoot("primary");
    }
}