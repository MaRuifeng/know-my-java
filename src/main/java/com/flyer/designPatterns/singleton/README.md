# Design Pattern - Singleton

Singleton is a creational design pattern that restricts the instantiation of a class and ensures that only one 
instance of the class exists in the Java Virtual Machine. 

A singleton class must provide a global access point to get the instance of the class.

This pattern is commonly used for logging, DB drivers and caching etc. where a single instantiation 
of the target is necessary. 

There are different approaches to implement the Singleton pattern, but all of them have the 
following concepts. 

* Private constructor to restrict instantiation of the class from other classes
* Private static variable of the same class that is the only instance of the class
* Public static method that returns the instance of the class, which serves as a unique global access point

This [blog](https://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples) talks different implementation 
approaches in details with in depth discussions. 

Below 4 implementations will be listed here for demonstration purpose. 

* [Static block initialization]()
* [Lazy initialization]()
* [Thread safe singleton]()
* [Bill Pugh singleton]() 