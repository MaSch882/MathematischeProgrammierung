package Teil_1.InterfaceAnsatz;

import org.testng.annotations.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class SetUnifierTest
{

    //-----------------------------------------------------------------------------------------------------------------

    // Testfaelle - testExecuteOperationOnTwoSets:
    // 1. Zwei nichtleere Mengen ungleich null mit nichtleerer Vereinigung.
    // 2. Zwei nichtleere Mengen, von der eine null ist.
    // 3. Zwei Mengen, die null sind.
    // 4. Eine nichtleere und eine leere Menge.
    // 5. Zwei leere Mengen.

    @Test
    public void testExecuteOperationOnTwoSets_twoNonemptySetsWithNonemptyUnion()
    {
        // Given

        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        Set<Integer> setB = new HashSet<>(Arrays.asList(1, 4, 9, 16));
        Set<Integer> expectedResult = new HashSet<>(Arrays.asList(1, 2, 3, 4, 9, 16));

        SetUnifier<Integer> setOperator = new SetUnifier<>();

        // When

        Set<Integer> intersection = setOperator.executeOperationOnTwoSets(setA, setB);

        // Then

        assertThat(intersection).containsExactlyInAnyOrderElementsOf(expectedResult);
    }

    @Test
    public void testExecuteOperationOnTwoSets_oneNull()
    {
        // Given
        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4));

        SetUnifier<Integer> setOperator = new SetUnifier<>();

        // When
        Set<Integer> unionSetAAndNull = setOperator.executeOperationOnTwoSets(setA, null);
        Set<Integer> unionNullAndSetA = setOperator.executeOperationOnTwoSets(null, setA);

        // Then

        assertThat(unionSetAAndNull).containsExactlyInAnyOrderElementsOf(setA);
        assertThat(unionNullAndSetA).containsExactlyInAnyOrderElementsOf(setA);

    }

    @Test
    public void testExecuteOperationOnTwoSets_bothNull()
    {
        // Given

        SetUnifier<Integer> setOperator = new SetUnifier<>();

        // When

        Set<Integer> unionNullAndNull = setOperator.executeOperationOnTwoSets(null, null);

        // Then

        assertThat(unionNullAndNull).isEmpty();
    }

    @Test
    public void testExecuteOperationOnTwoSets_oneEmpty()
    {
        // Given
        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        Set<Integer> setB = new HashSet<>();

        SetUnifier<Integer> setOperator = new SetUnifier<>();

        // When
        Set<Integer> unionSetAAndNull = setOperator.executeOperationOnTwoSets(setA, setB);
        Set<Integer> unionNullAndSetA = setOperator.executeOperationOnTwoSets(setB, setA);

        // Then

        assertThat(unionSetAAndNull).containsExactlyInAnyOrderElementsOf(setA);
        assertThat(unionNullAndSetA).containsExactlyInAnyOrderElementsOf(setA);
    }

    @Test
    public void testExecuteOperationOnTwoSets_bothEmpty()
    {
        // Given
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        SetUnifier<Integer> setOperator = new SetUnifier<>();

        // When
        Set<Integer> unionSetAAndNull = setOperator.executeOperationOnTwoSets(setA, setB);

        // Then

        assertThat(unionSetAAndNull).isEmpty();
    }

    //-----------------------------------------------------------------------------------------------------------------

    // Testfaelle - testExecuteOperationOnListOfSets:
    // 1. Drei nichtleere Mengen mit nichtleerer Vereinigung.
    // 2. Zwei nichtleere Mengen mit nichtleerer Vereinigung.
    // 3. Drei nichtleere Mengen, von denen eine null ist.
    // -> Reicht aus, da alle weiteren Kombinationen schon oben abgetestet sind.
    // 4. Drei Mengen, von denen eine leer ist.
    // -> Reicht aus, da alle weiteren Kombinationen schon oben abgetestet sind.

    @Test
    public void testExecuteOperationOnListOfSets_threeNonemptySetsWithNonemptyUnion()
    {
        //Given

        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> setB = new HashSet<>(Arrays.asList(2, 3, 4, 5, 6));
        Set<Integer> setC = new HashSet<>(Arrays.asList(3, 4, 5, 6, 7));
        List<Set<Integer>> sets = new ArrayList<>(Arrays.asList(setA, setB, setC));

        Set<Integer> expectedResult = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));

        SetUnifier<Integer> setOperator = new SetUnifier<>();

        // When
        Set<Integer> result = setOperator.executeOperationOnListOfSets(sets);

        // Then
        assertThat(result).containsExactlyInAnyOrderElementsOf(expectedResult);
    }

    @Test
    public void testExecuteOperationOnListOfSets_twoNonemptySetsWithNonemptyUnion()
    {
        //Given

        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> setB = new HashSet<>(Arrays.asList(2, 3, 4, 5, 6));
        List<Set<Integer>> sets = new ArrayList<>(Arrays.asList(setA, setB));

        Set<Integer> expectedResult = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        SetUnifier<Integer> setOperator = new SetUnifier<>();

        // When
        Set<Integer> result = setOperator.executeOperationOnListOfSets(sets);

        // Then
        assertThat(result).containsExactlyInAnyOrderElementsOf(expectedResult);
    }

    @Test
    public void testExecuteOperationOnListOfSets_threeSetsWithOneNull()
    {
        //Given

        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> setB = new HashSet<>(Arrays.asList(6, 7, 8, 9, 10));

        List<Set<Integer>> setsCombination1 = new ArrayList<>(Arrays.asList(setA, setB, null));
        List<Set<Integer>> setsCombination2 = new ArrayList<>(Arrays.asList(setA, null, setB));
        List<Set<Integer>> setsCombination3 = new ArrayList<>(Arrays.asList(null, setA, setB));

        Set<Integer> expectedResult = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        SetUnifier<Integer> setOperator = new SetUnifier<>();

        // When - Then
        assertThat(setOperator.executeOperationOnListOfSets(setsCombination1)).containsExactlyInAnyOrderElementsOf(expectedResult);
        assertThat(setOperator.executeOperationOnListOfSets(setsCombination2)).containsExactlyInAnyOrderElementsOf(expectedResult);
        assertThat(setOperator.executeOperationOnListOfSets(setsCombination3)).containsExactlyInAnyOrderElementsOf(expectedResult);
    }

    @Test
    public void testExecuteOperationOnListOfSets_threeSetsWithOneEmpty()
    {
        //Given

        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> setB = new HashSet<>(Arrays.asList(6, 7, 8, 9, 10));
        Set<Integer> setC = new HashSet<>();

        List<Set<Integer>> setsCombination1 = new ArrayList<>(Arrays.asList(setA, setB, setC));
        List<Set<Integer>> setsCombination2 = new ArrayList<>(Arrays.asList(setA, setC, setB));
        List<Set<Integer>> setsCombination3 = new ArrayList<>(Arrays.asList(setC, setA, setB));


        Set<Integer> expectedResult = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        SetUnifier<Integer> setOperator = new SetUnifier<>();

        // When - Then
        assertThat(setOperator.executeOperationOnListOfSets(setsCombination1)).containsExactlyInAnyOrderElementsOf(expectedResult);
        assertThat(setOperator.executeOperationOnListOfSets(setsCombination2)).containsExactlyInAnyOrderElementsOf(expectedResult);
        assertThat(setOperator.executeOperationOnListOfSets(setsCombination3)).containsExactlyInAnyOrderElementsOf(expectedResult);
    }

    //-----------------------------------------------------------------------------------------------------------------

    // Testfaelle - testExecuteOperationOnManySets:
    // 1. Drei nichtleere Mengen mit nichtleerer Vereinigung.
    // 2. Zwei nichtleere Mengen mit nichtleerer Vereinigung.
    // 3. Eine nichtleere Menge.
    // 4. Eine Menge, die leer ist.
    // 5. Eine Menge, die null ist.
    // 6. Drei nichtleere Mengen, von denen eine null ist.
    // -> Reicht aus, da alle weiteren Kombinationen schon oben abgetestet sind.
    // 7. Drei Mengen, von denen eine leer ist.
    // -> Reicht aus, da alle weiteren Kombinationen schon oben abgetestet sind.

    @Test
    public void testExecuteOperationOnManySets_threeNonemptySetsWithNonemptyIntersection()
    {
        //Given

        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> setB = new HashSet<>(Arrays.asList(2, 3, 4, 5, 6));
        Set<Integer> setC = new HashSet<>(Arrays.asList(3, 4, 5, 6, 7));

        Set<Integer> expectedResult = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));

        SetUnifier<Integer> setOperator = new SetUnifier<>();

        // When
        Set<Integer> result = setOperator.executeOperationOnManySets(setA, setB, setC);

        // Then
        assertThat(result).containsExactlyInAnyOrderElementsOf(expectedResult);
    }

    @Test
    public void testExecuteOperationOnManySets_twoNonemptySetsWithNonemptyIntersection()
    {
        //Given

        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> setB = new HashSet<>(Arrays.asList(2, 3, 4, 5, 6));

        Set<Integer> expectedResult = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        SetUnifier<Integer> setOperator = new SetUnifier<>();

        // When
        Set<Integer> result = setOperator.executeOperationOnManySets(setA, setB);

        // Then
        assertThat(result).containsExactlyInAnyOrderElementsOf(expectedResult);
    }

    @Test
    public void testExecuteOperationOnManySets_oneNonemptySet()
    {
        //Given

        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));


        SetUnifier<Integer> setOperator = new SetUnifier<>();

        // When
        Set<Integer> result = setOperator.executeOperationOnManySets(setA);

        // Then
        assertThat(result).containsExactlyInAnyOrderElementsOf(setA);
    }

    @Test
    public void testExecuteOperationOnManySets_oneEmptySet()
    {
        //Given

        Set<Integer> setA = new HashSet<>();


        SetUnifier<Integer> setOperator = new SetUnifier<>();

        // When
        Set<Integer> result = setOperator.executeOperationOnManySets(setA);

        // Then
        assertThat(result).isEmpty();
    }

    @Test
    public void testExecuteOperationOnManySets_oneNull()
    {
        SetUnifier<Integer> setOperator = new SetUnifier<>();
        assertThat(setOperator.executeOperationOnManySets(null)).isEmpty();
    }

    @Test
    public void testExecuteOperationOnManySets_threeSetsWithOneNull()
    {
        //Given

        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> setB = new HashSet<>(Arrays.asList(6, 7, 8, 9, 10));

        Set<Integer> expectedResult = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        SetUnifier<Integer> setOperator = new SetUnifier<>();

        // When - Then
        assertThat(setOperator.executeOperationOnManySets(setA, setB, null)).containsExactlyInAnyOrderElementsOf(expectedResult);
        assertThat(setOperator.executeOperationOnManySets(setA, null, setB)).containsExactlyInAnyOrderElementsOf(expectedResult);
        assertThat(setOperator.executeOperationOnManySets(null, setA, setB)).containsExactlyInAnyOrderElementsOf(expectedResult);
    }

    @Test
    public void testExecuteOperationOnManySets_threeSetsWithOneEmpty()
    {
        //Given

        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> setB = new HashSet<>(Arrays.asList(6, 7, 8, 9, 10));
        Set<Integer> setC = new HashSet<>();

        Set<Integer> expectedResult = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        SetUnifier<Integer> setOperator = new SetUnifier<>();

        // When - Then
        assertThat(setOperator.executeOperationOnManySets(setA, setB, null)).containsExactlyInAnyOrderElementsOf(expectedResult);
        assertThat(setOperator.executeOperationOnManySets(setA, null, setB)).containsExactlyInAnyOrderElementsOf(expectedResult);
        assertThat(setOperator.executeOperationOnManySets(null, setA, setB)).containsExactlyInAnyOrderElementsOf(expectedResult);
    }


    //-----------------------------------------------------------------------------------------------------------------
}