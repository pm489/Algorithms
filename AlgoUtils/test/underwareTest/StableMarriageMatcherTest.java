package underwareTest;

import org.junit.Test;
import underware.PersonInterface;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static underware.StableMarriageMatcher.match;

public class StableMarriageMatcherTest {
    @Test
    public void canCreateStableMarriages() throws Exception {
        Set<PersonInterface> men = new HashSet<PersonInterface>();
        Set<PersonInterface> women = new HashSet<PersonInterface>();

        Set<PersonInterface> expected = new HashSet<PersonInterface>();

        assertThat(match(men, women), equalTo(expected));
    }
}
