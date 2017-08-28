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

/**
 * Created by Администратор on 01.08.2017.
 */

@Controller
@RequestMapping("/registration")
@SessionAttributes("user")
public class RegistrationController {

    protected Log log = LogFactory.getLog(getClass());

    User user = new User();

    @RequestMapping(method = RequestMethod.GET)
    public String getSomething(ModelMap model) {
        return "registration";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String registration(ModelMap model,
                               @RequestParam("login") String login,
                               @RequestParam("password") String password,
                               @RequestParam("retypepsw") String retypepsw,
                               @RequestParam(name="agree", required=false) String agree,
                               @RequestParam("name") String name,
                               @RequestParam("region") String region,
                               @RequestParam("feedback") String feedback,
                               @RequestParam(name="gender", required=false) String gender,
                               @RequestParam("submit") String submit
    ) {

        if (submit.equals("Register")) {
            Validator validator = new Validator();
            validator.setLogin(login);
            validator.setPassword(password);
            validator.setRetypepsw(retypepsw);
            validator.setAgree(agree);
            validator.setName(name);
            validator.setRegion(region);
            validator.setFeedback(feedback);
            validator.setGender(gender);

                user.setLogin(login);
                user.setPassword(password);
                user.setRetypepsw(retypepsw);
                user.setAgree(agree);
                user.setName(name);
                user.setRegion(region);
                user.setFeedback(feedback);
                user.setGender(gender);
                model.addAttribute("user", user);
            if (validator.isValid()) {
                boolean reg = user.getRegistration();
                    if (!reg){
                    System.out.println("Пользователь с таким логином уже зарегистрирован");
                    return "registration";
                }else{

                    return "login";
                }
            } else {
                model.addAttribute("validator", validator);
                log.info("Not valid data");
                return "registration";
            }
        }
        return "registration";

    }

}
