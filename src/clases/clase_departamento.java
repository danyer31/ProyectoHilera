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
public class clase_departamento {
    
    private String codigo;
    private String nombre;
    
    Conexion con = new Conexion();
    Connection cn;
    Statement st;
    ResultSet rs;

    public clase_departamento(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
    
    public clase_departamento(){
    
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
    
    public void llenar_combo_departamento(JComboBox<clase_departamento> combo_Departamento_Empleado){
        try {
            String sql = "SELECT departamento.Id_Departamento, departamento.Nombre_Departamento from departamento";
            cn = con.getConnection();
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            combo_Departamento_Empleado.removeAllItems();
            while (rs.next()){
                combo_Departamento_Empleado.addItem(new clase_departamento(
                        rs.getString("Id_Departamento"),
                        rs.getString("Nombre_Departamento")
                ));
            }
            
            
        } catch (SQLException e){
            Logger.getLogger(clase_departamento.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    @Override
    
    public String toString(){
        return nombre;
    }
    
}
