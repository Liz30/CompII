package treenodes.statement;

import codegeneration.ExpresionCode;
import treenodes.expresion.ExpresionNode;
import treenodes.expresion.NumberNode;


public class SetColorNode extends StatementNode {

     ExpresionNode value;
     
    public ExpresionNode getValue() {
        return value;
    }

    public void setValue(ExpresionNode value) {
        this.value = value;
    }

    public SetColorNode(ExpresionNode value) {
        this.value = value;
    }

   
    @Override
    public String generateCode() {        
        ExpresionCode code = value.generateCode();
        return   "\n;Set_Color ("+code.getResult()+")\n"+
                 "       push "+code.getResult()+"\n"+
                 "       push [handle] \n"+
                 "       call [setcolor]\n"+
                 "       add esp,4\n";
    }
}
