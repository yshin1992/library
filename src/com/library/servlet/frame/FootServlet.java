package com.library.servlet.frame;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.constants.UrlConstants;

@WebServlet(name="foot",urlPatterns="/manager/foot.do")
public class FootServlet extends HttpServlet
{
    private static final long serialVersionUID = 5120367460262473740L;
    
    public void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException
    {
        request.getRequestDispatcher(UrlConstants.FRAME_FOOT_PAGE).forward(request, response);
    }
}
