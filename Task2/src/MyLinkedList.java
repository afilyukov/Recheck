public class MyLinkedList {

    private Node head;
    private Node tail;
    private int size;
    private Iterator iterator;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    public Iterator iterator() {
        return iterator;
    }

    public Object[] toArray() {
        if (isEmpty()) {
            return null;
        }
        Object[] a = new Object[size];
        Node currentNode = head;
        int count = 0;
        while (count != size) {
            a[count] = currentNode.getElement();
            currentNode = currentNode.getNext();
            count++;
        }
        return a;
    }

    public boolean add(Object o) {
        if (isEmpty()) {
            head = new Node(o);
            tail = head;
            size++;
            return true;
        }

        Node newNode = new Node(tail, o, null);
        tail.setNext(newNode);
        tail = newNode;
        size++;
        return true;
    }

    public boolean remove(Object o) {
        Node currentNode = head;
        int count = 0;
        while (count != size) {
            if (currentNode.getElement().equals(o)) {
                remove(count);
                return true;
            }
            currentNode = currentNode.getNext();
            count++;
        }
        return false;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public Object get(int index) {
        if (index > size - 1 || index < 0) {
            throw new RuntimeException(String.format("Индекс %d не существует при размерности списка %d", index, size));
        }
        Node currentNode = head;
        int count = 0;
        while (count != index) {
            currentNode = currentNode.getNext();
            count++;
        }
        return currentNode;
    }

    public void add(int index, Object element) {
        if (index > size - 1 || index < 0) {
            throw new RuntimeException(String.format("Индекс %d не существует при размерности списка %d", index, size));
        }

        Node currentNode = null;
        if (index == 0) {
            currentNode = head;
            head = new Node(null, element, currentNode);
            currentNode.setPrev(head);
        } else if (index == size) {
            add(element);
        } else {
            currentNode = head;
            int count = 0;
            while (count != index) {
                currentNode = currentNode.getNext();
                count++;
            }
            Node newNode = new Node(currentNode.getPrev(), element, currentNode);
            currentNode.getPrev().setNext(newNode);
            currentNode.setPrev(newNode);
        }
        size++;
    }

    public void remove(int index) {
        if (index > size - 1 || index < 0) {
            throw new RuntimeException(String.format("Индекс %d не существует при размерности списка %d", index, size));
        }
        if (size > 1) {
            if (index == 0) {
                head = head.getNext();
            } else if (index == size - 1) {
                tail = tail.getPrev();
                tail.setNext(null);
            } else {
                Node currentNode = head;
                int count = 0;
                while (count != index) {
                    currentNode = currentNode.getNext();
                    count++;
                }
                currentNode.getPrev().setNext(currentNode.getNext());
                currentNode.getNext().setPrev(currentNode.getPrev());
            }
        } else if (size == 1) {
            head = null;
            tail = null;
        }
        size--;
    }

    public int indexOf(Object o) {
        Node currentNode = head;
        int count = 0;
        while (count != size) {
            if (currentNode.getElement().equals(o)) {
                return count;
            }
            currentNode = currentNode.getNext();
            count++;
        }
        return -1;
    }

    private static class Node {
        private Node prev;
        private Node next;
        private Object element;

        public Node(Object o) {
            this(null, o, null);
        }

        public Node(Node prev, Object o, Node next) {
            this.prev = prev;
            this.element = o;
            this.next = next;
        }

        public Object getElement() {
            return element;
        }

        public void setValue(Object o) {
            this.element = o;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            String p = "null";
            String n = "null";
            if (prev != null) {
                p = prev.getElement().toString();
            }
            if (next != null) {
                n = next.getElement().toString();
            }
            return "Node{" +
                    "prev=" + p +
                    ", next=" + n +
                    ", value='" + element.toString() + '\'' +
                    '}';
        }
    }

    protected static class Iterator {
        private Node current;

        public Iterator() {
        }

        public Iterator(Node current) {
            this.current = current;
        }

        public boolean hasNext() {
            return current.getNext() != null;
        }

        public boolean hasPrev() {
            return current.getPrev() != null;
        }

        public Object currentElement() {
            return current.getElement();
        }

        public void moveToNext() {

            if (current.getNext() != null) {
                current = current.getNext();
            }
        }

        public void moveToPrev() {
            if (current.getPrev() != null) {
                current = current.getPrev();
            }
        }
    }
}
