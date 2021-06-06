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
public class clase_tipo_mantenimiento {
    
    private String codigo;
    private String nombre;
    
    Conexion con = new Conexion();
    Connection cn;
    Statement st;
    ResultSet rs;

    public clase_tipo_mantenimiento(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
    
    public clase_tipo_mantenimiento(){
    
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
    
    public void llenar_combo_tipo_mantenimiento(JComboBox<clase_tipo_mantenimiento> combo_tipo_mantenimiento){
        try {
            String sql = "SELECT mantenimiento.Id_Mantenimiento, mantenimiento.Tipo_Mantenimiento from mantenimiento";
            cn = con.getConnection();
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            combo_tipo_mantenimiento.removeAllItems();
            while (rs.next()){
                combo_tipo_mantenimiento.addItem(new clase_tipo_mantenimiento(
                        rs.getString("Id_Mantenimiento"),
                        rs.getString("Tipo_Mantenimiento")
                ));
            }
            
            
        } catch (SQLException e){
            Logger.getLogger(clase_tipo_mantenimiento.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    @Override
    
    public String toString(){
        return nombre;
    }
    
}
