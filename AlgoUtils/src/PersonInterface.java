


public interface PersonInterface {
    public PersonInterface topChoice();

    public PersonInterface currentPartner();

    public PersonInterface newCurrentPartner(PersonInterface freeMan);

    public boolean preferenceIsHigherFor(PersonInterface freeMan);

    void pickNewTopChoice();
}
