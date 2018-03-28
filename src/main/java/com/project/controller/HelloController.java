package com.project.controller;

import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.scheduled.AsyncTask;
import com.project.scheduled.SyncTask;

@Controller
public class HelloController {

	@Autowired
	private SyncTask syncTask;

	@Autowired
	private AsyncTask asyncTask;

	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		System.out.println(1 / 0);
		return "hello spring boot!";
	}

	@RequestMapping("/testSyncTask")
	public void testSyncTask() {
		try {
			syncTask.doTaskOne();
			syncTask.doTaskTwo();
			syncTask.doTaskThree();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/testAsyncTask")
	public void testAsyncTask() {
		try {
			asyncTask.doTaskOne();
			asyncTask.doTaskTwo();
			asyncTask.doTaskThree();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/testAsyncTask2")
	public void testAsyncTask2() {
		try {
			long start = System.currentTimeMillis();
			Future<String> task1 = asyncTask.doTaskOne();
			Future<String> task2 = asyncTask.doTaskTwo();
			Future<String> task3 = asyncTask.doTaskThree();
			while (true) {
				if (task1.isDone() && task2.isDone() && task3.isDone()) {
					// 三个任务都调用完成，退出循环等待
					break;
				}
				Thread.sleep(1000);
			}
			long end = System.currentTimeMillis();
			System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
