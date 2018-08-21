/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.servlet;

import com.udea.ejb.SaleFacadeLocal;
import com.udea.entity.Sale;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author victor restrepo
 */
public class SaleServlet extends HttpServlet {

    @EJB
    private SaleFacadeLocal saleFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String action = request.getParameter("action");
            String url = "index.jsp";
            if ("list".equals(action)) {
                List<Sale> findAll = saleFacade.findAll();
                request.getSession().setAttribute("sales", findAll);
                url = "listSales.jsp";
            } else if ("insert".equals(action)) {
                Sale a = new Sale();
                //String idu = request.getParameter("induser");
                //a.setId(Integer.parseInt(idu));
                a.setClient(request.getParameter("username"));
                a.setId(request.getParameter("cedula"));
                //a.setFecha(response.);
                a.setEnrollment(request.getParameter("matricula"));
                a.setPayment(request.getParameter("valorapagar"));
                a.setGiveback(request.getParameter("devuelta"));
                saleFacade.create(a);
                url = "login.jsp";
            } else if ("delete".equals(action)) {
                String id = request.getParameter("id");
                Sale a = saleFacade.find(Integer.valueOf(id));
                saleFacade.remove(a);
                url = "saleServlet?action=list";
            } else if ("logout".equals(action)) {
                request.getSession().removeAttribute("login");
                url = "login.jsp";
            }
            response.sendRedirect(url);
        } finally {
            out.close();
        }
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
