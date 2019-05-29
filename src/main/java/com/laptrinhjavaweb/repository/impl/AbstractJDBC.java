package com.laptrinhjavaweb.repository.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javaweb.annotion.Column;
import com.javaweb.annotion.Table;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.mapper.ResultSetMapper;
import com.laptrinhjavaweb.repository.GenericJDBC;

public class AbstractJDBC<T> implements GenericJDBC<T> {
	
	private Class<T> zClass;
	@SuppressWarnings("unchecked")
	public AbstractJDBC() {
		Type type = getClass().getGenericSuperclass();
		ParameterizedType parameterizedType = (ParameterizedType) type;
		zClass = (Class<T>) parameterizedType.getActualTypeArguments()[0];
	}
	
	public Connection getConnection() {
		try {
			 String databaseURL ="jdbc:mysql://localhost:3306/estate4month2019";
		       String username = "root";
		       String password = "0000";
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(databaseURL, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<T> query(String sql, Object... parameters) {
		
		  
	       ResultSetMapper<T> resultSetMapper = new ResultSetMapper<T>();
	       try(Connection conn = getConnection();
	    		   PreparedStatement statement = conn.prepareStatement(sql);
	    		   ResultSet rs = statement.executeQuery()) {
			
			if(conn!=null) {
				for(int i = 0 ; i < parameters.length ; i++) {
            		int index = i + 1;
            		statement.setObject(index, parameters[i]);
            	}
					return resultSetMapper.mapRow(rs, this.zClass);
			}
		} catch ( SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(String sql, Object... parameters) {
		 Connection conn = null;
         PreparedStatement statement = null;        
       try {
           
            conn = getConnection();
            conn.setAutoCommit(false);
            statement = conn.prepareStatement(sql);
            if (conn != null) {    
            	// set parameter cho statement
            	for(int i = 0 ; i < parameters.length ; i++) {
            		int index = i + 1;
            		statement.setObject(index, parameters[i]);
            	}
            	 
            	int rowsInserted = statement.executeUpdate();
            	conn.commit();
            	if (rowsInserted > 0) {
            	   System.out.println("building update succesfully");
            }
            }
        } catch (SQLException e) {
          if(conn != null) {
        	  try {
				conn.rollback();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
          }
        } finally {
        	if(conn!=null) {
        		try {
					conn.close();
				} catch (SQLException e3) {
					
					e3.printStackTrace();
				}
        	}
        	if(statement!=null) {
        		try {
					statement.close();
				} catch (SQLException e2) {
					
					e2.printStackTrace();
				}
	}
        }
		
	}

	@Override
	public Long insert(String sql, Object... parameters) {
		Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
      
      try {
           
           conn = getConnection();
           conn.setAutoCommit(false);
           statement = conn.prepareStatement(sql, statement.RETURN_GENERATED_KEYS);
           if (conn != null) {         
           	for(int i = 0; i < parameters.length ; i++) {
           		int index = i + 1;
           		statement.setObject(index, parameters[i]);
           	}
          
         int rowsInserted = statement.executeUpdate();
           	rs = statement.getGeneratedKeys();
           	conn.commit();
           	if (rowsInserted > 0) {
           		while(rs.next()) {
           		long id = rs.getLong(1);
           	 return id;
           		}
           }
           }
       } catch ( SQLException e) {
         if(conn != null) {
       	  try {
				conn.rollback();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
         }
       } finally {
       	if(conn!=null) {
       		try {
					conn.close();
				} catch (SQLException e3) {
					
					e3.printStackTrace();
				}
       	}
       	if(statement!=null) {
       		try {
					statement.close();
				} catch (SQLException e2) {
					
					e2.printStackTrace();
				}
		
		
	}
   }
      return null;
	}

	@Override
	public Long insert(Object object) {
		Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
      
      try {
           
           conn = getConnection();
           conn.setAutoCommit(false);
           String sql = createSQLInsert();
           statement = conn.prepareStatement(sql, statement.RETURN_GENERATED_KEYS);
           if (conn != null) {       
        	Class<?> zClass = object.getClass();
        	Field[] fields = zClass.getDeclaredFields();
           	for(int i = 0; i < fields.length ; i++) {
           		int index = i + 1;
           		Field field = fields[i];
           		
           		field.setAccessible(true);
           		statement.setObject(index, field.get(object));
           	}
           	
           	Class<?> parentClass = zClass.getSuperclass();
           	int parentIndex = fields.length + 1;
    		while(parentClass!=null) {
    			for(int i = 0; i < parentClass.getDeclaredFields().length ; i++) {
               		Field field = parentClass.getDeclaredFields()[i];
           
               		field.setAccessible(true);
               		statement.setObject(parentIndex, field.get(object));
               		parentIndex = parentIndex + 1;
               	}
    		parentClass = parentClass.getSuperclass();
    	}
          
         int rowsInserted = statement.executeUpdate();
           	rs = statement.getGeneratedKeys();
           	conn.commit();
           	if (rowsInserted > 0) {
           		while(rs.next()) {
           		long id = rs.getLong(1);
           	 return id;
           		}
           }
           }
       } catch ( SQLException |  IllegalAccessException e) {
         if(conn != null) {
       	  try {
				conn.rollback();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
         }
       } finally {
       	if(conn!=null) {
       		try {
					conn.close();
				} catch (SQLException e3) {
					
					e3.printStackTrace();
				}
       	}
       	if(statement!=null) {
       		try {
					statement.close();
				} catch (SQLException e2) {
					
					e2.printStackTrace();
				}
		
		
	}
   }
      return null;
	}

	private String createSQLInsert() {
		String tableName = "";
		if(zClass.isAnnotationPresent(Table.class)) {
			Table table = zClass.getAnnotation(Table.class);
			tableName = table.name();
		}
		
		StringBuilder fields = new StringBuilder("");
		StringBuilder params = new StringBuilder("");
		
		for (Field field: zClass.getDeclaredFields()) {
			if(fields.length() > 1) {
				fields.append(",");
				params.append(",");
			}
			if(field.isAnnotationPresent(Column.class)) {
				Column column = field.getAnnotation(Column.class);
				
				fields.append(column.name());
				params.append("?");
			}
		}
		
		// check parent class
		Class<?> parentClass = zClass.getSuperclass();
		while(parentClass!=null) {
		
		for (Field field: parentClass.getDeclaredFields()) {
			if(fields.length() > 1) {
				fields.append(",");
				params.append(",");
			}
			if(field.isAnnotationPresent(Column.class)) {
				Column column = field.getAnnotation(Column.class);
				
				fields.append(column.name());
				params.append("?");
			}
		}
		parentClass = parentClass.getSuperclass();
	}
	
		String sql = "INSERT INTO " + tableName + " (" + fields.toString() + ") VALUES ("+ params.toString()+")";
		return sql;
	}

	@Override
	public void update(Object object) {
		Connection conn = null;
        PreparedStatement statement = null;
       
      
      try {
           
           conn = getConnection();
           conn.setAutoCommit(false);
           String sql = createSQLUpdate();
           statement = conn.prepareStatement(sql);
           if (conn != null) {       
        	Class<?> zClass = object.getClass();
        	Field[] fields = zClass.getDeclaredFields();
           	for(int i = 0; i < fields.length ; i++) {
           		int index = i + 1;
           		Field field = fields[i];
           		
           		field.setAccessible(true);
           		statement.setObject(index, field.get(object));
           	}
           	
           	Class<?> parentClass = zClass.getSuperclass();
           	int parentIndex = fields.length + 1;
           	Object id =null;
    		while(parentClass!=null) {
    			for(int i = 0; i < parentClass.getDeclaredFields().length ; i++) {
               		Field field = parentClass.getDeclaredFields()[i];
               		String name = field.getName();
               		field.setAccessible(true);
               		if(!name.equals("id")) {
               		statement.setObject(parentIndex, field.get(object));
               		parentIndex = parentIndex + 1;
               	}else {
               		id = field.get(object);
               	}
    			}
    		parentClass = parentClass.getSuperclass();
    	}
        statement.setObject(parentIndex, id);  
        statement.executeUpdate();
         
           	conn.commit();
          
           }
       } catch ( SQLException |  IllegalAccessException e) {
         if(conn != null) {
       	  try {
				conn.rollback();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
         }
       } finally {
       	if(conn!=null) {
       		try {
					conn.close();
				} catch (SQLException e3) {
					
					e3.printStackTrace();
				}
       	}
       	if(statement!=null) {
       		try {
					statement.close();
				} catch (SQLException e2) {
					
					e2.printStackTrace();
				}
		
		
	}
   }
    
	}

	private String createSQLUpdate() {
		String tableName = "";
		if(zClass.isAnnotationPresent(Table.class)) {
			Table table = zClass.getAnnotation(Table.class);
			tableName = table.name();
		}
		
		StringBuilder sets = new StringBuilder("");
		String where = null;
		
		for (Field field: zClass.getDeclaredFields()) {
			
			if(field.isAnnotationPresent(Column.class)) {
				Column column = field.getAnnotation(Column.class);
				String columnName = column.name();
				String value = columnName + " = ?";
				if(!columnName.equals("id")) {
					if(sets.length() > 1) {
						sets.append(",");
					}
					sets.append(value);
				}
				
			}
		}
		
		// check parent class
		Class<?> parentClass = zClass.getSuperclass();
		while(parentClass!=null) {
		
		for (Field field: parentClass.getDeclaredFields()) {
			
			if(field.isAnnotationPresent(Column.class)) {
				Column column = field.getAnnotation(Column.class);
				String columnName = column.name();
				String value = columnName + " = ?";
				if(!columnName.equals("id")) {
					if(sets.length() > 1) {
						sets.append(",");
					}
					sets.append(value);
				}else {
					where = "WHERE " + value;
				}
			}
		}
		parentClass = parentClass.getSuperclass();
	}
	
		String sql = "UPDATE " + tableName + " SET " + sets.toString() + where ;
		return sql;
	}

	@Override
	public void delete(Object object) {
		Connection conn = null;
        PreparedStatement statement = null;
       
      
      try {
           
           conn = getConnection();
           conn.setAutoCommit(false);
           String sql = createSQLDelete();
           statement = conn.prepareStatement(sql);
           if (conn != null) {       
        	Class<?> zClass = object.getClass();
        	Field[] fields = zClass.getDeclaredFields();
           	for(int i = 0; i < fields.length ; i++) {
           		int index = i + 1;
           		Field field = fields[i];
           		
           		field.setAccessible(true);
           		statement.setObject(index, field.get(object));
           	}
           	
           	Class<?> parentClass = zClass.getSuperclass();
           	int parentIndex = fields.length + 1;
           	Object id =null;
    		while(parentClass!=null) {
    			for(int i = 0; i < parentClass.getDeclaredFields().length ; i++) {
               		Field field = parentClass.getDeclaredFields()[i];
               		String name = field.getName();
               		field.setAccessible(true);
               		if(!name.equals("id")) {
               		statement.setObject(parentIndex, field.get(object));
               		parentIndex = parentIndex + 1;
               	}else {
               		id = field.get(object);
               	}
    			}
    		parentClass = parentClass.getSuperclass();
    	}
        statement.setObject(parentIndex, id);  
        statement.executeUpdate();
         
           	conn.commit();
          
           }
       } catch ( SQLException |  IllegalAccessException e) {
         if(conn != null) {
       	  try {
				conn.rollback();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
         }
       } finally {
       	if(conn!=null) {
       		try {
					conn.close();
				} catch (SQLException e3) {
					
					e3.printStackTrace();
				}
       	}
       	if(statement!=null) {
       		try {
					statement.close();
				} catch (SQLException e2) {
					
					e2.printStackTrace();
				}
		
		
	}
   }
	}

	private String createSQLDelete() {
		String tableName = "";
		if(zClass.isAnnotationPresent(Table.class)) {
			Table table = zClass.getAnnotation(Table.class);
			tableName = table.name();
		}
		
		
		String where = null;
		
		
		
		// check parent class
		Class<?> parentClass = zClass.getSuperclass();
		while(parentClass!=null) {
		
		for (Field field: parentClass.getDeclaredFields()) {
			
			if(field.isAnnotationPresent(Column.class)) {
				Column column = field.getAnnotation(Column.class);
				String columnName = column.name();
				String value = columnName + " = ?";
				if(columnName.equals("id")) {
					where = "WHERE " + value;
				}
			}
		}
		parentClass = parentClass.getSuperclass();
	}
	
		String sql = "DELETE FROM " + tableName +  where ;
		return sql;
	}

	@Override
	public List<T> query(Object ...parameters) {
		 ResultSetMapper<T> resultSetMapper = new ResultSetMapper<T>();
		 String tableName = "";
			if(zClass.isAnnotationPresent(Table.class)) {
				Table table = zClass.getAnnotation(Table.class);
				tableName = table.name();
			}
			
			String sql = "SELECT * FROM " + tableName  ;
	       try(Connection conn = getConnection();
	    		   PreparedStatement statement = conn.prepareStatement(sql);
	    		   ResultSet rs = statement.executeQuery()) {
			
			if(conn!=null) {
				for(int i = 0 ; i < parameters.length ; i++) {
          		int index = i + 1;
          		statement.setObject(index, parameters[i]);
          	}
					
					return resultSetMapper.mapRow(rs, this.zClass);
					
			}
		} catch ( SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	public T findById() {
		
		List<T> results = query(BuildingEntity.class);
		return results.get(0);
		
	}

}
