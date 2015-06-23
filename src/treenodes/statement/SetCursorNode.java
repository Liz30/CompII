package treenodes.statement;

import codegeneration.ExpresionCode;
import codegeneration.ASMGenerator;
import treenodes.expresion.ExpresionNode;
import treenodes.expresion.NumberNode;


public class SetCursorNode extends StatementNode {

    ExpresionNode xvalue;
    ExpresionNode yvalue;
    
    public ExpresionNode getXvalue() {
        return xvalue;
    }

    public void setXvalue(NumberNode xvalue) {
        this.xvalue = xvalue;
    }

    public ExpresionNode getYvalue() {
        return yvalue;
    }

    public void setYvalue(NumberNode yvalue) {
        this.yvalue = yvalue;
    }

    public SetCursorNode(ExpresionNode xvalue, ExpresionNode yvalue) {
        this.xvalue = xvalue;
        this.yvalue = yvalue;
    }  

   
    @Override
    public String generateCode() {                
        ExpresionCode x = xvalue.generateCode();
        ExpresionCode y = yvalue.generateCode();
        //ASMGenerator asm=new ASMGenerator();
        return  "\n;Set_Cursor("+x.getResult()+","+y.getResult()+")\n"+
                "       push word "+y.getResult()+"\n"+
                "       push word "+x.getResult()+"\n"+
                "       push [handle] \n"+
                "       call [gotoxy] \n"+
                "       add esp, 8 \n";                
    }
}
