class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        HashMap<Integer,List<Integer>> map = new HashMap<>();

        // traverse diagonally ( i - j ) and store the value in the hashMap
        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j<m ; j++){
                if(map.containsKey(i-j)){
                    map.get(i - j).add(mat[i][j]);
                }else{
                    List<Integer> temp = new ArrayList<>();
                    temp.add(mat[i][j]);
                    map.put((i-j),temp);
                }
            }
        }

        // sort each key of the hashMap

        for(int key: map.keySet()){
            Collections.sort(map.get(key));
        }

        // again put the values from hashmap into matrix

        for(int i = 0 ; i < n ; i ++){
            for(int j = 0  ; j<m ; j++){
                int x = i - j;
                mat[i][j] = map.get(x).get(0);
                map.get(x).remove(0);
            }
        }
        return mat;
    }
}