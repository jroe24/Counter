package com.jacobroe.Counter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    
	@RequestMapping("/")
    public String welcome(HttpSession session){ //Counter starts at 0
        if (session.isNew()) {
            session.setAttribute("count", 0);
        }
        else { //Counter increment per HTTP session
            Integer count = (Integer) session.getAttribute("count");
            count+=1;
            session.setAttribute("count",count );
        }
        return "jsp/welcome.jsp";
        }
        
	@RequestMapping("/counter")
    public String showCounter(){
        return "jsp/counter.jsp";
	}
}