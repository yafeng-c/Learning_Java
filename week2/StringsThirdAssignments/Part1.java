
/**
 * use a StorageResource to store the genes you 
 * find instead of printing them out
 * 
 * YChen
 * 2019/12/30
 */
import edu.duke.*;
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
    
    public StorageResource getAllGenes(String dna){
        int startIndex = 0;
        StorageResource geneList = new StorageResource();
        while(true){
        String gene = findGene(dna,startIndex);
        if (gene.isEmpty()){
            break;
        }
        geneList.add(gene);
        startIndex = dna.indexOf(gene,startIndex)+gene.length();
        }
        return geneList;
    }
    
    public int countGenes(String dna){
        int startIndex = 0;
        int count = 0;
        StorageResource geneList = new StorageResource();
        while(true){
        String gene = findGene(dna,startIndex);
        if (gene.isEmpty()){
            break;
        }
        count = count + 1;
        geneList.add(gene);
        startIndex = dna.indexOf(gene,startIndex)+gene.length();
        }
        return count;
    }
    
    public void testAllGenes(){
        String dna = "ATGTAAGATGCCCTAGT";
        for (String g : getAllGenes(dna).data()){
            System.out.println(g);
        }
    }
    
    public float cgRatio(String dna){
        float ratio = 0;
        int CG = 0;
        for (int i = 0; i < dna.length(); i++){
            char ch = dna.charAt(i);
            if (ch == 'C' | ch == 'G'){
              CG = CG + 1;  
            }
        }
        ratio = ((float)CG)/dna.length();
        return ratio;
    }
    
    public int countCTG(String dna){
        int count = 0;
        int startIndex = dna.indexOf("CTG");
        while(true){
            if (startIndex == -1){
                break;
            }
            count = count + 1;
            startIndex = dna.indexOf("CTG",startIndex + 1);
        }
        return count;
    
    }
    
    public void testRatio(){
       String dna = "ATGCCATAG";
       System.out.println(cgRatio(dna));
    
    }
    
    public void testCTG(){
        String dna = "ACTGCCATCTGCTGAG";
        System.out.println(countCTG(dna));
    }
    
    public void processGenes(StorageResource sr){
        int num = 0;
        int numCG = 0;
        int lengthG = 0;
        int length60 = 0;
        for (String s : sr.data()){
            if (s.length()>9){
                num = num + 1;
                System.out.println("Strings longer than 9: " +s);
            }
            if (cgRatio(s)>0.35){
                numCG = numCG + 1;
                System.out.println("CG-ratio > 0.35: " + s);
            }
            
            if (lengthG <= s.length()){
                lengthG = s.length();
            }
            
            if(s.length()>60){
                length60 = length60 + 1;
                System.out.println("length > 60: " + s);
            }
        }
        
        System.out.println("number of Strings longer than 9: " +
        num);
        System.out.println("number of CG-ratio > 0.35: " + numCG);
        System.out.println("largest length: " + lengthG);
        System.out.println("number of Strings longer than 60: " +
        num);
    }
    
    public void testProcessGenes(){
        FileResource fr = new FileResource();
        String dna = fr.asString().toUpperCase();
        StorageResource geneList1 = getAllGenes(dna);
        processGenes(geneList1);
        System.out.println("gene number in file: " + 
        countGenes(dna));
        
        // String nineLong = "ATGxxxTAAyyyATGxxxTAG";             //no genes longer than 9
        // StorageResource geneList = getAllGenes(nineLong);
        // processGenes(geneList);

        // String dna1 = "ATGxxxyyyTAAyyyATGxxxyyyxxxyyyxxxTAG";  //2 genes longer than 9
        // geneList = getAllGenes(dna1);
        // processGenes(geneList);

        // String dna2 = "ATGCGCCyyTAAyyyATGxxxyyyCGGGGCxxxTAG";  //genes with 0.35+ CG ratio
        // geneList = getAllGenes(dna2);
        // processGenes(geneList);

        // String dna3 = "ATGxxxyyyxxxyyyTAG";                    //genes with 0.35- CG ratio
        // geneList = getAllGenes(dna3);
        // processGenes(geneList);
        
    }

}
