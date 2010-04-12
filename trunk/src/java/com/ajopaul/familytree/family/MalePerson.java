package com.ajopaul.familytree.family;

import java.util.Set;

public class MalePerson extends Person implements MaleRelations
{

  public MalePerson(String name)
  {
   super(name);
  }

  public MalePerson()
  {
    super();
  }

  public Set<Person> getBrotherOf()
  {
   return getSiblings();
  }

  public Set<Person> getFatherOf()
  {
    return getChildren();
  }

  public Person getHusbandOf()
  {
    return getSpouse();
  }
 
  
}
