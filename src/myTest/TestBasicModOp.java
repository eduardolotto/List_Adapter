package myTest;

import myAdapter.*;
import org.junit.*;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * SUMMARY: In this Test Case, some modification operations from myAdapter.ListAdapter
 * 			are tested to see if they work correctly. In particular, the methods
 * 			considered are add(Object obj), remove(Object obj), add(int index, Object obj),
 * 			set(int index, Object obj), remove(int index). Also contains(Object obj), which
 * 			is not a modification operation but it is useful to see the modifications made
 * 			by the above-mentioned methods, from myAdapter.ListAdapter, is tested here.
 * <P>
 *
 * TEST CASE DESIGN: This Test Case is based on the HList l1, which is initialised before
 * 					 every test method (in the @Before method called setup()) and cleared after them
 * 					 (in the @After method called cleanup()). In every test method, one or more
 * 					 modification operations methods are invoked on l1 and, when it gets modified,
 * 					 besides checking that the operations work correctly, its size and its elements
 * 					 are printed so that its changes are visible.
 * 					 When it is necessary, at the beginning of the test method, l1 is filled with
 * 					 the elements contained in static String[] argv, declared and initialised at
 * 					 the beginning of the Test Case. In some methods, another HList l2 and a
 * 					 HListIterator are employed; both are declared at the beginning of the Test
 * 					 Case. At the end of the class, it also defined a method called iterate: its
 * 					 functionality is simply to print out the content of the list.
 * <P>
 *
 * TEST DESCRIPTION: This Test Case checks every aspect of the above-mentioned methods.
 * 					 - In TestModOperations1(), tests add(obj), contains(obj) and remove(obj) by
 * 					 passing them a valid string (that could be an element of the list or not) and
 * 				     also passing them a null object. It also tests them on a empty list.
 * 					 - In TestModOperations2(), tests add(index, obj), set(index, obj) and remove(index)
 * 					 by passing them a valid string (that could be an element of the list or not),
 * 					 passing them a valid index, passing them an index that mark the limit of the list
 * 					 (0 and size() for add, size()-1 for set and remove).
 * 					 - In TestModOperations3(), checks if add(index, obj) works correctly also on a empty
 * 					 list and with a null object. It checks if also set(index, obj) works correctly with
 * 					 a null object.
 * 					 - In TestModOperations4(), checks the working of add(index, obj), set(index, obj)
 * 					 and remove(index) when they are used with iteration cycles.
 * 					 - In TestSetEx1() and TestSetEx2(), checks if set(index, obj) throws
 * 					 IndexOutOfBoundsException when the exception condition (index &lt; 0 || index &gt;= size())
 * 					 happens.
 * 					 - In TestRemoveEx1() and TestRemoveEx2(), checks if remove(index) throws
 * 					 IndexOutOfBoundsException when the exception condition (index &lt; 0 || index &gt;= size())
 * 					 happens.
 * 					 - In TestAddEx1() and TestAddEx2(), checks if add(index, obj) throws
 * 					 IndexOutOfBoundsException when the exception condition (index &lt; 0 || index &gt; size())
 * 					 happens.
 * <P>
 *
 * EXPECTED RESULTS: The whole Test Case has to be run completely without any error or failure.
 */
public class TestBasicModOp
{
    HList l1 = null, l2 = null;
    HListIterator li = null;
    static String[] argv = {"pippo", "qui", "pluto", "paperino", "qui", "ciccio"};

