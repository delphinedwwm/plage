package fr.esgi.plage.controller;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class DeconnexionController {

    private final HttpSession httpSession;

    @GetMapping("/deconnexion")
    public ModelAndView deconnexion(){
        httpSession.invalidate();
        return new ModelAndView("redirect:/parasols");
    }
}
