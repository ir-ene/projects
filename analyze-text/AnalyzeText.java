import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
public class AnalyzeText
{
    public static void main (String[] args)
    throws FileNotFoundException {
        Scanner s = new Scanner(new File("SampleText.txt")); //you can replace this with any .txt file to analyze
        ArrayList <String> wordList = new ArrayList<>();
        ArrayList <Integer> freqList = new ArrayList<>();
        ArrayList <String> hyphenList = new ArrayList<>();
        String newWord = "";
        do {
            newWord = s.next(); 
            newWord = newWord.replaceAll("[^a-zA-Z'-]+", "").toLowerCase();
            int i = wordList.indexOf(newWord);
            int f = newWord.indexOf("-");
            if (f>=0) hyphenList.add(newWord); //if index is >=0 then the word contains a hyphen
            if (i>=0){ //if index is >=0 then the word is already in the arraylist
                int currentFreq = freqList.get(i)+1;
                freqList.set(i,currentFreq);
            }
            else {
                wordList.add(newWord);
                freqList.add(1);

            }
        }
        while (s.hasNext());
        System.out.println("A. Top 10 words: ");
        System.out.println("Word\tFrequency");
        for (int i=0; i<10; i++){
            int freq = 0;
            int index=0;
            for (int f = 0; f<freqList.size(); f++){
                if (freqList.get(f)>freq){ //if the frequency at index f is greater than the current frequency
                    freq = freqList.get(f);
                    index=freqList.indexOf(freq);
                }
            }
            System.out.println(wordList.get(index)+"\t"+freq);
            wordList.remove(index); freqList.remove(index); //remove the highest freq word and moves to the next highest freq
        }
        System.out.println("************************");
        Collections.sort(hyphenList);
        System.out.println("B. Hyphenated words:");
        for (String h : hyphenList) System.out.println(h);
        System.out.println("************************");
    }
}
