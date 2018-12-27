package net.eoapp.obligatorioandroid.EntidadesCompartidas;

import java.io.Serializable;
import java.util.Date;

public class dtPedido implements Serializable {

    dtProducto elProducto;
    int id;
    int cantidad;
    double total;
    boolean entregado;
    boolean prepagado;
    String cliente;
    String fecha;

    public dtPedido()
    {
        this.id = 0;
        this.elProducto = new dtProducto();
        this.cantidad = 0;
        this.total = 0;
        this.entregado = false;
        this.prepagado = false;
        this.cliente = "";
        this.fecha = "";

    }

    public dtPedido(dtProducto elProducto, int cantidad, boolean entregado, boolean prepagado, String cliente, String fecha, int id, double total) {
        this.id = 0;
        this.elProducto = elProducto;
        this.cantidad = cantidad;
        this.total = total;
        this.entregado = entregado;
        this.prepagado = prepagado;
        this.cliente = cliente;
        this.fecha = fecha;
    }

    public dtProducto getElProducto() {
        return elProducto;
    }

    public void setElProducto(dtProducto elProducto) {
        this.elProducto = elProducto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
