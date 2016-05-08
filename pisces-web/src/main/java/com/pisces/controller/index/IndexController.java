package com.pisces.controller.index;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jun.xu on 16/5/7.
 */
@Controller
public class IndexController {
    @RequestMapping(value = {"/","/index"})
    public String index(ModelMap modelMap) {
        return "index";
    }
}
