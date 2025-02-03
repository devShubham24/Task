package com.sb.main.controller1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuditController {
	
    @RequestMapping(method= RequestMethod.GET, path="/StaticBarChart")    //when you use @RestController tells Spring not to use the View Resolver.
    public String getfilename() {
  	  return "StaticBarchart.html";   
    }
	
}
