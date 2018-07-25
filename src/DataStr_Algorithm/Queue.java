package DataStr_ALgorithm;

public class Queue<T>
{
	private int size;
	private Node front;
	private Node end;
	public Queue()
	{
		size = 0;
		front = 0;
		end = 0;
	}

	public boolean enqueue(T input)
	{
		if(input == null) return false;
		if(size == 0)
		{
			end = front = new Node(input);
			size++;
		}
		else
		{
			Node newend = new Node(input);
			end.next = newend;
			end = newend;
			size++;
		}
		return true;
	}

	public T dequeue()
	{
		if(size == 0) return null;
		if(size == 1)
		{
			size--;
			T result = front.value;
			front = end = null;
			return result;
		}
		else
		{
			T result = front.value;
			front = front.next;
			return result;
		}
	}

	public int getSize()
	{
		return size;
	}

	public T peek()
	{
		return front==null?null:front.value;
	}

	public void clear()
	{
		size = 0;
		front = end = null;
	}

	private class Node
	{
		T value;
		Node next;
		public Node(T input)
		{
			value = input;
		}
	}	
}

