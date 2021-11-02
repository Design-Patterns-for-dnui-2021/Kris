import java.awt.*;

public class Wall {
	int x, y, w, h;
	TankClient tc;
	
	public Wall(int x, int y, int w, int h, TankClient tc) {
		super();
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
		this.tc=tc;
	}
	
	public Rectangle getRect() {
		return new Rectangle(x, y, w, y);
	}
}
