package com.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

public class LeetCode17 {

    String[] map=new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> res=new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        backtrack(digits,0,new StringBuilder());
        return res;
    }

    void backtrack(String digits,int index,StringBuilder sb ) {
        if(index==digits.length()){
            res.add(sb.toString());
            return;
        }
        int mapIndex = Integer.parseInt(digits.substring(index, index + 1));
        for(int i=0;i<map[mapIndex].length();i++){
            sb.append(map[mapIndex].charAt(i));
            backtrack(digits,index+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
