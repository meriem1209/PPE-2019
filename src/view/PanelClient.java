package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controleur.Main;

public class PanelClient extends JPanel implements ActionListener{

    private static PanelAjoutClient unPanelAjoutClient = new PanelAjoutClient();
    private static PanelListerClient unPanelListerClient = new PanelListerClient();

    private JButton btQuitter = new JButton("Quitter");

    private JButton btAjouter = new JButton("Ajouter");
    private JButton btSupprimer = new JButton("Supprimer");
    private JButton btLister = new JButton("Lister");
    private JButton btRechercher = new JButton("Rechercher");

    private static JPanel menu = new JPanel();

    public PanelClient() {

        this.setBounds(300, 50, 900, 600);
        this.setLayout(null);
        this.setBackground(Color.WHITE);



        menu.setLayout(new GridLayout(1, 4));
        menu.setBounds(20, 10, 400, 30);
        menu.add(this.btAjouter);
        menu.add(this.btSupprimer);
        menu.add(this.btLister);
        menu.add(this.btRechercher);
        this.add(menu);

        this.btAjouter.addActionListener(this);
        this.btLister.addActionListener(this);
        this.btRechercher.addActionListener(this);
        this.btSupprimer.addActionListener(this);

        this.add(unPanelAjoutClient);
        this.add(unPanelListerClient);

        this.btQuitter.setBounds(700, 440, 100, 20);
        menu.add(this.btQuitter);
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
                unPanelAjoutClient.setVisible(true);
                unPanelListerClient.setVisible(false);
                break;
            case "Lister" :
                unPanelListerClient.setVisible(true);
                unPanelAjoutClient.setVisible(false);
                break;
        }

    }

}
