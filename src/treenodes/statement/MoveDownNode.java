package treenodes.statement;

import codegeneration.ExpresionCode;
import treenodes.expresion.ExpresionNode;
import treenodes.expresion.NumberNode;


public class MoveDownNode extends StatementNode {

    Integer fila;
    Integer columna;
    
    public MoveDownNode(Integer fila, Integer columna) {
        this.fila = fila;
        this.columna = columna;
    }

    @Override
    public String generateCode() { 
        //obtener las posiciones actuales del cursor
        //x+=1;
        //codigo de set_cursor
        ExpresionCode f=new NumberNode(fila).generateCode();
        ExpresionCode c=new NumberNode(columna).generateCode();
        
        return  "\n;MoveDown\n"+
                "       push word "+c.getResult()+"\n"+
                "       push word "+f.getResult()+"\n"+
                "       push [handle] \n"+
                "       call [gotoxy] \n"+
                "       add esp, 8 \n";  
    }
}
