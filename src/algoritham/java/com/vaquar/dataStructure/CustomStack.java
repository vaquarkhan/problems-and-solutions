package algoritham.java.com.vaquar.dataStructure;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Source Oracle JDK: java.util.stack
 * 
 *
 * @param <E>
 */
public class CustomStack<E> {

    protected Object[] elementData;
    protected int elementCount;
    protected transient int modCount = 0;
    

    /** use serialVersionUID from JDK 1.0.2 for interoperability */
    private static final long serialVersionUID = -2767605614048989439L;
    
    public CustomStack(int initialCapacity) {
        this.elementData = new Object[initialCapacity];
	}
    
    public E push(E item) {
    	modCount++;
        ensureCapacityHelper(elementCount + 1);
        elementData[elementCount++] = item;
        return item;
    }
    
    private void ensureCapacityHelper(int minCapacity) {
        if (minCapacity - elementData.length > 0) {
            int oldCapacity = elementData.length;
            int newCapacity = 2 * oldCapacity; 
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }

    public E pop() {
        E obj = peek();
        removeElementAt(size() - 1);
        return obj;
    }
    
    public void removeElementAt(int index) {
        modCount++;
        if (index >= elementCount) {
            throw new ArrayIndexOutOfBoundsException(index + " >= " +
                                                     elementCount);
        }
        else if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        int j = elementCount - index - 1;
        if (j > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, j);
        }
        elementCount--;
        elementData[elementCount] = null; /* avoid leak */
    }


    public E peek() {
        int len = size();

        if (len == 0)
            throw new EmptyStackException();
        return elementAt(len - 1);
    }

    private E peek(int index) {
        return elementAt(index);
    }
    
    @SuppressWarnings("unchecked") //To avoid warning; Type safety: Unchecked cast from Object to E
    public  E elementAt(int index) {
        if (index >= elementCount) {
            throw new ArrayIndexOutOfBoundsException(index + " >= " + elementCount);
        }
        return (E) elementData[index];
    }
    
    /**
     * Tests if this stack is empty.
     *
     * @return  <code>true</code> if and only if this stack contains
     *          no items; <code>false</code> otherwise.
     */
    public boolean empty() {
        return size() == 0;
    }
    
    public int size() {
        return elementCount;
    }
    
    
    // Iterators
    public Iterator<E> iterator() {
        return new Itr();
    }

//    public ListIterator<E> listIterator() {
//        return listIterator(0);
//    }

//    public ListIterator<E> listIterator(final int index) {
//        rangeCheckForAdd(index);
//
//        return new ListItr(index);
//    }

    private class Itr implements Iterator<E> {
        int cursor = 0;
        int lastRet = -1;
        int expectedModCount = modCount;

        public boolean hasNext() {
            return cursor != size();
        }

        public E next() {
            checkForComodification();
            try {
                int i = cursor;
                E next = peek(i);
                lastRet = i;
                cursor = i + 1;
                return next;
            } catch (IndexOutOfBoundsException e) {
                checkForComodification();
                throw new NoSuchElementException();
            }
        }

        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();
            checkForComodification();

            try {
            	removeElementAt(lastRet);
                if (lastRet < cursor)
                    cursor--;
                lastRet = -1;
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException e) {
                throw new ConcurrentModificationException();
            }
        }

        final void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }
    }

//    private class ListItr extends Itr implements ListIterator<E> {
//        ListItr(int index) {
//            cursor = index;
//        }
//
//        public boolean hasPrevious() {
//            return cursor != 0;
//        }
//
//        public E previous() {
//            checkForComodification();
//            try {
//                int i = cursor - 1;
//                E previous = get(i);
//                lastRet = cursor = i;
//                return previous;
//            } catch (IndexOutOfBoundsException e) {
//                checkForComodification();
//                throw new NoSuchElementException();
//            }
//        }
//
//        public int nextIndex() {
//            return cursor;
//        }
//
//        public int previousIndex() {
//            return cursor-1;
//        }
//
//        public void set(E e) {
//            if (lastRet < 0)
//                throw new IllegalStateException();
//            checkForComodification();
//
//            try {
//                AbstractList.this.set(lastRet, e);
//                expectedModCount = modCount;
//            } catch (IndexOutOfBoundsException ex) {
//                throw new ConcurrentModificationException();
//            }
//        }
//
//        public void add(E e) {
//            checkForComodification();
//
//            try {
//                int i = cursor;
//                AbstractList.this.add(i, e);
//                lastRet = -1;
//                cursor = i + 1;
//                expectedModCount = modCount;
//            } catch (IndexOutOfBoundsException ex) {
//                throw new ConcurrentModificationException();
//            }
//        }
//    }
    
//    private void rangeCheckForAdd(int index) {
//        if (index < 0 || index > size())
//            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
//    }
//
//    private String outOfBoundsMsg(int index) {
//        return "Index: "+index+", Size: "+size();
//    }
}
