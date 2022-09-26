package Teil_1.Interface;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetIntersectorTest
{

    // FIXME: Tests schreiben.

    @Test
    public void testExecuteOperationOnTwoSets_twoNonemptySetsWithNonemptyIntersection()
    {
        // Given

        SetIntersector<Integer> setIntersector = new SetIntersector<Integer>();

        Set<Integer> setA = new HashSet<Integer>(Arrays.asList(1,2,3,4,5));
        Set<Integer> setB = new HashSet<Integer>(Arrays.asList(2,3,4,5,6));

        Set<Integer> expectedResult = new HashSet<>(Arrays.asList(2,3,4,5));

        // When

        Set<Integer> result = setIntersector.calculateIntersectionOfTwoSets(setA, setB);

        // Then

        assertThat(result).containsExactlyInAnyOrderElementsOf(expectedResult);

    }

    @Test
    public void testCalculateIntersectionOfTwoSets()
    {
    }

    @Test
    public void testExecuteOperationOnListOfSets()
    {
    }

    @Test
    public void testCalculateIntersectionOfListOfSets()
    {
    }

    @Test
    public void testExecuteOperationOnManySets()
    {
    }

    @Test
    public void testCalculateIntersectionOfManySets()
    {
    }
}