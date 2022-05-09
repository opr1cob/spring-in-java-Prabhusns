package statisticker;
import java.util.List;
import java.util.OptionalDouble;
public class Statistics {
    // Stats with avg, max, min values
    public static Stats getStatistics(List < Float > numbers) {
        Stats stats = new Stats();
        // manipulating avg value using streams
        OptionalDouble avg = numbers.stream().mapToDouble((a) -> a).average();
        // checking avg value is present else mapping Nan
        stats.setAverage(avg.isPresent() ? avg.getAsDouble() : Float.NaN);
        // manipulating min value using streams
        OptionalDouble min = numbers.stream().mapToDouble((a) -> a).min();
        // checking avg value is present else mapping Nan
        stats.setMin(min.isPresent() ? min.getAsDouble() : Float.NaN);
        // manipulating max value using streams
        OptionalDouble max = numbers.stream().mapToDouble((a) -> a).max();
        // checking avg value is present else mapping Nan
        stats.setMax(max.isPresent() ? max.getAsDouble() : Float.NaN);
        return stats;
    }
	
    // created static inner class based on test case
    static class Stats {
        double min; //minimum value
        double average; // avg value on the list
        double max; // max value
        // getter and setter
        public double getMin() {
            return min;
        }
        public void setMin(double min) {
            this.min = min;
        }
        public double getAverage() {
            return average;
        }
        public void setAverage(double average) {
            this.average = average;
        }
        public double getMax() {
            return max;
        }
        public void setMax(double max) {
            this.max = max;
        }
    }
}
