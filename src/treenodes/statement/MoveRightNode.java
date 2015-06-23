package treenodes.statement;

import codegeneration.ExpresionCode;
import treenodes.expresion.ExpresionNode;
import treenodes.expresion.NumberNode;


public class MoveRightNode extends StatementNode {

    public MoveRightNode() {
    }
    
    @Override
    public String generateCode() {        
        return  "Move_Right () push \n"//"+valueCode.getResult()+"\n"
                +"push digitMsgln\n"
                +"call [printf]\n"
                +"add esp,8\n";
    }
}
