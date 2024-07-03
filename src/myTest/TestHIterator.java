package myTest;

import myAdapter.HIterator;
import myAdapter.HList;
import myAdapter.ListAdapter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.NoSuchElementException;
import static org.junit.Assert.*;

/**
 * SUMMARY: In this Test Case, the behaviour of HIterator is tested to see
 * 			if it works correctly. HIterator is the basic iterator for a
 * 			list and it has only three methods which are hasNext(),
 * 			next() and remove(); it also can only be created at the
 * 			beginning of a list, and not at a specified index like HListIterator.
 *<P>
 *
 * TEST CASE DESIGN: TestHIterator is based on the HList l1, which is initialised before
 * 					 every test method (in the @Before method called setup()) and cleared after them
 * 					 (in the @After method called cleanup()). In every test method, the iterator hi (which
 * 					 is declared at the beginning of the Test Case) is created over l1 and one or more
 * 					 methods are invoked on it to see if they work properly. besides checking that the
 * 					 operations work correctly, its size and its elements are printed out so that its changes
 *                   are visible. At the beginning of every test method, l1 is filled with the elements
 *                   contained in static String[] argv, declared and initialised at the beginning of the
 *                   Test Case. In some methods, another HList l4 is employed, which is declared at the
 *                   beginning of the Test Case. At the end of the class, it also defined a method called
 *                   iterate: its functionality is to create a string containing the elements of the list.
 *<P>
 *
 * TEST DESCRIPTION: This Test Case checks every aspect of the above-mentioned methods.
 * 					 - In testHIterator1(), checks if the creation of an HIterator works correctly using
 * 					 hasNext() and next() methods.Then, it also checks if next() throws NoSuchElementException
 * 					 when it's necessary.
 * 					 - In testHIterator2(), checks the correct working of next() and remove().
 *                   - In testRemoveEx1(), testRemoveEx2() and testRemoveEx3(), checks if remove() throws
 *                   IllegalStateException when it is necessary.
 *<P>
 *
 * EXPECTED RESULTS: The whole Test Case has to be run completely without any error or failure.
 *
 */
