/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Clases.Ingresos;
import DAO.IndicesDAO;
import DAO.IngresosDAO;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinUser;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.windows.WindowsDriver;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author sopor
 */
public class ProcedimientoIngresaMercaderia {

    public static String cantidadBusqueda = "";
    public static WindowsDriver driver = null;

    public static void procedimiento(ArrayList<Ingresos> arrProducto, ArrayList<Ingresos> arrProductoNO, String comboBox, String ordenDeCompra, String numeroDocumento) throws MalformedURLException, InterruptedException, IOException, SQLException {

        int numReinicio = 10;
        int tiempoEspera = 10;

        int cont = 0;
        for (int t = 0; t < 1; t++) {
            System.out.println("28:");
            numReinicio = esperaTabla("Footer Panel", tiempoEspera);
            System.out.println("numReinicio " + numReinicio);
            if (numReinicio == tiempoEspera) {
                cont++;
                actualizaError(arrProducto, arrProductoNO, "Error: 28");
                IndicesDAO.updateIndiceEstado("" + arrProducto.get(0).getIndice(), "Error: 28");
                System.out.println("Error: 28");
                break;
            }
            System.out.println("29:");
            numReinicio = clickElementByID("sbtnIngresoMercaderia", tiempoEspera);
            System.out.println("numReinicio " + numReinicio);
            if (numReinicio == tiempoEspera) {
                cont++;
                actualizaError(arrProducto, arrProductoNO, "Error: 29");
                IndicesDAO.updateIndiceEstado("" + arrProducto.get(0).getIndice(), "Error: 29");
                System.out.println("Error: 29");
                break;
            }
            System.out.println("30:");
            numReinicio = esperaAbrir("Ingreso Mercadería", tiempoEspera);
            System.out.println("numReinicio " + numReinicio);
            if (numReinicio == tiempoEspera) {
                cont++;
                actualizaError(arrProducto, arrProductoNO, "Error: 30");
                IndicesDAO.updateIndiceEstado("" + arrProducto.get(0).getIndice(), "Error: 30");
                System.out.println("Error: 30");
                break;
            }
            System.out.println("31:");
            numReinicio = sendKeyToElementByID("TextOrdenCompra", ordenDeCompra, tiempoEspera, true);
            System.out.println("numReinicio " + numReinicio);
            if (numReinicio == tiempoEspera) {
                cont++;
                actualizaError(arrProducto, arrProductoNO, "Error: 31");
                IndicesDAO.updateIndiceEstado("" + arrProducto.get(0).getIndice(), "Error: 31");
                System.out.println("Error: 31");
                break;
            }
            System.out.println("32:");
            numReinicio = esperaAbrir("BusquedaProducto", 2);
            System.out.println("numReinicio " + numReinicio);
            if (numReinicio < 2) {
                cont++;
                actualizaError(arrProducto, arrProductoNO, "Error: 32");
                IndicesDAO.updateIndiceEstado("" + arrProducto.get(0).getIndice(), "Error: 32");
                System.out.println("Error: 32");
                break;
            }
            System.out.println("33:");
            numReinicio = sendKeyToElementByID("TextNumeroDocDespacho", numeroDocumento, tiempoEspera, true);
            System.out.println("numReinicio " + numReinicio);
            if (numReinicio == tiempoEspera) {
                cont++;
                actualizaError(arrProducto, arrProductoNO, "Error: 33");
                IndicesDAO.updateIndiceEstado("" + arrProducto.get(0).getIndice(), "Error: 33");
                System.out.println("Error: 33");
                break;
            }
            System.out.println("34:");
            numReinicio = sendKeyToElementByID("CmbTipoDocumento", comboBox, tiempoEspera, true);
            System.out.println("numReinicio " + numReinicio);
            if (numReinicio == tiempoEspera) {
                cont++;
                actualizaError(arrProducto, arrProductoNO, "Error: 34");
                IndicesDAO.updateIndiceEstado("" + arrProducto.get(0).getIndice(), "Error: 34");
                System.out.println("Error: 34");
                break;
            }
            System.out.println("35:");
            Object[] objectsPaneldeDatos = findElementByName("Panel de datos", tiempoEspera);
            System.out.println("numReinicio " + Integer.valueOf(objectsPaneldeDatos[1].toString()));
            if (Integer.parseInt(objectsPaneldeDatos[1].toString()) == tiempoEspera) {
                cont++;
                actualizaError(arrProducto, arrProductoNO, "Error: 35");
                IndicesDAO.updateIndiceEstado("" + arrProducto.get(0).getIndice(), "Error: 35");
                System.out.println("Error: 35");
                break;
            }

            WebElement findElementByName = (WebElement) objectsPaneldeDatos[0];

            System.out.println("36:");
            Object[] findElementsFromWebElement = findElementsFromWebElement(findElementByName, "*/*", tiempoEspera);
            System.out.println("numReinicio " + Integer.valueOf(findElementsFromWebElement[1].toString()));
            if (Integer.parseInt(findElementsFromWebElement[1].toString()) == tiempoEspera) {
                cont++;
                actualizaError(arrProducto, arrProductoNO, "Error: 36");
                IndicesDAO.updateIndiceEstado("" + arrProducto.get(0).getIndice(), "Error: 36");
                System.out.println("Error: 36");
                break;
            }
            List<WebElement> findElements = (List<WebElement>) findElementsFromWebElement[0];

            int size = findElements.size();
            System.out.println("size " + size);

            System.out.println("---------------------------------------");
            for (int i = 0; i < findElements.size(); i++) {
                System.out.println("37:");
                Object[] objectsCodigoRow = getTextByName("Codigo row " + i, tiempoEspera);
                System.out.println("numReinicio " + Integer.valueOf(objectsCodigoRow[1].toString()));
                if (Integer.parseInt(objectsCodigoRow[1].toString()) == tiempoEspera) {
                    cont++;
                    actualizaError(arrProducto, arrProductoNO, "Error: 37");
                    IndicesDAO.updateIndiceEstado("" + arrProducto.get(0).getIndice(), "Error: 37");
                    System.out.println("Error: 37");
                    break;
                }

                String codigorow = objectsCodigoRow[0].toString().replace("ñ", "n");
                System.out.println("text " + codigorow);

                System.out.println("38:");
                Object[] objectsCodigoSAFrow = getTextByName("Codigo SAF row " + i, tiempoEspera);
                System.out.println("numReinicio " + Integer.valueOf(objectsCodigoSAFrow[1].toString()));
                if (Integer.parseInt(objectsCodigoSAFrow[1].toString()) == tiempoEspera) {
                    cont++;
                    actualizaError(arrProducto, arrProductoNO, "Error: 38");
                    IndicesDAO.updateIndiceEstado("" + arrProducto.get(0).getIndice(), "Error: 38");
                    System.out.println("Error: 38");
                    break;
                }

                String codigoSAFrow = objectsCodigoSAFrow[0].toString();
                System.out.println("text " + codigoSAFrow);

                System.out.println("-------------------------------------");

                System.out.println(arrProducto.size());
                System.out.println(arrProductoNO.size());

                System.out.println("-------------------------------------");
                Ingresos producto = null;
                for (int j = 0; j < arrProducto.size(); j++) {
                    String codigoOriginal = arrProducto.get(j).getCodigoOriginal().replace("ñ", "n");
                    System.out.println(arrProducto.get(j).getCodigoOriginal());
                    if (codigorow.equals(codigoOriginal)) {
                        producto = arrProducto.get(j);

                        System.out.println("1");
                        break;
                    }
                }
                System.out.println("-------------------------------------");
                for (int j = 0; j < arrProductoNO.size(); j++) {
                    String codigoOriginal = arrProductoNO.get(j).getCodigoOriginal().replace("ñ", "n");;
                    System.out.println(arrProductoNO.get(j).getCodigoOriginal());
                    if (codigorow.equals(codigoOriginal)) {
                        producto = arrProductoNO.get(j);

                        System.out.println("2");
                        break;
                    }
                }

                if (producto == null) {
                    actualizaError(arrProducto, arrProductoNO, "Error: Producto null");
                    IndicesDAO.updateIndiceEstado("" + arrProducto.get(0).getIndice(), "Error: Producto null");
                    System.out.println("Error: Producto null");
                    break;
                }

                System.out.println("-------------------------------------");

                if (!codigoSAFrow.equals("Codigo SAF row " + i)) {
                    System.out.println("codigoSAFrow " + codigoSAFrow);
                    System.out.println("Codigo SAF row " + i);

                    System.out.println("39:");
                    numReinicio = enterElementByName("Codigo SAF row " + i, tiempoEspera, false);
                    System.out.println("numReinicio " + numReinicio);
                    if (numReinicio == tiempoEspera) {
                        cont++;
                        actualizaError(arrProducto, arrProductoNO, "Error: 39");
                        IndicesDAO.updateIndiceEstado("" + arrProducto.get(0).getIndice(), "Error: 39");
                        System.out.println("Error: 39");
                        break;
                    }
                    System.out.println("40:");
                    numReinicio = enterElementByName("Codigo SAF row " + i, tiempoEspera, false);
                    System.out.println("numReinicio " + numReinicio);
                    if (numReinicio == tiempoEspera) {
                        cont++;
                        actualizaError(arrProducto, arrProductoNO, "Error: 40");
                        IndicesDAO.updateIndiceEstado("" + arrProducto.get(0).getIndice(), "Error: 40");
                        System.out.println("Error: 40");
                        break;
                    }
                    System.out.println("41:");
                    numReinicio = esperaAbrir("Pregunta", tiempoEspera);
                    System.out.println("numReinicio " + numReinicio);
                    if (numReinicio == tiempoEspera) {
                        cont++;
                        actualizaError(arrProducto, arrProductoNO, "Error: 41");
                        IndicesDAO.updateIndiceEstado("" + arrProducto.get(0).getIndice(), "Error: 41");
                        System.out.println("Error: 41");
                        break;
                    }
                    System.out.println("42:");
                    numReinicio = clickElementByID("6", tiempoEspera);
                    System.out.println("numReinicio " + numReinicio);
                    if (numReinicio == tiempoEspera) {
                        cont++;
                        actualizaError(arrProducto, arrProductoNO, "Error: 42");
                        IndicesDAO.updateIndiceEstado("" + arrProducto.get(0).getIndice(), "Error: 42");
                        System.out.println("Error: 42");
                        break;
                    }
                    System.out.println("43:");
                    numReinicio = esperaAbrir("Buscar Producto", tiempoEspera);
                    System.out.println("numReinicio " + numReinicio);
                    if (numReinicio == tiempoEspera) {
                        cont++;
                        actualizaError(arrProducto, arrProductoNO, "Error: 43");
                        IndicesDAO.updateIndiceEstado("" + arrProducto.get(0).getIndice(), "Error: 43");
                        System.out.println("Error: 43");
                        break;
                    }
                    System.out.println("44:");
                    numReinicio = sendKeyToElementByID("TextCodigo", producto.getCodigo().replace("-", "/"), tiempoEspera, true);
                    System.out.println("numReinicio " + numReinicio);
                    if (numReinicio == tiempoEspera) {
                        cont++;
                        actualizaError(arrProducto, arrProductoNO, "Error: 44");
                        IndicesDAO.updateIndiceEstado("" + arrProducto.get(0).getIndice(), "Error: 44");
                        System.out.println("Error: 44");
                        break;
                    }
                    System.out.println("45:");
                    objectsPaneldeDatos = findElementByName("Panel de datos", tiempoEspera);
                    System.out.println("numReinicio " + Integer.valueOf(objectsPaneldeDatos[1].toString()));
                    if (Integer.parseInt(objectsPaneldeDatos[1].toString()) == tiempoEspera) {
                        cont++;
                        actualizaError(arrProducto, arrProductoNO, "Error: 45");
                        IndicesDAO.updateIndiceEstado("" + arrProducto.get(0).getIndice(), "Error: 45");
                        System.out.println("Error: 45");
                        break;
                    }

                    WebElement findElementByNamex = (WebElement) objectsPaneldeDatos[0];

                    System.out.println("46:");
                    List<WebElement> findElementsx = findElementByNamex.findElements(By.xpath("*/*"));
                    int sizex = findElementsx.size();
                    System.out.println("sizex " + sizex);

                    if (findElementsx.isEmpty()) {
                        cont++;
                        actualizaError(arrProducto, arrProductoNO, "Error: 46");
                        IndicesDAO.updateIndiceEstado("" + arrProducto.get(0).getIndice(), "Error: 46");
                        System.out.println("Error: 46");
                        break;
                    }

                    System.out.println("---------------------------------------");
                    for (int u = 0; u < findElementsx.size(); u++) {
                        System.out.println("---> " + u);

                        System.out.println("47:");
                        objectsCodigoRow = getTextByName("Codigo row " + u, tiempoEspera);
                        System.out.println("numReinicio " + Integer.valueOf(objectsCodigoRow[1].toString()));
                        if (Integer.parseInt(objectsCodigoRow[1].toString()) == tiempoEspera) {
                            cont++;
                            actualizaError(arrProducto, arrProductoNO, "Error: 47");
                            IndicesDAO.updateIndiceEstado("" + arrProducto.get(0).getIndice(), "Error: 47");
                            System.out.println("Error: 47");
                            break;
                        }
                        String codigorowx = objectsCodigoRow[0].toString();

                        if (codigorowx.equals(producto.getCodigo())) {
                            System.out.println("48:");
                            numReinicio = clickElementByName("Codigo row " + u, tiempoEspera);
                            System.out.println("numReinicio " + numReinicio);
                            if (numReinicio == tiempoEspera) {
                                cont++;
                                actualizaError(arrProducto, arrProductoNO, "Error: 48");
                                IndicesDAO.updateIndiceEstado("" + arrProducto.get(0).getIndice(), "Error: 48");
                                System.out.println("Error: 48");
                                break;
                            }
                        }
                    }
                    System.out.println("49:");
                    numReinicio = clickElementByName("&Aceptar", tiempoEspera);
                    System.out.println("numReinicio " + numReinicio);
                    if (numReinicio == tiempoEspera) {
                        cont++;
                        actualizaError(arrProducto, arrProductoNO, "Error: 49");
                        IndicesDAO.updateIndiceEstado("" + arrProducto.get(0).getIndice(), "Error: 49");
                        System.out.println("Error: 49");
                        break;
                    }
                } else {
                    System.out.println("50:");
                    numReinicio = enterElementByName("Codigo SAF row " + i, tiempoEspera, false);
                    System.out.println("numReinicio " + numReinicio);
                    if (numReinicio == tiempoEspera) {
                        cont++;
                        actualizaError(arrProducto, arrProductoNO, "Error: 50");
                        IndicesDAO.updateIndiceEstado("" + arrProducto.get(0).getIndice(), "Error: 50");
                        System.out.println("Error: 50");
                        break;
                    }
                    System.out.println("51:");
                    numReinicio = enterElementByName("Codigo SAF row " + i, tiempoEspera, false);
                    System.out.println("numReinicio " + numReinicio);
                    if (numReinicio == tiempoEspera) {
                        cont++;
                        actualizaError(arrProducto, arrProductoNO, "Error: 51");
                        IndicesDAO.updateIndiceEstado("" + arrProducto.get(0).getIndice(), "Error: 51");
                        System.out.println("Error: 51");
                        break;
                    }
                    System.out.println("52:");
                    numReinicio = esperaAbrir("Buscar Producto", tiempoEspera);
                    System.out.println("numReinicio " + numReinicio);
                    if (numReinicio == tiempoEspera) {
                        cont++;
                        actualizaError(arrProducto, arrProductoNO, "Error: 52");
                        IndicesDAO.updateIndiceEstado("" + arrProducto.get(0).getIndice(), "Error: 52");
                        System.out.println("Error: 52");
                        break;
                    }
                    System.out.println("53:");
                    numReinicio = sendKeyToElementByID("TextCodigo", producto.getCodigo().replace("-", "/"), tiempoEspera, true);
                    System.out.println("numReinicio " + numReinicio);
                    if (numReinicio == tiempoEspera) {
                        cont++;
                        actualizaError(arrProducto, arrProductoNO, "Error: 53");
                        IndicesDAO.updateIndiceEstado("" + arrProducto.get(0).getIndice(), "Error: 53");
                        System.out.println("Error: 53");
                        break;
                    }
                    System.out.println("54:");
                    objectsPaneldeDatos = findElementByName("Panel de datos", tiempoEspera);
                    System.out.println("numReinicio " + Integer.valueOf(objectsPaneldeDatos[1].toString()));
                    if (Integer.parseInt(objectsPaneldeDatos[1].toString()) == tiempoEspera) {
                        cont++;
                        actualizaError(arrProducto, arrProductoNO, "Error: 54");
                        IndicesDAO.updateIndiceEstado("" + arrProducto.get(0).getIndice(), "Error: 54");
                        System.out.println("Error: 54");
                        break;
                    }

                    WebElement findElementByNamex = (WebElement) objectsPaneldeDatos[0];

                    System.out.println("55:");
                    findElementsFromWebElement = findElementsFromWebElement(findElementByNamex, "*/*", tiempoEspera);
                    System.out.println("numReinicio " + Integer.valueOf(findElementsFromWebElement[1].toString()));
                    if (Integer.parseInt(findElementsFromWebElement[1].toString()) == tiempoEspera) {
                        cont++;
                        actualizaError(arrProducto, arrProductoNO, "Error: 55");
                        IndicesDAO.updateIndiceEstado("" + arrProducto.get(0).getIndice(), "Error: 55");
                        System.out.println("Error: 55");
                        break;
                    }
                    List<WebElement> findElementsx = (List<WebElement>) findElementsFromWebElement[0];

                    int sizex = findElementsx.size();
                    System.out.println("sizex " + sizex);

                    System.out.println("---------------------------------------");
                    for (int u = 0; u < findElementsx.size(); u++) {
                        System.out.println("---> " + u);

                        System.out.println("56:");
                        objectsCodigoRow = getTextByName("Codigo row " + u, tiempoEspera);
                        System.out.println("numReinicio " + Integer.valueOf(objectsCodigoRow[1].toString()));
                        if (Integer.parseInt(objectsCodigoRow[1].toString()) == tiempoEspera) {
                            cont++;
                            actualizaError(arrProducto, arrProductoNO, "Error: 56");
                            IndicesDAO.updateIndiceEstado("" + arrProducto.get(0).getIndice(), "Error: 56");
                            System.out.println("Error: 56");
                            break;
                        }

                        String codigorowx = objectsCodigoRow[0].toString();

                        if (codigorowx.equals(producto.getCodigo())) {
                            System.out.println("57:");
                            numReinicio = clickElementByName("Codigo row " + u, tiempoEspera);
                            System.out.println("numReinicio " + numReinicio);
                            if (numReinicio == tiempoEspera) {
                                cont++;
                                actualizaError(arrProducto, arrProductoNO, "Error: 57");
                                IndicesDAO.updateIndiceEstado("" + arrProducto.get(0).getIndice(), "Error: 57");
                                System.out.println("Error: 57");
                                break;
                            }
                        }
                    }
                    System.out.println("58:");
                    numReinicio = clickElementByName("&Aceptar", tiempoEspera);
                    System.out.println("numReinicio " + numReinicio);
                    if (numReinicio == tiempoEspera) {
                        cont++;
                        actualizaError(arrProducto, arrProductoNO, "Error: 58");
                        IndicesDAO.updateIndiceEstado("" + arrProducto.get(0).getIndice(), "Error: 58");
                        System.out.println("Error: 58");
                        break;
                    }
                }
                System.out.println("---------------------------------------");
            }
            if (cont > 0) {
                break;
            }

            System.out.println("---------------------------------------");
            for (int i = 0; i < findElements.size(); i++) {
                System.out.println("59");
                Object[] objectsCodigoRow = getTextByName("Codigo row " + i, tiempoEspera);
                System.out.println("numReinicio " + Integer.valueOf(objectsCodigoRow[1].toString()));
                if (Integer.parseInt(objectsCodigoRow[1].toString()) == tiempoEspera) {
                    cont++;
                    actualizaError(arrProducto, arrProductoNO, "Error: 59");
                    IndicesDAO.updateIndiceEstado("" + arrProducto.get(0).getIndice(), "Error: 59");
                    System.out.println("Error: 59");
                    break;
                }

                String codigorow = objectsCodigoRow[0].toString().replace("ñ", "n");
                System.out.println("text " + codigorow);

                System.out.println("60:");
                Object[] objectsCodigoSAFRow = getTextByName("Codigo SAF row " + i, tiempoEspera);
                System.out.println("numReinicio " + Integer.valueOf(objectsCodigoSAFRow[1].toString()));
                if (Integer.parseInt(objectsCodigoSAFRow[1].toString()) == tiempoEspera) {
                    cont++;
                    actualizaError(arrProducto, arrProductoNO, "Error: 60");
                    IndicesDAO.updateIndiceEstado("" + arrProducto.get(0).getIndice(), "Error: 60");
                    System.out.println("Error: 60");
                    break;
                }

                String codigoSAFrow = objectsCodigoSAFRow[0].toString();
                System.out.println("text " + codigoSAFrow);

                System.out.println("-------------------------------------");

                System.out.println(arrProducto.size());
                System.out.println(arrProductoNO.size());

                System.out.println("-------------------------------------");
                Ingresos producto = null;
                for (int j = 0; j < arrProducto.size(); j++) {
                    String codigoOriginal = arrProducto.get(j).getCodigoOriginal().replace("ñ", "n");;
                    System.out.println(arrProducto.get(j).getCodigoOriginal());

                    if (codigorow.equals(codigoOriginal)) {
                        producto = arrProducto.get(j);
                        break;
                    }
                }
                System.out.println("-------------------------------------");
                for (int j = 0; j < arrProductoNO.size(); j++) {
                    String codigoOriginal = arrProductoNO.get(j).getCodigoOriginal().replace("ñ", "n");;
                    System.out.println(arrProductoNO.get(j).getCodigoOriginal());
                    if (codigorow.equals(codigoOriginal)) {
                        producto = arrProductoNO.get(j);
                        break;
                    }
                }

                if (producto == null) {
                    actualizaError(arrProducto, arrProductoNO, "Error: Producto null");
                    IndicesDAO.updateIndiceEstado("" + arrProducto.get(0).getIndice(), "Error: Producto null");
                    System.out.println("Error: Producto null");
                    break;
                }

                System.out.println("-------------------------------------");

                String cantidad = producto.getCantidad();

                String[] split = cantidad.split("@");
                String pb = split[0];
                String cs = split[1];
                String ls = split[2];

                if (!producto.getLocal().equals("PB")) {
                    System.out.println("61:");
                    numReinicio = sendKeyToElementByName("Ing. Actual row " + i, pb, tiempoEspera, true);
                    System.out.println("numReinicio " + numReinicio);
                    if (numReinicio == tiempoEspera) {
                        cont++;
                        actualizaError(arrProducto, arrProductoNO, "Error: 61");
                        IndicesDAO.updateIndiceEstado("" + arrProducto.get(0).getIndice(), "Error: 61");
                        System.out.println("Error: 61");
                        break;
                    }
                } else {
                    System.out.println("cantidad " + cantidad);

                    split = cantidad.split("@");
                    pb = split[0];
                    cs = split[1];
                    ls = split[2];

                    int parseInt = Integer.parseInt(pb);
                    int parseInt1 = Integer.parseInt(cs);
                    int parseInt2 = Integer.parseInt(ls);

                    int suma = parseInt + parseInt1 + parseInt2;
                    String sumaString = String.valueOf(suma);

                    System.out.println("62:");
                    numReinicio = sendKeyToElementByName("Ing. Actual row " + i, sumaString, tiempoEspera, true);
                    System.out.println("numReinicio " + numReinicio);
                    if (numReinicio == tiempoEspera) {
                        cont++;
                        actualizaError(arrProducto, arrProductoNO, "Error: 62");
                        IndicesDAO.updateIndiceEstado("" + arrProducto.get(0).getIndice(), "Error: 62");
                        System.out.println("Error: 62");
                        break;
                    }

                    if (parseInt1 > 0 || parseInt2 > 0) {
                        System.out.println("63:");
                        numReinicio = clickElementByName("BO row " + i, tiempoEspera);
                        System.out.println("numReinicio " + numReinicio);
                        if (numReinicio == tiempoEspera) {
                            cont++;
                            actualizaError(arrProducto, arrProductoNO, "Error: 63");
                            IndicesDAO.updateIndiceEstado("" + arrProducto.get(0).getIndice(), "Error: 63");
                            System.out.println("Error: 63");
                            break;
                        }

                        String originalWindow = driver.getWindowHandle();

                        for (String windowHandle : driver.getWindowHandles()) {
                            if (!originalWindow.contentEquals(windowHandle)) {
                                driver.switchTo().window(windowHandle);
                                break;
                            }
                        }

                        String title = driver.getTitle();
                        System.out.println("title " + title);

                        System.out.println("64:");
                        numReinicio = esperaAbrir("Distribucion de Stock en Bodegas", tiempoEspera);
                        System.out.println("numReinicio " + numReinicio);
                        if (numReinicio == tiempoEspera) {
                            cont++;
                            actualizaError(arrProducto, arrProductoNO, "Error: 64");
                            IndicesDAO.updateIndiceEstado("" + arrProducto.get(0).getIndice(), "Error: 64");
                            System.out.println("Error: 64");
                            break;
                        }

                        System.out.println("parseInt " + parseInt);
                        System.out.println("parseInt1 " + parseInt1);
                        System.out.println("parseInt2 " + parseInt2);

                        System.out.println("PB");

                        System.out.println("65:");
                        numReinicio = clickElementByName("Cantidad Fila 0", tiempoEspera);
                        System.out.println("numReinicio " + numReinicio);
                        if (numReinicio == tiempoEspera) {
                            cont++;
                            actualizaError(arrProducto, arrProductoNO, "Error: 65");
                            IndicesDAO.updateIndiceEstado("" + arrProducto.get(0).getIndice(), "Error: 65");
                            System.out.println("Error: 65");
                            break;
                        }
                        System.out.println("66:");
                        numReinicio = clickElementByName("Cantidad Fila 0", tiempoEspera);
                        System.out.println("numReinicio " + numReinicio);
                        if (numReinicio == tiempoEspera) {
                            cont++;
                            actualizaError(arrProducto, arrProductoNO, "Error: 66");
                            IndicesDAO.updateIndiceEstado("" + arrProducto.get(0).getIndice(), "Error: 66");
                            System.out.println("Error: 66");
                            break;
                        }
                        System.out.println("67:");
                        numReinicio = sendKeyToElementByName("Cantidad Fila 0", pb, tiempoEspera, false);
                        System.out.println("numReinicio " + numReinicio);
                        if (numReinicio == tiempoEspera) {
                            cont++;
                            actualizaError(arrProducto, arrProductoNO, "Error: 67");
                            IndicesDAO.updateIndiceEstado("" + arrProducto.get(0).getIndice(), "Error: 67");
                            System.out.println("Error: 67");
                            break;
                        }
                        System.out.println("68:");
                        System.out.println("VA");
                        numReinicio = clickElementByName("Cantidad Fila 1", tiempoEspera);
                        System.out.println("numReinicio " + numReinicio);
                        if (numReinicio == tiempoEspera) {
                            cont++;
                            actualizaError(arrProducto, arrProductoNO, "Error: 68");
                            IndicesDAO.updateIndiceEstado("" + arrProducto.get(0).getIndice(), "Error: 68");
                            System.out.println("Error: 68");
                            break;
                        }
                        System.out.println("69:");
                        numReinicio = clickElementByName("Cantidad Fila 1", tiempoEspera);
                        System.out.println("numReinicio " + numReinicio);
                        if (numReinicio == tiempoEspera) {
                            cont++;
                            actualizaError(arrProducto, arrProductoNO, "Error: 69");
                            IndicesDAO.updateIndiceEstado("" + arrProducto.get(0).getIndice(), "Error: 69");
                            System.out.println("Error: 69");
                            break;
                        }
                        System.out.println("70:");
                        numReinicio = sendKeyToElementByName("Cantidad Fila 1", cs, tiempoEspera, false);
                        System.out.println("numReinicio " + numReinicio);
                        if (numReinicio == tiempoEspera) {
                            cont++;
                            actualizaError(arrProducto, arrProductoNO, "Error: 70");
                            IndicesDAO.updateIndiceEstado("" + arrProducto.get(0).getIndice(), "Error: 70");
                            System.out.println("Error: 70");
                            break;
                        }

                        System.out.println("OL");
                        System.out.println("71:");
                        numReinicio = clickElementByName("Cantidad Fila 2", tiempoEspera);
                        System.out.println("numReinicio " + numReinicio);
                        if (numReinicio == tiempoEspera) {
                            cont++;
                            actualizaError(arrProducto, arrProductoNO, "Error: 71");
                            IndicesDAO.updateIndiceEstado("" + arrProducto.get(0).getIndice(), "Error: 71");
                            System.out.println("Error: 71");
                            break;
                        }
                        System.out.println("72:");
                        numReinicio = clickElementByName("Cantidad Fila 2", tiempoEspera);
                        System.out.println("numReinicio " + numReinicio);
                        if (numReinicio == tiempoEspera) {
                            cont++;
                            actualizaError(arrProducto, arrProductoNO, "Error: 72");
                            IndicesDAO.updateIndiceEstado("" + arrProducto.get(0).getIndice(), "Error: 72");
                            System.out.println("Error: 72");
                            break;
                        }
                        System.out.println("73:");
                        numReinicio = sendKeyToElementByName("Cantidad Fila 2", ls, tiempoEspera, false);
                        System.out.println("numReinicio " + numReinicio);
                        if (numReinicio == tiempoEspera) {
                            cont++;
                            actualizaError(arrProducto, arrProductoNO, "Error: 73");
                            IndicesDAO.updateIndiceEstado("" + arrProducto.get(0).getIndice(), "Error: 73");
                            System.out.println("Error: 73");
                            break;
                        }
                        System.out.println("74:");
                        numReinicio = clickElementByID("BtnGuardarDistribucion", tiempoEspera);
                        System.out.println("numReinicio " + numReinicio);
                        if (numReinicio == tiempoEspera) {
                            cont++;
                            actualizaError(arrProducto, arrProductoNO, "Error: 74");
                            IndicesDAO.updateIndiceEstado("" + arrProducto.get(0).getIndice(), "Error: 74");
                            System.out.println("Error: 74");
                            break;
                        }
                        System.out.println("75:");
                        numReinicio = esperaCerrar("Distribucion de Stock en Bodegas", tiempoEspera);
                        System.out.println("numReinicio " + numReinicio);
                        if (numReinicio == tiempoEspera) {
                            cont++;
                            actualizaError(arrProducto, arrProductoNO, "Error: 75");
                            IndicesDAO.updateIndiceEstado("" + arrProducto.get(0).getIndice(), "Error: 75");
                            System.out.println("Error: 75");
                            break;
                        }

                        driver.switchTo().window(originalWindow);
                    }
                }
            }
            if (cont > 0) {
                break;
            }

            File file = new File("C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\FolioIngreso.pdf");
            if (file.exists()) {
                file.delete();
            }

            System.out.println("76:");
            numReinicio = clickElementByID("SimpleButton3", tiempoEspera);
            System.out.println("numReinicio " + numReinicio);
            if (numReinicio == tiempoEspera) {
                cont++;
                actualizaError(arrProducto, arrProductoNO, "Error: 76");
                IndicesDAO.updateIndiceEstado("" + arrProducto.get(0).getIndice(), "Error: 76");
                System.out.println("Error: 76");
                break;
            }
            System.out.println("77:");
            numReinicio = clickElementByName("&Aceptar", 2);
            System.out.println("numReinicio " + numReinicio);
            if (numReinicio < 2) {
                cont++;
                actualizaError(arrProducto, arrProductoNO, "Error: 77");
                IndicesDAO.updateIndiceEstado("" + arrProducto.get(0).getIndice(), "Error: 77");
                System.out.println("Error: 77");
                break;
            }
            System.out.println("78:");
            numReinicio = clickElementByName("Aceptar", 2);
            System.out.println("numReinicio " + numReinicio);
            if (numReinicio < 2) {
                cont++;
                actualizaError(arrProducto, arrProductoNO, "Error: 78");
                IndicesDAO.updateIndiceEstado("" + arrProducto.get(0).getIndice(), "Error: 78");
                System.out.println("Error: 78");
                break;
            }

            int contx = 0;
            while (!file.exists() && contx < 15) {
                Thread.sleep(1000);
                cont++;
            }

            if (file.exists()) {
                String text = "";
                try (PDDocument document = PDDocument.load(file)) {
                    PDFTextStripper stripper = new PDFTextStripper();
                    text = stripper.getText(document);
                }

                System.out.println(text);

                String[] split = text.split("\n");
                String folio = split[0].trim();

                InputStream input = new FileInputStream("C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\FolioIngreso.pdf");

                byte[] b3 = new byte[8192];
                int nose;

                ByteArrayOutputStream output = new ByteArrayOutputStream();
                try {
                    while ((nose = input.read(b3)) != -1) {
                        output.write(b3, 0, nose);
                    }
                } catch (Exception e) {
                }

                byte[] bs = output.toByteArray();
                input.close();

                for (int i = 0; i < arrProducto.size(); i++) {
                    Ingresos get = arrProducto.get(i);
                    IngresosDAO.updateEstado(get.getOrdenDeCompra(), "" + get.getIndice(), "entregado", get.getLocal());
                }
                for (int i = 0; i < arrProductoNO.size(); i++) {
                    Ingresos get = arrProductoNO.get(i);
                    IngresosDAO.updateEstado(get.getOrdenDeCompra(), "" + get.getIndice(), "entregado", get.getLocal());
                }

                IndicesDAO.updateIndiceEstado("" + arrProducto.get(0).getIndice(), "entregado");
                IndicesDAO.updateIndicePDF("" + arrProducto.get(0).getIndice(), bs);
                IndicesDAO.updateIndiceFolio("" + arrProducto.get(0).getIndice(), folio);

                Runtime.getRuntime().exec("cmd /c start \"\" " + System.getProperty("user.dir") + "\\run.bat");
            } else {
                cont++;
                actualizaError(arrProducto, arrProductoNO, "Error: 79");
                IndicesDAO.updateIndiceEstado("" + arrProducto.get(0).getIndice(), "Error: 79");
                System.out.println("Error: 79");
                break;
            }
        }
    }

