Tree Builder App

This program prints a tree structure with indentation and line separators from a list of child-parent pairs stored in a text file

App source code is in src/main/java/com/mycompany/app

JUnit test code is in src/test/java/com/mycompany/app/AppTest.java

How to run:
1) Clone the repository
2) Change directory to tree_builder
3) Build the project: mvn package
4) Run the program: <br />
    a) mvn exec:java -Dexec.args="input.txt" <br />
    Expected output: <br />
    &nbsp;&nbsp;&nbsp;&nbsp;Ivan <br />
            Adam <br />
                Stjepan <br />
                    Marko <br />
                    Robert <br />
            Fran <br />
        Luka <br />
            Leopold <br /> <br />

    b) mvn exec:java -Dexec.args="childHasMoreThanOneParent.txt" <br />
    Expected output: <br />
        Pero <br /> 
            Ivan <br /> 
        Luka <br />
            Ivan <br /> <br />

    c) mvn exec:java -Dexec.args="cyclicInput.txt" <br />
    Expected output: <br />
        Cyclic relationship not allowed! <br />
        Program terminated <br /> <br />


Note: Run JUnit tests with: mvn clean test 

Note: If you want your own input text file you can put it in src/main/resources/ and run the program with file name as an argument
or you can just edit the existing src/main/resources/input.txt file

Note: Use mvn compile to compile the code after code change

Note: This is app is tested with Java 1.8 and 1.10 on Windows 10. It should also work on
any Unix based system.
