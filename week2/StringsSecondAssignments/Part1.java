
/**
 * A. Find a gene in a strand of DNA where the stop codon could 
 *  be any of the three stop codons “TAA”, “TAG”, or “TGA”.
 * B. Find all the genes (where the stop codon could be
 *  any of the three stop codons) in a strand of DNA.
 * 
 * @YChen
 * @2019/12/28
 */
public class Part1 {
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
    
    public void testFindStopCodon(){
        String dna1 = "ATGTTTAAGTGTTAA";
        int stopIndex1 = findStopCodon(dna1,0,"TAA");
        System.out.println(stopIndex1);
        
        String dna2 = "ATGGG";
        int stopIndex2 = findStopCodon(dna2,0,"TAA");
        System.out.println(stopIndex2);
        
        String dna3 = "ATGGGGTAAT";
        int stopIndex3 = findStopCodon(dna3,0,"TAA");
        System.out.println(stopIndex3);
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
    
    public void testFindGene(){
        String dna1 = "ATFGGGTTTAAATAATTTTAGAAA";
        String dna2 = "TTTATGTTTAAATTTTAGTTAAGGG";
	String dna3 = "AAAATGAAATTTGGGTGAGGGTAGTTT";
	String dna4 = "GGGATGTGTTTTTTTGAGGGTAGAAA";
	
	System.out.println(findGene(dna1,0));
        System.out.println(findGene(dna2,0));
	System.out.println(findGene(dna3,0));
	System.out.println(findGene(dna4,0));
    }
    
    public void printAllGenes(String dna){
        int startIndex = 0;
        while(true){
        String gene = findGene(dna,startIndex);
        if (gene.isEmpty()){
            break;
        }
        System.out.println(gene);
        startIndex = dna.indexOf(gene,startIndex)+gene.length();
        }
        
    }
    
    public void testAllGenes(){
        String dna = "ATGTAAGATGCCCTAGT";
        printAllGenes(dna);
    }

}
