package comperator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();

        players.add(new Player(1, "Aysel", 24, 90, true));
        players.add(new Player(2, "Orxan", 24, 90, false));
        players.add(new Player(3, "Murad", 22, 95, false));
        players.add(new Player(4, "Nigar", 25, 90, true));
        players.add(new Player(5, "Leyla", 22, 95, true));
        players.add(new Player(6, "Rəşad", 30, 85, false));
        players.add(new Player(7, "Günay", 27, 87, true));
        players.add(new Player(8, "İlqar", 24, 93, false));
        players.add(new Player(9, "Zəhra", 26, 89, true));
        players.add(new Player(10, "Cavid", 28, 88, false));
        players.add(new Player(11, "Gülnar", 23, 91, true));
        players.add(new Player(12, "Elvin", 29, 92, false));
        players.add(new Player(13, "Sevda", 24, 94, true));
        players.add(new Player(14, "Əli", 22, 96, false));
        players.add(new Player(15, "Narmin", 25, 90, true));
        players.add(new Player(16, "Rauf", 24, 83, false));
        players.add(new Player(17, "Aynur", 21, 97, true));
        players.add(new Player(18, "Kamran", 30, 82, false));
        players.add(new Player(19, "Səbinə", 27, 90, true));
        players.add(new Player(20, "Toğrul", 26, 89, false));

        Collections.sort(players, new PlayerComperator());
        printPlayers(players);

    }

    public static void printPlayers(List<Player> players) {
        players.forEach(System.out::println);
    }
}
