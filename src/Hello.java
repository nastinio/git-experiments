import java.util.*;
import java.util.stream.Collectors;

public class Hello {
  public static void main(String[] args) {
    System.out.println("Éîó!");

    Date date = new Date();
    Date dateEnd = date;

    check(date, dateEnd);

  }
  public static void check(Date date, Date dateEnd) {
    System.out.println(date == null ? dateEnd != null : (dateEnd == null || !dateEnd.equals(date)));
  }


}