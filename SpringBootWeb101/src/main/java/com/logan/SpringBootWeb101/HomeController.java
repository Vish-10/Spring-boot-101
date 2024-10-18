package com.logan.SpringBootWeb101;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String home(){
        //this function is responsible for calling the index.jsp

        return "index";
    }

    //servlet way of doing it
//    @RequestMapping("add")
//    public String add(HttpServletRequest req, HttpSession session){
//        int num1 = Integer.parseInt(req.getParameter("num1"));
//        int num2 = Integer.parseInt(req.getParameter("num2"));
//        int result = num1 + num2;
//        System.out.println(result);
//
//        session.setAttribute("result", result);//this is used to maintain a data between multiple pages
//
//        return "result.jsp";
//    }

    @RequestMapping("add")
    public String add(HttpServletRequest req, Model model){
        int num1 = Integer.parseInt(req.getParameter("num1"));
        int num2 = Integer.parseInt(req.getParameter("num2"));
        int result = num1 + num2;
        System.out.println(result);

        model.addAttribute("result", result);//this is the model part of the MVC structure

        return "result";
    }
}
