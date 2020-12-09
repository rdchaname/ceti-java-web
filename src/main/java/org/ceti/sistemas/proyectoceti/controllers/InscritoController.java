/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ceti.sistemas.proyectoceti.controllers;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.ceti.sistemas.proyectoceti.beans.Inscrito;
import org.ceti.sistemas.proyectoceti.models.InscritoModel;

/**
 *
 * @author Dario
 */
@WebServlet(name = "InscritoController", urlPatterns = {"/admin/inscrito/*"})
public class InscritoController extends HttpServlet {

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
        String pathInfo = request.getPathInfo();
        if (pathInfo == null || "/".equals(pathInfo)) {
            InscritoModel inscritoModel = new InscritoModel();
            ArrayList<Inscrito> listado = inscritoModel.todos();
            request.setAttribute("listado_inscritos", listado);
            request.setAttribute("menu_activo", "admin/inscrito");
            request.getRequestDispatcher("/inscrito/index.jsp").forward(request, response);
        } else {
            pathInfo = pathInfo.substring(1);
            String[] ruta = pathInfo.split("/");
            switch (ruta[0]) {
                case "crear":
                    request.getRequestDispatcher("/inscrito/crear.jsp").forward(request, response);
                    break;
                case "editar":
                    Integer idInscrito = Integer.parseInt(ruta[1]);
                    InscritoModel inscritoModel = new InscritoModel();
                    Inscrito inscrito = inscritoModel.obtenerPorId(idInscrito);
                    request.setAttribute("inscrito", inscrito);
                    request.getRequestDispatcher("/inscrito/editar.jsp").forward(request, response);
                    break;
                default:
                    request.getRequestDispatcher("/errores/404.jsp").forward(request, response);
//                    response.sendError(HttpServletResponse.SC_NOT_FOUND);
                    break;
            }
        }

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
        request.setCharacterEncoding("UTF-8");
        String pathInfo = request.getPathInfo();
        if (pathInfo == null || "/".equals(pathInfo)) {
            InscritoModel inscritoModel = new InscritoModel();
            ArrayList<Inscrito> listado = inscritoModel.todos();
            request.setAttribute("listado_inscritos", listado);
            request.setAttribute("menu_activo", "admin/inscrito");
            request.getRequestDispatcher("/inscrito/index.jsp").forward(request, response);
        } else {
            pathInfo = pathInfo.substring(1);
            String[] ruta = pathInfo.split("/");
            InscritoModel inscritoModel = new InscritoModel();
            Inscrito inscrito;
            HttpSession sesion = request.getSession();
            switch (ruta[0]) {
                case "crear":
                    inscrito = new Inscrito();
                    inscrito.setNombres(request.getParameter("nombres"));
                    inscrito.setApellido_paterno(request.getParameter("apellido_paterno"));
                    inscrito.setApellido_materno(request.getParameter("apellido_materno"));
                    inscrito.setCelular(request.getParameter("celular"));
                    inscritoModel.registrar(inscrito);
                    sesion.setAttribute("mensaje", "Registrado correctamente");
                    response.sendRedirect(request.getContextPath() + "/admin/inscrito");
                    break;
                case "editar":
                    inscrito = inscritoModel.obtenerPorId(Integer.parseInt(ruta[1]));
                    inscrito.setNombres(request.getParameter("nombres"));
                    inscrito.setApellido_paterno(request.getParameter("apellido_paterno"));
                    inscrito.setApellido_materno(request.getParameter("apellido_materno"));
                    inscrito.setCelular(request.getParameter("celular"));
                    inscritoModel.actualizar(inscrito);
                    sesion.setAttribute("mensaje", "Actualizado correctamente");
                    response.sendRedirect(request.getContextPath() + "/admin/inscrito");
                    break;
                case "eliminar":
                    inscrito = inscritoModel.obtenerPorId(Integer.parseInt(ruta[1]));
                    inscritoModel.eliminar(inscrito.getId());
                    sesion.setAttribute("mensaje", "Eliminado correctamente");
                    response.sendRedirect(request.getContextPath() + "/admin/inscrito");
                    break;
                default:
                    response.sendRedirect(request.getContextPath() + "/admin/inscrito");
                    break;
            }
        }
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
