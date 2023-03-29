//iterator testcases
import com.thinking.machines.util.*;
class TMIteratorTestCase
{
public static void main(String gg[])
{
TMLinkedList list1=new TMLinkedList();
list1.add(10);
list1.add(20);
list1.add(30);
list1.add(40);
list1.add(50);
TMArrayList list2=new TMArrayList();
list2.add(1000);
list2.add(2000);
list2.add(3000);
list2.add(4000);
list2.add(5000);
System.out.println("Iterating on linked list");
TMIterator iterator1=list1.iterator();
int x;
while(iterator1.hasNext())
{
x=(int) iterator1.next();
System.out.println(x);
}
System.out.println("Iterating on array list");
TMIterator iterator2=list2.iterator();
while(iterator2.hasNext())
{
x=(int) iterator2.next();
System.out.println(x);
}
}
}