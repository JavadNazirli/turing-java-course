package comperator;

public class Player {
    int id;
    String name;
    int age;
    int score;
    boolean isFemale;

    public Player(int id, String name, int age, int score, boolean isFemale) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.score = score;
        this.isFemale = isFemale;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                ", isFemale=" + isFemale +
                '}';
    }
}
