package com.example.demo;

import com.example.strategy.BothDictionaryStrategy;
import com.example.strategy.CustomDictionaryStrategy;
import com.example.strategy.RegularDictionaryStrategy;
import com.example.strategy.Tokenizer;
import com.example.util.WordDictionary;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void stageOne() {
		Tokenizer tokenizer = new Tokenizer(new RegularDictionaryStrategy());
		tokenizer.addWords("i", "like", "sam", "sung", "samsung", "mobile", "ice", "cream", "man go","and");
		System.out.println("input:ilikesamsungmobile");
		System.out.println("Output:");
		List<String> list = tokenizer.splitSentence("ilikesamsungmobile");
		for(String str : list){
			System.out.println(str);
		}
		System.out.println();
		System.out.println("input:ilikeicecreamandmango");
		System.out.println("Output:");
		list = tokenizer.splitSentence("ilikeicecreamandmango");
		for(String str : list){
			System.out.println(str);
		}
	}

	@Test
	void stageTwo() {
		Tokenizer tokenizer = new Tokenizer(new CustomDictionaryStrategy());
		tokenizer.addCustomWords("i", "like", "sam", "sung", "mobile", "icecream", "man go", "mango","and");
		System.out.println("input:ilikesamsungmobile");
		System.out.println("Output:");
		List<String> list = tokenizer.splitSentence("ilikesamsungmobile");
		for(String str : list){
			System.out.println(str);
		}
		System.out.println();
		System.out.println("input:ilikeicecreamandmango");
		System.out.println("Output:");
		list = tokenizer.splitSentence("ilikeicecreamandmango");
		for(String str : list){
			System.out.println(str);
		}
	}

	@Test
	void stageThree() {
		Tokenizer tokenizer = new Tokenizer(new BothDictionaryStrategy());
		tokenizer.addWords("i", "like", "sam", "sung", "samsung", "mobile", "ice", "cream", "man go","and");
		tokenizer.addCustomWords("i", "like", "sam", "sung", "mobile", "icecream", "man go", "mango");

		System.out.println("input:ilikesamsungmobile");
		System.out.println("Output:");
		List<String> list = tokenizer.splitSentence("ilikesamsungmobile");
		for(String str : list){
			System.out.println(str);
		}
		System.out.println();
		System.out.println("input:ilikeicecreamandmango");
		System.out.println("Output:");
		list = tokenizer.splitSentence("ilikeicecreamandmango");
		for(String str : list){
			System.out.println(str);
		}
	}





}
