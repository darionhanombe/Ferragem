package processamento;

import javax.swing.JOptionPane;

public class Sessao {
    private int conta;
    private String cont;
    private String senha;
    
    
    public int getConta() {
        return conta;
    }
    public void setConta(int conta) {
        this.conta = conta;
    }
    public String getCont() {
        return cont;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

   public void Confirma(String cont, String senha){
       this.cont = cont;
       this.senha = senha;
      
       int tamanho = getCont().length();
       
       if(tamanho > 1 && tamanho < 5){
               setConta(Integer.parseInt(getCont()));
           } else{
               JOptionPane.showMessageDialog(null, "Codigo Invalido!" + "\n" + "Verifique seu codigo");
           }
      
     
   }
    
}
