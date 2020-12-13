package interview.questions;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Q_007_MTFuture {

	/*
	 * 	How can you cancel the method execution after time out expires using Future.
	 */
	public static class FutureTimedExecution {

		private final ExecutorService executorService = Executors.newCachedThreadPool();

		public void timedRun(Runnable runnable, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException {
			Future<?> task = executorService.submit(runnable);
			try {
				task.get(timeout, unit);
			}
			catch (TimeoutException e) {
				System.err.println("Timeout Occurred.");
			}
			finally {
				task.cancel(true);
			}
		}

		public void stop() {
			executorService.shutdown();
		}

		public static void main(String[] args) throws InterruptedException, ExecutionException {
			FutureTimedExecution timedExecution = new FutureTimedExecution();
			timedExecution.timedRun(new Runnable() {
				@Override
				public void run() {
					while (!Thread.interrupted()) {
						System.out.println("Test me.....");
					}
				}
			}, 200, TimeUnit.MICROSECONDS);
			timedExecution.stop();
		}
	}

}
