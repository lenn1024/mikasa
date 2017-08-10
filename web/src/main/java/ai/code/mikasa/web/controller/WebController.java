package ai.code.mikasa.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lenn on 2017/6/2.
 */
@Controller
public class WebController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String index(){
        return "hello mikasa.";
    }

    @RequestMapping(value = "/test/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Integer> testId(@PathVariable int id){
        Map<String, Integer> map = new HashMap<>();
        map.put("id", id);
        return map;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ModelAndView test(){
        return new ModelAndView("test");
    }

    @RequestMapping(value = "/testViewResolver", method = RequestMethod.GET)
    public ModelAndView testViewResolver(){
        return new ModelAndView("/WEB-INF/web.xml");
    }

}
