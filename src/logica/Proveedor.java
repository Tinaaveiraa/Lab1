package logica;

public class Proveedor {

	private String nickname;
	private String email;
    private String nombre;
    private String apellido;
    private String fNacimiento;
    private String URL;
    private String nombreEmpresa;
    //atributo imagen

    public Proveedor(String nick, String em, String n, String ap, String fNac, String url, String nomEmp) {
    	this.nickname = nick;
    	this.email = em;
    	this.nombre = n;
        this.apellido = ap;
        this.fNacimiento = fNac;
        this.URL = url;
        this.nombreEmpresa = nomEmp;
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

    public String getfNacimiento() {
        return fNacimiento;
    }
    
    public String getURL() {
        return URL;
    }
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }
    
    public void setNickname(String nick) {
        nickname = nick;
    }
    public void setEmail(String em) {
        email = em;
    }

    public void setNombre(String n) {
        nombre = n;
    }

    public void setApellido(String ap) {
        apellido = ap;
    }

    public void setfNacimiento(String fNac) {
        fNacimiento = fNac;
    }
    
    public void setURL(String url) {
        URL = url;
    }

    public void setNombreEmpresa(String nomEmp) {
        nombreEmpresa = nomEmp;
    }

}
