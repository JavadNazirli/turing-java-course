package LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedListCore<Integer> list = new LinkedListCore<>(); // LinkedListCore yerine LinkedList
        list.addHead(10);
        list.addTail(20);
        list.addTail(30);

        System.out.println(list);


        list.removeHead();
        System.out.println(list);

        list.insert(1, 25);
        System.out.println(list);

        list.update(2, 35);
        System.out.println(list);

        list.delete(1);
        System.out.println(list);

        list.deleteAll();
        System.out.println(list);
    }
}
