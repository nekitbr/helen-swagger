package com.quatronacoes;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Bend {

  private @Id @GeneratedValue Long id;
  private String name;
  private String origin;

  Bend() {}

  Bend(String name, String origin) {

    this.name = name;
    this.origin = origin;
  }

  public Long getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }
  
  public String getOrigin() {
	    return this.origin;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }
  
  public void setOrigin(String origin) {
	    this.origin = origin;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof Bend))
      return false;
    Bend bend = (Bend) o;
    return Objects.equals(this.id, bend.id) && Objects.equals(this.name, bend.name)
    		&& Objects.equals(this.origin, bend.origin);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.name, this.origin);
  }

  @Override
  public String toString() {
    return "Bending{" + "id=" + this.id + ", name='" + this.name + '\'' + ", origin='" + this.origin + '\'' + '}';
  }
}
