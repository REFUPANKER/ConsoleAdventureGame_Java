package Managers;

public class ShortOutputCommands {
    /**
    *   cwl : Console WriteLine
    */
    public static void cwl(Object msg){
        System.out.println(msg);
    }

    /**
    *   cw : Console Write
    */
    public static void cw(Object msg){
        System.out.print(msg);
    }
    /**
    * Console Clear with = \033[H\033[2J
    */
    public static void clear(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
