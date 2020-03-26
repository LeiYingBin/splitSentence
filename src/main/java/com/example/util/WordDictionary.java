package com.example.util;


import java.util.HashSet;
import java.util.Set;

public class WordDictionary {
    private static Set<String> dictionaries = new HashSet<>(50000);
    private static Set<String> customDictionaries = new HashSet<>(5000);

    public static void putDictionary(String word){
        if(null == word || "" == word){
            return;
        }
        dictionaries.add(word);
    }
    public static void putDictionary(String... words){
        if(null == words || words.length == 0){
            return;
        }
        for(String word : words){
            if(word.contains(" ")){
                String[] array = word.split(" ");
                for(String str : array){
                    putDictionary(str);
                }
            } else {
                putDictionary(word);
            }
        }
    }

    public static void putCustomDictionary(String word){
        if(null == word || "" == word){
            return;
        }
        customDictionaries.add(word);
    }
    public static void putCustomDictionary(String... words){
        if(null == words || words.length == 0){
            return;
        }
        for(String word : words){
            if(word.contains(" ")){
                String[] array = word.split(" ");
                for(String str : array){
                    putCustomDictionary(str);
                }
            } else {
                putCustomDictionary(word);
            }
        }
    }

    public static boolean searchDictionaries(String word){
        if(null == word || "" == word){
            return false;
        }
        if(dictionaries.contains(word)){
            return true;
        } else {
            return false;
        }
    }

    public static boolean searchCustomDictionaries(String word){
        if(null == word || "" == word){
            return false;
        }
        if(customDictionaries.contains(word)){
            return true;
        } else {
            return false;
        }
    }

    public static boolean searchBothDictionaries(String word){
        return (searchCustomDictionaries(word) == true ? true : searchDictionaries(word));

    }


}
