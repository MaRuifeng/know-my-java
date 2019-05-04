# BlockingQueue

The Java `BlockingQueue` interface represents a thread safe queue data structure. 
It is a concurrent collection from the `java.util.concurrent` package. 

A typical implementation of this interface is `ArrayBlockingQueue` which exhibits following characteristics. 

* Circular array as the internal data structure
* Bounded capacity specified during instantiation
* FIFO order
* Constant time complexity for insertion and removal
* No need of synchronization or locking code, concurrency self-managed


`BlockingQueue` is often used in producer-consumer stream processing patterns. 