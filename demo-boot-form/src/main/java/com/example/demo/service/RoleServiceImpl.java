package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.Role;

@Service
public class RoleServiceImpl implements RoleService {

	private List<Role> roleList;

	public RoleServiceImpl() {
		roleList = new ArrayList<>();
		roleList.add(new Role(1, "ROLE_ADMIN", "Administrador"));
		roleList.add(new Role(2, "ROLE_USER", "Usuario"));
		roleList.add(new Role(3, "ROLE_MODERATOR", "Moderador"));
	}

	@Override
	public List<Role> getAll() {
		return roleList;
	}

	@Override
	public Role getById(Integer pk) {
		Role role = roleList.stream().filter(x -> x.getPk().equals(pk)).findAny().orElse(null);
		return role;
	}

}
