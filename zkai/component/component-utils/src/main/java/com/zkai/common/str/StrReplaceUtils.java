package com.zkai.common.str;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 高效的字符串替换类
 *
 * @author 曹健【115359178@qq.com】
 * @create 2017-06-01 下午 3:37
 **/
public final class StrReplaceUtils {

    private StrReplaceUtils(){}

	private static String replace(String original, String oldChar, String newChar) {
	      
		   if (oldChar == null || newChar == null || oldChar.isEmpty()){
	    	   return original;
	       }
	       
	       //找到要替换的字符串的开始下标
	       int index = original.indexOf(oldChar);
	       if (index == -1) return original;
	       
	       //下标指针
	       int pointer = 0;
	       
	       //老的字符串占用的下标数
	       int oldStrLen = oldChar.length()-1;
	        
	       char[] originalCharArr = original.toCharArray();
	       //构造替换后字符串的长度的空字符数组
	       char[] resultCharArr = new char[original.length() - oldChar.length() + newChar.length()];
	       
	       //循环字符数组
	       for (int i = 0; i < originalCharArr.length; i++) {
	    	   
	    	   //如果是要替换的字符串的下标位置了，就把要新的字符串加入的结果数组里
	           if (i == index) {
	               for (char c : newChar.toCharArray()) {
	                   resultCharArr[pointer] = c;
	                   pointer ++;
	               }
	               //下标往下移原来的字符串长度的位置
	               i += oldStrLen;
	               continue;
	           }
	           //不要替换的原样复制
	           resultCharArr[pointer] = originalCharArr[i];
	           pointer ++;
	       }
	       
	       return replace(new String(resultCharArr), oldChar, newChar);
	   }
	
	 public static String extend(String templateStr, Map<String, String> vars){
		   
		   if(templateStr == null || templateStr.isEmpty()){
			   return templateStr;
		   }
		   
		   if(vars == null || vars.isEmpty()){
			   return templateStr;
		   }
		   
		   for(Iterator<Map.Entry<String,String>> ite = vars.entrySet().iterator(); ite.hasNext();){  
			   Map.Entry<String,String> entry = ite.next();  
			   String key = entry.getKey();  
			   String val = entry.getValue();
			   templateStr = replace(templateStr, "{"+key+"}", val);
		   }
		  
		   return templateStr;
	   }
	   
	   
	   public static void main(String[] args) {  
		   
		   Map<String, String> vars = new HashMap<String, String>(2);
		   vars.put("first", "2");
		   vars.put("second", "3");
		   System.out.println(extend("{first} to {second}",vars));
	   }
}
