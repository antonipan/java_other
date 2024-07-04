package algorithms;

public class Exm12HashTable {
    public static void main(String[] args) {

//        Map<String, Double> map = new HashMap<>();
//
//        map.put("first", 5.5);
//        map.put("second", 6.4);
//        map.put("trird", 7.8);
//        System.out.println(map.get("first"));



    }
}

class Hashtable <K, V>{

    private static final int DEFAULT_SIZE = 16;

    private static final double LOAD_FACTOR = 0.75; // Коэффициент заполненности массива.

    private int sizw = 0; // количество заполненных элементов.


    private Bucket<K, V>[] buckets;

    public Hashtable () {
        this(DEFAULT_SIZE);
    }

    public Hashtable (int size) {
        buckets = new Bucket[size];
    };

    private int calculateIndex (K key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    public void recalculate() {
        Bucket<K,V>[] old = buckets;
        buckets = new Bucket[old.length * 2];
        for (int i = 0; i < old.length; i++) {
            Bucket<K, V> bucket = old[i];
            Bucket.Node currentNode = bucket.root;
            while (currentNode != null) {
                put((K) currentNode.entity.key, (V) currentNode.entity.value);
                currentNode = currentNode.next;
            }
            old[i] = null;
        }
        old = null;
    }

    public V get (K key) {
        int index = calculateIndex(key);
        Bucket <K, V> bucket = buckets[index];
        if (bucket == null) {
            return null;
        }
        return buckets[calculateIndex(key)].get(key);
    }

    public boolean put (K key, V value ) {
        if (buckets.length * LOAD_FACTOR < sizw);
        int index = calculateIndex(key);
        Bucket<K, V> bucket = buckets[index];
        if (bucket == null) {
            bucket = new Bucket<>();
            buckets[index] = bucket;

        }
        boolean added = bucket.add(key, value);
        if (added) {
            sizw++;
        }
        return added;
    }

    public boolean remove (K key) {
        int index = calculateIndex(key);
        Bucket<K, V> bucket = buckets[index];
        boolean removed = bucket.delete(key);

        if (removed) {
            sizw--;
        }
        return removed;

    }

    class Bucket<K, V> {
        Node root;

        public V get (K key) {
            Node currentNode = root;
            while (currentNode != null) {
                if (currentNode.entity.key.equals(key)) {
                    return currentNode.entity.value;
                } else {
                    currentNode = currentNode.next;
                }
                return null;
            }
            return null;
        }
        public boolean add (Entity entity) {
            Node node = new Node();
            node.entity = entity;
            if (root != null) {
                Node currentNode = root;
                while (currentNode != null) {
                    if (currentNode.entity.equals(entity)) {
                        return false;
                    }
                    if (currentNode.next == null) {
                        currentNode.next = node;
                        return true;
                    }
                }
            }
            root = node;
            return true;
        }
        public boolean add (K key, V value) {
            Entity entity = new Entity(key, value);
            return this.add(entity);

        }

        public boolean delete (K key) {
            if (root == null) {
                return false;
            }
            if (root.entity.key.equals(key)) {
                root = root.next;
                return true;
            } else {
                Node currentNode = root;
                while (currentNode.next != null) {
                    if (currentNode.next.entity.key.equals(key)) {
                        currentNode.next = currentNode.next.next;
                    }
                    currentNode = currentNode.next;

                }
            }
            return false;
        }


        private class Node {
            Node next;
            Entity<K, V> entity;


        }



        private class Entity <K, V> {
            K key;
            V value;

            public Entity () {
                key = null;
                value = null;
            }
            public Entity(K key, V value) {
                this.key = key;
                this.value = value;
            }

        }
    }

}


