package underwareTest;

import junit.framework.TestCase;
import org.junit.Test;
import underware.ChoiceName;
import underware.MyName;
import underware.Person;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static underware.ChoiceName.choice;
import static underware.MyName.myName;


public class PersonTest {

    private Person bob = new Person(myName("Phil"), choice("Karen"), choice("Charlie"), choice("Sue"));

    @Test
    public void getTopChoice() throws Exception {
        assertThat(bob.topChoice().name,equalTo("Karen"));

    }

    @Test
    public void currentPartnerWhenNoneSpecified() throws Exception {
         assertThat(bob.currentPartner(), equalTo(ChoiceName.SINGLE));
    }

    @Test
    public void currentPartnerWhenOneHasBeenSet() throws Exception {
        bob.newCurrentPartner(choice("Sally")); 
        assertThat(bob.currentPartner().name, equalTo("Sally"));
    }


    @Test
    public void currentPartnerIsNotUpdatedIfNewChoiceIsLowerPreferenceThanCurrent(){
        bob.newCurrentPartner(choice("Karen"));

        assertFalse(bob.preferenceIsHigherFor(choice("Sue")));
    }



    @Test
    public void currentPartnerIsUpdatedWhenNewMatchIsHigherPreferenceThanCurrentMatch() throws Exception {
        bob.newCurrentPartner(choice("Sue"));
        assertTrue(bob.preferenceIsHigherFor(choice("Karen")));
    }

    @Test
    public void currentPartnerIsUpdatedWhenNewMatchIsHigherPreferenceThanSingleness() throws Exception {
      assertTrue(bob.preferenceIsHigherFor(choice("Sue")));
    }

    @Test
    public void testPickNewTopChoice() throws Exception {

    }
}
