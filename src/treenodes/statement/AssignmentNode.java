package treenodes.statement;

import codegeneration.ExpresionCode;
import codegeneration.LabelGenerator;
import java.util.List;
import treenodes.expresion.ExpresionNode;
import treenodes.expresion.IdNode;
import codegeneration.ASMGenerator;

/**
 * Created by mac on 5/7/15.
 */
public class AssignmentNode extends StatementNode {
    ExpresionNode value;
    IdNode id;

    public AssignmentNode(IdNode id,ExpresionNode value) {
        this.value = value;
        this.id = id;
    }

    public ExpresionNode getValue() {
        return value;
    }

    public void setValue(ExpresionNode value) {
        this.value = value;
    }

    public IdNode getId() {
        return id;
    }

    public void setId(IdNode id) {
        this.id = id;
    }
    
    
    @Override
    public String generateCode() {
        ExpresionCode valueCode = value.generateCode();
        ExpresionCode idCode = id.generateCodeForAssign();
        String result = LabelGenerator.getInstance().GenerateLabel("t");     
        
        
        return  valueCode.getCode() +
                idCode.getCode() +
                idCode.getResult() + ":="+valueCode.getResult()+"\n";

    }
}
