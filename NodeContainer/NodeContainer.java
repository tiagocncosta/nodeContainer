package NodeContainer;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class NodeContainer implements List {
    private Node head;
    private Node tail;
    private int length;

    public NodeContainer(){
        this.head = new Node(null);
        this.tail = new Node(null);
        head.setNext(tail);
        length = 0;
    }

    public static class Node{

        private Node next;
        private Object o;

        public Node(Object o){
            this.o = o;
            this.next = null;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Object getO() {
            return o;
        }

        public void setO(Object o) {
            this.o = o;
        }

        public boolean hasNext(){
            return next != null;
        }
    }


    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        if (o == null){
            return false;
        }
        if (head.getO() == null){
            head.setO(o);
            length = 1;
            return true;
        }

        tail.setO(o);
        Node newTail = new Node(null);
        tail.setNext(newTail);
        tail = newTail;
        length ++;

        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object get(int index) {
        if(index > length-1 || index <0){
            throw new ArrayIndexOutOfBoundsException();
        }
        if (index == 0){
            if(head == null){
                throw new ArrayIndexOutOfBoundsException();
            }
            return head.getO();
        }
        Node CurrentNode = head;
        for (int i = 0; i <= index - 1; i++) {

                CurrentNode = CurrentNode.getNext();
            }

            return CurrentNode.getO();

    }

    public Node getNode(int index){

        if (index > length || index < 0){
            throw new ArrayIndexOutOfBoundsException();
        }
        if (index == 0){
            if(head.getO() == null){
                throw new ArrayIndexOutOfBoundsException();
            }
            return head;

        }
        Node currentNode = head;
        for (int i = 0; i <= index-1; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }


    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {
        Node node = getNode(index);
        Object toReturn = node.getO();
       if (size() == 1){
           head.setO(null);
           length = 0;
           return toReturn;
       }
       if (index == 0){
           Node next = node.getNext();
           node.setO(null);
           node.setNext(null);
           head = next;
           length --;
           return toReturn;
       }

       Node previous = getNode(index-1);
       Node next = node.getNext();
       previous.setNext(next);
       node.setNext(null);
       length--;
       return toReturn;

    }

    @Override
    public int indexOf(Object o) {
        if (o == null){
            return -1;
        }
        Node returnNode = head;
        int counter = 0;
        do {
            if (returnNode.getO() == o || returnNode.getO().equals(o)) {
                return counter;
            }
            returnNode = returnNode.getNext();
            counter++;
        }
          while (returnNode.hasNext());
          return -1;

    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
