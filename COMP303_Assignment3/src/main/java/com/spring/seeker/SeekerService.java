package com.spring.seeker;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class SeekerService {
	Map<Integer, Seeker> seekers = new HashMap<>();

    public void addSeeker(Seeker seeker) throws Exception {
        if(seekers.containsKey(seeker.getSeekerId())) {
            throw new Exception("This seeker Id already exists");
        }
        else {
        	seekers.put(seeker.getSeekerId(), seeker);
        }
    }

    public Iterable<Seeker> getSeekers(){
        return seekers.values();
    }

    public Seeker getSeeker(int seekerId) throws Exception {

        if(seekers.containsKey(seekerId)) {
            return seekers.get(seekerId);
        }
        else {
            throw new Exception("Seeker Id not found");
        }
    }

    public void updateSeeker(Seeker seeker) throws Exception {
        if(seekers.containsKey(seeker.getSeekerId())) {
            seekers.put(seeker.getSeekerId(), seeker);
        }
        else {
            throw new Exception("Seeker Id not found");
        }
    }

    public void deleteSeeker(int seekerId) throws Exception {
        if(seekers.containsKey(seekerId)) {
            seekers.remove(seekerId);
        }
        else {
            throw new Exception("Seeker Id not found");
        }
    }
}
