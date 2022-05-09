package statisticker;

// Email alert class implemets Ialerter interface
public class EmailAlert implements IAlerter {
	
	// boolean value
	public boolean emailSent;

	// implemented interface method
	@Override
	public void triggerAlert() {
		emailSent = true;
	}

}
