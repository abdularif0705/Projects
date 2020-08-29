import java.util.ArrayList;


class HashNode<K, V>{
    K key;
    V value;
    HashNode<K, V> next;//generic node to pass on next reference

    public HashNode(K key, V value) {//constructor to create a node
        this.key = key;
        this.value = value;
    }
}
//class to represent the phone book
class PhoneBook<K, V> {//map

    private ArrayList<HashNode<K, V>> bucketArray;//bucket array is used to index the keys (array of chains)

    private int numBuckets;//capacity
    private int size;

    public PhoneBook() {
        bucketArray = new ArrayList<>();
        numBuckets = 10;
        size = 0;

        //  empty chains
        for (int i = 0; i < numBuckets; i++) {
            bucketArray.add(null);
        }
    }
    public int size() {//return size of array
        return size;
    }

    public boolean isEmpty() {//check if empty
        return size() == 0;
    }

    //we use this to find the index of each nodes
    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        int index = hashCode % numBuckets;
        return index;
    }
    //to remove a given key and value
    public V remove(K key) {
        int bucketIndex = getBucketIndex(key);

        HashNode<K, V> head = bucketArray.get(bucketIndex);
        HashNode<K, V> prev = null;
        while (head != null) {//transverse through the array, if head == key return it
            //key is found
            if (head.key.equals(key)) {
                break;
            }

            //  keep moving in chain
            prev = head;
            head = head.next;
        }
        // if key not found return null
        if (head == null) {
            return null;
        }
        size--;

        //finally remove key
        if (prev != null) {//change position
            prev.next = head.next;
        }
        else {
            bucketArray.set(bucketIndex, head.next);
        }
        return head.value;
    }
    //get a value from a key input
    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucketArray.get(bucketIndex);

        while (head != null) {
            if (head.key.equals(key)) {//tranverse through if found return it
                return head.value;
            }
            head = head.next;
        }
        return null;//not found return null
    }
    //adds a key and value
    public void add(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucketArray.get(bucketIndex);

        //check if key is present so this is how we deal with collisions
        while (head != null) {
            if (head.key.equals(key)) {//transverse through
                head.value = value;
                return;
            }
            head = head.next;
        }

        //add to the chain
        size++;//increase the size
        head = bucketArray.get(bucketIndex);
        HashNode<K, V> newNode = new HashNode<K, V>(key, value);//create the node
        newNode.next = head;
        bucketArray.set(bucketIndex, newNode);


        if ((1.0 * size) / numBuckets >= 0.7) {
            ArrayList<HashNode<K, V>> temp = bucketArray;
            bucketArray = new ArrayList<>();
            numBuckets = 2 * numBuckets;
            size = 0;
            for (int i = 0; i < numBuckets; i++) {
                bucketArray.add(null);
            }
            //move on the chain
            for (HashNode<K, V> headNode : temp) {
                while (headNode != null) {
                    add(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }
    }
    public void entrySet() {//show all
        ArrayList<HashNode<K, V>> temp = bucketArray;

        for (HashNode<K, V> head : temp) {//go through the generic node and print both key and value
            while (head != null) {
                System.out.println(head.key+" "+head.value);
                head = head.next;
            }
        }
    }
    public void keySet() {//show names
        ArrayList<HashNode<K, V>> keys = bucketArray;//all entryset, keyset, and values are the same

        for (HashNode<K, V> head : keys) {
            while (head != null) {
                System.out.println(head.key);
                head = head.next;
            }
        }
    }
    public void values() {//show numbers
        ArrayList<HashNode<K, V>> value = bucketArray;

        for (HashNode<K, V> head : value) {
            while (head != null) {
                System.out.println(head.value);
                head = head.next;
            }
        }
    }
}