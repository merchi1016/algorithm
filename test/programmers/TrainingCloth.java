package programmers;

import java.util.Arrays;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class TrainingCloth {
	public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int total[] = new int[n];
        
        Arrays.fill(total, 1);
        
        for(int i=0;i<lost.length;i++){
        	total[lost[i]-1] = 0;
        }
        
        for(int i=0;i<reserve.length;i++){
        	total[reserve[i]-1] = 2;
        	
        	for(int j=0;j<lost.length;j++) {
        		if(reserve[i] == lost[j]) {
        			total[reserve[i]-1] = 1;
        		}
        	}        	
        }
        
        for(int i=0;i<n;i++) {
        	if(total[i] == 0) {
        		if(i == 0) {
        			if(total[i+1] == 2) {
        				total[i]++;
        				total[i+1]--;
        				answer++;
        			}
        		}else if(i == n-1) {
        			if(total[i-1] == 2) {
        				total[i]++;
        				total[i-1]--;
        				answer++;
        			}
        		}else {
        			if(total[i-1] == 2) {
        				total[i]++;
        				total[i-1]--;
        				answer++;
        			}else if(total[i+1] == 2) {
        				total[i]++;
        				total[i+1]--;
        				answer++;
        			}
        		}
        	}else{
        		answer++;
        	}
        }
        
        
        return answer;
    }
}
