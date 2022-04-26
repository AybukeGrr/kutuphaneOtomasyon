/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package filter;

import entity.Kullanici;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author 90553
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) sr;
        HttpServletResponse response = (HttpServletResponse) sr1;

        String url = request.getRequestURI();
        Kullanici kullanici = (Kullanici) request.getSession().getAttribute("validUser");

        if (kullanici == null) {//kullanıcı yok ise 
            if (url.contains("admin") || url.contains("logout")) {
                response.sendRedirect(request.getContextPath() + "/login.xhtml");
            } else {
                fc.doFilter(sr, sr1);

            }
        } else {
            if (url.contains("login") || url.contains("register")) {
                response.sendRedirect(request.getContextPath() + "/admin/index.xhtml");
            } else if (url.contains("logout")) {
                request.getSession().invalidate();
                response.sendRedirect(request.getContextPath() + "/login.xhtml");

            } else {
                fc.doFilter(sr, sr1);

            }
        }

    }

}
