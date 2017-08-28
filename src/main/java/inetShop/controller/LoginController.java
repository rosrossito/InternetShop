package inetShop.controller;

import inetShop.domain.User;
import inetShop.validator.Validator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 * Created by Администратор on 02.08.2017.
 */

@Controller
@RequestMapping("/login")
@SessionAttributes("user")
public class LoginController {

    protected Log log = LogFactory.getLog(getClass());
    boolean access;

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(ModelMap model) {

        User user = (User) model.get("user");
        model.addAttribute("access", "" + access);
        log.info("access -> " + access);

        if (user != null) {
            log.info("url -> " + "logout");
            return "login";
        } else {

            log.info("url -> " + "login");
            return "login";
        }
    }


    @RequestMapping(method = RequestMethod.POST)
    public String login(ModelMap model, @RequestParam(name = "submit", required = false) String submit,
                        @RequestParam(name = "login", required = false) String login,
                        @RequestParam(name = "password", required = false) String password,
                        @RequestParam(name = "logout", required = false) String logout,
                        SessionStatus status) {

        log.info("submit : " + submit);

        if (logout != null) {
//            model.addAttribute("user", null);
            access=false;
            model.addAttribute("access", "false");
            model.remove("user");
            status.setComplete();

        } else if (submit.equals("Sign In")) {

            Validator validator = new Validator();
            validator.setLogin(login);
            validator.setPassword(password);

            User user = new User(login, password);

            access = user.getAccess(login, password);
            model.addAttribute("access", "" + access);
//            if (user != null && (user.passwordConverter(password)).equals(user.getPassword())){
            if (access) {
                model.addAttribute("user", user);

                log.info("access granted for " + login);
                return "index";
            } else {
                model.addAttribute("validator", validator);
                log.info("access denied for " + login);
                model.addAttribute("errorPassMessage", "Неправильный логин или пароль");
            }
            return "login";
        }

        return "login";
    }


}
