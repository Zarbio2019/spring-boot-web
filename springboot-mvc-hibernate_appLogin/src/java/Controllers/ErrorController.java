/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

/**
 *
 * @author VERONICA
 */
@Controller
public class ErrorController {

    @RequestMapping //No lleva paramtero no valida niingun ingreso de URL
    public ModelAndView error() {
        return new ModelAndView();
    }
}
