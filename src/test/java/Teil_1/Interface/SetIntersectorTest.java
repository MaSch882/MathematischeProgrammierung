package Teil_1.Interface;

import org.testng.annotations.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class SetIntersectorTest
{

    //-----------------------------------------------------------------------------------------------------------------

    // Testfaelle - testCalculateIntersectionOfTwoSets:
    // 1. Zwei nichtleere Mengen ungleich null mit nichtleerem Schnitt.
    // 2. Zwei nichtleere Mengen ungleich null mit leerem Schnitt.
    // 3. Zwei nichtleere Mengen, von der eine null ist.
    // 4. Zwei Mengen, die null sind.
    // 5. Eine nichtleere und eine leere Menge.
    // 6. Zwei leere Mengen.

    @Test
    public void testCalculateIntersectionOfTwoSets_twoNonemptySetsWithNonemptyIntersection()
    {
        // Given

        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        Set<Integer> setB = new HashSet<>(Arrays.asList(1, 4, 9, 16));
        Set<Integer> expectedResult = new HashSet<>(Arrays.asList(1, 4));

        SetIntersector<Integer> setOperator = new SetIntersector<>();

        // When

        Set<Integer> intersection = setOperator.calculateIntersectionOfTwoSets(setA, setB);

        // Then

        assertThat(intersection).containsExactlyInAnyOrderElementsOf(expectedResult);
    }

    @Test
    public void testCalculateIntersectionOfTwoSets_twoNonemptySetsWithEmptyIntersection()
    {
        // Given

        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        Set<Integer> setB = new HashSet<>(Arrays.asList(5, 6, 7, 8));

        SetIntersector<Integer> setOperator = new SetIntersector<>();

        // When

        Set<Integer> intersection = setOperator.calculateIntersectionOfTwoSets(setA, setB);

        // Then

        assertThat(intersection).isEmpty();
    }

    @Test
    public void testCalculateIntersectionOfTwoSets_oneNull()
    {
        // Given
        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4));

        SetIntersector<Integer> setOperator = new SetIntersector<>();

        // When
        Set<Integer> intersectionSetAAndNull = setOperator.calculateIntersectionOfTwoSets(setA, null);
        Set<Integer> intersectionNullAndSetA = setOperator.calculateIntersectionOfTwoSets(null, setA);

        // Then

        assertThat(intersectionSetAAndNull).isEmpty();
        assertThat(intersectionNullAndSetA).isEmpty();

    }

    @Test
    public void testCalculateIntersectionOfTwoSets_bothNull()
    {
        // Given

        SetIntersector<Integer> setOperator = new SetIntersector<>();

        // When

        Set<Integer> intersectionNullAndNull = setOperator.calculateIntersectionOfTwoSets(null, null);

        // Then

        assertThat(intersectionNullAndNull).isEmpty();
    }

    @Test
    public void testCalculateIntersectionOfTwoSets_oneEmpty()
    {
        // Given
        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        Set<Integer> setB = new HashSet<>();

        SetIntersector<Integer> setOperator = new SetIntersector<>();

        // When
        Set<Integer> intersectionSetAAndNull = setOperator.calculateIntersectionOfTwoSets(setA, setB);
        Set<Integer> intersectionNullAndSetA = setOperator.calculateIntersectionOfTwoSets(setB, setA);

        // Then

        assertThat(intersectionSetAAndNull).isEmpty();
        assertThat(intersectionNullAndSetA).isEmpty();
    }

    @Test
    public void testCalculateIntersectionOfTwoSets_bothEmpty()
    {
        // Given
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        SetIntersector<Integer> setOperator = new SetIntersector<>();

        // When
        Set<Integer> intersectionSetAAndNull = setOperator.calculateIntersectionOfTwoSets(setA, setB);

        // Then

        assertThat(intersectionSetAAndNull).isEmpty();
    }

    //-----------------------------------------------------------------------------------------------------------------

    // Testfaelle - testCalculateIntersectionOfListsOfSets:
    // 1. Drei nichtleere Mengen mit nichtleerem Schnitt.
    // 2. Drei nichtleere Mengen mit leerem Schnitt.
    // 3. Zwei nichtleere Mengen mit nichtleerem Schnitt.
    // 4. Zwei nichtleere Mengen mit leerem Schnitt.
    // 5. Drei nichtleere Mengen, von denen eine null ist.
    // -> Reicht aus, da alle weiteren Kombinationen schon oben abgetestet sind.
    // 6. Drei Mengen, von denen eine leer ist.
    // -> Reicht aus, da alle weiteren Kombinationen schon oben abgetestet sind.

    @Test
    public void testCalculateIntersectionOfListsOfSets_threeNonemptySetsWithNonemptyIntersection()
    {
        //Given

        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> setB = new HashSet<>(Arrays.asList(2, 3, 4, 5, 6));
        Set<Integer> setC = new HashSet<>(Arrays.asList(3, 4, 5, 6, 7));
        List<Set<Integer>> sets = new ArrayList<>(Arrays.asList(setA, setB, setC));

        Set<Integer> expectedResult = new HashSet<>(Arrays.asList(3, 4, 5));

        SetIntersector<Integer> setOperator = new SetIntersector<>();

        // When
        Set<Integer> result = setOperator.calculateIntersectionOfListOfSets(sets);

        // Then
        assertThat(result).containsExactlyInAnyOrderElementsOf(expectedResult);
    }

    @Test
    public void testCalculateIntersectionOfListsOfSets_threeNonemptySetsWithEmptyIntersection()
    {
        //Given

        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> setB = new HashSet<>(Arrays.asList(6, 7, 8, 9, 10));
        Set<Integer> setC = new HashSet<>(Arrays.asList(11, 12, 13, 14, 15));
        List<Set<Integer>> sets = new ArrayList<>(Arrays.asList(setA, setB, setC));


        SetIntersector<Integer> setOperator = new SetIntersector<>();

        // When
        Set<Integer> result = setOperator.calculateIntersectionOfListOfSets(sets);

        // Then
        assertThat(result).isEmpty();
    }

    @Test
    public void testCalculateIntersectionOfListsOfSets_twoNonemptySetsWithNonemptyIntersection()
    {
        //Given

        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> setB = new HashSet<>(Arrays.asList(2, 3, 4, 5, 6));
        List<Set<Integer>> sets = new ArrayList<>(Arrays.asList(setA, setB));

        Set<Integer> expectedResult = new HashSet<>(Arrays.asList(2, 3, 4, 5));

        SetIntersector<Integer> setOperator = new SetIntersector<>();

        // When
        Set<Integer> result = setOperator.calculateIntersectionOfListOfSets(sets);

        // Then
        assertThat(result).containsExactlyInAnyOrderElementsOf(expectedResult);
    }

    @Test
    public void testCalculateIntersectionOfListsOfSets_twoNonemptySetsWithEmptyIntersection()
    {
        //Given

        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> setB = new HashSet<>(Arrays.asList(6, 7, 8, 9, 10));
        List<Set<Integer>> sets = new ArrayList<>(Arrays.asList(setA, setB));


        SetIntersector<Integer> setOperator = new SetIntersector<>();

        // When
        Set<Integer> result = setOperator.calculateIntersectionOfListOfSets(sets);

        // Then
        assertThat(result).isEmpty();
    }

    @Test
    public void testCalculateIntersectionOfListsOfSets_threeSetsWithOneNull()
    {
        //Given

        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> setB = new HashSet<>(Arrays.asList(6, 7, 8, 9, 10));

        List<Set<Integer>> setsCombination1 = new ArrayList<>(Arrays.asList(setA, setB, null));
        List<Set<Integer>> setsCombination2 = new ArrayList<>(Arrays.asList(setA, null, setB));
        List<Set<Integer>> setsCombination3 = new ArrayList<>(Arrays.asList(null, setA, setB));


        SetIntersector<Integer> setOperator = new SetIntersector<>();

        // When - Then
        assertThat(setOperator.calculateIntersectionOfListOfSets(setsCombination1)).isEmpty();
        assertThat(setOperator.calculateIntersectionOfListOfSets(setsCombination2)).isEmpty();
        assertThat(setOperator.calculateIntersectionOfListOfSets(setsCombination3)).isEmpty();
    }

    @Test
    public void testCalculateIntersectionOfListOfSets_threeSetsWithOneEmpty()
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
        assertThat(setOperator.calculateIntersectionOfListOfSets(setsCombination1)).isEmpty();
        assertThat(setOperator.calculateIntersectionOfListOfSets(setsCombination2)).isEmpty();
        assertThat(setOperator.calculateIntersectionOfListOfSets(setsCombination3)).isEmpty();
    }

    //-----------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------

    // Testfaelle - testCalculateIntersectionOfManySets:
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
    public void testCalculateIntersectionOfManySets_threeNonemptySetsWithNonemptyIntersection()
    {
        //Given

        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> setB = new HashSet<>(Arrays.asList(2, 3, 4, 5, 6));
        Set<Integer> setC = new HashSet<>(Arrays.asList(3, 4, 5, 6, 7));

        Set<Integer> expectedResult = new HashSet<>(Arrays.asList(3, 4, 5));

        SetIntersector<Integer> setOperator = new SetIntersector<>();

        // When
        Set<Integer> result = setOperator.calculateIntersectionOfManySets(setA, setB, setC);

        // Then
        assertThat(result).containsExactlyInAnyOrderElementsOf(expectedResult);
    }

    @Test
    public void testCalculateIntersectionOfManySets_threeNonemptySetsWithEmptyIntersection()
    {
        //Given

        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> setB = new HashSet<>(Arrays.asList(6, 7, 8, 9, 10));
        Set<Integer> setC = new HashSet<>(Arrays.asList(11, 12, 13, 14, 15));


        SetIntersector<Integer> setOperator = new SetIntersector<>();

        // When
        Set<Integer> result = setOperator.calculateIntersectionOfManySets(setA, setB, setC);

        // Then
        assertThat(result).isEmpty();
    }

    @Test
    public void testCalculateIntersectionOfManySets_twoNonemptySetsWithNonemptyIntersection()
    {
        //Given

        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> setB = new HashSet<>(Arrays.asList(2, 3, 4, 5, 6));

        Set<Integer> expectedResult = new HashSet<>(Arrays.asList(2, 3, 4, 5));

        SetIntersector<Integer> setOperator = new SetIntersector<>();

        // When
        Set<Integer> result = setOperator.calculateIntersectionOfManySets(setA, setB);

        // Then
        assertThat(result).containsExactlyInAnyOrderElementsOf(expectedResult);
    }

    @Test
    public void testCalculateIntersectionOfManySets_twoNonemptySetsWithEmptyIntersection()
    {
        //Given

        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> setB = new HashSet<>(Arrays.asList(6, 7, 8, 9, 10));


        SetIntersector<Integer> setOperator = new SetIntersector<>();

        // When
        Set<Integer> result = setOperator.calculateIntersectionOfManySets(setA, setB);

        // Then
        assertThat(result).isEmpty();
    }

    @Test
    public void testCalculateIntersectionOfManySets_oneNonemptySet()
    {
        //Given

        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));


        SetIntersector<Integer> setOperator = new SetIntersector<>();

        // When
        Set<Integer> result = setOperator.calculateIntersectionOfManySets(setA);

        // Then
        assertThat(result).containsExactlyInAnyOrderElementsOf(setA);
    }

    @Test
    public void testCalculateIntersectionOfManySets_oneEmptySet()
    {
        //Given

        Set<Integer> setA = new HashSet<>();


        SetIntersector<Integer> setOperator = new SetIntersector<>();

        // When
        Set<Integer> result = setOperator.calculateIntersectionOfManySets(setA);

        // Then
        assertThat(result).isEmpty();
    }

    @Test
    public void testCalculateIntersectionOfManySets_oneNull()
    {
        SetIntersector<Integer> setOperator = new SetIntersector<>();
        assertThat(setOperator.calculateIntersectionOfManySets(null)).isEmpty();
    }

    @Test
    public void testCalculateIntersectionOfManySets_threeSetsWithOneNull()
    {
        //Given

        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> setB = new HashSet<>(Arrays.asList(6, 7, 8, 9, 10));

        SetIntersector<Integer> setOperator = new SetIntersector<>();

        // When - Then
        assertThat(setOperator.calculateIntersectionOfManySets(setA, setB, null)).isEmpty();
        assertThat(setOperator.calculateIntersectionOfManySets(setA, null, setB)).isEmpty();
        assertThat(setOperator.calculateIntersectionOfManySets(null, setA, setB)).isEmpty();
    }

    @Test
    public void testCalculateIntersectionOfManySets_threeSetsWithOneEmpty()
    {
        //Given

        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> setB = new HashSet<>(Arrays.asList(6, 7, 8, 9, 10));
        Set<Integer> setC = new HashSet<>();

        SetIntersector<Integer> setOperator = new SetIntersector<>();

        // When - Then
        assertThat(setOperator.calculateIntersectionOfManySets(setA, setB, setC)).isEmpty();
        assertThat(setOperator.calculateIntersectionOfManySets(setA, setC, setB)).isEmpty();
        assertThat(setOperator.calculateIntersectionOfManySets(setC, setA, setB)).isEmpty();
    }


    //-----------------------------------------------------------------------------------------------------------------
}