    /**
     * Method run before every test method. It initialises l1.
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
     * SUMMARY: This method checks if add(obj), contains(obj) and remove(obj) work correctly.
     * 			It firstly tests them by passing them a valid string (that could
     * 			be an element of the list or not) and secondly passing them a
     * 			null object to see if they work correctly also in this case.
     * 			It also tests them on a empty list.
     * <P>
     *
     * TEST CASE DESIGN: This method is based on the HList l1, which is initialised before the
     * 					 method (in the @Before method called setup()) and cleared after
     * 					 (in the @After method called cleanup()). This method is structured in three
     * 					 parts: the first makes tests on add(obj), the second on contains(obj) (which
     * 					 does not modify l1) and the third on remove(obj). After the first and the third part,
     * 					 the size of l1 and its elements are printed so that its changes are visible.
     * 					 At the beginning of the test method, l1 is filled with the elements contained in argv.					 the beginning of the Test Case. In some methods, another HList l2 and a
     * 					 An empty HList l2 and a HListIterator li are employed: the first to test the
     * 					 methods on a empty list and the iterator to check that the methods work correctly.
     * <P>
     *
     * TEST DESCRIPTION: This method checks the basic aspects of the above-mentioned methods. In order
     * 					 it tests:
     * 					 - add(obj) on l1 filled with argv passing it a valid string.
     * 				     - add(obj) on l1 passing it a null object.
     * 					 - add(obj) on l2 (empty list).
     * 					 - contains(obj) on l1 passing it a string contained in l1.
     * 				     - contains(obj) on l1 passing it a null object.
     * 					 - contains(obj) on l1 passing it a string not contained in l1.
     * 					 - contains(obj) on l2 (empty list).
     * 					 - remove(obj) on l1 passing it a string contained in l1.
     * 					 - remove(obj) on l1 passing it a string not contained in l1.
     * 				     - remove(obj) on l1 passing it a null object.
     * 					 - remove(obj) on l2 (empty list).
     * <P>
     *
     * PRE-CONDITION: In order:
     * 				  - existing and not empty list.
     * 				  - existing and not empty list.
     * 				  - existing and empty list.
     * 				  - existing and not empty list containing one occurrence of the searched object.
     * 				  - existing and not empty list containing one occurrence of the searched object (null).
     * 				  - existing and not empty list not containing any occurrence of the searched object.
     * 				  - existing and empty list.
     * 				  - existing and not empty list containing one occurrence of the searched object.
     * 			      - existing and not empty list not containing any occurrence of the searched object.
     * 				  - existing and not empty list containing one occurrence of the searched object(null).
     * 			      - existing and empty list.
     * <P>
     *
     * POST-CONDITION: In order:
     * 				   - the string is now contained in l1.
     * 				   - the null object is now contained in l1.
     * 				   - l2 is not empty anymore.
     * 				   - contains returns true.
     * 				   - contains returns true.
     * 				   - contains returns false.
     * 				   - contains returns false.
     * 			       - l1 does not contain the string anymore.
     * 			       - remove return false.
     * 				   - l1 does not contain null anymore.
     * 				   - remove return false.
     * <P>
     *
     * EXPECTED RESULTS: The whole method has to be run completely without any error or failure.
     */
    @Test
    public void TestModOperations1()
    {
        System.out.println("Test ModOperations #1");
        li = l1.listIterator();
        l2 = new ListAdapter();
        for(int i = 0; i < argv.length; i++)
            l1.add(argv[i]);
        System.out.println(l1.size());
        iterate(l1.iterator());

        l1.add("nuovo");
        while(li.hasNext())
            li.next();
        assertEquals("\n*** add(obj) not working ***\n", li.previous(), "nuovo");
        li.next();
        l1.add(null);
        assertEquals("\n*** add(null) not working ***\n", li.next(), null);
        l2.add("primo");
        assertFalse("\n*** add(obj) not working ***\n", (l2.size() == 0));
        l2.remove("primo");

        System.out.println(l1.size());
        iterate(l1.iterator());

        assertTrue("\n*** contains(obj) not working ***\n", l1.contains("qui"));
        assertTrue("\n*** contains(null) not working ***\n", l1.contains(null));
        assertFalse("\n*** contains(obj) not working ***\n", l1.contains("quo"));
        assertFalse("\n*** contains(null) not working ***\n", l2.contains(null));

        l1.remove("nuovo");
        assertFalse("\n*** remove(obj) not working ***\n", l1.contains("nuovo"));
        assertFalse("\n*** remove(obj) not working ***\n", l1.remove("nuovo"));
        l1.remove(null);
        assertFalse("\n*** remove(null) not working ***\n", l1.contains(null));
        assertFalse("\n*** remove(obj) not working ***\n", l2.remove(null));

        System.out.println(l1.size());
        iterate(l1.iterator());
    }

