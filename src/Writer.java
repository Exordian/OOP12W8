import java.lang.annotation.*; 

@Target({ElementType.METHOD, ElementType.TYPE}) // on methods and classes
@Retention(RetentionPolicy.RUNTIME)
@Writer("Jakob Englisch")
public @interface Writer {
	String value();
}
