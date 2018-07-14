/**
这段代码是基于拉链法的散列表
*/
public class SeperateChainingHashST<Key, Value>
{
	private int N
	private int M;
	private SequantialSearchST<Key, Value>[] st;

	public SeperateChainingHashST()
	{
		this(997);
	}

	public SeperateChainingHashST(int M)
	{
		this.M = M;
		st = (SequantialSearchST<Key, Value>[]) new SequantialSearchST[M];
		for (int i = 0; i < M; i++) {
			st[i] = new SequantialSearchST();
		}
	}

	private int hash(Key key)
	{
		return (key.hashCode() & 0x7fffffff) % M;
	}

	public Value get(Key key)
	{
		return (Value) st[hash(key)].get(key);
	}

	public void put(Key key, Value val)
	{
		st[hash(key)].put(key, val);
	}

	public Iterable<Key> keys()
}
