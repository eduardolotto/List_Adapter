package myAdapter;

/**
 * Class that implements myAdapter.HCollection and myAdapter.HList interfaces.
 */
public class ListAdapter implements HList
{
    private Vector list;
    private boolean isSon;
    private int from;
    private HList father;


    /**
     * Default constructor.
     */
    public ListAdapter()
    {
        list = new Vector();
        isSon = false;
    }

    /**
     * Constructor with initial capacity.
     * Constructs an empty list with the specified capacity.
     *
     * @param initialCapacity - the desired initial capacity of the list.
     */
    public ListAdapter(int initialCapacity)
    {
        list = new Vector(initialCapacity);
        isSon = false;
    }

    /**
     * Constructor with initial capacity and capacity increment.
     * Constructs an empty list with the specified initial capacity and capacity increment.
     *
     * @param initialCapacity   - initial capacity of the vector.
     * @param capacityIncrement - the amount by which the capacity is increased when
     * 							the list overflows.
     */
    public ListAdapter(int initialCapacity, int capacityIncrement)
    {
        list = new Vector(initialCapacity, capacityIncrement);
        isSon = false;
    }

    /**
     * Set the sublist from yhe original list.
     *
     * @param f - from index.
     * @param dad - original list.
     */
    private void setSon(int f, HList dad)
    {
        isSon = true;
        from = f;
        father = dad;
    }

    //Methods from HCollection

    /**
     * Returns the number of elements in this collection. If this collection
     * contains more than Integer.MAX_VALUE elements, returns
     * Integer.MAX_VALUE.
     *
     * @return the number of elements in this collection
     */
    @Override
    public int size()
    {
        return list.size();
    }

    /**
     * Returns true if this collection is empty, false otherwise.
     *
     * @return true if this collection contains no elements
     */
    @Override
    public boolean isEmpty()
    {
        return (size() <= 0);
    }

    /**
     * Returns true if this collection contains the specified element. More
     * formally, returns true if and only if this collection contains at
     * least one element e such that (o==null ? e==null : o.equals(e)).
     *
     * @param obj - element whose presence in this collection is to be tested.
     * @return true if this collection contains the specified element
     */
    @Override
    public boolean contains(Object obj)
    {
        return list.contains(obj);
    }

    /**
     * Returns an iterator over the elements in this collection. There are no
     * guarantees concerning the order in which the elements are returned (unless
     * this collection is an instance of some class that provides a guarantee).
     *
     * @return an HIterator over the elements in this collection
     */
    @Override
    public IteratorClass iterator()
    {
        return new IteratorClass(this);
    }

    /**
     * Returns an array containing all of the elements in this collection. If the
     * collection makes any guarantees as to what order its elements are returned by
     * its iterator, this method must return the elements in the same order.
     *
     * The returned array will be "safe" in that no references to it are maintained
     * by this collection. (In other words, this method must allocate a new array
     * even if this collection is backed by an array). The caller is thus free to
     * modify the returned array.
     * This method acts as bridge between array-based and collection-based APIs.
     *
     * @return an array containing all of the elements in this collection
     */
    @Override
    public Object[] toArray()
    {
        Object[] newArray = new Object[size()];

        for(int i = 0; i < size(); i++)
            newArray[i] = get(i);

        return newArray;
    }

    /**
     * Returns an array containing all of the elements in this collection; the
     * runtime type of the returned array is that of the specified array. If the
     * collection fits in the specified array, it is returned therein. Otherwise,
     * an IllegalArgumentException is generated.
     *
     * If this collection fits in the specified array with room to spare (i.e., the
     * array has more elements than this collection), the element in the array
     * immediately following the end of the collection is set to null. This
     * is useful in determining the length of this collection only if the
     * caller knows that this collection does not contain any null
     * elements.)
     *
     * If this collection makes any guarantees as to what order its elements are
     * returned by its iterator, this method must return the elements in the same
     * order.
     *
     * Like the toArray method, this method acts as bridge between
     * array-based and collection-based APIs. Further, this method allows precise
     * control over the runtime type of the output array, and may, under certain
     * circumstances, be used to save allocation costs
     *
     * @param arrayTarget - the array into which the elements of this collection are
     *                    to be stored, if it is big enough; otherwise, a new array
     *                    of the same runtime type is allocated for this purpose.
     * @return an array containing the elements of this collection
     * @throws NullPointerException     - if the specified array is null.
     * @throws IllegalArgumentException - if arrayTarget.length is less than this.size().
     */
    @Override
    public Object[] toArray(Object[] arrayTarget) throws NullPointerException, IllegalArgumentException
    {
        if (arrayTarget == null) throw new NullPointerException();
        if (arrayTarget.length < size()) throw new IllegalArgumentException();

        for(int i = 0; i < size(); i++)
            arrayTarget[i] = get(i);

        return arrayTarget;
    }

