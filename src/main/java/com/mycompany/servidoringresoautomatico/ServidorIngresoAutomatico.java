/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.servidoringresoautomatico;

import Clases.Ingresos;
import DAO.IngresosDAO;
import Logica.ProcedemientoAnular;
import Logica.ProcedimientoIngreso;
import Ventana.Consola;
import connect.DbConnection;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.ini4j.Ini;

/**
 *
 * @author sopor
 */
public class ServidorIngresoAutomatico {

    public static DbConnection conex;
    public static Consola consola;

    public static void connection() throws IOException {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                try {
                    conex.desconectar();
                    System.out.println("Desconectando...");
                } catch (SQLException ex) {
                    Logger.getLogger(ServidorIngresoAutomatico.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        conex = new DbConnection();

        Thread thread = new Thread(() -> {
            int cont = 0;
            while (true) {
                try {
                    if (conex.getConnection() == null) {
                        try {
                            conex = new DbConnection();
                        } catch (IOException ex) {
                            Logger.getLogger(ServidorIngresoAutomatico.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else if (conex.getConnection().isClosed()) {
                        try {
                            conex = new DbConnection();
                        } catch (IOException ex) {
                            Logger.getLogger(ServidorIngresoAutomatico.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    cont++;
                    Thread.sleep(1000);
                } catch (SQLException ex) {
                    Logger.getLogger(ServidorIngresoAutomatico.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ServidorIngresoAutomatico.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        thread.start();
    }

    public static void reiniciar(String[] args) throws IOException {
        StringBuilder cmd = new StringBuilder();
        cmd.append(System.getProperty("java.home")).append(File.separator).append("bin").append(File.separator).append("java ");
        for (String jvmArg : ManagementFactory.getRuntimeMXBean().getInputArguments()) {
            cmd.append(jvmArg + " ");
        }
        cmd.append("-cp ").append(ManagementFactory.getRuntimeMXBean().getClassPath()).append(" ");
        cmd.append(ServidorIngresoAutomatico.class.getName()).append(" ");
        for (String arg : args) {
            cmd.append(arg).append(" ");
        }
        Runtime.getRuntime().exec(cmd.toString());
        System.exit(0);
    }

    public static void main(String[] args) throws IOException, SQLException, AWTException {
        Consola consola = new Consola(new JFrame(), true);
        consola.setVisible(false);
        Consola.jTextArea1.setEditable(false);

        if (!SystemTray.isSupported()) {
            System.out.println("System tray is not supported !!! ");
            return;
        }
        SystemTray systemTray = SystemTray.getSystemTray();

        Image image = Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir") + "/images/server.png");

        PopupMenu trayPopupMenu = new PopupMenu();

        MenuItem close = new MenuItem("Cerrar");
        close.addActionListener((java.awt.event.ActionEvent e) -> {
            System.exit(0);
        });
        trayPopupMenu.add(close);

        MenuItem reiniciar = new MenuItem("Reiniciar");
        reiniciar.addActionListener((java.awt.event.ActionEvent e) -> {
            try {
                reiniciar(args);
            } catch (IOException ex) {
                Logger.getLogger(ServidorIngresoAutomatico.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        trayPopupMenu.add(reiniciar);
        
        TrayIcon trayIcon = new TrayIcon(image, "Servidor Ingresos", trayPopupMenu);
        trayIcon.setImageAutoSize(true);
        systemTray.add(trayIcon);

        connection();

        File fileToParse = new File("config.ini");
        Ini ini = new Ini(fileToParse);
        String localConfig = ini.get("Local", "l");
        String ruta = ini.get("Ruta", "r");
        String usuarioSaf = ini.get("Usuario", "u");

        while (true) {
            try {
                ArrayList<Integer> selectDistincIndice = IngresosDAO.selectDistincIndiceFalse(localConfig);

                System.out.println("selectDistincIndice.size() " + selectDistincIndice.size());

                for (int i = 0; i < selectDistincIndice.size(); i++) {
                    int indicex = selectDistincIndice.get(i);

                    ArrayList<Ingresos> selectProductoIngresadoFalseSI = IngresosDAO.selectProductoIngresadoFalseSI("" + indicex, localConfig);
                    System.out.println("XX---------------------- SI ---------------------------XX");

                    selectProductoIngresadoFalseSI.stream().forEach((Ingresos ingreso) -> {
                        String cantidad = ingreso.getCantidad();
                        String codigo = ingreso.getCodigo();
                        String codigoOriginal = ingreso.getCodigoOriginal();
                        String estado = ingreso.getEstado();
                        Timestamp fecha = ingreso.getFecha();
                        int indice = ingreso.getIndice();
                        String local = ingreso.getLocal();
                        String operador = ingreso.getOperador();
                        String ordenDeCompra = ingreso.getOrdenDeCompra();
                        String rtu = ingreso.getRtu();
                        String usuario = ingreso.getUsuario();

                        System.out.println("cantidad " + cantidad);
                        System.out.println("codigo " + codigo);
                        System.out.println("codigoOriginal " + codigoOriginal);
                        System.out.println("estado " + estado);
                        System.out.println("fecha " + fecha);
                        System.out.println("indice " + indice);
                        System.out.println("local " + local);
                        System.out.println("operador " + operador);
                        System.out.println("ordenDeCompra " + ordenDeCompra);
                        System.out.println("rtu " + rtu);
                        System.out.println("usuario " + usuario);
                        System.out.println("-----------------------------------");
                    });
                    ArrayList<Ingresos> selectProductoIngresadoFalseNO = IngresosDAO.selectProductoIngresadoFalseNO("" + indicex, localConfig);
                    System.out.println("XX---------------------- NO ---------------------------XX");

                    selectProductoIngresadoFalseNO.stream().forEach((Ingresos ingreso) -> {
                        String cantidad = ingreso.getCantidad();
                        String codigo = ingreso.getCodigo();
                        String codigoOriginal = ingreso.getCodigoOriginal();
                        String estado = ingreso.getEstado();
                        Timestamp fecha = ingreso.getFecha();
                        int indice = ingreso.getIndice();
                        String local = ingreso.getLocal();
                        String operador = ingreso.getOperador();
                        String ordenDeCompra = ingreso.getOrdenDeCompra();
                        String rtu = ingreso.getRtu();
                        String usuario = ingreso.getUsuario();

                        System.out.println("cantidad " + cantidad);
                        System.out.println("codigo " + codigo);
                        System.out.println("codigoOriginal " + codigoOriginal);
                        System.out.println("estado " + estado);
                        System.out.println("fecha " + fecha);
                        System.out.println("indice " + indice);
                        System.out.println("local " + local);
                        System.out.println("operador " + operador);
                        System.out.println("ordenDeCompra " + ordenDeCompra);
                        System.out.println("rtu " + rtu);
                        System.out.println("usuario " + usuario);
                        System.out.println("-----------------------------------");
                    });

                    ProcedimientoIngreso.procedimiento2(usuarioSaf, ruta, selectProductoIngresadoFalseSI, selectProductoIngresadoFalseNO,
                            selectProductoIngresadoFalseSI.get(0).getTipoDocumento(), selectProductoIngresadoFalseSI.get(0).getOrdenDeCompra(),
                            selectProductoIngresadoFalseSI.get(0).getNumeroDocumento());
                }

                ArrayList<Integer> selectDistincIndiceAnular = IngresosDAO.selectDistincIndiceAnular(localConfig);

                System.out.println("selectDistincIndiceAnular.size() " + selectDistincIndiceAnular.size());

                for (int i = 0; i < selectDistincIndiceAnular.size(); i++) {

                    int indicex = selectDistincIndiceAnular.get(i);

                    ArrayList<Ingresos> selectProductoIngresadoAnularSI = IngresosDAO.selectProductoIngresadoAnularSI("" + indicex, localConfig);
                    System.out.println("XX---------------------- SI ANULAR ----------------------XX");

                    selectProductoIngresadoAnularSI.stream().forEach((Ingresos ingreso) -> {
                        String cantidad = ingreso.getCantidad();
                        String codigo = ingreso.getCodigo();
                        String codigoOriginal = ingreso.getCodigoOriginal();
                        String estado = ingreso.getEstado();
                        Timestamp fecha = ingreso.getFecha();
                        int indice = ingreso.getIndice();
                        String local = ingreso.getLocal();
                        String operador = ingreso.getOperador();
                        String ordenDeCompra = ingreso.getOrdenDeCompra();
                        String rtu = ingreso.getRtu();
                        String usuario = ingreso.getUsuario();
                        String folio = ingreso.getFolio();

                        System.out.println("cantidad " + cantidad);
                        System.out.println("codigo " + codigo);
                        System.out.println("codigoOriginal " + codigoOriginal);
                        System.out.println("estado " + estado);
                        System.out.println("fecha " + fecha);
                        System.out.println("indice " + indice);
                        System.out.println("local " + local);
                        System.out.println("operador " + operador);
                        System.out.println("ordenDeCompra " + ordenDeCompra);
                        System.out.println("rtu " + rtu);
                        System.out.println("usuario " + usuario);
                        System.out.println("folio " + folio);
                        System.out.println("-----------------------------------");
                    });

                    ProcedemientoAnular.procedimiento3(usuarioSaf, ruta, selectProductoIngresadoAnularSI, selectProductoIngresadoAnularSI.get(0).getTipoDocumento(),
                            selectProductoIngresadoAnularSI.get(0).getOrdenDeCompra(), selectProductoIngresadoAnularSI.get(0).getNumeroDocumento());
                }

                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ServidorIngresoAutomatico.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
