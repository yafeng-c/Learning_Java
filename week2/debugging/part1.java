
/**
 * 在这里给出对类 part1 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class part1 {
    
    public void findAbc(String input) {
    int index = input.indexOf("abc");
    while (true) {
        if (index == -1) {
            break;
        }
        String found = input.substring(index+1, index+4);
        System.out.println(found);
        index = input.indexOf("abc", index+4);
    }
}
   public void test() {
    //no code yet
    findAbc("abcdkfjsksioehgjfhsdjfhksdfhuwabcabcajfieowj");
}

}
