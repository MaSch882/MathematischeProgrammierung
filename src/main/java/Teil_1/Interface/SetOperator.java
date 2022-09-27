package Teil_1.Interface;

import java.util.List;
import java.util.Set;

public interface SetOperator<T>
{
    /**
     * Fuehrt die Operation auf zwei Mengen aus.
     *
     * @param setA Menge A.
     * @param setB Menge B.
     * @return Die Menge operation(A,B).
     */
    public abstract Set<T> executeOperationOnTwoSets(Set<T> setA, Set<T> setB);

    /**
     * Fuehrt die Operation auf einer Liste von Mengen aus. Hierfuer sollte die Operation assoziativ und kommutativ sein.
     *
     * @param listOfSets Die Liste der n Mengen.
     * @return Die Menge operation(A_1,...,A_n).
     */
    public abstract Set<T> executeOperationOnListOfSets(List<Set<T>> listOfSets);

    /**
     * Fuehrt die Operation auf beliebig vielen Mengen aus. Hierfuer sollte die Operation assoziativ und kommutativ sein.
     *
     * @param sets Die Mengen.
     * @return Die Menge operation(stream(sets)).
     */
    public abstract Set<T> executeOperationOnManySets(Set<T>... sets);
}
