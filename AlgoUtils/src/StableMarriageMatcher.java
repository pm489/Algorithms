

import java.util.HashSet;
import java.util.Set;

public class StableMarriageMatcher {


    public static Set<PersonInterface> match(Set<PersonInterface> men, Set<PersonInterface> woman) {
        Set<PersonInterface> freeMen = men;
        Set<PersonInterface> freeWoman = woman;

        Set<PersonInterface> matched = new HashSet<PersonInterface>();

        while (!freeMen.isEmpty()) {

            for (PersonInterface freeMan : freeMen) {

                final PersonInterface topChoiceWoman = freeMan.topChoice();

                if (topChoiceWoman == null) {
                    freeMen.remove(freeMan);
                }

                if (freeWoman.contains(topChoiceWoman)) {
                    matched.add(topChoiceWoman.newCurrentPartner(freeMan));
                    freeWoman.remove(topChoiceWoman);
                    freeMen.remove(freeMan);
                } else if (matched.contains(topChoiceWoman)) {
                    if (topChoiceWoman.preferenceIsHigherFor(freeMan)) {
                        freeMen.add(topChoiceWoman.currentPartner());
                        topChoiceWoman.newCurrentPartner(freeMan);
                    } else {
                        freeMan.pickNewTopChoice();
                    }
                }

            }

        }
        return matched;
    }


}
