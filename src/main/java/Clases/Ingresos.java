/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.security.Timestamp;

/**
 *
 * @author sopor
 */
public class Ingresos {

    String codigo;
    String cantidad;
    String local;
    String rtu;
    String operador;
    String codigoOriginal;
    java.sql.Timestamp fecha;
    String usuario;
    String ordenDeCompra;
    int indice;
    String estado;
    String tipoDocumento;
    String numeroDocumento;
    String folio;

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getRtu() {
        return rtu;
    }

    public void setRtu(String rtu) {
        this.rtu = rtu;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public String getCodigoOriginal() {
        return codigoOriginal;
    }

    public void setCodigoOriginal(String codigoOriginal) {
        this.codigoOriginal = codigoOriginal;
    }

    public java.sql.Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(java.sql.Timestamp fecha) {
        this.fecha = fecha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getOrdenDeCompra() {
        return ordenDeCompra;
    }

    public void setOrdenDeCompra(String ordenDeCompra) {
        this.ordenDeCompra = ordenDeCompra;
    }
}
