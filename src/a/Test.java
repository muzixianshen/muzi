package a;

import java.util.Scanner;

/** 
 * 根据输入的整数返回回文数的demo 
 * @author Administrator 
 * 
 */ 
public class Test {
	public static int huiwenCount = 0;  
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	    System.out.print("请输入一个正整数：");  
	    int num = scanner.nextInt();  
	    if( ! (num>=10 && num<=1000 ) ){  
	        System.err.println("输入的整数不满足规范。");  
	        return;  
	    }  
	    int total = calcNumTotal(num);  
	    calcHuiWenNum(total,num);  

	    if(huiwenCount==0){  
	        System.out.println("Impossible");  
	    }else{  
	        System.out.println("总共统计出回文数有"+ huiwenCount + "个！");  
	    } 
	}
	
	/** 
     * 根据传递的参数，返回该整数 所有数字之和 
     * @param num 
     * @return 
     */  
	 public static int calcNumTotal(int num){  
	        int total = 0;  
	        String tempStr = String.valueOf(num);  
	        for (int i = 0; i < tempStr.length(); i++) {  
	            total = total + Integer.valueOf(tempStr.subSequence(i, i+1).toString());  
	        }  
	        return total;  
	    }  
	 
	 /** 
	     * 根据传递的参数判断是否是回文数 
	     * @param num 
	     * @return 
	     */  
	    public static boolean isHuiWenNum(int newNum, int oldNum){  
	        if(oldNum >= newNum){  
	            return false;  
	        }  
	        String tempStr = String.valueOf(newNum);  
	        int tempLoop = tempStr.length() / 2;  
	        for(int i=0; i < tempLoop; i++){  
	            //System.out.println(tempStr.subSequence(i, i+1).toString() + "__" + tempStr.subSequence(tempStr.length()-i-1, tempStr.length()-i).toString());  
	            if(!tempStr.subSequence(i, i+1).toString().equals(tempStr.subSequence(tempStr.length()-i-1, tempStr.length()-i).toString())){  
	                return false;  
	            }  
	        }  
	        if(calcNumTotal(newNum)!=calcNumTotal(oldNum)){  
	            return false;  
	        }  
	        return true;  
	    }  
	      
	    /** 
	     * 统计所有满足条件的回文数 
	     * @param total 
	     * @param oldNum 
	     */  
	    public static void calcHuiWenNum(int total, int oldNum){  
	        int tempLoop = total / 2;  
	        for(int i = 1; i < tempLoop; i++){  
	            int index = 1;  
	            int temp = total - 2 * i;  
	            calcHuiWenDetail(temp, i, oldNum);  
	        }     
	    }     
	    /** 
	     * 递归拆分当前传递的temp变量，取出满足条件的数字拼接之后匹配是否回文数 
	     * @param temp 
	     * @param i 
	     * @param oldNum 
	     */  
	    public static void calcHuiWenDetail(int temp, int i, int oldNum){  
	        if(temp >= 0){  
	            if(temp>9){ //大于9就会出问题，组成x的所有数字之和与组成y的所有数字之和不相等  
	                //这里还需要做处理，但是不会啊！！  
	            }  
	            String jiaVal = "";  
	            for(int j=0; j<i; j++){  
	                jiaVal += String.valueOf(i);  
	            }  
	            String newNum = jiaVal + String.valueOf(temp) + jiaVal;  
	            //System.out.println("newNum:" + newNum);  
	            if(newNum.length()>9){  //如果超过2的31次方就会报转换出错！  
	                return;  
	            }  
	            if(isHuiWenNum(Integer.valueOf(newNum).intValue(),oldNum)){  
	                System.out.println(newNum + ": 回文数！");  
	                huiwenCount++;  
	            }  
	            int temp_1 = temp - 2 * i;  
	            calcHuiWenDetail(temp_1, i, oldNum); //如果temp_1大于等于0就表示可以继续拆分。  
	            //这里还有一个问题，回文数都是成双成对的，比如12321满足，同样21312也满足，可是目前还没有实现。  
	        }  
	    }  
}
