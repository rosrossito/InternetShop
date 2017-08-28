package inetShop.controller;

import inetShop.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Администратор on 30.07.2017.
 */

@Controller
@RequestMapping("/products")
public class ProductController {

//    Long category;

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(ModelMap model,
                      @RequestParam(name="category_id", required=false) String category_id) {


//        if (category_id != null) {
//            category = Long.valueOf("category_id");
//        } else {
//            category = null;
//        }
        UserRepository userRepository = new UserRepository();
        userRepository.connect_to_database_from_properties();

        List products;
        products = userRepository.getProducts(userRepository.buildQuery(category_id));
        model.addAttribute("products", products);

    return "products";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doPost(ModelMap model){

        return "products";

    }
}
