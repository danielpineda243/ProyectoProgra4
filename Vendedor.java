
package Modelo;


public class Vendedor extends Usuario {
    
    private String Password;
    
    
    //constructor 
    public Vendedor(String Nombre, int Edad, int id, String Password){
        super(Nombre,Edad,id);
        this.Password = Password;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
  
  
 

   
}
