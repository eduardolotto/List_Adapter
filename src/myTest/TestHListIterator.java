package myTest;

import myAdapter.HIterator;
import myAdapter.HList;
import myAdapter.HListIterator;
import myAdapter.ListAdapter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.NoSuchElementException;
import static org.junit.Assert.*;

/**
 * SUMMARY: In this Test Case, the behaviour of HListIterator is tested to see
 * 			if it works correctly. HListIterator is the advanced iterator for a
 * 			list. It can go forward and backward (while HIterator can only go
 * 			forward) and it has more methods than HIterator. In particular,
 * 			it also has hasPrevious(), previous(), nextIndex(), previousIndex(),
 * 			set(Object obj) and add(Object obj); it also can also be created at the
 * 			at a specified index, while HIterator can not.
 *<P>
 *
 * TEST CASE DESIGN: TestHListIterator is based on the HList l1, which is initialised before
 * 					 every test method (in the @Before method called setup()) and cleared after them
 * 					 (in the @After method called cleanup()). In every test method, the listIterator li
 * 					 (which is declared at the beginning of the Test Case) is created over l1 and one or
 * 					 more methods are invoked on it to see if they work properly. Besides checking that the
 * 					 operations work correctly, its size and its elements are printed out so that its changes
 *                   are visible. At the beginning of almost every test method, l1 is filled with the elements
 *                   contained in static String[] argv, declared and initialised at the beginning of the
 *                   Test Case. At the end of the class, it also defined a method called
 *                   iterate: its functionality is to create a string containing the elements of the list.
 *<P>
 *
 * TEST DESCRIPTION: This Test Case checks every aspect of the above-mentioned methods.
 * 					 - In testHIterator1(), checks if the creation of an HListIterator at a specified index
 * 					 works correctly using hasNext(), hasPrevious() and previous() methods.
 * 					 - In testHListIterator2(), checks the correct working of previous() and remove().
 *                   - In testHListIterator3(), checks if previousIndex() and nextIndex() work properly.
 *                   - In testHListIterator3(), checks if previousIndex() and nextIndex() work properly.
 *                   - In testHListIterator4(), checks if set(Object obj) works properly.
 *                   - In testHListIterator5(), checks if set(Object obj) works properly while doing a full
 *                   forward and backward scan of the list.
 *                   - In testSetEx1(), checks if set(obj) throws IllegalStateException when the
 * 					 listIterator hasn't made any next() or previous() yet.
 *                   - In testSetEx2(), checks if set(obj) throws IllegalStateException when the last
 * 					 operation done by the listIterator was remove().
 *
 *                   In this Test Case, next() and the default constructor aren't clearly
 * 					 tested because they are already in the Test Case TestHIterator. Two
 * 					 parts of remove() aren't tested for the same reason too: the throwing
 * 					 of IllegalStateException and the forward removal.
 *<P>
 *
 * EXPECTED RESULTS: The whole Test Case has to be run completely without any error or failure.
 *
 */
public class TestHListIterator
{
    HList l1 = null;
    HListIterator li = null;
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
     * SUMMARY: This method checks if the creation of an HListIterator at a specified index works correctly
     * 			using hasNext(), hasPrevious() and previous() methods.
     * 			Firstly using them on a not empty list and secondly on a empty list. In this way,
     * 			it also checks if previous() throws NoSuchElementException when the condition
     * 			(!HListIterator.hasPrevious()).
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
     * 					 - the constructor of HListIterator over a not empty list.
     * 				     - the constructor of HListIterator over an empty list.
     * 					 - if previous() throws NoSuchElementException when (!HListIterator.hasPrevious()).
     *<P>
     *
     * PRE-CONDITION: In order:
     * 				  - existing and not empty list.
     * 				  - existing and empty list.
     * 				  - existing listIterator which does not have a previous.
     *<P>
     *
     * POST-CONDITION: In order:
     * 				   - HListIterator li is created correctly at the specified index of the not empty list.
     * 				   - HListIterator li is created correctly at the beginning of the empty list.
     * 				   - previous() has thrown NoSuchElementException.
     *<P>
     *
     * EXPECTED RESULTS: The whole method has to be run completely without any error or failure.
     */
    @Test(expected = NoSuchElementException.class)
    public void testHListIterator1()
    {
        System.out.println("Test HListIterator #1");
        for(int i=0;i<argv.length;i++)
            l1.add(argv[i]);

        System.out.println(l1.size());
        iterate(l1.iterator());

        li = l1.listIterator(1);
        assertTrue("\n*** HIterator not created correctly ***\n", li.hasPrevious());
        assertEquals("\n*** HIterator not created correctly ***\n", "pippo", li.previous());
        assertFalse("\n*** HIterator not created correctly ***\n", li.hasPrevious());

        HList l2 = new ListAdapter();
        HListIterator li2 = l2.listIterator();
        assertFalse("\n*** HIterator not created correctly ***\n", li2.hasNext());
        assertFalse("\n*** HIterator not created correctly ***\n", li2.hasPrevious());
        li2.previous();
    }

