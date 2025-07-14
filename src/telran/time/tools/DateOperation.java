package telran.time.tools;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class DateOperation {
    private static final LocalDate currentDate = LocalDate.of(2025, 7, 14);

    public static int getAge(String birthDate) {
        // TODO
        LocalDate date = parseDate(birthDate);
        int age;
        age = Period.between(date, currentDate).getYears();
        return age;
    }

    public static String[] sortStringDates(String[] dates) {
        // TODO
        String[] res = Arrays.copyOf(dates,dates.length);
        Arrays.sort(res,(a, b)->{return parseDate(a).compareTo(parseDate(b));});
        return res;
    }

/*
    public static String[] sortStringDates(String[] dates) {
        // TODO
        int length = dates.length;
        LocalDateAndFormat[] newDates = new LocalDateAndFormat[length];
        String[] res = new String[length];
        for (int i = 0; i < length; i++) {
            newDates[i] = new LocalDateAndFormat(parseDate(dates[i]), dates[i]);
        }
        Arrays.sort(newDates, (a,b) -> a.getDate().compareTo(b.getDate()));
        for (int i = 0; i < length; i++) {
            res[i] = newDates[i].getStrDate();
        }
        return res;
    }
    
 */

    private static LocalDate parseDate(String strDate){
        DateTimeFormatter df = DateTimeFormatter
                .ofPattern("[dd/MM/yyyy]" +
                        "[yyyy-MM-dd]" +
                        "[dd.MM.yyyy]" +
                        "[MM-dd-yyyy]" +
                        "[dd MMM yyyy]" +
                        "[dd MMMM yyyy]" +
                        "[yyyyMMdd]");
        return LocalDate.parse(strDate, df);
    }

}