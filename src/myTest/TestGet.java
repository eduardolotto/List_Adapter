package myTest;

import myAdapter.HIterator;
import myAdapter.HList;
import myAdapter.ListAdapter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * SUMMARY: In this Test Case, the methods indexOf(Object obj), lastIndexOf(Object obj)
 * 			and get(int index) from myAdapter.ListAdapter are tested to see if they work correctly.
 *<P>
 *
 * TEST CASE DESIGN: This Test Case is based on the HList l1, which is initialised before
 * 					 every test method (in the @Before method called setup()) and cleared after them
 * 					 (in the @After method called cleanup()). In every test method, one of the
 * 					 above-mentioned methods are invoked on l1 and they are checked to see if they
 * 					 work correctly. At the beginning of every test method, l1 is filled with
 * 					 the elements contained in static String[] argv, declared and initialised at
 * 					 the beginning of the Test Case. At the end of the class, it also defined a method
 * 					 called iterate: its functionality is to create a string containing the elements of the list.
 *<P>
 *
 * TEST DESCRIPTION: This Test Case checks every aspect of the above-mentioned methods.
 * 					 - In TestIndexOf(), tests this method in every way: when we pass it a valid object,
 * 					 when we pass it an object not contained in the list and when we pass it a null object.
 * 					 - In TestLastIndexOf(), tests this method in every way: when we pass it a valid object,
 * 					 when we pass it an object not contained in the list and when we pass it a null object.
 *                   - It does the same with containsAll(coll), removeAll(coll), retainAll(coll),
 *                   addAll(index, coll) in nullTest2(), nullTest3(), nullTest4() and nullTest5().
 * 					 - TestGet1(), checks if get(index) actually return the element at the specified index.
 * 					 - TestGet2(), checks if get(int index) throws IndexOutOfBoundsException when it has an
 * 					 invalid index as argument.
 *<P>
 *
 * EXPECTED RESULTS: The whole Test Case has to be run completely without any error or failure.
 *
 */
public class TestGet
{
    HList l1 = null;
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
     * SUMMARY: This method checks the correct working of the method indexOf(Object obj). It tests this
     * 			method in every way: when we pass it a valid object, when we pass it an object
     * 			not contained in the list and when we pass it a null object.
     *<P>
     *
     * TEST CASE DESIGN: This method is based on the HList l1, which is initialised before the
     * 					 method (in the @Before method called setup()) and cleared after
     * 					 (in the @After method called cleanup()). At the beginning of the test method,
     * 					 l1 is filled with the elements contained in argv.Then, the size of l1 and its
     * 					 elements are printed out so that its content and the order in which the
     * 					 elements are disposed can be visible.
     *<P>
     *
     * TEST DESCRIPTION: This method checks indexOf(Object obj) in these ways, in order:
     * 					 - indexOf(Object obj) on l1 passing it a valid object.
     * 				     - indexOf(Object obj) on l1 passing it an object not contained in the list.
     * 					 - indexOf(Object obj) on l1 passing it a null object.
     *<P>
     *
     * PRE-CONDITION: In order:
     * 				  - existing and not empty list containing at least one occurrence of obj.
     * 				  - existing and not empty list not containing any occurrence of obj.
     * 				  - existing and not empty list containing at least one occurrence of null.
     *<P>
     *
     * POST-CONDITION: In order:
     * 				   - indexOf(Object obj) returns the correct index of the first occurrence of obj.
     * 				   - indexOf(Object obj) returns -1.
     * 				   - indexOf(Object obj) returns the correct index of the first occurrence of null.
     *<P>
     *
     * EXPECTED RESULTS: The whole method has to be run completely without any error or failure.
     */
    @Test
    public void TestIndexOf()
    {
        System.out.println("Test lastIndexOf(Object obj)");
        for(int i = 0; i < argv.length; i++)
            l1.add(argv[i]);
        System.out.println(l1.size());
        iterate(l1.iterator());

        assertEquals("\n*** lastIndexOf(obj) not working ***\n", 0, l1.indexOf("pippo"));
        assertEquals("\n*** lastIndexOf(obj) not working ***\n", 1, l1.indexOf("qui"));
        l1.remove(1);
        assertEquals("\n*** lastIndexOf(obj) not working ***\n", 3, l1.indexOf("qui"));
        assertEquals("\n*** lastIndexOf(obj) not working ***\n", -1, l1.indexOf("qua"));
        l1.add(null);
        assertEquals("\n*** lastIndexOf(obj) not working ***\n", 5, l1.indexOf(null));
    }

