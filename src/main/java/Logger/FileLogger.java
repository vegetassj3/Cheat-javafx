package Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;


public class FileLogger {

	public static void log(String logData) {
		 Date dateObj = new Date();
	     String date= new SimpleDateFormat("dd-MM-yyyy").format(dateObj);
	     String time= new SimpleDateFormat("hh.mm.ss aa").format(dateObj);
	     String filePath="C:/logs/"+date+".log";
	     File file= new File(filePath);
		
	     logData=time+"\t"+logData+"\n";
	    
		try {
			file.createNewFile();
			Files.write(Paths.get(filePath), logData.getBytes(), StandardOpenOption.APPEND);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
}
