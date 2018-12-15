package net.eoapp.obligatorioandroid.EntidadesCompartidas;

public class dtPedido {

    dtProducto elProducto;
    int cantidad;
    int total;
    boolean entregado;
    boolean prepagado;
    String cliente;

    public dtPedido()
    {
        this.elProducto = new dtProducto();
        this.cantidad = 0;
        this.total = 0;
        this.entregado = false;
        this.prepagado = false;
        this.cliente = "";

    }

    public dtPedido(dtProducto elProducto, int cantidad, boolean entregado, boolean prepagado, String cliente) {
        this.elProducto = elProducto;
        this.cantidad = cantidad;
        if (elProducto != null)
        this.total = elProducto.getPrecio() * cantidad;
        this.entregado = entregado;
        this.prepagado = prepagado;
        this.cliente = cliente;
    }

    public dtProducto getElProducto() {
        return elProducto;
    }

    public void setElProducto(dtProducto elProducto) {
        this.elProducto = elProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean isEntregado() {
        return entregado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }

    public boolean isPrepagado() {
        return prepagado;
    }

    public void setPrepagado(boolean prepagado) {
        this.prepagado = prepagado;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
}
