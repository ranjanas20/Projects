package com.greenfield.skateboard.entity;

import javax.persistence.*;


@Entity
public class Item {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer id;
  @Column
  private boolean checked;
  @Column
  private String description;
  
  public Item(){
	  super();
  }
  public Item(Integer id, boolean checked,String description){
	  super();
	  this.id=id;
	  this.checked=checked;
	  this.description=description;
  }
  
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public boolean isChecked() {
    return checked;
  }

  public void setChecked(boolean checked) {
    this.checked = checked;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

@Override
public String toString() {
	return "Item [id=" + id + ", checked=" + checked + ", description=" + description + "]";
}
  
  
}
