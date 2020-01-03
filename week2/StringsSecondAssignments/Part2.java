
/**
 *  a method to determine how many occurrences of a 
 *  string appear in another string
 * 
 * @YChen
 * @2019/12/28
 */
public class Part2 {
    public int howMany(String stringa, String stringb){
        int count = 0;
        int startIndex = 0;
        while(true){
            int currIndex = stringb.indexOf(stringa,startIndex);
            if(currIndex == -1){
                break;
            }
            startIndex = stringb.indexOf(stringa,startIndex)+
            stringa.length();
            count = count +1;
            
        }
        return count;
    }
    
    public void testHowMany(){
        int count1 = howMany("GAA", "ATGAACGAATTGAATC");
        System.out.println(count1);
        int count2 =  howMany("AA", "ATAAAA");
        System.out.println(count2);
        
    }

}
