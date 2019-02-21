package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaDemo1 {

	
	public static void main(String[] args) {
		
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Inside run..");
			}
		});
		t.start();
		
		Thread t2 = new Thread(() -> System.out.println("Inside run with lambda.."));
		t2.start();
		
		List<String> names = Arrays.asList("A","B","C");
		names.stream().forEach(System.out::println);
		System.out.println(names.stream().count());
		
		names.stream().filter(s->s.startsWith("A")).forEach(System.out::println);
		
		names.stream().filter(s->s.startsWith("A")).collect(Collectors.toList());
		
		/*NullCheckPredicate np = xxxx
		names.stream().filter(np)..xx*/
	}
	
	/*static class NullCheckPredicate implements Predicate<String>{
		@Override
		public boolean test(String t) {
			if(t==null)
				return false;
			else
				return true;
		}
	}*/
}
