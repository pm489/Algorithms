package underware;


public class MyName extends Name {

    private MyName(String firstName, String surname){
        super(firstName, surname);
    }

    public static MyName myName(String firstName, String surnameName) {
         return new MyName(firstName, surnameName);
    }
}
