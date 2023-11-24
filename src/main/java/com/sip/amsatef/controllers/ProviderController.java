package com.sip.amsatef.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@Controller
@RequestMapping("providers")
public class ProviderController {

		 static int compteur=0;
	public static List<Provider> providers= new ArrayList<>();
	@RequestMapping("/welcome")
	//@ResponseBody
	public String welcome(Model model) {// action
		//return "<h1 align=center>hello Atef</h1>";
		String description="formation String angluar";
		model.addAttribute("desc", description);
		return "provider/welcome";
	}
	
	@RequestMapping("/details")
	//@ResponseBody
	public String details(Model model) {// une autre action 
		//return "<h1 align=center>Spring MVC</h1>";
		String names[]= {"Iyadh","achref","ousssama","med anes"};
		model.addAttribute("names",names);
		
		List<Provider> providers= new ArrayList<>();
		providers.add(new Provider("samsung","korea","1234"));
		providers.add(new Provider("DXC","USA","102030"));
		providers.add(new Provider("PWC","USA","36547"));
		
		model.addAttribute("providers",providers);
		return "provider/details";
	}
	
	@PostMapping("/email")//post ds le form (view)
	//@ResponseBody
	public String GetEmail(Model model,@RequestParam("mail") String mailUser,@RequestParam("nom") String nomUser) {
		
		model.addAttribute("mailUser", mailUser);
		model.addAttribute("nomUser", nomUser);
		//return "votre email est :"+mailUser+", votre nom est: "+nomUser;
		return "provider/user";
	}
	
	
	@GetMapping("/add") // bel GET
	public String add(Model model) {
		
		Provider provider= new Provider();
		//Provider provider= new Provider("Abdo","Gafsa","76767676");
		model.addAttribute("provider", provider);
		return "provider/ajoutProvider";
	}
	
	@PostMapping("/add") // bel Post
	//@ResponseBody
	public String add(Provider provider ) {
		compteur++;
		provider.setId(compteur);
		providers.add(provider);
		//return "provider/listProvider";
		return "redirect:list";
	}
	
	@GetMapping("/list")
	public String listProvider(Model model) {
		
		model.addAttribute("providers", providers);
		return "provider/listProvider";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id,Model model) {
		
		Provider prov=findProviderById(id);
		providers.remove(prov);
		model.addAttribute("providers", providers);
		return "redirect:../list";
	}
	
	private static Provider findProviderById(int id) {
		Provider res= null;
		for(Provider pro:providers)
		{
			if(pro.getId()==id)
		return pro;
		}
		return res;
	}
	
	@GetMapping("/edit/{id}")
	public String update(@PathVariable("id") int id,Model model) {
		
		Provider provider=findProviderById(id);
		model.addAttribute("provider", provider);
		return "provider/editProvider";
	}
	
	@PostMapping("/edit")
	//@ResponseBody
	public String update(Provider provider) {
		
		for(Provider p:providers) {
			if(p.getId()==provider.getId()) {
				p.setNom(provider.getNom());
				p.setAddresse(provider.getAddresse());
				p.setMobile(provider.getMobile());
			}
		}
		return "redirect:list";
	}
}
