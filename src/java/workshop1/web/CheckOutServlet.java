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
import javax.servlet.http.HttpSession;
import worksop1.model.Cart;
import worksop1.model.Item;

/**
 *
 * @author nirav
 */
@WebServlet(urlPatterns = "/CheckOut")
public class CheckOutServlet extends HttpServlet{
    
    //Injecting Cart proxy
    @Inject private Cart cart;

    @Override
    protected void doPost(HttpServletRequest req, 
            HttpServletResponse resp) throws ServletException, IOException {
        
        //Removing SessionID cookie to reset session
        HttpSession session = req.getSession();
        session.invalidate();
        
        //Final response page - as defined in assignment.
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.setContentType("text/html");
        
        try(PrintWriter pw = resp.getWriter()){
            pw.print("<h2>Checkout</h2>");
            pw.print("<b>The contents of your cart:</b>");
            pw.print("<br>");
            
            pw.print("<ul>");
            for (Item i: cart.getAllItems()) {
		pw.print(String.format("<li>%s (%d)</li>", i.getItem(), i.getQuantity()));
            }
            pw.print("</ul>");
            pw.print("<br>");
            
            pw.print("<u>Thank you for shopping with us!</u>");
            
        }
        
    }
    
    
    
}
