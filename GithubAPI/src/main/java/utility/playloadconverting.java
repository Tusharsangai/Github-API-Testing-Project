package utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class playloadconverting {
public static String generatepayloadstring(String filename) throws IOException {
	//String filefath="//Users//user//OneDrive//Desktop//MxPlayer//ApiTestingUsingCucumber//target//test-classes//Login.json/";
	String filepath = System.getProperty("user.dir")+"\\src\\test\\resources\\"+filename;
	return new String(Files.readAllBytes(Paths.get(filepath)));
}


}

