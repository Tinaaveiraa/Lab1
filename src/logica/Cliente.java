package logica;

import java.util.Date;

public class Cliente {

	private String nickname;
	private String email;
    private String nombre;
    private String apellido;
    private String fNacimiento;
    //atributo imagen

    public Cliente(String nick, String em, String n, String ap, String fNac) {
    	this.nickname = nick;
    	this.email = em;
    	this.nombre = n;
        this.apellido = ap;
        this.fNacimiento = fNac;
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

	public Date getToolTipText() {
		// TODO Auto-generated method stub
		return null;
	}
	public Date setToolTipText() {
		// TODO Auto-generated method stub
		return null;
	}

}
