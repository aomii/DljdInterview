package com.bjpowernode.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JVMController {

	@RequestMapping("/sayHi")
	public Object sayHi(){
		return "Hi, world.";
	}


	/**
	 * 死循环
	 *
	 * @return
	 */
	@RequestMapping("/loop")
	public Object loop(){
		String str = "<xml>文章内容</xml>";
		while (true) {
			str = str.replace("<xml>", "").replace("</xml>", "");
			System.out.println(str);
		}
	}
}