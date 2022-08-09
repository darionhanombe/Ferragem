package processamento;

import Database.SessaoDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author EllPuto
 */
public class Admin {

    private int admin;
    private String contadmin, senhaadmin;

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    public String getContadmin() {
        return contadmin;
    }

    public void setContadmin(String contadmin) {
        this.contadmin = contadmin;
    }

    public String getSenhaadmin() {
        return senhaadmin;
    }

    public void setSenhaadmin(String senhaadmin) {
        this.senhaadmin = senhaadmin;
    }


    public void Confirma(String conta, String senha) {
        this.contadmin = conta;
        this.senhaadmin = senha;
        
       SessaoDAO confere = new SessaoDAO();
        
        try {
            int tamanho = getContadmin().length();
            if (tamanho > 1 && tamanho < 5) {
                setAdmin(Integer.parseInt(getContadmin()));
                confere.confereAdmin(this);
            } else {
                 JOptionPane.showMessageDialog(null, "Conta do Administrador Invalida!");
            }
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Conta do Administrador Invalida!");
        }
    }
}
