/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ceti.sistemas.proyectoceti.controllers.listeners;

import io.github.cdimascio.dotenv.Dotenv;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author Dario
 */
public class AplicacionListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent evento) {
        Dotenv dotenv = Dotenv.load();
        String urlAplicacion = dotenv.get("URL_APLICACION");
        System.out.println(urlAplicacion);
        evento.getServletContext().setAttribute("url_aplicacion", urlAplicacion);
        System.out.println("--------------------Proyecto iniciado--------------");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("-----------------Proyecto apagado --------------------");
    }
}
