package org.common.com.utils;

import net.sf.json.JSONObject;
import org.apache.commons.codec.binary.Base64;
import org.common.com.app.AppConstants;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class EncryptionUtil {

	public static void main(String[] args) throws Exception {
		// try {
		// //加密 KEY1=abcdef1234567890
		// KEY2=s6vSeN6IEi5fM4OJySXoPuqsofEc0zqITj9T8RFwXDU=
		// String temp = desEncrypt(AppConstants.KEY1, AppConstants.KEY2);
		// byte tempbt[] = Base64.decodeBase64(temp);
		// String tempdata = new String(tempbt, "UTF-8");
		// String realkey = desEncrypt(AppConstants.KEY1, tempdata);
		// String miwen = encrypt(realkey, "data:{\"name\":\"asdasdad\"}");
		// System.out.println("miwen=" + miwen);
		// //解密
		// String respStr = desEncrypt(realkey, miwen);
		// System.out.println("respStr=" + respStr);
		// String str1 = desEncrypt(AppConstants.KEY1, AppConstants.KEY2);
		// byte bt[] = Base64.decodeBase64(str1);
		// String data = new String(bt, "UTF-8");
		// System.out.println("data:" + data);
		// String str2 = desEncrypt(AppConstants.KEY1, data);
		// String str = encrypt(str2, AppConstants.SECURITY_KEY);
		// System.out.println("str=" + str);
		// //真实的密钥
		// String resStr = desEncrypt(AppConstants.KEY1, new
		// String(Base64.decodeBase64(desEncrypt(AppConstants.KEY1,
		// AppConstants.KEY2)), "UTF-8"));
		// System.out.println("resStr=" + resStr);
		// // 加密
		// String reqstr = encrypt(AppConstants.KEY1,
		// Base64.decodeBase64(resStr).toString());
		// System.out.println("reqstr:" + reqstr);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// String jm =
		// getEncryption("dDZAf1KeAKzO2n2An39Fi4a6R5K8oQwcPeUTEdKYNhjjkhNDGD3euinSHhl/nNdTAANOjkQW8BA8znI29fqalO3B8Sf2257hfE459m7AFZoFhEasUgX54vRHXHbGa+Nas0yPQr8KqwFHlldexpNcFD3+HXr144Sxa9gDGtWmutaiFjkfXpl/VNLTnmAIiaW4gUzkkO9RH7UpikOgRtsnZCz1OpCtjAM+qPE+GJ5wMVDzIm2PVQbr8Dtf7ZzLMUZ6VJ44GlQbs1VnVmgY3AeL/x9YyVzDZ0LtZyHz4kCQjRClxc8qp91rly44e/wWD0MxKtW6Yj5kzz10ZUI7nERBn4KqdyCzKGu1j/iG6DkrFffhKLc3B0CDdyYP4NmUoR+VQc0RFzec3TXwhi4UsnvSEu6fFw9Z1ZiNhLmlSaRQh4jerJ9eWihTb/pQNvqTnTfUHCKTKBv1dVah2V40oBuBWd5QG0iItZpPRg9MGMre9S+I1JzzxotPeF8hwZQ4w8qXvjxDZNR7PoLcOnqneztLnCd0XYFah90GZF2MpbFnpWeCktw07ysMzY3kiJpod3PZvAPVpaexCvPoc5GzmlBI8myo7x+tsCl+KPP2W3JWhipwLwMHoZjteGK4kdXxOxSKfFCHHyVpM/CjsValXG2gW49FhlFWIT/s5b0CAJ7pWhSz7C7CRcCIssS4c1wMayu4");
		String a = "{'Result':0,'ErrorCode':'','ErrorMsg':'','Data':{'WayBillId':'8238f330-b810-e411-b992-f46d04046920'}}";
		JSONObject jsonstr = JSONObject.fromObject(a);
		JSONObject data = (JSONObject) jsonstr.get("Data");
		String way = (String) data.get("WayBillId");
		System.out.println(way);
		// System.out.println("user:" + jm);
		// String jk1 = setEncryption("{'userId':'65'}");
		// System.out.println(jk1);
	}

	/**
	 * 加密
	 * 
	 * @param key1
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public static String encrypt(String key1, String value) throws Exception {
		try {
			String data = value;
			String key = key1;
			String iv = AppConstants.IV();
			Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
			int blockSize = cipher.getBlockSize();
			byte[] dataBytes = data.getBytes("UTF-8");
			int plaintextLength = dataBytes.length;
			if (plaintextLength % blockSize != 0) {
				plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
			}
			byte[] plaintext = new byte[plaintextLength];
			System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);
			SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
			IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());
			cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
			byte[] encrypted = cipher.doFinal(plaintext);
			return Base64.encodeBase64String(encrypted);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// 真实的密钥(key3)=Aes解密(Base64解密(Aes解密(key1,key2)),key1)
	/**
	 * 解密
	 * 
	 * @param key
	 *            KEY1
	 * @param data
	 *            KEY2
	 * @return
	 * @throws Exception
	 */
	public static String desEncrypt(String key, String data) throws Exception {
		try {
			// IV=L+\\~f4,Ir)b$=pkf
			String iv = AppConstants.IV();// 加密向量
			byte[] encrypted1 = Base64.decodeBase64(data);// base64解密KEY2
			Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
			SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");// KEY1
			IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());
			cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);
			byte[] original = cipher.doFinal(encrypted1);
			String originalString = new String(original, "UTF-8");
			return originalString;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// 解密
	public static String getEncryption(String data) throws Exception {
		String temp;
		String respStr = null;
		// if(StringUtils.isNotBlank(type)){
		try {
			temp = desEncrypt(AppConstants.KEY1(), AppConstants.KEY2());
			byte tempbt[] = Base64.decodeBase64(temp);
			String tempdata = new String(tempbt, "UTF-8");
			String realkey = desEncrypt(AppConstants.KEY1(), tempdata);
			respStr = desEncrypt(realkey, data.replaceAll(" ", "+"));
			// }else{
			// respStr=data;
			// }
		} catch (Exception ex) {
			System.out.println("method-getEncryption:"+ex.toString());
		}
		return respStr;
	}

	// 加密
	public static String setEncryption(String data) {
		String temp;
		String miwen = null;
		// if (StringUtils.isNotBlank(type)) {
		try {
			temp = desEncrypt(AppConstants.KEY1(), AppConstants.KEY2());
			byte tempbt[] = Base64.decodeBase64(temp);
			String tempdata = new String(tempbt, "UTF-8");
			String realkey = desEncrypt(AppConstants.KEY1(), tempdata);
			miwen = encrypt(realkey, data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// } else {
		// miwen = data;
		// }
		return miwen;
	}

	public static String getAesEncode() {
		try {
			String str1 = desEncrypt(AppConstants.KEY1(), AppConstants.KEY2());
			byte bt[] = Base64.decodeBase64(str1);
			String data = new String(bt, "UTF-8");
			String str2 = desEncrypt(AppConstants.KEY1(), data);
			String str = encrypt(str2, AppConstants.SECURITY_KEY());
			return str;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean isAes(String data) {
		if (data.substring(0, 1).equals("{") && data.substring(data.length() - 1, data.length()).equals("}")) {
			return true;
		} else {
			return false;
		}
	}
}