    public static void abrirConsultaProducto(String ruta) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", ruta);
        capabilities.setCapability("platformName", "Windows");
        capabilities.setCapability("deviceName", "WindowsPC");

        driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public static void cerrarCP() {
        try {
            Runtime rt = Runtime.getRuntime();
            rt.exec("taskkill /F /IM BusquedaProducto.exe");

        } catch (IOException ex) {
            Logger.getLogger(ProcedimientoIngresaMercaderia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static int esperaAbrir(String nombre, int tiempo) throws InterruptedException {
        WinDef.HWND hwnd = User32.INSTANCE.FindWindow(null, nombre);
        int i = 0;
        while (hwnd == null && i < tiempo) {
            hwnd = User32.INSTANCE.FindWindow(null, nombre);
            User32.INSTANCE.PostMessage(hwnd, WinUser.WS_MAXIMIZE, null, null);
            Thread.sleep(1000);
            i++;
            System.out.println("i " + i);
        }
        return i;
    }

    public static int esperaCerrar(String nombre, int tiempo) throws InterruptedException {
        WinDef.HWND hwnd = User32.INSTANCE.FindWindow(null, nombre);
        int i = 0;
        while (hwnd != null && i < tiempo) {
            hwnd = User32.INSTANCE.FindWindow(null, nombre);
            User32.INSTANCE.PostMessage(hwnd, WinUser.WS_MAXIMIZE, null, null);
            Thread.sleep(1000);
            i++;
            System.out.println("i " + i);
        }
        return i;
    }

    public static int sendKeyToElementByID(String id, String text, int tiempo, boolean enter) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, tiempo);

            WebElement element = driver.findElementByAccessibilityId(id);
            wait.until(ExpectedConditions.elementToBeClickable(element));

            element.clear();
            element.sendKeys(text);

            if (enter) {
                element.sendKeys(Keys.ENTER);
            }

            return 0;
        } catch (Exception ex) {
            return tiempo;
        }
    }

