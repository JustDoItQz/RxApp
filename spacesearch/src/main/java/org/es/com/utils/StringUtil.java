package org.es.com.utils;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

	public static boolean isNotStringEmpty(String s) {
		return !isStringEmpty(s);
	}

	public static boolean isStringEmpty(String s) {
		if (null == s || s.length() == 0 || s.equals("")) {
			return true;
		}
		return false;
	}

	public static boolean isNotEmpty(String s) {
		return !isStringEmpty(s);
	}

	public static boolean isStringArrayEmpty(String[] ss) {
		if (null == ss || ss.length == 0) {
			return true;
		}
		return false;
	}

	public static boolean isOneStringEmpty(String... s) {
		boolean result = isStringArrayEmpty(s);
		if (result) {
			return result;
		}
		for (String each : s) {
			if (isStringEmpty(each)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isNumeric(String str) {
		boolean isNumeric = false;
		if (!isStringEmpty(str)) {
			Pattern pattern = Pattern.compile("[0-9]*");
			Matcher isNum = pattern.matcher(str);
			if (isNum.matches()) {
				isNumeric = true;
			}
		}
		return isNumeric;
	}

	public static String arrayToString(String strs[]) {
		StringBuffer sbuf = new StringBuffer("[");
		if (!isStringArrayEmpty(strs)) {
			for (int i = 0; i < strs.length; i++) {
				if (i == strs.length - 1) {
					sbuf.append(strs[i]);
				} else {
					sbuf.append(strs[i] + ", ");
				}
			}
		}
		sbuf.append("]");
		return sbuf.toString();
	}

	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(List ls) {
		boolean isEmpty = true;
		if (ls != null && ls.size() > 0) {
			isEmpty = false;
		}
		return isEmpty;
	}

	public static String xssEncode(String value) {
		if (value != null) {
			// NOTE: It's highly recommended to use the ESAPI library and
			// uncomment the following line to
			// avoid encoded attacks.
			// value = ESAPI.encoder().canonicalize(value);

			// Avoid null characters
			value = value.replaceAll(" ", "");

			// Avoid anything between script tags
			Pattern scriptPattern = Pattern.compile("<script>(.*?)</script>",
					Pattern.CASE_INSENSITIVE);
			value = scriptPattern.matcher(value).replaceAll("");

			// Avoid anything in a src='...' type of expression
			scriptPattern = Pattern.compile("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'",
					Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
							| Pattern.DOTALL);
			value = scriptPattern.matcher(value).replaceAll("");

			scriptPattern = Pattern.compile("src[\r\n]*=[\r\n]*\\\"(.*?)\\\"",
					Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
							| Pattern.DOTALL);
			value = scriptPattern.matcher(value).replaceAll("");

			// Remove any lonesome </script> tag
			scriptPattern = Pattern.compile("</script>",
					Pattern.CASE_INSENSITIVE);
			value = scriptPattern.matcher(value).replaceAll("");

			// Remove any lonesome <script ...> tag
			scriptPattern = Pattern.compile("<script(.*?)>",
					Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
							| Pattern.DOTALL);
			value = scriptPattern.matcher(value).replaceAll("");

			// Avoid eval(...) expressions
			scriptPattern = Pattern.compile("eval\\((.*?)\\)",
					Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
							| Pattern.DOTALL);
			value = scriptPattern.matcher(value).replaceAll("");

			// Avoid expression(...) expressions
			scriptPattern = Pattern.compile("expression\\((.*?)\\)",
					Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
							| Pattern.DOTALL);
			value = scriptPattern.matcher(value).replaceAll("");

			// Avoid javascript:... expressions
			scriptPattern = Pattern.compile("javascript:",
					Pattern.CASE_INSENSITIVE);
			value = scriptPattern.matcher(value).replaceAll("");

			// Avoid vbscript:... expressions
			scriptPattern = Pattern.compile("vbscript:",
					Pattern.CASE_INSENSITIVE);
			value = scriptPattern.matcher(value).replaceAll("");

			// Avoid onload= expressions
			scriptPattern = Pattern.compile("onload(.*?)=",
					Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
							| Pattern.DOTALL);
			value = scriptPattern.matcher(value).replaceAll("");
		}
		return value;
	}

	/**
	 * 过滤特殊字符
	 * 
	 * @param s
	 * @return
	 * @author siquan.lv
	 * @date 2013-5-27
	 */
	public static String specialCharFilter(String s) {
		// String inj_str =
		// "'|and|exec|insert|select|delete|update|count|*|%|chr|mid|master|truncate|char|declare|; |or|-|+|,";

		return s.replaceAll(".*([';]+|(--)+).*", " ");
	}

	public static String encodeStr(String str)
			throws UnsupportedEncodingException {
		return new String(str.getBytes("ISO-8859-1"), "UTF-8");
	}

	public static boolean isMobileNO(String mobiles) {
		Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
		Matcher m = p.matcher(mobiles);
		return m.matches();
	}
	
//	//获取本地IP地址
//	public static String getLocalIP(){
//		String ip = "";
//		try {
//			ip = InetAddress.getLocalHost().getHostAddress();
//		} catch (UnknownHostException e) {
//			e.printStackTrace();
//		}
//		return ip;
//	}
	

	public static void main(String args[]) {
//		System.out.println(isNumeric("55"));
//		System.out.println(isNumeric("55号"));
//		System.out.println(getLocalIP());
	}

}
