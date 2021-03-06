package xyz.hanks.create;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * Created by hanks on 16/1/27.
 */
public class Interval {
        public static void main(final String[] args) {
          /*  subscribePrint(Observable.interval(500L, TimeUnit.MILLISECONDS), "Interval Observable");
            subscribePrint(Observable.timer(500L, TimeUnit.MILLISECONDS), "Timer Observable");
            subscribePrint(Observable.error(new Exception("Test Error")), "Error Observable");
            subscribePrint(Observable.empty(), "Empty Observable");
            subscribePrint(Observable.never(), "Never Observable");
            subscribePrint(Observable.range(1, 3), "Range Observable");
            try {
                Thread.sleep(3*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
             */

        	
        	
        	Observable.just("Hello")
        	.doOnNext(s->{System.out.println("doOnNext:"+s);})
        	.flatMap(new Func1<String, Observable<Long>>() {

				@Override
				public Observable<Long> call(String arg0) {
					
					return Observable.interval(1, TimeUnit.SECONDS);
				}
        		
			})
        	.subscribe(s->{System.out.println("interval:"+s); System.out.println(System.currentTimeMillis());});
        	
        	try {
                Thread.sleep(30*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        	
        	
        	
        }

        private static <T> void subscribePrint(final Observable<T> observable, final String name) {
            observable.subscribe(v -> System.out.println(name + " : " + v), e -> {
                System.err.println("Error From ==>" + name + " : ");
                System.err.println(e.getMessage());
            } , () -> System.out.println(name + " ended!"));
    }
}
