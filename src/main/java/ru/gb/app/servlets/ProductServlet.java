package ru.gb.app.servlets;

import ru.gb.app.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> list = new ArrayList<>();
        list.add(new Product(1, "Milk", 10));
        list.add(new Product(2, "Bread", 1));
        list.add(new Product(3, "Cheese", 3));
        list.add(new Product(4, "Water", 2));
        list.add(new Product(5, "Butter", 6));
        list.add(new Product(6, "Apple", 12));
        list.add(new Product(7, "Cucumber", 34));
        list.add(new Product(8, "Tomato", 23));
        list.add(new Product(9, "Pear", 11));
        list.add(new Product(10, "Meat", 54));
        resp.getWriter().printf("<html><body>");
        for (Product product : list) {
            resp.getWriter().println(product);
            resp.getWriter().println("<p></p>");
        }
        resp.getWriter().printf("</body></html>");
    }
}
