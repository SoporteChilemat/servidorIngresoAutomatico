/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import static com.mycompany.servidoringresoautomatico.ServidorIngresoAutomatico.conex;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Clases.Ingresos;
import java.sql.Statement;

/**
 *
 * @author sopor
 */
public class IngresosDAO {

    public static ArrayList<Integer> selectDistincIndiceAnular(String localConfig) throws SQLException {
        ArrayList<Integer> arrIncice = new ArrayList<>();
        System.out.println("SELECT DISTINCT(indice) FROM dbo.indices WHERE estado = 'anular' AND local = '" + localConfig + "'");
        try (PreparedStatement estatuto = conex.getConnection().prepareStatement("SELECT DISTINCT(indice) FROM dbo.indices WHERE estado = 'anular' AND local = '" + localConfig + "'"); ResultSet res = estatuto.executeQuery()) {
            while (res.next()) {
                arrIncice.add(res.getInt("indice"));
            }
            res.close();
            estatuto.close();
        } catch (Exception ex) {

        }
        return arrIncice;
    }

    public static ArrayList<Integer> selectDistincIndiceFalse(String localConfig) throws SQLException {
        ArrayList<Integer> arrIncice = new ArrayList<>();
        try (PreparedStatement estatuto = conex.getConnection().prepareStatement("SELECT DISTINCT(indice) FROM dbo.indices WHERE estado = 'false' AND local = '" + localConfig + "'"); ResultSet res = estatuto.executeQuery()) {
            while (res.next()) {
                arrIncice.add(res.getInt("indice"));
            }
            res.close();
            estatuto.close();
        } catch (Exception ex) {

        }
        return arrIncice;
    }

    public static ArrayList<Ingresos> selectProductoIngresadoFalseNO(String indice, String localConfig) throws SQLException {
        ArrayList<Ingresos> arrProducto = new ArrayList<>();
        try (PreparedStatement estatuto = conex.getConnection().prepareStatement("SELECT * FROM dbo.ingresos WHERE estado = 'false' AND indice = '" + indice + "' AND cantidad = '0@0@0' AND local = '" + localConfig + "'"); ResultSet res = estatuto.executeQuery()) {
            while (res.next()) {
                Ingresos ingresos = new Ingresos();
                ingresos.setCodigo(res.getString("codigo"));
                ingresos.setCantidad(res.getString("cantidad"));
                ingresos.setLocal(res.getString("local"));
                ingresos.setRtu(res.getString("rtu"));
                ingresos.setOperador(res.getString("operador"));
                ingresos.setCodigoOriginal(res.getString("codigoOriginal"));
                ingresos.setFecha(res.getTimestamp("fecha"));
                ingresos.setUsuario(res.getString("usuario"));
                ingresos.setOrdenDeCompra(res.getString("ordenDeCompra"));
                ingresos.setIndice(res.getInt("indice"));
                ingresos.setEstado(res.getString("estado"));
                ingresos.setTipoDocumento(res.getString("tipoDocumento"));
                ingresos.setNumeroDocumento(res.getString("numeroDocumento"));
                arrProducto.add(ingresos);
            }
            res.close();
            estatuto.close();
        } catch (Exception ex) {

        }
        return arrProducto;
    }

