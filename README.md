State space search - Sudoku solver for a 9 X 9 board

Assumptions made:

1. This algorithm currently works with a 9 X 9 board, however it can be extended to provide support for different variants - Mini (6*6), normal (9*9) and Hypersize (16*16).

2. In AI, State space search algorithms can be broadly classified as uninformed search and heuristic search.
Uninformed search allows us to perform search without any prior information or a function about the goal's location which makes it exhaustive and less efficient.

On the other hand, heuristic search allows us to consider and assign weights in the form of a function that helps to solve the problem faster than above by removing unnecessary
states that do not help us reach the goal.

In this project, with my knowledge in Depth First Search and Breadth First search algorithms, I was able to solve the sudoku puzzle.
With no prior background in AI, I could not implement any of the heuristic search algorithms such as A*, Branch-and-bound, etc due to time constraints. Also, I was not able to
come up with any heuristic functions that would help me to reach the goal easier.

Although I could not implement it myself, I have designed my project solution in such a way that the support for the heuristic algorithms can be easily added in the future if needed.

Little background about the sudoku problem and the features I added:

1. The APIs given to me were not modified. They were used as is and I designed the solution in such a way that I used the APIs as a baseline framework to provide support to 
the DFS and BFS search algorithms.

2. The brute force way of solving sudoku puzzle is by assigning each box from 1-9 for 9X9 board, which means, there are a total of 9 to the power of 81 operations involved,
where 9 is the total numbers from 1-9 and 81 boxes to fill and then we individually check if one of the combination reaches the solution/goal state.

However with search algorithms like Depth First Search, the above number of operations can be drastically reduced.
Per row, we have 9 ways to fill a single cell. The next cell in the row could be filled in 8 ways and then the next one in 7 ways and so on.
This basically means that for one row, we can take upto 9! operations to fill. This has to be expanded for 9 rows. Thus, we can complete it in 9! to the power of 9 operations.

This is enormously faster than the naive brute force approach.

3. Metrics comparing DFS and BFS have been added to compare total time taken to solve easy and difficult puzzles and total number of iterations involved.

4. Logger functionality has been added across the project with apache-log4j. A log file will be made available whenever you run the application.

5. Unit tests have been added to test different test cases, go through the test cases and run them for generating test reports.

6. Go through all the packages, comments have been added for almost all classes and test classes.

Instructions to run the project and solution:

1. I have attached 2 zip files. One is the project zip file and the other is the target zip file generated after running maven package commands.
I added the target zip file just in case although it is not necessary.

2. The project zip file contains the src folder and the entire source code. The Driver program is SudokuSolver.java which basically contains the 2 inputs given to me
in the questionnaire. Run this program to check for solved sudoku solution for the provided inputs.
You can perform a maven build to create a JAR which helps you to run the driver program which is SudokuSolver.java. A maven wrapper is also included in the project
if there is no maven installed in the machine. Run this first and then run the below.

Here are the maven commands and java -jar command to run the sudoku solver.

	a. Run: mvn install
		to install required dependencies.

	b. Run: mvn compile
		to compile and make sure the project builds fine

	c. Run: mvn test
		to run the unit tests in the project.

	d. Run: mvn clean package
		to create a JAR for the application. The JAR gets created inside the /target directory

	e. Finally, navigate to the target directory and run the JAR using:
		java -jar sudoku-1.0-SNAPSHOT.jar
	
If there are any issues with running the application, please reach out to me at vishal266@gmail.com

3. If the above does not work, just unzip the target file attached and navigate to the target folder and run the following command:
	java -jar sudoku-1.0-SNAPSHOT.jar
	
	The above command should definitely work provided it is inside target folder containing all the decompiled classes, lib folder, maven surefire test reports, etc.
	

Readme prepared by Vishal Gautham Venkataraaman - vishal266@gmail.com	