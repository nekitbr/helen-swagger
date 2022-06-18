package com.quatronacoes;

class NationNotFoundException extends RuntimeException {

	NationNotFoundException(Long id) {
    super("Could not find nation " + id);
  }
}
