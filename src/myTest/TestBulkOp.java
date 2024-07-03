package myTest;

import myAdapter.*;
import org.junit.*;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * SUMMARY: In this Test Case, all the bulk operations from myAdapter.ListAdapter
 * 			are tested to see if they work correctly. In particular, the methods
 * 			considered are addAll(HCollection coll), containsAll(HCollection coll),
 * 			removeAll(HCollection coll), retainAll(HCollection coll),
 * 			addAll(int index, HCollection coll).
 * <P>
 *
 * TEST CASE DESIGN: This Test Case is based on the HList l1, which is initialised before
 * 					 every test method (in the @Before method called setup()) and cleared after them
 * 					 (in the @After method called cleanup()). In every test method, one or more
 * 					 bulk operations methods are invoked on l1 and, when it gets modified,
 * 					 besides checking that the operations work correctly, its size and its elements
 * 					 are printed so that its changes are visible.
 * 					 When it is necessary, at the beginning of the test method, l1 is filled with
 * 					 the elements contained in static String[] argv, declared and initialised at
 * 					 the beginning of the Test Case. In some methods, another HList l4 is employed,
 * 					 which is declared at the beginning of the Test Case. At the end of the class,
 * 					 it also defined a method called iterate: its functionality is to create a string
 * 					 containing the elements of the list.
 * <P>
 *
 * TEST DESCRIPTION: This Test Case checks every aspect of the above-mentioned methods.
 * 					 - In returnTest(), checks if the bulk operations methods, which all return a boolean
 * 					 value, correctly return true or false. addAll(coll) and addAll(index, coll) are tested
 * 					 passing them a collection containing some elements (eturn true) and passing them an
 * 					 empty (not null) collection (return false). containsAll(coll) is tested passing it a
 * 					 collection whose elements are all contained in l1 (return true) and passing it a collection
 * 					 that contains an element that l1 does not contain (return false). removeAll(coll) is tested
 * 					 passing it a collection that has elements contained also in l1 (return true), passing it
 * 					 a collection that does not contain any element that l1 contains (return false) and finally
 * 				     passing it an empty (not null) collection (return false). retainAll(coll) is tested passing
 * 					 it a collection that has only some elements contained also in l1 (return true), passing it
 * 					 a collection that contains only elements that also l1 contains (return false), and finally
 * 					 passing it an empty (not null) collection (return false).
 * 					 - In nullTest1(), checks if addAll(coll) throws NullPointerException when it has a null
 * 					 collection as argument.
 *                   - It does the same with containsAll(coll), removeAll(coll), retainAll(coll),
 *                   addAll(index, coll) in nullTest2(), nullTest3(), nullTest4() and nullTest5().
 * 					 - In boundsTest1() and boundsTest2(), checks if addAll(int index, HCollection coll) throws
 *					 IndexOutOfBoundsException when it has an index &gt; size() or index &lt; 0 as argument.
 * <P>
 *
 * EXPECTED RESULTS: The whole Test Case has to be run completely without any error or failure.
 *
 */
