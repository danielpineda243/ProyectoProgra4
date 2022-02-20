
package Controlador;

import consulta.ConsultasVendedor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import proyectoprogra4.vendedor;
import vista.FrmVendedor;

/**
 *
 * @author jaredt907
 */
public class CtrlVentas implements ActionListener {
    private vendedor mod;
    private ConsultasVendedor modC;
    private FrmVendedor Frm;
    
    public CtrlVentas(vendedor mod, ConsultasVendedor modC, FrmVendedor Frm)
    {
     this.mod = mod;
     this.modC = modC;
     this.Frm = Frm;
     this.Frm.btnGuardar.addActionListener(this);
     this.Frm.btnModificar.addActionListener(this);
     this.Frm.btnEliminar.addActionListener(this);
     this.Frm.btnLimpiar.addActionListener(this);
     
     
    }
    public void iniciar()
    {
    Frm.setTitle("Vendedor");
    Frm.setLocationRelativeTo(null);
    
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
    if(e.getSource() == Frm.btnGuardar)
    {
        mod.setId(Integer.parseInt(Frm.txtId.getText()));
        mod.setNombre(Frm.txtUsuario.getText());
        mod.setEdad(Integer.parseInt(Frm.txtEdad.getText()));
        
        if(modC.registrar(mod))
        {
            JOptionPane.showMessageDialog(null, "registro guardado");
            limpiar();
        }else{
            JOptionPane.showMessageDialog(null, "Error al guardado");
            limpiar();
        }
        
    }
    if(e.getSource() == Frm.btnModificar)
    {
        mod.setId(Integer.parseInt(Frm.txtId.getText()));
        mod.setNombre(Frm.txtUsuario.getText());
        mod.setEdad(Integer.parseInt(Frm.txtEdad.getText()));
        
        if(modC.modificar(mod))
        {
            JOptionPane.showMessageDialog(null, "registro modificado");
            limpiar();
        }else{
            JOptionPane.showMessageDialog(null, "Error al modificar");
            limpiar();
        }
        
    }
     if(e.getSource() == Frm.btnEliminar)
    {
        mod.setId(Integer.parseInt(Frm.txtId.getText()));
        mod.setNombre(Frm.txtUsuario.getText());
        mod.setEdad(Integer.parseInt(Frm.txtEdad.getText()));
        
        if(modC.registrar(mod))
        {
            JOptionPane.showMessageDialog(null, "registro eliminado");
            limpiar();
        }else{
            JOptionPane.showMessageDialog(null, "Error al eliminar ");
            limpiar();
        }
       
    }
      
    if(e.getSource()== Frm.btnLimpiar){
    limpiar();
    }
    }
    public void limpiar()
    {
    Frm.txtId.setText(null);
    Frm.txtUsuario.setText(null);
    Frm.txtEdad.setText(null);
            
    }
    
    
}
