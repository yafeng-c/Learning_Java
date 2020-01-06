
/**
 * 在这里给出对类 part1 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import edu.duke.*;
import org.apache.commons.csv.*;
public class part1 {
    public void tester(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        //System.out.println(countryInfo(parser,"Nauru"));
        //listExportersTwoProducts(parser,"gold","diamonds");
        bigExporters(parser,"\\$999,999,999,999");
        //System.out.println(numberOfExporters(parser,"gold"));
    }
    public String countryInfo(CSVParser parser, String country){
        for (CSVRecord record: parser){
            String coun = record.get("Country");
            if (coun.contains(country)){
                String export = record.get("Exports");
                String value = record.get("Value (dollars)");
                String info = country + ": " + export + ": " + value;
                return info;
            }
        }
        return "NOT FOUND";
    }
    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2){
        for (CSVRecord record: parser){
            String export = record.get("Exports");
            if (export.contains(exportItem1) & export.contains(exportItem2)){
                String country = record.get("Country");
                System.out.println(country);
            }
        }        
    }
    public int numberOfExporters(CSVParser parser, String exportItem){
        int num = 0;
        for (CSVRecord record: parser){
            String export = record.get("Exports");
            if (export.contains(exportItem)) {
                num = num + 1;
            }
        } 
        return num;
    }
    public void bigExporters(CSVParser parser, String amount){
        for (CSVRecord record: parser){
            String value = record.get("Value (dollars)");
            if (value.length() > amount.length()){
                String country = record.get("Country");
                System.out.println(country + " " + value);
            }
        } 
        
    }
    
}