public class TestBulkOp
{
    HList l1 = null, l4 = null;
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
     * SUMMARY: This method checks if the bulk operations methods, which all return a boolean value,
     * 			correctly return true or false.
     * <P>
     *
     * TEST CASE DESIGN: This method is based on the HList l1, which is initialised before the
     * 					 method (in the @Before method called setup()) and cleared after
     * 					 (in the @After method called cleanup()). This method is structured in five
     * 					 parts: the first makes tests on addAll(coll), the second on containsAll(coll) (which
     * 					 does not modify l1), the third on removeAll(coll), the fourth on addAll(index, coll)
     * 					 and the fifth on retainAll(coll). After every change applied on l1, its size and its
     * 					 elements are printed out so that its changes are visible.
     * 					 At the beginning of the test method, l2 is filled with the elements contained in argv.
     * 					 Another two HList (l2 and l3) are employed.
     * <P>
     *
     * TEST DESCRIPTION: This method checks the basic aspects of the above-mentioned methods. In order
     * 					 it tests:
     * 					 - addAll(coll) on l1 passing it l2.
     * 				     - addAll(coll) on l1 passing it l3 (empty).
     * 					 - containsAll(coll) on l1 passing it l2 (true case).
     * 				     - containsAll(coll) on l1 passing it l2 (false case).
     * 					 - removeAll(coll) on l1 passing it l2 (true case).
     * 				     - removeAll(coll) on l1 passing it l2 (false case).
     * 					 - removeAll(coll) on l1 passing it l3 (empty).
     * 					 - addAll(coll) on l1 passing it l2.
     * 				     - addAll(index, coll) on l1 passing it l3 (empty).
     * 					 - retainAll(coll) on l1 passing it l2 (true case).
     * 					 - removeAll(coll) on l1 passing it l2 (false case).
     * 					 - removeAll(coll) on l1 passing it l3 (empty).
     * <P>
     *
     * PRE-CONDITION: In order:
     * 				  - existing and empty list.
     * 				  - existing and not empty list.
     * 				  - existing and empty list.
     * 				  - existing and not empty list, l2 contains only elements contained also in l1.
     * 				  - existing and not empty list, l2 contains also elements not contained in l1.
     * 				  - existing and not empty list, l2 contains only elements contained also in l1.
     * 				  - existing and not empty list, l2 does not have elements contained in l1.
     * 				  - existing and not empty list.
     * 			      - existing and not empty list.
     * 				  - existing and not empty list.
     * 			      - existing and not empty list, l2 contains also elements not contained in l1.
     * 				  - existing and not empty list, l2 contains only elements contained also in l1.
     * 				  - existing and not empty list.
     * <P>
     *
     * POST-CONDITION: In order:
     * 				   - l1 results modified and it is not empty anymore.
     * 				   - l1 results not modified.
     * 				   - containsAll returns true.
     * 				   - containsAll returns false.
     * 				   - contains returns true.
     * 				   - removeAll returns true.
     * 				   - removeAll returns false.
     * 			       - removeAll returns false.
     * 			       - l1 results modified.
     * 				   - l1 results not modified.
     * 				   - retainAll returns true.
     * 				   - retainAll returns false.
     * 			       - retainAll returns false.
     * <P>
     *
     * EXPECTED RESULTS: The whole method has to be run completely without any error or failure.
     */
    @Test
    public void returnTest()
    {
        System.out.println("ReturnTest Bulk Operations");
        assertEquals("\n*** List starts not empty ***\n", l1.size(), 0);
        System.out.println(l1.size());

        HList l2 = new ListAdapter();
        HList l3 = new ListAdapter();
        for(int i = 0; i < argv.length; i++)
            l2.add(argv[i]);

        //addAll(coll) return testing
        assertTrue("\n*** List results not modified ***\n", l1.addAll(l2));
        assertFalse("\n*** List results not modified ***\n", l1.isEmpty());
        System.out.println(l1.size());
        System.out.println(iterate(l1.iterator()));
        assertFalse("\n*** List results modified ***\n", l1.addAll(l3));
        System.out.println(l1.size());
        System.out.println(iterate(l1.iterator()));

        //containsAll(coll) return testing
        assertTrue("\n*** ContainsAll method should return true ***\n", l1.containsAll(l2));
        l2.add("topolino");
        assertFalse("\n*** ContainsAll method should return false ***\n", l1.containsAll(l2));

        //removeAll(coll) return testing
        l2.clear();
        l2.add("qui");
        l2.add("ciccio");
        assertTrue("\n*** List results not modified ***\n", l1.removeAll(l2));
        System.out.println(l1.size());
        System.out.println(iterate(l1.iterator()));
        assertFalse("\n*** List results modified ***\n", l1.removeAll(l2));
        assertFalse("\n*** List results modified ***\n", l1.removeAll(l3));
        System.out.println(l1.size());
        System.out.println(iterate(l1.iterator()));

        //addAll(index, coll) return testing
        assertTrue("\n*** List results not modified ***\n", l1.addAll(1, l2));
        System.out.println(l1.size());
        System.out.println(iterate(l1.iterator()));
        assertFalse("\n*** List results modified ***\n", l1.addAll(2, l3));
        System.out.println(l1.size());
        System.out.println(iterate(l1.iterator()));

        //retainAll(coll) return testing
        assertTrue("\n*** List results not modified ***\n", l1.retainAll(l2));
        System.out.println(l1.size());
        System.out.println(iterate(l1.iterator()));
        assertFalse("\n*** List results modified ***\n", l1.retainAll(l2));
        assertFalse("\n*** List results modified ***\n", l1.retainAll(l3));
        System.out.println(l1.size());
        System.out.println(iterate(l1.iterator()));
    }

