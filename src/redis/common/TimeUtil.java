package redis.common;

/**
 * <pre>
 * @author liubing01@youku.com
 * 2013年12月13日  下午4:12:43
 * </pre>
 */
public class TimeUtil {

    private static long HOUR = 60 * 60;

    private static long MINUTE = 60;

    public static String formatHMS(long second) {
        if (second == -1) {
            return "无过期时间";
        }
        long hour = (second - second % HOUR) / HOUR;
        second = second - hour * HOUR;
        long minute = (second - second % MINUTE) / MINUTE;
        second = second - minute * MINUTE;
        return String.format("%s时%s分%s秒", hour, minute, second);
    }
}
