package com.example.strategy;

import com.example.util.WordDictionary;

public class BothDictionaryStrategy implements IDictionaryStrategy {

    @Override
    public boolean searchDictionary(String word) {
        return (WordDictionary.searchCustomDictionaries(word) == true ? true : WordDictionary.searchDictionaries(word));
    }

    @Override
    public void putDictionary(String... word) {
        WordDictionary.putDictionary(word);
    }

    @Override
    public void putCustomDictionary(String... word) {
        WordDictionary.putDictionary(word);
    }


}
