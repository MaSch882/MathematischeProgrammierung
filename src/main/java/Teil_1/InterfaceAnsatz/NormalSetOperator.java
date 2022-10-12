package Teil_1.InterfaceAnsatz;

import java.util.List;
import java.util.Set;

/**
 * @param <T> Der generische Typparameter T.
 * @author Matthias Schulte
 * <p>
 * Interface fuer eine normale Operation auf Mengen. Eine Operation heisst dabei <i>normal</i>, falls sie assoziativ
 * und kommutativ ist. Bereitgestellt werden folgende Methoden:
 * <p>
 * - Ausfuehrung der Operation auf zwei Mengen.
 * <p>
 * - Ausfuehrung der Operation auf einer Liste von Mengen.
 * <p>
 * - Ausfuehrung der Operation auf beliebig vielen Mengen.
 */
public interface NormalSetOperator<T>
{
    /**
     * Fuehrt die normale Operation auf zwei Mengen aus.
     *
     * @param setA Menge A.
     * @param setB Menge B.
     * @return Die Menge operation(A,B).
     */
    public Set<T> executeOperationOnTwoSets(final Set<T> setA, final Set<T> setB);

    /**
     * Fuehrt die normale Operation auf einer Liste von Mengen aus.
     *
     * @param listOfSets Die Liste der n Mengen.
     * @return Die Menge operation(A_1,...,A_n).
     */
    public Set<T> executeOperationOnListOfSets(final List<Set<T>> listOfSets);

    /**
     * Fuehrt die normale Operation auf beliebig vielen Mengen aus.
     *
     * @param sets Die Mengen.
     * @return Die Menge operation(stream(sets)).
     */
    public Set<T> executeOperationOnManySets(final Set<T>... sets);
}
