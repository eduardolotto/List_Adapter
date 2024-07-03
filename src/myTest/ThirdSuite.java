package myTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * SUMMARY: With this Test Suite, the remaining methods of myAdapter.ListAdapter, which have been
 * 			left out from AllModOpSuite.java and IteratorSuite.java, are tested to see if they work
 *  		correctly. In particular, the Test Cases considered are TestEquals.java, TestGet.java
 *  		and TestModList.java. More specifically, all the methods tested are hashCode(),
 *  		equals(Object obj), indexOf(Object obj), lastIndexOf(Object obj), get(int index),
 *  		toArray(), toArray(Object[] arrayTarget) and subList(int fromIndex, int toIndex).
 * <P>
 *
 * TEST SUITE DESIGN: This Test Suite includes three Test Cases TestEquals.java, TestGet.java
 *  				  and TestModList.java). They test different types of operations and they are all
 * 					  united under this Test Suite.
 * <P>
 *
 * PRE-CONDITION: all the methods above-mentioned are implemented but not tested.
 * <P>
 *
 * POST-CONDITION: all the methods above-mentioned are tested to work correctly, if the Test Suite
 * 				   does not generate any error or failure.
 * <P>
 *
 * TEST CASES: TestEquals.java, TestGet.java and TestModList.java.
 * <P>
 *
 * TEST SUITE EXECUTION RECORDS: Every test method of every Test Cased worked correctly. The Test Suite
 * 								 did not generate any error or failure.
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ TestEquals.class, TestGet.class, TestModList.class })
public class ThirdSuite {

}