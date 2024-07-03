package myTest;

import myAdapter.*;
import org.junit.*;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * SUMMARY: In this Test Case, the methods toArray(), toArray(Object[] arrayTarget) and
 * 			subList(int fromIndex, int toIndex) myAdapter.ListAdapter are tested to see if they work
 * 			correctly.
 *<P>
 *
 * TEST CASE DESIGN: This Test Case is based on the HList l1, which is initialised before
 * 					 every test method (in the @Before method called setup()) and cleared after them
 * 					 (in the @After method called cleanup()). In every test method, one of the
 * 					 above-mentioned methods are invoked on l1 and, in some methods, when it gets modified,
 * 					 besides checking that the operation works correctly, its size and its elements
 * 					 are printed so that its changes are visible.
 * 					 When it is necessary, at the beginning of the test method, l1 is filled with
 * 					 the elements contained in static String[] argv, declared and initialised at
 * 					 the beginning of the Test Case. In some methods, another HList l2 is employed,
 * 					 which is declared at the beginning of the Test Case. At the end of the class,
 * 					 it also defined a method called iterate: its functionality is to create a string
 * 					 containing the elements of the list.
 *<P>
 *
 * TEST DESCRIPTION: This Test Case checks every aspect of the above-mentioned methods.
 * 					 - In testBacking(), checks if modifying the sublist implies that the modifies are
 *					 also applied on the original list.
 * 					 - In testSubList(), checks that subList really returns a portion of the given list and
 * 					 checks that the sublist is empty if we pass to the method the same value
 *					 both for fromIndex and toIndex.
 * 					 - In testRecursiveSublist(), checks if subList works in a recursive situation.
 * 					 - In testSublistEx1(), checks if subList throws IndexOutOfBoundsException when we pass
 * 					 it a fromIndex that is less than zero.
 *                   - In testSublistEx2(), checks if subList throws IndexOutOfBoundsException when we pass
 *                   it a toIndex that is greater than fatherList.size().
 *                   - In testSublistEx3(), checks if subList throws IndexOutOfBoundsException when we pass
 *                   it a fromIndex that is greater than toIndex, or vice versa.
 *                   - In TestToArray1(), checks if toArray() creates correctly an array containing the elements
 *					 of the list.
 *                   - In TestToArray2(), checks if toArray(Object arrayTarget[]) creates correctly an array
 *                   containing the elements of the list when the specified array's length is bigger or equal
 *                   to the list's size.
 *                   - In TestToArray3(), checks if toArray(Object arrayTarget[]) throws NullPointerException
 *                   when we pass it a null array.
 *                   - In TestToArray4(), checks if toArray(Object arrayTarget[]) throws IllegalArgumentException
 *                   when we pass it an array whose length is smaller than the list's size.
 *<P>
 *
 * EXPECTED RESULTS: The whole Test Case has to be run completely without any error or failure.
 *
 */
