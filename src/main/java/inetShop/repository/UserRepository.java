package inetShop.repository;

import inetShop.domain.Category;
import inetShop.domain.Product;
import inetShop.domain.User;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by Администратор on 08.07.2017.
 */
public class UserRepository {
    Connection con = null;
    Statement stmt = null;
    List categories;
    List<Product> products;

    public Connection connect_to_database_from_properties() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Properties prop = new Properties();

        InputStream is;
        try {

            is = this.getClass().getClassLoader().getResourceAsStream("config.properties");

            prop.load(is);

            String url = prop.getProperty("url");
            String user = prop.getProperty("user");
            String pass = prop.getProperty("password");
            is.close();
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, pass);
            stmt = con.createStatement();
            stmt.execute("SET NAMES 'UTF8'");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean getAuthorithation(String login, String password) {
        String query = "SELECT login,password FROM customers WHERE login='" + login + "' and password='" + password +
                "';";

            try {
                ResultSet rs = stmt.executeQuery(query);

                if (rs.next()) {
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        return false;
    }


    public boolean registration(String login, String password, String name, String region, String feedback, String
            gender) {

        if (getAuthorithation(login, password)) {
            System.out.println("User with such login or password is registered.");
            return false;
        } else {
            String query1 = "INSERT INTO customers (login, password, name, region, feedback, gender)" + "VALUES ('" + login +
                    "','" + password + "','" + name + "','" + region + "','" + feedback + "','" + gender + "');";
            try {
                stmt.executeUpdate(query1);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }


    public List getCategories() {

//        String query = "SELECT * FROM category;";
//        categories = new ArrayList();
//
//        try {
//            ResultSet rs = stmt.executeQuery(query);
//            while (rs.next()) {
//                Category category = new Category();
//                category.setId(rs.getLong("ID"));
//                category.setName(rs.getString("name"));
//                categories.add(category);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//


        categories = new ArrayList<Category>();
        Category category = new Category();
        category.setId(1L);
        category.setName("Книги");
        categories.add(category);


        return categories;
    }

    public String buildQuery(String category_id) {
        String query;
        if (category_id==null){
            query = "SELECT * FROM product;";
        }else {
            query = "SELECT * FROM product where category_id=" + category_id + ";";
        }
        return query;
    }

    public List getProducts(String query) {
//        String query = "SELECT * FROM product where category_id=" + category.getId() + ";";
//        String query = "SELECT * FROM product;";
        products = new ArrayList();
        try {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {

                Product product = new Product();
                product.setId(rs.getLong("ID"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getDouble("price"));
                product.setImage("images/" + rs.getString("image") + ".jpg");
                System.out.println(product.getName());
                products.add(product);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public User getUserByLogin(String login) {
        String query = "SELECT password FROM customers WHERE login='" + login + "';";
        User user = null;
        try {
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                user = new User(rs.getString("login"), rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public User getUser(int id) {
        String query = "SELECT login,password FROM customers WHERE id='" + id + "';";
        User user = null;
        try {
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                user = new User(rs.getString("login"), rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


}
