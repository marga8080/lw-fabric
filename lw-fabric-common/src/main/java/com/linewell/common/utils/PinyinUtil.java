package com.linewell.common.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * copy from ccip-core-framework-1.0.jar
 * @author mawei
 *
 */
public class PinyinUtil {
	private static final Log log = LogFactory.getLog(PinyinUtil.class);

	public static String DA833A2AC4A7DCB2A62E5E5BC48CB993(String paramString, boolean paramBoolean) {
		if (StringUtils.isEmpty(paramString)) {
			return "";
		}
		StringBuffer localStringBuffer = new StringBuffer();
		HanyuPinyinOutputFormat localHanyuPinyinOutputFormat = new HanyuPinyinOutputFormat();
		localHanyuPinyinOutputFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		localHanyuPinyinOutputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		localHanyuPinyinOutputFormat.setVCharType(HanyuPinyinVCharType.WITH_V);
		for (int i = 0; i < paramString.length(); i++) {
			char c = paramString.charAt(i);
			try {
				String[] arrayOfString = PinyinHelper.toHanyuPinyinStringArray(c, localHanyuPinyinOutputFormat);
				if (arrayOfString != null) {
					if (paramBoolean) {
						localStringBuffer.append(arrayOfString[0].charAt(0));
					} else {
						localStringBuffer.append(arrayOfString[0]);
					}
				} else {
					localStringBuffer.append(c);
				}
			} catch (BadHanyuPinyinOutputFormatCombination localBadHanyuPinyinOutputFormatCombination) {
				log.error(localBadHanyuPinyinOutputFormatCombination);
			}
		}
		return localStringBuffer.toString();
	}
}