    /**
     * SUMMARY: This method checks if addAll(coll) throws NullPointerException when
     * 			it has a null collection as argument.
     * <P>
     *
     * TEST CASE DESIGN: This method is based on the HList l1, which is initialised before
     * 					 the method (in the @Before method called setup()) and cleared after it
     * 					 (in the @After method called cleanup()). It uses l4, a null collection.
     * <P>
     *
     * TEST DESCRIPTION: This method tests addAll(coll) passing it a null collection and checks if it
     * 					 throws NullPointerException.
     * <P>
     *
     * PRE-CONDITION: Existing and empty list.
     * <P>
     *
     * POST-CONDITION: NullPointerException has been thrown.
     * <P>
     *
     * EXPECTED RESULTS: The whole method has to be run completely without any error or failure.
     */
    @Test(expected = NullPointerException.class)
    public void nullTest1()
    {
        System.out.println("Testing addAll(null)");
        l1.addAll(l4);
    }

    /**
     * SUMMARY: This method checks if containsAll(coll) throws NullPointerException when
     * 			it has a null collection as argument.
     * <P>
     *
     * TEST CASE DESIGN: This method is based on the HList l1, which is initialised before
     * 					 the method (in the @Before method called setup()) and cleared after it
     * 					 (in the @After method called cleanup()). It uses l4, a null collection.
     * <P>
     *
     * TEST DESCRIPTION: This method tests containsAll(coll) passing it a null collection and checks if it
     * 					 throws NullPointerException.
     * <P>
     *
     * PRE-CONDITION: Existing and empty list.
     * <P>
     *
     * POST-CONDITION: NullPointerException has been thrown.
     * <P>
     *
     * EXPECTED RESULTS: The whole method has to be run completely without any error or failure.
     */
    @Test(expected = NullPointerException.class)
    public void nullTest2()
    {
        System.out.println("Testing containsAll(null)");
        l1.containsAll(l4);
    }

    /**
     * SUMMARY: This method checks if removeAll(coll) throws NullPointerException when
     * 			it has a null collection as argument.
     * <P>
     *
     * TEST CASE DESIGN: This method is based on the HList l1, which is initialised before
     * 					 the method (in the @Before method called setup()) and cleared after it
     * 					 (in the @After method called cleanup()). It uses l4, a null collection.
     * <P>
     *
     * TEST DESCRIPTION: This method tests removeAll(coll) passing it a null collection and checks if it
     * 					 throws NullPointerException.
     * <P>
     *
     * PRE-CONDITION: Existing and empty list.
     * <P>
     *
     * POST-CONDITION: NullPointerException has been thrown.
     * <P>
     *
     * EXPECTED RESULTS: The whole method has to be run completely without any error or failure.
     */
    @Test(expected = NullPointerException.class)
    public void nullTest3()
    {
        System.out.println("Testing removeAll(null)");
        l1.removeAll(l4);
    }

    /**
     * SUMMARY: This method checks if retainAll(coll) throws NullPointerException when
     * 			it has a null collection as argument.
     * <P>
     *
     * TEST CASE DESIGN: This method is based on the HList l1, which is initialised before
     * 					 the method (in the @Before method called setup()) and cleared after it
     * 					 (in the @After method called cleanup()). It uses l4, a null collection.
     * <P>
     *
     * TEST DESCRIPTION: This method tests retainAll(coll) passing it a null collection and checks if it
     * 					 throws NullPointerException.
     * <P>
     *
     * PRE-CONDITION: Existing and empty list.
     * <P>
     *
     * POST-CONDITION: NullPointerException has been thrown.
     * <P>
     *
     * EXPECTED RESULTS: The whole method has to be run completely without any error or failure.
     */
    @Test(expected = NullPointerException.class)
    public void nullTest4()
    {
        System.out.println("Testing retainAll(null)");
        l1.retainAll(l4);
    }

