package persistenciaEj1;

import ejercicio1.RegistroInscripcion;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class EnMailRegistroInscripcion implements RegistroInscripcion {

    private List<String> inscripciones = new ArrayList<>();


    @Override
    public void registrar(String registro) {
        inscripciones.add(registro);
    }

    public void envioDeMail() {
        //provide recipient's email ID
        String to = "31eb13a63f-79850f+1@inbox.mailtrap.io";
        //provide sender's email ID
        String from = "31eb13a63f-79850f+1@inbox.mailtrap.io";
        //provide Mailtrap's username
        final String username = "0b65b3edcaf7f8";
        //provide Mailtrap's password
        final String password = "74fc12b4fdfb87";
        //provide Mailtrap's host address
        String host = "sandbox.smtp.mailtrap.io";
        //configure Mailtrap's SMTP server details
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");
        //create the Session object
        Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        try {
            //create a MimeMessage object
            Message message = new MimeMessage(session);
            //set From email field
            message.setFrom(new InternetAddress(from));
            //set To email field
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            //set email subject field
            message.setSubject("Envio de Email Prueba!");
            //set the content of the email message
            message.setText(String.join(System.lineSeparator(), this.inscripciones));
            //send the email message
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
