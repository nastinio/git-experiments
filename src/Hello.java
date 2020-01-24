import java.util.*;
import java.util.stream.Collectors;

public class Hello {
  public static void main(String[] args) {
    System.out.println("Йоу!");

    Date date1 = new Date();

    Calendar c = Calendar.getInstance();
    c.setTime(date1);
    c.add(Calendar.MONTH, -1);
    Date date2 = c.getTime();

    System.out.println(date1);
    System.out.println(date2);

    List<ServRefused> listServs = new ArrayList<>();
    listServs.add(new ServRefused(1, 1, date1));
    listServs.add(new ServRefused(2, 1, date1));
    listServs.add(new ServRefused(3, 2, date1));
    listServs.add(new ServRefused(4, 2, date1));
    listServs.add(new ServRefused(5, 1, date2));
    listServs.add(new ServRefused(6, 1, date2));
    listServs.add(new ServRefused(7, 2, date2));
    listServs.add(new ServRefused(8, 2, date2));

    // Нужно состряпать 2 мапы Map<Date, Collection<SXId>> stopDates, Map<SXId, Collection<SXId>> stopReason
    // для создания объекта StopServServ
    // потом шмякнуть streamExec()

    // Раздербанить сразу на две на этапе просмотра строк таблицы
    // Раздербанить итоговый стрим


    // 1.Через бин - на этапе чтения стрима задачей, запихнуть все в лист бинов
    // Входная штука для подхода - List<RefusedServ>

    // Уникальные причины


    Map<Integer, Integer> mapServByReason = new HashMap<>();
    Map<Integer, Date> mapServByDates = new HashMap<>();

    listServs.forEach(x -> {
      mapServByReason.put(x.getServId(), x.getRefuseReasonId());
      mapServByDates.put(x.getServId(), x.getRefuseDate());
    });

    Map<Integer, Collection<Integer>> stopReason = new HashMap<>();
    Set<Integer> reasons = new HashSet<>(mapServByReason.values());
    reasons.forEach(reasonId -> stopReason.put(reasonId, mapServByReason.entrySet().stream()
            .filter(entry -> entry.getValue().equals(reasonId))
            .map(Map.Entry::getKey)
            .collect(Collectors.toList()))
    );
//
    Map<Date, Collection<Integer>> stopDates = new HashMap<>();
    Set<Date> dates = new HashSet<>(mapServByDates.values());
    dates.forEach(refuseDate -> stopDates.put(refuseDate, mapServByDates.entrySet().stream()
        .filter(entry -> entry.getValue().equals(refuseDate))
        .map(Map.Entry::getKey)
        .collect(Collectors.toList()))
    );


    //listServs.forEach(x - > x);stream().distinct();
    //Map<Date, Collection<Integer>> stopDates = listServs.stream()


  }


}