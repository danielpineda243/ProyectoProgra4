

package controlador;

import consulta.ConsultaCartelera;
import formularios.Formcartelera;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import proyectoprogra4.cartelera;


public class ControladorCartelera implements ActionListener {
    private cartelera car;
    private ConsultaCartelera consultacar;
    private Formcartelera formcar;

    public ControladorCartelera(cartelera car, ConsultaCartelera consultacar, Formcartelera formcar) {
        this.car = car;
        this.consultacar = consultacar;
        this.formcar = formcar;
        this.formcar.btnagregar.addActionListener((ActionListener)this);
        this.formcar.btnbuscar.addActionListener((ActionListener)this);
        this.formcar.btneditar.addActionListener((ActionListener)this);
        this.formcar.btneliminar.addActionListener((ActionListener)this);
    }
    
    public void Iniciar() {
		formcar.setTitle("");
		formcar.setLocationRelativeTo(null);
	}
    
    public void limpiar() {
		formcar.txtHorarios.setText("");
		formcar.txtpelicula.setText("");
/*		formcar.cmbIdioma.setText(""); 
/*		formcar.cmbTipoSala.setText("");
		*/ //investigar los combobox para limpiar y para almacenar 

	}
    
    @Override
	public void actionPerformed(ActionEvent e) 
        {
		if (e.getSource() == formcar.btnagregar) {
                    car.setPelicula(formcar.txtpelicula.getText());
			car.setHorario(formcar.txtHorarios.getText());
			//*car.setTipoSala(formcar.cmbTipoSala.getText());
                        //car.setIdioma(formcar.cmbIdioma);
                        
                          
		if (consultacar.Agregar(car)) {
				JOptionPane.showMessageDialog(null, "Se ha añadido una nueva pelicula");
				limpiar();
			} else {
				JOptionPane.showMessageDialog(null, "error ");
			}
} 
                if (e.getSource() == formcar.btneditar) {
                    car.setPelicula(formcar.txtpelicula.getText());
			car.setHorario(formcar.txtHorarios.getText());
			//*car.setTipoSala(formcar.cmbTipoSala.getText());
                        //car.setIdioma(formcar.cmbIdioma);
                        
                          
		if (consultacar.editar(car)) {
				JOptionPane.showMessageDialog(null, "Se ha editado la pelicula");
				limpiar();
			} else {
				JOptionPane.showMessageDialog(null, "error ");
			}
                
	}
                if (e.getSource() == formcar.btneliminar) {
                    car.setPelicula(formcar.txtpelicula.getText());
			car.setHorario(formcar.txtHorarios.getText());
			//*car.setTipoSala(formcar.cmbTipoSala.getText());
                        //car.setIdioma(formcar.cmbIdioma);
                        
                          
		if (consultacar.eliminar(car)) {
				JOptionPane.showMessageDialog(null, "Se ha eliminado la pelicula");
				limpiar();
			} else {
				JOptionPane.showMessageDialog(null, "error ");
			}
      
        
        

}
                
}
}
    

