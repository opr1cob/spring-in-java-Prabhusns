package statisticker;

import java.util.List;

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
}
