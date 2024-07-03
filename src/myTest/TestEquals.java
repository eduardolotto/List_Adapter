package myTest;

import myAdapter.*;
import org.junit.*;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * SUMMARY: In this Test Case, the methods hashCode() and equals(Object obj) from
 * 			myAdapter.ListAdapter are tested to see if they work correctly.
 *<P>
 *
 * TEST CASE DESIGN: This Test Case is based on the HList l1, which is initialised before
 * 					 every test method (in the @Before method called setup()) and cleared after them
 * 					 (in the @After method called cleanup()). In the test methods, one of the
 * 					 above-mentioned methods are invoked on l1 and they are checked to see if they work
 * 					 correctly. When it is necessary, at the beginning of the test method, l1 is filled with
 * 					 the elements contained in static String[] argv, declared and initialised at
 * 					 the beginning of the Test Case. In some methods, another HList l2 is employed,
 * 					 which is declared at the beginning of the Test Case. At the end of the class,
 * 					 it also defined a method called iterate: its functionality is to create a string
 * 					 containing the elements of the list.
 *<P>
 *
 * TEST DESCRIPTION: This Test Case checks every aspect of the above-mentioned methods.
 * 					 - In TestHashCode(), checks if hashCode() gives the same hash code for two identical
 * 					 lists and different hash codes for different lists.
 * 					 - In TestEquals1(), checks if equals(Object obj) returns true if the lists are identical,
 * 					 false if they are different and false if equals is used between a list and an object from
 * 					 another class (in this case, a string). Finally, it does a last test: it checks that
 * 					 equals return true if it is used between an HList and an HCollection which are identical.
 * 					 - In TestEquals2(), checks if equals(obj) throws NullPointerException when we pass it
 * 					 a null object.
 *<P>
 *
 * EXPECTED RESULTS: The whole Test Case has to be run completely without any error or failure.
 *
 */
public class TestEquals
{
    HList l1 = null, l2 = null;
    static String[] argv = {"pippo", "qui", "pluto", "paperino", "qui", "ciccio"};

    /**
     * Method run before every test method. It initialise l1.
     */
    @Before
    public void setup()
    {
        System.out.println("Instantiate an empty List");
        l1 = new ListAdapter();
    }

    /**
     * Method run after every test method. It clears up l1.
     */
    @After
    public void cleanup()
    {
        System.out.println("Purge all remaining elements");
        l1.clear();;
    }

    /**
     * SUMMARY: This method checks if hashCode() works correctly. So, in particular, it checks that
     * 			it gives the same hash code for two identical lists and different hash codes for different lists.
     *<P>
     *
     * TEST CASE DESIGN: This method is based on the HList l1, which is initialised before the
     * 					 method (in the @Before method called setup()) and cleared after
     * 					 (in the @After method called cleanup()). This method is structured in two parts:
     * 					 the first checks that two identical lists have the same hash code while the second
     * 					 checks that adding a null object to one of the lists they, consequently, have a
     * 					 different hash code. The hash codes are also printed out so that they are visible.
     * 					 At the beginning of the test method, both l1 and l2 are filled with the elements
     * 					 contained in argv.
     *<P>
     *
     * TEST DESCRIPTION: This method, in order, tests:
     * 					 - hashCode() between two identical lists.
     * 				     - hashCode() between two lists which differ one from the other only for a null object.
     *<P>
     *
     * PRE-CONDITION: In order:
     * 				  - two existing and identical lists.
     * 				  - two existing and not identical lists.
     *<P>
     *
     * POST-CONDITION: In order:
     * 				   - hashCode() gives the same hash code for both.
     * 				   - hashCode() does not give the same hash code for both.
     *<P>
     *
     * EXPECTED RESULTS: The whole method has to be run completely without any error or failure.
     */
    @Test
    public void TestHashCode()
    {
        System.out.println("Test hashCode()");
        for(int i = 0; i < argv.length; i++)
            l1.add(argv[i]);
        l2 = new ListAdapter();
        for(int i = 0; i < argv.length; i++)
            l2.add(argv[i]);

        System.out.println("List 1: " + l1.hashCode());
        System.out.println("List 2: " + l2.hashCode());

        assertEquals("\n*** hashCode() not working ***\n", l1.hashCode(), l2.hashCode());

        l2.add(null);
        System.out.println("List 1: " + l1.hashCode());
        System.out.println("List 2: " + l2.hashCode());
        assertFalse("\n*** hashCode() not working ***\n", (l1.hashCode() == l2.hashCode()));
    }

