package com.quatronacoes;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class CitizenController {

  private final CitizenRepository repository;

  CitizenController(CitizenRepository repository) {
    this.repository = repository;
  }

  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/citizen")
  List<Citizen> all() {
    return repository.findAll();
  }
  // end::get-aggregate-root[]

  @PostMapping("/citizen")
  Citizen newCitizen(@RequestBody Citizen newCitizen) {
    return repository.save(newCitizen);
  }

  // Single item
  
  @GetMapping("/citizen/{id}")
  Citizen one(@PathVariable Long id) {
    
    return repository.findById(id)
      .orElseThrow(() -> new CitizenNotFoundException(id));
  }

  @PutMapping("/citizen/{id}")
  Citizen replaceCitizen(@RequestBody Citizen newCitizen, @PathVariable Long id) {
    
    return repository.findById(id)
      .map(citizen -> {
    	  citizen.setName(newCitizen.getName());
    	  citizen.setNation(newCitizen.getNation());
    	  citizen.setRole(newCitizen.getRole());
    	  citizen.setBending(newCitizen.getBending());
    	  citizen.setAlive(newCitizen.getAlive());
        return repository.save(citizen);
      })
      .orElseGet(() -> {
        newCitizen.setId(id);
        return repository.save(newCitizen);
      });
  }

  @DeleteMapping("/citizen/{id}")
  void deleteCitizen(@PathVariable Long id) {
    repository.deleteById(id);
  }
}