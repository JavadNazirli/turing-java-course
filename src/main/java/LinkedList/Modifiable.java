package LinkedList;

public interface Modifiable<T> {

    public void addHead(T data);

    public void addTail(T data);

    public void removeHead();

    public void removeTail();

    public void insert(int index, T data);

    public void update(int index, T data);

    public void delete(int index);

    public void delete(T data);

    public void deleteAll();

    public Object[] toArray();

    public String toString();

    public int size();

}
