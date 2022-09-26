package Teil_1.Interface;

import java.util.List;
import java.util.Set;

public class SetUnifier<T> implements SetOperator<T>
{

    @Override
    public Set<T> executeOperationOnTwoSets(Set<T> setA, Set<T> setB)
    {
        return calculateUnionOfTwoSets(setA, setB);
    }

    public Set<T> calculateUnionOfTwoSets(Set<T> setA, Set<T> setB)
    {
        // FIXME: Implementieren.
        return null;
    }

    @Override
    public Set<T> executeOperationOnListOfSets(List<Set<T>> listOfSets)
    {
        return null;
    }

    public Set<T> calculateUnionOfListOfSets(List<Set<T>> listOfSets)
    {
        // FIXME: Implementieren.
        return null;
    }

    @Override
    public Set<T> executeOperationOnManySets(Set<T>... sets)
    {
        return null;
    }

    public Set<T> calculateUnionOfManySets(Set<T>... sets)
    {
        // FIXME: Implementieren.
        return null;
    }
}
