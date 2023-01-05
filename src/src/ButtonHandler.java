
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class ButtonHandler implements ActionListener {
private int row , col;
private MineGrid grid;
public static JButton emojibutton;
public ButtonHandler(int x, int y, MineGrid g) {
	row=x;
	col=y;
	grid=g;
}
	@Override
	public void actionPerformed(ActionEvent e) {
if(grid.isMine(row, col)) {
	grid.showmines();
	
	MineSweeperupperpanel.emoji.setText("\ud83d\ude41");
	JOptionPane.showMessageDialog(null, "OOOPS!!");
	System.exit(0);
}else {
	if(e.getSource() instanceof JButton) {
		JButton button=(JButton)e.getSource();
		if(grid.getCellContent(row, col)==0) {
			grid.zeroopener(row, col);
		}else {
		button.setText(String.valueOf(grid.getCellContent(row, col)));
		button.setBackground(Color.white);
		}
	}
}
	}
}
