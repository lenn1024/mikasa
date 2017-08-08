package ai.code.mikasa.advanced.stream;

import java.util.Arrays;
import java.util.List;

/**
 * Created by lenn on 17/4/8.
 */
public class Main {
    public static void main(String[] args){
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Trader> traders = Arrays.asList(
                raoul, mario, alan, brian
        );

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // 1
        transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted((t1, t2) -> t1.getValue() - t2.getValue())
                .forEach(t -> System.out.println(t));

        // 2
        traders.stream()
                .map(trader -> trader.getCity())
                .distinct()
                .forEach(city -> System.out.println(city));

        // 3
        traders.stream()
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .sorted((t1, t2) -> t1.getName().compareTo(t2.getName()))
                .forEach(trader -> System.out.println(trader));

        // 4
        traders.stream()
                .map(Trader::getName)
                .sorted((n1, n2) -> n1.compareTo(n2))
                .forEach(name -> System.out.println(name));

        // 5
        traders.stream()
                .filter(trader -> trader.getCity().equals("Milan"))
                .findAny()
                .ifPresent(trader -> System.out.println(trader));

        // 6

        // 7
        transactions.stream()
                .map(t -> t.getValue())
                .reduce(Integer::max)
                .ifPresent(v -> System.out.println(v));

        // 8
        transactions.stream()
                .reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);
    }
}
