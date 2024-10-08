package LinkedList;

public class LinkedListCore<T> implements Modifiable<T> {
    private Node<T> head;
    private int size;

    public LinkedListCore() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public void addHead(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    @Override
    public void addTail(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    @Override
    public void removeHead() {
        if (head != null) {
            head = head.next;
            size--;
        }
    }

    @Override
    public void removeTail() {
        if (head == null) return;
        if (head.next == null) {
            head = null;
        } else {
            Node<T> current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
        }
        size--;
    }

    @Override
    public void insert(int index, T data) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Invalid index");
        if (index == 0) {
            addHead(data);
        } else {
            Node<T> newNode = new Node<>(data);
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }
    }

    @Override
    public void update(int index, T data) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Invalid index");
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.data = data;
    }

    @Override
    public void delete(int index) {
        if (head == null) return;
        if (head.next == null) {
            removeHead();
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            size--;
        }
    }


    @Override
    public void delete(T data) {
        if (head == null) return;
        if (head.data.equals(data)) {
            removeHead();
            return;
        }
        Node<T> current = head;
        while (current.next != null && !current.next.data.equals(data)) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
            size--;
        }
    }

    @Override
    public void deleteAll() {
        head = null;
        size = 0;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node<T> current = head;
        int index = 0;
        while (current != null) {
            array[index++] = current.data;
            current = current.next;
        }
        return array;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> current = head;
        while (current != null) {
            sb.append(current.data).append(" -> ");
            current = current.next;
        }
        sb.append("null");
        return sb.toString();
    }

    @Override
    public int size() {
        return size;
    }
}
