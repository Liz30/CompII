package treenodes.statement;

import codegeneration.ExpresionCode;
import codegeneration.LabelGenerator;
import treenodes.expresion.ExpresionNode;
import treenodes.expresion.IdNode;
import treenodes.statement.StatementNode;

import java.util.List;

/**
 * Created by mac on 5/7/15.
 */
public class ForNode extends StatementNode {
    IdNode iteratorVariable;
    ExpresionNode initialValue;
    ExpresionNode finalValue;
    List<StatementNode> code;

    public ForNode(IdNode iteratorVariable, ExpresionNode initialValue, ExpresionNode finalValue, List<StatementNode> code) {
        this.iteratorVariable = iteratorVariable;
        this.initialValue = initialValue;
        this.finalValue = finalValue;
        this.code = code;
    }

    public IdNode getIteratorVariable() {
        return iteratorVariable;
    }

    public void setIteratorVariable(IdNode iteratorVariable) {
        this.iteratorVariable = iteratorVariable;
    }

    public ExpresionNode getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(ExpresionNode initialValue) {
        this.initialValue = initialValue;
    }

    public ExpresionNode getFinalValue() {
        return finalValue;
    }

    public void setFinalValue(ExpresionNode finalValue) {
        this.finalValue = finalValue;
    }

    public List<StatementNode> getCode() {
        return code;
    }

    public void setCode(List<StatementNode> code) {
        this.code = code;
    }

    @Override
    public String generateCode() {
        String beginFor = LabelGenerator.getInstance().GenerateLabel("for");
        String endFor = LabelGenerator.getInstance().GenerateLabel("endfor");
        String incResult = LabelGenerator.getInstance().GenerateLabel("t");

        ExpresionCode iteratorCode = iteratorVariable.generateCode();
        ExpresionCode iteratorForAssignCode = iteratorVariable.generateCodeForAssign();
        ExpresionCode initialCode = initialValue.generateCode();
        ExpresionCode finalCode = finalValue.generateCode();

        String bodyCode ="";
        for(StatementNode stmnt:code)
           bodyCode += stmnt.generateCode();
        
        return
                "\n       "+initialCode.getCode()+ iteratorForAssignCode.getCode()+
                iteratorForAssignCode.getResult()+":="+initialCode.getResult()+"\n"+
                beginFor+":\n"+
                finalCode.getCode()+
                iteratorCode.getCode()+
                "       if "+iteratorCode.getResult()+">"+finalCode.getResult()+" then goto "+endFor+"\n"
                +bodyCode+
                        "\n       "+incResult+":="+iteratorCode.getResult()+"+1\n"+
                "       "+iteratorForAssignCode.getCode()+
                iteratorForAssignCode.getResult()+":="+incResult+"\n"+
                "       goto "+beginFor+"\n"+
                endFor+":\n";

    }
}
