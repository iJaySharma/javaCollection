import java.util.*;
public class HashMapCode
{
static class HashMap<K,V> // generics
{
private class Node
{
K key;
V value;

public Node(K key,V value)
{
this.key = key;
this.value = value;
}
}

private int n; // n - nodes
private int N; // N - buckets
private LinkedList<Node> buckets[]; // N = buckets.lenght

public HashMap()
{
this.N = 4;
this.buckets = new LinkedList[4];
for(int i=0; i<4; i++)
{
this.buckets[i] = new LinkedList<>();
}
}

public int hashFunction(K key)
{
int bi = key.hashCode();
return Math.abs(bi)%N;
}

public int searchInLL(K key,int bi)
{
LinkedList<Node> ll = buckets[bi];
for(int i=0; i<ll.size(); i++)
{
if(ll.get(i).key==key)
{
return i;
}
}
return -1;
}

public void put(K key,V value)
{
int bi = hashFunction(key);
int di = searchInLL(key,bi);

if(di==-1)
{
buckets[bi].add(new Node(key,value));
}
else 
{
Node node = buckets[bi].get(di);
node.value  =value;
}

double lambda = (double)n/N;
if(lambda>2.0)
{
System.out.print("rehashing");
}
}

public boolean containsKey(K key)
{
return false;
}

public V remove(K key)
{
return null;
}

public V get(K key)
{
return  null;
}

public ArrayList<K> KeySet()
{
return null;
}

public boolean isEmpty()
{
return false;
}

}


public static void main(String[] gg)
{
HashMap<String,Integer> map = new HashMap<>();
map.put("india",190);
map.put("china",200);
map.put("america",150);
}
}