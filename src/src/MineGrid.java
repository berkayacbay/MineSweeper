
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;

public class MineGrid {
	private static final int mine=-1;
private int[][] mineinfo;
public MineGrid(int rows,int cols, int mines) {
	mineinfo=new int[rows][cols];
	initializeCells();
	placeMines(mines);
	setMineInformation();
}
public int[][] getmineinfo() {
	return mineinfo;
}

private void initializeCells() {
	for(int i=0;i<mineinfo.length;i++) {
		for(int j =0;j<mineinfo[0].length;j++) {
			mineinfo[i][j]=0;
		}
	}
}

public void zeroopener (int i,int j) {
JButton[][] a=MineSweeperGUI.getbuttonarray();
	if(isInsideGrid(i,j)&&getCellContent(i,j)!=0) {		
a[i][j].setText(String.valueOf(mineinfo[i][j]));
a[i][j].setBackground(Color.white);
	}
if(a[i][j].getBackground()!=Color.white&&getCellContent(i,j)==0&&isInsideGrid(i,j)) {
	a[i][j].setText("");
	a[i][j].setBackground(Color.white);
	try {
zeroopener(i-1,j);
zeroopener(i+1,j);
zeroopener(i,j-1);
zeroopener(i,j+1);
	}catch(ArrayIndexOutOfBoundsException e){
		
	}
}
}
public void showmines() {
	JButton[][] a=MineSweeperGUI.getbuttonarray();
	for(int i=0;i<mineinfo.length;i++) {
		for(int j=0;j<mineinfo[0].length;j++) {
			if(isMine(i,j)==true) {
			a[i][j].setText("*");
			}
		}
	}
}
private void placeMines(int mines) {
	
	Random r=new Random();
	for(int i=0;i<mines;i++) {
		int a=r.nextInt(mineinfo.length);
		int b=r.nextInt(mineinfo[0].length);
		if(mineinfo[a][b]!=mine) {
		mineinfo[a][b]=mine;
	}else {
	i--;	
	}
	}
}
public void ss(int i,int j) {
	System.out.println("a");
	System.out.println(i+" "+j);
}
private void incrementMineCountAt(int i , int j ) {
	if(isInsideGrid(i,j)&& !isMine(i,j)) {
	mineinfo[i][j]++;
	}
}
public boolean isMine(int i, int j) {
	if(mineinfo[i][j]==mine) {
		return true;
	}else {
		return false;
	}
}
private boolean isInsideGrid(int i, int j) {
	return (i>=0&& i<mineinfo.length)&&(j>=0&&j<mineinfo[0].length);
}
public int getCellContent(int i, int j) {
	return mineinfo[i][j];
}
private void setMineInformation() {
	// TODO Auto-generated method stub
	for(int i=0;i<mineinfo.length;i++) {
		for(int j=0;j<mineinfo[0].length;j++) {
			if(mineinfo[i][j]==mine) {
				incrementMineCountAt(i-1,j-1);
				incrementMineCountAt(i-1,j+1);
				incrementMineCountAt(i-1,j);
				
				incrementMineCountAt(i,j+1);
				incrementMineCountAt(i,j-1);
				
				incrementMineCountAt(i+1,j);
				incrementMineCountAt(i+1,j+1);
				incrementMineCountAt(i+1,j-1);
			}
		}
	}
}
}
