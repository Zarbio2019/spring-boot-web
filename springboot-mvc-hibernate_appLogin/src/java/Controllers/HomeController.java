/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

/**
 *
 * @author VERONICA
 */
@Controller
public class HomeController {

    //Para http://localhost:8080/Usuarios/home
    @RequestMapping(value = "/home") //Si ingreso la URL con /home, se ejecutará esta función ModelAndView
    public ModelAndView home() {
        return new ModelAndView();
    }

    //Para http://localhost:8080/Usuarios/home/*
    @RequestMapping(value = "/home/*") //* = Si ingreso cualquier cosa en la URL despues de /home/
    public void error(HttpServletResponse res) {
        try {
            res.sendRedirect("http://localhost:8080/Usuarios/error");
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
    //Si se desea implementar a partir de /home/"otras funciones"
}
