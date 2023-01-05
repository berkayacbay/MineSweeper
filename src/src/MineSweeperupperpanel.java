
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import java.util.Timer;

import javax.swing.*;

public class MineSweeperupperpanel extends JPanel {
	public static  int mines;
	public static Timer time;
	public static int miness;
	public static MineGrid grid;
	public static String k;
	public  static JButton[][] a;
	public static    JLabel label;
	public static JButton emoji;
	public static String face;
	public static JLabel minecount;
	public static int flags;
	public static int flagmine;
	public static int i;
	public static int j;
	public static boolean mineinfo;
	public static boolean[][] mineinfoo;
	public static JLabel timelabel;
	public static int second;
	public static int minute=0;
public MineSweeperupperpanel(int mines, MineGrid grid) {
	this.mines=mines;
	time=new Timer();
	this.miness=mines;
	this.grid=grid;
	 k=String.valueOf(this.mines);
	JButton[][] a= MineSweeperGUI.getbuttonarray();
	this.a=a;
	 boolean mineinfoo[][] = new boolean[20][20];
	this.mineinfoo=mineinfoo;
	this.setLayout(new BorderLayout());
	 this.minecount=new JLabel(k);
	 this.emoji=new JButton();
	 this.timelabel=new JLabel();
	 for(this.i=0;this.i<a.length;this.i++) {
			for(this.j=0;this.j<a[i].length;this.j++) {
	gamefinisher(i,j);
			}
	 }
	runTimer();
	Font font=new Font("Digital-7 Mono",Font.PLAIN,30);
	timelabel.setFont(font);
	this.add(minecount,BorderLayout.WEST);
	this.add(emoji,BorderLayout.CENTER);
this.add(timelabel,BorderLayout.EAST);
}
public void gamefinisher(int i, int j) {
	int k=i;
	int l=j;				
					mineinfoo[k][l]=grid.isMine(k,l);
				
				a[k][l].addMouseListener(new MouseListener(){
					public void mouseClicked(MouseEvent e) {
						String flag="\u26f3";
						
						if (SwingUtilities.isRightMouseButton(e)) {
							JButton button=(JButton)e.getSource();
				
								if(!(button.getText().equals(flag))&&(MineSweeperupperpanel.mines!=MineSweeperupperpanel.miness)) {
								MineSweeperupperpanel.mines++;
								}else {
									MineSweeperupperpanel.mines--;
									if(mineinfoo[k][l]==true&&(button.getText().equals(flag))) {
										MineSweeperupperpanel.flags++;
									
		        		}
								}
								
								if(MineSweeperupperpanel.mines>0) {
								minecount.setText(String.valueOf(MineSweeperupperpanel.mines));
								}else if((MineSweeperupperpanel.flags==MineSweeperupperpanel.miness)&&(MineSweeperupperpanel.mines==0)){
									minecount.setText(String.valueOf(MineSweeperupperpanel.mines));
									JOptionPane.showMessageDialog(null, "You are genius");
									System.exit(0);
								}else {
									minecount.setText(String.valueOf(MineSweeperupperpanel.mines));
									JOptionPane.showMessageDialog(null, "Flags are not shows mines");
								}
					}
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub

					}
			});
		}
	 

TimerTask task=new TimerTask() {
	
	public void run() {
		if(flags!=miness) {
		timelabel.setText(String.valueOf(minute+":"+second));
		if(second<60) {
			second++;
			minute=0;
			}else if(second>=60){
				second=0;
				minute++;
			}
		}
	}
};
public void runTimer() {
	time.schedule(task,0,1000);
}
}
