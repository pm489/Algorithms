package underware;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

import java.util.List;
import java.util.Map;

import static com.google.common.collect.Iterables.find;
import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newHashMap;
import static underware.ChoiceName.SINGLE;

public class StableMarriageMatcher {


    public static Map<PersonInterface, PersonInterface> match(final List<PersonInterface> men, final List<PersonInterface> allWoman) {
        List<PersonInterface> freeMen = men;
        Map<PersonInterface, PersonInterface> engaged = newHashMap();
        List<PersonInterface> noMatches = newArrayList();

        while (!freeMen.isEmpty()) {

            final PersonInterface manToMatch = freeMen.get(0);
            final Name topChoiceWomanName = manToMatch.topChoice();
            if (topChoiceWomanName.equals(SINGLE)) {
                noMatches.add(manToMatch);
                freeMen.remove(0);
            } else {
                PersonInterface topChoiceWoman = nameToWoman(allWoman, topChoiceWomanName);
                if (!engaged.containsKey(topChoiceWoman)) {
                    engaged.put(topChoiceWoman, manToMatch);
                    topChoiceWoman.newCurrentPartner(manToMatch.whoAmI());
                    freeMen.remove(0);
                } else if (engaged.containsKey(topChoiceWoman) && topChoiceWoman.preferenceIsHigherFor(manToMatch.whoAmI())) {
                    topChoiceWoman.newCurrentPartner(manToMatch.whoAmI());
                    PersonInterface oldGuy = engaged.get(topChoiceWoman);
                    freeMen.add(oldGuy);
                    oldGuy.pickNewTopChoice();
                    engaged.put(topChoiceWoman, manToMatch);
                    freeMen.remove(manToMatch);
                }else{
                    manToMatch.pickNewTopChoice();
                }
            }
        }

        return engaged;
    }

    private static PersonInterface nameToWoman(List<PersonInterface> allWoman, final Name topChoiceWomanName) {
        return find(allWoman, new Predicate<PersonInterface>() {
            @Override
            public boolean apply(PersonInterface personInterface) {
                return personInterface.whoAmI().equals(topChoiceWomanName);
            }
        });
    }

}
