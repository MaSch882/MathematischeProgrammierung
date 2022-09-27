package Teil_1.Interface;

import java.util.*;

public class SetIntersector<T> implements SetOperator<T>
{

    /**
     * {@inheritDoc} Hier ist die Operation die Schnittbildung.
     */
    @Override
    public Set<T> executeOperationOnTwoSets(Set<T> setA, Set<T> setB)
    {
        return calculateIntersectionOfTwoSets(setA, setB);
    }

    /**
     * Berechnet die Schnittmenge zweier Mengen desselben generischen Typs <code>T</code>.
     * Ist einer der Parameter <code>null</code>, so interpretiert die Methode dies als leere Menge und gibt
     * folglich eine leere Menge zurueck. Insbesondere ist der Schnitt zweier <code>null</code>-Instanzen
     * wieder die leere Menge.
     *
     * @param setA Die erste Menge.
     * @param setB Die zweite Menge.
     * @return Die Schnittmenge beider Mengen.
     */
    protected Set<T> calculateIntersectionOfTwoSets(Set<T> setA, Set<T> setB)
    {
        if (setA == null || setB == null)
        {
            return new HashSet<>();
        }
        setA.retainAll(setB);
        return setA;
    }

    /**
     * {@inheritDoc} Hier ist die Operation die Schnittbildung.
     */
    @Override
    public Set<T> executeOperationOnListOfSets(List<Set<T>> listOfSets)
    {
        return calculateIntersectionOfListOfSets(listOfSets);
    }

    /**
     * Berechnet die Schnittmenge von <code>n</code> Mengen desselben generischen Typs, die in einer Liste
     * uebergeben werden. Ist einer der Listeneintraege <code>null</code>, so interpretiert die Methode dies
     * als leere Menge und gibt folglich die leere Menge aus. Insbesondere ist der Schnitt beliebig vieler
     * <code>null</code>-Instanzen wieder die leere Menge.
     *
     * @param listOfSets Die Liste der <code>n</code> Mengen.
     * @return Die Schnittmenge der <code>n</code> Mengen.
     */
    public Set<T> calculateIntersectionOfListOfSets(List<Set<T>> listOfSets)
    {
        Set<T> intersection = listOfSets.get(0);
        // Wenn die erste Menge 'null' ist, geben wir eine leere Menge zurueck.
        if (intersection == null)
        {
            return new HashSet<>();
        }
        for (Set<T> setToIntersect : listOfSets)
        {
            intersection = calculateIntersectionOfTwoSets(intersection, setToIntersect);
        }
        return intersection;
    }

    /**
     * {@inheritDoc} Hier ist die Operation die Schnittbildung.
     */
    @SafeVarargs
    @Override
    public final Set<T> executeOperationOnManySets(Set<T>... sets)
    {
        return calculateIntersectionOfManySets(sets);
    }

    /**
     * Berechnet die Schnittmenge von <code>n</code> Mengen desselben generischen Typs.
     * Ist eine der uebergebenen Mengen <code>null</code> oder wird direkt nur <code>null</code> uebergeben,
     * so interpretiert die Methode dies als leere Menge und gibt folglich die leere Menge aus. Insbesondere
     * ist der Schnitt beliebig vieler <code>null</code>-Instanzen wieder die leere Menge.
     *
     * @param sets Die uebergebenen Mengen.
     * @return Die Schnittmenge der uebergebenen Mengen.
     */
    @SafeVarargs
    public final Set<T> calculateIntersectionOfManySets(Set<T>... sets)
    {
        // Wenn sets schon 'null' ist, gib eine leere Menge zurueck.
        if (sets == null)
        {
            return new HashSet<>();
        }
        List<Set<T>> listOfSets = new ArrayList<>(Arrays.asList(sets));
        // Wenn die erste Menge schon 'null' ist, gib eine leere Menge zurueck.
        if (listOfSets.get(0) == null)
        {
            return new HashSet<>();
        }
        // Wenn nur eine Menge eingegeben wird, gib diese zurueck.
        if (listOfSets.size() == 1)
        {
            return listOfSets.get(0);
        }
        return this.calculateIntersectionOfListOfSets(listOfSets);
    }
}
