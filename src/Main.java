import codegeneration.ExpresionCode;
import treenodes.statement.AssignmentNode;
import treenodes.statement.StatementNode;
import codegeneration.ASMGenerator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Hashtable;

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

      System.out.print(code);
      //System.out.print(asm_gen.generator(code));
      
      /*Hashtable<String, Integer> t = new Hashtable<String, Integer>();
      t.put("x", 10);
      t.put("y", 2);
      
      System.out.print(t.get("x"));*/
      
    } catch (Exception e) {
      /* do cleanup here -- possibly rethrow e */
      e.printStackTrace();
    }
  }
}


