package com.quatronacoes;

class CitizenNotFoundException extends RuntimeException {

	CitizenNotFoundException(Long id) {
    super("Could not find citizen " + id);
  }
}