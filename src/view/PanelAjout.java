package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controleur.Main;
import controleur.Prestataire;

public class PanelAjout extends PanelCentral implements ActionListener
{
	private JTextField txtNom =new JTextField(); 
	private JTextField txtService = new JTextField(); 
	private JTextField txtEmail = new JTextField(); 
	private JTextField txtAdresse = new JTextField();
	private JTextField txtTelephone = new JTextField();
	private JTextField txtMdp = new JTextField();
	private JButton btAnnuler = new JButton("Annuler"); 
	private JButton btEnregistrer = new JButton("Enregistrer"); 
	
	public PanelAjout()
	{
		super(); 
		this.setLayout(new GridLayout(8, 2));
		this.add(new JLabel("")); 
		this.add(new JLabel("Ajout d'un prestataire"));
		
		this.add(new JLabel("Nom : "));
		this.add(this.txtNom); 
		this.add(new JLabel("Service : "));
		this.add(this.txtService); 
		this.add(new JLabel("Email : "));
		this.add(this.txtEmail); 
		this.add(new JLabel("Adresse : "));
		this.add(this.txtAdresse);
		this.add(new JLabel("Telephone : "));
		this.add(this.txtTelephone);
		this.add(new JLabel("Mdp : "));
		this.add(this.txtMdp);
		this.add(this.btAnnuler);
		this.add(this.btEnregistrer); 
		
		for (int i= 0; i<this.getComponentCount(); i++)
		{
			this.getComponent(i).setFont(this.unePolice);
		}
		this.btAnnuler.addActionListener(this);
		this.btEnregistrer.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()== this.btEnregistrer)
		{
			
			int ok = 1; 
			for (int i= 0; i<this.getComponentCount(); i++)
			{
				if (this.getComponent(i) instanceof JTextField)
				{
						if (((JTextField)this.getComponent(i)).getText().equals(""))
						{
							((JTextField)this.getComponent(i)).setBackground(Color.red);
							ok = 0; 
						}
				}
			}
			if (ok== 1)
			{
				Prestataire unPrestataire = new Prestataire (this.txtNom.getText(), 
						this.txtService.getText(), this.txtEmail.getText(), this.txtAdresse.getText(), this.txtTelephone.getText(), this.txtMdp.getText()); 
				Main.insertPrestataire(unPrestataire);
				
				
				PanelLister.mettreAjourTable(Main.selectWherePrestataire(unPrestataire));
				
				JOptionPane.showMessageDialog(this,"Insertion realisee avec succes ! ",
						"Information", JOptionPane.INFORMATION_MESSAGE);
				this.setVisible(false);
			}
				
				
		}else
		if (e.getSource() == this.btAnnuler)
		{
			this.txtAdresse.setText("");
			this.txtService.setText("");
			this.txtEmail.setText("");
			this.txtNom.setText("");
			this.txtTelephone.setText("");
			this.txtMdp.setText("");
			
		}
	}
}













