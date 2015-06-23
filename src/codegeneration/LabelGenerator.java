package codegeneration;

import java.util.Hashtable;

/**
 * Created by mac on 5/27/15.
 */
public class LabelGenerator {

    private static LabelGenerator instance=null;

    private LabelGenerator()
    {

    }

    public static LabelGenerator getInstance()
    {
        if(instance==null)
            instance = new LabelGenerator();
        return instance;
    }


    private Hashtable<String,Integer> labels = new Hashtable<String, Integer>();


    public  String GenerateLabel(String label) {

        if(!labels.containsKey(label))
            labels.put(label,0);

        int count = labels.get(label)+1;
        labels.put(label,count);

        return label+count;

    }
}
