
 Autor:YuWei Zhang (Wayne)
      
Files:
1. workspace(folder): Eclipse workspace.Contains all .java files, EclipseLinke file and xml mapping file.
2. test.ddl :MySQL DDL script used for set up database schema.
3. a4.jar :java execution file.

How to set up Employee database (Windows only): 
1. Open cmd.exe
2. Type command: mysql -uroot -p < test.ddl (Make sure test.ddl is under current working directory)
3. Enter password of your local MySQL
4. Done!

How to run application:   
1. Open Eclipse EE.
2.File->Switch Workplace->other. Change workplace to where you place workspace foler.
3. You can run UserInterface.java inside eclipse or Export UserInterface.java file to a runnable .jar file, and run exported jar file using cmd.

P.S: This database using textual user interface, which provides detailed instruction of executing each required functions. GUI is under development
