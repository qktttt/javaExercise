package DataStr_Algorithm;

public class Heap<T extends Comparable>
{
	// ATTENTION!!!!
	// the index at there will start at 1
	// instead of zero

	private T[] container;
	private int size;
	public static final DEFAULT_SIZE;
	private int startSize;

	public Heap()
	{
		Heap(DEFAULT_SIZE);
	}

	public Heap(int size)
	{
		container = (T[]) new Object[size];
	}

	public void heapify()
	{
		for(int i = 1; i < container.length / 2 + 1; i++)
		{
			this.down(i)
		}
	}	

	public void add(T newOne)
	{
		if(size > (container.length / 0.75)) resize(size * 2);
		container[++size] = newOne;
		swim(size);
	}

	public T deleteMin()
	{
		T result = container[1];
		container[1] = container[size];
		container[size--] = null;
		return result;
	}

	public T pop()
	{
		return deleteMin()
	}

	private void swim(int index)
	{	
 		int pointer = index;
 		while(pointer > 1)
 		{
 			if(container[pointer].compareTo(container[pointer / 2]))
 			{
 				exch(pointer, pointer / 2)
 				pointer = pointer / 2;
 			}
 		}
	}

	private void down(int index)
	{
		int pointer = index;
		while(pointer <= size/2)
		{
			int target = (pointer * 2 + 1 <= size && 
						container[pointer * 2 + 1].
						compareTo(container[pointer * 2]) < 0) ? 
						pointer * 2 + 1 : (
						(container[pointer * 2].compareTo(container[pointer]) < 0) ? 
						pointer * 2 : pointer);
			exch(pointer, target)
			pointer = target;
		}
	}

	private void resize(int newSize)
	{
		T[] newContainer = (T[]) new Object[newSize];
	}

	public int getSize()
	{
		return size;
	}

	public void clear()
	{
		size = 0;
		if(startSize == 0)
		{
			container = (T[]) new Object[DEFAULT_SIZE];
		}
		else
		{
			container = (T[]) new Object(startSize);
		}
	}

	private void exch(int one, int two)
	{
		if(one == two) return;
		T tmp = container[one];
		container[one] = container[two];
		container[two] = container[one];
	}
}