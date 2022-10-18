import java.time.DayOfWeek;
import java.time.LocalDate;

public class Date {
    public static void main(String[] args) {
        LocalDate date = LocalDate.parse("2010-10-10");
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        System.out.println(dayOfWeek.name());

        LocalDate now = LocalDate.now().plusDays(1);
        while (!now.getDayOfWeek().equals(DayOfWeek.MONDAY)){
            now = now.plusDays(1);
        }
        now = now.plusDays(1);
        System.out.println(now);



    }
}
