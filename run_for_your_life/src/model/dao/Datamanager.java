package model.dao;

import java.sql.CallableStatement;
import java.sql.SQLException;

/**
 * @author Sutibun
 *
 */
public class Datamanager extends AbstractDAO{

	private final static String command ="{call insertdata(?,?)}";

	/**
	 * @param name
	 * @param time
	 */
	public void save(String name , int time){
		final CallableStatement callStatement = prepareCall(command);
	    try {
			callStatement.setString(1, name);
			callStatement.setInt(2, time);
			callStatement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	     
	}
	
}