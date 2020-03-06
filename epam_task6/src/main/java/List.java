package com.epamtask;
import java.util.Arrays;
public class List<E>
{
    private int s = 0;
    private static final int c = 10;
    private Object ele[];
    public List() {
        ele = new Object[c];
    }
    public void add(E e)
    {
        if (s == ele.length)
        {
            ensureCapacity();
        }
        ele[s++] = e;
    }
    public E get(int i)
    {
        if (i >= s || i < 0)
        {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        return (E) ele[i];
    }
    public E remove(int i) {
        if (i >= s || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        Object item = ele[i];
        int numElts = ele.length - ( i + 1 ) ;
        System.arraycopy( ele, i + 1, ele, i, numElts ) ;
        s--;
        return (E) item;
    }
    public int size() {
        return s;
    }
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for(int i = 0; i < s ;i++) {
            sb.append(ele[i].toString());
            if(i<s-1){
                sb.append(",");
            }
        }
        sb.append(']');
        return sb.toString();
    }

    private void ensureCapacity() {
        int newSize = ele.length * 2;
        ele = Arrays.copyOf(ele, newSize);
    }
}