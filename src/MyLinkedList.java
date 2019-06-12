import javax.xml.soap.Node;

public class MyLinkedList<E> {
    private Node head;
    private Node tail;
    private int size = 0;
    private int numNodes;

    public MyLinkedList() {

    }

    public Object clone() {
        MyLinkedList<E> newList = new MyLinkedList<>();
        Node temp = head;
        for (int i = 0; i < size; i++) {
            newList.addLast((E) temp.getData());
            temp =temp.next;
        }
        return newList;
    }

    private class Node {
        private Node next;
        private Object element;

        public Node(Object element) {
            this.element = element;
        }

        public Object getData() {
            return this.element;
        }
    }

    public void add(int index, E element) {
        if (index == 0) addFirst(element);
        else if (index >= size) addLast(element);
        else {
            Node current = head;
            for (int i = 1; i < index; i++) current = current.next;
            Node temp = current.next;
            current.next = new Node(element);
            (current.next).next = temp;
            size++;
        }

    }

    public void addFirst(E element) {
        Node newNode = new Node(element);
        newNode.next = head;
        head = newNode;
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void addLast(E element) {
        Node newNode = new Node(element);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
        size++;
    }

    public E removeFirst() {
        if (size == 0) return null;
        else {
            Node temp = head;
            head = head.next;
            size--;
            if (head == null) tail = null;
            return (E) temp.element;
        }
    }

    public E removeLast() {
        if (size == 0) return null;
        else if (size == 1) {
            Node temp = head;
            head = tail = null;
            size = 0;
            return (E) temp.element;
        } else {
            Node current = head;
            for (int i = 0; i < size; i++) {
                current = current.next;
            }
            Node temp = tail;
            tail = current;
            tail.next = null;
            size--;
            return (E) temp.element;
        }
    }

    public E remove(int index) {
        if (index < 0 || index >= size) return null;
        else if (index == 0) return removeFirst();
        else if (index == size - 1) return removeLast();
        else {
            Node previous = head;
            for (int i = 0; i < index - 1; i++) {
                previous = previous.next;
            }
            Node current = previous.next;
            previous.next = current.next;
            size--;
            return (E) current.element;
        }
    }

    public E get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return (E) temp.element;
    }

    public int Size() {
        return this.size;
    }

    public void printList() {
        Node temp = head;
        for (int i = 0; i < size; i++) {
            System.out.println(temp.element);
            temp = temp.next;
        }
    }


    public boolean contains(E o) {
        Node temp = head;
        for (int i = 0; i < size; i++) {
            if ((E) temp.element == o) return true;
            temp = temp.next;
        }
        return false;
    }

    public int indexOf(E o) {
        Node temp = head;
        for (int i = 0; i < size; i++) {
            if ((E) temp.element == o) return i;
            temp = temp.next;
        }
        return -1;
    }


}
