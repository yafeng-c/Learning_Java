
/**
 * 在这里给出对类 Part4 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import edu.duke.*;
public class Part4 {
    public void findURL(String url){
        URLResource ur = new URLResource(url);
        for (String word: ur.words()){
            int pos = word.toLowerCase().indexOf("youtube.com");
            if(pos!=-1){
                int quoteIndex = word.lastIndexOf("\"",pos);
                int lastIndex = word.indexOf("\"",pos+1);
                String result = word.substring(quoteIndex+1,lastIndex);
                System.out.println(result);
            }
        }
    }
    
    public void testUrl(){
    String url = "http://www.dukelearntoprogram.com/course2/data/manylinks.html";
    findURL(url);
    }


}

