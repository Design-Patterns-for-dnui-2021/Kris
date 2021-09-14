public class ScrollBar implements ScrollingWindow {
 
	private Scroll scrollingWindow;
	 
	public void scroll(Scroll scrollingWindow) {
	 this.scrollingWindow=scrollingWindow;
	}
	 
	public void scrollbar() {
	 
	}
	 
	/**
	 * @see ScrollingWindow#displayInfo()
	 */
	public void displayInfo() {
	 System.out.println("Window is scrolled");
	}
	 
}
 
