
/**
 * count how many genes are in a strand of DNA
 * 
 * @YChen
 * @2019/12/28
 */
public class Part3 {
    public int findStopCodon(String dna, int startIndex,
    String stopCodon){
        int stopIndex = dna.indexOf(stopCodon,startIndex+3);
        while (stopIndex != -1){
            if ((stopIndex - startIndex) % 3 == 0){
             return stopIndex;
            }else{
             stopIndex = dna.indexOf(stopCodon,stopIndex+1);
            }
        }
        int length = dna.length();
        return length;
    }
    
 
    public String findGene(String dna, int currIndex){
        int startIndex = dna.indexOf("ATG", currIndex);
        if (startIndex == -1){
           return "";
        }
        int index1 = findStopCodon(dna,startIndex,"TAA");
        int index2 = findStopCodon(dna,startIndex,"TAG");
        int index3 = findStopCodon(dna,startIndex,"TGA");
        int stopIndex = Math.min(index1, Math.min(index2,index3));
        if (stopIndex == dna.length()){return "";}
        String gene = dna.substring(startIndex,stopIndex+3);
        return gene;
    }
      
    
    public int countGenes(String dna){
        int startIndex = 0;
        int count = 0;
        while(true){
         String gene = findGene(dna,startIndex);
         if (gene.isEmpty()){
            break;
         }
         startIndex = dna.indexOf(gene,startIndex)+gene.length();
         count = count + 1;
        }
        return count;
    }
    
    public void testCountGenes(){
        String dna = "ATGTAAGATGCCCTAGT";
        System.out.println(countGenes(dna));
    }

}
