
/**
 * 在这里给出对类 Part3 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class Part3 {
    public String twoOccurrences(String stringa, String stringb){
        int l = stringa.length();
        int startIndex = stringb.indexOf(stringa);
        if (startIndex == -1){return "false";}
        int secondIndex = stringb.indexOf(stringa,startIndex+l);
        if (secondIndex !=-1){
        return "true"; }else{
        return "false";} 
    }
    
    public void testOccurrences(){
        String result = twoOccurrences("by","A story by Abby Long");
        System.out.println(result);
        
        String result1 = twoOccurrences("zoo","forest");
        System.out.println(result);
    }
    
    public String lastPart(String stringa, String stringb){
        int l = stringa.length();
        int startIndex = stringb.indexOf(stringa);
        if (startIndex == -1){return stringb;}
        String lastpart = stringb.substring(startIndex+l);
        return lastpart;
    }
    
    public void testLastPart(){
       String result = lastPart("an","banana");
       System.out.println(result);
       
       String result1 = lastPart("zoo","forest");
       System.out.println(result1);
    
    }

}

