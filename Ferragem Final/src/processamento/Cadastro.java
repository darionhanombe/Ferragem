package processamento;

import Database.SessaoDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author Dario DN
 */
public class Cadastro {

    private String nome;
    private String morada;
    private String DocIdentificacao;
    private String cont;
    private String confirmar, senha;
    private String genero;

    private int contacto;
    private int sexo, codigo;

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCont() {
        return cont;
    }

    public void setCont(String cont) {
        this.cont = cont;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getDocIdentificacao() {
        return DocIdentificacao;
    }

    public void setDocIdentificacao(String DocIdentificacao) {
        this.DocIdentificacao = DocIdentificacao;
    }

    public int getContacto() {
        return contacto;
    }

    public void setContacto(int contacto) {
        this.contacto = contacto;
    }

    public String getConfirmar() {
        return confirmar;
    }

    public void setConfirmar(String confirmar) {
        this.confirmar = confirmar;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int Sexo) {
        this.sexo = Sexo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void cadastrar(String nome, String morada, String DocIdentificacao, String contacto, int sexo, int codigo, String confirmar, String senha) {
        this.nome = nome;
        this.morada = morada;
        this.DocIdentificacao = DocIdentificacao;
        this.cont = contacto;
        this.sexo = sexo;
        this.codigo = codigo;
        this.confirmar = confirmar;
        this.senha = senha;

        switch (getSexo()) {
            case 0:
                setGenero("Masculino");
                break;
            case 1:
                setGenero("Femenino");
                break;
            case 2:
                setGenero("Nao Indicar");
                break;
            default:
                break;
        }

        int tamanho = getCont().length();
        try {
            String numero = getCont();
            if (numero.substring(0, 2).equals("82") || numero.substring(0, 2).equals("83") || numero.substring(0, 2).equals("84") || numero.substring(0, 2).equals("85") || numero.substring(0, 2).equals("86") || numero.substring(0, 2).equals("87") && tamanho == 9) {
                setContacto(Integer.parseInt(getCont()));
            } else {
                JOptionPane.showMessageDialog(null, "Numero Invalido!");
            }
        } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Numero Invalido!");
        }

        int tamanhosenha = getSenha().length();

        if (tamanhosenha >= 8 && tamanhosenha < 20) {
            if (getSenha().equals(getConfirmar())) {
                SessaoDAO cadastrar = new SessaoDAO();
                cadastrar.cadastrar(this);
                JOptionPane.showMessageDialog(null, "Sucesso! \nCadastro Efectuado!");
            } else {
                JOptionPane.showMessageDialog(null, "Palavra - Passe diferentes!");
                //System.out.println("A palavra passe nao e compativel");
                setSenha("");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Palavra - Passe muito fraca!");
            //System.out.println("Palavra passe muito fraca!");
        }

    }

}
