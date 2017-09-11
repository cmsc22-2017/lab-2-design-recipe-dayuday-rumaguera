import tester.Tester;

// to represent a pet
interface IPet { }

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
   ... this.name ...
   ... this.pet ...
   ... this.age ...
   
   METHODS:
   ... this.isOlder ...
   
   */
  
  boolean isOlder(Personnn other) {
  	return this.age > other.age;
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
}
    
class ExamplesIPet {
    	
	IPet cat = new Cat("Serena", "Ragdoll", true);
	IPet cat2 = new Cat("Lizalie", "Russian Blue", false);
	IPet dog = new Dog("Chase", "Maltese", false);
	IPet dog2 = new Dog("Cerbrus", "Bulldog", true);
	
	
	Personnn a = new Personnn("Lionel", this.dog, 32);
	Personnn b = new Personnn("Shakira", this.dog, 45);
	Personnn c = new Personnn("Toni", this.cat, 23);
	Personnn d = new Personnn("Marco", this.cat, 19);
	Personnn e = new Personnn("Ben", this.dog, 19);
	Personnn f = new Personnn("Michael", this.dog2, 14);
	Personnn g = new Personnn("Ben", this.cat2, 15);
	
	boolean testIsOlder(Tester t) {
		return
				t.checkExpect(this.a.isOlder(b), false) &&
				t.checkExpect(this.c.isOlder(d), true) &&
				t.checkExpect(this.e.isOlder(d), false) &&
				t.checkExpect(this.f.isOlder(g), false) &&
				t.checkExpect(this.a.isOlder(g), true);
		
	}
  	
}


    
    
