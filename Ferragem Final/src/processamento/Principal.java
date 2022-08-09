package processamento;

import FiltroFicheiro.FileTypeFilter;
import Interface.TelaPrincipal;
import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Principal {

    private String nome;
    private String endereco;
    private String tel;
    private String relato;

    private int telefone;
    private int produtos;
    private int qtd;
    private double preco;
    private double valor;

    private final TelaPrincipal principal;

    //Construtor
    public Principal(TelaPrincipal principal) {
        this.principal = principal;
    }

    //Getters And Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getTel() {
        return tel;
    }

    public String getRelato() {
        return relato;
    }

    public void setRelato(String relato) {
        this.relato = relato;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public int getProdutos() {
        return produtos;
    }

    public void setProdutos(int produtos) {
        this.produtos = produtos;
    }

    //Metodo Enviar Dados
    public void Enviar(String nome, String telefone, String endereco) {
        this.nome = nome;
        this.tel = telefone;
        this.endereco = endereco;

        try {
            String validar = getTel();
            int tamanho = getTel().length();
            if (validar.substring(0, 2).equals("82") || validar.substring(0, 2).equals("83") || validar.substring(0, 2).equals("84") || validar.substring(0, 2).equals("85") || validar.substring(0, 2).equals("86") || validar.substring(0, 2).equals("87") && tamanho == 9) {
                setTelefone(Integer.parseInt(getTel()));
            } else {
                JOptionPane.showMessageDialog(null, "Número Inválido");
            }
        } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Número Inválido");
        }
    }

    //Metodo que determina os precos
    public void Precario(int produtos, double preco, int qtd, double valor) {
        this.produtos = produtos;
        this.preco = preco;
        this.qtd = qtd;
        this.valor = valor;

        switch (getProdutos()) {
            case 0:
                setValor(250);
                setPreco(getQtd() * getValor());
                break;
            case 1:
                setValor(200);
                setPreco(getQtd() * getValor());
                break;
            case 2:
                setValor(250);
                setPreco(getQtd() * getValor());
                break;
            case 3:
                setValor(7500);
                setPreco(getQtd() * getValor());
                break;
            case 4:
                setValor(3500);
                setPreco(getQtd() * getValor());
                break;
            case 5:
                setValor(3500);
                setPreco(getQtd() * getValor());
                break;
            case 6:
                setValor(2000);
                setPreco(getQtd() * getValor());
                break;
            case 7:
                setValor(700);
                setPreco(getQtd() * getValor());
                break;
            case 8:
                setValor(75);
                setPreco(getQtd() * getValor());
                break;
            case 9:
                setValor(150);
                setPreco(getQtd() * getValor());
                break;
            case 10:
                setValor(150);
                setPreco(getQtd() * getValor());
                break;
            case 11:
                setValor(75);
                setPreco(getQtd() * getValor());
                break;
            case 12:
                setValor(200);
                setPreco(getQtd() * getValor());
                break;
            case 13:
                setValor(100);
                setPreco(getQtd() * getValor());
                break;
            case 14:
                setValor(175);
                setPreco(getQtd() * getValor());
                break;
            default:
                JOptionPane.showMessageDialog(null, "Produto Invalido");
                break;
        }

    }

    //Metodo de erro de quantidade
    public void QtdErro() {
        JOptionPane.showMessageDialog(null, "Quantidade Inválida.");
    }

    //Metdodo Sair do sistema
    public void Sair() {
        UIManager.put("OptionPane.titleText", "Sair");
        UIManager.put("OptionPane.cancelButtonText", "Cancelar");
        UIManager.put("OptionPane.noButtonText", "Não");
        UIManager.put("OptionPane.yesButtonText", "Sim");

        int saida = JOptionPane.showConfirmDialog(null, "Deseja Sair do Sistema?");
        if (saida == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    //Metodo guardar relatorio
    public void SaveRelato(String relato) {
        setRelato(relato);
        UIManager.put("FileChooser.saveButtonText", "Salvar");
        UIManager.put("FileChooser.cancelButtonText", "Cancelar");

        JFileChooser fc = new JFileChooser("D:\\Sistema\\Ferragem\\Relatorios");

        fc.setDialogTitle("Salvar Arquivo");
        fc.setToolTipText("Salve seu arquivo onde quiser.");

        fc.setFileFilter(new FileTypeFilter(".txt", "File Text"));
        fc.setFileFilter(new FileTypeFilter(".doc", "Word File"));
        int res = fc.showSaveDialog(null);

        if (res == JFileChooser.APPROVE_OPTION) {
            try {
                try (FileWriter fw = new FileWriter(fc.getSelectedFile() + ".doc")) {
                    fw.write(getRelato());
                    fw.flush();
                    fw.close();
                    JOptionPane.showMessageDialog(null, "Sucesso! Arquivo Salvo.");
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar arquivo!");
            }
        }
    }
    
    
 
 
    public void criar() {
        try {
            File ficheiro = new File("D:\\Sistema\\Ferragem\\Relatorios\\Relatorio");
            ficheiro.createNewFile();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar documento.");
        }
    }
    
    public void escrever(){
        try {
            try (FileWriter fw = new FileWriter("D:\\Sistema\\Ferragem\\Relatorios\\Relatorio.doc")) {
                fw.write(getRelato());
                fw.flush();
                fw.close();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao escrever no documento!");
        }
    }
    
    public void Imprimir(String way){
        Desktop desktop = Desktop.getDesktop();
        try {
            File ficheiro = new File(way);
            desktop.print(ficheiro);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar imprimir!");
        }
    }

}
