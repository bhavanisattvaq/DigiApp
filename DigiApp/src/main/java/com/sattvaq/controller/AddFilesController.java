package com.sattvaq.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sattvaq.command.UploadForm;
import com.sattvaq.model.UploadFormmodel;
import com.sattvaq.service.LoginService;

@Controller
public class AddFilesController {

	@Autowired(required = true)
	private LoginService service;

	@RequestMapping(value = "/loginsuccess.htm", method = RequestMethod.GET)
	public String showForm(Model model) {
		return "loginsuccess";
	}

	@RequestMapping(value = "/addfiles.htm", method = RequestMethod.GET)
	public String UploadForm(Model model) {
		UploadForm uploadform = new UploadForm();
		model.addAttribute("uploadform", uploadform);
		return "addfiles";
	}

	@RequestMapping(value = "/addfiles.htm", method = RequestMethod.POST)
	public String upload(@ModelAttribute("uploadform") UploadForm uploadform, Model map)
			throws IllegalStateException, IOException {
		System.out.println("enter into controller");
		String saveDirectory = "C:/Users/bhava/Documents/SpringBoot/DigiApp/src/main/webapp/upload/";

		MultipartFile uploadfiles = uploadform.getFile1();
		MultipartFile uploadfiles2 = uploadform.getFile2();

		List<String> fileNames = null;
		String fileName = null;
		String fileName2 = null;

		if (null != uploadfiles) {
			fileName = uploadfiles.getOriginalFilename();
			if (!"".equalsIgnoreCase(fileName)) {
				// Handle file content - multipartFile.getInputStream()
				uploadfiles.transferTo(new File(saveDirectory + fileName));
			}
		}
		if (null != uploadfiles2) {

			fileName2 = uploadfiles2.getOriginalFilename();
			if (!"".equalsIgnoreCase(fileName2)) {
				// Handle file content - multipartFile.getInputStream()
				uploadfiles2.transferTo(new File(saveDirectory + fileName2));
			}
		}
		fileNames = new ArrayList<String>();
		fileNames.add(fileName2);
		fileNames.add(fileName);
		UploadFormmodel form = new UploadFormmodel();

		form.setBpage(fileName2);
		form.setFpage(fileName);
		form.setSearch(uploadform.getSearch());
		form.setTitle(uploadform.getTitle());
		form.setUserEmail("bhavanisankar@gmail.com");
		// System.out.println(uploadform.getUseremail());
		System.out.println(fileName2);
		System.out.println(fileName);
		System.out.println(uploadform.getSearch());
		System.out.println(uploadform.getTitle());
		System.out.println("enter into controller before service class method calling");
		service.insert(form);
		System.out.println("enter into controller after service class method calling");
		map.addAttribute("msg", "files upload successfully");
		return "addfiles";
	}

	@RequestMapping(value = "/edit.htm", method = RequestMethod.GET)
	public String editContact(HttpServletRequest request, Model map) {
		/* UploadForm uploadform = new UploadForm (); */
		Integer id = Integer.parseInt(request.getParameter("id"));
		UploadFormmodel u = service.getFile(id);
		map.addAttribute("u", u);
		return "/edit";
	}

	@RequestMapping(value = "/edit.htm", method = RequestMethod.POST)
	public String update(@ModelAttribute("uploadform") UploadForm uploadform, Model map, @RequestParam("id") Integer id)
			throws IllegalStateException, IOException {

		System.out.println("enter into controller");
		String saveDirectory = "C:/Users/bhava/Documents/SpringBoot/DigiApp/src/main/webapp/upload/";

		MultipartFile uploadfiles = uploadform.getFile1();
		MultipartFile uploadfiles2 = uploadform.getFile2();

		List<String> fileNames = null;
		String fileName = null;
		String fileName2 = null;

		if (null != uploadfiles) {
			fileName = uploadfiles.getOriginalFilename();
			if (!"".equalsIgnoreCase(fileName)) {
				// Handle file content - multipartFile.getInputStream()
				uploadfiles.transferTo(new File(saveDirectory + fileName));
			}
		}
		if (null != uploadfiles2) {

			fileName2 = uploadfiles2.getOriginalFilename();
			if (!"".equalsIgnoreCase(fileName2)) {
				// Handle file content - multipartFile.getInputStream()
				uploadfiles2.transferTo(new File(saveDirectory + fileName2));
			}
		}
		fileNames = new ArrayList<String>();
		fileNames.add(fileName2);
		fileNames.add(fileName);
		UploadFormmodel form = new UploadFormmodel();
		form.setId(id);
		form.setBpage(fileName2);
		form.setFpage(fileName);
		form.setSearch(uploadform.getSearch());
		form.setTitle(uploadform.getTitle());
		form.setUserEmail("bhavanisankar@gmail.com");
		// System.out.println(uploadform.getUseremail());
		System.out.println(fileName2);
		System.out.println(fileName);
		System.out.println(uploadform.getSearch());
		System.out.println(uploadform.getTitle());
		System.out.println("enter into controller before service class method calling");

		service.updateFile(form);

		System.out.println("enter into controller after service class method calling");
		map.addAttribute("msg", "files upload successfully");

		return "loginsuccess";
	}

	@RequestMapping(value = "/view.htm", method = RequestMethod.GET)
	public ModelAndView listEmployee(ModelAndView model) throws IOException {
		List<UploadFormmodel> listEmployee = service.getAllFiles();
		model.addObject("listEmployee", listEmployee);
		model.setViewName("view");
		return model;
	}
}
