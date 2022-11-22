package com.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.web.config.PrincipalDetail;
import com.web.model.Article;
import com.web.model.BlockUser;
import com.web.model.Upload;
import com.web.model.User;
import com.web.s3.FileUploadService;
import com.web.service.ArticleService;
import com.web.service.FlowerListService;
import com.web.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MainController {
	private final FlowerListService flowerListService;
	private final ArticleService articleService;
	private final UserService userService;
	private final FileUploadService fileUploadService;
	
	@GetMapping({"", "/"})
	public String main() {
		return "flowerList";
	}	
	
	@GetMapping("/auth/join")
	public String join() {
		return "join";
	}
	
	@GetMapping("/auth/login")
	public String login() {
		return "login";
	}	
	
	@RequestMapping("/logout")
    public ModelAndView logout(HttpSession session) {
        session.invalidate();
        ModelAndView mv = new ModelAndView("redirect:/flowerList");
        return mv;
    }
	
	@GetMapping("/flowerList")
	public String flowerList(Model m, 
			@PageableDefault(size=10,sort="id",direction=Sort.Direction.DESC) Pageable pageable) {
		Page<Upload> flowerList=flowerListService.flowerList(pageable);
		int pageNumber = flowerList.getPageable().getPageNumber(); //현재 페이지
		int totalPages = flowerList.getTotalPages(); //총 페이지 수, 검색에 따라 10개면 10개
		int total = (int) flowerList.getTotalElements();
		int pageBlock = 5; //블럭의 수 1,2,3,4,5
		int startBlockPage = ((pageNumber)/pageBlock) * pageBlock+1; //현재 페이지가 7이라면 1*5+1=6
		int endBlockPage = startBlockPage+pageBlock-1; //6+5-1=10. 6,7,8,9,10해서 10
		endBlockPage = totalPages < endBlockPage ? totalPages : endBlockPage;
		
		m.addAttribute("startBlockPage", startBlockPage);
		m.addAttribute("endBlockPage", endBlockPage);
		m.addAttribute("flowerListTotal", total);
		m.addAttribute("flowerList",flowerList);
		return "flowerList";
	}
	
	@PostMapping("/flowerListSave")
	public String uploadImage(@RequestPart MultipartFile file, Upload upload,
			@AuthenticationPrincipal PrincipalDetail principal) {
		fileUploadService.uploadImage(file, upload, principal.getUser());
		return "redirect:/flowerList";
	}
	
	@PostMapping("/flowerListUpdate")
	public String updateImage(@RequestPart MultipartFile file, Upload upload)
			throws IllegalStateException, IOException {
		fileUploadService.updateImage(file, upload);		
		return "redirect:/flowerList";
	}
	
//	@PostMapping("/flowerListSave")
//	public String flowerListSave(Upload upload, Model m, @RequestPart MultipartFile file,
//			@AuthenticationPrincipal PrincipalDetail principal) throws IllegalStateException, IOException {		
//		flowerListService.flowerListSave(upload, principal.getUser(), file);
//		m.addAttribute("message", "글 작성이 완료되었습니다.");
//		m.addAttribute("searchUrl", "");
//		
//		return "redirect:/flowerList";
//	}
	
	@GetMapping("/flowerListUpdate/{id}")
	public String goFlowerListUpdate(@PathVariable int id, Model m) {
		m.addAttribute("flowerList", flowerListService.flowerListDetail(id));
		return "flowerListUpdate";
	}
	
//	@PostMapping("/flowerListUpdate")
//	public String flowerListUpdate(Upload upload, MultipartFile file)throws IllegalStateException, IOException {
//		flowerListService.flowerListUpdate(upload, file);		
//		return "redirect:/flowerList";
//	}
	
	@GetMapping("/articleList")
	public String articleList(Model m, 
			@PageableDefault(size=10,sort="id",direction=Sort.Direction.DESC) Pageable pageable) {
		Page<Article> articleList=articleService.articleList(pageable);
		int pageNumber = articleList.getPageable().getPageNumber(); 
		int totalPages = articleList.getTotalPages(); 
		int total = (int) articleList.getTotalElements();
		int pageBlock = 5;
		int startBlockPage = ((pageNumber)/pageBlock) * pageBlock+1; 
		int endBlockPage = startBlockPage+pageBlock-1; 
		endBlockPage = totalPages < endBlockPage ? totalPages : endBlockPage;
		
		m.addAttribute("startBlockPage", startBlockPage);
		m.addAttribute("endBlockPage", endBlockPage);
		m.addAttribute("total", total);
		m.addAttribute("articleList",articleList);
		return "articleList";
	}
	
	@GetMapping("/userList")
	public String userList(Model m, 
			@PageableDefault(size=10,sort="id",direction=Sort.Direction.DESC) Pageable pageable) {
		Page<User> userList=userService.userList(pageable);
		int pageNumber = userList.getPageable().getPageNumber(); 
		int totalPages = userList.getTotalPages(); 
		int total = (int) userList.getTotalElements();
		int pageBlock = 5;
		int startBlockPage = ((pageNumber)/pageBlock) * pageBlock+1; 
		int endBlockPage = startBlockPage+pageBlock-1; 
		endBlockPage = totalPages < endBlockPage ? totalPages : endBlockPage;
		
		m.addAttribute("startBlockPage", startBlockPage);
		m.addAttribute("endBlockPage", endBlockPage);
		m.addAttribute("total", total);
		m.addAttribute("userList",userList);
		return "userList";
	}
	
	@GetMapping("/articleListDetail/{id}")
	public String articleListDetail(@PathVariable int id, Model m) {
		m.addAttribute("articleList", articleService.detail(id));
		return "articleListDetail";
	}	
	
	@GetMapping("/chart")
	public String chart(Model m) {		
		return "chart";
	}
	
	@GetMapping("/flowerListWrite")
	public String flowerListWrite(Model m) {
		m.addAttribute("flowerList", new Upload());
		return "flowerListWrite";
	}
	
	@GetMapping("/flowerListDetail/{id}")
	public String flowerListDetail(@PathVariable int id, Model m) {
		m.addAttribute("flowerList", flowerListService.flowerListDetail(id));
		return "flowerListDetail";
	}		
	
	@GetMapping("/selectUser/{userid}")
	public String selectUser(@PathVariable String userid, Model m) {
		m.addAttribute("userinfo", userService.selectUser(userid));
		return "userinfo";
	}
	
	@GetMapping("/blockUser/{userid}")
	public String blockUser(@PathVariable String userid, Model m) {	
		m.addAttribute("userid", userid);
		return "blockUser";
	}
	
	@GetMapping("/blockUserList")
	public String blockUserList(Model m, 
			@PageableDefault(size=10,sort="id",direction=Sort.Direction.DESC) Pageable pageable) {
		Page<BlockUser> blockUserList=userService.blockUserList(pageable);
		int pageNumber = blockUserList.getPageable().getPageNumber(); 
		int totalPages = blockUserList.getTotalPages(); 
		int total = (int) blockUserList.getTotalElements();
		int pageBlock = 5;
		int startBlockPage = ((pageNumber)/pageBlock) * pageBlock+1; 
		int endBlockPage = startBlockPage+pageBlock-1; 
		endBlockPage = totalPages < endBlockPage ? totalPages : endBlockPage;
		
		m.addAttribute("startBlockPage", startBlockPage);
		m.addAttribute("endBlockPage", endBlockPage);
		m.addAttribute("total", total);
		m.addAttribute("blockUserList",blockUserList);
		return "blockUserList";
	}
}