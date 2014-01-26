

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class StableMarriageMatcherTest {
    @Test
    public void canCreateStableMarriages() throws Exception {
        Set<PersonInterface> men = new HashSet<PersonInterface>();
        Set<PersonInterface> women = new HashSet<PersonInterface>();

        Set<PersonInterface> expected = new HashSet<PersonInterface>();

        assertThat(StableMarriageMatcher.match(men, women), equalTo(expected));
    }
}
