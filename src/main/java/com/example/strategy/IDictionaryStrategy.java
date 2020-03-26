package com.example.strategy;

public interface IDictionaryStrategy {
    boolean searchDictionary(String word);

    void putDictionary(String... word);
    void putCustomDictionary(String... word);
}
