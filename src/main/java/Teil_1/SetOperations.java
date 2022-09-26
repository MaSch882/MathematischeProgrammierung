package Teil_1;

import java.util.*;

public class SetOperations
{
    /**
     * Berechnet die Schnittmenge zweier Mengen desselben generischen Typs <code>T</code>.
     * Ist einer der Parameter <code>null</code>, so interpretiert die Methode dies als leere Menge und gibt
     * folglich eine leere Menge zurueck. Insbesondere ist der Schnitt zweier <code>null</code>-Instanzen
     * wieder die leere Menge.
     *
     * @param setA Die erste Menge.
     * @param setB Die zweite Menge.
     * @param <T> Der generische Typparameter.
     * @return Die Schnittmenge beider Mengen.
     */
    public <T> Set<T> calculateIntersectionOfTwoSets(Set<T> setA, Set<T> setB)
    {
        if(setA == null || setB == null)
        {
            return new HashSet<>();
        }
        setA.retainAll(setB);
        return setA;
    }

    /**
     * Berechnet die Schnittmenge von <code>n</code> Mengen desselben generischen Typs, die in einer Liste
     * uebergeben werden. Ist einer der Listeneintraege <code>null</code>, so interpretiert die Methode dies
     * als leere Menge und gibt folglich die leere Menge aus. Insbesondere ist der Schnitt beliebig vieler
     * <code>null</code>-Instanzen wieder die leere Menge.
     *
     * @param listOfSets Die Liste der <code>n</code> Mengen.
     * @param <T> Der generische Typparameter.
     * @return Die Schnittmenge der <code>n</code> Mengen.
     */
    public <T> Set<T> calculateIntersectionOfListOfSets(List<Set<T>> listOfSets)
    {
        Set<T> intersection = listOfSets.get(0);
        // Wenn die erste Menge 'null' ist, geben wir eine leere Menge zurueck.
        if(intersection == null)
        {
            return new HashSet<>();
        }
        for (Set<T> setToIntersect : listOfSets)
        {
            calculateIntersectionOfTwoSets(intersection, setToIntersect);
        }
        return intersection;
    }

    /**
     * Berechnet die Schnittmenge von <code>n</code> Mengen desselben generischen Typs.
     * Ist eine der uebergebenen Mengen <code>null</code> oder wird direkt nur <code>null</code> uebergeben,
     * so interpretiert die Methode dies als leere Menge und gibt folglich die leere Menge aus. Insbesondere
     * ist der Schnitt beliebig vieler <code>null</code>-Instanzen wieder die leere Menge.
     *
     * @param sets Die uebergebenen Mengen.
     * @param <T> Der generische Typparameter.
     * @return Die Schnittmenge der uebergebenen Mengen.
     */
    @SafeVarargs
    public final <T> Set<T> calculateIntersectionOfManySets(Set<T>... sets)
    {
        // Wenn sets schon 'null' ist, gib eine leere Menge zurueck.
        if(sets == null)
        {
            return new HashSet<>();
        }
        List<Set<T>> listOfSets = new ArrayList<>(Arrays.asList(sets));
        // Wenn die erste Menge schon 'null' ist, gib eine leere Menge zurueck.
        if(listOfSets.get(0) == null)
        {
            return new HashSet<>();
        }
        // Wenn nur eine Menge eingegeben wird, gib diese zurueck.
        if(listOfSets.size() == 1)
        {
            return listOfSets.get(0);
        }
        return this.calculateIntersectionOfListOfSets(listOfSets);
    }


}
