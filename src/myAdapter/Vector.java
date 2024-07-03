package myAdapter;

import java.util.Enumeration;

/**
 * Vector class adaptee of the myAdapter.ListAdapter class.
 * The object {@link myAdapter.Vector} is used to save e manage data,
 * the porpouse of this class is only to filter the methods of vector
 * in order to use only methods from CLDC1.1
 */
public class Vector
{

    private java.util.Vector vector;

    /**
     * Constructs an empty vector
     */
    public Vector()
    {
        this.vector = new java.util.Vector();
    }

    /**
     * Constructs an empty vector with the given initial capacity.
     *
     * @param initialCapacity - initial capacity
     */
    public Vector(int initialCapacity)
    {
        this.vector = new java.util.Vector(initialCapacity);
    }

    /**
     * Constructs an empty vector with the given initial capacity and the capacity increment.
     *
     * @param initialCapacity   - initial capacity
     * @param capacityIncrement - increment size
     */
    public Vector(int initialCapacity, int capacityIncrement)
    {
        this.vector = new java.util.Vector(initialCapacity, capacityIncrement);
    }

    /**
     * Appends the given element to the vector.
     *
     * @param obj - object to add
     */
    public void addElement(Object obj)
    {
        this.vector.addElement(obj);
    }

    /**
     * Provides the capacity of the vector.
     *
     * @return the amount of element in the vector
     */
    public int capacity()
    {
        return this.vector.capacity();
    }

    /**
     * Search if the given element is present in the Vector
     *
     * @param elem - element to search
     * @return true if present, otherwise false
     */
    public boolean contains(Object elem)
    {
        return this.vector.contains(elem);
    }

    /**
     * Copies the components of this vector into the specified array. The array must
     * be big enough to hold all the objects in this vector.
     *
     * @param anArray - array to store elements
     */
    public void copyInto(Object[] anArray)
    {
        this.vector.copyInto(anArray);
    }

    /**
     * Provides the element at a given index
     *
     * @param index - of the object to return
     * @return the component at the specified index
     */
    public Object elementAt(int index)
    {
        return this.vector.elementAt(index);
    }

    /**
     * Returns an enumeration of the components of this vector.
     *
     * @return an enumeration of the components of this vector.
     */
    public Enumeration elements()
    {
        return this.vector.elements();
    }

    /**
     * Increases the capacity of this vector, if necessary, to ensure that it can
     * hold at least the number of components specified by the minimum capacity
     * argument.
     *
     * @param minCapacity - min capacity
     */
    public void ensureCapacity(int minCapacity)
    {
        this.vector.ensureCapacity(minCapacity);
    }

    /**
     * Returns the first element of the vector.
     *
     * @return the first element of the vector.
     */
    public Object firstElement()
    {
        return this.vector.firstElement();
    }

    /**
     * Searches for the first occurrence of the given argument, testing for equality
     * using the equals method.
     *
     * @param elem - to find the index
     * @return the index of the first occurrence, -1 if not present
     */
    public int indexOf(Object elem)
    {
        return this.vector.indexOf(elem);
    }

    /**
     * Searches for the first occurrence of the given argument, beginning the search
     * at index, and testing for equality using the equals method.
     *
     * @param elem  - to find the index
     * @param index - starting point of the search
     * @return the index of the first occurence, -1 if not present
     */
    public int indexOf(Object elem, int index)
    {
        return this.vector.indexOf(elem, index);
    }

    /**
     * Inserts the specified object as a component in this vector at the specified
     * index. Each component in this vector with an index greater or equal to the
     * specified index is shifted upward to have an index one greater than the value
     * it had previously.
     * The index must be a value greater than or equal to 0 and less than or equal
     * to the current size of the vector.
     *
     * @param obj   - object to insert
     * @param index - of inserting object
     */
    public void insertElementAt(Object obj, int index)
    {
        this.vector.insertElementAt(obj, index);
    }

    /**
     * Check if the vector is empty.
     *
     * @return true if there is no element in the vector, otherwise false
     */
    public boolean isEmpty()
    {
        return this.vector.isEmpty();
    }

    /**
     * Return the last element of the vector.
     *
     * @return the last element of the vector.
     */
    public Object lastElement()
    {
        return this.vector.lastElement();
    }

    /**
     * Provides the last occurrence of the specified element.
     *
     * @param elem - to search
     * @return the index of the last occurrence of the specified object in this
     *         vector.
     */
    public int lastIndexOf(Object elem)
    {
        return this.vector.lastIndexOf(elem);
    }

    /**
     * Searches backwards for the specified object, starting from the specified
     * index, and returns an index to it.
     *
     * @param elem  - to search
     * @param index - starting point of the search
     * @return the index of the last occurrence of the specified object in this
     *         vector at position less than index in the vector; -1 if the object is
     *         not found.
     */
    public int lastIndexOf(Object elem, int index)
    {
        return this.vector.lastIndexOf(elem, index);
    }

    /**
     * Deletes the component at the specified index. Each component in this vector
     * with an index greater or equal to the specified index is shifted downward to
     * have an index one smaller than the value it had previously.
     *
     * @param index - to remove element
     */
    public void removeElementAt(int index) throws ArrayIndexOutOfBoundsException
    {
        this.vector.removeElementAt(index);
    }

    /**
     * Sets the component at the specified index of this vector to be the specified
     * object. The previous component at that position is discarded.
     * The index must be a value greater than or equal to 0 and less than the
     * current size of the vector.
     *
     * @param obj   - object to set
     * @param index - of the object
     */
    public void setElementAt(Object obj, int index)
    {
        this.vector.setElementAt(obj, index);
    }

    /**
     * Sets the size of this vector. If the new size is greater than the current
     * size, new null items are added to the end of the vector. If the new size is
     * less than the current size, all components at index newSize and greater are
     * discarded.
     *
     * @param newSize - new dimension
     */
    public void setSize(int newSize)
    {
        this.vector.setSize(newSize);
    }

    /**
     * Returns the size of the vector.
     *
     * @return the size of the vector.
     */
    public int size()
    {
        return this.vector.size();
    }

    /**
     * Returns a string representation of this vector.
     *
     * @return a string representation of this vector.
     */
    public String toString()
    {
        return this.vector.toString();
    }

    /**
     * Trims the capacity of this vector to be the vector's current size. An
     * application can use this operation to minimise the storage of a vector.
     */
    public void trimToSize()
    {
        this.vector.trimToSize();
    }
}