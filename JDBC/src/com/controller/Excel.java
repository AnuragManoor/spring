package com.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel{
	 public static void main(String[] args) throws ParseException, ClassNotFoundException, InstantiationException, IllegalAccessException {
	        String jdbcURL = "jdbc:mysql://localhost:3306/anudb";
	        String username = "root";
	        String password = "#Anurag123";
	 
	        String excelFilePath = "C:\\Users\\Anurag\\Desktop\\Book4.xlsx";
	 
	        int batchSize = 20;
	 
	        Connection connection = null;
	 
	        try {
	            long start = System.currentTimeMillis();
	             
	            FileInputStream inputStream = new FileInputStream(excelFilePath);
	 
	            Workbook workbook = new XSSFWorkbook(inputStream);
	 
	            Sheet firstSheet = workbook.getSheetAt(0);
	            Iterator<Row> rowIterator = firstSheet.iterator();
	          
	            connection = DriverManager.getConnection(jdbcURL, username, password);
	            connection.setAutoCommit(false);
	  
	            String sql = "INSERT INTO stock88 (Time,Symbol,Putorcall,Sentiment,OptionSymbol,TradeType,DTE,StrikePrice,Capa,TradeCount,TotalTradePrice,Option_Price,OI,Volume,VolByOI,modifiedOptionSymbol) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
	            PreparedStatement statement = connection.prepareStatement(sql);    
	             
	            int count = 0;
	             
	            rowIterator.next(); // skip the header row
	             
	            while (rowIterator.hasNext()) {
	                Row nextRow = rowIterator.next();
	                Iterator<Cell> cellIterator = nextRow.cellIterator();
	 
	                while (cellIterator.hasNext()) {
	                    Cell nextCell = cellIterator.next();
	 
	                    int columnIndex = nextCell.getColumnIndex();
	 
	                    switch (columnIndex) {
	                    case 0:
	                    	String Time = nextCell.getStringCellValue();
	                    	 Date r1=new SimpleDateFormat("MM/dd/YYYY HH:mm").parse(Time);
	                    	 
                              statement.setTimestamp(1, new Timestamp(r1.getTime()));     
	                        break;
	                    case 1:
	                    	 
	                          String Symbol = nextCell.getStringCellValue();
		                        statement.setString(2, Symbol);
		                        break;
	                    case 2:
	                    	 String Putorcall = nextCell.getStringCellValue();
		                        statement.setString(3, Putorcall);
		                        break;
	                    case 3:
	                    	 String Sentiment = nextCell.getStringCellValue();
		                        statement.setString(4, Sentiment);
		                        break;
	                    case 4:
	                    	 String OptionSymbol = nextCell.getStringCellValue();
		                        statement.setString(5, OptionSymbol);
		                        String modifiedOptionSymbol="."+OptionSymbol;
		                        String x2=null;
		                        String x3=null;
		                       if(modifiedOptionSymbol.contains("C000")||modifiedOptionSymbol.contains("C00")||modifiedOptionSymbol.contains("C00")||modifiedOptionSymbol.contains("C0")||modifiedOptionSymbol.contains("P0000")||modifiedOptionSymbol.contains("P000")||modifiedOptionSymbol.contains("P00")||modifiedOptionSymbol.contains("P0")) {
		                        	String x1=modifiedOptionSymbol.replaceAll("C000","C" ).replaceAll("C00", "C").replaceAll("C0","C").replaceAll("P0000", "P").replaceAll("P000","P").replaceAll("P00","P").replaceAll("P0","P");
		                         x2=x1.substring(0,x1.length()-3);
		                    		 x3=x1.substring(x1.length()-3,x1.length());
		                    		if(x3.equals("000")) {
		                    			 statement.setString(16,x2);}
		                    		else {
		                    			 String x5=x2+"."+x3;
				                    	   String x6=x5.replaceAll("()\\.0+$|(\\..+?)0+$","$2");
				                    	   statement.setString(16,x6);
		                   	}
                     //3.Extract last 3 digits,then remove trailing zeros
		                        //4 if all zeros remove entirely else append . infront
		                      
		                       }

		                     
		                      
		                        break;
	                    case 5:
	                    	 String TradeType = nextCell.getStringCellValue();
		                        statement.setString(6, TradeType);
		                        break;
	                    /*case 6:
	                    	 String ExpirationDate = nextCell.getStringCellValue();
	                    	 Date r2=new SimpleDateFormat("MM/dd/YYYY").parse(ExpirationDate);
                               statement.setTimestamp(7, new Timestamp(r2.getTime()));
                               break;*/
	                        
	                    case 6:
	                    	int DTE =  (int) nextCell.getNumericCellValue();
	                         
		                        statement.setInt(7, DTE);
		                        
	                    case 7:
	                          float StrikePrice = (float) nextCell.getNumericCellValue();
		                        statement.setFloat(8, StrikePrice);
		                        break;
	                    case 8:
	                          int Capa = (int) nextCell.getNumericCellValue();
		                        statement.setInt(9, Capa);
		                        break;
	                    case 9:
	                          int TradeCount = (int) nextCell.getNumericCellValue();
		                        statement.setInt(10, TradeCount);
		                        break;
	                    case 10:
	                          float TotalTradePrice = (float) nextCell.getNumericCellValue();
		                        statement.setFloat(11, TotalTradePrice);
		                        break;
	                    
	                    case 11:
	                          float Option_Price = (float) nextCell.getNumericCellValue();
		                        statement.setFloat(12, Option_Price);
		                        break;
	                    case 12:
	                          int OI = (int) nextCell.getNumericCellValue();
		                        statement.setInt(13, OI);
		                        break;
	                    case 13:
	                          int Volume = (int) nextCell.getNumericCellValue();
		                        statement.setInt(14, Volume);
		                        break;
	                    case 14:
	                          float VolByOI = (float) nextCell.getNumericCellValue();
		                        statement.setFloat(15, VolByOI);
		                        break;
		                        

						        
						}
	 
	                }
	                 
	                statement.addBatch();
	                if (count % batchSize == 0) {
	                    statement.executeBatch();
	                }
	                 
	                             
	 
	            }
	 
	           workbook.close();
	           statement.executeBatch();
	             
	           
	         
	  
	            connection.commit();
	            connection.close();
	             
	            long end = System.currentTimeMillis();
	            System.out.printf("Import done in %d ms\n", (end - start));
	             
	        } catch (IOException ex1) {
	            System.out.println("Error reading file");
	            ex1.printStackTrace();
	        } catch (SQLException ex2) {
	            System.out.println("Database error");
	            ex2.printStackTrace();
	        }
	 
	    }
}