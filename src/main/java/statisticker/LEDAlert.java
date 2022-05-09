package statisticker;
// LED alert class implemets Ialerter interface
public class LEDAlert implements IAlerter {
	// status boolean varaible
	public boolean ledGlows;

	@Override
	public void triggerAlert() {
		ledGlows = true;
	}

}
