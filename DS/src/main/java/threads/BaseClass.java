package threads;

public class BaseClass {

	// Private method will not be overriden
	 private void m1() {
	 System.out.println("In BaseClass method");

	 }

	 public static void main(String args[])
	 {
	 BaseClass b=new SubClass();
	 b.m1();
	 }
	}
	 


	class SubClass extends BaseClass {
	 public void m1() {
	 System.out.println("In SubClass method");

	 }
	}

