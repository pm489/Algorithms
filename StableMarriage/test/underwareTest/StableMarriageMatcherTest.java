package underwareTest;

import org.junit.Test;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import underware.*;

import static com.google.common.collect.Maps.newHashMap;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static underware.ChoiceName.choice;
import static underware.MyName.myName;
import static underware.StableMarriageMatcher.match;

public class StableMarriageMatcherTest {
    @Test
    public void canCreateStableMarriages() throws Exception {
        List<PersonInterface> men = new ArrayList<>();
        List<PersonInterface> women = new ArrayList<>();

        Person phil = new Person(myName("Phil", "M"), choice("Kay", "B"), choice("Sue", "P"));
        Person pete = new Person(myName("Pete", "N"), choice("Sue", "P"), choice("Kay", "B"));

        men.add(phil);
        men.add(pete);

        Person sue = new Person(myName("Sue", "P"), choice("Pete", "N"), choice("Phil", "M"));
        Person kay = new Person(myName("Kay", "B"), choice("Phil", "M"), choice("Pete", "N"));

        women.add(sue);
        women.add(kay);

        Map<PersonInterface, PersonInterface> expected = newHashMap();
        expected.put(kay,phil);
        expected.put(sue,pete);

        assertThat(match(men, women), equalTo(expected));
    }

    @Test
    public void canCreateStableMatchesWhenPreferencesAreNotAligned() throws Exception {
        List<PersonInterface> men = new ArrayList<>();
        List<PersonInterface> women = new ArrayList<>();

        Person phil = new Person(myName("Phil", "M"), choice("Kay", "B"), choice("Sue", "P"),choice("Jane","G"));
        Person pete = new Person(myName("Pete", "N"), choice("Kay", "B"), choice("Sue", "P"),choice("Jane","G"));
        Person tom = new Person(myName("Tom", "B"), choice("Kay", "B"), choice("Sue", "P"),choice("Jane","G"));

        men.add(phil);
        men.add(pete);
        men.add(tom);

        Person sue = new Person(myName("Sue", "P"), choice("Pete", "N"), choice("Phil", "M"),choice("Tom","B"));
        Person kay = new Person(myName("Kay", "B"), choice("Phil", "M"), choice("Pete", "N"),choice("Tom","B"));
        Person jane = new Person(myName("Jane", "G"), choice("Phil", "M"), choice("Pete", "N"),choice("Tom","B"));

        women.add(sue);
        women.add(kay);
        women.add(jane);

        Map<PersonInterface, PersonInterface> expected = newHashMap();
        expected.put(kay,phil);
        expected.put(sue,pete);
        expected.put(jane,tom);

        assertThat(match(men, women), equalTo(expected));
    }

    @Test
    public void unevenGroupsMoreMenThanWomen(){
        
    }



}
