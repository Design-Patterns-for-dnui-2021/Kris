public class Window implements ScrollingWindow {
 
	public void scrollbar() {
	 System.out.println("Window is starting");
	}
	 
	/**
	 * @see ScrollingWindow#displayInfo()
	 */
	public void displayInfo() {
		System.out.println("Window is being scrolled");
	}
	 
}
 
