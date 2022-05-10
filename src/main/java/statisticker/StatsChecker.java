package statisticker;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class StatsChecker {

	float maxThreshold;
	IAlerter[] alerters;

	// constructor with params
	public StatsChecker(float maxThreshold, IAlerter[] alerters) {
		this.maxThreshold = maxThreshold;
		this.alerters = alerters;
	}

	// func to trigger alerts
	public void checkAndAlert(Float[] numbers) {
		// convert float [] to list 
		List<Float> numberList = Arrays.asList(numbers);
		// get Max value from list using streams
		OptionalDouble max = numberList.stream().mapToDouble((a) -> a).max();
		// check max value is present else mapping NaN
		double maxVal = max.isPresent() ? max.getAsDouble() : Float.NaN;
		// compare with threshold
		if (maxVal > maxThreshold) {
			// loping Ialerter interface to trigger alerts
			for (IAlerter alert : alerters) {
				// check the object instance based on class
				if (alert instanceof EmailAlert) {
					((EmailAlert) alert).triggerAlert();
				} else if (alert instanceof LEDAlert) {
					((LEDAlert) alert).triggerAlert();
				}
			}
		}

	}

}
