package net.eoapp.obligatorioandroid.EntidadesCompartidas;

public class dtProducto {

    private int idProducto;
    private String categoría;
    private String nombre;
    private String descripcion;
    private int  idFoto;
    private  double precio;

    public dtProducto()
    {
        this.idProducto = -1;
        this.categoría = "";
        this.nombre = "";
        this.descripcion = "";
        this.idFoto = -1;
        this.precio = 0;
    }

    public dtProducto(int idProducto, String categoría, String nombre, String descripcion, int foto, double precio) {
        this.idProducto = idProducto;
        this.categoría = categoría;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.idFoto = foto;
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

    public int getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(int idFoto) {
        this.idFoto = idFoto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return getIdProducto() + " - " + getNombre();
    }
}