    /**
     * SUMMARY: This method checks if addAll(index, coll) throws NullPointerException when
     * 			it has a null collection as argument.
     * <P>
     *
     * TEST CASE DESIGN: This method is based on the HList l1, which is initialised before
     * 					 the method (in the @Before method called setup()) and cleared after it
     * 					 (in the @After method called cleanup()). It uses l4, a null collection.
     * <P>
     *
     * TEST DESCRIPTION: This method tests addAll(index, coll) passing it a null collection and checks if it
     * 					 throws NullPointerException.
     * <P>
     *
     * PRE-CONDITION: Existing and empty list.
     * <P>
     *
     * POST-CONDITION: NullPointerException has been thrown.
     * <P>
     *
     * EXPECTED RESULTS: The whole method has to be run completely without any error or failure.
     */
    @Test(expected = NullPointerException.class)
    public void nullTest5()
    {
        System.out.println("Testing addAll(index, null)");
        l1.addAll(0, l4);
    }

    /**
     * SUMMARY: This method checks if addAll(index, coll) throws IndexOutOfBoundsException when
     * 			the exception condition (index > size()) happens.
     * <P>
     *
     * TEST CASE DESIGN: This method is based on the HList l1, which is initialised before
     * 					 the method (in the @Before method called setup()) and cleared after it
     * 					 (in the @After method called cleanup()). At the beginning of the test
     * 					 method, l2 is filled with the elements contained in argv.
     * <P>
     *
     * TEST DESCRIPTION: This method tests addAll(index, coll) passing it an index>size() and checks if it
     * 					 throws IndexOutOfBoundsException.
     * <P>
     *
     * PRE-CONDITION: Existing and not empty list.
     * <P>
     *
     * POST-CONDITION: IndexOutOfBoundsException has been thrown.
     * <P>
     *
     * EXPECTED RESULTS: The whole method has to be run completely without any error or failure.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void boundsTest1()
    {
        System.out.println("Testing addAll(index>size(), coll)");
        l1.add("quo");
        l1.add("ciao");
        HList l2 = new ListAdapter();
        for(int i = 0; i < argv.length; i++)
            l2.add(argv[i]);
        l1.addAll(l1.size()+1, l2);
    }

    /**
     * SUMMARY: This method checks if addAll(index, coll) throws IndexOutOfBoundsException when
     * 			the exception condition (index &lt; 0) happens.
     * <P>
     *
     * TEST CASE DESIGN: This method is based on the HList l1, which is initialised before
     * 					 the method (in the @Before method called setup()) and cleared after it
     * 					 (in the @After method called cleanup()). At the beginning of the test
     * 					 method, l2 is filled with the elements contained in argv.
     * <P>
     *
     * TEST DESCRIPTION: This method tests addAll(index, coll) passing it an index&lt;0 and checks if it
     * 					 throws IndexOutOfBoundsException.
     * <P>
     *
     * PRE-CONDITION: Existing and not empty list.
     * <P>
     *
     * POST-CONDITION: IndexOutOfBoundsException has been thrown.
     * <P>
     *
     * EXPECTED RESULTS: The whole method has to be run completely without any error or failure.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void boundsTest2()
    {
        System.out.println("Testing addAll(index<0, coll)");
        l1.add("quo");
        l1.add("ciao");
        HList l2 = new ListAdapter();
        for(int i = 0; i < argv.length; i++)
            l2.add(argv[i]);
        l1.addAll(-1, l2);
    }

    /**
     * Generates a string containing the content of the list.
     *
     * @return a string containing the elements of the list.
     * @param iter - iterator of the list.
     */
    public static String iterate(HIterator iter)
    {
        String s = "List l1 contains: {";
        while(iter.hasNext())
            s += iter.next() + "; ";

        s += "}";
        return s;
    }
}