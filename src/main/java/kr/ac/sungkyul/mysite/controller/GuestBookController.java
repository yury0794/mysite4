package kr.ac.sungkyul.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.sungkyul.mysite.service.GuestBookService;
import kr.ac.sungkyul.mysite.vo.GuestBookVo;

@Controller
@RequestMapping("/guestbook")
public class GuestBookController {

	@Autowired
	GuestBookService guestBookService;

	@RequestMapping("/list")
	public String List(Model model) {
		List<GuestBookVo> list = guestBookService.getList();
		model.addAttribute("list", list);
		return "guestbook/list";
	}

	@RequestMapping("/insert")
	public String insert(@ModelAttribute GuestBookVo vo) {
		guestBookService.insert(vo);
		return "redirect:/guestbook/list";
	}

	@RequestMapping("/deleteform/{no}")
	public String deleteForm(@PathVariable("no") Long no, Model model) {
		model.addAttribute("no", no);
		return "guestbook/deleteform";
	}

	@RequestMapping("/delete")
	public String delete(@ModelAttribute GuestBookVo vo) {
		guestBookService.delete(vo);
		return "redirect:/guestbook/list";
	}
}