package underware;

public abstract class Name {
    public final String firstName;
    public final String surnameName;

    protected Name(String name, String surnameName) {
        this.firstName = name;
        this.surnameName = surnameName;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Name)) return false;
        return this.firstName.equals(((Name) obj).firstName) && this.surnameName.equals(((Name) obj).surnameName);
    }

}