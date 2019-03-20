package transport.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zlb on 2019.03.19.
 */
@RestController
@RequestMapping("/index")
public class Index {

    @RequestMapping("/list")
    public String index(){

        return new String("hello,world");
    }
}
