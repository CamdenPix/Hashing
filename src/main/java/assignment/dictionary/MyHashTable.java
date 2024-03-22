package assignment.dictionary;

/*

 */

//
import java.util.*;
import java.io.*;
import java.util.Dictionary;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.BiFunction;



/**

 */
public class MyHashTable<K,V>
//        
//        
{
    private static class Entry<K,V> {
        public K key;
        public V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int initial_capacity = 10;
    private int count = 0;
    private LinkedList[] table = new LinkedList[initial_capacity];
    public MyHashTable(){
        for(int i = 0; i<initial_capacity; i++){
            table[i] = new LinkedList<>();
        }
    }

    private int getIndex(Object key) {
        String str = String.valueOf(key);
        int a = 0;
        for(int i = 0; i < str.length(); i++){
            a += Character.getNumericValue(str.charAt(i));
        }
        return a % initial_capacity;
    }

   public V put(K key, V value) {
        int index = getIndex(key);
        LinkedList<Entry<K,V>> table_row = table[index];
        Entry<K,V> new_entry = new Entry(key, value);

        if (!this.containsKey(key)) {
            table_row.add(new_entry);
            count++;

            return null;
        }

       for (int i = 0; i < table_row.size(); i++) {
           if (table_row.get(i).key == key) {
               V old_val = table_row.get(i).value;
               table_row.set(i, new_entry);
               return old_val;
           }
       }

       return null;
   }

    /** Removes a specific entry from this dictionary.
     @param key An object search key of the entry to be removed.
     @return Either the value that was associated with the search key
     or null if no such object exists.
     */
    public V remove(K key) {
        int index = getIndex(key);

        LinkedList<Entry<K,V>> table_row = table[index];
        V result = null;

        Entry<K,V> last_entry = table_row.getLast();
        if (!this.containsKey(key)) {
            return null;
        }

        for (int i = 0; i < table_row.size(); i++) {
            if (table_row.get(i).key == key) {
                result = table_row.get(i).value;
                table_row.set(i, last_entry);
                count--;
            }
        }

        return result;
    }
    /** Retrieves from this dictionary the value associated with a given
     search key.
     @param key An object search key of the entry to be retrieved.
     @return Either the value that is associated with the search key
     or null if no such object exists. */
    public V get(K key) {
        int index = getIndex(key);
        LinkedList<Entry<K,V>> table_row = table[index];


        if (!this.containsKey(key)) {

            return null;
        }

        for (int i = 0; i < table_row.size(); i++) {
            if (table_row.get(i).key == key) {
                return table_row.get(i).value;
            }
        }

        return null;
    }

    public boolean containsKey(Object key) {
        LinkedList<K> keys = new LinkedList<>();

        for (int i = 0; i < initial_capacity; i++) {
            LinkedList<Entry<K,V>> table_row = table[i];
            if(table_row != null) {
                for (int k = 0; k < table_row.size(); k++) {
                    keys.add(table_row.get(k).key);
                }
            }
            else{
                return false;
            }
        }

        return keys.contains((K)key);
    }

    public Iterator<K> keySet() {
        LinkedList<K> keys = new LinkedList<>();

        for (int i = 0; i < initial_capacity; i++) {
            LinkedList<Entry<K,V>> table_row = table[i];
            for (int k = 0; k < table_row.size(); k++) {
                keys.add(table_row.get(i).key);
            }
        }

        return keys.iterator();
    }

    public Iterator<V> values() {
        LinkedList<V> values = new LinkedList<>();

        for (int i = 0; i < initial_capacity; i++) {
            LinkedList<Entry<K,V>> table_row = table[i];
            for (int v = 0; v < table_row.size(); v++) {
                values.add(table_row.get(i).value);
            }
        }

        return values.iterator();
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public void clear() {


        for(int j = 0; j < table.length -1;j++) {
            LinkedList<Entry<K,V>> table_row = table[j];
            Entry<K,V> last_entry = table_row.getLast();
            for (int i = 0; i < table_row.size(); i++) {
                table_row.set(i, last_entry);
                count--;
            }
        }
    }
}


