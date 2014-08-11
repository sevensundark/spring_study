package controller;

import model.DataBinderTestModel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DataBinderTestController {
	@RequestMapping(value = "/dataBind")
	public String test(DataBinderTestModel command, Model model) {
		System.out.println("do");
		// 输出command对象看看是否绑定正确
		System.out.println(command);
		model.addAttribute("dataBinderTest", command);
		return "bind/success";
	}
}
