package myAdapter;

import java.util.NoSuchElementException;

/**
 * This class implements myAdapter.HIterator and myAdapter.HListIterator interfaces.
 */

public class IteratorClass implements HListIterator
{
    private HList hList;
    private int index;
    private int lastMove;

    /**
     * Iterator default constructor.
     * The iterator is built at the beginning of the specified list.
     *
     * @param hL - list of the iterator
     */
    public IteratorClass(HList hL)
    {
        hList = hL;
        index = 0;
        lastMove = 0;
    }

    /**
     * Iterator constructor with index.
     * The iterator is built at the specified index of the specified list.
     *
     * @param hL  - list of the iterator
     * @param ind - starting point of the iterator
     */
    public IteratorClass(HList hL, int ind)
    {
        hList = hL;
        index = ind;
        lastMove = 0;
    }

    /**
     * Returns true if the iteration has more elements. (In other
     * words, returns true if next would return an element
     * rather than throwing an exception.)
     *
     * @return true if the iterator has more elements.
     */
    @Override
    public boolean hasNext()
    {
        if(index < hList.size())
            return true;
        return false;
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration.
     * @throws NoSuchElementException - iteration has no more elements.
     */
    @Override
    public Object next() throws NoSuchElementException
    {
        if (!this.hasNext()) throw new NoSuchElementException();

        Object obj = hList.get(index);
        index++;
        lastMove = 1;
        return obj;
    }

    /**
     * Removes from the underlying collection the last element returned by the
     * iterator (optional operation).  This method can be called only once per
     * call to next.  The behavior of an iterator is unspecified if
     * the underlying collection is modified while the iteration is in
     * progress in any way other than by calling this method.
     *
     * @throws IllegalStateException - if the next method has not yet been called,
     *                               or the remove method has alread been called
     *                               after the last call to the next method.
     */
    @Override
    public void remove() throws IllegalStateException
    {
        if(lastMove == -2 || lastMove == 0) throw new IllegalStateException();

        if(lastMove == 1)
        {
            this.previous();
            hList.remove(index);
            lastMove = -2;
            return;
        }

        if(lastMove == -1)
        {
            hList.remove(index);
            lastMove = -2;
            return;
        }
    }

    /**
     * Returns true if this list iterator has more elements when traversing
     * the list in the reverse direction. (In other words, returns true if
     * previous would return an element rather than throwing an exception.)
     *
     * @return true if the list iterator has more elements when traversing
     *         the list in the reverse direction.
     */
    @Override
    public boolean hasPrevious()
    {
        if(index > 0)
            return true;
        return false;
    }

    /**
     * Returns the previous element in the list. This method may be called
     * repeatedly to iterate through the list backwards, or intermixed with calls to
     * next to go back and forth. (Note that alternating calls to
     * next and previous will return the same element repeatedly.)
     *
     * @return the previous element in the list.
     * @throws NoSuchElementException - if the iteration has no previous element.
     */
    @Override
    public Object previous() throws NoSuchElementException
    {
        if (!this.hasPrevious()) throw new NoSuchElementException();

        index--;
        Object obj = hList.get(index);
        lastMove = -1;
        return obj;
    }

    /**
     * Returns the index of the element that would be returned by a subsequent call
     * to next. (Returns list size if the list iterator is at the end of
     * the list.)
     *
     * @return the index of the element that would be returned by a subsequent call
     *         to next, or list size if list iterator is at end of list.
     */
    @Override
    public int nextIndex() { return index; }

    /**
     * Returns the index of the element that would be returned by a subsequent call
     * to previous. (Returns -1 if the list iterator is at the beginning of
     * the list.)
     *
     * @return the index of the element that would be returned by a subsequent call
     *         to previous, or -1 if list iterator is at beginning of list.
     */
    @Override
    public int previousIndex()
    {
        if(index > 0)
            return (index-1);
        return -1;
    }

    /**
     * Replaces the last element returned by next or previous with
     * the specified element (optional operation). This call can be made only if
     * neither HIterator.remove nor HListIterator.add have been
     * called after the last call to next or previous.
     *
     * @param obj - the element with which to replace the last element returned by
     *          next or previous.
     * @throws IllegalStateException - if neither next nor previous have
     *                               been called, or remove or add have been
     *                               called after the last call to next or
     *                               previous.
     */
    @Override
    public void set(Object obj) throws IllegalStateException
    {
        if(lastMove == 2 || lastMove == -2 || lastMove == 0) throw new IllegalStateException();

        if(lastMove == 1)
            hList.set(index-1, obj);

        if (lastMove == -1)
            hList.set(index, obj);
    }

    /**
     * Inserts the specified element into the list (optional operation). The element
     * is inserted immediately before the next element that would be returned by
     * next, if any, and after the next element that would be returned by
     * previous, if any. (If the list contains no elements, the new element
     * becomes the sole element on the list.) The new element is inserted before the
     * implicit cursor: a subsequent call to next would be unaffected, and
     * a subsequent call to previous would return the new element. (This
     * call increases by one the value that would be returned by a call to
     * nextIndex or previousIndex.)
     *
     * @param obj - the element to insert.
     */
    @Override
    public void add(Object obj)
    {
        hList.add(index, obj);
        index++;
        lastMove = 2;
    }
}