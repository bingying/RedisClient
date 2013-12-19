package redis.client.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 命令映射
 * 
 * <pre>
 * @author liubing01@youku.com
 * 2013年12月18日  上午11:29:28
 * </pre>
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Relation {

    String value() default "";
}
