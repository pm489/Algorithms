package underware;


public interface PersonInterface {
    public MyName whoAmI();

    public Name topChoice();

    public Name currentPartner();

    public void newCurrentPartner(Name freeMan);

    public boolean preferenceIsHigherFor(Name freeMan);

    void pickNewTopChoice();
}
