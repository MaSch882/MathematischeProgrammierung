package Teil_1.InterfaceAnsatz;

import java.util.*;

public class SetUnifier<T> implements NormalSetOperator<T>
{

    /**
     * {@inheritDoc}
     * <p>
     * Hier ist die Operation die Vereinigungsbildung.
     */
    @Override
    public Set<T> executeOperationOnTwoSets(final Set<T> setA, final Set<T> setB)
    {
        return calculateUnionOfTwoSets(setA, setB);
    }

    /**
     * Berechnet die Vereinigungsmenge zweier Mengen desselben generischen Typs <code>T</code>. Ist einer der Parameter
     * <code>null</code>, so interpretiert diese Methode dies als leere Menge.
     *
     * @param setA Die erste Menge.
     * @param setB Die zweite Menge.
     * @return Die Vereinigungsmenge beider Mengen.
     */
    public Set<T> calculateUnionOfTwoSets(final Set<T> setA, final Set<T> setB)
    {
        Set<T> copyOfSetA = setA == null ? new HashSet<>() : setA;
        Set<T> copyOfSetB = setB == null ? new HashSet<>() : setB;

        copyOfSetB.addAll(copyOfSetA);
        return copyOfSetB;
    }

    /**
     * {@inheritDoc}
     * <p>
     * Hier ist die Operation die Vereinigungsbildung.
     */
    @Override
    public Set<T> executeOperationOnListOfSets(final List<Set<T>> listOfSets)
    {
        return calculateUnionOfListOfSets(listOfSets);
    }

    /**
     * Berechnet die Vereinigungsmenge von <code>n</code> Mengen desselben generischen Typs, die in einer Liste
     * uebergeben werden. Ist einer der Listeneintraege <code>null</code>, so interpretiert diese Methode dies als
     * leere Menge.
     *
     * @param listOfSets Die Liste der <code>n</code> Mengen.
     * @return Die Vereinigungsmenge der <code>n</code> Mengen.
     */
    public Set<T> calculateUnionOfListOfSets(final List<Set<T>> listOfSets)
    {
        Set<T> union = listOfSets.get(0);
        for (Set<T> setToUnify : listOfSets)
        {
            union = calculateUnionOfTwoSets(union, setToUnify);
        }
        return union;
    }

    /**
     * {@inheritDoc}
     * <p>
     * Hier ist die Operation die Vereinigungsbildung.
     */
    @Override
    public Set<T> executeOperationOnManySets(Set<T>... sets)
    {
        return calculateUnionOfManySets(sets);
    }

    /**
     * Berechnet die Vereinigungsmenge von <code>n</code> Mengen desselben generischen Typs.
     * Ist eine der uebergebenen Mengen <code>null</code> oder wird direkt nur <code>null</code> uebergeben,
     * so interpretiert die Methode dies als leere Menge.
     *
     * @param sets Die uebergebenen Mengen.
     * @return Die Vereinigungsmenge der uebergebenen Mengen.
     */
    public Set<T> calculateUnionOfManySets(Set<T>... sets)
    {
        if (sets == null)
        {
            return new HashSet<>();
        }
        List<Set<T>> listOfSets = new ArrayList<>(Arrays.asList(sets));
        // Wenn nur eine Menge eingegeben wird, gib diese zurueck.
        if (listOfSets.size() == 1)
        {
            return listOfSets.get(0);
        }
        return this.calculateUnionOfListOfSets(listOfSets);
    }
}
