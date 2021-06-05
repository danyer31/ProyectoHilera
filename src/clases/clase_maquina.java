package clases;
import config.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author daniel
 */
public class clase_maquina {
    
    private String codigo;
    private String nombre;
    
    Conexion con = new Conexion();
    Connection cn;
    Statement st;
    ResultSet rs;

    public clase_maquina(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
    
    public clase_maquina(){
    
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void llenar_combo_motor(JComboBox<clase_maquina> combo_maquina){
        try {
            String sql = "SELECT maquina.Id_Maquina, maquina.Nombre_Maquina from maquina";
            cn = con.getConnection();
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            combo_maquina.removeAllItems();
            while (rs.next()){
                combo_maquina.addItem(new clase_maquina(
                        rs.getString("Id_Maquina"),
                        rs.getString("Nombre_Maquina")
                ));
            }
            
            
        } catch (SQLException e){
            Logger.getLogger(clase_maquina.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    @Override
    
    public String toString(){
        return nombre;
    }
    
}
