class Solution {
    public int[] scoreValidator(String[] events) {
        int score = 0;
        int counter = 0;

        for(String st : events){
            if(st.equals("0") || st.equals("1") || st.equals("2") || st.equals("3") || st.equals("4") || st.equals("6")){
                int num = Integer.valueOf(st);
                score+= num;
            }else if(st.equals("W")){
                counter++;
            }else if(st.equals("WD") || st.equals("NB")){
                score+=1;
            }

            if(counter == 10) break;
        }

        return new int[]{score,counter};
    }
}