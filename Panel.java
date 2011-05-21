/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.awt.image.*;
	import java.util.*;

/**
 *
 * @author David
 */
public class Panel extends JPanel {
	public Graphics graph;
	public BufferedImage image;
	public java.util.Timer t;
	public int count=0;
	public int moleX=0;
	public int moleY=0;
	public boolean running=true;

	public Panel() {
		  image =  new BufferedImage(400, 425, BufferedImage.TYPE_INT_RGB);
        graph = image.getGraphics();
	     graph.setColor(Color.RED.darker());
        graph.fillRect(0, 0, 400, 425);
		  graph.setColor(Color.BLACK);
		  graph.fillOval(20, 20, 100, 100);
		  graph.fillOval(150, 20, 100, 100);
		  graph.fillOval(280, 20, 100, 100);
		  graph.fillOval(20, 150, 100, 100);
		  graph.fillOval(150, 150, 100, 100);
		  graph.fillOval(280, 150, 100, 100);
		  graph.fillOval(20, 280, 100, 100);
		  graph.fillOval(150, 280, 100, 100);
		  graph.fillOval(280, 280, 100, 100);
		  showScore();
        randomMole(0, 0);
		  java.util.Timer endTimer=new java.util.Timer();
		  endTimer.schedule(new ender(), 10000);
		  addMouseListener(new Mouse());
	}
    @Override
    public void paintComponent(Graphics g) {
			g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        /*graph.setFont(new Font("SansSerif", Font.BOLD, 26));
        graph.setColor(Color.RED);
        graph.drawString("Our not-so-fearless leader...", 25, 300);*/
    }

	public void showScore() {
		  graph.setColor(Color.RED.darker());
        graph.fillRect(10, 400, 400, 25);
		  graph.setFont(new Font("SansSerif", Font.BOLD, 26));
        graph.setColor(Color.WHITE);
        graph.drawString(count+" points!", 10, 420);
	}

	public void killMoleAtCoords(int x, int y) {
		//System.out.println("Clicked at ("+x+", "+y+"); Mole currently at ("+moleX+", "+moleY+")");
		 graph.setColor(Color.BLACK);
       if (x==0 && y==0) {
			graph.fillOval(20, 20, 100, 100);
		 } else if (x==1 && y==0) {
		 	graph.fillOval(150, 20, 100, 100);
		 } else if (x==2 && y==0) {
		 	graph.fillOval(280, 20, 100, 100);
		 } else if (x==0 && y==1) {
			graph.fillOval(20, 150, 100, 100);
		 } else if (x==1 && y==1) {
		 	graph.fillOval(150, 150, 100, 100);
		 } else if (x==2 && y==1) {
		 	graph.fillOval(280, 150, 100, 100);
		 } else if (x==0 && y==2) {
			graph.fillOval(20, 280, 100, 100);
		 } else if (x==1 && y==2) {
		 	graph.fillOval(150, 280, 100, 100);
		 } else if (x==2 && y==2) {
		 	graph.fillOval(280, 280, 100, 100);
		 }
		 t.cancel();

		 repaint();
		 
		 //printf(

		 if (moleX==x && moleY==y) {
			 randomMole(x, y);
			 count+=1;
			 showScore();
		 }
	}

	public void randomMole(int oldX, int oldY) {
		if (!running) {
			return;
		}

		int randx=oldX;
		int randy=oldY;

		while (randx==oldX && randy==oldY) {
			randx=(int)(Math.random()*3+1);
			randy=(int)(Math.random()*3+1);
		}

		int x=0;
		int y=0;
		if (randx==1) {
			x=30;
		} else if (randx==2) {
			x=160;
		} else {
			x=290;
		}

		if (randy==1) {
			y=30;
		} else if (randy==2) {
			y=160;
		} else {
			y=290;
		}
		moleX=randx-1;
		moleY=randy-1;
		ImageIcon ico=new ImageIcon("mole.png");
      graph.drawImage(ico.getImage(), x, y, 85, 85, null);
		repaint();
		t=new java.util.Timer();
		t.schedule(new canceler(), 1000);
	}