public class TestHIterator
{
    HList l1 = null;
    HIterator hi = null;
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
        l1.clear();
    }

    /**
     * SUMMARY: This method checks if the creation of an HIterator works correctly using hasNext()
     * 			and next() methods. Firstly using them on a not empty list and secondly on
     * 			an empty list. In this way, it also checks if next() throws NoSuchElementException when
     * 			the condition (!HIterator.hasNext()) happens.
     *<P>
     *
     * TEST CASE DESIGN: This method is based on the HList l1, which is initialised before the
     * 					 method (in the @Before method called setup()) and cleared after
     * 					 (in the @After method called cleanup()).
     * 					 At the beginning of the test method, l1 is filled with the elements contained in argv
     * 					 and then, the size of l1 and its elements are printed out so that they are visible.
     * 					 This method also uses the empty list l2, declared and initialised inside the method.
     *<P>
     *
     * TEST DESCRIPTION: This method, in order, tests:
     * 					 - the constructor of HIterator over a not empty list.
     * 				     - the constructor of HIterator over an empty list.
     * 					 - if next() throws NoSuchElementException when (!HIterator.hasNext()).
     *<P>
     *
     * PRE-CONDITION: In order:
     * 				  - existing and not empty list.
     * 				  - existing and empty list.
     * 				  - existing iterator which does not have a next.
     *<P>
     *
     * POST-CONDITION: In order:
     * 				   - HIterator hi is created correctly at the beginning of the not empty list.
     * 				   - HIterator hi is created correctly at the beginning of the empty list.
     * 				   - next() has thrown NoSuchElementException.
     *<P>
     *
     * EXPECTED RESULTS: The whole method has to be run completely without any error or failure.
     */
    @Test(expected = NoSuchElementException.class)
    public void testHIterator1()
    {
        System.out.println("Test HIterator #1");
        for(int i=0;i<argv.length;i++)
            l1.add(argv[i]);
        System.out.println(l1.size());
        iterate(l1.iterator());

        hi = l1.iterator();
        assertTrue("\n*** HIterator not created correctly ***\n", hi.hasNext());
        assertEquals("\n*** HIterator not created correctly ***\n", "pippo", hi.next());

        HList l2 = new ListAdapter();
        HIterator hi2 = l2.iterator();
        assertFalse("\n*** HIterator not created correctly ***\n", hi2.hasNext());
        hi2.next();
    }

    /**
     * SUMMARY: This method checks the correct working of next() and remove(). It calls repeatedly
     * 			next() and then remove(), until the list gets empty, to see if they do
     * 			the complete scan of the list and the forward removing at the same time.
     *<P>
     *
     * TEST CASE DESIGN: This method is based on the HList l1, which is initialised before the
     * 					 method (in the @Before method called setup()) and cleared after
     * 					 (in the @After method called cleanup()).
     * 					 At the beginning of the test method, l1 is filled with the elements contained in argv
     * 					 and then, the size of l1 and its elements are printed out so that they are visible.
     * 					 Then, in a while cycle, the element return by next() and all the elements of the list
     * 					 are printed out and then the list is decreased with remove at every iteration.
     *<P>
     *
     * TEST DESCRIPTION: This method tests:
     * 					 - if next() manages to do the full scan of the list in a while cycle.
     * 				     - if remove() manages to empty the list in a while cycle (forward removal).
     *<P>
     *
     * PRE-CONDITION: - existing and not empty list.
     * 				  - existing and not empty list.
     *<P>
     *
     * POST-CONDITION: - next() has done the full forward scan of the list.
     * 				   - remove() has done the forward removal of the list.
     *<P>
     *
     * EXPECTED RESULTS: The whole method has to be run completely without any error or failure.
     */
    @Test
    public void testHIterator2()
    {
        System.out.println("Test HIterator #2");
        int dl0, dl1, dl2;
        dl0 = l1.size();
        for(int i=0;i<argv.length;i++)
            l1.add(argv[i]);

        dl1 = l1.size();
        System.out.print(dl1);
        iterate(l1.iterator());
        hi = l1.iterator();
        while(hi.hasNext())
        {
            System.out.print(hi.next() + " ");
            iterate(l1.iterator());
            hi.remove();
        }
        dl2 = l1.size();
        System.out.print(dl2);
        iterate(l1.iterator());

        assertEquals("\n*** Full scan and forward removal not working ***\n", dl1, (dl0+argv.length));
        assertEquals("\n*** Full scan and forward removal not working ***\n", dl2, 0);
    }

    /**
     * SUMMARY: This method checks if remove() throws IllegalStateException when it has not
     * 			been called next() yet, in this case, over a list containing some elements.
     *<P>
     *
     * TEST CASE DESIGN: This method is based on the HList l1, which is initialised before
     * 					 the method (in the @Before method called setup()) and cleared after it
     * 					 (in the @After method called cleanup()). After that l1 has been filled
     * 					 its size and elements are printed out so that they are visible.
     *<P>
     *
     * TEST DESCRIPTION: This method tests remove() by invoking it when the iterator has just been created
     * 					 and next() has not been called yet, to see if it throws IllegalStateException.
     *<P>
     *
     * PRE-CONDITION: Existing and not empty list whose iterator has not done a next() yet.
     *<P>
     *
     * POST-CONDITION: IllegalStateException has been thrown.
     *<P>
     *
     * EXPECTED RESULTS: The whole method has to be run completely without any error or failure.
     */
    @Test(expected = IllegalStateException.class)
    public void testRemoveEx1()
    {
        System.out.println("Test Remove Exception #1");
        hi = l1.iterator();
        for(int i=0;i<argv.length;i++)
            l1.add(argv[i]);
        System.out.print(l1.size());
        iterate(l1.iterator());
        hi.remove();
    }

    /**
     * SUMMARY: This method checks if remove() throws IllegalStateException when it has not
     * 			been called next() yet, in this case, over a empty list.
     *<P>
     *
     * TEST CASE DESIGN: This method is based on the HList l1, which is initialised before
     * 					 the method (in the @Before method called setup()) and cleared after it
     * 					 (in the @After method called cleanup()). Here, l1 is empty..
     *<P>
     *
     * TEST DESCRIPTION: This method tests remove() by invoking it when the iterator has just been created
     * 					 and next() has not been called yet, to see if it throws IllegalStateException.
     *<P>
     *
     * PRE-CONDITION: Existing and empty list whose iterator has not done a next() yet.
     *<P>
     *
     * POST-CONDITION: IllegalStateException has been thrown.
     *<P>
     *
     * EXPECTED RESULTS: The whole method has to be run completely without any error or failure.
     */
    @Test(expected = IllegalStateException.class)
    public void testRemoveEx2()
    {
        System.out.println("Test Remove Exception #2");
        hi = l1.iterator();
        System.out.print(l1.size());
        iterate(l1.iterator());
        hi.remove();
    }

    /**
     * SUMMARY: This method checks if remove() throws IllegalStateException when the last operation
     * 			done by the iterator was another remove().
     *<P>
     *
     * TEST CASE DESIGN: This method is based on the HList l1, which is initialised before
     * 					 the method (in the @Before method called setup()) and cleared after it
     * 					 (in the @After method called cleanup()). After that l1 has been filled
     * 					 its size and elements are printed out so that they are visible.
     *<P>
     *
     * TEST DESCRIPTION: This method tests remove() by invoking it when the iterator has just invoked
     * 					 remove(), to see if it throws IllegalStateException.
     *<P>
     *
     * PRE-CONDITION: Existing and not empty list whose iterator has just invoked remove().
     *<P>
     *
     * POST-CONDITION: IllegalStateException has been thrown.
     *<P>
     *
     * EXPECTED RESULTS: The whole method has to be run completely without any error or failure.
     */
    @Test(expected = IllegalStateException.class)
    public void testRemoveEx3()
    {
        System.out.println("Test Remove Exception #3");
        hi = l1.iterator();
        for(int i=0;i<argv.length;i++)
            l1.add(argv[i]);
        System.out.print(l1.size());
        iterate(l1.iterator());
        System.out.print(hi.next());
        hi.remove();
        hi.remove();
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