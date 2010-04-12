package com.ajopaul.familytree.family;

import java.util.HashSet;
import java.util.Set;

public class Person
{
  String name;
  int age;
  String gender;
  Set<Person> siblings;
  Set<Person> children;
  Person spouse;
  Set<Person> parents;
  
  public Person(String name){
    this.name = name;
  }
  
  
  public Person()
  {
  }

  public Person getSpouse()
  {
    return spouse;
  }
  
  /**
   * Add spouse and also transfer the children.
   * @param spouse
   */
  public void setSpouse(Person spouse)
  {
    this.spouse = spouse;
    if(null == spouse.getSpouse()){
      spouse.setSpouse(this);
    }
    this.setChildren(spouse.getChildren());
  }
  
  private void setParents(Set<Person> parent){
    this.parents = parent;
  }
  
  private void setChildren(Set<Person> children)
  {
    this.children = children;
    
  }
  /**
   * Set this person as child of parent.
   * also set the same for this person's siblings.
   * also add this child to parent as a child.
   * @param parent
   */
  public void addParent(Person parent){
    if(null != parents) {
      if(!isPersonAlreadyAdded(parents, parent) && parents.size() < 2){
        parents.add(parent);
      }else{
        return;
      }
    }else{
      parents = new HashSet<Person>(2);
      parents.add(parent);
    }
    
    Set<Person> tempSiblings = getSiblings();
    if(null != tempSiblings)
      for(Person sib:tempSiblings){
        sib.addParent(parent);
      }
    
    parent.addChild(this);
    
    if(null != parent.getSpouse()){
      parent.getSpouse().addChild(this);
    }
  }

  public String getName()
  {
    return name;
  }
  public void setName(String name)
  {
    this.name = name;
  }
  public int getAge()
  {
    return age;
  }
  public void setAge(int age)
  {
    this.age = age;
  }
  public String getGender()
  {
    return gender;
  }
  public void setGender(String gender)
  {
    this.gender = gender;
  }
  
  /**
   * Add person as a sibling also add person as a child to this person's parent.
   * @param person
   */
  public void addSibling(Person person){
    if(null != siblings){
      if(!isPersonAlreadyAdded(siblings,person)){
        siblings.add(person);
      }else{
        return;
      }
    }else{
      siblings = new HashSet<Person>();
      siblings.add(person);
    }
    
    if(null != this.parents){
      if(null != person.getParents()){
        if(this.parents.size() > person.getParents().size()){
          person.setParents(this.parents);
        }else if(this.parents.size() < person.getParents().size()){
          this.setParents(person.parents);
        }
      }else{
        for(Person parent:this.parents){
          person.addParent(parent);
        }
      }
    }
    
    person.addSibling(this);
  }
  
  public Set<Person> getParents(){
   return parents; 
  }
  
  /**
   * Check if the person is alread there in the set of relations.
   * @param relations
   * @param person
   * @return boolean
   */
  private boolean isPersonAlreadyAdded(Set<Person> relations,Person person)
  {
    boolean isAdded = false;
    for(Person per:relations){
      if(per.equals(person)){
        isAdded = true;
        break;
      }
    }
    return isAdded;
  }
  
  
  /**
   * Add person as this person's child 
   * and the person's siblings as this person's child.
   * @param person
   */
  public void addChild(Person person){
    if(null != children){
      if(!isPersonAlreadyAdded(children, person)){
        children.add(person);
      }else{
        return;
      }
    }else{
      children = new HashSet<Person>();
      children.add(person);
    }

    person.addParent(this);
   
    /*
    Set<Person> tempSiblings = person.getSiblings();
    if(null != tempSiblings){
      for(Person sibling:tempSiblings){
        if(null == sibling.getChildOf()){
          sibling.setChildOf(this);
        }
        if(null != children && !isPersonAlreadyAdded(children, sibling)){
          this.addChild(sibling);
        }
      }
    }
    */
    if(null != this.getSpouse()){
      this.getSpouse().addChild(person);
    }
  }
  
  public Set<Person> getSiblings(){
    return siblings;
  }
  
  public Set<Person> getChildren(){
    return children;
  }
  
  public Person getMother(){
    if(null != parents){
      for(Person parent:parents){
        if(parent instanceof FemalePerson){
          return parent;
        }
      }
    }
    return null;
  }
  
  public Person getFather(){
    if(null != parents){
      for(Person parent:parents){
        if(parent instanceof MalePerson){
          return parent;
        }
      }
    }
    return null;
  }
  
  @Override
  public String toString()
  {
    if(null != getName()){
      return getName();
    }
    return super.toString();
  }
}
