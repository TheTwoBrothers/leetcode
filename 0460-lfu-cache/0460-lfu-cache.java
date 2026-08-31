class LFUCache {
    int n;
    HashMap<Integer, Node> map;
    HashMap<Integer, LinkedHashSet<Integer>> freqMap;
    int minfreq;

    class Node {
        int val;
        int freq;

        Node(int val) {
            this.val = val;
            this.freq = 1;
        }
    }

    void incminfreq(int key) {
        Node node = map.get(key);

        int oldfreq = node.freq;

        freqMap.get(oldfreq).remove(key);

        if (oldfreq == minfreq && freqMap.get(oldfreq).isEmpty()) {
            minfreq++;
        }

        node.freq++;

        if (!freqMap.containsKey(node.freq)) {
            freqMap.put(node.freq, new LinkedHashSet<>());
        }

        freqMap.get(node.freq).add(key);
    }

    public LFUCache(int capacity) {
        n = capacity;
        map = new HashMap<>();
        freqMap = new HashMap<>();
        minfreq = 1;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;

        incminfreq(key);

        return map.get(key).val;
    }

    public void put(int key, int value) {

        if (n == 0)
            return;

        
        if (map.containsKey(key)) {
            map.get(key).val = value;
            incminfreq(key);
            return;
        }

       
        if (map.size() == n) {
            LinkedHashSet<Integer> set = freqMap.get(minfreq);

            int removeKey = set.iterator().next();

            set.remove(removeKey);
            map.remove(removeKey);
        }

      
        Node node = new Node(value);
        map.put(key, node);

        if (!freqMap.containsKey(1)) {
            freqMap.put(1, new LinkedHashSet<>());
        }

        freqMap.get(1).add(key);

        minfreq = 1;
    }
}
/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */