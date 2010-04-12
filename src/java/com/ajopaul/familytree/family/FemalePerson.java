package com.ajopaul.familytree.family;

import java.util.Set;


public class FemalePerson extends Person implements FemaleRelations
{
  
  public FemalePerson(String name)
  {
    super(name);
  }

  public FemalePerson()
  {
  }

  
  public Set<Person> getSisterOf()
  {
    return getSiblings();
  }
 
  public Person getWifeOf()
  {
    return getSpouse();
  }

  public Set<Person> getMotherOf()
  {
    return getChildren();
  }
 
}
