package com.yncb.gramopay.payloads;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.yncb.gramopay.entities.Role;
import com.yncb.gramopay.enums.RolesEnum;
import com.yncb.gramopay.repositories.RoleRepo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Order(1)
@Component
public class RoleSeeder implements ApplicationListener<ContextRefreshedEvent>{
	
	@Autowired
	private RoleRepo roleRepo;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		loadRoles();
		log.debug("Roles added successfully !!");
	}
	
	public void loadRoles() {
		RolesEnum[] roleType=new RolesEnum[] {RolesEnum.ADMIN,RolesEnum.SUPER_ADMIN,RolesEnum.USER};
		
		Map<RolesEnum,String> roleDesc=new HashMap<>();
		roleDesc.put(roleType[0], "Administrator Role");
		roleDesc.put(roleType[1], "Super-Administrator Role");
		roleDesc.put(roleType[2], "User Role");
		
		for(RolesEnum roleEnum:roleType) {
			boolean isRoleEmpty = !roleRepo.findByRoleType(roleEnum).isPresent();
			if(isRoleEmpty) {
				Role role=new Role();
				role.setRoleType(roleEnum);
				role.setRoleDescription(roleDesc.get(roleEnum));
				roleRepo.save(role);
				log.info("Role  created : "+role.getRoleType());
			}
		}
	}

}
