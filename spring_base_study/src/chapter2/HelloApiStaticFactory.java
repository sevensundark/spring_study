package chapter2;

public class HelloApiStaticFactory {
	public static HelloApi newInstance(String message) {
		return new HelloImpl2(message);
	}
}
