package org.ceti.sistemas.proyectoceti.utils;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {

    public static void enviar(String destinatario, String asunto, String cuerpo) {
        String host = "";
        final String remitente = "";// colocar el valor que le de su proveedor
        final String password = "";// colocar el valor que le de su proveedor

        //Get the session object  
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(remitente, password);
            }
        });

        //Compose the message  
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(remitente));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            message.setSubject(asunto);
            message.setText(cuerpo);
            //send the message  
            Transport.send(message);
            System.out.println("Mensaje enviado correctamente...");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
