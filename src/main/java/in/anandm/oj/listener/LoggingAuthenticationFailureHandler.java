package in.anandm.oj.listener;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class LoggingAuthenticationFailureHandler implements
        AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception)
            throws IOException, ServletException {

        String ip = request.getRemoteAddr();
        String emailId = request.getParameter("emailId");

        LoggerFactory.getLogger(getClass()).info(
                "{} login failed from ip : {}", emailId, ip);

        response.sendRedirect(request.getContextPath() + "/");
    }
}
