package services;

import java.util.Scanner;
import java.util.regex.Pattern;

import factories.TrackingFactory;
import interfaces.TrackingInterface;
import utils.Constants;

public class TrackingDispatcher {

	public void dispatcher() {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Type in  number tracking:");
			String numberTracking = sc.nextLine().toUpperCase();
			String trackingType = TrackingDispatcher.getTrackingType(numberTracking);
			
			TrackingInterface trackingFactory = TrackingFactory.create(trackingType, numberTracking);
			trackingFactory.find(numberTracking);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static String getTrackingType(String numberTracking) {
		
		if (Pattern.compile("[A-Z]{2}[0-9]{9}[A-Z]{2}").matcher(numberTracking).matches()) {
			return Constants.INTERNATIONAL_FORMAT;
		}

		return "";
	}
}
