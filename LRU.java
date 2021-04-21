/*class LRUCache {
    Map<Integer,Integer>cache;
    int capacity;
    public LRUCache(int capacity) {
        cache = new LinkedHashMap<Integer,Integer>(){
          @Override
            public boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest){
               return this.size() > capacity;
           } 
        };
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
          int value = cache.get(key);
          cache.remove(key);
          cache.put(key,value);
          return value;
        }
      return -1;
    }
    
    public void put(int key, int value) {
        cache.remove(key);
        cache.put(key,value);
    }
}

*/
/*Map + LinkedLit

for get action : 
   if map contains key, then delete node from map,list , put back to map and list again 
   if map does not contains key, then return -1;
   
 for put action, if map.size() has not exceed capacity, then put back to map and list 
                  if map.size() exceeded capacity, then delete head from list and map. then put back into map and list again.

*/
class LRUCache{
  Map<Integer,Node>map = new HashMap<>();
  MyLinkedList list = new  MyLinkedList ();
  int capacity;
  public LRUCache(int capacity){
    this.capacity = capacity;
  }
  public int get(int key){
    if(!map.containsKey(key)){
      return -1;
      //throw new RuntimeException("not found");
    }
    Node node = map.get(key);
    list.deleteByNode(node);
    list.addToTail(node);
    return node._value;
  }
  public void put(int key, int value){
    Node node;
    if(map.containsKey(key)){
      node = map.get(key);
      node._value = value;
      list.deleteByNode(node);
    }else{
      if(map.size() == capacity){
        Node head = list.deleteHead();
        map.remove(head._key);
      }
      node = new Node(key,value);
    }
    list.addToTail(node);
    map.put(key,node);
  }
  
}


class MyLinkedList {
    Node _dummyHead;
    Node _dummyTail;
    
    public MyLinkedList() {
        _dummyHead = new Node(0, 0);
        _dummyTail = new Node(0, 0); 
        _dummyHead._next = _dummyTail;
        _dummyTail._prev = _dummyHead;
    }
    
    public void deleteByNode(Node node) {
        node._prev._next = node._next;
        node._next._prev = node._prev;
    }
    
    public Node deleteHead() {
        Node head = _dummyHead._next;
        _dummyHead._next = head._next;
        head._next._prev = _dummyHead;
        return head;
    }
    
    public Node addToTail(Node node) {
        _dummyTail._prev._next = node;
        node._prev = _dummyTail._prev;
        _dummyTail._prev = node;
        node._next = _dummyTail;
        return node;
    }
}

class Node {
    Node _prev;
    Node _next;
    int _key;
    int _value;
    
    public Node(int key, int value) {
        _key = key;
        _value = value;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