    /**
     * Ensures that this collection contains the specified element (optional
     * operation). Returns true if this collection changed as a result of the call.
     * (Returns false if this collection does not permit duplicates and already
     * contains the specified element.)
     *
     * Collections that support this operation may place limitations on what
     * elements may be added to this collection. In particular, some collections
     * will refuse to add null elements, and others will impose restrictions on the
     * type of elements that may be added. Collection classes should clearly specify
     * in their documentation any restrictions on what elements may be added.
     *
     * If a collection refuses to add a particular element for any reason other than
     * that it already contains the element, it must throw an exception
     * (rather than returning false). This preserves the invariant that a collection
     * always contains the specified element after this call returns.
     *
     * @param obj - element whose presence in this collection is to be ensured.
     * @return true if this collection changed as a result of the call
     */
    @Override
    public boolean add(Object obj)
    {
        list.addElement(obj);
        if(this.isSon)
            father.add(obj);
        return true;
    }

    /**
     * Removes a single instance of the specified element from this collection, if
     * it is present (optional operation). More formally, removes an element e such
     * that (o==null ? e==null : o.equals(e)), if this collection contains one or
     * more such elements. Returns true if this collection contained the specified
     * element (or equivalently, if this collection changed as a result of the
     * call).
     *
     * @param obj element to be removed from this collection, if present.
     * @return true if this collection changed as a result of the call
     */
    @Override
    public boolean remove(Object obj)
    {
        int index = list.indexOf(obj);
        if (index == -1)
            return false;
        list.removeElementAt(index);
        if(this.isSon)
            father.remove(obj);
        return true;
    }

    /**
     * Returns true if this collection contains all of the elements in the
     * specified collection.
     *
     * @param coll collection to be checked for containment in this collection.
     * @return true if this collection contains all of the elements in the
     *         specified collection
     * @throws NullPointerException if the specified collection is null.
     */
    @Override
    public boolean containsAll(HCollection coll) throws NullPointerException
    {
        if (coll == null) throw new NullPointerException();

        Object[] temp = coll.toArray();

        for(Object obj : temp)
            if(!this.contains(obj))
                return false;
        return true;
    }

    /**
     * Adds all of the elements in the specified collection to this collection
     * (optional operation). The behavior of this operation is undefined if the
     * specified collection is modified while the operation is in progress. (This
     * implies that the behavior of this call is undefined if the specified
     * collection is this collection, and this collection is nonempty.)
     *
     * @param coll - elements to be inserted into this collection.
     * @return true if this collection changed as a result of the call
     * @throws NullPointerException - if the specified collection is null.
     */
    @Override
    public boolean addAll(HCollection coll) throws NullPointerException
    {
        if(coll == null) throw new NullPointerException();

        int ogSize = size();
        Object[] temp = coll.toArray();

        for(Object obj : temp)
            add(obj);

        if (ogSize == list.size())
            return false;
        return true;
    }

    /**
     * Removes all this collection's elements that are also contained in the
     * specified collection (optional operation). After this call returns, this
     * collection will contain no elements in common with the specified collection.
     *
     * @param coll - elements to be removed from this collection.
     * @return true if this collection changed as a result of the call
     * @throws NullPointerException - if the specified collection is null.
     */
    @Override
    public boolean removeAll(HCollection coll) throws NullPointerException
    {
        if (coll == null) throw new NullPointerException();

        int ogSize = size();
        Object[] temp = this.toArray();

        for (Object obj : temp)
            if(coll.contains(obj))
                remove(obj);

        if (ogSize == size())
            return false;
        return true;
    }

    /**
     * Retains only the elements in this collection that are contained in the
     * specified collection (optional operation). In other words, removes from this
     * collection all of its elements that are not contained in the specified
     * collection.
     *
     * @param coll - elements to be retained in this collection.
     * @return true if this collection changed as a result of the call
     * @throws NullPointerException - if the specified collection is null.
     */
    @Override
    public boolean retainAll(HCollection coll) throws NullPointerException
    {
        if(coll == null) throw new NullPointerException();
        if(coll.size() == 0)
            return false;

        int ogSize = size();
        Object[] temp = this.toArray();

        for(Object obj : temp)
            if(!coll.contains(obj))
                remove(obj);

        if(ogSize == size())
            return false;
        return true;
    }

    /**
     * Removes every element from this collection (optional operation). This
     * collection will be empty after this method returns unless it throws an exception.
     */
    @Override
    public void clear()
    {
        Object[] temp = toArray();
        for(Object obj : temp)
            remove(obj);
    }

