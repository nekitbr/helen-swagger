package com.quatronacoes;

class BendNotFoundException extends RuntimeException {

	BendNotFoundException(Long id) {
    super("Could not find bend " + id);
  }
}