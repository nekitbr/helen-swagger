package com.quatronacoes;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Nation {

  private @Id @GeneratedValue Long id;
  private String name;
  private int population;

  Nation() {}

  Nation(String name, int population) {

    this.name = name;
    this.population = population;
  }

  public Long getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }
  
  public int getPopulation() {
	    return this.population;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }
  
  public void setPopulation(int population) {
	    this.population = population;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof Nation))
      return false;
    Nation nation = (Nation) o;
    return Objects.equals(this.id, nation.id) && Objects.equals(this.name, nation.name)
    		&& Objects.equals(this.population, nation.population);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.name, this.population);
  }

  @Override
  public String toString() {
    return "Citizen{" + "id=" + this.id + ", name='" + this.name + '\'' + ", nation='" + this.population + '\'' + '}';
  }
}