    /**
     * Compares the specified object with this collection for equality.
     *
     * While the Collection interface adds no stipulations to the general
     * contract for the Object.equals, programmers who implement the
     * Collection interface "directly" (in other words, create a class that
     * is a Collection but is not a Set or a List) must
     * exercise care if they choose to override the Object.equals. It is
     * not necessary to do so, and the simplest course of action is to rely on
     * Object's implementation, but the implementer may wish to implement a
     * "value comparison" in place of the default "reference comparison." (The
     * List and Set interfaces mandate such value comparisons.)
     *
     * The general contract for the Object.equals method states that equals
     * must be symmetric (in other words, a.equals(b) if and only if
     * b.equals(a)). The contracts for List.equals and
     * Set.equals state that lists are only equal to other lists, and sets
     * to other sets. Thus, a custom equals method for a collection class
     * that implements neither the List nor Set interface must
     * return false when this collection is compared to any list or set.
     * (By the same logic, it is not possible to write a class that correctly
     * implements both the Set and List interfaces.)
     *
     * @param obj - Object to be compared for equality with this collection.
     * @return true if the specified object is equal to this collection
     * @throws NullPointerException - if obj is null.
     */
    @Override
    public boolean equals(Object obj) throws NullPointerException
    {
        if(obj == null) throw new NullPointerException();

        if(this.getClass() != obj.getClass()) return false;
        if(size() != ((ListAdapter) obj).size()) return false;
        if(((ListAdapter) obj).hashCode() != this.hashCode())
            return false;
        return true;
    }

    /**
     * Returns the hash code value for this collection. While the
     * Collection interface adds no stipulations to the general contract
     * for the Object.hashCode method, programmers should take note that
     * any class that overrides the Object.equals method must also override
     * the Object.hashCode method in order to satisfy the general contract
     * for the Object.hashCodemethod. In particular, c1.equals(c2)
     * implies that c1.hashCode()==c2.hashCode().
     *
     * @return the hash code value for this collection
     */
    @Override
    public int hashCode()
    {
        Object[] arr = this.toArray();
        int hashCode = 1;
        for(int i = 0; i < arr.length; i++)
        {
            Object obj = arr[i];
            hashCode = 31*hashCode + (obj == null ? 0 : obj.hashCode());
        }
        return hashCode;
    }

    //Methods from HList

