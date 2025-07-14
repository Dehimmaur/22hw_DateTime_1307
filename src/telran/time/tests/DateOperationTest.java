package telran.time.tests;

import org.junit.jupiter.api.Test;

import telran.time.tools.DateOperation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


class DateOperationTest {

    @Test
    void testGetAge() {
        assertEquals(64, DateOperation.getAge("12/04/1961"));
        assertEquals(63, DateOperation.getAge("1961-10-10"));
    }

    @Test
    void testSortStringDates() {
        String[] dates = {"2000-12-01", "10/12/2000", "1970-08-12", "2010-10-05"};
        String[] actual = DateOperation.sortStringDates(dates);
        String[] expected = {"1970-08-12", "2000-12-01", "10/12/2000", "2010-10-05"};
        assertArrayEquals(expected, actual);
    }

    //=============================== New Tests ========================================

    @Test
    void testGetAgeMore() {
        assertEquals(36, DateOperation.getAge("1989-03-17"));
        assertEquals(35, DateOperation.getAge(("1989-08-17")));
        assertEquals(163, DateOperation.getAge("11/11/1861"));
        assertEquals(80, DateOperation.getAge("09/05/1945"));
    }

    @Test
    void  testSortStringDatesMore(){
        String[] dates = generateDatesArray(100);
        String[] newDates = shaffleArray(dates);
        String[] actual = DateOperation.sortStringDates(newDates);
        assertArrayEquals(dates, actual);
    }

    private static String[] generateDatesArray(int length){
        Random random = new Random();
        String[] typesFormatter = {"dd/MM/yyyy",
                "yyyy-MM-dd",
                "dd.MM.yyyy",
                "MM-dd-yyyy",
                "dd MMM yyyy",
                "dd MMMM yyyy",
                "yyyyMMdd"};
        int lastYear = 1600;
        int maxYear = 2100;
        int approxPeriod = (maxYear - lastYear) / length;
        String[] res = new String[length];
        for (int i = 0; i < length; i++) {
            LocalDate date = LocalDate.of(
                    random.nextInt(approxPeriod) + lastYear + i * approxPeriod,
                    random.nextInt(12) + 1,
                    random.nextInt(28) + 1);
            DateTimeFormatter df = DateTimeFormatter.ofPattern(typesFormatter[random.nextInt(typesFormatter.length)]);
            res[i] = date.format(df);
        }
        return res;
    }

    private static String[] shaffleArray(String[] dates) {
        String[] shaffledDates = Arrays.copyOf(dates, dates.length);
        Random rnd = new Random();
        for (int i = shaffledDates.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            String temp = shaffledDates[index];
            shaffledDates[index] = shaffledDates[i];
            shaffledDates[i] = temp;
        }
        return shaffledDates;
    }
}