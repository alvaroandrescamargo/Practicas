package Modelo;

public class Almacenamiento {

private String primerNombre="";
private String segundoNombre="";
private String primerApellido="";
private String segundoApellido="";
private String Ciudad="";
private Long Cedula;

public Almacenamiento(){}

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public Long getCedula() {
        return Cedula;
    }

    public void setCedula(Long Cedula) {
        this.Cedula = Cedula;
    }


}