package DataStr_Algorithm;

import com.sun.xml.internal.bind.v2.TODO;

/**
 * Created by Kunting QI on 2018/6/17.
 */
public class RedBlackBST<Key extends Comparable<Key>, Value>
{
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    private int size(Node h)
    {
        return h == null? 0 : h.N;
    }

    private void flipColors(Node h)
    {
        h.left.color = h.right.color = !h.right.color;
        h.color = !h.color;
    }

    public void put(Key key, Value val)
    {
        root = put(root, key, val);
        root.color = BLACK;
    }

    private Node put(Node h, Key key, Value val)
    {
        if(h == null)
            return new Node(key, val, 1, RED);
        int cmp = key.compareTo(h.key);
        if(cmp < 0) h.left = put(h.left, key, val);
        else if(cmp > 0) h.right = put(h.right, key, val);
        else h.val = val;

        if(isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if(isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if(isRed(h.left) && isRed(h.right) ) flipColors(h);

        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }

    private class Node
    {
        Key key;
        Value val;
        Node left, right;
        int N;
        boolean color;

        Node(Key key, Value val, int N, boolean color)
        {
            this.key = key;
            this.val = val;
            this.N = N;
            this.color = color;
        }
    }

    Node rotateLeft(Node h)
    {
        Node x = h.left;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    Node rotateRight(Node h)
    {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    Node balance(Node h)
    {
        //TODO
        return null;
    }

    private boolean isRed(Node x)
    {
        return (x == null || x.color != RED) ? false : true;
    }

    private Node moveRedLeft(Node h)
    {
        flipColors(h);
        if (isRed(h.right.left) )
        {
            h.right = rotateRight(h.right);
            h = rotateLeft(h);
        }

        return h;
    }

    public void deleteMin()
    {
        if(!isRed(root.left) && !isRed(root.right) )
            root.color = RED;
        root =deleteMin(root);
        if(!isEmpty() ) root.color = BLACK;
    }

    public boolean isEmpty()
    {
        return root == null;
    }

    private Node deleteMin(Node h)
    {
        if(h.left == null)
            return null;
        if(!isRed(h.left) && !isRed(h.left.left) )
            h = moveRedLeft(h);
        h.left = deleteMin(h.left);
        return balance(h);
    }
}
