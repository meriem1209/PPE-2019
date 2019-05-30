package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controleur.Main;

public class VueConnexion extends JFrame implements ActionListener,KeyListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel unPanel = new  JPanel(); 
	private JTextField txtEmail = new JTextField(); 
	private JPasswordField txtMdp = new JPasswordField(); 
	private JButton btSeConnecter = new JButton("Se Connecter"); 
	private JButton btAnnuler = new JButton("Annuler"); 
	
		
	public VueConnexion()
	{
		this.setTitle(" Administration Printemps ");
		this.setBounds(200, 200, 500, 250);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.PINK);
		this.setResizable(false);
		this.setLayout(null);
		
		this.unPanel.setBounds(200, 40, 260, 120);
		this.unPanel.setBackground(Color.WHITE);
		this.unPanel.setLayout(new GridLayout(3, 2));
		this.unPanel.add(new JLabel("Email :"));
		this.unPanel.add(this.txtEmail); 
		this.unPanel.add(new JLabel("MDP :"));
		this.unPanel.add(this.txtMdp);
		this.unPanel.add(this.btAnnuler);
		this.unPanel.add(this.btSeConnecter);
		
		Font unePolice = new Font("Arial", Font.ITALIC, 15);
		//changement de police pour tous les objets du pannel 
		for (int i = 0; i <this.unPanel.getComponentCount(); i++)
		{
			this.unPanel.getComponent(i).setFont(unePolice);
		}
		ImageIcon uneImage = new ImageIcon("src/images/connexion.png");
		JLabel monImage = new JLabel(uneImage); 
		monImage.setBounds(20, 20, 160, 160);
		this.add(monImage);
		
		this.add(this.unPanel);
		
		//Rendre les boutons ecoutables 
		this.btAnnuler.addActionListener(this); //clic
		this.btSeConnecter.addActionListener(this); //clic 
		this.txtEmail.addKeyListener(this); //frappe de touche 
		this.txtMdp.addKeyListener(this); //frappe de touche
		
		this.setVisible(true);
	}


	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			String email = this.txtEmail.getText(); 
			String mdp = new String (this.txtMdp.getPassword());
			Main.verifConnexion (email, mdp);
			this.txtEmail.setText("");
			this.txtMdp.setText("");
		}
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand())
		{
		case "Annuler" : 
						this.txtEmail.setText("");
						this.txtMdp.setText("");
						break;
		case "Se Connecter" : 
						{
						String email = this.txtEmail.getText(); 
						String mdp = new String (this.txtMdp.getPassword());
						Main.verifConnexion (email, mdp);
						this.txtEmail.setText("");
						this.txtMdp.setText("");
						}
						break;
		}
		
	}
}














