package DataStr_Algorithm;

import java.util.Iterator;

/**
 * Created by Kunting QI on 2018/5/22.
 */
public class DbLinkedList<T> implements Iterable<T>
{
    private Node start;
    private Node end;
    private int size;

    DbLinkedList()
    {
        size = 0;
        start = end = null;
    }

    public <T> boolean addToHead(T data)
    {
        if(size == 0)
        {
            start = new Node<T>(data);
            end = start;
            size = 1;
            return true;
        }
        else
        {
            Node newOne = new Node<T>(data);
            newOne.next = start;
            start.previous = newOne;
            start = newOne;
            size++;
            return true;
        }
    }

    public <T> boolean addToTail(T data)
    {
        if(size == 0)
        {
            start = end = new Node<T>(data);
            size = 1;
            return true;
        }
        else
        {
            Node newOne = new Node<T>(data);
            end.next = newOne;
            newOne.previous = end;
            end = newOne;
            size++;
            return true;
        }
    }

    public <T> T removeFromHead()
    {
        if(size == 0) return null;
        if(size == 1)
        {
            size = 0;
            Node<T> result = start;
            start = end = null;
            return result.data;
        }

        Node<T> result = start;
        start.next.previous = null;
        start = start.next;
        size--;
        return result.data;
    }

    public <T> T removeFromTail()
    {
        if(size == 0) return null;
        if(size == 1)
        {
            size = 0;
            Node<T> result = end;
            start = end = null;
            return result.data;
        }

        Node<T> result = end;
        end.previous.next = null;
        end = end.previous;
        size--;
        return result.data;
    }

    /**
     * This is still an unfinished method
     * @param data
     * @param <T>
     * @return
     */
    public <T> T remove(T data)
    {
        return null;
    }

    public int getSize()
    {
        return this.size;
    }

    public void startEndExchange()
    {
        if(size <= 1) return;
        T temp = (T)start.data;
        start.data = end.data;
        end.data = temp;
    }

    public void print()
    {
        if(size == 0)
        {
            System.out.println("This has been a empty list");
            return;
        }
        Node pointer = start;
        System.out.println("------------------");
        while(pointer != null)
        {
            System.out.print(pointer.data  + " ");
            pointer = pointer.next;
        }
        System.out.println("\n------------------");
    }

    public Iterator<T> iterator()
    {
        return new ListLooper();
    }

    class ListLooper implements Iterator<T>
    {
        Node currentPointer;
        int sizeTrack;
        ListLooper()
        {
            currentPointer = start;
            sizeTrack = size;
        }

        public boolean hasNext()
        {
            return (size > 0 && currentPointer.next != null);
        }

        public T next() {
            Node temp = currentPointer;
            currentPointer = currentPointer.next;
            return (size > 0 && temp.next != null) ? (T) temp.next.data : null;
        }
    }
}

class Node<T>
{
    Node previous;
    Node next;
    T data;

    Node(T data)
    {
        this.data = data;
    }
}
