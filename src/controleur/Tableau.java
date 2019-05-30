package controleur;

import javax.swing.table.AbstractTableModel;

public class Tableau extends AbstractTableModel
{
    private Object donnees [][];
    private String entetes [];

    public Tableau (Object donnees [][], String entetes[])
    {
        this.donnees = donnees;
        this.entetes = entetes;
    }

    @Override
    public int getColumnCount() {
        return this.entetes.length;
    }

    @Override
    public int getRowCount() {
        return this.donnees.length;
    }

    @Override
    public Object getValueAt(int ligne, int colonne) {
        return this.donnees[ligne][colonne];
    }

    @Override
    public String getColumnName(int colonne) {

        return this.entetes[colonne];
    }

    @Override
    public Class<?> getColumnClass(int colonne) {

        return this.entetes[colonne].getClass();
    }

    @Override
    public boolean isCellEditable(int ligne, int colonne) {
        return false;
    }

    @Override
    public void setValueAt(Object valeur, int ligne, int colonne) {
        this.donnees[ligne][colonne] = valeur;
    }

    public void insertTable (Object ligne[])
    {
        Object matrice [][] = new Object[this.donnees.length+1][this.entetes.length];
        for (int i = 0; i <this.donnees.length; i++)
        {
            matrice [i] = this.donnees[i];
        }
        matrice[this.donnees.length] = ligne;
        this.donnees = matrice ;
        this.fireTableDataChanged();
    }
    public void deleteTable (int ligne)
    {
        Object matrice [][] = new Object[this.donnees.length-1][this.entetes.length];
        int j = 0;
        for (int i = 0; i <this.donnees.length; i++)
        {
            if (i != ligne)
            {
                matrice [j] = this.donnees[i];
                j++;
            }
        }
        this.donnees = matrice ;
        this.fireTableDataChanged();
    }
    public void updateTable (Object ligne[], int indiceLigne)
    {
        Object matrice [][] = new Object[this.donnees.length][this.entetes.length];
        for (int i = 0; i <this.donnees.length; i++)
        {
            if (i == indiceLigne)
            {
                matrice[i] = ligne;
            }else {
                matrice[i] = this.donnees[i];
            }
        }
        this.donnees = matrice ;
        this.fireTableDataChanged();
    }




    public void setDonnees(String[][] matrice) {
        this.donnees = matrice ;
        this.fireTableDataChanged();
    }

}









