package a;

import java.util.Scanner;

/** 
 * ����������������ػ�������demo 
 * @author Administrator 
 * 
 */ 
public class Test {
	public static int huiwenCount = 0;  
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	    System.out.print("������һ����������");  
	    int num = scanner.nextInt();  
	    if( ! (num>=10 && num<=1000 ) ){  
	        System.err.println("���������������淶��");  
	        return;  
	    }  
	    int total = calcNumTotal(num);  
	    calcHuiWenNum(total,num);  

	    if(huiwenCount==0){  
	        System.out.println("Impossible");  
	    }else{  
	        System.out.println("�ܹ�ͳ�Ƴ���������"+ huiwenCount + "����");  
	    } 
	}
	
	/** 
     * ���ݴ��ݵĲ��������ظ����� ��������֮�� 
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
	     * ���ݴ��ݵĲ����ж��Ƿ��ǻ����� 
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
	     * ͳ���������������Ļ����� 
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
	     * �ݹ��ֵ�ǰ���ݵ�temp������ȡ����������������ƴ��֮��ƥ���Ƿ������ 
	     * @param temp 
	     * @param i 
	     * @param oldNum 
	     */  
	    public static void calcHuiWenDetail(int temp, int i, int oldNum){  
	        if(temp >= 0){  
	            if(temp>9){ //����9�ͻ�����⣬���x����������֮�������y����������֮�Ͳ����  
	                //���ﻹ��Ҫ���������ǲ��ᰡ����  
	            }  
	            String jiaVal = "";  
	            for(int j=0; j<i; j++){  
	                jiaVal += String.valueOf(i);  
	            }  
	            String newNum = jiaVal + String.valueOf(temp) + jiaVal;  
	            //System.out.println("newNum:" + newNum);  
	            if(newNum.length()>9){  //�������2��31�η��ͻᱨת������  
	                return;  
	            }  
	            if(isHuiWenNum(Integer.valueOf(newNum).intValue(),oldNum)){  
	                System.out.println(newNum + ": ��������");  
	                huiwenCount++;  
	            }  
	            int temp_1 = temp - 2 * i;  
	            calcHuiWenDetail(temp_1, i, oldNum); //���temp_1���ڵ���0�ͱ�ʾ���Լ�����֡�  
	            //���ﻹ��һ�����⣬���������ǳ�˫�ɶԵģ�����12321���㣬ͬ��21312Ҳ���㣬����Ŀǰ��û��ʵ�֡�  
	        }  
	    }  
}
