package Teil_1.InterfaceAnsatz;

import org.testng.annotations.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class SetIntersectorTest
{

    //-----------------------------------------------------------------------------------------------------------------

    // Testfaelle - testExecuteOperationOnTwoSets:
    // 1. Zwei nichtleere Mengen ungleich null mit nichtleerem Schnitt.
    // 2. Zwei nichtleere Mengen ungleich null mit leerem Schnitt.
    // 3. Zwei nichtleere Mengen, von der eine null ist.
    // 4. Zwei Mengen, die null sind.
    // 5. Eine nichtleere und eine leere Menge.
    // 6. Zwei leere Mengen.

    @Test
    public void testExecuteOperationOnTwoSets_twoNonemptySetsWithNonemptyIntersection()
    {
        // Given

        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        Set<Integer> setB = new HashSet<>(Arrays.asList(1, 4, 9, 16));
        Set<Integer> expectedResult = new HashSet<>(Arrays.asList(1, 4));

        SetIntersector<Integer> setOperator = new SetIntersector<>();

        // When

        Set<Integer> intersection = setOperator.executeOperationOnTwoSets(setA, setB);

        // Then

        assertThat(intersection).containsExactlyInAnyOrderElementsOf(expectedResult);
    }

    @Test
    public void testExecuteOperationOnTwoSets_twoNonemptySetsWithEmptyIntersection()
    {
        // Given

        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        Set<Integer> setB = new HashSet<>(Arrays.asList(5, 6, 7, 8));

        SetIntersector<Integer> setOperator = new SetIntersector<>();

        // When

        Set<Integer> intersection = setOperator.executeOperationOnTwoSets(setA, setB);

        // Then

        assertThat(intersection).isEmpty();
    }

    @Test
    public void testExecuteOperationOnTwoSets_oneNull()
    {
        // Given
        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4));

        SetIntersector<Integer> setOperator = new SetIntersector<>();

        // When
        Set<Integer> intersectionSetAAndNull = setOperator.executeOperationOnTwoSets(setA, null);
        Set<Integer> intersectionNullAndSetA = setOperator.executeOperationOnTwoSets(null, setA);

        // Then

        assertThat(intersectionSetAAndNull).isEmpty();
        assertThat(intersectionNullAndSetA).isEmpty();

    }

    @Test
    public void testExecuteOperationOnTwoSets_bothNull()
    {
        // Given

        SetIntersector<Integer> setOperator = new SetIntersector<>();

        // When

        Set<Integer> intersectionNullAndNull = setOperator.executeOperationOnTwoSets(null, null);

        // Then

        assertThat(intersectionNullAndNull).isEmpty();
    }

    @Test
    public void testExecuteOperationOnTwoSets_oneEmpty()
    {
        // Given
        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        Set<Integer> setB = new HashSet<>();

        SetIntersector<Integer> setOperator = new SetIntersector<>();

        // When
        Set<Integer> intersectionSetAAndNull = setOperator.executeOperationOnTwoSets(setA, setB);
        Set<Integer> intersectionNullAndSetA = setOperator.executeOperationOnTwoSets(setB, setA);

        // Then

        assertThat(intersectionSetAAndNull).isEmpty();
        assertThat(intersectionNullAndSetA).isEmpty();
    }

    @Test
    public void testExecuteOperationOnTwoSets_bothEmpty()
    {
        // Given
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        SetIntersector<Integer> setOperator = new SetIntersector<>();

        // When
        Set<Integer> intersectionSetAAndNull = setOperator.executeOperationOnTwoSets(setA, setB);

        // Then

        assertThat(intersectionSetAAndNull).isEmpty();
    }

    //-----------------------------------------------------------------------------------------------------------------

    // Testfaelle - testExecuteOperationOnListOfSets:
    // 1. Drei nichtleere Mengen mit nichtleerem Schnitt.
    // 2. Drei nichtleere Mengen mit leerem Schnitt.
    // 3. Zwei nichtleere Mengen mit nichtleerem Schnitt.
    // 4. Zwei nichtleere Mengen mit leerem Schnitt.
    // 5. Drei nichtleere Mengen, von denen eine null ist.
    // -> Reicht aus, da alle weiteren Kombinationen schon oben abgetestet sind.
    // 6. Drei Mengen, von denen eine leer ist.
    // -> Reicht aus, da alle weiteren Kombinationen schon oben abgetestet sind.

    @Test
    public void testExecuteOperationOnListOfSets_threeNonemptySetsWithNonemptyIntersection()
    {
        //Given

        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> setB = new HashSet<>(Arrays.asList(2, 3, 4, 5, 6));
        Set<Integer> setC = new HashSet<>(Arrays.asList(3, 4, 5, 6, 7));
        List<Set<Integer>> sets = new ArrayList<>(Arrays.asList(setA, setB, setC));

        Set<Integer> expectedResult = new HashSet<>(Arrays.asList(3, 4, 5));

        SetIntersector<Integer> setOperator = new SetIntersector<>();

        // When
        Set<Integer> result = setOperator.executeOperationOnListOfSets(sets);

        // Then
        assertThat(result).containsExactlyInAnyOrderElementsOf(expectedResult);
    }

    @Test
    public void testExecuteOperationOnListOfSets_threeNonemptySetsWithEmptyIntersection()
    {
        //Given

        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> setB = new HashSet<>(Arrays.asList(6, 7, 8, 9, 10));
        Set<Integer> setC = new HashSet<>(Arrays.asList(11, 12, 13, 14, 15));
        List<Set<Integer>> sets = new ArrayList<>(Arrays.asList(setA, setB, setC));


        SetIntersector<Integer> setOperator = new SetIntersector<>();

        // When
        Set<Integer> result = setOperator.executeOperationOnListOfSets(sets);

        // Then
        assertThat(result).isEmpty();
    }

    @Test
    public void testExecuteOperationOnListOfSets_twoNonemptySetsWithNonemptyIntersection()
    {
        //Given

        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> setB = new HashSet<>(Arrays.asList(2, 3, 4, 5, 6));
        List<Set<Integer>> sets = new ArrayList<>(Arrays.asList(setA, setB));

        Set<Integer> expectedResult = new HashSet<>(Arrays.asList(2, 3, 4, 5));

        SetIntersector<Integer> setOperator = new SetIntersector<>();

        // When
        Set<Integer> result = setOperator.executeOperationOnListOfSets(sets);

        // Then
        assertThat(result).containsExactlyInAnyOrderElementsOf(expectedResult);
    }

    @Test
    public void testExecuteOperationOnListOfSets_twoNonemptySetsWithEmptyIntersection()
    {
        //Given

        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> setB = new HashSet<>(Arrays.asList(6, 7, 8, 9, 10));
        List<Set<Integer>> sets = new ArrayList<>(Arrays.asList(setA, setB));


        SetIntersector<Integer> setOperator = new SetIntersector<>();

        // When
        Set<Integer> result = setOperator.executeOperationOnListOfSets(sets);

        // Then
        assertThat(result).isEmpty();
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


        SetIntersector<Integer> setOperator = new SetIntersector<>();

        // When - Then
        assertThat(setOperator.executeOperationOnListOfSets(setsCombination1)).isEmpty();
        assertThat(setOperator.executeOperationOnListOfSets(setsCombination2)).isEmpty();
        assertThat(setOperator.executeOperationOnListOfSets(setsCombination3)).isEmpty();
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


        SetIntersector<Integer> setOperator = new SetIntersector<>();

        // When - Then
        assertThat(setOperator.executeOperationOnListOfSets(setsCombination1)).isEmpty();
        assertThat(setOperator.executeOperationOnListOfSets(setsCombination2)).isEmpty();
        assertThat(setOperator.executeOperationOnListOfSets(setsCombination3)).isEmpty();
    }

    //-----------------------------------------------------------------------------------------------------------------
    
    // Testfaelle - testExecuteOperationOnManySets:
    // 1. Drei nichtleere Mengen mit nichtleerem Schnitt.
    // 2. Drei nichtleere Mengen mit leerem Schnitt.
    // 3. Zwei nichtleere Mengen mit nichtleerem Schnitt.
    // 4. Zwei nichtleere Mengen mit leerem Schnitt.
    // 5. Eine nichtleere Menge.
    // 6. Eine Menge, die leer ist.
    // 7. Eine Menge, die null ist.
    // 8. Drei nichtleere Mengen, von denen eine null ist.
    // -> Reicht aus, da alle weiteren Kombinationen schon oben abgetestet sind.
    // 9. Drei Mengen, von denen eine leer ist.
    // -> Reicht aus, da alle weiteren Kombinationen schon oben abgetestet sind.

    @Test
    public void testExecuteOperationOnManySets_threeNonemptySetsWithNonemptyIntersection()
    {
        //Given

        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> setB = new HashSet<>(Arrays.asList(2, 3, 4, 5, 6));
        Set<Integer> setC = new HashSet<>(Arrays.asList(3, 4, 5, 6, 7));

        Set<Integer> expectedResult = new HashSet<>(Arrays.asList(3, 4, 5));

        SetIntersector<Integer> setOperator = new SetIntersector<>();

        // When
        Set<Integer> result = setOperator.executeOperationOnManySets(setA, setB, setC);

        // Then
        assertThat(result).containsExactlyInAnyOrderElementsOf(expectedResult);
    }

    @Test
    public void testExecuteOperationOnManySets_threeNonemptySetsWithEmptyIntersection()
    {
        //Given

        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> setB = new HashSet<>(Arrays.asList(6, 7, 8, 9, 10));
        Set<Integer> setC = new HashSet<>(Arrays.asList(11, 12, 13, 14, 15));


        SetIntersector<Integer> setOperator = new SetIntersector<>();

        // When
        Set<Integer> result = setOperator.executeOperationOnManySets(setA, setB, setC);

        // Then
        assertThat(result).isEmpty();
    }

    @Test
    public void testExecuteOperationOnManySets_twoNonemptySetsWithNonemptyIntersection()
    {
        //Given

        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> setB = new HashSet<>(Arrays.asList(2, 3, 4, 5, 6));

        Set<Integer> expectedResult = new HashSet<>(Arrays.asList(2, 3, 4, 5));

        SetIntersector<Integer> setOperator = new SetIntersector<>();

        // When
        Set<Integer> result = setOperator.executeOperationOnManySets(setA, setB);

        // Then
        assertThat(result).containsExactlyInAnyOrderElementsOf(expectedResult);
    }

    @Test
    public void testExecuteOperationOnManySets_twoNonemptySetsWithEmptyIntersection()
    {
        //Given

        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> setB = new HashSet<>(Arrays.asList(6, 7, 8, 9, 10));


        SetIntersector<Integer> setOperator = new SetIntersector<>();

        // When
        Set<Integer> result = setOperator.executeOperationOnManySets(setA, setB);

        // Then
        assertThat(result).isEmpty();
    }

    @Test
    public void testExecuteOperationOnManySets_oneNonemptySet()
    {
        //Given

        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));


        SetIntersector<Integer> setOperator = new SetIntersector<>();

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


        SetIntersector<Integer> setOperator = new SetIntersector<>();

        // When
        Set<Integer> result = setOperator.executeOperationOnManySets(setA);

        // Then
        assertThat(result).isEmpty();
    }

    @Test
    public void testExecuteOperationOnManySets_oneNull()
    {
        SetIntersector<Integer> setOperator = new SetIntersector<>();
        assertThat(setOperator.executeOperationOnManySets(null)).isEmpty();
    }

    @Test
    public void testExecuteOperationOnManySets_threeSetsWithOneNull()
    {
        //Given

        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> setB = new HashSet<>(Arrays.asList(6, 7, 8, 9, 10));

        SetIntersector<Integer> setOperator = new SetIntersector<>();

        // When - Then
        assertThat(setOperator.executeOperationOnManySets(setA, setB, null)).isEmpty();
        assertThat(setOperator.executeOperationOnManySets(setA, null, setB)).isEmpty();
        assertThat(setOperator.executeOperationOnManySets(null, setA, setB)).isEmpty();
    }

    @Test
    public void testExecuteOperationOnManySets_threeSetsWithOneEmpty()
    {
        //Given

        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> setB = new HashSet<>(Arrays.asList(6, 7, 8, 9, 10));
        Set<Integer> setC = new HashSet<>();

        SetIntersector<Integer> setOperator = new SetIntersector<>();

        // When - Then
        assertThat(setOperator.executeOperationOnManySets(setA, setB, setC)).isEmpty();
        assertThat(setOperator.executeOperationOnManySets(setA, setC, setB)).isEmpty();
        assertThat(setOperator.executeOperationOnManySets(setC, setA, setB)).isEmpty();
    }


    //-----------------------------------------------------------------------------------------------------------------
}