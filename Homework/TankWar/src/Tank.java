import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Tank {
	private int x, y;
	private int xspeed = 10, yspeed=10;
	public static final int WIDTH = 30;
	public static final int HEIGHT = 30;
	TankClient tc = null;
	private boolean good;
	private boolean bL = false, bU = false, bR = false, bD = false;
	enum Direction {L, LU, U, RU, R, RD, D, LD, STOP};
	private Direction dir = Direction.STOP;
	private Direction ptDir = Direction.D;
	List<Tank> tanks = new ArrayList<Tank>();
	
	public Tank(int x, int y, boolean good){
		this.x=x;
		this.y=y;
		this.good = good;
	}
	
	public Tank (int x, int y, boolean good, TankClient tc) {
		this(x, y, good);
		this.tc = tc;
		
	}
	
	public void draw(Graphics g) {
		Color c = g.getColor();
		if(good) {
			bb.draw(g);
			g.setColor(Color.DARK_GRAY);
		}else {
			g.setColor(Color.RED);
		}
		g.fillOval(x, y, WIDTH, HEIGHT);
		g.setColor(c);
		switch(ptDir) {
		case L:
			g.drawLine(x + Tank.WIDTH / 2, y + Tank.HEIGHT / 2, x, y + Tank.HEIGHT / 2);
			break;
		case LU:
			g.drawLine(x + Tank.WIDTH / 2, y + Tank.HEIGHT / 2, x, y);
			break;
		case U:
			g.drawLine(x + Tank.WIDTH / 2, y + Tank.HEIGHT / 2, x + Tank.WIDTH / 2, y);
			break;
		case RU:
			g.drawLine(x + Tank.WIDTH / 2, y + Tank.HEIGHT / 2, x + Tank.WIDTH, y);
			break;
		case R:
			g.drawLine(x + Tank.WIDTH / 2, y + Tank.HEIGHT / 2, x + Tank.WIDTH, y + Tank.HEIGHT / 2);
			break;
		case RD:
			g.drawLine(x +Tank.WIDTH / 2, y + Tank.HEIGHT / 2, x + Tank.WIDTH, y + Tank.HEIGHT / 2);
			break;
		case D:
			g.drawLine(x + Tank.WIDTH / 2, y + Tank.HEIGHT / 2, x + Tank.WIDTH / 2, y + Tank.HEIGHT);
			break;
		case LD:
			g.drawLine(x + Tank.WIDTH / 2, y + Tank.HEIGHT / 2, x, y + Tank.HEIGHT);
			break;
		case STOP:
			break;
		}
		
		move();
	}
	
	//8 direction movement value
	public void move() {
		switch(dir) {
		case L:
			x -= xspeed;
			break;
		case LU:
			x -= xspeed;
			y -= yspeed;
			break;
		case U:
			y -= yspeed;
			break;
		case RU:
			x += xspeed;
			y -= yspeed;
			break;
		case R:
			x += xspeed;
			break;
		case RD:
			x += xspeed;
			y += yspeed;
			break;
		case D:
			y += yspeed;
			break;
		case LD:
			x -= xspeed;
			y += yspeed;
			break;
		case STOP:
			break;
		}
		if(this.dir != Direction.STOP) {
			this.ptDir = this.dir;
		}
		
		if(x < 0) x = 0;
		if(y < 25) y = 25;
		if(x + Tank.WIDTH > TankClient.GAME_WIDTH) x = TankClient.GAME_WIDTH - Tank.WIDTH;
		if(y + Tank.HEIGHT > TankClient.GAME_HEIGHT) y = TankClient.GAME_HEIGHT - Tank.HEIGHT;

	}
	
	//key pressed for starting the tank to move into the direction
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		switch(key){
		case KeyEvent.VK_LEFT:
			bL = true;
//			x -= 10;
			break;
		case KeyEvent.VK_UP:
			bU = true;
//			y -= 10;
			break;
		case KeyEvent.VK_RIGHT:
			bR = true;
//			x += 10;
			break;
		case KeyEvent.VK_DOWN:
			bD = true;
//			y += 10;
			break;
		}
		locateDirection();
	}
	
	//key release for stopping the tank from moving 
	public void keyRelease(KeyEvent e) {
		int key = e.getKeyCode();
		switch(key) {
		case KeyEvent.VK_CONTROL:
			fire();
			break;
		case KeyEvent.VK_LEFT:
			bL = false;
			break;
		case KeyEvent.VK_UP:
			bU = false;
			break;
		case KeyEvent.VK_RIGHT:
			bR = false;
			break;
		case KeyEvent.VK_DOWN:
			bD = false;
			break;
		case KeyEvent.VK_A:
			superFire();
			break;
		}
		locateDirection();
	}
	
	//8 direction mobility
	public void locateDirection() {
		if(bL && !bU && !bR && !bD) dir = Direction.L;
		else if (bL && bU && !bR && !bD) dir = Direction.LU;
		else if (!bL && bU && !bR && !bD) dir = Direction.U;
		else if (!bL && bU && bR && !bD) dir = Direction.RU;
		else if (!bL && !bU && bR && !bD) dir = Direction.R;
		else if (!bL && !bU && bR && bD) dir = Direction.RD;
		else if (!bL && !bU && !bR && bD) dir = Direction.D;
		else if (bL && !bU && !bR && bD) dir = Direction.LD;
		else if (!bL && !bU && !bR && !bD) dir = Direction.STOP;
		
	}
	
	public Missile fire(Direction dir) {
		if(!live) return null;
		
		int x = this.x + Tank.WIDTH / 2 - Missile.WIDTH / 2;
		int y = this.y + Tank.HEIGHT / 2 - Missile.WIDTH / 2;
		
		Missile m = new Missile(x, y, good, dir, this.tc);
		tc.missiles.add(m);
		return m;
	}
	
	public boolean collideWithWall(Wall w) {
		if(this.getRect().intersects(w.getRect()) && this.live) {
			this.stay();
			return true;
		}
		return false;
	}
	
	public boolean collidesWithTanks(java.util.List<Tank>tanks) {
		for(int i = 0; i < tanks.size(); i++) {
			Tank t - tanks.get(i);
			if(this != t) {
				if(this.live && t.isLive() && this.getRect().intersects(t.getRect())) {
					t.stay();
					this.stay();
					return true;
				}
			}
		}
		return false;
	}
	
	private void stay() {
		x = oldX;
		y = Oldy;
	}
	
	private void superFire() {
		Diretion[] dirs = Direction.values();
		for(int i = 0; i < 8; i++) {
			fire(dirs[i]);
		}
	}
	
	public class BloodBar{
		public void draw (Graphics g) {
			Color c = g.getColor();
			g.setColor(Color.RED);
			g.drawRect(x, y - 10, WIDTH, 10);
			int w = WIDTH * life / 100;
			g.fillRect(x, y - 10, w, 10);
			g.setColor(c);
		}
	}
	
	public boolean eat(Blood b) {
		if(this.live && b.isLive() && this.getRect().intersects(b.getRect())) {
			this.life = 100;
			b.setLive(false);
			return true;
		}
		return false;
	}
}
