/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ceti.sistemas.proyectoceti.utils;

import org.jasypt.util.password.StrongPasswordEncryptor;

/**
 *
 * @author Dario
 */
public class Encriptacion {

    public static String encriptarPassword(String password) {
        StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
        return passwordEncryptor.encryptPassword(password);
    }

    public static boolean compararPassword(String password, String passwordEncriptada) {
        StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
        return passwordEncryptor.checkPassword(password, passwordEncriptada);
    }
}
