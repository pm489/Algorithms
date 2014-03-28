package underware;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static underware.ChoiceName.SINGLE;

public class Person implements PersonInterface {


    public final MyName myName;
    private Name currentPartner = SINGLE;
    public ArrayList<ChoiceName> orderedChoices;
    public ArrayList<ChoiceName> engagedChoices;


    public Person(MyName myName, ChoiceName... orderedChoices) {
        this.myName = myName;
        this.engagedChoices=newArrayList();
        this.orderedChoices = newArrayList(Arrays.asList(orderedChoices));
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Person)) return false;
        return myName.equals(((Person) obj).myName);
    }

    @Override
    public MyName whoAmI() {
        return this.myName;
    }

    @Override
    public ChoiceName topChoice() {
        if(orderedChoices.isEmpty()){
            return SINGLE;
        }
        return orderedChoices.get(0);
    }

    @Override
    public Name currentPartner() {
        return currentPartner;
    }

    @Override
    public void newCurrentPartner(Name freeMan) {
        this.currentPartner= freeMan;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean preferenceIsHigherFor(Name freeMan) {
        if(!orderedChoices.contains(freeMan)){
           return false;
        }
        return orderedChoices.indexOf(freeMan)< orderedChoices.indexOf(currentPartner) || currentPartner.equals(SINGLE);

    }

    @Override
    public void pickNewTopChoice() {
        if(orderedChoices.isEmpty()){
            orderedChoices= new ArrayList<ChoiceName>();
            orderedChoices.add(SINGLE);
        }
        ChoiceName remove = orderedChoices.remove(0);
        engagedChoices.add(remove);
    }
}
