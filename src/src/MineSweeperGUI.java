
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;


public class MineSweeperGUI extends JPanel {
	public static MineGrid grid;
	private  static JButton[][] buttonarray;
public MineSweeperGUI(int rows,int cols,int mines) {
	grid= new MineGrid(rows,cols,mines);
	setLayout(new GridLayout(rows,cols));

	JButton[][] buttonarray =new JButton[rows][cols];

	for(int i=0;i<rows;i++) {
		for(int j=0;j<cols;j++) {
			JButton button=new JButton();
			buttonarray[i][j]=button;
			this.add(button);
			button.addActionListener(new ButtonHandler(i,j,grid));
			button.addMouseListener(new MouseHandler());
		}
	}
	this.buttonarray=buttonarray;
}
public static JButton[][] getbuttonarray(){
	return buttonarray;
	
}
}

