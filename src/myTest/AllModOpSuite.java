package myTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * SUMMARY: With this Test Suite, all modification operations of myAdapter.ListAdapter are tested
 * 			to see if they work correctly. In particular, the Test Cases considered
 * 			are TestBasicModOp.java and TestBulkOp.java. More specifically, all the methods tested are
 * 			add(Object obj), remove(Object obj), contains(Object obj), add(int index, Object obj),
 * 			set(int index, Object obj), remove(int index), addAll(HCollection coll),
 * 			containsAll(HCollection coll), removeAll(HCollection coll), retainAll(HCollection coll),
 * 			addAll(int index, HCollection coll).
 * <P>
 *
 * TEST SUITE DESIGN: This Test Suite includes two Test Cases (TestBasicModOp.java and TestBulkOp.java).
 * 					  They both test a different type of modification operation so they are united
 * 					  under the same Test Suite. Despite contains(Object obj) and containsAll(HCollection coll)
 * 					  are not modification operations, they are very useful to check the changes made by
 * 					  the modification operations above-mentioned. That is the reason why they are included here.
 * 					  Furthermore, some methods from TestBasicModOp.java are used in the implementation of
 * 					  the bulk operations. That is the reason, for example, why in TestBulkOp.java
 * 					  the bulk operations are not tested using collections containing null elements. And that
 * 					  is because that aspect is already tested in TestBasicModOp.java.
 * 	<P>
 *
 * PRE-CONDITION: all the methods above-mentioned are implemented but not tested.
 * <P>
 *
 * POST-CONDITION: all the methods above-mentioned are tested to work correctly, if the Test Suite
 * 				   does not generate any error or failure.
 * <P>
 *
 * TEST CASES: TestBasicModOp.java, TestBulkOp.java.
 * <P>
 *
 * TEST SUITE EXECUTION RECORDS: Every test method of every Test Cased worked correctly. The Test Suite
 * 								 did not generate any error or failure.
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ TestBasicModOp.class, TestBulkOp.class })
public class AllModOpSuite {

}