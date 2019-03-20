package transport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import transport.domain.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by zlb on 2019.03.19.
 */
@Controller
@RequestMapping("/login")
public class Login {

    @RequestMapping("/login")
    public String login(){
        return  "login";
    }

    @RequestMapping("/index")
    public String toIndex(HttpServletRequest request, @RequestParam Map<String,User> map, String username, String password){
        //System.out.println(user.toString());
        //User user = new User();
        //user.setUsername(username);
        //user.setPassword(password);
//        /*HttpSession session = request.getSession();
//        session.setAttribute("username",username);
//        session.setAttribute("password",password);*/
        //map.put("user",user);
        return "index";
    }
}
