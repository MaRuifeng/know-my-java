# Java Functional Interface & Lambda Expressions

**Since Java 8**

A functional interface follows the pattern of containing only a single abstract method.
When defined in code, it is often annotated with `@FunctionalInterface` such that errors can be captured by the compiler when the pattern is violated. 
```
@FunctionalInterface
public interface Foo {
    String bar(String input);
}
``` 

Lambda expressions in Java are its first step into functional programming. 
A Java lambda expression is a function which can be created without belonging to any class. 
It can be passed around as if it were an object and executed on demand. 

Functional interfaces provide target types for Lambda expressions and method references.
This [blog](https://www.baeldung.com/java-8-lambda-expressions-tips) explains Java functional interfaces and lambda expressions with great tips. 
A more detailed introductory tutorial can be found [here](http://tutorials.jenkov.com/java/lambda-expressions.html).
Generally lambda expressions provide a more concise way to instantiate an functional interface 
compared to the traditional anonymous inner class, e.g. instead of 
```
Foo fooByInnerClass = new Foo() {
    @Override
    public String bar(String string) {
        return string.concat("bar");
    }
};
```
use a lambda expression as below
```
Foo foo = param -> param.concat("bar");
```
Generally there is no need to specify parameter types in lambda expressions since the compiler is able to resolve them through type inference. 
