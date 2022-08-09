package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import processamento.Admin;
import processamento.Cadastro;
import processamento.Sessao;

/**
 *
 * @author EllPuto
 */
public class SessaoDAO {
    Connection conecta;
    PreparedStatement pstm;
    
    public void cadastrar(Cadastro user){
        String sql = "INSERT INTO Cadastro (Nome, Morada, Contacto, DocIdentificacao, Genero, Codigo, Senha) VALUES (?,?,?,?,?,?,?)";
        ConexaoDAO conn = new ConexaoDAO();
        conecta = conn.conectar();
        
        
        try {
            pstm = conecta.prepareStatement(sql);
            pstm.setString(1, user.getNome());
            pstm.setString(2, user.getMorada());
            pstm.setString(3, user.getCont());
            pstm.setString(4, user.getDocIdentificacao());
            pstm.setString(5, user.getGenero());
            pstm.setInt(6, user.getCodigo());
            pstm.setString(7, user.getSenha());
            pstm.execute();
            pstm.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar-se !!" + ex.getMessage() );
        }
    }
    
    
    public ResultSet logar(Sessao credenciais){
        String sql = "SELECT * FROM Cadastro WHERE Codigo = ? AND Senha = ?";
        ConexaoDAO conn = new ConexaoDAO();
        conecta = conn.conectar();
        
        try {
            pstm = conecta.prepareStatement(sql);
            pstm.setInt(1, credenciais.getConta());
            pstm.setString(2, credenciais.getSenha());
            
            ResultSet rs = pstm.executeQuery();
            return rs;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Senha ou Usuario Incorrectos!");
            return null;
        }
    }
    
    public ResultSet confereAdmin(Admin admin){
        String sql = "SELECT * FROM Administrador WHERE Codigo = ? AND Senha = ?";
        ConexaoDAO conn = new ConexaoDAO();
        conecta = conn.conectar();
        
        try {
            pstm = conecta.prepareStatement(sql);
            pstm.setInt(1, admin.getAdmin());
            pstm.setString(2, admin.getSenhaadmin());
            
            ResultSet rs = pstm.executeQuery();
            return rs;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro" + e.getMessage());
            return null;
        }
        
    }
    
}
