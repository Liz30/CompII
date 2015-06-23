package treenodes.expresion;

import codegeneration.ExpresionCode;
import codegeneration.LabelGenerator;

/**
 * Created by mac on 5/7/15.
 */
public  class IdNode extends ExpresionNode {
      String name;
      Accesor accesor;

    public IdNode(String name, Accesor accesor) {
        this.name = name;
        this.accesor = accesor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Accesor getAccesor() {
        return accesor;
    }

    public void setAccesor(Accesor accesor) {
        this.accesor = accesor;
    }

    @Override
    public ExpresionCode generateCode() {
        String code = "";
        String result = "["+ name+"]";


        return new ExpresionCode(code,result) ;
    }

    public ExpresionCode generateCodeForAssign() {
        String code = "";
        String result = "["+name+"]";


        return new ExpresionCode(code,result) ;
    }
}
