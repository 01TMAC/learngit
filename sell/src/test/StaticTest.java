package test;

public class StaticTest {
	private static String name;
	public StaticTest(){
		name = "mai";
		System.out.println(name);
	}
	public void say(){
		this.name += "name";
		System.out.println(this.name);
		
	}
	public static void main(String [] args){
		StaticTest st = new StaticTest();
		st.say();
	}

	

}
