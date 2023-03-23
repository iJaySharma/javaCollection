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
n++;

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
int bi = hashFunction(key);
int di = searchInLL(key,bi);

if(di==-1)
{
return false;
}
else 
{
return true;
}

}

public V remove(K key)
{
int bi = hashFunction(key);
int di = searchInLL(key,bi);

if(di==-1)
{
return null;
}
else 
{
Node node = buckets[bi].remove(di);
return node.value;
}

}

public V get(K key)
{
int bi = hashFunction(key);
int di = searchInLL(key,bi);

if(di==-1)
{
return null;
}
else 
{
Node node = buckets[bi].get(di);
return node.value;
}

}

public ArrayList<K> KeySet()
{
ArrayList<K> list = new ArrayList<>();
for(int i=0; i<buckets.length; i++) // bi
{
LinkedList<Node> ll = buckets[i];
for(int j=0; j<ll.size();j++) // di
{
Node node = ll.get(j);
list.add(node.key);
} 
}
return list;
}

public boolean isEmpty()
{
return n==0;
}

}


public static void main(String[] gg)
{
HashMap<String,Integer> map = new HashMap<>();
map.put("india",190);
map.put("china",200);
map.put("america",150);
System.out.println(map.containsKey("china"));
System.out.println(map.get("america"));
System.out.println(map.isEmpty());
System.out.println(map.remove("india"));
for(String g: map.KeySet())
{
System.out.print(g);
}
}
}