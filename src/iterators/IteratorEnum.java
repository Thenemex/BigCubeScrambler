package iterators;

import exceptions.conversions.ClassNotEnumType;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A specified iterator that will iterate over the enum's fields
 * NB : Needs a cast at the output of next()
 */
public class IteratorEnum
implements Iterator<Object> {

    private final Object[] enums;
    private int index = -1;

    public IteratorEnum(Class<?> enumClass) {
        this.enums = enumClass.getEnumConstants();
        if (enums == null) throw new ClassNotEnumType();
    }

    @Override public boolean hasNext() {
        return index + 1 < enums.length;
    }
    @Override public Object next() {
        if (++index >= enums.length) throw new NoSuchElementException("End of iterator reached");
        return enums[0].getClass().cast(enums[index]);
    }
}
