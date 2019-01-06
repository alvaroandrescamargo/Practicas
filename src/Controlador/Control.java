package Controlador;

import Modelo.*;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class Control implements ActionListener{

    
    Almacenamiento al=new Almacenamiento();
    RegUsuario vista=new RegUsuario();
    ConsultasSQL cons=new ConsultasSQL();
    
    private String nombre1;
    private String nombre2;
    private String apellido1;
    private String apellido2;
    private String ciudad;
    private Long cedula;
    
    
public Control(RegUsuario vista, ConsultasSQL cons, Almacenamiento al){
    
    vista.btnConsulta.addActionListener(this);
    vista.btnEliminar.addActionListener(this);
    vista.btnLimpiar.addActionListener(this);
    vista.btnModificar.addActionListener(this);
    vista.btnRegistrar.addActionListener(this);
    vista.jtxApellido1.addActionListener(this);
    vista.jtxApellido2.addActionListener(this);
    vista.jtxCedula.addActionListener(this);
    vista.jtxCiudad.addActionListener(this);
    vista.jtxNombre1.addActionListener(this);
    vista.jtxNombre2.addActionListener(this);
    
    this.al=al;
    this.cons=cons;
    this.vista=vista;
     
    
}

    public void Limpiar(){
        
        vista.jtxApellido1.setText("");
        vista.jtxApellido2.setText("");
        vista.jtxCedula.setText("");
        vista.jtxCiudad.setText("");
        vista.jtxNombre1.setText("");
        vista.jtxNombre2.setText("");
        
        al.setPrimerNombre("");
        al.setSegundoNombre("");
        al.setPrimerApellido("");
        al.setSegundoApellido("");
        al.setCiudad("");
        al.setCedula(null);
        
        nombre1="";
        nombre2="";
        apellido1="";
        apellido2="";
        ciudad="";
        //cedula=null;
        
    }
    
    public void capturaDatos(){
        
        nombre1=vista.jtxNombre1.getText();
        nombre2=vista.jtxNombre2.getText();
        apellido1=vista.jtxApellido1.getText();
        apellido2=vista.jtxApellido2.getText();
        ciudad=vista.jtxCiudad.getText();
        cedula=Long.parseLong(vista.jtxCedula.getText());
        
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==vista.btnConsulta){
            
            cons.MostrarUsuario(Long.parseLong(vista.jtxCedula.getText()), al);
            
            vista.jtxNombre1.setText(al.getPrimerNombre());
            vista.jtxNombre2.setText(al.getSegundoNombre());
            vista.jtxApellido1.setText(al.getPrimerApellido());
            vista.jtxApellido2.setText(al.getSegundoApellido());
            vista.jtxCiudad.setText(al.getCiudad());
            
        }        
        
        if(e.getSource()==vista.btnLimpiar){
            
            Limpiar();
            
        }
        
        if(e.getSource()==vista.btnRegistrar){
            
            capturaDatos();
            
            if (cons.RegistrarUsuario(nombre1, nombre2, apellido1, apellido2, cedula, ciudad)) {
                
                JOptionPane.showMessageDialog(null, "Registro Exitoso");
                
            }
            else{
                 JOptionPane.showMessageDialog(null, "error al registrar");
               
            }
            
        }
        
        if(e.getSource()==vista.btnModificar){
            
            capturaDatos();
            
            if(cons.ModificarUsuario(nombre1, nombre2, apellido1, apellido2, cedula, ciudad)){
                
                JOptionPane.showMessageDialog(null, "Actualizacion Exitosa");
                
            }
            else{
                 JOptionPane.showMessageDialog(null, "error al Actualizar");
               
            }
                
        }
        
        if(e.getSource()==vista.btnEliminar){
            
            capturaDatos();
            
            if(cons.EliminarUsuario(cedula)){
                
                JOptionPane.showMessageDialog(null, "Registro Eliminado Exitosamente");
                
            }
            else{
                 JOptionPane.showMessageDialog(null, "Error al eliminar");
               
            }
                
            Limpiar();
            
        }
          
    }
    
}