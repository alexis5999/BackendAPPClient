package intercorp.com.pe.springboot.app.clientes.models.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MathUtils {

   
    public static int calculateAgeAverage(List<Integer> ages) {
        if (ages.isEmpty()) {
            return 0;
        }

        int sum = 0;
        for (Integer age : ages) {
            sum += age;
        }

        return Math.floorDiv(sum, ages.size());
    }

  
    public static double calculateStandardDeviation(List<Integer> ages) {
        if (ages.isEmpty()) {
            return 0;
        }

        int average = calculateAgeAverage(ages);

        double sumDiffToAverage = 0;
        for (Integer age : ages) {
            sumDiffToAverage += Math.pow(age - average, 2);
        }
        double averageOfDiff = sumDiffToAverage / (double) ages.size();

        return Math.sqrt(averageOfDiff);
    }

   
    public static Date estimatedDeathDate(Date birthDate, int average) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(birthDate);
        calendar.add(Calendar.YEAR, average);

        return calendar.getTime();
    }
}