    /**
     * Inserts all of the elements in the specified collection into this list at the
     * specified position (optional operation). Shifts the element currently at that
     * position (if any) and any subsequent elements to the right (increases their
     * indices). The new elements will appear in this list in the order that they
     * are returned by the specified collection's iterator. The behavior of this
     * operation is unspecified if the specified collection is modified while the
     * operation is in progress. (Note that this will occur if the specified
     * collection is this list, and it's nonempty.)
     *
     * @param index - index at which to insert first element from the specified
     *              collection.
     * @param coll  - elements to be inserted into this list.
     * @return true if this list changed as a result of the call.
     * @throws NullPointerException      - if the specified collection contains
     *                                   one or more null elements and this list
     *                                   does not support null elements, or if
     *                                   the specified collection is null.
     * @throws IndexOutOfBoundsException - if the index is out of range.
     */
    @Override
    public boolean addAll(int index, HCollection coll) throws NullPointerException, IndexOutOfBoundsException
    {
        if (coll == null) throw new NullPointerException();
        if (index < 0 || index > size()) throw new IndexOutOfBoundsException();

        int ogSize = size();
        Object[] temp = coll.toArray();

        for (int i = 0; i < temp.length; i++)
            add(index + i, temp[i]);

        if (ogSize == size())
            return false;
        return true;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index - index of element to return.
     * @return the element at the specified position in this list.
     * @throws IndexOutOfBoundsException - if the index is out of range.
     */
    @Override
    public Object get(int index) throws IndexOutOfBoundsException
    {
        if (index < 0 || index >= size()) throw new IndexOutOfBoundsException();
        return list.elementAt(index);
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element (optional operation).
     *
     * @param index   - index of element to replace.
     * @param element - element to be stored at the specified position.
     * @return the element previously at the specified position.
     * @throws IndexOutOfBoundsException - if the index is out of range.
     */
    @Override
    public Object set(int index, Object element) throws IndexOutOfBoundsException
    {
        if (index < 0 || index >= size()) throw new IndexOutOfBoundsException();

        Object toReturn = get(index);
        list.setElementAt(element, index);

        if(this.isSon)
            father.set(from+index, element);

        return toReturn;
    }

    /**
     * Inserts the specified element at the specified position in this list
     * (optional operation). Shifts the element currently at that position (if any)
     * and any subsequent elements to the right (adds one to their indices).
     *
     * @param index   - index at which the specified element is to be inserted.
     * @param element - element to be inserted.
     * @throws IndexOutOfBoundsException - if the index is out of range.
     */
    @Override
    public void add(int index, Object element) throws IndexOutOfBoundsException
    {
        if (index < 0 || index > size()) throw new IndexOutOfBoundsException();

        list.insertElementAt(element, index);
        if(this.isSon)
            father.add(from+index, element);
    }

    /**
     * Removes the element at the specified position in this list (optional
     * operation). Shifts any subsequent elements to the left (subtracts one from
     * their indices). Returns the element that was removed from the list.
     *
     * @param index - the index of the element to removed.
     * @return the element previously at the specified position.
     * @throws IndexOutOfBoundsException     - if the index is out of range.
     */
    @Override
    public Object remove(int index) throws IndexOutOfBoundsException
    {
        if (index < 0 || index >= size()) throw new IndexOutOfBoundsException();

        Object toReturn = get(index);
        list.removeElementAt(index);

        if(this.isSon)
            father.remove(from+index);

        return toReturn;
    }

    /**
     * Returns the index in this list of the first occurrence of the specified
     * element, or -1 if this list does not contain this element. More formally,
     * returns the lowest index i such that (o==null ? get(i)==null :
     * o.equals(get(i))), or -1 if there is no such index.
     *
     * @param obj - element to search for.
     * @return the index in this list of the first occurrence of the specified
     *         element, or -1 if this list does not contain this element.
     */
    @Override
    public int indexOf(Object obj)
    {
        return list.indexOf(obj);
    }

    /**
     * Returns the index in this list of the last occurrence of the specified
     * element, or -1 if this list does not contain this element. More formally,
     * returns the highest index i such that (o==null ? get(i)==null :
     * o.equals(get(i))), or -1 if there is no such index.
     *
     * @param obj - element to search for.
     * @return the index in this list of the last occurrence of the specified
     *         element, or -1 if this list does not contain this element.
     */
    @Override
    public int lastIndexOf(Object obj)
    {
        return list.lastIndexOf(obj);
    }

    /**
     * Returns a list iterator of the elements in this list.
     *
     * @return a list iterator of the elements in this list (in proper sequence).
     */
    @Override
    public HListIterator listIterator()
    {
        return new IteratorClass(this);
    }

    /**
     * Returns a list iterator of the elements in this list (in proper sequence),
     * starting at the specified position in this list. The specified index
     * indicates the first element that would be returned by an initial call to the
     * next method. An initial call to the previous method would return the element
     * with the specified index minus one.
     *
     * @param index - index of first element to be returned from the list iterator (by
     *              a call to the next method).
     * @return a list iterator of the elements in this list (in proper sequence),
     *         starting at the specified position in this list.
     * @throws IndexOutOfBoundsException - if the index is out of range.
     */
    @Override
    public HListIterator listIterator(int index) throws IndexOutOfBoundsException
    {
        if (index < 0 || index > size()) throw new IndexOutOfBoundsException();
        return new IteratorClass(this, index);
    }

    /**
     * Returns a view of the portion of this list between the specified fromIndex,
     * inclusive, and toIndex, exclusive. (If fromIndex and toIndex are equal, the
     * returned list is empty.) The returned list is backed by this list, so
     * non-structural changes in the returned list are reflected in this list.
     * The returned list supports all of the optional list operations
     * supported by this list.
     *
     * This method eliminates the need for explicit range operations (of the sort
     * that commonly exist for arrays). Any operation that expects a list can be
     * used as a range operation by passing a subList view instead of a whole list.
     * For example, the following idiom removes a range of elements from a list:
     *
     * list.subHList(from, to).clear();
     *
     * Similar idioms may be constructed for indexOf and lastIndexOf, and all of the
     * algorithms in the Collections class can be applied to a subList.
     *
     * The semantics of the list returned by this method become undefined if the
     * backing list (i.e., this list) is structurally modified in any way
     * other than via the returned list. (Structural modifications are those that
     * change the size of this list, or otherwise perturb it in such a fashion that
     * iterations in progress may yield incorrect results.)
     *
     * @param fromIndex - low endpoint (inclusive) of the subList.
     * @param toIndex   - high endpoint (exclusive) of the subList.
     * @return a view of the specified range within this list.
     * @throws IndexOutOfBoundsException - for an illegal endpoint index value.
     */
    @Override
    public HList subList(int fromIndex, int toIndex) throws IndexOutOfBoundsException
    {
        if (fromIndex < 0 || toIndex > size() || fromIndex > toIndex) throw new IndexOutOfBoundsException();

        ListAdapter sub = new ListAdapter();

        for (int i = fromIndex; i < toIndex; i++)
            sub.add(get(i));

        sub.setSon(fromIndex, this);
        return sub;
    }
}