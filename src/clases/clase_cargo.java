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
public class clase_cargo {
    
    private String codigo;
    private String nombre;
    
    Conexion con = new Conexion();
    Connection cn;
    Statement st;
    ResultSet rs;

    public clase_cargo(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
    
    public clase_cargo(){
    
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
    
    public void llenar_combo_cargo(JComboBox<clase_cargo> combo_Cargo_Empleado){
        try {
            String sql = "SELECT cargo.Id_Cargo, cargo.Nombre_Cargo from cargo";
            cn = con.getConnection();
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            combo_Cargo_Empleado.removeAllItems();
            while (rs.next()){
                combo_Cargo_Empleado.addItem(new clase_cargo(
                        rs.getString("Id_Cargo"),
                        rs.getString("Nombre_Cargo")
                ));
            }
            
            
        } catch (SQLException e){
            Logger.getLogger(clase_cargo.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    @Override
    
    public String toString(){
        return nombre;
    }
    
}
