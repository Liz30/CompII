package treenodes.statement;

import codegeneration.ExpresionCode;
import treenodes.expresion.ExpresionNode;
import treenodes.expresion.NumberNode;


public class MoveUpNode extends StatementNode {

    public MoveUpNode() {
    }
    
    @Override
    public String generateCode() { 
        //obtener las posiciones actuales del cursor
        //x-=1;
        //codigo de set_cursor
        return  "\n;MoveUp\n"+
                "       push word \n"+
                "       push word \n"+
                "       push [handle] \n"+
                "       call [gotoxy] \n"+
                "       add esp, 8 \n"; 
    }
}
