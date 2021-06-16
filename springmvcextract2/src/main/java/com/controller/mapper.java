package com.controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class mapper implements RowMapper<stock>{
	@Override
	public stock mapRow(ResultSet rs,int rowNum) throws SQLException{
	stock s=new stock();
	s.setTime(rs.getTimestamp("Time"));
	s.setSymbol(rs.getString("Symbol"));
	s.setPutorcall(rs.getString("Putorcall"));
	s.setSentiment(rs.getString("Sentiment"));
	s.setOptionSymbol(rs.getString("OptionSymbol"));
	s.setTradeType(rs.getString("TradeType"));
	s.setDTE(rs.getInt("DTE"));
	s.setStrikePrice(rs.getFloat("StrikePrice"));
	s.setCapa(rs.getInt("Capa"));
	s.setTradeCount(rs.getInt("TradeCount"));
	s.setTotalTradePrice(rs.getFloat("TotalTradePrice"));
	s.setOption_Price(rs.getFloat("Option_Price"));
	s.setOI(rs.getInt("OI"));
	s.setVolume(rs.getInt("Volume"));
	s.setVolByOI(rs.getFloat("VolByOI"));
	return s;
	
}
}
