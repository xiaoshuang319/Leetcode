class Solution {
    public List<String> generatePalindromes(String s) {
      if(s.length() == 0)return new ArrayList<>();
      int[]freq = new int[26];
      for(char c : s.toCharArray()){
          freq[c - 'a']++;
      }
      boolean odd = false;
      for(int i = 0; i < 26; i++){
          if(freq[i] % 2 == 1){
              if(odd){
                  return new ArrayList<>();
              }
              odd = true;
          }
      }
      int len = s.length();
      List<String>result = new ArrayList<>();
      String path = new String();
      //deal with odd freq;
      for(int i = 0; i < 26; i++){
           if(freq[i] % 2 != 0){
               freq[i]--;
               path += (char)(i + 97);
               break;
           }
      }
      helper(result, path, freq, len);
      return result;
    }
    private void helper(List<String>result, String path,int[]freq, int len){
          if(path.length() == len){
              result.add(path);
              return;
          }
          for(int i = 0; i < 26; i++){
              if(freq[i] > 0){
                  freq[i] -= 2;
                  String newTemp = (char)(i + 97) + path + (char)(i + 97);
                  helper(result, newTemp, freq, len);
                  freq[i] += 2;
              }
          }
      }
}
