/*
  This example comes from a short article series in the Linux 
  Gazette by Richard A. Sevenich and Christopher Lopes, titled
  "Compiler Construction Tools". The article series starts at

  http://www.linuxgazette.com/issue39/sevenich.html

  Small changes and updates to newest JFlex+Cup versions 
  by Gerwin Klein
*/

/*
  Commented By: Christopher Lopes
  File Name: Main.java
  To Create: 
  After the scanner, lcalc.flex, and the parser, ycalc.cup, have been created.
  > javac Main.java
  
  To Run: 
  > java Main test.txt
  where test.txt is an test input file for the calculator.
*/
   
import codegeneration.ExpresionCode;
import treenodes.statement.AssignmentNode;
import treenodes.statement.StatementNode;
import codegeneration.ASMGenerator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    
  static public void main(String argv[]) {    
    /* Start the parser */

    try {

      
      parser p = new parser(new Lexer(new FileReader("src/test.txt")));
      List<StatementNode> result =(List<StatementNode>) p.parse().value;
      String code ="";
      ASMGenerator asm_gen=new ASMGenerator();
      for(StatementNode stmnt:result)
      {
         code+=stmnt.generateCode();
         
      }

      //System.out.print(code);
      System.out.print(asm_gen.generator(code));
      
    } catch (Exception e) {
      /* do cleanup here -- possibly rethrow e */
      e.printStackTrace();
    }
  }
}


