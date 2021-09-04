package services;

import org.jsoup.nodes.Document;

import interfaces.TrackingInterface;
import utils.Utils;

public class TrackJapanPostServices implements TrackingInterface {

	public static String ULR = "https://trackings.post.japanpost.jp";

	@Override
	public void find(String numberTracking) {

		System.out.println("\nJAPAN_POST\n");
		
		Document document = Utils.getHtmlDocument(
				ULR + "/services/srv/search/direct?reqCodeNo1=:_numberTracking&searchKind=S002&locale=en"
						.replaceFirst(":_numberTracking", numberTracking));
		
		System.out.println(document);
	}

	private void fun() {

	}

}