    /**
     * SUMMARY: This method checks if add(index, obj), set(index, obj) and remove(index) work correctly.
     *			It tests them by passing them a valid string (that could be an element of the list or not)
     *			and passing them a valid index and index that mark the limit of the list(0 and size() for add,
     *			size()-1 for set and remove).
     * <P>
     *
     * TEST CASE DESIGN: This method is based on the HList l1, which is initialised before
     * 					 the method (in the @Before method called setup()) and cleared after it
     * 					 (in the @After method called cleanup()). This method is structured in three
     * 					 parts: the first makes tests on add(index, obj), the second on set(index, obj),
     * 					 and the third on remove(index).
     * 					 After every change applied on l1, the size of l1 and its elements are printed so
     * 					 that its changes are visible. At the beginning of the test method, l1 is filled with
     * 					 the elements contained in argv.
     * <P>
     *
     * TEST DESCRIPTION: This method checks the basic aspects of the above-mentioned methods. In order
     * 					 it tests:
     * 					 - add(index, obj) on l1 filled with argv passing it two valid strings adding them at the
     * 					 two limits of the list.
     * 				     - add(index, obj) on l1 passing it a valid string adding it in the middle of the list.
     * 					 - that set(index, obj) does not affect the size of the list.
     * 					 - that set(index, obj) actually changes the value of the objects.
     * 					 - remove(index) on l1 passing it valid index.
     * <P>
     *
     * PRE-CONDITION: In order:
     * 				  - existing and not empty list.
     * 				  - existing and not empty list.
     * 				  - existing and not empty list.
     * 				  - existing and not empty list.
     * 				  - existing and not empty list.
     * <P>
     *
     * POST-CONDITION: In order:
     * 				   - the two strings are now contained in l1.
     * 				   - the string is now contained in l1.
     * 				   - the size of l1 has not changed.
     * 				   - l1 contains the new values changed by set and does not contain the old values anymore.
     * 				   - l1 does not contain anymore the elements removed by remove.
     * <P>
     *
     * EXPECTED RESULTS: The whole method has to be run completely without any error or failure.
     */
    @Test
    public void TestModOperations2()
    {
        System.out.println("Test ModOperations #2");
        for(int i = 0; i < argv.length; i++)
            l1.add(argv[i]);
        System.out.println(l1.size());
        iterate(l1.iterator());

        int dl0, dl1;
        dl0 = l1.size();
        l1.add(0, "primo");
        l1.add(l1.size(), "ultimo");
        l1.add((l1.size())/2, "middle");
        System.out.println(l1.size());
        iterate(l1.iterator());
        assertTrue("\n*** add(index, obj) not working ***\n", l1.contains("primo"));
        assertTrue("\n*** add(index, obj) not working ***\n", l1.contains("ultimo"));
        dl1 = l1.size();

        l1.set(1, "modificato");
        l1.set(l1.size()-2, "modificato");
        assertEquals("\n*** set(index, obj) not working ***\n", dl1, l1.size());
        assertTrue("\n*** set(index, obj) not working ***\n", l1.contains("modificato"));
        assertFalse("\n*** set(index, obj) not working ***\n", l1.contains("pippo"));
        System.out.println(l1.size());
        iterate(l1.iterator());

        l1.remove((l1.size())/2);
        l1.remove(1);
        l1.remove(l1.size()-2);
        assertEquals("\n*** remove(index) not working ***\n", dl0, l1.size());
        System.out.println(l1.size());
        iterate(l1.iterator());
    }

    /**
     * SUMMARY: Checks if add(index, obj) on a empty list and with a null object, and
     * 			if also set(index, obj) works correctly with a null object.
     * <P>
     *
     * TEST CASE DESIGN: This method is based on the HList l1, which is initialised before
     * 					 the method (in the @Before method called setup()) and cleared after it
     * 					 (in the @After method called cleanup()). In this case, l1 is empty.
     * <P>
     *
     * TEST DESCRIPTION: In order it tests:
     * 					 - add(index, obj) on l1 (empty) adding a null object.
     * 					 - set(index, obj) with a null object.
     * <P>
     *
     * PRE-CONDITION: In order:
     * 				  - existing and empty list.
     * 				  - existing and not empty list, not containing null.
     * <P>
     *
     * POST-CONDITION: In order:
     * 				   - l1 is not empty anymore and contains null.
     * 				   - l1 now contains null.
     * <P>
     *
     * EXPECTED RESULTS: The whole method has to be run completely without any error or failure.
     */
    public void TestModOperations3()
    {
        System.out.println("Test ModOperations #3");

        l1.add(0, null);
        assertFalse("\n*** add(index, null) not working ***\n", l1.isEmpty());
        assertTrue("\n*** add(index, null) not working ***\n", l1.contains(null));
        l1.set(0, 1);
        l1.set(0, null);
        assertTrue("\n*** set(index, null) not working ***\n", l1.contains(null));
    }

