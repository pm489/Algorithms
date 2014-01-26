

import java.util.List;

public class Person implements PersonInterface {


    private String myName;
    private Person currentPartner=null;
    private List<Person> orderedPreferences;

    public Person(String myName, List<Person> orderedPreferences) {
        this.myName = myName;
        this.orderedPreferences = orderedPreferences;
    }


    @Override
    public Person topChoice() {
       return orderedPreferences.isEmpty()? null : orderedPreferences.get(0);
    }

    @Override
    public Person currentPartner() {
        return currentPartner;
    }

    @Override
    public Person newCurrentPartner(PersonInterface freeMan) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean preferenceIsHigherFor(PersonInterface freeMan) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void pickNewTopChoice() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