    /**
     * SUMMARY: This method checks the correct working of the method lastIndexOf(Object obj). It tests this
     * 			method in every way: when we pass it a valid object, when we pass it an object
     * 			not contained in the list and when we pass it a null object.
     *<P>
     *
     * TEST CASE DESIGN: This method is based on the HList l1, which is initialised before the
     * 					 method (in the @Before method called setup()) and cleared after
     * 					 (in the @After method called cleanup()). At the beginning of the test method,
     * 					 l1 is filled with the elements contained in argv.Then, the size of l1 and its
     * 					 elements are printed out so that its content and the order in which the
     * 					 elements are disposed can be visible.
     *<P>
     *
     * TEST DESCRIPTION: This method checks lastIndexOf(Object obj) in these ways, in order:
     * 					 - lastIndexOf(Object obj) on l1 passing it a valid object.
     * 				     - lastIndexOf(Object obj) on l1 passing it an object not contained in the list.
     * 					 - lastIndexOf(Object obj) on l1 passing it a null object.
     *<P>
     *
     * PRE-CONDITION: In order:
     * 				  - existing and not empty list containing at least one occurrence of obj.
     * 				  - existing and not empty list not containing any occurrence of obj.
     * 				  - existing and not empty list containing at least one occurrence of null.
     *<P>
     *
     * POST-CONDITION: In order:
     * 				   - lastIndexOf(Object obj) returns the correct index of the first occurrence of obj.
     * 				   - lastIndexOf(Object obj) returns -1.
     * 				   - lastIndexOf(Object obj) returns the correct index of the first occurrence of null.
     *<P>
     *
     * EXPECTED RESULTS: The whole method has to be run completely without any error or failure.
     */
    @Test
    public void TestLastIndexOf()
    {
        System.out.println("Test indexOf(Object obj)");
        for(int i = 0; i < argv.length; i++)
            l1.add(argv[i]);
        System.out.println(l1.size());
        iterate(l1.iterator());

        assertEquals("\n*** indexOf(obj) not working ***\n", 0, l1.lastIndexOf("pippo"));
        assertEquals("\n*** indexOf(obj) not working ***\n", 4, l1.lastIndexOf("qui"));
        l1.remove(4);
        assertEquals("\n*** indexOf(obj) not working ***\n", 1, l1.lastIndexOf("qui"));
        assertEquals("\n*** indexOf(obj) not working ***\n", -1, l1.lastIndexOf("qua"));
        l1.add(null);
        assertEquals("\n*** indexOf(obj) not working ***\n", 5, l1.lastIndexOf(null));
    }

    /**
     * SUMMARY: This method checks the correct working of the method get(int index). So,
     * 			it checks if get(index) actually returns the element at the specified index.
     *<P>
     *
     * TEST CASE DESIGN: This method is based on the HList l1, which is initialised before the
     * 					 method (in the @Before method called setup()) and cleared after
     * 					 (in the @After method called cleanup()). At the beginning of the test method,
     * 					 l1 is filled with the elements contained in argv. Then, the size of l1 and its
     * 					 elements are printed out so that its content and the order in which the
     * 					 elements are disposed can be visible.
     *<P>
     *
     * TEST DESCRIPTION: This method tests get(int index) by passing it some valid indexes and
     * 					 checking if it really returns the object at the specified index in the list.
     *<P>
     *
     * PRE-CONDITION: Existing and not empty list.
     *<P>
     *
     * POST-CONDITION: get(int index) has returned the objects at the specified indexes.
     *<P>
     *
     * EXPECTED RESULTS: The whole method has to be run completely without any error or failure.
     */
    @Test
    public void TestGet1()
    {
        System.out.println("Test get(int index) #1");
        for(int i = 0; i < argv.length; i++)
            l1.add(argv[i]);
        System.out.println(l1.size());
        iterate(l1.iterator());

        assertEquals("\n*** get(index) not working ***\n", "pippo", l1.get(0));
        assertEquals("\n*** get(index) not working ***\n", l1.get(1), l1.get(4));
    }

    /**
     * SUMMARY: This method checks if get(int index) throws IndexOutOfBoundsException when
     * 			it has an invalid index as argument.
     *<P>
     *
     * TEST CASE DESIGN: This method is based on the HList l1, which is initialised before
     * 					 the method (in the @Before method called setup()) and cleared after it
     * 					 (in the @After method called cleanup()). At the beginning of the test
     * 					 method, l2 is filled with the elements contained in argv.
     *<P>
     *
     * TEST DESCRIPTION: This method tests get(int index) by passing it the value returned from indexOf
     * 					 when it has an object not contained in the list as argument. So, it basically tests
     * 					 get(int index) by passing it the int value -1.
     *<P>
     *
     * PRE-CONDITION: Existing and not empty list not containing the object searched by indexOf.
     *<P>
     *
     * POST-CONDITION: IndexOutOfBoundsException has been thrown.
     *<P>
     *
     * EXPECTED RESULTS: The whole method has to be run completely without any error or failure.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void TestGet2()
    {
        System.out.println("Test get(int index) #2");
        for(int i = 0; i < argv.length; i++)
            l1.add(argv[i]);
        System.out.println(l1.size());
        iterate(l1.iterator());

        l1.get(l1.indexOf(null));
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