package pe.edu.cibertec.adopta_patitas.Controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pe.edu.cibertec.adopta_patitas.viewmodel.LoginModel;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping("/inicio")
    public String inicio(Model model) {
        LoginModel loginModel = new LoginModel("00", "", "");
        model.addAttribute("loginModel", loginModel);
        return "inicio";
    }

    @PostMapping("/autenticar")
    public String autenticar(@RequestParam("tipoDocumento") String tipoDocumento,
                             @RequestParam("numeroDocumento") String numeroDocumento,
                             @RequestParam("password") String password,
                             Model model) {

        //Validar campos de entrada
        if(tipoDocumento == null || tipoDocumento.trim().length() == 0 ||
            numeroDocumento == null || numeroDocumento.trim().length() == 0 ||
            password == null || password.trim().length() == 0) {

            LoginModel loginModel = new LoginModel("01", "Error: Debe completar correctamente sus credenciale", "");
            model.addAttribute("loginModel", loginModel);
            return "inicio";
        }


        LoginModel loginModel = new LoginModel("00", "", "Cesar Santos");
        model.addAttribute("loginModel", loginModel);
        return "principal";
    }
}
