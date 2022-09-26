package Teil_1.Interface;

import java.util.List;
import java.util.Set;

public interface SetOperator<T>
{
    public abstract Set<T> executeOperationOnTwoSets(Set<T> setA, Set<T> setB);

    public abstract Set<T> executeOperationOnListOfSets(List<Set<T>> listOfSets);

    public abstract Set<T> executeOperationOnManySets(Set<T> ... sets);
}
