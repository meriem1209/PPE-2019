package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controleur.Main;
import controleur.Admin;

public class VuePrincipale extends JFrame implements ActionListener
{	

	private  JPanel panel = new JPanel(); 
	private  JPanel panelProfil = new JPanel(); 
	
	private JButton btClient = new JButton ("Client");
	private JButton btPrestataire = new JButton("Prestataire");
	
	private static PanelPrestataire unPanelPrestataire= new PanelPrestataire(); 
	private static PanelClient unPanelClient = new PanelClient ();

	

	
	//private static PanelAjout unPanelAjout = new PanelAjout();
	//private static PanelLister unPanelLister = new PanelLister();
	
	private JButton btQuitter = new JButton("Quitter");
	
	//private JButton btAjouter = new JButton("Ajouter");
	//private JButton btSupprimer = new JButton("Supprimer");
	//private JButton btLister = new JButton("Lister");
	//private JButton btRechercher = new JButton("Rechercher");
	
	
	//private static JPanel menu = new JPanel(); 
	
	public VuePrincipale(Admin unAdminConnecte) //passage de admin connecte � travers le constructeur 
	{
		
		
		this.setTitle(" Administration Printemps ");
		this.setBounds(200, 200, 900, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.WHITE);
		this.setResizable(false);
		this.setLayout(null);
		
		this.panel.setBounds(400, 100, 200, 250);
		this.panel.setBackground(Color.WHITE);
		this.panel.setLayout(new GridLayout(4, 1));
		
		
		panel.add(btClient);
		panel.add(btPrestataire);
       
		this.add(this.panel);
		
		this.panelProfil.setBounds(10, 50, 250, 300);
		this.panelProfil.setLayout(new GridLayout(4, 1));
		this.panelProfil.setBackground(Color.PINK);
		this.panelProfil.add(new JLabel("Nom de l'utilisateur :" + unAdminConnecte.getNom()));
		this.panelProfil.add(new JLabel("Poste de l'utilisateur :" + unAdminConnecte.getPoste()));
		this.panelProfil.add(new JLabel("Email de l'utilisateur :" + unAdminConnecte.getEmail()));
		this.panelProfil.add(new JLabel("Vous avez les Droits  :" + unAdminConnecte.getDroits()));
		
		this.add(this.panelProfil);
		
	
		this.add(unPanelPrestataire);
		this.add(unPanelClient);

		
		
		/*menu.setLayout(new GridLayout(1, 4));
		menu.setBounds(250, 10, 500, 30);
		menu.add(this.btAjouter); 
		menu.add(this.btSupprimer);
		menu.add(this.btLister); 
		menu.add(this.btRechercher); 
		this.add(menu);
		
		this.btAjouter.addActionListener(this);
		this.btLister.addActionListener(this);
		this.btRechercher.addActionListener(this);
		this.btSupprimer.addActionListener(this);
		
		this.add(unPanelAjout);
		this.add(unPanelLister);
		
		this.btQuitter.setBounds(700, 440, 100, 20);
		this.add(this.btQuitter);
		this.btQuitter.addActionListener(this);
		
		this.setVisible(false);
		this.menu.setVisible(false);*/
		
		this.btClient.addActionListener(this);
		this.btPrestataire.addActionListener(this);
		
	}
		@Override
		public void actionPerformed(ActionEvent e) {
			switch(e.getActionCommand())
			{
			case "Client" : 
			unPanelClient.setVisible(true);
			this.panel.setVisible(false);
				break;
			case "Prestataire" : 
			unPanelPrestataire.setVisible(true);
			this.panel.setVisible(false);
				break;
			}
	

	
}

}

		


		
		/*menu.setLayout(new GridLayout(1, 4));
		menu.setBounds(250, 10, 500, 30);
		menu.add(this.btAjouter); 
		menu.add(this.btSupprimer);
		menu.add(this.btLister); 
		menu.add(this.btRechercher); 
		this.add(menu);
		
		this.btAjouter.addActionListener(this);
		this.btLister.addActionListener(this);
		this.btRechercher.addActionListener(this);
		this.btSupprimer.addActionListener(this);
		
		this.add(unPanelAjout);
		this.add(unPanelLister);
		
		this.btQuitter.setBounds(700, 440, 100, 20);
		this.add(this.btQuitter);
		this.btQuitter.addActionListener(this);
		
		this.setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand())
		{
		case "Quitter" : 
			if(JOptionPane.showConfirmDialog(this, "Voulez-Vous quitter ?", "Quitter l'application", JOptionPane.YES_NO_OPTION)==0)
			{
				Main.getVuePrincipale().dispose();
				Main.getVueConnexion().setVisible(true);
			}
			break;
		case "Ajouter" : 
			unPanelAjout.setVisible(true);
			unPanelLister.setVisible(false);
			break;
		case "Lister" : 
			unPanelLister.setVisible(true);
			unPanelAjout.setVisible(false);
			break;
		}
		
	}

}*/









