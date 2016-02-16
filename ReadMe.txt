
 Autor:YuWei Zhang (Wayne)
      

1. workspace(folder): Eclipse workspace.Contains all .java files, EclipseLinke file 
		       and mapping xml file.
2. test.ddl :MySQL DDL script used for set up database schema.
3. a4.jar :java execution file.

How to set up database (Windows): 1. Open cmd.exe
				    2. Type command: mysql -uroot -p < test.ddl
				    3. Enter password of your local mysql
		                   4. Done!

How to run run application:   1. Open Eclipse EE.
			        2.File->Switch Workplace->other. Change workplace to 				   where you place workspace foler.
			       	3. You can run UserInterface.java inside eclipse or 					   Export UserInterface.java file to a runnable .jar 				   file, and run exported jar file using cmd.

P.S: This database using textual user interface, which provides detailed instruction of executing each required functions.
