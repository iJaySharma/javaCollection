package com.thinking.machines.util;
public class TMArrayList<T> implements TMList<T>
{
private Object collection[];
private int size;

public class TMArrayListIterator<T> implements TMIterator<T>
{
private int index;
public TMArrayListIterator()
{
this.index=0;
}
public boolean hasNext()
{
return index!=size;
}
public T next()
{
if(index==size) throw new InvalidIteratorException("Iterator has no more elements");
T data=(T)get(index);
index++;
return data;
}
}

public TMIterator<T> iterator()
{
return new TMArrayListIterator<T>();
}

public TMArrayList()
{
this.collection=new Object[10];
this.size=0;
}

public void add(T data)
{
if(this.size==this.collection.length)
{
Object [] tmp=new Object[this.size+10];
for(int e=0;e<this.size;e++) tmp[e]=this.collection[e];
this.collection=tmp;
}
this.collection[this.size]=data;
this.size++;
}

public void add(int index,T data)
{
if(index<0 || index>this.size) throw new IndexOutOfBoundsException("Invalid index : "+index);
if(this.size==this.collection.length)
{
Object [] tmp=new Object[this.size+10];
for(int e=0;e<this.size;e++) tmp[e]=this.collection[e];
this.collection=tmp;
}
for(int e=this.size;e>index;e--)
{
this.collection[e]=this.collection[e-1];
}
this.collection[index]=data;
this.size++;
}

public void insert(int index,T data)
{
add(index,data);
}

public void removeAll()
{
clear();
}

public T removeAt(int index)
{
if(index<0 || index>=this.size) throw new IndexOutOfBoundsException("Invalid index : "+index);
int ep=this.size-2;
T data=(T)this.collection[index];
for(int e=index;e<=ep;e++)
{
this.collection[e-1]=this.collection[e];
}
this.size--;
return data;
}

public void clear()
{
this.size=0;
}

public int size()
{
return this.size;
}

public T get(int index)
{
if(index<0 || index>=this.size) throw new IndexOutOfBoundsException("Invalid index : "+index);
return (T)this.collection[index];
}

public void update(int index,T data)
{
if(index<0 || index>=this.size) throw new IndexOutOfBoundsException("Invalid index : "+index);
this.collection[index]=data;
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
for(int i=0;i<this.size;i++) a.accept((T)collection[i]);
}

}//TMArrayList class end
