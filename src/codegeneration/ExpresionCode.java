package codegeneration;

/**
 * Created by mac on 5/27/15.
 */
public class ExpresionCode {
    String code;
    String result;

    public ExpresionCode(String code, String result) {
        this.code = code;
        this.result = result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
