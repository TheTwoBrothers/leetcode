class LRUCache {
    int n;
    HashMap<Integer,Integer>map;
    LinkedHashSet<Integer>set;
    public LRUCache(int capacity) {
        n=capacity;
        map=new HashMap<>();
        set=new LinkedHashSet<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        set.remove(key);    
        set.add(key);
        return map.get(key);    
    }
    
    public void put(int key, int value) {
       if(map.containsKey(key))
       {
            map.put(key,value);
            set.remove(key);
            set.add(key);
            return;
       }
       if(map.size()==n)
       {
           int removeKey = set.iterator().next();
            System.out.println(removeKey);
            set.remove(removeKey);
            map.remove(removeKey);
       }
       map.put(key,value);
       set.add(key); 
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */