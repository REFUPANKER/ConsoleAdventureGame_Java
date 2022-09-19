package Managers;

public class LineStringCreaters {
    public String CreateLine(int Length,String lineChar,boolean writeLine){
        String result="";
        for (int i = 0; i < Length; i++) {
            result+=lineChar;
        }
        if(writeLine){
            System.out.println(result);
        }
        return result;
    }
}
