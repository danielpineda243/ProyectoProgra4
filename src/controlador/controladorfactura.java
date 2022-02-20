/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import consulta.consultafactura;
import formulario.FormFactura;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import proyectoprogra4.facturar;

/**
 *
 * @author LA CHAPARRITA PINEDA
 */
public class controladorfactura implements ActionListener {

	private facturar fac;
	private consultafactura consultaFac;
	private FormFactura FormFac;

	public controladorfactura(facturar fac, consultafactura consultaFac, FormFactura FormFac) {
		this.fac = fac;
		this.consultaFac = consultaFac;
		this.FormFac = FormFac;
		this.FormFac.btnAceptar.addActionListener((ActionListener) this);
	}

	public void Iniciar() {
		FormFac.setTitle("");
		FormFac.setLocationRelativeTo(null);
	}

	public void limpiar() {
		FormFac.txtnumeroF.setText("");
		FormFac.txtvendedor.setText("");
		FormFac.txtnSala.setText("");
		FormFac.txtusuario.setText("");
		FormFac.txthora.setText("");
		FormFac.fecha.setText("");
		FormFac.cmbpelicula.removeAllItems();
		FormFac.txtNAsiento.setText("");
		FormFac.txtnombre.setText("");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == FormFac.btnAceptar) {
}                     
			fac.setNumFactura(Integer.parseInt(FormFac.txtnumeroF.getText()));
			fac.setNombre(FormFac.txtnombre.getText());
			fac.setFecha(FormFac.fecha.getText());
                        fac.setNumeroAsiento(Integer.parseInt(FormFac.txtNAsiento.getText()));
                        fac.setNumeroSala(Integer.parseInt(FormFac.txtnSala.getText()));
			fac.setIdcliente(Integer.parseInt(FormFac.txtusuario.getText()));
			fac.setIdvendedor(Integer.parseInt(FormFac.txtvendedor.getText()));
                        fac.setNpelicula(FormFac.cmbpelicula.getItemCount());
			fac.setHora(FormFac.txthora.getText());
			fac.setDescuento(fac.descuento());
			fac.setPrecio(fac.subtotal(Integer.parseInt(FormFac.txtusuario.getText())));
			fac.setTotal(fac.total());
                          
		if (consultaFac.Registrar(fac)) {
				JOptionPane.showMessageDialog(null, "Boleto comprado exitosamente Exitosamente");
				limpiar();
			} else {
				JOptionPane.showMessageDialog(null, "error ");
			}
		

	}

}
