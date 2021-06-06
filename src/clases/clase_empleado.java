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
public class clase_empleado {
    
    private String codigo;
    private String nombre;
    
    Conexion con = new Conexion();
    Connection cn;
    Statement st;
    ResultSet rs;

    public clase_empleado(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
    
    public clase_empleado(){
    
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
    
    public void llenar_combo_empleado(JComboBox<clase_empleado> combo_empleado){
        try {
            String sql = "SELECT empleado.Id_Empleado, empleado.Nombre_Empleado from empleado";
            cn = con.getConnection();
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            combo_empleado.removeAllItems();
            while (rs.next()){
                combo_empleado.addItem(new clase_empleado(
                        rs.getString("Id_Empleado"),
                        rs.getString("Nombre_Empleado")
                ));
            }
            
            
        } catch (SQLException e){
            Logger.getLogger(clase_empleado.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    @Override
    
    public String toString(){
        return nombre;
    }
    
}
