package in.anandm.oj.listener;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class LoggingAuthenticationSuccessHandler implements
        AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication)
            throws IOException, ServletException {
        String ip = request.getRemoteAddr();
        String emailId = request.getParameter("emailId");
        LoggerFactory.getLogger(getClass()).info(
                "{} logged in successfully from ip : {}", emailId, ip);

        response.sendRedirect(request.getContextPath() + "/todo/todos");
    }
}
