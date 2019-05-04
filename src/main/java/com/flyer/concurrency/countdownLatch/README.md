# CountDownLatch

`CountDownLatch` in Java is a type of synchronizer that allows one thread to wait for one or more other threads before it starts processing.

It works on the latch principle. The thread will wait until the gate is open. One thread waits for `n` number of threads specified when creating the latch. 

Any thread, usually the main thread of the application, which calls `CountDownLatch.await()` will wait until the count
reaches zero or it gets interrupted by another thread. All other threads that need to be waited for are required to do count down by calling
`CountDownLatch.countDown()` once they are completed or ready for the job. 
As soon as the count reaches zero, the waiting thread will start executing. 

The disadvantage of the `CountDownLatch` is that it's not reusable. Once the count becomes zero, it can't be used any more.  