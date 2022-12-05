/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaMail;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author karen_b
 */
@WebServlet(name = "DatosMail", urlPatterns = {"/DatosMail"})
public class DatosMail extends HttpServlet {

    private String host;
    private String puerto;
    private String usuarioCorreo;
    private String password;

    public void init() {

        ServletContext context = getServletContext();

        host = context.getInitParameter("host");
        puerto = context.getInitParameter("puerto");
        usuarioCorreo = context.getInitParameter("usuarioCorreo");
        password = context.getInitParameter("password");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String receptor = request.getParameter("textCorreo");
        String asunto = request.getParameter("textAsunto");
        String contenido = request.getParameter("textMensaje");
        String resultadoMensaje = "";

        try {

            ParametrosCorreo.envioCorreo(host, puerto, usuarioCorreo, password, receptor, asunto, contenido);
            resultadoMensaje = "El mensaje se envio de forma correcta";
        } catch (Exception e) {
            e.printStackTrace();
            resultadoMensaje = "Error al enviar el mensaje " + e.getMessage();
        } finally {
            request.setAttribute("mensaje", resultadoMensaje);
            getServletContext().getRequestDispatcher("/resultado.jsp").forward(request, response);
        }
    }

}