    /**
     * SUMMARY: This method checks if equals(Object obj) works correctly. So, in particular, it checks
     * 			that it returns true if the lists are identical, false if they are
     *			different and false if equals is used between a list and an object from
     * 			another class (in this case, a string). Finally, it does another test:
     * 			it checks that equals return true if it is used between an HList and an
     * 			HCollection which are identical.
     *<P>
     *
     * TEST CASE DESIGN: This method is based on the HList l1, which is initialised before the
     * 					 method (in the @Before method called setup()) and cleared after
     * 					 (in the @After method called cleanup()). This method is structured in three parts:
     * 					 the first checks that equals returns true if the lists are identical, the second
     * 					 adds a null object to one of the list and checks that equals returns false, and the
     * 					 third checks that equals return true if it is used between an HList and an
     * 					 HCollection which are identical. l1, l2 and l3 are all filled with the elements
     * 					 contained in argv.
     *<P>
     *
     * TEST DESCRIPTION: This method, in order, tests:
     * 					 - equals(Object obj) between two identical lists.
     * 				     - equals(Object obj) between two lists which differ one from the other only
     * 					 for a null object.
     *                   - equals(Object obj) between a HList and a HCollection, which are identical.
     *<P>
     *
     * PRE-CONDITION: In order:
     * 				  - two existing and identical lists.
     * 				  - two existing and not identical lists.
     *                - a HList and a HCollection which are identical.
     *<P>
     *
     * POST-CONDITION: In order:
     * 				   - equals(Object obj) returns true.
     * 				   - equals(Object obj) returns false.
     * 				   - equals(Object obj) returns true.
     *<P>
     *
     * EXPECTED RESULTS: The whole method has to be run completely without any error or failure.
     */
    @Test
    public void TestEquals1()
    {
        System.out.println("Test equals(Object obj) #1");
        for(int i = 0; i < argv.length; i++)
            l1.add(argv[i]);
        l2 = new ListAdapter();
        for(int i = 0; i < argv.length; i++)
            l2.add(argv[i]);

        assertTrue("\n*** equals(Object obj) not working ***\n", l1.equals(l2));
        l2.add(null);
        assertFalse("\n*** equals(Object obj) not working ***\n", l1.equals(l2));
        String s = "stringa";
        assertFalse("\n*** equals(Object obj) not working ***\n", l1.equals(s));
        HCollection l3 = new ListAdapter();
        for(int i = 0; i < argv.length; i++)
            l3.add(argv[i]);
        assertTrue("\n*** equals(Object obj) not working ***\n", l1.equals(l3));
    }

    /**
     * SUMMARY: This method checks if equals(obj) throws NullPointerException when
     * 			it has a null object as argument.
     *<P>
     *
     * TEST CASE DESIGN: This method is based on the HList l1, which is initialised before
     * 					 the method (in the @Before method called setup()) and cleared after it
     * 					 (in the @After method called cleanup()). It uses l2, a null collection.
     *<P>
     *
     * TEST DESCRIPTION: This method tests equals(obj) passing it a null object and checks if it
     * 					 throws NullPointerException.
     *<P>
     *
     * PRE-CONDITION: Existing and empty list.
     *
     * POST-CONDITION: NullPointerException has been thrown.
     * <P>
     *
     * EXPECTED RESULTS: The whole method has to be run completely without any error or failure.
     */
    @Test(expected = NullPointerException.class)
    public void TestEquals2()
    {
        System.out.println("Test equals(Object obj) #2");

        l1.equals(l2);
    }

    /**
     * Prints out the content of the list.
     *
     * @param iter - iterator of the list.
     */
    public static void iterate(HIterator iter)
    {
        System.out.print("{");
        while(iter.hasNext())
        {
            System.out.print(iter.next() + "; ");
        }
        System.out.println("}");
    }
}