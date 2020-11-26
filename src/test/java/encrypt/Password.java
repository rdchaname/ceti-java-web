/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encrypt;

import org.jasypt.util.password.StrongPasswordEncryptor;

/**
 *
 * @author Dario
 */
public class Password {

    public static void main(String[] args) {
        String userPassword = "123456";
        String inputPassword = "123456";
        StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
        String encryptedPassword = passwordEncryptor.encryptPassword(userPassword);
        System.out.println(encryptedPassword);
        if (passwordEncryptor.checkPassword(inputPassword, encryptedPassword)) {
            System.out.println("Bien");
        } else {
            System.out.println("Mal");
        }
    }
}
