
/**
 * 在这里给出对类 Part1 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class Part1 {
    public String findSimpleGene(String dna){
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1){return "";}
        int stopIndex = dna.indexOf("TAA",startIndex+3);
        if (stopIndex == -1){return "";}
        String result = dna.substring(startIndex,stopIndex+3);
        if ((stopIndex-startIndex)%3==0){
        return result;}else{
        return "";}
              
    };
    
    public void testSimpleGene(){
        String dna1 = "TGAAAGGGATAAGT";//no ATG
        System.out.println("DAN strand is " + dna1);
        String gene1 = findSimpleGene(dna1);
        System.out.println("Gene is " + gene1);
        
        String dna2 = "TGATGAAATGGGA";//no TAA
        System.out.println("DAN strand is " + dna2);
        String gene2 = findSimpleGene(dna2);
        System.out.println("Gene is " + gene2);
        
        String dna3 = "TGAGAAATGGGA";//no TAA nor ATG
        System.out.println("DAN strand is " + dna3);
        String gene3 = findSimpleGene(dna3);
        System.out.println("Gene is " + gene3);
        
        String dna4 = "TGATGAAAGTGTAAGGA";// with ATG and TAA
        System.out.println("DAN strand is " + dna4);
        String gene4 = findSimpleGene(dna4);
        System.out.println("Gene is " + gene4);
        
        String dna5 = "TGATGAAGGGTAAATGGGA";//not a multiple of 3
        System.out.println("DAN strand is " + dna5);
        String gene5 = findSimpleGene(dna5);
        System.out.println("Gene is " + gene5);
        
        
        
    }

}
