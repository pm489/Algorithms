package underware;


public class MyName {
    public final String myName;

    private MyName(String name){
        this.myName = name;
    }

    public static MyName myName(String name){
        return new MyName(name);
    }

}
