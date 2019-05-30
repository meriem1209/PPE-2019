package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;

public class PanelCentral extends JPanel 
{

	protected Font unePolice = new Font ("Arial", Font.ITALIC, 15);
	
	public PanelCentral()
	{
		this.setBounds(50, 80, 400, 350);
		this.setLayout(null);
		this.setBackground(Color.PINK);
		
		this.setVisible(false);
	}

	public Font getUnePolice() {
		return unePolice;
	}

	public void setUnePolice(Font unePolice) {
		this.unePolice = unePolice;
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
