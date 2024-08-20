package logica;


public class Producto {

    private String nombre;
    private String descripcion;
    private String especificacion;
    private int numRegistro;
    private float precio;
    //private Categoria *catPadre;
    //atributo imagen

    public Producto(String n, String desc, String espe, int numReg, float prec)// Categoria *catP 
    {
    	
    	this.nombre = n;
        this.descripcion = desc;
        this.especificacion = espe;
        this.numRegistro = numReg;
        this.precio = prec;
        //this.catPadre = catP;
    }

    public String getNombre() {
        return nombre;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public String getEspecificacion() {
        return especificacion;
    }

    public int getNumReg() {
        return numRegistro;
    }

    public float getPrecio() {
        return precio;
    }
    
    public void setNombre(String n) {
        nombre = n;
    }
    public void setDescripcion(String desc) {
        descripcion = desc;
    }

    public void setEspecificacion(String espe) {
        especificacion = espe;
    }

    public void setNumReg(int numReg) {
        numRegistro = numReg;
    }

    public void setPrecio(float prec) {
        precio = prec;
    }

}