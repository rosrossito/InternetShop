package inetShop.domain;

import java.util.ArrayList;

/**
 * Created by Администратор on 30.07.2017.
 */
public class Cart {

    private ArrayList <Product> products;


    public ArrayList getProducts() {
        return products;
    }

    public void setProducts(ArrayList products) {
        this.products = products;
    }

    public void addProduct(Product product)
    {
        if (products == null) {
            products = new ArrayList();
        }

        products.add(product);
    }

    public void deleteProduct(String productId)
    {
        int i=0;
        for (Product product : products){
            if (product.getId()==Long.valueOf(productId)) {
                products.remove(i);
                break;
            }
        i++;
        }


    }

}
