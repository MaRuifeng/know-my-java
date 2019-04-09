# Composition vs. Inheritance

In object oriented programming, two fundamental ways of relating classes are ***inheritance*** and ***compositionVsInheritance***. 

While inheritance is a design technique to implement the *is-a* relationship, composition deals with the *has-a* relationship. 
But this is layman understanding in general terms. We need to look deeper into the philosophy and desgin details behind them so as to determine which one to use. 

Inheritance yields the benefits of dynamic binding and polymorphism, which help make the code easier to change and reuse. 
But the limitations are pretty obvious as well. 

* Inheritance makes the superclass and subclass tightly coupled
    * Changes to a superclass's interface not only ripples down the inheritance hierarchy, but also breaks code that just uses the subclass's interface
    * Changes to a subclass's interface has to be compatible with the superclass's interface, e.g. no method with the same signature but different return type is allowed
* Inheritance provides only weak encapsulation without access control
    * Once inherited, protected/public methods are exposed through all subclasses without a finely-grained access control
    * Subclasses unnecessarily inherits the testing scope of the subclass
* In Java, multiple class inheritance is not allowed. 

Composition is achieved by defining an instance variable of the "back-end class" type, and only exposes needed methods and attributes. 
This approach leads to only loose coupling and also provides finely-grained access control. 

Hence generally composition is used in favor of inheritance. Inheritance is used when the relationship between the superclass and the 
subclass is a permanent *is-a* that does not change throughout the lifetime of the application. 

**Don't use inheritance just to get code reuse.** 

**Don't use interface just to get polymorphism.** 

These comparisons are presented in [composition vs. inheritance](./) examples. 

It is easier to add a subclass (inheritance) than it is to add a new front-end class (composition), because 
inheritance comes with polymorphism. A code portion that relies upon a superclass interface can work with a new 
subclass without change, but not with a new front-end class. 

However, polymorphism can be nicely achieved in composition when used with interfaces.

Java interfaces solve the ambiguities in the "diamond problem" where a class multiply inherits from two classes that both descend
from a common superclass. If the two classes override a method in the superclass with different variables, or declare the same instance
variables with different values, the end class cannot decide which one to use when being invoked. Via interfaces, Java allows
multiple inheritance without detailed implementation. 

More importantly, Java interfaces enables more polymorphism than singly inherited classes, avoiding ambiguities caused by 
multiple inheritance of implementation.  

This is demonstrated in the [polymorphic composition](./polymorphicComposition/FoodProcessor.java) example.

[Composition vs. inheritance](https://www.artima.com/designtechniques/compoinh.html)

[Designing with interfaces](https://www.artima.com/designtechniques/interfaces.html)





