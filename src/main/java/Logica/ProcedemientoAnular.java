/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Clases.Ingresos;
import DAO.IndicesDAO;
import static Logica.ProcedimientoIngresaMercaderia.abrirConsultaProducto;
import static Logica.ProcedimientoIngresaMercaderia.actualizaError;
import static Logica.ProcedimientoIngresaMercaderia.actualizaErrorAnular;
import static Logica.ProcedimientoIngresaMercaderia.cerrarCP;
import static Logica.ProcedimientoIngresaMercaderia.clickElementByID;
import static Logica.ProcedimientoIngresaMercaderia.clickElementByName;
import static Logica.ProcedimientoIngresaMercaderia.esperaAbrir;
import static Logica.ProcedimientoIngresaMercaderia.esperaCerrar;
import static Logica.ProcedimientoIngresaMercaderia.esperaTabla;
import static Logica.ProcedimientoIngresaMercaderia.findElementByName;
import static Logica.ProcedimientoIngresaMercaderia.findElementsFromWebElement;
import static Logica.ProcedimientoIngresaMercaderia.sendKeyToElementByID;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;

/**
 *
 * @author sopor
 */
public class ProcedemientoAnular {

    public static void procedimiento3(String usuarioSaf, String ruta, ArrayList<Ingresos> arrDocumento, String comboBox, String ordenDeCompra, String numeroDocumento) throws InterruptedException, MalformedURLException, IOException, SQLException {
        int numReinicio = 10;
        int tiempoEspera = 15;
        int cont = 0;

        for (int t = 0; t < 1; t++) {
            IndicesDAO.updateIndiceEstado("" + arrDocumento.get(0).getIndice(), "anulando");

            cerrarCP();
            abrirConsultaProducto(ruta);
            System.out.println("79:");
            numReinicio = esperaAbrir("Acceso ...", tiempoEspera);
            System.out.println("numReinicio " + numReinicio);
            if (numReinicio == tiempoEspera) {
                cont++;
                actualizaErrorAnular(arrDocumento, "Error: 79");
                IndicesDAO.updateIndiceEstado("" + arrDocumento.get(0).getIndice(), "Error: 79");
                System.out.println("Error: 79");
                break;
            }

            System.out.println("80:");
            numReinicio = sendKeyToElementByID("TxtEditUsuario", usuarioSaf, tiempoEspera, false);
            System.out.println("numReinicio " + numReinicio);
            if (numReinicio == tiempoEspera) {
                IndicesDAO.updateIndiceEstado("" + arrDocumento.get(0).getIndice(), "Error: 80");

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
            System.out.println("81:");
            numReinicio = sendKeyToElementByID("TxtEditPasswd", "t55337", tiempoEspera, false);
            System.out.println("numReinicio " + numReinicio);
            if (numReinicio == tiempoEspera) {
                cont++;
                actualizaErrorAnular(arrDocumento, "Error: 81");
                IndicesDAO.updateIndiceEstado("" + arrDocumento.get(0).getIndice(), "Error: 81");
                System.out.println("Error: 81");
                break;
            }
            System.out.println("82:");
            numReinicio = clickElementByID("SAFBttnIngresar", tiempoEspera);
            System.out.println("numReinicio " + numReinicio);
            if (numReinicio == tiempoEspera) {
                cont++;
                actualizaErrorAnular(arrDocumento, "Error: 82");
                IndicesDAO.updateIndiceEstado("" + arrDocumento.get(0).getIndice(), "Error: 82");
                System.out.println("Error: 82");
                break;
            }
            System.out.println("83:");
            numReinicio = esperaCerrar("Acceso ...", tiempoEspera);
            System.out.println("numReinicio " + numReinicio);
            if (numReinicio == tiempoEspera) {
                cont++;
                actualizaErrorAnular(arrDocumento, "Error: 83");
                IndicesDAO.updateIndiceEstado("" + arrDocumento.get(0).getIndice(), "Error: 83");
                System.out.println("Error: 83");
                break;
            }
            System.out.println("84:");
            numReinicio = esperaTabla("Footer Panel", tiempoEspera);
            System.out.println("numReinicio " + numReinicio);
            if (numReinicio == tiempoEspera) {
                cont++;
                actualizaErrorAnular(arrDocumento, "Error: 84");
                IndicesDAO.updateIndiceEstado("" + arrDocumento.get(0).getIndice(), "Error: 84");
                System.out.println("Error: 84");
                break;
            }
            System.out.println("85:");
            numReinicio = clickElementByID("BtnConsultaFolio", tiempoEspera);
            System.out.println("numReinicio " + numReinicio);
            if (numReinicio == tiempoEspera) {
                cont++;
                actualizaErrorAnular(arrDocumento, "Error: 85");
                IndicesDAO.updateIndiceEstado("" + arrDocumento.get(0).getIndice(), "Error: 85");
                System.out.println("Error: 85");
                break;
            }
            System.out.println("86:");
            numReinicio = esperaAbrir("Consulta de Folios", tiempoEspera);
            System.out.println("numReinicio " + numReinicio);
            if (numReinicio == tiempoEspera) {
                cont++;
                actualizaErrorAnular(arrDocumento, "Error: 86");
                IndicesDAO.updateIndiceEstado("" + arrDocumento.get(0).getIndice(), "Error: 86");
                System.out.println("Error: 86");
                break;
            }
            System.out.println("87:");
            numReinicio = sendKeyToElementByID("TxtFolio", arrDocumento.get(0).getFolio(), tiempoEspera, false);
            System.out.println("numReinicio " + numReinicio);
            if (numReinicio == tiempoEspera) {
                cont++;
                actualizaErrorAnular(arrDocumento, "Error: 87");
                IndicesDAO.updateIndiceEstado("" + arrDocumento.get(0).getIndice(), "Error: 87");
                System.out.println("Error: 87");
                break;
            }
            System.out.println("88:");
            numReinicio = sendKeyToElementByID("TxtOcompra", arrDocumento.get(0).getOrdenDeCompra(), tiempoEspera, false);
            System.out.println("numReinicio " + numReinicio);
            if (numReinicio == tiempoEspera) {
                cont++;
                actualizaErrorAnular(arrDocumento, "Error: 88");
                IndicesDAO.updateIndiceEstado("" + arrDocumento.get(0).getIndice(), "Error: 88");
                System.out.println("Error: 88");
                break;
            }
            System.out.println("89:");
            numReinicio = clickElementByID("DevBuscar", tiempoEspera);
            System.out.println("numReinicio " + numReinicio);
            if (numReinicio == tiempoEspera) {
                cont++;
                actualizaErrorAnular(arrDocumento, "Error: 89");
                IndicesDAO.updateIndiceEstado("" + arrDocumento.get(0).getIndice(), "Error: 89");
                System.out.println("Error: 89");
                break;
            }

            System.out.println("90:");
            Object[] objectsPaneldeDatos = findElementByName("Panel de datos", tiempoEspera);
            System.out.println("numReinicio " + Integer.valueOf(objectsPaneldeDatos[1].toString()));
            if (Integer.parseInt(objectsPaneldeDatos[1].toString()) == tiempoEspera) {
                cont++;
                actualizaErrorAnular(arrDocumento, "Error: 90");
                IndicesDAO.updateIndiceEstado("" + arrDocumento.get(0).getIndice(), "Error: 90");
                System.out.println("Error: 90");
                break;
            }

            WebElement findElementByName = (WebElement) objectsPaneldeDatos[0];

            System.out.println("91:");
            Object[] findElementsFromWebElement = findElementsFromWebElement(findElementByName, "*/*", tiempoEspera);
            System.out.println("numReinicio " + Integer.valueOf(findElementsFromWebElement[1].toString()));
            if (Integer.parseInt(findElementsFromWebElement[1].toString()) == tiempoEspera) {
                cont++;
                actualizaErrorAnular(arrDocumento, "Error: 91");
                IndicesDAO.updateIndiceEstado("" + arrDocumento.get(0).getIndice(), "Error: 91");
                System.out.println("Error: 91");
                break;
            }
            List<WebElement> findElements = (List<WebElement>) findElementsFromWebElement[0];

            int size = findElements.size();
            System.out.println("size " + size);

            if (size == 2) {
                System.out.println("92:");
                numReinicio = clickElementByID("SaFBttnAnularFolio", tiempoEspera);
                System.out.println("numReinicio " + numReinicio);
                if (numReinicio == tiempoEspera) {
                    cont++;
                    actualizaErrorAnular(arrDocumento, "Error: 92");
                    IndicesDAO.updateIndiceEstado("" + arrDocumento.get(0).getIndice(), "Error: 92");
                    System.out.println("Error: 92");
                    break;
                }
                System.out.println("93:");
                numReinicio = esperaAbrir("Anular", tiempoEspera);
                System.out.println("numReinicio " + numReinicio);
                if (numReinicio == tiempoEspera) {
                    cont++;
                    actualizaErrorAnular(arrDocumento, "Error: 93");
                    IndicesDAO.updateIndiceEstado("" + arrDocumento.get(0).getIndice(), "Error: 93");
                    System.out.println("Error: 93");
                    break;
                }
                System.out.println("94:");
                numReinicio = clickElementByName("&Sí", tiempoEspera);
                System.out.println("numReinicio " + numReinicio);
                if (numReinicio == tiempoEspera) {
                    cont++;
                    actualizaErrorAnular(arrDocumento, "Error: 94");
                    IndicesDAO.updateIndiceEstado("" + arrDocumento.get(0).getIndice(), "Error: 94");
                    System.out.println("Error: 94");
                    break;
                }
                System.out.println("95:");
                numReinicio = esperaAbrir("Atencion", 2);
                System.out.println("numReinicio " + numReinicio);
                if (numReinicio < 2) {
                    cont++;
                    actualizaErrorAnular(arrDocumento, "Error: 95");
                    IndicesDAO.updateIndiceEstado("" + arrDocumento.get(0).getIndice(), "Error: 95");
                    System.out.println("Error: 95");
                    break;
                }

                IndicesDAO.updateIndiceEstado("" + arrDocumento.get(0).getIndice(), "anulado");
                IndicesDAO.updateIndicePDF("" + arrDocumento.get(0).getIndice(), null);
            } else {
                cont++;
                actualizaErrorAnular(arrDocumento, "Error: 79");
                IndicesDAO.updateIndiceEstado("" + arrDocumento.get(0).getIndice(), "Error: 96");
                System.out.println("Error: 96");
                break;
            }
        }
    }
}
