package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.demo.dto.Country;
import com.example.demo.dto.Role;
import com.example.demo.dto.User;
import com.example.demo.editor.CountryEditor;
import com.example.demo.editor.RolesEditor;
import com.example.demo.editor.UpperCaseEditor;
import com.example.demo.service.CountryService;
import com.example.demo.service.RoleService;
import com.example.demo.validation.UserValidator;

@Controller
@SessionAttributes("user")
public class FormController {

	@Autowired
	CountryService countryService;

	@Autowired
	RoleService roleService;

	@Autowired
	UserValidator userValidator;

	@Autowired
	CountryEditor countryEditor;

	@Autowired
	RolesEditor rolesEditor;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(userValidator);
		binder.registerCustomEditor(String.class, new UpperCaseEditor());
		// binder.registerCustomEditor(Country.class, "country", countryEditor);
		binder.registerCustomEditor(Role.class, "role", rolesEditor);
	}

	@GetMapping("/form")
	public String showForm(Model model) {
		User user = new User();
		user.setDocument("12345");
		user.setEnable(true);
		user.setAccount(10);
		user.setEmail("pepe@correo.com");
		user.setClient("123.457-K");
		user.setCountry(new Country(3, "AU", "Australia"));
		user.setRole(Arrays.asList(new Role(2, "ROLE_USER", "Usuario")));
		model.addAttribute("user", user);
		return "form";
	}

	@PostMapping("/form")
	public String submitForm(@Valid User user, BindingResult result, Model model) {

		// userValidator.validate(user, result);

		if (result.hasErrors()) {
			return "form";
		}

		return "redirect:/show";
	}

	@GetMapping("/show")
	public String show(@SessionAttribute(required = false) User user, SessionStatus status) {
		// model.addAttribute("user", user); // optional

		if (user == null) {
			return "redirect:/form";
		}

		status.setComplete();
		return "show";
	}

	@ModelAttribute("countries")
	public List<String> countries() {
		return Arrays.asList("Colombia", "Chile", "Australia");
	}

	@ModelAttribute("countryList")
	public List<Country> countryList() {
		return countryService.getAll();
	}

	@ModelAttribute("roleList")
	public List<Role> roleList() {
		return roleService.getAll();
	}

	@ModelAttribute("genderList")
	public List<String> genderList() {
		return Arrays.asList("Hombre", "Mujer");
	}

}

// SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
// dateFormat.setLenient(false);
// binder.registerCustomEditor(Date.class, "dtCreation", new
// CustomDateEditor(dateFormat, false));

/*
 * @PostMapping("/form") public String submitForm(@Valid UserForm userForm,
 * BindingResult result, Model model) {
 * 
 * if (result.hasErrors()) { Map<String, String> errors = new HashMap<>();
 * result.getFieldErrors().forEach(err -> { errors.put(err.getField(),
 * err.getDefaultMessage()); }); model.addAttribute("errors", errors); return
 * "form"; } model.addAttribute("userForm", userForm); return "show"; }
 */

/*
 * @ModelAttribute("allVarieties") public List<Variety> populateVarieties() {
 * return this.varietyService.findAll(); }
 */
