package abstraction.week4;

public class Automation extends MultipleLanguage implements Language, TestTool{

	public void selenium() {
		System.out.println("This is Selenium Project");
		
	}

	public void java() {
		System.out.println("This is Java based Project");
		
	}

	@Override
	public void ruby() {
		System.out.println("This is ruby based Project");
		
	}
	public static void main(String[] args)
	{
		Automation A = new Automation();
		A.python();
		A.ruby();
		A.java();
	}

}
