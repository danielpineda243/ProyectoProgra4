package controlador;

import consulta.ConsultaCliente;
import formularios.FormCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import static jdk.vm.ci.meta.JavaKind.Int;
import proyectoprogra4.cliente;

public class ControladorCliente implements ActionListener {

    private cliente clien;
    private FormCliente frmcliente;
    private ConsultaCliente cnscliente;

    public ControladorCliente(cliente clien, FormCliente frmcliente, ConsultaCliente cnscliente) {
        this.clien = clien;
        this.frmcliente = frmcliente;
        this.cnscliente = cnscliente;
        this.frmcliente.btnAgregar.addActionListener((ActionListener) this);
        this.frmcliente.btnBuscar.addActionListener((ActionListener) this);
        this.frmcliente.btnEditar.addActionListener((ActionListener) this);
        this.frmcliente.btnBorrar.addActionListener((ActionListener) this);
    }

    public void Iniciar() {
        frmcliente.setTitle("Cliente");
        frmcliente.setLocationRelativeTo(null);
        frmcliente.txtId.setVisible(true);

    }

    @Override

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmcliente.btnAgregar) {
            clien.setNombre(frmcliente.txtNombre.getText());
            clien.setEdad(Integer.parseInt(frmcliente.txtEdad.getText()));
            clien.setId(Integer.parseInt(frmcliente.txtId.getText()));
            //Esta es la parte que debe ir en orden al momento del menu

            if (cnscliente.Agregar(clien)) {
                JOptionPane.showMessageDialog(null, "Registro guardado con exito");
                Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error, no se pudo guardar");
                Limpiar();
            }

        }
        if (e.getSource() == frmcliente.btnEditar) {
            clien.setNombre(frmcliente.txtNombre.getText());
            clien.setEdad(Integer.parseInt(frmcliente.txtEdad.getText()));
            clien.setId(Integer.parseInt(frmcliente.txtId.getText()));

            if (cnscliente.Editar(clien)) {
                JOptionPane.showMessageDialog(null, "Registro editado con exito");
                Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al editar");
                Limpiar();
            }

        }
        if (e.getSource() == frmcliente.btnBorrar) {
            clien.setId(Integer.parseInt(frmcliente.txtId.getText()));

            if (cnscliente.Borrar(clien)) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error, no fue eliminado");
                Limpiar();
            }

        }

        if (e.getSource() == frmcliente.btnBuscar) {
            //clien.setId(formcliente.txtpelicula.getText());esto se convierte 
            clien.setId(Integer.parseInt(frmcliente.txtId.getText()));

            if (cnscliente.buscar(clien)) {
                frmcliente.txtNombre.setText(clien.getNombre());
                frmcliente.txtEdad.setText(String.valueOf(clien.getEdad()));
                //se agrega el parentesis y el string dspues de setTet
                frmcliente.txtId.setText(String.valueOf(clien.getId()));
                System.out.println(clien.getNombre()+clien.getEdad()+clien.getId());
                

            } else {
                JOptionPane.showMessageDialog(null, "error ");
            }

        }
    }

    public void Limpiar() {
        frmcliente.txtId.setText("");
        frmcliente.txtNombre.setText("");
        frmcliente.txtEdad.setText("");

    }

}
