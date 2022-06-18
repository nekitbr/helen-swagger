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
class BendController {

  private final BendRepository repository;

  BendController(BendRepository repository) {
    this.repository = repository;
  }

  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/bendings")
  List<Bend> all() {
    return repository.findAll();
  }
  // end::get-aggregate-root[]

  @PostMapping("/bendings")
  Bend newBend(@RequestBody Bend newBend) {
    return repository.save(newBend);
  }

  // Single item
  
  @GetMapping("/bendings/{id}")
  Bend one(@PathVariable Long id) {
    
    return repository.findById(id)
      .orElseThrow(() -> new BendNotFoundException(id));
  }

  @PutMapping("/bendings/{id}")
  Bend replaceBend(@RequestBody Bend newBend, @PathVariable Long id) {
    
    return repository.findById(id)
      .map(bend -> {
    	  bend.setName(newBend.getName());
    	  bend.setOrigin(newBend.getOrigin());
        return repository.save(bend);
      })
      .orElseGet(() -> {
        newBend.setId(id);
        return repository.save(newBend);
      });
  }

  @DeleteMapping("/bendings/{id}")
  void deleteBend(@PathVariable Long id) {
    repository.deleteById(id);
  }
}
