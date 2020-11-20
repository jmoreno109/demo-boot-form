package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Role;

public interface RoleService {

	public List<Role> getAll();

	public Role getById(Integer pk);

}
