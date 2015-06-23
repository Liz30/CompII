package treenodes.expresion;

import codegeneration.ExpresionCode;
import codegeneration.LabelGenerator;

import java.awt.*;

/**
 * Created by mac on 5/28/15.
 */
public class IndexAccesor extends Accesor {

    ExpresionNode index;

    public IndexAccesor(ExpresionNode index) {
        this.index = index;
    }

    public ExpresionNode getIndex() {
        return index;
    }

    public void setIndex(ExpresionNode index) {
        this.index = index;
    }

    @Override
    public ExpresionCode generateCode() {
        ExpresionCode indexCode = index.generateCode();
        String result = LabelGenerator.getInstance().GenerateLabel("t");
        String code = indexCode.getCode()+
                      result+":="+indexCode.getResult()+"*4\n";
        return  new ExpresionCode(code,result);
    }
}
