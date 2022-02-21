package controlador;

import consulta.ConsultaCliente;
import formularios.FormCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import static jdk.vm.ci.meta.JavaKind.Int;
import proyectoprogra4.cliente;

public class ControladorCliente implements ActionListener {

    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
      
    }
    private cliente clien;
    private FormCliente frmcliente;
    private ConsultaCliente cnscliente;

    public ControladorCliente(cliente clien, FormCliente frmcliente, ConsultaCliente cnscliente) {
        this.clien = clien;
        this.frmcliente = frmcliente;
        this.cnscliente = cnscliente;
        this.frmcliente.btnAgregar.addActionListener(this);
        this.frmcliente.btnBuscar.addActionListener(this);
        this.frmcliente.btnEditar.addActionListener(this);
        this.frmcliente.btnBorrar.addActionListener(this);
    }

    public void Iniciar() {
        frmcliente.setTitle("Cliente");
        frmcliente.setLocationRelativeTo(null);
        frmcliente.txtId.setVisible(false);

    }

    public void acctionPerfomed(ActionEvent e) {
         if(e.getSource() == frmcliente.btnAgregar)
    {
        clien.setId(Integer.parseInt(frmcliente.txtId.getText()));
        clien.setNombre(frmcliente.txtNombre.getText());
        clien.setEdad(Integer.parseInt(frmcliente.txtEdad.getText()));
        
        if(cnscliente.Agregar(clien))
        {
            JOptionPane.showMessageDialog(null, "Registro guardado con exito");
            Limpiar();
        }else{
            JOptionPane.showMessageDialog(null, "Error, no se pudo guardar");
            Limpiar();
        }
        
    }
    if(e.getSource() == frmcliente.btnEditar)
    {
        clien.setId(Integer.parseInt(frmcliente.txtId.getText()));
        clien.setNombre(frmcliente.txtNombre.getText());
        clien.setEdad(Integer.parseInt(frmcliente.txtEdad.getText()));
        
        if(cnscliente.Editar(clien))
        {
            JOptionPane.showMessageDialog(null, "Registro editado con exito");
            Limpiar();
        }else{
            JOptionPane.showMessageDialog(null, "Error al editar");
           Limpiar();
        }
        
    }
     if(e.getSource() == frmcliente.btnBorrar)
    {
        clien.setId(Integer.parseInt(frmcliente.txtId.getText()));
        clien.setNombre(frmcliente.txtNombre.getText());
        clien.setEdad(Integer.parseInt(frmcliente.txtEdad.getText()));
        
        if(cnscliente.Borrar(clien))
        {
            JOptionPane.showMessageDialog(null, "Registro Eliminado");
            Limpiar();
        }else{
            JOptionPane.showMessageDialog(null, "Error, no fue eliminado");
            Limpiar();
        }
       
    }

     if(e.getSource()== frmcliente.btnBuscar){
         
    Limpiar();
    }
    }
    
    public void Limpiar()
    {
    frmcliente.txtId.setText("");
    frmcliente.txtNombre.setText("");
    frmcliente.txtEdad.setText("");
            
    }
    
    
}