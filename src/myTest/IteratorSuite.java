package myTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * SUMMARY: With this Test Suite, all the operations of IteratorClass are tested
 * 			to see if they work correctly. In particular, the Test Cases considered
 * 			are TestHIterator.java and TestHListIterator.java. More specifically, all the methods
 * 			tested are hasNext(), next(), remove(), hasPrevious(), previous, nextIndex(),
 * 			previousIndex(), set(Object obj) and add(Object obj).
 * <P>
 *
 * TEST SUITE DESIGN: This Test Suite includes two Test Cases (TestHIterator.java and TestHListIterator.java).
 * 					  They both test a different type of iterator so they are united
 * 					  under the same Test Suite. The first iterator is HIterator: the basic iterator for a
 * 					  list, it has only three methods which are hasNext(), next() and remove();
 * 					  it also can only be created at the beginning of a list, and not at a specified index like
 * 					  HListIterator. The second iterator is HListIterator: the advanced iterator for a
 * 					  list. It can go forward and backward, it has more methods like hasPrevious(), previous(),
 * 					  nextIndex(), previousIndex(), set(Object obj) and add(Object obj); it also can also be
 * 					  created at the at a specified index, not only at the beginning.
 * 					  Obviously, in HIterator there are only the tests for the three methods it has while
 * 					  in HListIterator there are the test for the methods which are exclusive of this type
 * 					  of iterator.
 * <P>
 *
 * PRE-CONDITION: all the methods above-mentioned are implemented but not tested.
 * <P>
 *
 * POST-CONDITION: all the methods above-mentioned are tested to work correctly, if the Test Suite
 * 				   does not generate any error or failure.
 * <P>
 *
 * TEST CASES: TestHIterator.java, TestHListIterator.java.
 * <P>
 *
 * TEST SUITE EXECUTION RECORDS: Every test method of every Test Cased worked correctly. The Test Suite
 * 								 did not generate any error or failure.
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ TestHIterator.class, TestHListIterator.class })
public class IteratorSuite {

}