package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	
	@GetMapping("hello") // get method�� ���� ��û�� ����
	public String hello(Model model) { // model ������
		
		
		model.addAttribute("data","hello!!"); //view�� attribute�� ���� ����. 
		
		return "hello2"; // hello2.html�� ��ȯ��.
		
	}
	
	
	
	
	@GetMapping("hello-mvc")
	public String helloMvc(@RequestParam("name") String name, Model model) {
		
		model.addAttribute("name",name);
		
		return "hello-template";
		
	}
	
	@GetMapping("hello-string")
	@ResponseBody // http�� ����ο� �ٵ�� �� �ٵ�. ���� �ٵ�ο� �Ʒ� ������ �߰��ϰڴٴ� ��.
	public String helloString(@RequestParam("name") String name) {
		return "hello "+name; //"hello spring"
	}
	
	
	@GetMapping("hello-api") // json�������� ������ �ѱ� �� �̷��� ����� ����.
	@ResponseBody
	public Hello helloApi(@RequestParam("name") String name) {
		Hello hello = new Hello();
		
		hello.setName(name);
		return hello;
	}
	
	
	
	static class Hello{
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
	
}