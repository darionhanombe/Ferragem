package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author EllPuto
 */
public class ConexaoDAO {
    public Connection conectar(){
        Connection conecta = null;
        
        try {
            String url = "jdbc:mysql://localhost/Ferragem?user=DNhanombe&password=nhanombeddn";
            conecta = DriverManager.getConnection(url);
        } catch (SQLException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Sem Internet Disponivel \nSem acesso ao servidor" + e.getMessage());
        }
        return conecta;
    }
    

 
}
