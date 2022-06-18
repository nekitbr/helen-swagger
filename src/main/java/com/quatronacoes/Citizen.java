package com.quatronacoes;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Citizen {

  private @Id @GeneratedValue Long id;
  private String name;
  private String nation;
  private String role;
  private String bending;
  private Boolean alive;

  Citizen() {}

  Citizen(String name, String nation, String role, String bending, boolean alive) {

    this.name = name;
    this.nation = nation;
    this.role = role;
    this.bending = bending;
    this.alive = alive;
  }

  public Long getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }
  
  public String getNation() {
	    return this.nation;
  }
  
  public String getRole() {
	    return this.role;
  }
  
  public String getBending() {
	    return this.bending;
  }
  
  public Boolean getAlive() {
	    return this.alive;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setNation(String nation) {
	    this.nation = nation;
  }
  
  public void setRole(String role) {
    this.role = role;
  }
  
  public void setBending(String bending) {
	    this.bending = bending;
  }
  
  public void setAlive(Boolean alive) {
	    this.alive = alive;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof Citizen))
      return false;
    Citizen citizen = (Citizen) o;
    return Objects.equals(this.id, citizen.id) && Objects.equals(this.name, citizen.name)
    		&& Objects.equals(this.nation, citizen.nation) && Objects.equals(this.role, citizen.role) && Objects.equals(this.bending, citizen.bending) && Objects.equals(this.alive, citizen.alive);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.name, this.nation, this.role, this.bending, this.alive);
  }

  @Override
  public String toString() {
    return "Citizen{" + "id=" + this.id + ", name='" + this.name + '\'' + ", nation='" + this.nation + '\'' + ", role='" + this.role + '\'' + ", bending='" + this.bending + '\'' + ", alive='" + this.alive + '\'' + '}';
  }
}