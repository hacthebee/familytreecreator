package com.ajopaul.familytree.family;

public class FamilyTreeMain
{
  public static void main(String[] args){
    MalePerson ajo = new MalePerson("ajo");
    MalePerson joy = new MalePerson("joy");
    MalePerson chacko = new MalePerson("chacko");
  
    FemalePerson jomy = new FemalePerson("jomy");
    FemalePerson ammini = new FemalePerson("ammini");
    FemalePerson maya = new FemalePerson("maya");
    FemalePerson mini = new FemalePerson("mini");
    FemalePerson aleyama = new FemalePerson("aleyama");
    
    aleyama.setSpouse(chacko);
    ajo.addSibling(jomy);
    joy.addChild(ajo);
    joy.setSpouse(ammini);
    maya.setSpouse(ajo);
    maya.addParent(chacko);
    maya.addSibling(mini);
   
    System.out.println("Created ");
  }
}
