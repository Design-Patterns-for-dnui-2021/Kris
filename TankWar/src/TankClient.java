import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

public class TankClient extends Frame {
	private int x = 50, y = 50; //tank size
	public static final int GAME_WIDTH = 800; //win. width
	public static final int GAME_HEIGHT = 600; //win. height
	
	// Virtual picture
	private Image offScreenImage = null;
	private Tank tank;
	Tank Tank = new Tank (x, y, true, this);
	Tank enemyTank = new Tank(100, 100, false, this);
	
//	Tank myTank = new Tank(50, 50, this);
	List<Missile> missiles = new ArrayList<Missile>();
	List<Tank> tanks = new ArrayList<Tank>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TankClient tc = new TankClient();
		tc.launchFrame();
		
//		Missile m = new Missile(50, 50, Tank.Direction.R);

	}
	
	//Creating window or canvas
	public void launchFrame() {
		for(int i = 0; i < 10; i++) {
			tanks.add(new Tank(50 + 40 *(i + 1), 50, false, this));
		}
		this.setLocation(300,100);
		this.setSize(GAME_WIDTH,GAME_HEIGHT);
		this.setTitle("Tank War Game");
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setResizable(false);
		this.setBackground(Color.WHITE);
//		this.tank = new Tank(x, y);
		this.addKeyListener(new KeyMonitor());
		setVisible(true);
		
		new Thread(new PaintThread()).start();
	}
	
	//Creating the tank
	public void paint(Graphics g) {
		t.collidesWithTanks(tanks);
		t.collidesWithWall(tanks);
		g.drawString("Missiles count: " + missiles.size(), 10, 50);
		g.drawString("Explodes count: " + explodes.size(), 10, 70);
		g.drawString("Tanks count: " + tanks.size(), 10,90);
		for(int i = 0; i < missiles.size(); i++) {
			Missile m = missiles.get(i);
			m.hitTank(enemyTank);
			m.hitTanks(tanks);
			m.draw(g);
//			if(!m.isLive()) {
//				missiles.remove(m);
//			}else {
//				m.draw(g);
//			}
		}
		
		for(int i = 0; i < explodes.size(); i++) {
			Explode e = explodes.get(i);
			e.draw(g);
		}
		tank.draw(g);
		enemyTank.draw(g);
	}
	
	public void update(Graphics g) {
		if(this.offScreenImage == null) {
			this.offScreenImage = this.createImage(GAME_WIDTH,GAME_HEIGHT);
		}
		Graphics gOffScreen = this.offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.WHITE);
		gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		gOffScreen.setColor(c);
		print(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}
	
	private class PaintThread implements Runnable{
		@Override
		public void run() {
			while(true) {
				repaint();
				try {
					Thread.sleep(100);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		}
	}
	
	private class KeyMonitor extends KeyAdapter {
		public void keyPressed(KeyEvent e){
			tank.keyPressed(e);
//			int key = e.getKeyCode(); switch(key) {
//			case KeyEvent.VK_LEFT:
//				x -= 5;
//				break;
//			case KeyEvent.VK_UP: 
//				y -= 5;
//				break;
//			case KeyEvent.VK_RIGHT:
//				x += 5;
//				break;
//			case KeyEvent.VK_DOWN:
//				y += 5;
//				break;
////			}
		}
		
		public void keyReleased(KeyEvent e) {
			tank.keyRelease(e);
		}
	}
}
