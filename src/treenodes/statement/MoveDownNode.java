package treenodes.statement;

import codegeneration.ExpresionCode;
import treenodes.expresion.ExpresionNode;
import treenodes.expresion.NumberNode;


public class MoveDownNode extends StatementNode {

    ExpresionNode fila;
    ExpresionNode columna;
    
    public MoveDownNode(ExpresionNode fila, ExpresionNode columna) {
        this.fila = fila;
        this.columna = columna;
    }

    @Override
    public String generateCode() { 
        ExpresionCode f=fila.generateCode();
        ExpresionCode c=columna.generateCode();
        
        
        return  "\n;MoveDown\n"+
                "       push word "+c.getResult()+"\n"+
                "       push word "+f.getResult()+"\n"+
                "       push [handle] \n"+
                "       call [gotoxy] \n"+
                "       add esp, 8 \n";  
    }
}
