//1
import java.util.*;
public class Test{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int a[] = new int[5];
        System.out.println("Enter 5 no.s between 10-100(inclusive)");
        for (int i=0;i<5;i++) {
            int t=sc.nextInt();
            if (t<10 || t>100) {
                System.out.println("enter num between 10<=num<=100");
                i--;
                continue;
            }
            a[i]=t;
            for (int j=0;j<i;j++) {
                if (a[i]==a[j])
                    a[i]=-1;
            }
            System.out.println("Unique elements:");
            for (int j=0;j<=i;j++) {
                if (a[j]!=-1)
                System.out.print(a[j]+" ");
            }System.out.println();
        }
        sc.close();
    }
}

//2
import java.util.*; 

abstract class Figure{
	int d1;
	int d2;
	abstract public void area();
}

class Rectangle extends Figure{
	Rectangle(int d1,int d2){
		this.d1=d1;
		this.d2=d2;
	}
	public void area() {
        System.out.print("Rectangle area="+(d1*d2));
	}
}

class Triangle extends Figure{
	Triangle(int d1,int d2){
		this.d1=d1;
		this.d2=d2;
	}
	public void area() {
        System.out.print("Triangle area="+(d1*d2/2));
	}
}
public class Test {  
    public static void main(String args[]){
    	Triangle t = new Triangle(3,3);
    	t.area();
        Rectangle r = new Rectangle(3,5);
        r.area();
    }    
}

//3.1
import java.util.*; 

class MyException extends Exception{
	int age;
	MyException(int age){
		this.age=age;
	}
	public String toString() {
		return "MyException age "+age+" is less";
	}
}

public class Test { 
	
	public static void validate(int age) throws MyException {
		System.out.println("Validating age "+age);
		if (age<18) {
			throw new MyException(age);
		}
		else {
			System.out.println("Good to go");
		}
	}
	
    public static void main(String args[]){
    	try {
    		validate(20);
    		validate(1);
    	}catch(MyException e) {
    		System.out.println(e);
    	}
    }    
}
//3.2
import java.util.*;
public class Test{
    public static void main(String args[]){
    	try {
    		int t=1/0;
    	}
    	catch(ArithmeticException e) {
    		System.out.println(e);
    	}
    }
}
//output: java.lang.ArithmeticException: / by zero

//4
import java.util.*;

class Thread1 extends Thread{
	synchronized public void run() {
		try {
			while (true) {
				System.out.println("gm");
				sleep(1000);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}

class Thread2 extends Thread{
	synchronized public void run() {
		try {
			while (true) {
				System.out.println("hlo");
				sleep(2000);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}

class Thread3 extends Thread{
	synchronized public void run() {
		try {
			while (true) {
				System.out.println("wc");
				sleep(3000);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}

public class Test{
	public static void main(String[] args) {
		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2();
		Thread3 t3 = new Thread3();
		t1.start();
		t2.start();
		t3.start();
		
	}
}

//5.1
import java.io.*;

public class Test{
	public static void main(String args[]) throws Exception {
		try{
			String s="hi hlo how who";
			FileWriter w = new FileWriter("D://t.txt");
			w.write(s);
			System.out.println("Done");
			w.close();	
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
//Output: Done 

//5.2
import java.io.*;

public class Test{
	public static void main(String args[]) throws Exception {
		try{
			FileReader fqtry= new FileReader("D://t.txt");
			
			String s = new String();
			int i;
			while ((i=f.read())!=-1) {
				s+=(char)i;
			}System.out.println(s);
			String q = s.replace("h", "w");
			System.out.println(q);
			FileWriter w = new FileWriter("D://t.txt");
			w.write(q);
            System.out.println("Done");
		}catch(Exception e){
			System.out.println(e);
		}	
	}
}

/*Output:
hi hlo how who
wi wlo wow wwo
Done
*/

//6A
import java.util.*;

public class Test{
	public static void main(String args[]) throws Exception {
			List<Integer> l = new ArrayList<>();
			l.add(1);
			l.add(2);
			l.add(3);
			l.add(4);
			l.add(5);
			System.out.println("Printing as List");
			System.out.println(l);
			System.out.println("Printing each element using loop");
			for (int i=0;i<l.size();i++)
				System.out.print(l.get(i)+" ");
			System.out.println("\nUsing Iterator");
			Iterator i = l.iterator();
			while (i.hasNext())
				System.out.print(i.next()+" ");
			System.out.println("\nUsing ListIterator");
			System.out.println("Forward");
			ListIterator j = l.listIterator();
			while (j.hasNext())
				System.out.print(j.next()+" ");
			System.out.println("\nReverse");
			while (j.hasPrevious())
				System.out.print(j.previous()+" ");
	}
}
Output:
Printing as List
[1, 2, 3, 4, 5]
Printing each element using loop
1 2 3 4 5 
Using Iterator
1 2 3 4 5 
Using ListIterator
Forward
1 2 3 4 5 
Reverse
5 4 3 2 1 