public class TestModList
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
     * SUMMARY: This method checks if modifying the sublist implies that the modifies are
     * 			also applied on the original list.
     *<P>
     *
     * TEST CASE DESIGN: This method is based on the HList l1, which is initialised before the
     * 					 method (in the @Before method called setup()) and cleared after
     * 					 (in the @After method called cleanup()). This method is structured in three
     * 					 parts: the first tests the backing adding an element to the sublist, the second
     * 					 removing an element from the sublist while the third does some other tests using
     * 					 the lengths that the lists assumed during the method.
     * 					 At the beginning of the test method, l1 is filled with the elements contained in argv
     * 					 and then its size and elements are printed out so that they are visible. During the
     * 					 method the content of the original list and the sublist is printed so that the
     * 					 development of the backin is visible.
     * 					 The sublist is created from the list l1, and then some operations are done on the
     * 					 sublist (add, remove, clear) and it is checked if also l1 gets modified consequently.
     *<P>
     *
     * TEST DESCRIPTION: This method checks the sublist backing. In order it tests:
     * 					 - backing if an element is added on the sublist.
     * 				     - backing if an element is removed from the sublist.
     * 					 - backing if the sublist is cleared.
     *<P>
     *
     * PRE-CONDITION: In order:
     * 				  - existing and not empty original list and existing and not empty sublist.
     * 				  - existing and not empty original list and existing and not empty sublist.
     * 				  - existing and not empty original list and existing and not empty sublist.
     *<P>
     *
     * POST-CONDITION: In order:
     * 				   - the object is added to l2 and, consequently, also to l1.
     * 				   - the object is removed from l2 and, consequently, also from l1.
     * 				   - l2 is cleared and, consequently, all the elements of l2 have been removed from l1.
     *<P>
     *
     * EXPECTED RESULTS: The whole method has to be run completely without any error or failure.
     */
    @Test
    public void testBacking()
    {
        System.out.println("Test Backing");
        int dl0, dl1, dli, dsl0, dsl1, dsli;
        for(int i=0;i<argv.length;i++)
            l1.add(argv[i]);

        dl0 = l1.size();
        System.out.println(dl0);
        iterate(l1.iterator());

        l2 = l1.subList(0, argv.length/2);
        dsl0 = l2.size();
        System.out.print("Sublist: ");
        iterate(l2.iterator());

        l2.add("pipperissimo");
        dli = l1.size();
        dsli = l2.size();
        System.out.println(dli);
        iterate(l1.iterator());

        assertEquals("\n*** subList add is NOT backed correctly ***\n", dsli, dsl0+1);
        assertEquals("\n*** subList add is NOT backed correctly ***\n", dli, dl0+1);

        l2.remove("pipperissimo");
        assertEquals("\n*** subList remove is NOT backed correctly ***\n", l1.size(), dl0);
        assertEquals("\n*** subList remove is NOT backed correctly ***\n", l2.size(), dsl0);

        l2.clear();
        dl1 = l1.size();
        dsl1 = l2.size();
        System.out.print("List: ");
        iterate(l1.iterator());
        System.out.print("Sublist: ");
        iterate(l2.iterator());

        System.out.println(dl0 + " " + dl1 + " " + dsl0 + " " + dsl1);
        assertEquals("\n*** subList is NOT backed correctly ***\n", dsl0, (dl0/2));
        assertEquals("\n*** subList is NOT backed correctly ***\n", dsl1, 0);
        assertEquals("\n*** subList is NOT backed correctly ***\n", dl1, (dl0 - dsl0));
    }

    /**
     * SUMMARY: This method checks that subList really returns a portion of the given list (l1) and
     * 			checks that the sublist is empty if we pass to the method the same value
     * 			both for fromIndex and for toIndex.
     *<P>
     *
     * TEST CASE DESIGN: This method is based on the HList l1, which is initialised before the
     * 					 method (in the @Before method called setup()) and cleared after
     * 					 (in the @After method called cleanup()). At the beginning of the test method,
     * 					 l1 is filled with the elements contained in argv and then its size and elements are
     * 					 printed out so that they are visible. This method is structured in two parts:
     * 					 in the first a sublist is created from l1 and its content is printed out, in the
     * 					 second an empty sublist is created from l1 and its (empty) content is printed out.
     *<P>
     *
     * TEST DESCRIPTION: This method checks the correct working of subList. In order it tests:
     * 					 - that subList really returns a portion of l1.
     * 				     - that subList returns an empty list if we pass it the same value
     * 					 both for fromIndex and for toIndex.
     *<P>
     *
     * PRE-CONDITION: In order:
     * 				  - existing and not empty original list.
     * 				  - existing and not empty original list.
     *<P>
     *
     * POST-CONDITION: In order:
     * 				   - the sublist l3 is created correctly.
     * 				   - the sublist l4 is actually empty.
     *<P>
     *
     * EXPECTED RESULTS: The whole method has to be run completely without any error or failure.
     */
    @Test
    public void testSubList()
    {
        System.out.println("Test SubList");
        for(int i=0;i<argv.length;i++)
            l1.add(argv[i]);
        System.out.print("List: ");
        iterate(l1.iterator());

        HList l3 = l1.subList(0, argv.length/2);
        System.out.print("Sublist #1: ");
        iterate(l3.iterator());

        assertEquals("\n*** subList not working correctly ***\n", l3.size(), l1.size()/2);

        l3.clear();
        HList l4 = l1.subList(0, 0);
        System.out.print("Sublist #2: ");
        iterate(l4.iterator());

        assertTrue("\n*** subList not working correctly ***\n", l4.isEmpty());
    }

    /**
     * SUMMARY: This method checks if subList works in a recursive situation. So, it fills l1
     *			and then, in a while cycle, it sublists it in a recursive way (so that
     * 			l1 is the father list but also the son list), removing the external elements
     * 			at every iteration.
     *<P>
     *
     * TEST CASE DESIGN: This method is based on the HList l1, which is initialised before the
     * 					 method (in the @Before method called setup()) and cleared after
     * 					 (in the @After method called cleanup()). At the beginning of the test method,
     * 					 l1 is filled three times with the elements contained in argv and each time its size
     * 					 and elements are printed out. This method is structured in two parts:
     * 					 in the first a sublist is created from l1 and its content is printed out, in the
     * 					 second an empty sublist is created from l1 and its (empty) content is printed out.
     * 					 Then, in a while cycle, it sublists it in a recursively (l1 is the original list but
     * 					 also the sublist), removing the external elements at every iteration.
     *<P>
     *
     * TEST DESCRIPTION: This method tests that subList operates well also when it is used recursively.
     *<P>
     *
     * PRE-CONDITION: Existing and not empty original list.
     *<P>
     *
     * POST-CONDITION: l1 gets empty after the recursive sublisting.
     *<P>
     *
     * EXPECTED RESULTS: The whole method has to be run completely without any error or failure.
     */
    @Test
    public void testRecursiveSublist()
    {
        System.out.println("Test Recursive SubListing");
        System.out.println(l1.size());
        assertEquals("List Starts not empty", l1.size(), 0);

        int prev = l1.size();
        for(int i=0;i<argv.length;i++)
            l1.add(argv[i]);
        assertEquals("List add not working correctly", l1.size(), (prev + argv.length));
        System.out.println(l1.size());

        prev = l1.size();
        for(int i=0;i<argv.length;i++)
            l1.add(argv[i]);
        assertEquals("List add not working correctly", l1.size(), (prev + argv.length));
        System.out.println(l1.size());

        prev = l1.size();
        for(int i=0;i<argv.length;i++)
            l1.add(argv[i]);
        assertEquals("List add not working correctly", l1.size(), (prev + argv.length));
        System.out.println(l1.size());
        iterate(l1.iterator());

        int after = 0;
        int count = 0;
        while(l1.size()>=2)
        {
            count++;
            prev = l1.size();
            l1 = l1.subList(1, prev-1);
            after = l1.size();
            System.out.println(after);
            assertEquals("Iterative Sublisting not working at " + count + " iteration", after, (prev-2));
            iterate(l1.iterator());
        }
    }

    /**
     * SUMMARY: This method checks if subList throws IndexOutOfBoundsException when he has a fromIndex &lt; 0
     * 			as argument.
     *<P>
     *
     * TEST CASE DESIGN: This method is based on the HList l1, which is initialised before
     * 					 the method (in the @Before method called setup()) and cleared after it
     * 					 (in the @After method called cleanup()). At the beginning of the test
     * 					 method, l1 is filled with the elements contained in argv.
     *<P>
     *
     * TEST DESCRIPTION: This method tests subList passing it an (fromIndex &lt; 0) and checks if it
     * 					 throws IndexOutOfBoundsException.
     *<P>
     *
     * PRE-CONDITION: Existing and not empty list.
     *<P>
     *
     * POST-CONDITION: IndexOutOfBoundsException has been thrown.
     *<P>
     *
     * EXPECTED RESULTS: The whole method has to be run completely without any error or failure.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testSublistEx1()
    {
        System.out.println("Test SubList Exception #1");
        for(int i=0;i<argv.length;i++)
            l1.add(argv[i]);

        l2 = l1.subList(-1, l1.size());
    }

    /**
     * SUMMARY: This method checks if subList throws IndexOutOfBoundsException when he has a toIndex
     * 			greater than the original list's size as argument.
     *<P>
     *
     * TEST CASE DESIGN: This method is based on the HList l1, which is initialised before
     * 					 the method (in the @Before method called setup()) and cleared after it
     * 					 (in the @After method called cleanup()). At the beginning of the test
     * 					 method, l1 is filled with the elements contained in argv.
     *<P>
     *
     * TEST DESCRIPTION: This method tests subList passing it an (toIndex &lt; l1.size()) and checks if it
     * 					 throws IndexOutOfBoundsException.
     *<P>
     *
     * PRE-CONDITION: Existing and not empty list.
     *<P>
     *
     * POST-CONDITION: IndexOutOfBoundsException has been thrown.
     *<P>
     *
     * EXPECTED RESULTS: The whole method has to be run completely without any error or failure.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testSublistEx2()
    {
        System.out.println("Test SubList Exception #2");
        for(int i=0;i<argv.length;i++)
            l1.add(argv[i]);

        l2 = l1.subList(0, l1.size()+1);
    }

    /**
     * SUMMARY: This method checks if subList throws IndexOutOfBoundsException when he has a
     * 			fromIndex > toIndex as argument, or vice versa.
     *<P>
     *
     * TEST CASE DESIGN: This method is based on the HList l1, which is initialised before
     * 					 the method (in the @Before method called setup()) and cleared after it
     * 					 (in the @After method called cleanup()). At the beginning of the test
     * 					 method, l1 is filled with the elements contained in argv.
     *<P>
     *
     * TEST DESCRIPTION: This method tests subList passing it an (fromIndex > toIndex) and checks if it
     * 					 throws IndexOutOfBoundsException.
     *<P>
     *
     * PRE-CONDITION: Existing and not empty list.
     *<P>
     *
     * POST-CONDITION: IndexOutOfBoundsException has been thrown.
     *<P>
     *
     * EXPECTED RESULTS: The whole method has to be run completely without any error or failure.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testSublistEx3()
    {
        System.out.println("Test SubList Exception #3");
        for(int i=0;i<argv.length;i++)
            l1.add(argv[i]);

        l2 = l1.subList(4, 2);
    }

    /**
     * SUMMARY: This method checks if toArray() creates correctly an array containing the elements
     * 			of the list.
     *<P>
     *
     * TEST CASE DESIGN: This method is based on the HList l1, which is initialised before
     * 					 the method (in the @Before method called setup()) and cleared after it
     * 					 (in the @After method called cleanup()). At the beginning of the test
     * 					 method, l1 is filled with the elements contained in argv. Then toArray()
     * 					 is invoked on l1 and also its content is printed out.
     *<P>
     *
     * TEST DESCRIPTION: This method checks the correct working of toArray(). It tests that
     * 					 the elements of l1 are the same of l1.toArray().
     *<P>
     *
     * PRE-CONDITION: Existing and not empty original list.
     *<P>
     *
     * POST-CONDITION: The array is created correctly.
     *<P>
     *
     * EXPECTED RESULTS: The whole method has to be run completely without any error or failure.
     */
    @Test
    public void TestToArray1()
    {
        System.out.println("Test toArray()");
        for(int i = 0; i < argv.length; i++)
            l1.add(argv[i]);
        System.out.println("List l1:");
        iterate(l1.iterator());

        Object[] l1Array = l1.toArray();
        System.out.println("l1.toArray():");
        System.out.print("{");
        for(int i = 0; i < l1Array.length; i++)
            System.out.print(l1Array[i] + "; ");
        System.out.println("}");

        assertEquals("\n*** toArray() not working ***\n", l1.get(3), l1Array[3]);
    }

    /**
     * SUMMARY: This method checks if toArray(Object arrayTarget[]) creates correctly an array containing the
     * 			elements of the list when the specified array's length is bigger or equal to the list's size.
     *<P>
     *
     * TEST CASE DESIGN: This method is based on the HList l1, which is initialised before
     * 					 the method (in the @Before method called setup()) and cleared after it
     * 					 (in the @After method called cleanup()). At the beginning of the test
     * 					 method, l1 is filled with the elements contained in argv. Then
     * 					 toArray(Object arrayTarget[]) is invoked on l1 and also its content is printed out.
     *<P>
     *
     * TEST DESCRIPTION: This method checks the correct working of toArray(Object arrayTarget[]). It tests that
     * 					 the elements of l1 are the same of l1.toArray(Object arrayTarget[]).
     *<P>
     *
     * PRE-CONDITION: Existing and not empty original list.
     *<P>
     *
     * POST-CONDITION: The array is created correctly.
     *<P>
     *
     * EXPECTED RESULTS: The whole method has to be run completely without any error or failure.
     */
    @Test
    public void TestToArray2()
    {
        System.out.println("Test toArray(Object arrayTarget[]) #1");
        for(int i = 0; i < argv.length; i++)
            l1.add(argv[i]);
        System.out.println("List l1:");
        iterate(l1.iterator());

        Object[] arr = {1, 2, 3, 4, 5, 6};
        arr = l1.toArray(arr);
        System.out.println("l1.toArray(arr):");
        System.out.print("{");
        for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + "; ");
        System.out.println("}");

        assertEquals("\n*** toArray(Object arrayTarget[]) not working ***\n", l1.get(3), arr[3]);
    }

    /**
     * SUMMARY: This method checks if toArray(Object arrayTarget[]) throws NullPointerException when it
     * 			has a null array as argument.
     *<P>
     *
     * TEST CASE DESIGN: This method is based on the HList l1, which is initialised before
     * 					 the method (in the @Before method called setup()) and cleared after it
     * 					 (in the @After method called cleanup()). At the beginning of the test
     * 					 method, l1 is filled with the elements contained in argv.
     *<P>
     *
     * TEST DESCRIPTION: This method tests toArray(Object arrayTarget[]) passing it a null array and checks
     * 					 if it throws NullPointerException.
     *<P>
     *
     * PRE-CONDITION: Existing and not empty list.
     *<P>
     *
     * POST-CONDITION: NullPointerException has been thrown.
     *<P>
     *
     * EXPECTED RESULTS: The whole method has to be run completely without any error or failure.
     */
    @Test(expected = NullPointerException.class)
    public void TestToArray3()
    {
        System.out.println("Test toArray(Object arrayTarget[]) #2");
        for(int i = 0; i < argv.length; i++)
            l1.add(argv[i]);
        Object[] arr = null;
        arr = l1.toArray(arr);
    }

    /**
     * SUMMARY: This method checks if toArray(Object arrayTarget[]) throws IllegalArgumentException when we pass
     * 			it an array whose length is smaller than the list's size.
     *<P>
     *
     * TEST CASE DESIGN: This method is based on the HList l1, which is initialised before
     * 					 the method (in the @Before method called setup()) and cleared after it
     * 					 (in the @After method called cleanup()). At the beginning of the test
     * 					 method, l1 is filled with the elements contained in argv.
     *<P>
     *
     * TEST DESCRIPTION: This method tests toArray(Object arrayTarget[]) passing it an array
     * 					 whose length is smaller than the list's size and checks if it throws
     *                   IllegalArgumentException.
     *<P>
     *
     * PRE-CONDITION: Existing and not empty list.
     *<P>
     *
     * POST-CONDITION: IllegalArgumentException has been thrown.
     *<P>
     *
     * EXPECTED RESULTS: The whole method has to be run completely without any error or failure.
     */
    @Test(expected = IllegalArgumentException.class)
    public void TestToArray4()
    {
        System.out.println("Test toArray(Object arrayTarget[]) #3");
        for(int i = 0; i < argv.length; i++)
            l1.add(argv[i]);
        Object[] arr = {1, 2, 3};
        arr = l1.toArray(arr);
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