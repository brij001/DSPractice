package sorting;

public class MyDemoClass {

	public String strs = "";

	public static void main(String args[]) {

		MyDemoClass d = new MyDemoClass();
		d.rev("Hello abcd");
		System.out.println(d.strs);
	}

	public void rev(String str) {

		if (str == null || str.length()<1)
			return ;
		strs =strs+ str.charAt(str.length()-1);
		//System.out.print(str.charAt(str.length()-1));
		rev(str.substring(0,str.length()-1));
	
	}
}
