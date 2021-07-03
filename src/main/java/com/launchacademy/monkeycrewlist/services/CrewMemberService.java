package com.launchacademy.monkeycrewlist.services;

import com.launchacademy.monkeycrewlist.models.CrewMember;
import com.launchacademy.monkeycrewlist.repositories.CrewMemberRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrewMemberService {
  private CrewMemberRepository repository;

  @Autowired
  public CrewMemberService(CrewMemberRepository repository) {
    this.repository = repository;
  }

  public void save(CrewMember crewMember) {
    this.repository.save(crewMember);
  }

  public List<CrewMember> findAll(){
    return (List<CrewMember>) repository.findAll();
  }
}
