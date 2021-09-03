package factories;

import interfaces.TrackingInterface;
import services.TrackJapanPostServices;
import utils.Constants;

public class TrackingFactory {

	public static TrackingInterface create(String type, String numberTracking) {

		switch (type) {
		case Constants.INTERNATIONAL_FORMAT:
			return TrackingFactory.findServiceInternational(numberTracking);
		default:
			return null;
		}
	}

	private static TrackingInterface findServiceInternational(String numberTracking) {

		String country = numberTracking.substring(numberTracking.length()-2);
		
		switch (country) {
		case "JP":
			return new TrackJapanPostServices();
		default:
			return null;
		}

	}
}
