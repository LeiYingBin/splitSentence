package com.example.strategy;

import com.example.util.WordDictionary;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {
    static IDictionaryStrategy strategy;

    public Tokenizer(IDictionaryStrategy strategy){
        this.strategy = strategy;
    }

    public void addWords(String... word){
        strategy.putDictionary(word);
    }

    public void addCustomWords(String... word){
        strategy.putCustomDictionary(word);
    }

    public List<String> splitSentence(String sentence){
        if(null == sentence || "" == sentence){
            return null;
        }
        List<String> sentenceList = new ArrayList<>();
        List<List<String>> sentenceWordLists = new ArrayList<>();
        splitSentence(sentence,new ArrayList<String>(),sentenceWordLists);
        StringBuilder stringBuilder;
        if(null == sentenceWordLists || sentenceWordLists.size() == 0){
            return null;
        }
        //组合成一个句子
        stringBuilder = new StringBuilder();
        for (List<String>list : sentenceWordLists){
            for(String str : list){
                stringBuilder.append(str);
                stringBuilder.append(" ");
            }
            sentenceList.add(stringBuilder.toString());
            stringBuilder = new StringBuilder();
        }
        return sentenceList;
    }
    public static void splitSentence(String sentence, List<String> sentenceWords, List<List<String>> sentenceWordLists){
        if(null == sentence || "" == sentence){
            return;
        }
        char[] letters = sentence.toCharArray();
        StringBuilder str = new StringBuilder("");
        for(int i = 0; i < sentence.length(); i++){
            str.append(letters[i]);
            //成功匹配
            if(strategy.searchDictionary(str.toString())){
                //如果已经到末尾，则跳出该循环
                if(i == sentence.length()-1){
                    sentenceWords.add(str.toString());
                    sentenceWordLists.add(sentenceWords);
                    return;
                }
                List<String> newSentenceWord = new ArrayList<>();
                newSentenceWord.addAll(sentenceWords);
                newSentenceWord.add(str.toString());
                //继续分割
                splitSentence(sentence.substring(i+1,sentence.length()),newSentenceWord,sentenceWordLists);
            }
        }
    }

}
