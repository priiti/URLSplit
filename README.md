# URLSplit
URL splitting application using RegEx and State Machine implementations

**URL Definition**  
scheme://domain:port/path?query_string  
**Port** is an optional field  
**Query** String is an optional field  

* Write a program to split a URL to parts: scheme, host, port, path and parameters.
* The program will read the URL from command line.
* The program will implement 2 splitting algorithms and compare their performance.
* The **first algorithm** will use regular expressions.
* The **second algorithm** will be based on a state machine.
* The program will run 10000 iterations of each algorithm.
* The program will output URL parts and runtimes of both algorithms.
Note – comments describing the main parts of the code are required

* Source and compiled jar should be zipped and sent for review.
* You can use online sources but you must include comments explaining the code and algorithm.
* Once received there will be a review of the test and the methods used.

Example

**Input:**
splitUrl "http://host:8090/path?params"  

**Output:**  
http  
host  
8090  
path  
params  
Regex: 15msec  
State: 10msec  
