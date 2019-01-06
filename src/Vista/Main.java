package Vista;

import Controlador.Control;
import Modelo.*;
import java.lang.ref.Reference;


public class Main {

    public static void main(String[] args) {

        RegUsuario ventana=new RegUsuario();   
        ConsultasSQL cons=new ConsultasSQL();
        Almacenamiento al=new Almacenamiento();
        Control cont=new Control(ventana, cons, al);
        
        
        
        
        
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);     
        
        System.err.println("");
        
    }
    
}
