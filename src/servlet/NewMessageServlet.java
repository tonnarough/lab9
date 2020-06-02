package servlet;

import entity.ChatMessage;
import entity.ChatUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;

public class NewMessageServlet extends ChatServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String message = (String) request.getParameter("message");

        if (message != null && !"".equals(message)) {
            ChatUser author = activeUsers.get((String) request.getSession().getAttribute("name"));

            synchronized (messages) {
                messages.add(new ChatMessage(message, author, Calendar.getInstance().getTimeInMillis()));
            }
        }
        getServletContext().setAttribute("i",0);
        response.sendRedirect("/lab9/chat/messages");
    }
}