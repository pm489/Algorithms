package underware;


public class ChoiceName {

    public static final ChoiceName SINGLE = choice("single",null);
    public final String firstName;
    public final String surnameName;


    private ChoiceName(String firstName, String surnameName) {
        this.firstName = firstName;
        this.surnameName = surnameName;
    }

    public static ChoiceName choice(String firstName, String surname){
        return new ChoiceName(firstName, surname);
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof ChoiceName){
            ChoiceName that = (ChoiceName) o;
            return o==this || (this.firstName.equals(that.firstName) && this.surnameName.equals(that.surnameName));
        }
        return false;
    }
}
