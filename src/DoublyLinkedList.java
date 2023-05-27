//Реализовать метод разворота двухсвязного списка

class Node<T> {
    T data;
    Node<T> prev;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DoublyLinkedList<T> {
    private Node<T> head;

    public DoublyLinkedList() {
        this.head = null;
    }

    public void add(T data) {
        Node<T> node = new Node<T>(data);
        if (head == null) {
            head = node;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
            node.prev = current;
        }
    }

    //Для разворота двусвязного списка
    public void reverse() {
        Node<T> current = head;
        Node<T> temp = null;
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        if (temp != null) {
            head = temp.prev;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("Перед реверсом:");
        Node<Integer> current = list.head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("");
        list.reverse();
        System.out.println("После реверса:");
        current = list.head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("");
    }
}
