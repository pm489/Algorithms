package underware;


public class ChoiceName extends Name{

    public static final ChoiceName SINGLE = choice("single","single");

    private ChoiceName(String firstName, String surnameName) {
       super(firstName, surnameName);
    }

    public static ChoiceName choice(String firstName, String surname){
        return new ChoiceName(firstName, surname);
    }

}
