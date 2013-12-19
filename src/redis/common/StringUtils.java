package redis.common;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串操作工具类 <br/>
 * 
 * <pre>
 * @author liubing01@youku.com
 * 2013年12月19日  上午10:20:23
 * </pre>
 */
public class StringUtils {

    public static boolean isBlank(String str) {
        return str == null || str.trim() == "";
    }

    /**
     * 默认空白字符为分隔符
     * 
     * @param str
     * @return
     */
    public static String[] split(String str) {
        StringBuilder builder = new StringBuilder(50);
        if (str == null || str.trim() == "" || str.length() == 0) {
            return null;
        }
        char[] chars = str.toCharArray();
        char ch;
        List<String> list = new ArrayList<String>(20);
        for (int i = 0, n = chars.length; i < n; i++) {
            ch = chars[i];
            if (Character.isWhitespace(ch)) {
                if (builder.length() > 0) {
                    list.add(builder.toString());
                    builder.delete(0, builder.length());
                }
            } else {
                builder.append(ch);
            }
        }
        if (builder.length() > 0) list.add(builder.toString());
        return list.toArray(new String[0]);
    }
}
