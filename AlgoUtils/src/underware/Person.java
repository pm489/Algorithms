package underware;

import java.util.Arrays;
import java.util.List;

import static underware.ChoiceName.SINGLE;

public class Person implements PersonInterface {


    public final MyName myName;
    private ChoiceName currentPartner = SINGLE;
    private List<ChoiceName> orderedChoices;


    public Person(MyName myName, ChoiceName... orderedChoices) {
        this.myName = myName;
        this.orderedChoices = Arrays.asList(orderedChoices);
    }


    @Override
    public ChoiceName topChoice() {
        return orderedChoices.get(0);
    }

    @Override
    public ChoiceName currentPartner() {
        return currentPartner;
    }

    @Override
    public void newCurrentPartner(ChoiceName freeMan) {
        this.currentPartner=freeMan;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean preferenceIsHigherFor(ChoiceName freeMan) {
        if(!orderedChoices.contains(freeMan)){
           return false;
        }
        return orderedChoices.indexOf(freeMan)< orderedChoices.indexOf(currentPartner) || currentPartner.equals(SINGLE);

    }

    @Override
    public void pickNewTopChoice() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
