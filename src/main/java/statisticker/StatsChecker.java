package statisticker;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class StatsChecker {

	float maxThreshold;
	IAlerter[] alerters;

	public StatsChecker(float maxThreshold, IAlerter[] alerters) {
		this.maxThreshold = maxThreshold;
		this.alerters = alerters;
	}

	public void checkAndAlert(Float[] numbers) {
		List<Float> numberList = Arrays.asList(numbers);
		OptionalDouble max = numberList.stream().mapToDouble((a) -> a).max();
		double maxVal = max.isPresent() ? max.getAsDouble() : Float.NaN;
		if (maxVal > maxThreshold) {
			// trigger alerts
			for (IAlerter alert : alerters) {
				if (alert.getClass().getSimpleName().equalsIgnoreCase(EmailAlert.class.getSimpleName())) {
					((EmailAlert) alert).triggerAlert();
				} else if (alert.getClass().getSimpleName().equalsIgnoreCase(LEDAlert.class.getSimpleName())) {
					((LEDAlert) alert).triggerAlert();
				}
			}
		}

	}

}
