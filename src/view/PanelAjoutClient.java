package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controleur.Client;
import controleur.Main;

public class PanelAjoutClient extends PanelCentral implements ActionListener
{


    private JTextField txtPrenom =new JTextField();
    private JTextField txtAdressepersonnelle = new JTextField();
    private JTextField txtDatenaissance = new JTextField();
    private JTextField txtAdressefacturation = new JTextField();
    private JTextField txtNom = new JTextField();
    private JTextField txtEmail = new JTextField();
    private JTextField txtMdp = new JTextField();


    private JButton btAnnuler = new JButton("Annuler");
    private JButton btEnregistrer = new JButton("Enregistrer");

    public PanelAjoutClient()
    {
        super();
        this.setLayout(new GridLayout(12, 2));
        this.add(new JLabel(""));
        this.add(new JLabel("Ajout d'un client "));

        this.add(new JLabel("Prenom : "));
        this.add(this.txtPrenom);
        this.add(new JLabel("Adressepersonnelle : "));
        this.add(this.txtAdressepersonnelle);
        this.add(new JLabel("Date de naissance : "));
        this.add(this.txtDatenaissance);
        this.add(new JLabel("Adresse de facturation : "));
        this.add(this.txtAdressefacturation);
        this.add(new JLabel("Nom : "));
        this.add(this.txtNom);
        this.add(new JLabel("Email : "));
        this.add(this.txtEmail);
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
                Client unClient = new Client (this.txtPrenom.getText(),
                        this.txtAdressepersonnelle.getText(), this.txtDatenaissance.getText(), this.txtAdressefacturation.getText(), this.txtNom.getText(),
                        this.txtEmail.getText(),this.txtMdp.getText() );
                Main.insertClient(unClient);
                PanelListerClient.mettreAjourTable(Main.selectWhereClient(unClient));
                JOptionPane.showMessageDialog(this,"Insertion realisee avec succes ! ",
                        "Information", JOptionPane.INFORMATION_MESSAGE);

                this.setVisible(false);
            }


        }else
        if (e.getSource() == this.btAnnuler)
        {
            this.txtPrenom.setText("");
            this.txtAdressepersonnelle.setText("");
            this.txtDatenaissance.setText("");
            this.txtAdressefacturation.setText("");
            this.txtNom.setText("");
            this.txtEmail.setText("");
            this.txtMdp.setText("");



        }
    }
}













