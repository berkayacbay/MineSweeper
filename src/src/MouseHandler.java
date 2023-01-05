
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class MouseHandler implements MouseListener {
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		String flag="\u26f3";
		if (SwingUtilities.isRightMouseButton(e)) {
			JButton button=(JButton)e.getSource();
			if(button.getText().equals(flag)) {
			button.setText("");
        }else {
        	button.setText(flag);
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
}

