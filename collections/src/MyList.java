import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

public class MyList<T> implements Iterable<T> {
//arr
    @Override
    public Iterator<T> iterator() {
        return null;
    }



    class MyIterator implements Iterator<T>{

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            return null;
        }

        @Override
        public void remove() {

        }
    }
}
