# Java Generics

Generic Java methods and classes enable programmers to specify a set of related methods with a single method declaration or 
a set of related types with a single class declaration. E.g. 
```
List<String> stringList = new ArrayList<>();
List<Integer> integerList = new ArrayList<>();
```

## Generic methods

Written in a single declaration, callable with arguments of different types. 

[Sample code](./JavaGenericMethodDemo.java)

* Single type parameter
* Multiple type parameters
* Bounded type parameter

## Generic classes

Similar type parameter usage to that of generic methods, also known as parametrized classes or parametrized types. 

[Sample code](./JavaGenericClassDemo.java)

## Wildcards in generics

Wildcards are represented by the question mark `?` in Java and are used to refer to an unknown type. They can very useful
in extending methods of parametrized type arguments to the type's subtypes and supertypes, to work around below constraint.

***Object* is the supertype of all Java classes, but a collection of *Object* is not the supertype of any collection.**

Note that this is a valid constraint to prevent possible conflicts caused by adding heterogeneous types to the same collection.

[Sample code](./WildcardGenericDemo.java)

## Type erasure
Generics were added into Java to ensure type safety. To avoid the generics causing overhead at runtime, the compiler
applies a prcess called *type erasure* on generics during compilation. 

It removes all generic type parameters and replace it with their upper bounds if available or else the **Object** class. After compilation, 
the bytecode contains only normal classes, interfaces and methods. No new types are produced. Proper type casting is applied during compilation as well. 

This also infers that primitive data types cannot be used as type parameters as they do not extend the **Object** class. 
Below code won't compile. 

`List<int> list = new ArrayList<>();`