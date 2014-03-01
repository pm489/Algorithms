package underware;


public class ChoiceName {

    public static final ChoiceName SINGLE = choice("single");
    public final String name;


    private ChoiceName(String name) {
        this.name = name;
    }

    public static ChoiceName choice(String name){
        return new ChoiceName(name);
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof ChoiceName){
            ChoiceName that = (ChoiceName) o;
            return o==this || this.name.equals(that.name);
        }
        return false;
    }
}
