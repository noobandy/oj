package in.anandm.oj.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class BaseController {

    private static final String ALERTS = "alerts";

    protected void addAlert(Model model, Alert alert) {
        Map<String, Object> modelMap = model.asMap();
        List<Alert> alerts = (List<Alert>) modelMap.get(ALERTS);
        if (alerts == null) {
            alerts = new ArrayList<Alert>();
        }
        alerts.add(alert);

        model.addAttribute(ALERTS, alerts);
    }

    protected void addAlert(RedirectAttributes redirectAttributes, Alert alert) {
        Map<String, Object> modelMap = redirectAttributes.asMap();
        List<Alert> alerts = (List<Alert>) modelMap.get(ALERTS);
        if (alerts == null) {
            alerts = new ArrayList<Alert>();
        }
        alerts.add(alert);

        redirectAttributes.addFlashAttribute(ALERTS, alerts);
    }

    protected boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();

        return (authentication != null && authentication.isAuthenticated()
                && authentication.getPrincipal() != null && authentication
                    .getPrincipal() instanceof UserDetails);

    }
}