    public static ArrayList<Ingresos> selectProductoIngresadoFalseSI(String indice, String localConfig) throws SQLException {
        ArrayList<Ingresos> arrProducto = new ArrayList<>();
        try (PreparedStatement estatuto = conex.getConnection().prepareStatement("SELECT * FROM dbo.ingresos WHERE estado = 'false' AND indice = '" + indice + "' AND cantidad <> '0@0@0' AND local = '" + localConfig + "'"); ResultSet res = estatuto.executeQuery()) {
            while (res.next()) {
                Ingresos ingresos = new Ingresos();
                ingresos.setCodigo(res.getString("codigo"));
                ingresos.setCantidad(res.getString("cantidad"));
                ingresos.setLocal(res.getString("local"));
                ingresos.setRtu(res.getString("rtu"));
                ingresos.setOperador(res.getString("operador"));
                ingresos.setCodigoOriginal(res.getString("codigoOriginal"));
                ingresos.setFecha(res.getTimestamp("fecha"));
                ingresos.setUsuario(res.getString("usuario"));
                ingresos.setOrdenDeCompra(res.getString("ordenDeCompra"));
                ingresos.setIndice(res.getInt("indice"));
                ingresos.setEstado(res.getString("estado"));
                ingresos.setTipoDocumento(res.getString("tipoDocumento"));
                ingresos.setNumeroDocumento(res.getString("numeroDocumento"));
                arrProducto.add(ingresos);
            }
            res.close();
            estatuto.close();
        } catch (Exception ex) {

        }
        return arrProducto;
    }

    public static ArrayList<Ingresos> selectProductoIngresadoAnularSI(String indice, String localConfig) throws SQLException {
        ArrayList<Ingresos> arrProducto = new ArrayList<>();
        try (PreparedStatement estatuto = conex.getConnection().prepareStatement("SELECT a.codigo, a.cantidad, a.local, a.rtu, a.operador, a.codigoOriginal, a.fecha, a.usuario, a.ordenDeCompra"
                + ", a.indice, a.estado, a.tipoDocumento, a.numeroDocumento, b.folio FROM dbo.ingresos as a INNER JOIN dbo.indices as b on b.estado = 'anular' AND a.indice = '" + indice + "' AND a.cantidad <> '0@0@0' AND a.local = '" + localConfig + "'"); ResultSet res = estatuto.executeQuery()) {
            while (res.next()) {
                Ingresos ingresos = new Ingresos();
                ingresos.setCodigo(res.getString("codigo"));
                ingresos.setCantidad(res.getString("cantidad"));
                ingresos.setLocal(res.getString("local"));
                ingresos.setRtu(res.getString("rtu"));
                ingresos.setOperador(res.getString("operador"));
                ingresos.setCodigoOriginal(res.getString("codigoOriginal"));
                ingresos.setFecha(res.getTimestamp("fecha"));
                ingresos.setUsuario(res.getString("usuario"));
                ingresos.setOrdenDeCompra(res.getString("ordenDeCompra"));
                ingresos.setIndice(res.getInt("indice"));
                ingresos.setEstado(res.getString("estado"));
                ingresos.setTipoDocumento(res.getString("tipoDocumento"));
                ingresos.setNumeroDocumento(res.getString("numeroDocumento"));
                ingresos.setFolio(res.getString("folio"));
                arrProducto.add(ingresos);
            }
            res.close();
            estatuto.close();
        } catch (Exception ex) {

        }
        return arrProducto;
    }

    /*
      select a.[codigo]
      ,a.[cantidad]
      ,a.[local]
      ,a.[rtu]
      ,a.[operador]
      ,a.[codigoOriginal]
      ,a.[fecha]
      ,a.[usuario]
      ,a.[ordenDeCompra]
      ,a.[indice]
      ,a.[estado]
      ,a.[tipoDocumento]
      ,a.[numeroDocumento] 
	  ,b.folio from [ingresoAutomatico].[dbo].[ingresos] as a
	  inner join [ingresoAutomatico].[dbo].[indices] as b on a.indice = b.indice where cantidad <> '0@0@0' and a.indice = '4'
     */
    public static void updateEstado(String ordenDeCompra, String indice, String estado, String localConfig) {
        try (Statement estatuto = conex.getConnection().createStatement()) {
            System.out.println("UPDATE dbo.ingresos SET estado ='" + estado + "' WHERE ordenDeCompra = '" + ordenDeCompra + "' AND indice = '" + indice + "' AND local = '" + localConfig + "'");
            estatuto.executeUpdate("UPDATE dbo.ingresos SET estado ='" + estado + "' WHERE ordenDeCompra = '" + ordenDeCompra + "' AND indice = '" + indice + "' AND local = '" + localConfig + "'");
            estatuto.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
