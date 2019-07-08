# Objects and Classes Introduction

* *Objects* consists of:
  * *states* (aka properties/ attributes); represented by data fields and their values
    * Ex: A car object's state would consist of things like `mileage`, `vehicleType`, etc.
  * *behavior* (aka actions); these are defined by methods
    * Ex: A car object's methods would consist of things like `accelerate()`, `brake()`, etc.
* Objects are defined by `classes` which are template/ blueprint/ etc. that defines what an object's state and behavior will be
  * objects are `instances` of a classes; the term `instance` and `object` are interchangable

* *Note*... will not include examples of classes, since its so common

## Constructors

* *Constructors* are methods of a special type that classes provide, that are designed to perform initialization for objects (they create object and initialize their values)

* Some things to keep in mind:
  1. a constructor must have the same name as the class itself
  2. constructors do not have a return type (not even `void`)
  3. Contructors are invoked using the `new` operator when an object is created; Constructors play the role of initializing objects
  * Ex: `new ClassName(arguments);`

* if no constructor is defined, then *default constructor` is automatically provided which is a no-arg constructor with all values set to 0

## Reference Variables

* Since classes are a programmer-defined type, a class is a `reference type`, which means that a variable of the class type can reference an instance of the class
* After an object is created its data can be accessed and its method invoked using the *dot operator*
  * Ex: `objectRefVar.dataField` or `objectRefVar.method(arg)`
* Note, a variable of a primitive type holds a value of the primitive type, but a variable of a reference type holds a reference (aka *address*) to where an object is stored in memory
  * so when you assign a primitive variable to another variable, you are *copying* the value and making a separate container to hold that value; so changes to the original variable would not affect the copy variable (and vice versa)
  * however, when you assign a reference variable to another variable, you are not copying the object or creating a duplicate object; you are just tranferring the address of the object to another variable; so, changes to the copy reference variable will affect the original reference variable *since they both "reference" the same object*
    * also note that when object has no reference variable, Java will see it as "garbage" and automatically delete during garbage collection

## Static variables, constants, and methods

* a *static variable* is shared by all objects of the class
  * so an *instance* field/ variable is tied to a specific instance(object) of a class; two objects of the same class have different instance fields and don't share them
  * Static variables store values in a commom memory location; so if one object changes the value of a static variable, all objects of the same class are affected
* a *static method* cannot access instance members of the class
  * static methods can be called without creating an instance of the class
* to create static anything, put the modifier `static` in the variable/ method declaration

## Visibility Modifiers

* the `public` visibility modifier denotes that it can be accessed from any other classes
* if no visibility modifier, then it is set to default visibility (aka package-private or package-access) which means that its accessible by any class in the same package
  * Note regarding *packages*:
    * packages can be used to organize classes
    * to create/ denote as package, add this as the first noncomment/ nonblank code statement in the program: `package packageName;`
    * if a class is defined without the package statment, it is said to be placed in the `default package`
* the `private` modifier makes it so it is accessible only from within its own class

## Data field encapsulation

* to prevent direct modifications of data fields, you should declare the data fields private (this is known as *encapsulation*)
* to make the private data fields accessible by an object from outside the class, make *getter*/ *setter* methods
* Note: Look further into encapsulation/ coupling in the future

## Passing Objects/ Values to methods

* Like arrays, when you pass an object to method, you are passing the reference of the object
  * However, NOTE that java uses exactly one mode of passing arguemnts: pass by value (see [link:](https://www.journaldev.com/3884/java-is-pass-by-value-and-not-pass-by-reference))
  * When you pass an object (nonprimitive) to method, you are passing a *copy* of the reference (this is why is pass by value)
  * However, it is a little bit more complicated than that (see [link](https://stackoverflow.com/questions/373419/whats-the-difference-between-passing-by-reference-vs-passing-by-value))
  * Basically, nonprimitives like objects, arrays, etc. can be thought of as being passed by reference, which would mean that any changes to object, will affect methods, etc. that pass that bbject as argument

## Array of Objects

* an array can hold objects as well as primitive type values
  * an array of objects is more accurately an array of *reference variables*
  * Ex: This statement declares/ creates an array of ten `Circle` objects: `Circle[] circleArr = new Circle[10];`
