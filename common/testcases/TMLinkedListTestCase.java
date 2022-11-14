import com.thinking.machines.util.*;
class TMLinkedListTestCase
{
public static void main(String gg[])
{
TMLinkedList list1=new TMLinkedList();
list1.add(10);
list1.add(20);
list1.add(30);
for(int i=0;i<list1.size();i++) System.out.println(list1.get(i));
System.out.println("After Inserting");
list1.insert(0,5);
list1.insert(2,15);
list1.insert(25,100);
for(int i=0;i<list1.size();i++) System.out.println(list1.get(i));
System.out.println("After removing from index 2");
System.out.println("Removed : "+list1.removeAt(2));
for(int i=0;i<list1.size();i++) System.out.println(list1.get(i));
System.out.println("After removing from index 4");
System.out.println("Removed : "+list1.removeAt(4));
for(int i=0;i<list1.size();i++) System.out.println(list1.get(i));}
}//class ends