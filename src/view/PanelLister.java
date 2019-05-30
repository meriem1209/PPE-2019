package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controleur.Main;
import controleur.Prestataire;
import controleur.Tableau;
import modele.Modele;

public class PanelLister extends PanelCentral implements ActionListener
{
	private JTable uneTable ; 
	private static Tableau unTableau; 
	private JTextField txtMot = new JTextField();
	private JButton btOk = new JButton ("OK");
	
	public PanelLister ()
	{
		super () ; 
		
		 
		String entetes [] = {"Iduser", "Nom", "Service", "Email", "Adresse","Telephone"}; 
		
		unTableau = new Tableau (this.getLesPrestataires(Modele.selectAll()), entetes);
		
		this.uneTable = new JTable(unTableau); 
		
		//on insere la table dans une scrollPne 
		JScrollPane uneScroll = new JScrollPane(this.uneTable); 
		uneScroll.setBounds(20, 20, 350, 200); //relatif dans le panel 
		this.add(uneScroll);
		txtMot.setBounds(100, 250, 100, 20);
		this.add(txtMot);
		this.btOk.setBounds(220, 250, 80, 20);
		this.add(btOk);
		this.btOk.addActionListener(this);
		
		
		this.uneTable.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int ligne; 
				if (e.getClickCount()==2)
				{
					int retour = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer le Prestataire","Suppression",
							JOptionPane.YES_NO_OPTION);
					if (retour ==0)
					{
						ligne = uneTable.getSelectedRow();
						int iduser = Integer.parseInt((String)unTableau.getValueAt(ligne, 0));
						unTableau.deleteTable(ligne);
						Main.deleteArticle (iduser);
					
					}
				}
				
			}

		});
		
	}
	
	

	public String [][] getLesPrestataires (ArrayList<Prestataire> lesPrestataires)
	{
		
		String [][] matrice = new String [lesPrestataires.size()][6];
		int i =0; 
		for (Prestataire unPrestataire : lesPrestataires)
		{
			matrice[i][0] = unPrestataire.getIduser() +""; 
			matrice[i][1] = unPrestataire.getNom(); 
			matrice[i][2] = unPrestataire.getService(); 
			matrice[i][3] = unPrestataire.getEmail(); 
			matrice[i][4] = unPrestataire.getAdresse();
			matrice[i][5] = unPrestataire.getTelephone();
			i++;
		}
		return matrice ;
	}

	public static void mettreAjourTable(Prestataire unPrestataire) {
		Object ligne [] = {unPrestataire.getIduser(), unPrestataire.getNom(), 
				unPrestataire.getService(), unPrestataire.getEmail(), unPrestataire.getAdresse(), unPrestataire.getTelephone()};
		unTableau.insertTable(ligne);
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()== this.btOk) {
			String mot = this.txtMot.getText();
			String matrice [][] = this.getLesPrestataires(Modele.selectWhere(mot));
			unTableau.setDonnees(matrice);
		}
	}

	
}










