package edu.zut.cs.software.navigation.location.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Component;

import edu.zut.cs.software.navigation.admin.location.dao.RoutesDao;
import edu.zut.cs.software.navigation.admin.location.domain.Routes;
import edu.zut.cs.software.navigation.base.service.impl.GenericTreeManagerImpl;
import edu.zut.cs.software.navigation.location.RoutesManager;

@Component
public class RoutesManagerImpl extends GenericTreeManagerImpl<Routes, Long> implements RoutesManager{

	RoutesDao routesDao;

    @Autowired
    public void setRoutesDao(RoutesDao routesDao) {
        this.routesDao =routesDao;
        this.treeDao = this.routesDao;
        this.dao = this.treeDao;
    }
    
    
	@Override
	public List<Routes> findbyName(String routesname) {
		Routes queryObject = new Routes();
		queryObject.setName(routesname);
		queryObject.setDateCreated(null);
		queryObject.setDateModified(null);
		ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("routesname", ExampleMatcher.GenericPropertyMatchers.startsWith());
		Example<Routes > example = Example.of(queryObject,matcher);
		List<Routes > result = this.dao.findAll(example);
		return result;
	}
    
   
}
