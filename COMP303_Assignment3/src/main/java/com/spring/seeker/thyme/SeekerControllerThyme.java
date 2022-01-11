package com.spring.seeker.thyme;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.spring.seeker.Seeker;

@Controller
public class SeekerControllerThyme {
	private static List<Seeker> seekerList = new ArrayList<Seeker>();
	
    @RequestMapping("/seekerui")
    public String home()
    {
        return "index";
    }
    
    @RequestMapping(value = "/display_seeker", method = RequestMethod.POST)
    public ModelAndView saveSeeker(@ModelAttribute Seeker seeker)
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("seekerinfo");
        
        System.out.println("Seeker info");
        System.out.println("Seeker Id: " + seeker.getSeekerId());
        System.out.println("Seeker first name: " + seeker.getFirstName());
        System.out.println("Seeker last name: " + seeker.getLastName());
        System.out.println("Seeker age: " + seeker.getAge());
        System.out.println("Seeker gender: " + seeker.getGender());
        System.out.println("Seeker city: " + seeker.getCity());
        System.out.println("Seeker phone: " + seeker.getPhone());
        
        seekerList.add(seeker);
        mv.addObject("seekerList", seekerList);
        return mv;
    }
}
