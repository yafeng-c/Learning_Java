
/**
 * 在这里给出对类 part2 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class part2 {
    public void findAbc(String input){
       int index = input.indexOf("abc");
       System.out.println("index " + index);
       while (true){
           if (index == -1 || index >= input.length() - 3){
               break;
           }
           String found = input.substring(index+1, index+4);
           System.out.println(found);
           index = input.indexOf("abc",index+3);
           System.out.println("index after updating " + index);
       }
   }

   public void test(){
       //findAbc("abcd");
       findAbc("abcabcabcabca");
   }

}
