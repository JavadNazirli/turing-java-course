package comperator;

import java.util.Comparator;

public class PlayerComperator implements Comparator<Player> {
    @Override
    public int compare(Player p1, Player p2) {
        // 1. Score'a göre azalan sırada
        int scoreCompare = Integer.compare(p2.score, p1.score);
        if (scoreCompare != 0) {
            return scoreCompare;
        }

        // 2. isFemale'e göre evvel qadınlar
        int genderCompare = Boolean.compare(p2.isFemale, p1.isFemale);
        if (genderCompare != 0) {
            return genderCompare;
        }

        // 3. Age'e göre artan sırada
        int ageCompare = Integer.compare(p1.age, p2.age);
        if (ageCompare != 0) {
            return ageCompare;
        }

        // 4. Name'e göre elifba sıralamasının tersine
        int nameCompare = p2.name.compareTo(p1.name);
        if (nameCompare != 0) {
            return nameCompare;
        }

        // 5. ID'ye göre artan sırada
        return Integer.compare(p1.id, p2.id);
    }
}
