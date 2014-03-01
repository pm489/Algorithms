package underwareTest;

import org.junit.Test;
import underware.ChoiceName;
import underware.Person;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static underware.ChoiceName.choice;
import static underware.MyName.myName;


public class PersonTest {

    private Person bob = new Person(myName("Phil"), choice("Karen","M"), choice("Charlie","A"), choice("Sue","C"));

    @Test
    public void getTopChoice() throws Exception {
        assertThat(bob.topChoice().firstName,equalTo("Karen"));

    }

    @Test
    public void currentPartnerWhenNoneSpecified() throws Exception {
         assertThat(bob.currentPartner(), equalTo(ChoiceName.SINGLE));
    }

    @Test
    public void currentPartnerWhenOneHasBeenSet() throws Exception {
        bob.newCurrentPartner(choice("Sally","C"));
        assertThat(bob.currentPartner().firstName, equalTo("Sally"));
        assertThat(bob.currentPartner().surnameName, equalTo("C"));
    }


    @Test
    public void currentPartnerIsNotUpdatedIfNewChoiceIsLowerPreferenceThanCurrent(){
        bob.newCurrentPartner(choice("Karen","M"));

        assertFalse(bob.preferenceIsHigherFor(choice("Sue","C")));
    }



    @Test
    public void currentPartnerIsUpdatedWhenNewMatchIsHigherPreferenceThanCurrentMatch() throws Exception {
        bob.newCurrentPartner(choice("Sue","C"));
        assertTrue(bob.preferenceIsHigherFor(choice("Karen","M")));
    }

    @Test
    public void currentPartnerIsUpdatedWhenNewMatchIsHigherPreferenceThanSingleness() throws Exception {
      assertTrue(bob.preferenceIsHigherFor(choice("Sue","C")));
    }

    @Test
    public void testPickNewTopChoice() throws Exception {

    }
}
