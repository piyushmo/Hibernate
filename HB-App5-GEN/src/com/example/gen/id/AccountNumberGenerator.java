package com.example.gen.id;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class AccountNumberGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object arg1) throws HibernateException {

		String accNo = "SBI";
		
		try {
			
			Connection connection = session.connection();
			
			String QUERY_NAME = "SELECT TO_CHAR("
					+"ACCNO_SEQ.NEXTVAL, 'FM00000000') FROM DUAL";
			
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_NAME);
			
			if(resultSet.next()) {
				
				accNo = accNo + resultSet.getString(1);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return accNo;
	}

}
