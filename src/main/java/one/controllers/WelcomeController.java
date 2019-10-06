package one.controllers;

import one.internationalization.Internationalization;
import one.persistence.entity.User;
import one.servises.controllerservices.impl.LoginService;
import one.servises.controllerservices.impl.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private RegisterService registerService;
    @Autowired
    private Internationalization inter;



    @RequestMapping("/mainPage")
    public String welcome() {
        return "main";
    }


    @RequestMapping("/loginPage")
    public String loginPage() {
        return "login";
    }

    @RequestMapping("/registerPage")
    public String registerPage() {
        return "register";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:mainPage";
    }

    @GetMapping("/changeLanguage")
    public String changeLanguage(@RequestParam(name = "language") String language,
                                 @RequestParam(name = "requestURI") String uri) {
        return "redirect:" + uri;
    }

    @PostMapping("/login")
    public ModelAndView login(@RequestParam(name = "email") String email,
                              @RequestParam(name = "password") String password,
                              HttpSession session) {
        loginService.setEmail(email);
        loginService.setPassword(password);
        String result = loginService.handle();
        ModelAndView mv = new ModelAndView();
        if (result.equals("success")) {
            User user = loginService.getUser();
            session.setAttribute("user", user);
            mv.setViewName("redirect:/cabinet/mainPage");
            return mv;
        } else {
            mv.addObject("message", result);
            mv.setViewName("forward:/welcome/loginPage");
            return mv;
        }
    }

    @PostMapping("/register")
    public ModelAndView register(@RequestParam(name = "name") String name,
                                 @RequestParam(name = "surname") String surname,
                                 @RequestParam(name = "email") String email,
                                 @RequestParam(name = "password") String password,
                                 @RequestParam(name = "userType") String position,
                                 HttpServletRequest request) {

        SessionLocaleResolver localeResolver = (SessionLocaleResolver) inter.localeResolver();
        Locale locale = localeResolver.resolveLocale(request);
        registerService.setName(name);
        registerService.setSurname(surname);
        registerService.setEmail(email);
        registerService.setPassword(password);
        registerService.setPosition(position);
        registerService.setLocale(locale);
        String result = registerService.handle();
        ModelAndView mv = new ModelAndView();
        if (result.equals("success")) {
            User user = registerService.getUser();
            request.getSession().setAttribute("user", user);
            mv.setViewName("redirect:/welcome/successfulRegister");
            return mv;
        } else {
            mv.addObject("message", result);
            mv.setViewName("forward:/welcome/registerPage");
            return mv;
        }
    }

    @RequestMapping("/successfulRegister")
    public String successfulRegister() {
        return "successfulRegister";
    }

}
