import tester.Tester;

// to represent a pet
interface IPet {
	boolean checkName(String that);
}

//to represent a pet owner
class Personnn {
  String name;
  IPet pet;
  int age;

  Personnn(String name, IPet pet, int age) {
		this.name = name;
		this.pet = pet;
		this.age = age;
  }
  
  
  
  // -> boolean
  //returns true if this Personnn is older than the other given its age
  
  
  //TEMPLATE
  /*
   
   FIELDS:
   ... this.age ...  		  --int
   ... this.pet ...               --IPet
   ... this.name ...              --String
   METHODS:
   ... this.isOlder() ...  	  --boolean
   ... this.sameNamePet() ...     --boolean
   */
  
  boolean isOlder(Personnn other) {
  	return this.age > other.age;
  }
  
/* TEMPLATE
 * 
 * FIELDS:
   ... this.age ...  --int
   ... this.pet ...  --IPet
   ... this.name ... --String
   
   METHODS:
   	... this.isOlder() ...         --boolean
   	... this.sameNamePet() ...     --boolean
   	
   METHODS on pet:
    ... this.checkName() ...	       --boolean
 */

  
  //-> boolean
  // Returns true if this pet's name matches the given name
  boolean sameNamePet(String petName){
 	  return this.pet.checkName(petName);
  }
  
  
/* TEMPLATE
 * 
 * FIELDS:
   ... this.age ...  --int
   ... this.pet ...  --IPet
   ... this.name ... --String
   
   METHODS:
   	... this.isOlder() ...         --boolean
   	... this.sameNamePet() ...     --boolean
   	... this.perish() ... 	       --Personnn
 
 */
  
  //->Person
  //Returns the Person if its pet has perished
  Personnn perish(){
  	return new Personnn(this.name, new NoPet(), this.age);
  }
}

class NoPet implements IPet{
	NoPet(){};
	
	public boolean checkName(String that){
		return false;
	}
}

// to represent a pet cat
class Cat implements IPet {
  String name;
	String kind;
	boolean longhaired;
 
  Cat(String name, String kind, boolean longhaired) {
    this.name = name;
    this.kind = kind;
    this.longhaired = longhaired;
  }
  
  /* TEMPLATE
   * 
   * FIELDS:
     ... this.name ...       --String
     ... this.kind ...       --String
     ... this.longhaired ... --boolean
     
     METHODS:
     	... this.checkName() ...         --boolean
   */
  
  
  //-> boolean
  // Returns true if this cat's name is same as that.
  public boolean checkName(String that){
  	return this.name.equals(that);
  }
}
 
// to represent a pet dog
class Dog implements IPet {
  String name;
  String kind;
  boolean male;
 
  Dog(String name, String kind, boolean male) {
  	this.name = name;
    this.kind = kind;
    this.male = male;
  }
  
  /* TEMPLATE
   * 
   * FIELDS:
     ... this.name ...       --String
     ... this.kind ...       --String
     ... this.longhaired ... --boolean
     
     METHODS:
     	... this.checkName() ...         --boolean
   */
  
  
  //-> boolean
  // Returns true if this dog's name is same as that.
  public boolean checkName(String that){
  	return this.name.equals(that);
  }
}
    
class ExamplesIPet {
    	
	IPet cat = new Cat("Serena", "Ragdoll", true);
	IPet cat2 = new Cat("Lizalie", "Russian Blue", false);
	IPet dog = new Dog("Chase", "Maltese", false);
	IPet dog2 = new Dog("Cerbrus", "Bulldog", true);
	IPet noPet = new NoPet();
	
	Personnn a = new Personnn("Lionel", this.dog, 32);
	Personnn b = new Personnn("Shakira", this.dog, 45);
	Personnn c = new Personnn("Toni", this.cat, 23);
	Personnn d = new Personnn("Marco", this.cat, 19);
	Personnn e = new Personnn("Ben", this.dog, 19);
	Personnn f = new Personnn("Michael", this.dog2, 14);
	Personnn g = new Personnn("Ben", this.cat2, 15);
	Personnn h = new Personnn("Messi", this.noPet, 12);
	Personnn i = new Personnn("Neymar", this.noPet, 5);
	
	
	boolean testIsOlder(Tester t) {
	return
			t.checkExpect(this.a.isOlder(b), false) &&
			t.checkExpect(this.c.isOlder(d), true) &&
			t.checkExpect(this.e.isOlder(d), false) &&
			t.checkExpect(this.f.isOlder(g), false) &&
			t.checkExpect(this.a.isOlder(g), true);
		
	}
	
	boolean testSameNamePet(Tester t){
		return 
			t.checkExpect(a.sameNamePet("Chase"), true) &&
			t.checkExpect(b.sameNamePet("Cerbrus"), false) &&
			t.checkExpect(b.sameNamePet("Chase"), true) && 
			t.checkExpect(c.sameNamePet("Chase"), false) &&
			t.checkExpect(c.sameNamePet("Serena"), true);
	}
	

	boolean testCheckName(Tester t){
		return
			//class Cat
			t.checkExpect(cat.checkName("Chase"), false) &&
			t.checkExpect(cat2.checkName("Lizalie"), true) &&
			//class Dog
			t.checkExpect(dog.checkName("Chase"), true) &&
			t.checkExpect(dog2.checkName("Oreo"), false);
	}
	
	boolean testPerish(Tester t) {
		Personnn p = this.a.perish();
		Personnn q = this.d.perish();
		Personnn r = this.i.perish();
		return
			t.checkExpect(p.name, "Lionel")&&
			t.checkExpect(p.pet, this.noPet)&&
			t.checkExpect(p.age,32) &&
			t.checkExpect(q.name, "Marco") &&
			t.checkExpect(q.pet, this.noPet)&&
			t.checkExpect(q.age, 19) && 
			t.checkExpect(r.name, "Neymar")&&
			t.checkExpect(r.pet, this.noPet)&&
			t.checkExpect(r.age, 5) && 
			t.checkExpect(c.name, "Toni")&&
			t.checkExpect(c.pet, this.cat)&&
			t.checkExpect(c.age, 23);
	}
}

