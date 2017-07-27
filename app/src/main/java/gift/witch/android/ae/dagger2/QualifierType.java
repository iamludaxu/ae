package gift.witch.android.ae.dagger2;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * 自定义限定符
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface QualifierType {
    String value() default "";
}
