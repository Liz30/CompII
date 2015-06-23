package treenodes.expresion;

import codegeneration.ExpresionCode;
import codegeneration.LabelGenerator;

/**
 * Created by mac on 5/7/15.
 */
public    class SumOperatorNode extends BinaryOperatorNode {

    public SumOperatorNode(ExpresionNode leftOperand, ExpresionNode rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public ExpresionCode generateCode() {
        ExpresionCode leftCode = leftOperand.generateCode();
        ExpresionCode rightCode = rightOperand.generateCode();
        //TODO: hacer un metodo generar variable
        String result = LabelGenerator.getInstance().GenerateLabel("t");
        String code =  leftCode.getCode()+
                       rightCode.getCode()+
                       "mov eax,"+leftCode.getResult()+"\n"+
                       "add eax," +rightCode.getResult()+"\n"+
                       "mov ["+result+"],eax\n";
        return new ExpresionCode(code,"["+result+"]");
    }
}
