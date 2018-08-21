/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.servlet;

import com.udea.ejb.VehiclesFacadeLocal;
import com.udea.entity.Vehicles;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author victor restrepo
 */
public class VehiclesServlet extends HttpServlet {

    @EJB
    private VehiclesFacadeLocal vehiclesFacade;

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
                List<Vehicles> findAll = vehiclesFacade.findAll();
                request.getSession().setAttribute("vehicles", findAll);
                url = "listVehicles.jsp";
            } else if ("insert".equals(action)) {
                Vehicles a = new Vehicles();
                //String idu = request.getParameter("induser");
                //a.setId(Integer.parseInt(idu));
                a.setBrand(request.getParameter("marca"));
                a.setModel(request.getParameter("modelo"));
/*
                if (result > 0) {
                    response.sendRedirect("result.jsp?message=Image+Uploaded");
                } else {
                    response.sendRedirect("result.jsp?message=Some+Error+Occurred");
                }
                */
                /*Part _photo = request.getPart("imagen");
                try (InputStream is = _photo.getInputStream()) {
                    byte[] photo = new byte[is.available()];
                    is.read(photo);
                }*/
                a.setValor(request.getIntHeader("valor"));
                vehiclesFacade.create(a);
                url = "login.jsp";
            } else if ("delete".equals(action)) {
                String id = request.getParameter("id");
                Vehicles a = vehiclesFacade.find(Integer.valueOf(id));
                vehiclesFacade.remove(a);
                url = "VehiclesServlet?action=list";
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
