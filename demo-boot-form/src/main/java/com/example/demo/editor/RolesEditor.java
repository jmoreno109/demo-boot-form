package com.example.demo.editor;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.service.RoleService;

@Component
public class RolesEditor extends PropertyEditorSupport {

	@Autowired
	RoleService roleService;

	@Override
	public void setAsText(String pk) throws IllegalArgumentException {
		if (pk != null && pk.length() > 0) {
			setValue(roleService.getById(Integer.valueOf(pk)));
		} else {
			setValue(null);
		}

	}

}
