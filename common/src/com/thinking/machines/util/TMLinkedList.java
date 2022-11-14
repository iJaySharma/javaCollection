package com.thinking.machines.util;
public class TMLinkedList<T> implements TMList<T>
{
class Node<T>
{
public T data;
public Node<T> next;
Node()
{
this.data=null;
this.next=null;
} 
}
 
public class TMLinkedListIterator<T> implements TMIterator<T>
{
private Node<T> ptr;
public TMLinkedListIterator(Node<T> ptr)
{
this.ptr=ptr;
}
public boolean hasNext()
{
return this.ptr!=null;
}
public T next()
{
if(ptr==null) throw new InvalidIteratorException("Iterator has no more elements");
T data=this.ptr.data;
this.ptr=this.ptr.next;
return data;
}
}//TMLinkedListIterator class ends
 
public TMIterator<T> iterator()
{
return new TMLinkedListIterator<T>(this.start);
}

private Node<T> start,end;
private int size;

public TMLinkedList()
{
this.start=null;
this.end=null;
this.size=0;
}

public void add(T data)
{
Node<T> t;
t=new Node<T>();
t.data=data;
if(start==null)
{
this.start=t;
this.end=t;
}
else
{
this.end.next=t;
this.end=t;
}
this.size++;  
}

public void add(int index,T data)
{
insert(index,data);
}

public void insert(int index,T data)
{
if(index<0) throw new ArrayIndexOutOfBoundsException("Invalid Index : "+index);
if(index>=size) 
{
add(data);
return;
}
Node<T> node=new Node<T>();
node.data=data;
if(index==0)
{
node.next=this.start;
this.start=node; 
}
else
{
Node<T> j,k;
int i;
i=0;
k=null;
j=this.start;
while(i<index)
{
k=j;
j=j.next;
i++;
}
k.next=node;
node.next=j;
}
this.size++;
}

public void removeAll()
{
this.clear();
}

public T removeAt(int index)
{
if(index<0 || index>=size) throw new ArrayIndexOutOfBoundsException("Invalid Index : "+index);
T data;
if(start==end)
{
data=this.start.data;
this.start=null;
this.end=null;
this.size=0;
return data;
}
if(index==0)
{
data=this.start.data;
this.start=this.start.next;
this.size--;
return data;
}
Node<T> j,k;
j=this.start;
k=null;
int i;
i=0;
while(i<index)
{
k=j;
j=j.next;
i++;
}
data=j.data;
k.next=j.next;
if(this.end==j) this.end=k;
this.size--;
return data;
}

public void clear()
{
this.size=0;
this.end=null;
this.start=null;
}

public int size()
{
return this.size;
}

public T get(int index)
{
if(index<0 || index>this.size) throw new ArrayIndexOutOfBoundsException("Invalid Index : "+index);
Node<T> t;
t=this.start;
int x;
x=0;    
while(x<index)
{
t=t.next;
x++;
}
return t.data;
}

public void update(int index,T data)
{
if(index<0 || index>this.size) throw new ArrayIndexOutOfBoundsException("Invalid Index : "+index);
if(index==0)
{
this.start.data=data;
return;
}
if(index==this.size--)
{
this.end.data=data;
return;
}
Node<T> t;
t=this.start;
int x;
x=0;    
while(x<index)
{
t=t.next;
x++;
}
t.data=data;
}

public void copyTo(TMList<T> other)
{
other.clear();
for(int e=0;e<this.size();e++) other.add(this.get(e));
}

public void copyFrom(TMList<T> other)
{
this.clear();
for(int e=0;e<other.size();e++) this.add(other.get(e));
}

public void appendTo(TMList<T> other)
{
for(int e=0;e<this.size();e++) other.add(this.get(e));
}

public void appendFrom(TMList<T> other)
{
for(int e=0;e<other.size();e++) this.add(other.get(e));
}

public void forEach(TMListItemAcceptor<T> a)
{
if(a==null) return;
Node<T> initial=start;
while(initial!=null)
{
a.accept(initial.data);
initial=initial.next;
}
}
 
}//TMLinkedList class ends


