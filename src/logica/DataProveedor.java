package logica;
import java.util.Date;
/**
 * Datatype para transportar la información de un usuario entre capa lógica y de presentación.
 * En Java los datatypes se definen con setters y getters, y se denominan JavaBean.
 */
public class DataProveedor {

	private String nickname;
	private String email;
    private String nombre;
    private String apellido;
    private Date fNacimiento;
    private String URL;
    private String nombreEmpresa;
    //atributo imagen

    public DataProveedor() {
    	this.setNickname(new String());
    	this.setEmail(new String());
        this.setNombre(new String());
        this.setApellido(new String());
        this.setfNacimiento(new Date());
        this.setURL(new String());
        this.setNombreEmpresa(new String());
        //imagen por default
    }

    public DataProveedor(String nickname, String email, String nombre, String apellido, Date fNacimiento, String URL, String nombreEmpresa) {
    	this.setNickname(nickname);
        this.setEmail(email);
    	this.setNombre(nombre);
        this.setApellido(apellido);
        this.setfNacimiento(fNacimiento);
        this.setURL(URL);
        this.setNombreEmpresa(nombreEmpresa);
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
    public String getURL() {
        return URL;
    }
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    /* Sirve para mostrar textualmente la información del usuario, por ejemplo en un ComboBox
     */
    //public String toString() {
     //   return getCedulaIdentidad() + " (" + getNombre() + " " + getApellido() + ")";
   // }
    
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
    private void setURL(String URL) {
        this.URL = URL;
    }
    private void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

}