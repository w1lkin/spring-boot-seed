package com.welkin.springboot.test.java;

import com.alibaba.fastjson.JSON;
import com.welkin.springboot.test.BaseTests;
import org.junit.Test;

import java.util.*;

public class JavaTests extends BaseTests {

  @Test
  public void mapTest() {
    Map<Integer, Integer> linkedHashMap = new LinkedHashMap();
    linkedHashMap.put(null, 1);
    linkedHashMap.put(3, 1);
    linkedHashMap.put(2, 1);
    linkedHashMap.put(1, null);

    Map<Integer, Integer> hashMap = new HashMap<>();
    hashMap.put(null, 1);
    hashMap.put(3, 1);
    hashMap.put(2, 1);
    hashMap.put(1, null);

    Map<Integer, Integer> hashtable = new Hashtable<>();
    //        map2.put(null,1);
    hashtable.put(3, 1);
    hashtable.put(2, 1);
    //        map2.put(1,null);

    Map<Integer, Integer> treeMap = new TreeMap<>();
    //        map3.put(null,1);
    treeMap.put(3, 1);
    treeMap.put(2, 1);
    //        map3.put(1,null);

    System.out.println(
        "linkedHashMap:"
            + JSON.toJSONString(linkedHashMap)
            + " hashMap:"
            + JSON.toJSONString(hashMap)
            + " hashtable:"
            + JSON.toJSONString(hashtable)
            + " treeMap:"
            + JSON.toJSONString(treeMap));
  }

  @Test
  public void stringTest() {
    String a = "1234";
    String b = "1234";
    String c = new String("1234");
    System.out.println(a == b); // true
    System.out.println(a == c); // false
    System.out.println(a.equals(c)); // true
  }

  @Test
  public void knapsackTest() {
    int[] nums = {2, 5, 3, 7, 8};
    int target = 10;
    System.out.println(Solution.combinationSum(nums, target));
  }
}
