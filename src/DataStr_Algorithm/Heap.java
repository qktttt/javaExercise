package DataStr_Algorithm;

public class Heap<T extends Comparable>
{

	private T[] container;
	private int size;
	public static final DEFAULT_SIZE;
	private int startSize;

	public Heap()
	{

	}



	public void add(T newOne)
	{

	}

	public T deleteMax()
	{

	}

	public T pop()
	{

	}

	private void swim(int index)
	{

	}

	private void down(int index)
	{

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
}