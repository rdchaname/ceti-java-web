/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ceti.sistemas.proyectoceti.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.ceti.sistemas.proyectoceti.beans.Inscrito;
import org.ceti.sistemas.proyectoceti.beans.Usuario;
import org.ceti.sistemas.proyectoceti.models.UsuarioModel;
import org.ceti.sistemas.proyectoceti.utils.Email;

/**
 *
 * @author Dario
 */
@WebServlet(name = "RegistroController", urlPatterns = {"/registro"})
public class RegistroController extends HttpServlet {

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
        request.getRequestDispatcher("/auth/registro.jsp").forward(request, response);
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
        String apellido_paterno = request.getParameter("apellido_paterno");
        String apellido_materno = request.getParameter("apellido_materno");
        String nombres = request.getParameter("nombres");
        String celular = request.getParameter("celular");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Usuario usuario = new Usuario();
        Inscrito inscrito = new Inscrito();
        usuario.setEmail(email);
        usuario.setPassword(password);
        inscrito.setApellido_materno(apellido_materno);
        inscrito.setApellido_paterno(apellido_paterno);
        inscrito.setCelular(celular);
        inscrito.setNombres(nombres);
        UsuarioModel usuarioModel = new UsuarioModel();
        Usuario usuarioregistrado = usuarioModel.registrar(inscrito, usuario);
        if (usuarioregistrado != null) {
            Email.enviar(email, "Registro en Java Web", "Gracias por registrarse en Cursos Virtuales Java WEB");
            response.sendRedirect(request.getContextPath() + "/login");
        } else {
            HttpSession sesion = request.getSession();
            sesion.setAttribute("mensaje_error", "Sucedió un error en el registro");
            response.sendRedirect(request.getContextPath() + "/registro");
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