    /**
     * SUMMARY: This method checks the working of add(index, obj), set(index, obj) and remove(index)
     *          with some for cycles.
     * <P>
     *
     * TEST CASE DESIGN: This method is based on the HList l1, which is initialised before
     * 					 the method (in the @Before method called setup()) and cleared after it
     * 					 (in the @After method called cleanup()). This method is structured in three
     * 					 parts: the first makes tests on add(index, obj), the second on set(index, obj),
     * 					 and the third on remove(index).
     * 					 After every change applied on l1, the size of l1 and its elements are printed so
     * 					 that its changes are visible.
     * <P>
     *
     * TEST DESCRIPTION: This method, in order, tests:
     * 					 - add(index, obj) on l1 (empty) filling it with the numbers from 0 to 5.
     * 				     - set(index, obj) on l1 changing his values from 5 to 0.
     * 					 - remove(index) on l1 making it empty.
     * <P>
     *
     * PRE-CONDITION: In order:
     * 				  - existing and empty list.
     * 				  - existing and not empty list.
     * 				  - existing and not empty list.
     * <P>
     *
     * POST-CONDITION: In order:
     * 				   - l1 now contains the numbers from 0 to 5.
     * 				   - l1 now contains the numbers frmo 5 to 0.
     * 				   - l1 is now empty.
     * <P>
     *
     * EXPECTED RESULTS: The whole method has to be run completely without any error or failure.
     */
    @Test
    public void TestModOperations4()
    {
        System.out.println("Test ModOperations #4");
        int dl0, dl1;
        System.out.println(l1.size());
        for(int i = 0; i < 6; i++)
            l1.add(i, i);
        dl0 = l1.size();
        assertEquals("\n*** add(index, obj) not working ***\n", dl0, 6);
        System.out.println(l1.size());
        iterate(l1.iterator());

        for(int i = 0; i < 6; i++)
            l1.set(i, 5-i);
        dl1 = l1.size();
        assertEquals("\n*** set(index, obj) not working ***\n", dl0, dl1);
        System.out.println(l1.size());
        iterate(l1.iterator());

        for(int i = 0; i < 6; i++)
            l1.remove(0);
        assertTrue("\n*** remove(index) not working ***\n", l1.isEmpty());
        System.out.println(l1.size());
        iterate(l1.iterator());

    }

