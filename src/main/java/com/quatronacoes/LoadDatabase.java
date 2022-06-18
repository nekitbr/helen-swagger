package com.quatronacoes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(CitizenRepository repository, NationRepository nationRepository, BendRepository bendRepository) {

    return args -> { 
      log.info("Preloading " + repository.save(new Citizen("Aang", "Air Nomade", "Avatar", "Air, water, earth, fire and lighting", true)));
      log.info("Preloading " + repository.save(new Citizen("Sokka", "Southern Water Tribe", "Avatar Team warrior", "No bending", true)));
      log.info("Preloading " + repository.save(new Citizen("Katara", "Southern Water Tribe", "Avatar Team warrior", "Water, blood and healing", true)));
      log.info("Preloading " + repository.save(new Citizen("Toph Beifong", "Earth Kingdom", "Avatar Team warrior", "Earth and metal", true)));
      log.info("Preloading " + repository.save(new Citizen("Zuko", "Fire Nation", "Prince", "Fire and lighting", true)));
      log.info("Preloading " + repository.save(new Citizen("Suki", "Earth Kingdom", "Kyoshi Warrior", "No bending", true)));
      log.info("Preloading " + repository.save(new Citizen("Jet", "Earth Kingdom", "Freedom Warrior", "No bending", false)));
      log.info("Preloading " + repository.save(new Citizen("Lu Ten", "Fire Nation", "Prince and soldier", "Fire", false)));
      log.info("Preloading " + repository.save(new Citizen("Iroh", "Fire Nation", "Royal Family member", "Fire and lighting", true)));
      log.info("Preloading " + repository.save(new Citizen("Azula", "Fire Nation", "Princess", "Fire and lighting", true)));
    
      log.info("Preloading " + bendRepository.save(new Bend("Air", "Flying Bisons")));
      log.info("Preloading " + bendRepository.save(new Bend("Water", "Moon and Ocean Spirits")));
      log.info("Preloading " + bendRepository.save(new Bend("Earth", "Badgermoles")));
      log.info("Preloading " + bendRepository.save(new Bend("Fire", "Dragons")));
      log.info("Preloading " + bendRepository.save(new Bend("Energy", "Raava and Lion Turtles")));
      log.info("Preloading " + bendRepository.save(new Bend("Flight", "Air")));
      log.info("Preloading " + bendRepository.save(new Bend("Spiritual projection", "Air")));
      log.info("Preloading " + bendRepository.save(new Bend("Blood", "Water")));
      log.info("Preloading " + bendRepository.save(new Bend("Healing", "Water")));
      log.info("Preloading " + bendRepository.save(new Bend("Lava", "Earth")));
      log.info("Preloading " + bendRepository.save(new Bend("Metal", "Earth")));
      log.info("Preloading " + bendRepository.save(new Bend("Sand", "Earth")));
      log.info("Preloading " + bendRepository.save(new Bend("Lighting", "Fire")));
      log.info("Preloading " + bendRepository.save(new Bend("Combustion", "Fire")));
      
      log.info("Preloading " + nationRepository.save(new Nation("Air Nomades", 1)));
	  log.info("Preloading " + nationRepository.save(new Nation("Fire Nation", 100000)));
	  log.info("Preloading " + nationRepository.save(new Nation("Earth Kingdom", 200000)));
	  log.info("Preloading " + nationRepository.save(new Nation("Water Tribes", 50000)));
    };
  }
 
}