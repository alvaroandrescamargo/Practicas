package Modelo;

import java.sql.Connection;
import Modelo.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Vista.*;
import javax.swing.JOptionPane;

public class ConsultasSQL {

    RegUsuario registro;
    Connection condb;
    Conexion llamado;
    
    public ConsultasSQL() {
        llamado = new Conexion();

    }

    public void RegistroUsuario() {

    }

    public void MostrarUsuario(Long Cedula, Almacenamiento usuario) {

        String sql = "SELECT * FROM usuarios WHERE cedula='" + Cedula + "'";

        try {
            Connection condb = llamado.conexion();
            PreparedStatement ps = condb.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            boolean cont=true;
            
            while (rs.next()) {
                
                

                usuario.setPrimerNombre(rs.getString(2));
                usuario.setSegundoNombre(rs.getString(3));
                usuario.setPrimerApellido(rs.getString(4));
                usuario.setSegundoApellido(rs.getString(5));
                usuario.setCedula(rs.getLong(6));
                usuario.setCiudad(rs.getString(7));

                cont=rs.next();
            }
            
            System.out.println(cont);
            
        } catch (Exception e) {
            System.out.println("Error DB Mostat Usuario" + e);
        }

    }
    
    public boolean RegistrarUsuario(String Nombre1, String Nombre2, String Apellido1, String Apellido2, Long Cedula, String Ciudad){
        
        String sql = "INSERT INTO usuarios (primer_nombre, segundo_nombre, pirmer_apellido, segundo_apellido, cedula, ciudad) VALUES (?,?,?,?,?,?)";

        try {
            Connection condb = llamado.conexion();
            PreparedStatement ps = condb.prepareStatement(sql);
                        
               ps.setString(1, Nombre1);
               ps.setString(2, Nombre2);
               ps.setString(3, Apellido1);
               ps.setString(4, Apellido2);
               ps.setLong(5, Cedula);
               ps.setString(6, Ciudad);
               
               ps.execute();
               return true;
        } catch (Exception e) {
            System.out.println("Error al registrar "+e);
            JOptionPane.showMessageDialog(null, "error al registrar");
            return false;
        }
        
    }
    
    public boolean ModificarUsuario(String Nombre1, String Nombre2, String Apellido1, String Apellido2, Long Cedula, String Ciudad){
        
        String sql = "UPDATE usuarios SET primer_nombre=?,segundo_nombre=?,pirmer_apellido=?,"
                   + " segundo_apellido=?,cedula=?,ciudad=? WHERE cedula= ?";

        try {
            Connection condb = llamado.conexion();
            PreparedStatement ps = condb.prepareStatement(sql);
                        
               ps.setString(1, Nombre1);
               ps.setString(2, Nombre2);
               ps.setString(3, Apellido1);
               ps.setString(4, Apellido2);
               ps.setLong(5, Cedula);
               ps.setString(6, Ciudad);
               
               ps.setLong(7, Cedula);
               ps.executeUpdate();
               return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error al registrar");
            return false;
        }
        
    }
    
    public boolean EliminarUsuario(Long Cedula){
        
        String sql = "DELETE FROM usuarios WHERE cedula=?";
        
        try {
            Connection condb = llamado.conexion();
            PreparedStatement ps = condb.prepareStatement(sql);
            
            
            ps.setLong(1, Cedula);
            ps.executeUpdate();
               return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error al eliminar");
            return false;
        }
        
    }

}