    /**
     * SUMMARY: This method checks the correct working of previous() and remove(). It calls repeatedly
     * 			previous() and then remove(), until the list gets empty, to see if they do
     * 			the complete scan of the list and the backward removing at the same time.
     *<P>
     *
     * TEST CASE DESIGN: This method is based on the HList l1, which is initialised before the
     * 					 method (in the @Before method called setup()) and cleared after
     * 					 (in the @After method called cleanup()).
     * 					 At the beginning of the test method, l1 is filled with the elements contained in argv
     * 					 and then, the size of l1 and its elements are printed out so that they are visible.
     * 					 Then, in a while cycle, the element return by previous() and all the elements of the list
     * 					 are printed out and the list is decreased with remove at every iteration.
     *<P>
     *
     * TEST DESCRIPTION: This method tests:
     * 					 - if previous() manages to do the full backward scan of the list in a while cycle.
     * 				     - if remove() manages to empty the list in a while cycle (backward removal).
     *<P>
     *
     * PRE-CONDITION: - existing and not empty list.
     * 				  - existing and not empty list.
     *<P>
     *
     * POST-CONDITION: - previous() has done the full backward scan of the list.
     * 				   - remove() has done the backward removal of the list.
     *<P>
     *
     * EXPECTED RESULTS: The whole method has to be run completely without any error or failure.
     */
    @Test
    public void testHListIterator2()
    {
        System.out.println("Test HListIterator #2");
        int dl0, dl1, dl2;
        dl0 = l1.size();
        for(int i=0;i<argv.length;i++)
            l1.add(argv[i]);

        dl1 = l1.size();
        System.out.print(dl1);
        iterate(l1.iterator());

        li = l1.listIterator(l1.size());
        while(li.hasPrevious())
        {
            System.out.print(li.previous() + " ");
            iterate(l1.iterator());
            li.remove();
        }
        dl2 = l1.size();
        System.out.print(dl2);
        iterate(l1.iterator());

        assertEquals("\n*** Backward full scan and backward removal not working ***\n", dl1, (dl0+argv.length));
        assertEquals("\n*** Backward full scan and backward removal not working ***\n", dl2, 0);
    }

    /**
     * SUMMARY: This method checks if previousIndex() and nextIndex() work properly. So, it checks
     * 			also that previousIndex() returns -1 when the listIterator is at the
     * 			beginning of the list.
     *<P>
     *
     * TEST CASE DESIGN: This method is based on the HList l1, which is initialised before the
     * 					 method (in the @Before method called setup()) and cleared after
     * 					 (in the @After method called cleanup()).
     * 					 At the beginning of the test method, l1 is filled with the elements contained in argv
     * 					 and then, the size of l1 and its elements are printed out so that they are visible.
     * 					 Then, nextIndex() and previousIndex() are invoked to see if they work properly.
     *<P>
     *
     * TEST DESCRIPTION: This method tests:
     * 					 - previousIndex() on a listIterator which is not at the beginning of a not empty list.
     * 				     - nextIndex() on a listIterator over a not empty list.
     *                   - previousIndex() on a listIterator which is at the beginning of a not empty list.
     *<P>
     *
     * PRE-CONDITION: - existing and not empty list, listIterator is not at the beginning of it.
     * 				  - existing and not empty list.
     *                - existing and not empty list, listIterator is at the beginning of it.
     *<P>
     *
     * POST-CONDITION: - previousIndex() has returned the correct index.
     * 				   - nextIndex() has returned the correct index.
     *                 - previousIndex() has returned -1.
     *<P>
     *
     * EXPECTED RESULTS: The whole method has to be run completely without any error or failure.
     */
    @Test
    public void testHListIterator3()
    {
        System.out.println("TestListIterator #3");
        for(int i=0;i<argv.length;i++)
            l1.add(argv[i]);

        System.out.println(l1.size());
        iterate(l1.iterator());
        li = l1.listIterator(1);

        assertEquals("\n*** previousIndex() not working correctly ***\n", li.previousIndex(), 0);
        assertEquals("\n*** nextIndex() not working correctly ***\n", li.nextIndex(), 1);
        li.previous();
        assertEquals("\n*** previousIndex() not working correctly ***\n", li.previousIndex(), -1);
    }

