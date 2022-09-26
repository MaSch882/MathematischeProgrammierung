package Teil_1.Interface;

import java.util.*;

public class SetIntersector<T> implements SetOperator<T>
{

    @Override
    public Set<T> executeOperationOnTwoSets(Set<T> setA, Set<T> setB)
    {
        return calculateIntersectionOfTwoSets(setA, setB);
    }

    protected Set<T> calculateIntersectionOfTwoSets(Set<T> setA, Set<T> setB)
    {
        if(setA == null || setB == null)
        {
            return new HashSet<>();
        }
        setA.retainAll(setB);
        return setA;
    }

    @Override
    public Set<T> executeOperationOnListOfSets(List<Set<T>> listOfSets)
    {
        return calculateIntersectionOfListOfSets(listOfSets);
    }

    public Set<T> calculateIntersectionOfListOfSets(List<Set<T>> listOfSets)
    {
        Set<T> intersection = listOfSets.get(0);
        // Wenn die erste Menge 'null' ist, geben wir eine leere Menge zurueck.
        if(intersection == null)
        {
            return new HashSet<>();
        }
        for (Set<T> setToIntersect : listOfSets)
        {
            intersection = calculateIntersectionOfTwoSets(intersection, setToIntersect);
        }
        return intersection;
    }


    @SafeVarargs
    @Override
    public final Set<T> executeOperationOnManySets(Set<T>... sets)
    {
        return calculateIntersectionOfManySets(sets);
    }

    @SafeVarargs
    public final Set<T> calculateIntersectionOfManySets(Set<T>... sets)
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
