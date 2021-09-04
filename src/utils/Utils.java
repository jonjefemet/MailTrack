package utils;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Utils {

	public final static void clearConsole() {
		try {
			if (System.getProperty("os.name").contains("Windows"))
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			else
				Runtime.getRuntime().exec("clear");
		} catch (IOException | InterruptedException ex) {
		}

	}

	public static Document getHtmlDocument(String url) {

		Document document = null;
		
		try {
			System.out.println("\nExecuting request\n");
			document = Jsoup.connect(url).timeout(18000).get();
		} catch (Exception e) {
			System.out.println(e);
		}

		return document;

	}

}
