Tree Builder App

This program prints a tree structure with indentation and line separators from a list of child-parent pairs stored in a text file

App source code is in src/main/java/com/mycompany/app

JUnit test code is in src/test/java/com/mycompany/app/AppTest.java

How to run:
1) Clone the repository
2) Change directory to tree_builder
3) Build the project: mvn package
4) Run the program: mvn exec:java -Dexec.args="input.txt"
5) See the output in the console
6) Run JUnit tests with: mvn clean test


Note: If you want your own input text file you can put it in src/main/resources/ and run the program with file name as an argument
or you can just edit the existing src/main/resources/input.txt file

Note: Use mvn compile to compile the code after code change
