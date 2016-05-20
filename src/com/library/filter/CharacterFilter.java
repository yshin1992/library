package com.library.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName="characterFilter",urlPatterns="/*")
public class CharacterFilter implements Filter
{

    @Override
    public void destroy()
    {

    }

    @Override
    public void doFilter(ServletRequest request , ServletResponse response , FilterChain chain) throws IOException,
            ServletException
    {
        request.setCharacterEncoding("UTF-8");
        chain.doFilter(request, response);
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException
    {

    }

}
