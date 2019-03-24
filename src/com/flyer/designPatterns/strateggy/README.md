# Design Patten - Strategy

The strategy design patten enables an algorithm's behavior to be selected at runtime.
When there are multiple algorithms for a specific task, this pattern can be used to let the client application decide which one to use.

Normally it comprises a single strategy interface, multiple strategy classes and a context where a strategy class can be instantiated and used. 

A good usage example of the strategy pattern is the `Collections.sort()` method that takes in a `Comparator` parameter, which is an implementation of the `Comparator` interface.
Based on different strategies passed in, the objects are sorted in different ways. 

The example is adapted from this [blog](https://www.journaldev.com/1754/strategy-design-pattern-in-java-example-tutorial).