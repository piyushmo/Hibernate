package com.example.su.service;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.example.su.util.SessionUtil;
import com.example.su.bean.AccountBean;


public class AccountService {

	
	public void  userDetailsSaveOrUpdate(AccountBean bean) {
		
		Session session = null;
		try {
			session = SessionUtil.getSession();
			session.getTransaction().begin();
			
			/* Below code save or update record in database table */
			session.saveOrUpdate(bean);
			/* Above session.saveOrUpdate(bean);
			 * 
			 *    it will work perform operation on database table as below
			 *    
			 *    Object object = session.get(object);
			 *    
			 *    if(object!=null){
			 *    
			 *    	update(object);
			 *    
			 *    }else{
			 *    
			 *      save.(object);
			 *    }
			 * 
			 * */
			
		}catch (HibernateException e) {
			
			e.printStackTrace();
		}finally {
			
			session.getTransaction().commit();
		}
	}
	public static void main(String[] args) {

		AccountService service = new AccountService();
		
		AccountBean bean = new AccountBean();
		
		bean.setAccNo(100);
		bean.setName("Manoj");
		bean.setBalance(98000);
		bean.setAccCreationDate(new Date());
		
		service.userDetailsSaveOrUpdate(bean);
		
	}

}