	public void killAllMolesWithoutPoints() {
		  graph.setColor(Color.RED.darker());
        graph.fillRect(0, 0, 400, 400);
		  graph.setColor(Color.BLACK);
		  graph.fillOval(20, 20, 100, 100);
		  graph.fillOval(150, 20, 100, 100);
		  graph.fillOval(280, 20, 100, 100);
		  graph.fillOval(20, 150, 100, 100);
		  graph.fillOval(150, 150, 100, 100);
		  graph.fillOval(280, 150, 100, 100);
		  graph.fillOval(20, 280, 100, 100);
		  graph.fillOval(150, 280, 100, 100);
		  graph.fillOval(280, 280, 100, 100);
        randomMole(0, 0);
	}

	private class canceler extends TimerTask {
		public void run() {
			killAllMolesWithoutPoints();
		}
	}

	private class restarter extends TimerTask {
		public void run() {
			running=true;
			count=0;
			killAllMolesWithoutPoints();
		}
	}

	private class ender extends TimerTask {
		public void run() {
			running=false;
		  graph.setColor(Color.RED.darker());
        graph.fillRect(0, 0, 400, 400);
		  graph.setColor(Color.BLACK);
		  graph.fillOval(20, 20, 100, 100);
		  graph.fillOval(150, 20, 100, 100);
		  graph.fillOval(280, 20, 100, 100);
		  graph.fillOval(20, 150, 100, 100);
		  graph.fillOval(150, 150, 100, 100);
		  graph.fillOval(280, 150, 100, 100);
		  graph.fillOval(20, 280, 100, 100);
		  graph.fillOval(150, 280, 100, 100);
		  graph.fillOval(280, 280, 100, 100);
			//killAllMolesWithoutPoints();
			JOptionPane.showMessageDialog(null, "You killed "+count+" snakes.");
		}
	}

	private class countdown extends TimerTask {
		public int count=5;
		public void run() {
	     graph.setColor(Color.GRAY.darker());
        //graph.fillRect(100, 150, 200, 100);
		  //graph.setColor(Color.WHITE);
		  graph.setFont(new Font("SansSerif", Font.PLAIN, 154));
		  graph.drawString(""+count, 160, 260);
			//t.schedule(new restarter(), 5000);
		}
	}

		private class Mouse extends MouseAdapter {
			public void mousePressed(MouseEvent e) {
				System.out.println(e.getY());
				if (e.getX()>=15 && e.getX()<=115 && e.getY()>=5 && e.getY()<=100) {
					killMoleAtCoords(0, 0);
				} else if (e.getX()>=145 && e.getX()<=240 && e.getY()>=5 && e.getY()<=100) {
					killMoleAtCoords(1, 0);
				} else if (e.getX()>=270 && e.getX()<=370 && e.getY()>=5 && e.getY()<=100) {
					killMoleAtCoords(2, 0);
				} else if (e.getX()>=15 && e.getX()<=115 && e.getY()>=110 && e.getY()<=210) {
					killMoleAtCoords(0, 1);
				} else if (e.getX()>=145 && e.getX()<=240 && e.getY()>=110 && e.getY()<=210) {
					killMoleAtCoords(1, 1);
				} else if (e.getX()>=270 && e.getX()<=370 && e.getY()>=110 && e.getY()<=210) {
					killMoleAtCoords(2, 1);
				} else if (e.getX()>=15 && e.getX()<=115 && e.getY()>=230 && e.getY()<=320) {
					killMoleAtCoords(0, 2);
				} else if (e.getX()>=145 && e.getX()<=240 && e.getY()>=230 && e.getY()<=320) {
					killMoleAtCoords(1, 2);
				} else if (e.getX()>=270 && e.getX()<=370 && e.getY()>=230 && e.getY()<=320) {
					killMoleAtCoords(2, 2);
				}
			}
		}

    private void drawHorizLine(Graphics g, int x, int y, int l) {
        int r=15;
        int i=0;
        while (i<l)
        {
            graph.fillOval(x-r, y-r, 2*r, 2*r);
            i+=1;
            x+=25;
        }
    }

    private void drawVertLine(Graphics g, int x, int y, int l) {
        int r=15;
        int i=0;
        while (i<l)
        {
            graph.fillOval(x-r, y-r, 2*r, 2*r);
            i+=1;
            y+=25;
        }
    }
}
