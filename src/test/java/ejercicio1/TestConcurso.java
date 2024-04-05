package ejercicio1;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.junit.jupiter.api.Test;
import persistenciaEj1.EnDiscoRegistroInscripcion;

import java.time.LocalDate;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestConcurso {

    @Test
    public void inscripcionEnTermino() {
        Participante participante1 = new Participante("Ale", 12345);
        Participante participante2 = new Participante("Javier", 54321);

        Concurso concurso1 = new Concurso(LocalDate.now().minusDays(1),
                LocalDate.now().plusDays(4), "10KH",
                new EnDiscoRegistroInscripcion("C:\\Users\\amaya\\IdeaProjects\\Concursos\\src\\main\\resources\\prueba.txt"),
                new FakeProveedorFecha());
        concurso1.inscribir(participante1, LocalDate.now().minusDays(1));
        concurso1.inscribir(participante2, LocalDate.now().plusDays(1));

        assertTrue(concurso1.estaInscripto(participante1));
        assertTrue(concurso1.estaInscripto(participante2));
    }

    @Test
    public void inscripcionEnMemoria() {
        var fakeRegistro = new FakeRegistroInscripcion();
        Concurso concurso = new Concurso(LocalDate.now().minusDays(1),
                LocalDate.now().plusDays(5), "Concurso", fakeRegistro,
                new FakeProveedorFecha());
        Participante participante = new Participante("Agustin", 21445);

        concurso.inscribir(participante, LocalDate.now());
        String str = "05/04/2024, Agustin, Concurso";

        assertTrue(fakeRegistro.comienzaCon(str));
    }

    @Test
    public void incripcionFueraDeTermino() {
        Participante participante1 = new Participante("Javier", 12345);
        Concurso concurso1 = new Concurso(LocalDate.now().minusDays(1),
                LocalDate.now().plusDays(4), "10KH",
                new EnDiscoRegistroInscripcion("C:\\Users\\amaya\\IdeaProjects\\Concursos\\src\\main\\resources\\prueba.txt"),
                new FakeProveedorFecha());
        //concurso1.inscribir(participante1, LocalDate.now().plusDays(6));

        //assertFalse(concurso1.estaInscripto(participante1));
        try {
            concurso1.inscribir(participante1, LocalDate.now().plusDays(6));
        } catch (RuntimeException e) {
            assertNotNull(e);
        }
    }

    @Test
    public void participanteInscripto() {
        Participante participante1 = new Participante("Javier", 12345);
        Concurso concurso1 = new Concurso(LocalDate.now().minusDays(1),
                LocalDate.now().plusDays(4), "10KH",
                new EnDiscoRegistroInscripcion("C:\\Users\\amaya\\IdeaProjects\\Concursos\\src\\main\\resources\\prueba.txt"),
                new FakeProveedorFecha());
        concurso1.inscribir(participante1, LocalDate.now());

        assertTrue(concurso1.estaInscripto(participante1));
    }

    @Test
    public void mensajeEmail() {
        var fakeRegistro = new FakeRegistroInscripcion();
        Concurso concurso = new Concurso(LocalDate.now().minusDays(1),
                LocalDate.now().plusDays(5), "Concurso", fakeRegistro,
                new FakeProveedorFecha());
        Participante participante = new Participante("Agustin", 21445);

        concurso.inscribir(participante, LocalDate.now());


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
                new jakarta.mail.Authenticator() {
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
            message.setText(fakeRegistro.getContenido());
            //send the email message
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}

