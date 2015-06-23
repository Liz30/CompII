package treenodes.expresion;

import codegeneration.ExpresionCode;
import codegeneration.LabelGenerator;

/**
 * Created by mac on 5/7/15.
 */
public    class DivideOperatorNode extends BinaryOperatorNode {

    public DivideOperatorNode(ExpresionNode leftOperand, ExpresionNode rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public ExpresionCode generateCode() {
        ExpresionCode leftCode = leftOperand.generateCode();
        ExpresionCode rightCode = rightOperand.generateCode();
        String result = LabelGenerator.getInstance().GenerateLabel("t");
        String code =  leftCode.getCode()+
                rightCode.getCode()+
                result +":="+leftCode.getResult()+"/"+rightCode.getResult()+"\n" ;
        return new ExpresionCode(code,result);
    }
}
