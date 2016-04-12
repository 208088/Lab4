package it.polito.tdp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import it.polito.tdp.model.RichWord;

public class ContieneDAO {

	public List<RichWord> contiene(List<RichWord> lista) {
		String jdbcURL="jdbc:mysql://localhost/dizionario?user=root";
		try {
			Connection conn = DriverManager.getConnection(jdbcURL);
			for (RichWord r : lista) {
			String sql="select* from parola where nome=?";
			PreparedStatement st=conn.prepareStatement(sql);
			st.setString(1, r.getParola());
			ResultSet re=st.executeQuery();
			if(re.next()){
				r.setEsiste(true);
				re.close();
			}
			}
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

}
