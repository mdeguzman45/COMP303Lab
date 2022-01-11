package com.example.demo.Services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.Seeker;
import com.example.demo.Repositories.SeekerRepository;

@Service
public class SeekerService {
	@Autowired
	SeekerRepository repository;
	
	@PostConstruct
	private void initializeSeekers() {
		// Input 3 initial seekers
		if(repository.count() == 0) {
			Seeker seeker1 = new Seeker(
						"Dean Carlo",
						"Pinlac",
						LocalDate.of(1995, 6, 28),
						"Male",
						"Scarborough",
						"6476163701"
					);
			
			Seeker seeker2 = new Seeker(
					"Elyza Pamela",
					"Cruz",
					LocalDate.of(1996, 3, 6),
					"Female",
					"Scarborough",
					"6471234444"
				);
			
			Seeker seeker3 = new Seeker(
					"Test",
					"Seeker",
					LocalDate.of(2012, 11, 30),
					"Female",
					"Toronto",
					"6471234567"
				);
			
			repository.save(seeker1);
			repository.save(seeker2);
			repository.save(seeker3);
		}
	}
	
	public List<Seeker> getAll(){
		return repository.findAll();
	}
	
	public Seeker getById(long id){
		Optional<Seeker> seeker = repository.findById(id);
		return seeker.orElse(null);
	}
	
	public Seeker save(Seeker seeker){
		return repository.save(seeker);
	}
	
	public void removeById(long id) {
		repository.deleteById(id);
	}
}
