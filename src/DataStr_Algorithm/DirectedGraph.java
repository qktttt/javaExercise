package DataStr_Algorithm;
import java.util.ArrayList;
import java.util.Comparator;

//请问用什么样的数据结构储存
//vertice 以及 edge比较好
//HashMap,还是,TreeMap
//还是Set等
//我认为自定义Comparator是个
//更好的方式
public class DirectedGraph<Value extends Comparable<? super Value>>{
	private ArrayList<Vertice> vertices;
	private int verticeSize;
	private int edgeSize;

	public DirectedGraph()
	{
		this.vertices = new ArrayList<>();
	}

	public boolean sortVertice()
	{
		vertices.sort(new Comparator<Vertice>() {
			@Override
			public int compare(Vertice o1, Vertice o2) {
				return o1.identity.compareTo(o2.identity);
			}
		});
		return true;
	}

	public boolean addVertice(Value node)
	{
		if(getVertice(node) != null) return false;
		vertices.add(new Vertice(node));
		verticeSize++;
		return true;
	}

	public boolean addEdge(Value from, Value to)
	{
		Vertice verticeA = getVertice(from);
		Vertice verticeB = getVertice(to);
		if(getEdge(from, to) == null && verticeA != null && verticeB != null)
		{
			verticeA.adj.add(verticeB);
			edgeSize++;
			return true;
		}
		return false;
	}

	public Vertice getVertice(Value node)
	{
		for(Vertice each: vertices)
		{
			if(each.identity.equals(node))
			{
				return each;
			}
		}
		return null;
	}

	public Vertice[] getEdge(Value from, Value to)
	{
		Vertice<Value> a = getVertice(from);
		Vertice<Value> b = getVertice(to);
		if( a == null || b == null)
			return null;
		for(Vertice each:a.adj)
		{
			if((Vertice)each.identity == b.identity)
				return new Vertice[]{a, b};
		}
		return null;
	}

	public boolean removeVertice(Value val)
	{
		Vertice<Value> tmp = getVertice(val);
		if(val == null) return false;
		for(Vertice each : tmp.adj)
		{
			if(each.adj.remove(tmp))
			{
				edgeSize--;
			}
		}
		int size = tmp.adj.size();
		if(vertices.remove(tmp))
		{
			edgeSize -= size;
			verticeSize--;
			return true;
		}
		return false;
	}

	public boolean removeEdge(Value from, Value to)
	{
		if(getEdge(from, to) == null) return false;
		Vertice a = getVertice(from);
		Vertice b = getVertice(to);
		a.adj.remove(b);
		edgeSize--;
		return true;
	}

	/*
	删除全部vertice，全部的edge
	*/
	public boolean clear()
	{
		vertices = null;
		return true;
	}
}

//我认为使用Comparator是个更好的方式
class Vertice<Value extends Comparable<? super Value>>
{
	ArrayList<Vertice> adj;
	Value identity;

	public Vertice(Value val)
	{
		identity = val;
		adj = new ArrayList<>();
	}

	public boolean sortAdj() {
		adj.sort(new Comparator<Vertice>() {
			@Override
			public int compare(Vertice o1, Vertice o2) {
				return o1.identity.compareTo(o2.identity);
			}
		});
		return true;
	}
}