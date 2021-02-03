module org.openjfx.cheat {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
	requires java.net.http;
	requires org.jsoup;
	requires java.logging;
	requires java.sql;
    opens org.openjfx.cheat to javafx.fxml;
    exports org.openjfx.cheat;
}