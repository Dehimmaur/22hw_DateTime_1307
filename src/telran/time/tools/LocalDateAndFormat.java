package telran.time.tools;

import java.time.LocalDate;

class LocalDateAndFormat {
    private LocalDate date;
    private String strDate;

    LocalDateAndFormat(LocalDate date, String strDate) {
        this.date = date;
        this.strDate = strDate;
    }

    LocalDate getDate() {
        return date;
    }
    String getStrDate() {
        return strDate;
    }
}
