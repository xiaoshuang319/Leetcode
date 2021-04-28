class RandomizedSet {
    Map<Integer,Integer>numToIndex;
    List<Integer>indexToNum;
    Random random;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        numToIndex = new HashMap<>();
        random = new Random();
        indexToNum = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(numToIndex.containsKey(val)){
            return false;
        }
        numToIndex.put(val, indexToNum.size());
        indexToNum.add(indexToNum.size(),val);
        return true;
        
       
        
        
        
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!numToIndex.containsKey(val)){
            return false;
        }
        int lastEle = indexToNum.get(indexToNum.size() - 1);
        int deletedIndex = numToIndex.get(val);
        indexToNum.set(deletedIndex, lastEle);
        numToIndex.put(lastEle,deletedIndex);
        numToIndex.remove(val);
        indexToNum.remove(indexToNum.size() - 1);
        return true;  
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int randomIndex = random.nextInt(indexToNum.size());
        return indexToNum.get(randomIndex);
        
        
         
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
