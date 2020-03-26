package com.example.strategy;

import com.example.util.WordDictionary;

public class RegularDictionaryStrategy implements IDictionaryStrategy {

    @Override
    public boolean searchDictionary(String word) {
        return WordDictionary.searchDictionaries(word);
    }

    @Override
    public void putDictionary(String... word) {
        WordDictionary.putDictionary(word);
    }

    @Override
    public void putCustomDictionary(String... word) {

    }
}
