/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest; //Recibe datos del servlet del servidor
import javax.servlet.http.HttpServletResponse; //Envia datos al servlet del servidor
import javax.servlet.http.HttpSession; //Para sesiones HTTP
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author VERONICA
 */
@Controller
public class IndexController {

    //Creamos las solicitudes a los Controladores
    private String delimiter = "/";
    private HttpSession misession;

    @RequestMapping(method = RequestMethod.GET) //Interfaz para solicitud por HTTP
    public void procesar(HttpServletRequest req, HttpServletResponse res) {
        String url = req.getRequestURI(); //Obtiene los parametros URL que colocamos en el navegador
        //p.e: url = /Usuarios/ (desde http://localhost:8080/Usuarios/)
        String[] dataUrl = url.split(delimiter);
        misession = req.getSession(true); //obtiene la sesión activa
        misession.setAttribute("uses", ""); //"" = almacena "" en sesión
        
        try {
        if (dataUrl.length == 2) { //Si ingreso la URL, entonces envío solicitud al Controller "home"
            
                res.sendRedirect("home");
        }
        else{ //Sino, envio solicitud de error al Controller "error"
            res.sendRedirect("http://localhost:8080/Usuarios/error");
        }
        } catch (IOException ex) {
            //Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    }
}
