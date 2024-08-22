package logica;
/**
 * Datatype para transportar la información de un usuario entre capa lógica y de presentación.
 * En Java los datatypes se definen con setters y getters, y se denominan JavaBean.
 */
import java.util.Date;

public class DataCliente {

	private String nickname;
	private String email;
    private String nombre;
    private String apellido;
    private Date fNacimiento;
    //atributo imagen

    public DataCliente() {
    	this.setNickname(new String());
    	this.setEmail(new String());
        this.setNombre(new String());
        this.setApellido(new String());
        this.setfNacimiento(new Date());
        //imagen por default
    }

    public DataCliente(String nickname, String email, String nombre, String apellido, Date fNacimiento) {
    	this.setNickname(nickname);
        this.setEmail(email);
    	this.setNombre(nombre);
        this.setApellido(apellido);
        this.setfNacimiento(fNacimiento);
    }
    
    public String getNickname() {
        return nickname;
    }
    public String getEmail() {
        return email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Date getfNacimiento() {
        return fNacimiento;
    }

    public String toString() {
        return getNickname() + " - " + getNombre() + " " + getApellido() + " " + getEmail() + " " + getfNacimiento() + ".";
    }
    
    private void setNickname(String nickname) {
        this.nickname = nickname;
    }
    private void setEmail(String email) {
        this.email = email;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private void setApellido(String apellido) {
        this.apellido = apellido;
    }

    private void setfNacimiento(Date fNacimiento) {
        this.fNacimiento = fNacimiento;
    }

}