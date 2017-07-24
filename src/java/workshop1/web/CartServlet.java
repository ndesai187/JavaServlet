/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop1.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import worksop1.model.Cart;
import worksop1.model.Item;

/**
 *
 * @author nirav
 */
@WebServlet(urlPatterns = "/addToCart")
public class CartServlet extends HttpServlet{
    
    //Injecting Cart proxy
    @Inject private Cart cart;
    @Override
    protected void doPost(HttpServletRequest req, 
            HttpServletResponse resp) throws ServletException, IOException {
        Item item = new Item();
        item.setItem(req.getParameter("Item"));
        int quant = Integer.parseInt(req.getParameter("Quantity"));
        item.setQuantity(quant);
        
        cart.add(item);
        
        resp.setStatus(HttpServletResponse.SC_ACCEPTED);
        resp.setContentType("text/html");
        
        try(PrintWriter pw = resp.getWriter()){
            pw.print("<h2>My Cart</h2>");
            pw.print("<ul>");
            for (Item i: cart.getAllItems()) {
		pw.print(String.format("<li>%s (%d)</li>", i.getItem(), i.getQuantity()));
            }
            pw.print("</ul>");

            pw.print("<a href='index.html'>Back</a><br><br>");
            
            pw.print("<form  method=\"POST\" action=\"CheckOut\">");
            pw.print("<button type=\"submit\">Checkout</button>");
            pw.print("</form>");
            
        }
        
    }
    
    
    
    
    
}
