package com.spring.seeker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeekerController {
	@Autowired
    SeekerService seekerService;
	
	@ResponseBody
	@RequestMapping("")
	public String seekerHome()
	{
		// return "Create a Seeker Web service";
		return "Create Assignment 3 Web service";
	}

    @RequestMapping(value = "/seeker/{seekerId}", method = RequestMethod.GET)
    Seeker getSeeker(@PathVariable("seekerId") int seekerId) throws Exception {
        return seekerService.getSeeker(seekerId);
    }

    @RequestMapping(value = "/seekers", method = RequestMethod.GET)
    Iterable<Seeker> getSeekers() {
        return seekerService.getSeekers();
    }

    @RequestMapping(value = "/seeker", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    void addSeeker(@RequestBody Seeker seeker) throws Exception {
    	seekerService.addSeeker(seeker);
    }

    @RequestMapping(value = "/seeker/{seekerId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    void updateSeeker(@PathVariable("seekerId") int seekerId, @RequestBody Seeker seeker) throws Exception {
        seeker.setSeekerId(seekerId);
        seekerService.updateSeeker(seeker);
    }

    @RequestMapping(value = "/seeker/{seekerId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    void deleteSeeker(@PathVariable("seekerId") int seekerId) throws Exception {
    	seekerService.deleteSeeker(seekerId);
    }
}
