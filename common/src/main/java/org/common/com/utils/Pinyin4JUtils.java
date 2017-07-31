package org.common.com.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * Created by on 2017/6/22.
 * Author Aaron.Wang
 */
public class Pinyin4JUtils {
    /**
     * 获取汉字串拼音，英文字符不变
     * @param chinese 汉字串
     * @return 汉语拼音
     */
    public static String cn2PY(String chinese) {
        if(chinese == null || chinese.equals("")) {
            return "";
        } else {
            StringBuilder pybf = new StringBuilder();

            //英文字母不需要转换
            char[] chars = chinese.trim().toCharArray();

            HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
            //格式化为小写字母
            format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
            //不需要音调
            format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
            //设置对拼音字符 ü 的处理
            format.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);

            String[] str = null;
            for (char ch : chars) {
                //汉字的编码是两个字节
                if (ch > 128) {
                    try {
                        str = PinyinHelper.toHanyuPinyinStringArray(ch, format);
                        //不是汉字，估计是特殊字符
                        if (str == null || str.length == 0) {
                            pybf.append(ch);
                        } else {
                            //多音字只要第一个读音
                            pybf.append(str[0].toLowerCase());
                        }
                    } catch (BadHanyuPinyinOutputFormatCombination e) {
                        //出现格式化异常，则直接添加原字符
                        pybf.append(ch);
                    }
                } else {
                    //英文字母或者特殊字符
                    pybf.append(toUpperCase(ch));
                }
            }
            return pybf.toString();
        }
    }

    /**
     * 获取汉字串拼音首字母，英文字符不变
     * @param chinese 汉字串
     * @return 汉语拼音首字母
     */
    public static String cn2PYInitial(String chinese) {
        if(chinese == null || chinese.equals("")) {
            return "";
        } else {
            StringBuilder pybf = new StringBuilder();

            //英文字母不需要转换
            char[] chars = chinese.trim().toCharArray();

            HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
            //格式化为小写字母
            format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
            //不需要音调
            format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
            //设置对拼音字符 ü 的处理
            format.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);

            String[] str = null;
            for (char ch : chars) {
                //汉字的 ASCII 编码一定大于128
                if (ch > 128) {
                    try {
                        str = PinyinHelper.toHanyuPinyinStringArray(ch, format);
                        //不是汉字，估计是特殊字符
                        if (str == null || str.length == 0) {
                            pybf.append(ch);
                        } else {
                            //多音字只要第一个读音的首字母
                            pybf.append(str[0].charAt(0));
                        }
                    } catch (BadHanyuPinyinOutputFormatCombination e) {
                        //出现格式化异常，则直接添加原字符
                        pybf.append(ch);
                    }
                } else {
                    //英文字母或者特殊字符
                    pybf.append(toUpperCase(ch));
                }
            }
            return pybf.toString();
        }
    }

    /**
     * 将字符中的小写英文字母转为大写
     * @param ch 字符
     */
    private static char toUpperCase(char ch) {
        if(ch >= 97 && ch <= 122) {
            return (char) (ch - 32);
        } else {
            return ch;
        }
    }
}

