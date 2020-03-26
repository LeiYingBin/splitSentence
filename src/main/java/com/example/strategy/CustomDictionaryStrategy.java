package com.example.strategy;

import com.example.util.WordDictionary;

public class CustomDictionaryStrategy implements IDictionaryStrategy {

    @Override
    public boolean searchDictionary(String word) {
        return WordDictionary.searchCustomDictionaries(word);
    }

    @Override
    public void putDictionary(String... word) {
    }

    @Override
    public void putCustomDictionary(String... word) {
        WordDictionary.putCustomDictionary(word);
    }
}
