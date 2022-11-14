import com.thinking.machines.util.*;
class TMLambdaTestCase
{
public static void main(String gg[])
{
TMList list1=new TMLinkedList();
list1.add(10);
list1.add(20);
list1.add(30);
list1.add(40);
list1.add(50);
list1.forEach((m)->{System.out.println(m);});
System.out.println("#############");
TMList list2=new TMArrayList();
list2.add(222);
list2.add(333);
list2.add(444);
list2.add(555);
list2.add(666);
list2.forEach((m)->{System.out.println(m);});

}
}