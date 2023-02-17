/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Clases.Ingresos;
import DAO.IndicesDAO;
import static Logica.ProcedimientoIngresaMercaderia.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author sopor
 */
public class ProcedimientoIngreso {

    public static void procedimiento2(String usuarioSaf, String ruta, ArrayList<Ingresos> arrDocumento, ArrayList<Ingresos> arrDocumentoNO, String comboBox, String ordenDeCompra, String numeroDocumento) throws InterruptedException, MalformedURLException, IOException, SQLException {
        int numReinicio = 10;
        int tiempoEspera = 15;
        int cont = 0;

        for (int t = 0; t < 1; t++) {
            IndicesDAO.updateIndiceEstado("" + arrDocumento.get(0).getIndice(), "ingresando");

            cerrarCP();
            abrirConsultaProducto(ruta);
            System.out.println("1:");
            numReinicio = esperaAbrir("Acceso ...", tiempoEspera);
            System.out.println("numReinicio " + numReinicio);
            if (numReinicio == tiempoEspera) {
                cont++;
                actualizaError(arrDocumento, arrDocumentoNO, "Error: 1");
                IndicesDAO.updateIndiceEstado("" + arrDocumento.get(0).getIndice(), "Error: 1");
                System.out.println("Error: 1");
                break;
            }
            System.out.println("2:");
            numReinicio = sendKeyToElementByID("TxtEditUsuario", usuarioSaf, tiempoEspera, false);
            System.out.println("numReinicio " + numReinicio);
            if (numReinicio == tiempoEspera) {
                  IndicesDAO.updateIndiceEstado("" + arrDocumento.get(0).getIndice(), "Error: 2");

                cerrarCP();

                int sec = 0;
                Runtime r = Runtime.getRuntime();
                try {
                    System.out.println("The PC will get restarted after " + sec + " seconds.");
                    r.exec("shutdown -r -t " + sec);
                } catch (IOException e) {
                    System.out.println("Exception: " + e);
                }
            }
            System.out.println("3:");
            numReinicio = sendKeyToElementByID("TxtEditPasswd", "t55337", tiempoEspera, false);
            System.out.println("numReinicio " + numReinicio);
            if (numReinicio == tiempoEspera) {
                cont++;
                actualizaError(arrDocumento, arrDocumentoNO, "Error: 3");
                IndicesDAO.updateIndiceEstado("" + arrDocumento.get(0).getIndice(), "Error: 3");
                System.out.println("Error: 3");
                break;
            }
            System.out.println("4:");
            numReinicio = clickElementByID("SAFBttnIngresar", tiempoEspera);
            System.out.println("numReinicio " + numReinicio);
            if (numReinicio == tiempoEspera) {
                cont++;
                actualizaError(arrDocumento, arrDocumentoNO, "Error: 4");
                IndicesDAO.updateIndiceEstado("" + arrDocumento.get(0).getIndice(), "Error: 4");
                System.out.println("Error: 4");
                break;
            }
            System.out.println("5:");
            numReinicio = esperaCerrar("Acceso ...", tiempoEspera);
            System.out.println("numReinicio " + numReinicio);
            if (numReinicio == tiempoEspera) {
                cont++;
                actualizaError(arrDocumento, arrDocumentoNO, "Error: 5");
                IndicesDAO.updateIndiceEstado("" + arrDocumento.get(0).getIndice(), "Error: 5");
                System.out.println("Error: 5");
                break;
            }
            System.out.println("6:");
            numReinicio = esperaTabla("Footer Panel", tiempoEspera);
            System.out.println("numReinicio " + numReinicio);
            if (numReinicio == tiempoEspera) {
                cont++;
                actualizaError(arrDocumento, arrDocumentoNO, "Error: 6");
                IndicesDAO.updateIndiceEstado("" + arrDocumento.get(0).getIndice(), "Error: 6");
                System.out.println("Error: 6");
                break;
            }

            for (int x = 0; x < arrDocumento.size(); x++) {
                Ingresos get = arrDocumento.get(x);

                System.out.println("get.getCodigo() " + get.getCodigo());
                System.out.println("7:");
                numReinicio = sendKeyToElementByID("strCodigoProducto", get.getCodigo().replace("-", "/"), tiempoEspera, true);
                System.out.println("numReinicio " + numReinicio);
                if (numReinicio == tiempoEspera) {
                    cont++;
                    actualizaError(arrDocumento, arrDocumentoNO, "Error: 7");
                    IndicesDAO.updateIndiceEstado("" + arrDocumento.get(0).getIndice(), "Error: 7");
                    System.out.println("Error: 7");
                    break;
                }
                System.out.println("8:");
                numReinicio = esperaTabla("Footer Panel", tiempoEspera);
                System.out.println("numReinicio " + numReinicio);
                if (numReinicio == tiempoEspera) {
                    cont++;
                    actualizaError(arrDocumento, arrDocumentoNO, "Error: 8");
                    IndicesDAO.updateIndiceEstado("" + arrDocumento.get(0).getIndice(), "Error: 8");
                    System.out.println("Error: 8");
                    break;
                }

                int valueOf = Integer.parseInt(cantidadBusqueda.replace(".", ""));
                System.out.println("valueOf " + valueOf);

                for (int i = 0; i < valueOf; i++) {
                    System.out.println("9:");
                    Object[] objectsCodigoProductoRow = getTextByName("Código Producto row " + i, tiempoEspera);
                    System.out.println("numReinicio " + Integer.valueOf(objectsCodigoProductoRow[1].toString()));
                    if (Integer.parseInt(objectsCodigoProductoRow[1].toString()) == tiempoEspera) {
                        cont++;
                        actualizaError(arrDocumento, arrDocumentoNO, "Error: 9");
                        IndicesDAO.updateIndiceEstado("" + arrDocumento.get(0).getIndice(), "Error: 9");
                        System.out.println("Error: 9");
                        break;
                    }
                    String codigorow = objectsCodigoProductoRow[0].toString();

                    System.out.println("text            " + codigorow);
                    System.out.println("get.getCodigo() " + get.getCodigo());

                    if (codigorow.equals(get.getCodigo())) {
                        System.out.println("10:");
                        numReinicio = enterElementByName("Código Producto row " + i, i, true);
                        System.out.println("numReinicio " + numReinicio);
                        if (numReinicio == tiempoEspera) {
                            cont++;
                            actualizaError(arrDocumento, arrDocumentoNO, "Error: 10");
                            IndicesDAO.updateIndiceEstado("" + arrDocumento.get(0).getIndice(), "Error: 10");
                            System.out.println("Error: 10");
                            break;
                        }
                        System.out.println("11:");
                        numReinicio = esperaAbrir("Consulta Productos SAF2", tiempoEspera);
                        System.out.println("numReinicio " + numReinicio);
                        if (numReinicio == tiempoEspera) {
                            cont++;
                            actualizaError(arrDocumento, arrDocumentoNO, "Error: 11");
                            IndicesDAO.updateIndiceEstado("" + arrDocumento.get(0).getIndice(), "Error: 11");
                            System.out.println("Error: 11");
                            break;
                        }
                        System.out.println("12:");
                        numReinicio = clickElementByID("ChkBox_HabilitaCambioRTU", tiempoEspera);
                        System.out.println("numReinicio " + numReinicio);
                        if (numReinicio == tiempoEspera) {
                            cont++;
                            actualizaError(arrDocumento, arrDocumentoNO, "Error: 12");
                            IndicesDAO.updateIndiceEstado("" + arrDocumento.get(0).getIndice(), "Error: 12");
                            System.out.println("Error: 12");
                            break;
                        }
                        System.out.println("13:");
                        numReinicio = esperaAbrir("Información", tiempoEspera);
                        System.out.println("numReinicio " + numReinicio);
                        if (numReinicio == tiempoEspera) {
                            cont++;
                            actualizaError(arrDocumento, arrDocumentoNO, "Error: 13");
                            IndicesDAO.updateIndiceEstado("" + arrDocumento.get(0).getIndice(), "Error: 13");
                            System.out.println("Error: 13");
                            break;
                        }
                        System.out.println("14:");
                        numReinicio = clickElementByName("&Sí", tiempoEspera);
                        System.out.println("numReinicio " + numReinicio);
                        if (numReinicio == tiempoEspera) {
                            cont++;
                            actualizaError(arrDocumento, arrDocumentoNO, "Error: 14");
                            IndicesDAO.updateIndiceEstado("" + arrDocumento.get(0).getIndice(), "Error: 14");
                            System.out.println("Error: 14");
                            break;
                        }
                        System.out.println("15:");
                        esperaCerrar("Información", i);
                        System.out.println("numReinicio " + numReinicio);
                        if (numReinicio == tiempoEspera) {
                            cont++;
                            actualizaError(arrDocumento, arrDocumentoNO, "Error: 15");
                            IndicesDAO.updateIndiceEstado("" + arrDocumento.get(0).getIndice(), "Error: 15");
                            System.out.println("Error: 15");
                            break;
                        }
                        System.out.println("16:");
                        Object[] objectsTxtRtu = getTextByID("TxtRtu", tiempoEspera);
                        System.out.println("numReinicio " + Integer.valueOf(objectsTxtRtu[1].toString()));
                        if (Integer.parseInt(objectsTxtRtu[1].toString()) == tiempoEspera) {
                            cont++;
                            actualizaError(arrDocumento, arrDocumentoNO, "Error: 16");
                            IndicesDAO.updateIndiceEstado("" + arrDocumento.get(0).getIndice(), "Error: 16");
                            System.out.println("Error: 16");
                            break;
                        }

                        String rtu = objectsTxtRtu[0].toString();
                        System.out.println("text " + rtu);

                        int cambios = 0;
                        if (!rtu.equals(get.getRtu())) {
                            System.out.println("17:");
                            numReinicio = sendKeyToElementByID("TxtRtu", get.getRtu(), tiempoEspera, false);
                            System.out.println("numReinicio " + numReinicio);
                            if (numReinicio == tiempoEspera) {
                                cont++;
                                actualizaError(arrDocumento, arrDocumentoNO, "Error: 17");
                                IndicesDAO.updateIndiceEstado("" + arrDocumento.get(0).getIndice(), "Error: 17");
                                System.out.println("Error: 17");
                                break;
                            }
                            cambios++;
                        } else {
                            System.out.println("17:");
                        }

                        System.out.println("18:");
                        Object[] objectsCbOperador = getTextByID("CbOperador", tiempoEspera);
                        System.out.println("numReinicio " + Integer.valueOf(objectsCbOperador[1].toString()));
                        if (Integer.parseInt(objectsCbOperador[1].toString()) == tiempoEspera) {
                            cont++;
                            actualizaError(arrDocumento, arrDocumentoNO, "Error: 18");
                            IndicesDAO.updateIndiceEstado("" + arrDocumento.get(0).getIndice(), "Error: 18");
                            System.out.println("Error: 18");
                            break;
                        }

                        String combobox = objectsCbOperador[0].toString();
                        System.out.println("text " + combobox);

                        String operador = "";
                        if (get.getOperador().equals("*")) {
                            operador = "Multiplicación";
                        } else if (get.getOperador().equals("/")) {
                            operador = "División";
                        } else if (get.getOperador().equals("+")) {
                            operador = "Suma";
                        } else if (get.getOperador().equals("-")) {
                            operador = "Resta";
                        }

                        if (!combobox.equals(operador)) {
                            System.out.println("19:");
                            objectsCbOperador = getTextByID("CbOperador", tiempoEspera);
                            System.out.println("numReinicio " + Integer.valueOf(objectsCbOperador[1].toString()));
                            if (Integer.parseInt(objectsCbOperador[1].toString()) == tiempoEspera) {
                                cont++;
                                actualizaError(arrDocumento, arrDocumentoNO, "Error: 19");
                                IndicesDAO.updateIndiceEstado("" + arrDocumento.get(0).getIndice(), "Error: 19");
                                System.out.println("Error: 19");
                                break;
                            }
                            cambios++;
                        }

                        if (cambios > 0) {
                            System.out.println("20:");
                            numReinicio = clickElementByID("devBtnGrabar", tiempoEspera);
                            System.out.println("numReinicio " + numReinicio);
                            if (numReinicio == tiempoEspera) {
                                cont++;
                                actualizaError(arrDocumento, arrDocumentoNO, "Error: 20");
                                IndicesDAO.updateIndiceEstado("" + arrDocumento.get(0).getIndice(), "Error: 20");
                                System.out.println("Error: 20");
                                break;
                            }
                            System.out.println("21:");
                            numReinicio = esperaAbrir("Información", tiempoEspera);
                            System.out.println("numReinicio " + numReinicio);
                            if (numReinicio == tiempoEspera) {
                                cont++;
                                actualizaError(arrDocumento, arrDocumentoNO, "Error: 21");
                                IndicesDAO.updateIndiceEstado("" + arrDocumento.get(0).getIndice(), "Error: 21");
                                System.out.println("Error: 21");
                                break;
                            }
                            System.out.println("22:");
                            numReinicio = clickElementByName("&Sí", tiempoEspera);
                            System.out.println("numReinicio " + numReinicio);
                            if (numReinicio == tiempoEspera) {
                                cont++;
                                actualizaError(arrDocumento, arrDocumentoNO, "Error: 22");
                                IndicesDAO.updateIndiceEstado("" + arrDocumento.get(0).getIndice(), "Error: 22");
                                System.out.println("Error: 12345");
                                break;
                            }
                            System.out.println("23:");
                            numReinicio = esperaAbrir("Información", tiempoEspera);
                            System.out.println("numReinicio " + numReinicio);
                            if (numReinicio == tiempoEspera) {
                                cont++;
                                actualizaError(arrDocumento, arrDocumentoNO, "Error: 23");
                                IndicesDAO.updateIndiceEstado("" + arrDocumento.get(0).getIndice(), "Error: 23");
                                System.out.println("Error: 23");
                                break;
                            }
                            System.out.println("24:");
                            numReinicio = clickElementByName("&Aceptar", tiempoEspera);
                            System.out.println("numReinicio " + numReinicio);
                            if (numReinicio == tiempoEspera) {
                                cont++;
                                actualizaError(arrDocumento, arrDocumentoNO, "Error: 24");
                                IndicesDAO.updateIndiceEstado("" + arrDocumento.get(0).getIndice(), "Error: 24");
                                System.out.println("Error: 24");
                                break;
                            }
                            System.out.println("25:");
                            numReinicio = esperaCerrar("Información", i);
                            System.out.println("numReinicio " + numReinicio);
                            if (numReinicio == tiempoEspera) {
                                cont++;
                                actualizaError(arrDocumento, arrDocumentoNO, "Error: 25");
                                IndicesDAO.updateIndiceEstado("" + arrDocumento.get(0).getIndice(), "Error: 25");
                                System.out.println("Error: 25");
                                break;
                            }
                        }
                        System.out.println("26:");
                        numReinicio = clickElementByName("Cerrar", tiempoEspera);
                        System.out.println("numReinicio " + numReinicio);
                        if (numReinicio == tiempoEspera) {
                            cont++;
                            actualizaError(arrDocumento, arrDocumentoNO, "Error: 26");
                            IndicesDAO.updateIndiceEstado("" + arrDocumento.get(0).getIndice(), "Error: 26");
                            System.out.println("Error: 26");
                            break;
                        }
                        System.out.println("27:");
                        numReinicio = esperaCerrar("Información", i);
                        System.out.println("numReinicio " + numReinicio);
                        if (numReinicio == tiempoEspera) {
                            cont++;
                            actualizaError(arrDocumento, arrDocumentoNO, "Error: 27");
                            IndicesDAO.updateIndiceEstado("" + arrDocumento.get(0).getIndice(), "Error: 27");
                            System.out.println("Error: 27");
                            break;
                        }
                    }
                }
            }
            if (cont > 0) {
                break;
            }
            ProcedimientoIngresaMercaderia.procedimiento(arrDocumento, arrDocumentoNO, comboBox, ordenDeCompra, numeroDocumento);
        }
    }
}
