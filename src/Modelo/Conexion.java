package Modelo;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.SQLException;

public class Conexion 
{
    
    Connection conectar=null;
    private String db="crud";
    private String usuario="root";
    private String clave="";
    private String url="jdbc:mysql://localhost:3306/"+db;
    
    public Conexion(){
        
    }
    
    public Connection conexion(){
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            conectar=DriverManager.getConnection(url,usuario,clave);

            
            System.out.println("Conecto");
        
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return conectar;
    }
}
