import java.util.*;

class LFUCache {
    class Node {
        int key, value, cnt;
        Node next, prev;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.cnt = 1;
        }
    }


    class Dll {
        int size;
        Node head, tail;
        Dll() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }
        void addFront(Node node) {
            Node temp = head.next;
            node.next = temp;
            node.prev = head;
            head.next = node;
            temp.prev = node;
            size++;
        }
        void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
    }

    private final Map<Integer, Node> keyNode;
    private final Map<Integer, Dll> freqListMap;
    private final int maxSizeCache;
    private int minFreq;
    private int curSize;

    public LFUCache(int capacity) {
        keyNode = new HashMap<>();
        freqListMap = new HashMap<>();
//we need the varaible sminfreq and curr size and maxsize cahce 
// sp whenever we have to add and lement we will increase it size if twe have to update freqlist we have to update minfREq also
        maxSizeCache = capacity;
        minFreq = 0;
        curSize = 0;
    }

 //whenerver have to update new node in dll linkedlist
    private void updateFreqListMap(Node node) {
        int oldCount = node.cnt;
        freqListMap.get(oldCount).removeNode(node);
//updating min frequency everytime 
//here e are checking if cyrent node is present n min and als wals it it only node in hta minfreq dll
        if (oldCount == minFreq && freqListMap.get(oldCount).size == 0) {
            minFreq++;
        }
        node.cnt++;
        freqListMap.computeIfAbsent(node.cnt, k -> new Dll()).addFront(node);
    }

    public int get(int key) {
        if (!keyNode.containsKey(key)) {
            return -1;
        }
        Node node = keyNode.get(key);
        updateFreqListMap(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (maxSizeCache == 0) return;
     ///checki
        if (keyNode.containsKey(key)) {
            Node node = keyNode.get(key);
            node.value = value;
            updateFreqListMap(node);
        } else {
//every time removeing an element we doing curr size--;
            if (curSize == maxSizeCache) {
                Dll minList = freqListMap.get(minFreq);
                Node toRemove = minList.tail.prev;
                minList.removeNode(toRemove);
                keyNode.remove(toRemove.key);
                curSize--;
            }
            Node newNode = new Node(key, value);
            minFreq = 1;
            freqListMap.computeIfAbsent(1, k -> new Dll()).addFront(newNode);
            keyNode.put(key, newNode);
            curSize++;
        }
    }
}