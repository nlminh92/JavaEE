package org.annonce.servlet;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public  class AnnonceDao extends DAO<Annonce>{
	
	
	public AnnonceDao(Connection conn) {
		super(conn);
	}


	public  boolean create (Annonce obj){
		try{
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
					.executeQuery("select nextval('\"annonce_id_seq\"') as id");
			if(result.first()){
				int id = result.getInt("id");
				PreparedStatement prepare = this.connect
						    					.prepareStatement("INSERT INTO annonce (id,title,description,adress,mail,date) VALUES(?,?,?,?,?,?)");
				prepare.setLong(1,id);
				prepare.setString(2, obj.getTitle());
				prepare.setString(3, obj.getDescription());
				prepare.setString(4, obj.getAdress());
				prepare.setString(5, obj.getMail());
				java.util.Date utilDate =new java.util.Date() ; 
				java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime()) ;
				prepare.setDate(6, sqlDate);
				
				prepare.executeUpdate();
				obj = this.find(id);
				}
							
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return true;
	}
	
	
	public Annonce find(int id) {
		Annonce Annonce = new Annonce();
		try{
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
		                           .executeQuery("SELECT* FROM annonce WHERE id = "+id);
		                           		
		if(result.first())
		Annonce = new Annonce(new Integer(result.getInt("id")),
				result.getDate("date"),
				result.getString("title"),
				result.getString("description"),
				result.getString("adress"), result.getString("mail"));
		}catch (SQLException e){
			e.printStackTrace();
		}
		
	
		
		
		return Annonce;
	}
	
	public ArrayList<Annonce> List() {
		ArrayList<Annonce> AnnonceList = new ArrayList<Annonce>();
		Annonce Annonce = new Annonce();
		try {

			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery(
					"SELECT * FROM Annonce");
			while (result.next()) {
				Annonce = new Annonce(new Integer(result.getInt("id")),
						result.getDate("date"),
						result.getString("title"),
						result.getString("description"),
						result.getString("adress"), result.getString("mail"));
				AnnonceList.add(Annonce);

			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return AnnonceList;
	}
		
	
	
	public boolean delete(Annonce obj) {
		try{
			this.connect
			            .createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
			            .executeUpdate("DELETE FROM annonce WHERE id = "+obj.getId());
		}
			            		
			catch ( SQLException e) {
				e.printStackTrace();
			}
		return true;
			            		
	}
	

	@Override
	public boolean update(Annonce obj) {
		
		try{
			PreparedStatement prepare = this.connect
					                        .prepareStatement("UPDATE annonce SET title = ?, description = ?, date = ?, WHERE id  = ?");
		
			prepare.setString(1,  obj.getTitle());
			prepare.setString(2, obj.getDescription());
			prepare.setDate(3, obj.getDate());
			prepare.setLong(4, obj.getId());
		    
			prepare.executeUpdate();
			
		}catch (SQLException e){
			e.printStackTrace();
		}
	
		
		return true;
	}
}