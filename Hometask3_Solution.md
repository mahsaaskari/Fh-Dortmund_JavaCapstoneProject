
## Question
- Provide a comparison of the concurrency models
(Procs & Cons)
- Explain differences between Concurrency vs Parallelism
- Explain the usage of Blocking Concurrency Algorithms and Non-blocking Concurrency Algorithms

## Solution

### Question 1. Provide a comparison of the concurrency models (Procs & Cons)
Processes:
Pros:
	•	Processes have a self-contained execution environment with their own memory space, providing strong isolation. 
	•	Each process has its own set of basic run-time resources, reducing the risk of resource conflicts. If one process fails or crashes, it typically doesn't affect other processes since they operate independently.
	•	Processes can communicate using IPC mechanisms such as pipes and sockets, facilitating cooperation between different applications.
Cons:
	•	Creating a new process incurs higher resource overhead compared to threads, as it involves duplicating the entire execution environment.
	•	Communication between processes through IPC can introduce overhead and complexity.
Threads
Pros:
	•	Threads share the same memory space within a process, making communication more efficient than inter-process communication.
	•	Creating a new thread is less resource-intensive than creating a new process, making threads more lightweight.
	•	Threads within the same process can execute in parallel, potentially improving performance on multi-core systems.
Cons:
	•	Shared memory between threads can lead to synchronization challenges like communication.

### Question 2. Explain differences between Concurrency vs Parallelism?
Concurrency refers to the concept of making progress on multiple tasks at the same time. In a concurrent system, tasks may be executed in overlapping time intervals. It doesn't necessarily mean that tasks are running simultaneously. In the Java programming language, concurrent programming is mostly concerned with threads. However, processes are also important. Parallel computing involves dividing a problem into subproblems, solving those problems simultaneously (in parallel, with each subproblem running in a separate thread), and then combining the results of the solutions to the subproblems. Java SE provides the fork/join framework, which enables you to implement parallel computing more easily in your applications. 

### Question 3. Explain the usage of Blocking Concurrency Algorithms and Non-blocking Concurrency Algorithms?
Blocking concurrency algorithms involve operations that may cause a thread to wait or block until a certain condition is satisfied. For example, the “synchronized” keyword is used to create a synchronized block or method. When a thread enters a synchronized block, it acquires a lock, and other threads attempting to enter synchronized blocks on the same object are blocked until the lock is released. java.util.concurrent.locks package allows developers to control access to shared resources, and a thread attempting to acquire a lock may be blocked if the lock is currently held by another thread. LinkedBlockingQueue from the java.util.concurrent package provides blocking operations for adding and removing elements. If the queue is full, an attempt to add an element will block until space becomes available, and if the queue is empty, an attempt to remove an element will block until an element is available. They help in avoiding race conditions, ensuring data consistency, and facilitating safe shared resource access in a multi-threaded environment.
Non-blocking algorithms refer to concurrency mechanisms where threads can make progress without being forced to wait for a certain condition or resource. For example, in Atomic Operations in the java. util.concurrent.atomic package, such as AtomicInteger, AtomicLong, and AtomicReference, which offer atomic operations without the need for explicit locks.