    public static int sendKeyToElementByName(String name, String text, int tiempo, boolean enter) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, tiempo);

            WebElement element = driver.findElementByName(name);
            wait.until(ExpectedConditions.elementToBeClickable(element));

            element.clear();
            element.sendKeys(text);

            if (enter) {
                element.sendKeys(Keys.ENTER);
            }

            return 0;
        } catch (Exception ex) {
            return tiempo;
        }
    }

    public static int clickElementByID(String id, int tiempo) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, tiempo);

            WebElement element = driver.findElementByAccessibilityId(id);
            wait.until(ExpectedConditions.elementToBeClickable(element));

            element.click();

            return 0;
        } catch (Exception ex) {
            return tiempo;
        }
    }

    public static int enterElementByName(String name, int tiempo, boolean bool) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, tiempo);

            WebElement element = driver.findElementByName(name);
            wait.until(ExpectedConditions.elementToBeClickable(element));

            if (bool) {
                element.click();
            }

            element.sendKeys(Keys.ENTER);

            return 0;
        } catch (Exception ex) {
            return tiempo;
        }
    }

    public static int clickElementByName(String name, int tiempo) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, tiempo);

            WebElement element = driver.findElementByName(name);
            wait.until(ExpectedConditions.elementToBeClickable(element));

            element.click();

            return 0;
        } catch (Exception ex) {
            return tiempo;
        }
    }

    public static Object[] getTextByName(String name, int tiempo) {
        Object[] objects = new Object[2];
        try {
            WebDriverWait wait = new WebDriverWait(driver, tiempo);

            WebElement findElementByAccessibilityId = driver.findElementByName(name);
            String text = wait.until(ExpectedConditions.visibilityOf(findElementByAccessibilityId)).getText();

            objects[0] = text;
            objects[1] = 0;

            return objects;
        } catch (Exception ex) {
            objects[0] = "";
            objects[1] = tiempo;

            return objects;
        }
    }

    public static Object[] getTextByID(String id, int tiempo) {
        Object[] objects = new Object[2];
        try {
            WebDriverWait wait = new WebDriverWait(driver, tiempo);

            WebElement findElementByAccessibilityId = driver.findElementByAccessibilityId(id);
            String text = wait.until(ExpectedConditions.visibilityOf(findElementByAccessibilityId)).getText();

            objects[0] = text;
            objects[1] = 0;

            return objects;
        } catch (Exception ex) {
            objects[0] = "";
            objects[1] = tiempo;

            return objects;
        }
    }

    public static Object[] findElementByName(String name, int tiempo) {
        Object[] objects = new Object[2];
        try {
            WebElement findElementByName = driver.findElementByName(name);
            objects[0] = findElementByName;
            objects[1] = 0;

            return objects;
        } catch (Exception ex) {
            objects[0] = null;
            objects[1] = tiempo;

            return objects;
        }
    }

    public static Object[] findElementByID(String id, int tiempo) {
        Object[] objects = new Object[2];
        try {
            WebElement findElementByName = driver.findElementByAccessibilityId(id);
            objects[0] = findElementByName;
            objects[1] = 0;

            return objects;
        } catch (Exception ex) {
            objects[0] = null;
            objects[1] = tiempo;

            return objects;
        }
    }

    public static Object[] findElementsFromWebElement(WebElement name, String xPath, int tiempo) {
        Object[] objects = new Object[2];
        try {
            List<WebElement> findElements = name.findElements(By.xpath(xPath));

            objects[0] = findElements;
            objects[1] = 0;

            return objects;
        } catch (Exception ex) {
            objects[0] = null;
            objects[1] = tiempo;

            return objects;
        }
    }

    public static int esperaTabla(String id, int tiempo) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, tiempo);

            WebElement findElementByAccessibilityId = driver.findElementByName(id);
            wait.until(ExpectedConditions.visibilityOf(findElementByAccessibilityId));

            By name = By.name("Código Producto");
            WebElement findElement = findElementByAccessibilityId.findElement(name);

            cantidadBusqueda = findElement.getText().replace(",", ".");
            System.out.println("text " + cantidadBusqueda);

            return 0;
        } catch (Exception ex) {
            return tiempo;
        }
    }

    public static void actualizaError(ArrayList<Ingresos> arrDocumento, ArrayList<Ingresos> arrDocumentoNO, String error) {

        for (int i = 0; i < arrDocumento.size(); i++) {
            Ingresos get1 = arrDocumento.get(i);
            IngresosDAO.updateEstado(get1.getOrdenDeCompra(), "" + get1.getIndice(), error, get1.getLocal());
        }
        for (int i = 0; i < arrDocumentoNO.size(); i++) {
            Ingresos get2 = arrDocumentoNO.get(i);
            IngresosDAO.updateEstado(get2.getOrdenDeCompra(), "" + get2.getIndice(), error, get2.getLocal());
        }
    }

    public static void actualizaErrorAnular(ArrayList<Ingresos> arrDocumento, String error) {

        for (int i = 0; i < arrDocumento.size(); i++) {
            Ingresos get1 = arrDocumento.get(i);
            IngresosDAO.updateEstado(get1.getOrdenDeCompra(), "" + get1.getIndice(), error, get1.getLocal());
        }
    }
}
