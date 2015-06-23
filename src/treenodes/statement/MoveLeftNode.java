package treenodes.statement;

import codegeneration.ExpresionCode;
import treenodes.expresion.ExpresionNode;
import treenodes.expresion.NumberNode;


public class MoveLeftNode extends StatementNode {

    public MoveLeftNode() {
    }
    
    @Override
    public String generateCode() {        
        return  "Move_Left () push \n"//"+valueCode.getResult()+"\n"
                +"push digitMsgln\n"
                +"call [printf]\n"
                +"add esp,8\n";
    }
}
