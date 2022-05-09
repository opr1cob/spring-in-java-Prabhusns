package statisticker;
import java.util.List;
import java.util.OptionalDouble;
public class Statistics
{
    public static Stats getStatistics(List<Float> numbers) {
    	Stats stats = new Stats();
    	OptionalDouble avg =  numbers.stream().mapToDouble((a) -> a).average();
    	stats.setAverage(avg.getAsDouble());
    	
    	OptionalDouble min =  numbers.stream().mapToDouble((a) -> a).min();
    	stats.setMin(min.getAsDouble());
    	
    	OptionalDouble max =  numbers.stream().mapToDouble((a) -> a).max();
    	stats.setMax(max.getAsDouble());
    	
		return stats;
    }
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
