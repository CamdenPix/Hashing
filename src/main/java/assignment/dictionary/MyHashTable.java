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

    private int getIndex(Object key) {
        return (int)key % initial_capacity;
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

    public V remove(K key) {
        return null;
    }

    public V get(K key) {
        return null;
    }

    public boolean containsKey(Object key) {
        LinkedList<K> keys = new LinkedList<>();

        for (int i = 0; i < initial_capacity; i++) {
            LinkedList<Entry<K,V>> table_row = table[i];
            for (int k = 0; k < table_row.size(); k++) {
                keys.add(table_row.get(i).key);
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
        return null;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public void clear() {
        ;
    }
}


