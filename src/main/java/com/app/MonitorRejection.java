package com.app;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class MonitorRejection  implements RejectedExecutionHandler{

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		// TODO Auto-generated method stub
			System.out.println("reject oii..");
	}

}
