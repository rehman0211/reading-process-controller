package com.journaldev.spring.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import com.journaldev.spring.response.ResponseMessage;
import com.journaldev.spring.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.journaldev.spring.model.User;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class HomeController {

	@Autowired
	MainService mainService;

	String paused = "paused";
	String ongoing = "ongoing";
	String terminated = "terminated";

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		String message = "Hi, welcome to Atlan Hiring Task!!! \nDone By : Mohd Ammad Rehman";
		model.addAttribute("message", message);

		return "home";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String uploadFile(@RequestParam("file") MultipartFile file, Model model) {
		String message = "";
		if (mainService.isCSV(file)) {
			try {
				mainService.save(file);
				message = "Uploaded the file successfully: " + file.getOriginalFilename();
				model.addAttribute("status", ongoing);
				model.addAttribute("message", message);
				return "user";
			} catch (Exception e) {
				message = "Could not upload the file: " + file.getOriginalFilename() + "!";
				model.addAttribute("status", ongoing);
				model.addAttribute("message", message);
				return "user";
			}
		}

		message = "Please upload a csv file!";
		return "user";
	}

	@RequestMapping(value = "/pause", method = RequestMethod.POST)
	public String pause(Model model) {
		String message="";
		try {
			mainService.pause();
			message = "The reading process is paused...";
			model.addAttribute("status", paused);
			model.addAttribute("message", message);
			return "user";
		}catch (Exception e) {
			message = "Could not pause process!";
			model.addAttribute("status", ongoing);
			model.addAttribute("message", message);
			return "user";
		}
	}

	@RequestMapping(value = "/resume", method = RequestMethod.POST)
	public String resume(Model model) {
		String message="";
		try {
			mainService.resume();
			message = "The reading process is resumed...";
			model.addAttribute("status", ongoing);
			model.addAttribute("message", message);
			return "user";
		}catch (Exception e) {
			message = "Could not resume process!";
			model.addAttribute("status", paused);
			model.addAttribute("message", message);
			return "user";
		}
	}

	@RequestMapping(value = "/terminate", method = RequestMethod.POST)
	public String terminate(Model model) {
		String message="";
		try {
			mainService.terminate();
			message = "The reading process is terminated, you can upload a new file now...";
			model.addAttribute("message", message);
			return "home";
		}catch (Exception e) {
			message = "Could not terminate process !";
			model.addAttribute("status", paused);
			model.addAttribute("message", message);
			return "home";
		}
	}

//	@RequestMapping(value = "/terminate", method = RequestMethod.POST)
//	public ResponseEntity<ResponseMessage> terminate() {
//		String message="";
//		try {
//			mainService.terminate();
//			message = "The reading process is terminated...";
//			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
//		}catch (Exception e) {
//			message = "Could not terminate process !";
//			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
//		}
//	}
}
