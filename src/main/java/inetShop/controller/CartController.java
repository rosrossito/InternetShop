package inetShop.controller;

import inetShop.domain.Cart;
import inetShop.domain.Product;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Администратор on 30.07.2017.
 */

@Controller
@RequestMapping("/cart")
@SessionAttributes("cart")
public class CartController {

    protected Log log = LogFactory.getLog(getClass());

//    Product product;
//    Cart cart = new Cart();


//    @RequestMapping(value = "/cart.htm", method = RequestMethod.POST)

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String productToCart(ModelMap model, @RequestParam("product") String json) {

        log.info("jsonRequest : " + json);

        Cart cart = (Cart) model.get("cart");
        if (cart == null) {
            cart = new Cart();
        }

        Product product = new Product();
        JSONObject jsonObj = null;
        try {
        jsonObj = new JSONObject(json);
        product.setId(jsonObj.getLong("id"));
        product.setName(jsonObj.getString("name"));
        product.setPrice(jsonObj.getDouble("price"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

//        Gson g = new Gson();
//        product = g.fromJson(json, Product.class);

        cart.addProduct(product);
        model.addAttribute("cart", cart);

        log.info("cart : " + cart.getProducts().get(0));


        JSONObject response = new JSONObject();
        log.info("jsonResponse : " + response);
        return response.toString();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(ModelMap model, @RequestParam(name="product_id", required=false) String productId) {


        Cart cart = (Cart) model.get("cart");

        log.info("In doGet");
        if (cart == null) {
            log.info("cart is empty");
            return "cart";
        }else if (productId!=null) {

            log.info("deleting product with id" + productId);
            cart.deleteProduct(productId);
            model.addAttribute("cart", cart);
            return "cart";
        }else {

            log.info(productId);
            return "cart";
        }
     }
}
