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
class NationController {

  private final NationRepository repository;

  NationController(NationRepository repository) {
    this.repository = repository;
  }

  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/nation")
  List<Nation> all() {
    return repository.findAll();
  }
  // end::get-aggregate-root[]

  @PostMapping("/nation")
  Nation newNation(@RequestBody Nation newNation) {
    return repository.save(newNation);
  }

  // Single item
  
  @GetMapping("/nation/{id}")
  Nation one(@PathVariable Long id) {
    
    return repository.findById(id)
      .orElseThrow(() -> new NationNotFoundException(id));
  }

  @PutMapping("/nation/{id}")
  Nation replaceNation(@RequestBody Nation newNation, @PathVariable Long id) {
    
    return repository.findById(id)
      .map(nation -> {
    	  nation.setName(newNation.getName());
    	  nation.setPopulation(newNation.getPopulation());
        return repository.save(nation);
      })
      .orElseGet(() -> {
        newNation.setId(id);
        return repository.save(newNation);
      });
  }

  @DeleteMapping("/nation/{id}")
  void deleteNation(@PathVariable Long id) {
    repository.deleteById(id);
  }
  
}