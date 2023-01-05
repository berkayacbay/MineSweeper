import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MineSweeper {
private static final int num_mines=25;
private static final int size=20;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
JFrame mineframe= new JFrame("Mine Sweeper | # of mines: "+num_mines);
mineframe.setLayout(new BorderLayout());
mineframe.add(new MineSweeperGUI(size,size,num_mines));
mineframe.add(new MineSweeperupperpanel(num_mines,MineSweeperGUI.grid),BorderLayout.NORTH);
mineframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
mineframe.setSize(1000,600);
mineframe.setVisible(true);
	}
}