    /**
     * SUMMARY: This method checks if set(Object obj) works properly.
     *<P>
     *
     * TEST CASE DESIGN: This method is based on the HList l1, which is initialised before the
     * 					 method (in the @Before method called setup()) and cleared after
     * 					 (in the @After method called cleanup()).
     * 					 At the beginning of the test method, l1 is filled with the elements contained in argv
     * 					 and then, the size of l1 and its elements are printed out so that they are visible.
     * 					 Then, set is invoked to see if it works properly.
     *<P>
     *
     * TEST DESCRIPTION: This method tests:
     * 					 - set(obj) when the last move was made with next().
     * 				     - set(obj) when the last move was made with previous().
     *                   - that set throws IllegalStateException if the last move of the
     *   				 iterator was an add(obj).
     *<P>
     *
     * PRE-CONDITION: - existing and not empty list, listIterator has just made a next().
     *                - existing and not empty list, listIterator has just made a previous().
     *                - existing and not empty list, listIterator has just made an add(obj).
     *<P>
     *
     * POST-CONDITION: - set(obj) modified correctly the correct element.
     * 				   - set(obj) modified correctly the correct element.
     *                 - set(obj) has thrown IllegalStateException.
     *<P>
     *
     * EXPECTED RESULTS: The whole method has to be run completely without any error or failure.
     */
    @Test(expected = IllegalStateException.class)
    public void testHListIterator4()
    {
        System.out.println("TestListIterator #4");
        for(int i=0;i<argv.length;i++)
            l1.add(argv[i]);

        System.out.println(l1.size());
        iterate(l1.iterator());
        li = l1.listIterator();

        li.next();
        li.set("nuovo");
        assertEquals("\n*** set(obj) not working correctly ***\n", li.previous(), "nuovo");
        li.set("nuovissimo");
        assertEquals("\n*** set(obj) not working correctly ***\n", li.next(), "nuovissimo");
        li.add(null);
        li.set("pippo");
    }

    /**
     * SUMMARY: This method checks if set(Object obj) works properly while doing a full forward and
     * 			backward scan of the list.
     *<P>
     *
     * TEST CASE DESIGN: This method is based on the HList l1, which is initialised before the
     * 					 method (in the @Before method called setup()) and cleared after
     * 					 (in the @After method called cleanup()).
     * 					 At the beginning of the test method, l1 is filled with the elements contained in argv
     * 					 and then, the size of l1 and its elements are printed out so that they are visible.
     * 					 Then, set is invoked with a forward scan and a backward scan to see if it works properly.
     *<P>
     *
     * TEST DESCRIPTION: This method tests:
     * 					 - set(obj) with a forward scan.
     * 				     - set(obj) with a backward scan.
     *<P>
     *
     * PRE-CONDITION: - existing and not empty list.
     *                - existing and not empty list.
     *<P>
     *
     * POST-CONDITION: - set(obj) modified correctly the whole list.
     * 				   - set(obj) modified correctly the whole list.
     *<P>
     *
     * EXPECTED RESULTS: The whole method has to be run completely without any error or failure.
     */
    @Test
    public void testHListIterator5()
    {
        System.out.println("TestListIterator #5");
        for(int i=0;i<argv.length;i++)
            l1.add(argv[i]);

        System.out.println(l1.size());
        iterate(l1.iterator());
        li = l1.listIterator();
        int i = 1;
        while(li.hasNext())
        {
            li.next();
            li.set(i);
            i++;
        }
        iterate(l1.iterator());

        while(li.hasPrevious())
        {
            li.previous();
            li.set(i);
            i++;
        }
        iterate(l1.iterator());

        assertEquals("\n*** set(obj) not working correctly ***\n", li.next(), 12);
    }

    /**
     * SUMMARY: This method checks if set(obj) throws IllegalStateException when the
     * 			listIterator hasn't made any next() or previous() yet.
     *<P>
     *
     * TEST CASE DESIGN: This method is based on the HList l1, which is initialised before the
     * 					 method (in the @Before method called setup()) and cleared after
     * 					 (in the @After method called cleanup()). Here, l1 is empty.
     *<P>
     *
     * TEST DESCRIPTION: This method checks that set throws IllegalStateException if the listIterator
     * 					 still has to make any move.
     *<P>
     *
     * PRE-CONDITION: Existing and empty list, listIterator has only been created.
     *<P>
     *
     * POST-CONDITION: set(obj) has thrown IllegalStateException.
     *<P>
     *
     * EXPECTED RESULTS: The whole method has to be run completely without any error or failure.
     */
    @Test(expected = IllegalStateException.class)
    public void testSetEx1()
    {
        System.out.println("Test set(Object obj) exception #1");
        li = l1.listIterator();
        li.set("nuovo");
    }

    /**
     * SUMMARY: This method checks if set(obj) throws IllegalStateException when the last
     * 			operation done by the listIterator was remove().
     *<P>
     *
     * TEST CASE DESIGN: This method is based on the HList l1, which is initialised before the
     * 					 method (in the @Before method called setup()) and cleared after
     * 					 (in the @After method called cleanup()). At the beginning of the test method,
     * 					 l1 is filled with the elements contained in argv and then, the size of l1 and its
     *                   elements are printed out so that they are visible.
     *<P>
     *
     * TEST DESCRIPTION: This method checks that set throws IllegalStateException if the last operation
     * 					 made by the listIterator is a remove().
     *<P>
     *
     * PRE-CONDITION: Existing and not empty list, listIterator's last move was remove().
     *
     * POST-CONDITION: set(obj) has thrown IllegalStateException.
     *<P>
     *
     * EXPECTED RESULTS: The whole method has to be run completely without any error or failure.
     */
    @Test(expected = IllegalStateException.class)
    public void testSetEx2()
    {
        System.out.println("Test set(Object obj) exception #2");
        for(int i=0;i<argv.length;i++)
            l1.add(argv[i]);
        li = l1.listIterator();
        li.next();
        li.remove();
        li.set("nuovo");
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