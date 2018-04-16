package org.es.com.utils;
/*
 * author:zky
 */
public class Match {
	

	/**
	 * 通配符算法。 可以匹配"*"和"?"
	 * 如a*b?d可以匹配aAAAbcd
	 * @param pattern 匹配表达式
	 * @param str 匹配的字符串
	 * @return
	 */
	public static boolean match(String pattern, String str) {
		if (pattern == null || str == null)
			return false;

		boolean result = false;
		char c; // 当前要匹配的字符串
		boolean beforeStar = false; // 是否遇到通配符*
		int back_i = 0;// 回溯,当遇到通配符时,匹配不成功则回溯
		int back_j = 0;
		int i, j;
		for (i = 0, j = 0; i < str.length();) {
			if (pattern.length() <= j) {
				if (back_i != 0) {// 有通配符,但是匹配未成功,回溯
					beforeStar = true;
					i = back_i;
					j = back_j;
					back_i = 0;
					back_j = 0;
					continue;
				}
				break;
			}

			if ((c = pattern.charAt(j)) == '*') {
				if (j == pattern.length() - 1) {// 通配符已经在末尾,返回true
					result = true;
					break;
				}
				beforeStar = true;
				j++;
				continue;
			}

			if (beforeStar) {
				if (str.charAt(i) == c) {
					beforeStar = false;
					back_i = i + 1;
					back_j = j;
					j++;
				}
			} else {
				if (c != '?' && c != str.charAt(i)) {
					result = false;
					if (back_i != 0) {// 有通配符,但是匹配未成功,回溯
						beforeStar = true;
						i = back_i;
						j = back_j;
						back_i = 0;
						back_j = 0;
						continue;
					}
					break;
				}
				j++;
			}
			i++;
		}

		if (i == str.length() && j == pattern.length())// 全部遍历完毕
			result = true;
		return result;
	}

	/**
	 * 
	 * @param longitude 纬度
	 * @param latitude  经度
	 * @param distance  公里
	 * @return
	 */
	public static String findNearyPoint(double longitude,double latitude,double distance){
		int earthRadius = 6371;
        //圆心纬度
		double lat = ( latitude* Math.PI) / 180;
        //圆心经度
		double lon = (longitude* Math.PI) / 180;
		
		int sides = 360;// 圆上面的点个数
		StringBuffer coords = new StringBuffer();
		
		double d = distance/ earthRadius;
        for (int i = 0; i <= sides; i++) {
        	double bearing = i * Math.PI / 180; 
        	double lat1 = Math.asin(Math.sin(lat) * Math.cos(d) + Math.cos(lat) * Math.sin(d) * Math.cos(bearing));
        	double lng1 = ((lon + Math.atan2(Math.sin(bearing) * Math.sin(d) * Math.cos(lat), Math.cos(d) - Math.sin(lat) * Math.sin(lat1))) * 180) / Math.PI;
            lat1 = (lat1 * 180) / Math.PI;
            if(i==sides){
            	coords.append(lng1+","+lat1);
            }else{
            	coords.append(lng1+","+lat1+";");
            }
        }
		return coords.toString();
	}

}