    /**
     * SUMMARY: This method checks if set(index, obj) throws IndexOutOfBoundsException when
     * 			the exception condition (index &lt; 0) happens.
     * <P>
     *
     * TEST CASE DESIGN: This method is based on the HList l1, which is initialised before
     * 					 the method (in the @Before method called setup()) and cleared after it
     * 					 (in the @After method called cleanup()). At the beginning of the test
     * 					 method, l1 is filled with the elements contained in argv.
     * <P>
     *
     * TEST DESCRIPTION: This method tests set(index, obj) passing it an index&lt;0 and checks if it
     * 					 throws IndexOutOfBoundsException.
     * <P>
     *
     * PRE-CONDITION: Existing and notempty list.
     * <P>
     *
     * POST-CONDITION: IndexOutOfBoundsException has been thrown.
     * <P>
     *
     * EXPECTED RESULTS: The whole method has to be run completely without any error or failure.
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void TestSetEx1()
    {
        System.out.println("Test Set Exception #1");
        for(int i = 0; i < argv.length; i++)
            l1.add(argv[i]);
        l1.set(-1, null);
    }

    /**
     * SUMMARY: This method checks if set(index, obj) throws IndexOutOfBoundsException when
     * 			the exception condition (index >= size()) happens.
     * <P>
     *
     * TEST CASE DESIGN: This method is based on the HList l1, which is initialised before
     * 					 the method (in the @Before method called setup()) and cleared after it
     * 					 (in the @After method called cleanup()). At the beginning of the test
     * 					 method, l1 is filled with the elements contained in argv.
     * <P>
     *
     * TEST DESCRIPTION: This method tests set(index, obj) passing it an index>=size() and checks if it
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
    @Test (expected = IndexOutOfBoundsException.class)
    public void TestSetEx2()
    {
        System.out.println("Test Set Exception #2");
        for(int i = 0; i < argv.length; i++)
            l1.add(argv[i]);
        l1.set(l1.size(), null);
    }

    /**
     * SUMMARY: This method checks if remove(index) throws IndexOutOfBoundsException when
     * 			the exception condition (index &lt; 0) happens.
     * <P>
     *
     * TEST CASE DESIGN: This method is based on the HList l1, which is initialised before
     * 					 the method (in the @Before method called setup()) and cleared after it
     * 					 (in the @After method called cleanup()). At the beginning of the test
     * 					 method, l1 is filled with the elements contained in argv.
     * <P>
     *
     * TEST DESCRIPTION: This method tests remove(index) passing it an index&lt;0 and checks if it
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
    @Test (expected = IndexOutOfBoundsException.class)
    public void TestRemoveEx1()
    {
        System.out.println("Test Remove Exception #1");
        for(int i = 0; i < argv.length; i++)
            l1.add(argv[i]);
        l1.remove(-1);
    }

    /**
     * SUMMARY: This method checks if remove(index) throws IndexOutOfBoundsException when
     * 			the exception condition (index >= size()) happens.
     * <P>
     *
     * TEST CASE DESIGN: This method is based on the HList l1, which is initialised before
     * 					 the method (in the @Before method called setup()) and cleared after it
     * 					 (in the @After method called cleanup()). At the beginning of the test
     * 					 method, l1 is filled with the elements contained in argv.
     * <P>
     *
     * TEST DESCRIPTION: This method tests remove(index) passing it an index>=size() and checks if it
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
    @Test (expected = IndexOutOfBoundsException.class)
    public void TestRemoveEx2()
    {
        System.out.println("Test Remove Exception #2");
        for(int i = 0; i < argv.length; i++)
            l1.add(argv[i]);
        l1.remove(l1.size());
    }

    /**
     * SUMMARY: This method checks if add(index, obj) throws IndexOutOfBoundsException when
     * 			the exception condition (index &lt; 0) happens.
     * <P>
     *
     * TEST CASE DESIGN: This method is based on the HList l1, which is initialised before
     * 					 the method (in the @Before method called setup()) and cleared after it
     * 					 (in the @After method called cleanup()). At the beginning of the test
     * 					 method, l1 is filled with the elements contained in argv.
     * <P>
     *
     * TEST DESCRIPTION: This method tests add(index, obj) passing it an index&lt;0 and checks if it
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
    @Test (expected = IndexOutOfBoundsException.class)
    public void TestAddEx1()
    {
        System.out.println("Test Ass Exception #1");
        for(int i = 0; i < argv.length; i++)
            l1.add(argv[i]);
        l1.add(-1, null);
    }

    /**
     * SUMMARY: This method checks if add(index, obj) throws IndexOutOfBoundsException when
     * 			the exception condition (index > size()) happens.
     * <P>
     *
     * TEST CASE DESIGN: This method is based on the HList l1, which is initialised before
     * 					 the method (in the @Before method called setup()) and cleared after it
     * 					 (in the @After method called cleanup()). At the beginning of the test
     * 					 method, l1 is filled with the elements contained in argv.
     * <P>
     *
     * TEST DESCRIPTION: This method tests add(index, obj) passing it an index>size() and checks if it
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
    @Test (expected = IndexOutOfBoundsException.class)
    public void TestAddEx2()
    {
        System.out.println("Test Add Exception #2");
        for(int i = 0; i < argv.length; i++)
            l1.add(argv[i]);
        l1.set(l1.size()+1, null);
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