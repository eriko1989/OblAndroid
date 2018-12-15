package net.eoapp.obligatorioandroid.EntidadesCompartidas;

public class dtProducto {

    private int idProducto;
    private String categoría;
    private String nombre;
    private String descripcion;
    private String foto;
    private int precio;

    public dtProducto()
    {
        this.idProducto = -1;
        this.categoría = "";
        this.nombre = "";
        this.descripcion = "";
        this.foto = "";
        this.precio = 0;
    }

    public dtProducto(int idProducto, String categoría, String nombre, String descripcion, String foto, int precio) {
        this.idProducto = idProducto;
        this.categoría = categoría;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.foto = foto;
        this.precio = precio;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getCategoría() {
        return categoría;
    }

    public void setCategoría(String categoría) {
        this.categoría = categoría;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
