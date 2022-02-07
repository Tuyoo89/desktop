package controller;

import database.UserDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class UserLogInController extends HttpServlet {

    final static UserDB userDB = new UserDB();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phoneNumber = req.getParameter("phone_number");

        String user = userDB.getByPhoneNum(phoneNumber);

        if(user.equals("")){
            req.getRequestDispatcher("registration.jsp").forward(req,resp);
        }
    }
}
