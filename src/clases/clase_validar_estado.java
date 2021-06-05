package clases;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author daniel
 */
public class clase_validar_estado extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
        JLabel labelResultado = (JLabel)super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1); //To change body of generated methods, choose Tools | Templates.
        if (o instanceof String){
            String Dato = (String)o;
            if(Dato.equals("Activo")){
                labelResultado.setBackground(Color.blue);
                labelResultado.setForeground(Color.white);
            } else{
                if(Dato.equals("Inactivo")){
                    labelResultado.setBackground(Color.red);
                    labelResultado.setForeground(Color.white);
                }
            }
        }
        return labelResultado;
    }


    
}
