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

import controleur.Client;
import controleur.Main;
import controleur.Tableau;
import modele.ModeleClient;


public class PanelListerClient extends PanelCentral implements ActionListener
{
    private JTable uneTable ;
    private static Tableau unTableau;
    private JTextField txtMot = new JTextField();
    private JButton btOk = new JButton ("OK");

    public PanelListerClient ()
    {
        super () ;


        String entetes [] = { "Prenom", "Adresse personnelle", "Date de naissance ", "Adresse de facturation",
                "Nom","Email" ,"Mdp"};

        unTableau = new Tableau (this.getLesClients(ModeleClient.selectAll()), entetes);

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
                    int retour = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer le Client","Suppression",
                            JOptionPane.YES_NO_OPTION);
                    if (retour ==0)
                    {
                        ligne = uneTable.getSelectedRow();
                        int iduser = Integer.parseInt((String)unTableau.getValueAt(ligne, 0));
                        unTableau.deleteTable(ligne);
                        Main.deleteArticle(iduser);
                    }
                }

            }
        });

    }



    public String [][] getLesClients (ArrayList<Client> lesClients)
    {

        String [][] matrice = new String [lesClients.size()][8];
        int i =0;
        for (Client unClient : lesClients)
        {

            matrice[i][0] = unClient.getIduser() +"";
            matrice[i][1] = unClient.getPrenom();
            matrice[i][2] = unClient.getAdressepersonnelle();
            matrice[i][3] = unClient.getDatenaissance();
            matrice[i][4] = unClient.getAdressefacturation();
            matrice[i][5] = unClient.getEmail();
            matrice[i][5] = unClient.getMdp();
            i++;


        }
        return matrice ;
    }

    public static void mettreAjourTable(Client unClient) {
        Object ligne [] = { unClient.getPrenom(),
                unClient.getAdressepersonnelle(), unClient.getDatenaissance(), unClient.getAdressefacturation(),
                unClient.getNom(),
                unClient.getEmail(), unClient.getMdp()};
        unTableau.insertTable(ligne);

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== this.btOk) {
            String mot = this.txtMot.getText();
            String matrice [][] = this.getLesClients(ModeleClient.selectWhere(mot));
            unTableau.setDonnees(matrice);
        }
    }


}



