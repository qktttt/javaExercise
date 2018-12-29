package DataStr_Algorithm;

public class Stack<T>
{
	private Node root;
	private int size;
	public Stack()
	{
		root = null;
		size = 0;
	}	

	public boolean push(T input)
	{
		if(input == null) return false;
		if(root == null)
		{
			root = new Node(input);
			size = 1;
		}
		else
		{
			Node newNode = new Node(input);
			newNode.next = root;
			root = newNode;
			size++;
		}
		return true;
	}

	public T pop()
	{
		if(root == null) return null;
		T result = root.value;
		root = root.next;
		size--;
		return result;
	}

	public T peek()
	{
		return root==null?null:root.value;
	}

	public int getSize()
	{
		return size;
	}

	public void clear()
	{
		root = null;
		size = 0;
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

	public static void main(String[] args) {
		Stack newOne = new Stack<String>();
		newOne.push("123");
		newOne.push("234");
		newOne.push("qwe");
		System.out.println(newOne.pop());
		System.out.println(newOne.pop());
		System.out.println(newOne.pop());
	}
}