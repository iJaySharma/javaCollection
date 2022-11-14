 import com.thinking.machines.util.*;
class KeyboardTestCase
{
public static void main(String gg[])
{
Keyboard k=new Keyboard();
String a;
System.out.print("Enter a String : ");
a=k.getString();
String b;
b=k.getString("Enter another String : ");
char c;
c=k.getCharacter("Enter gender (M/F) : ");
long d;
d=k.getLong("Enter Long type value : ");
int e;
e=k.getInt("Enter int type value : ");
short f;
f=k.getShort("Enter Short type value : ");
byte g;
g=k.getByte("Enter Byte type value : ");
double h;
h=k.getDouble("Enter Double type value : ");
float i;
i=k.getFloat("Enter Float type value : ");
boolean j;
j=k.getBoolean("Enter Boolean type value : ");

System.out.println(a);
System.out.println(b);
System.out.println(c);
System.out.println(d);
System.out.println(e);
System.out.println(f);
System.out.println(g);
System.out.println(h);
System.out.println(i);
System.out.println(j);
}
}