/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cars;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sathwick
 */
@WebServlet(name = "CarsSellServlet", urlPatterns = {"/CarsSellServlet"})
public class CarsSellServlet extends HttpServlet {
    
    @EJB
    private CarsDaoLocal carsDao;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {      
        
        //String carID = request.getParameter("user");
        String make = request.getParameter("make");
        String model = request.getParameter("model");
        String year = request.getParameter("year");
        String color = request.getParameter("color");
        String type = request.getParameter("type");
        String price = request.getParameter("price");
        
        Cars cars = new Cars(make, model, year, color, type, price);
        carsDao.addCars(cars);
        
        /*PrintWriter out = response.getWriter();  
        response.setContentType("text/html");
        out.println("<script type=\"text/javascript\">");
        out.println("alert('Your car has been added');");
        out.println("location='Sell.jsp';");
        out.println("</script>");*/
        
        String message = "Your car has been added";
        request.setAttribute("message", message);
        
        request.getRequestDispatcher("Sell.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
