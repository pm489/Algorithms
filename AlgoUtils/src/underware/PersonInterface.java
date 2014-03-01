package underware;


public interface PersonInterface {
    public ChoiceName topChoice();

    public ChoiceName currentPartner();

    public void newCurrentPartner(ChoiceName freeMan);

    public boolean preferenceIsHigherFor(ChoiceName freeMan);

    void pickNewTopChoice();
}
