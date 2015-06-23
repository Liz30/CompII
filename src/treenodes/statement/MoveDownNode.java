package treenodes.statement;

import codegeneration.ExpresionCode;
import treenodes.expresion.ExpresionNode;
import treenodes.expresion.NumberNode;


public class MoveDownNode extends StatementNode {

    public MoveDownNode() {

    }    
    
    @Override
    public String generateCode() { 
        //obtener las posiciones actuales del cursor
        //x+=1;
        //codigo de set_cursor
        return  "\n;MoveDown\n"+
                "       push word \n"+
                "       push word \n"+
                "       push [handle] \n"+
                "       call [gotoxy] \n"+
                "       add esp, 8 \n";  
    }
}
