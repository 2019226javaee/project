package edu.zut.cs.software.navigation.admin.car;

//places和car一样
//map和driver一样

import edu.zut.cs.software.navigation.admin.car.dao.DriverDao;
import edu.zut.cs.software.navigation.admin.car.domain.Driver;


import edu.zut.cs.software.navigation.base.dao.GenericTreeDaoTestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;





public class DriverDaoTest extends GenericTreeDaoTestCase<Long, Driver,DriverDao>  {
    private static final Logger logger = LogManager.getLogger(DriverDaoTest.class.getName());
    DriverDao driverDao;

    @Autowired
    public void setDriverDao(DriverDao driverDao){
        this.driverDao=driverDao;
        this.dao=this.driverDao;
    }
    @Test
    public void testGetRoot(){
        int root_size = 10;
        for(int i = 0; i < root_size; i++) {
            Driver driver=new Driver();
            driver.setName("driver_"+i);
            for(int j = 0; j < 10; j++) {
                Driver d=new Driver();
                d.setName("driver_"+ i + "_" + j);
                d.setParent(driver);
            }
            this.driverDao.save(driver);
            

        }
        List<Driver> roots = this.driverDao.getRoot();
        assertEquals(root_size, roots.size());
        if (logger.isInfoEnabled()) {
            logger.info("testGetRoot() - List<Driver> roots={}", roots);
        }
    }


}
