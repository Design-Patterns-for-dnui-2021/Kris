
public class Test {

	public static void main(String[] args) {
		System.out.println("Window is starting");
		ScrollingWindow window1 = new Window();
		window1 = new Vertical();
		window1.displayInfo();
		window1 = new Horizontal();
		window1.displayInfo();
	}

}
