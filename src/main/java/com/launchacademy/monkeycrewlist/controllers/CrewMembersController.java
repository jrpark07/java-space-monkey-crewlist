package com.launchacademy.monkeycrewlist.controllers;

import com.launchacademy.monkeycrewlist.models.CrewMember;
import com.launchacademy.monkeycrewlist.repositories.CrewMemberRepository;
import com.launchacademy.monkeycrewlist.services.CrewMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/crewmembers")
public class CrewMembersController {

  @Autowired
  CrewMemberService service;

  @GetMapping
  public String getCrewMembers(Model model) {
    model.addAttribute("crewmembers", service.findAll());
    return "crewmembers/index";
  }

  @GetMapping("/new")
  public String getNewMember(Model model) {
  CrewMember crewMember =  new CrewMember();
  model.addAttribute("crewMember", crewMember);
  return "crewmembers/new";
  }

  @PostMapping
  public String createForm(@ModelAttribute @Valid CrewMember crewMember, BindingResult bindingResult, Model model) {
    if (bindingResult.hasErrors()) {
      return "crewmembers/new";
    } else {
      service.save(crewMember);
      return "redirect:/crewmembers/new";
    }
  }
}
