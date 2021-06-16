package com.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class controller3 {
	@Autowired(required=true)
	private Student student;
	private String Name;
	private int Id;
	private String sur;
	private String Symbol;
	private String Putorcall;
	private String Sentiment;
	private String OptionSymbol;
	private String TradeType;
	private int DTE;
	private float StrikePrice;
	private int Capa;
	private int TradeCount;
	private float TotalTradePrice;
	private String Description;
	private float Option_Price;
	private int OI;
	private int Volume;
	private float VolByOI;
@RequestMapping("/userlogin")	
public String showpage(Model model,HttpServletRequest request)
{
	
	return "login";
}
@RequestMapping("/showUpload")	
public String upload(Model model,HttpServletRequest request)
{
	
	return "upload";
}
	
	@RequestMapping("/showRegister")
	public String showdetails(Model model,HttpServletRequest request)
	{
		reg re=new reg();
		model.addAttribute("student",re);
		return "Register";
		
	}
	
	
	@RequestMapping("/Cars")
	public String displaypage(Model model,HttpServletRequest request)
	{
		
		String username=request.getParameter("user");
		String password=request.getParameter("password");
		model.addAttribute("user", username);
		model.addAttribute("password",password);
		
		return "Cars1";
	}
	@RequestMapping("/show")
	public String showfinal(Model model,HttpServletRequest request)
	{
		String sedan=request.getParameter("sedans");
		
		if(sedan.equals("Sedan")) 
			return "Cars";
		
		else
			return "Cars2";
	}
	@RequestMapping("/Display")
	public String displayfinal(Model model,HttpServletRequest request)
	{
		String car=request.getParameter("cars");
		model.addAttribute("car", car);
		return "Display";
	}
	@RequestMapping(value="/action")
	public String display(@RequestParam("filename") CommonsMultipartFile file ,Model model,HttpServletRequest request,HttpSession s) throws FileNotFoundException, ParseException, ClassNotFoundException
	{
		
		double size = file.getSize();
		System.out.println(size);
		byte[] data = file.getBytes();
		String path=s.getServletContext().getRealPath("/")+file.getOriginalFilename();
		System.out.println(path);
		try
		{
			FileOutputStream fos = new FileOutputStream(path);
			fos.write(data);
			fos.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		String jdbcURL ="jdbc:mysql://localhost:3306/anudb";;
        String username = "root";
        String password = "#Anurag123";
 
        String excelFilePath = path;
 
        int batchSize = 20;
 
        Connection connection = null;
        try {
            long start = System.currentTimeMillis();
             
            FileInputStream inputStream = new FileInputStream(excelFilePath);
 
            Workbook workbook = new XSSFWorkbook(inputStream);
 
            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = firstSheet.iterator();
          Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, username, password);
            connection.setAutoCommit(false);
  
            String sql = "INSERT INTO stock89 (Time,Symbol,Putorcall,Sentiment,OptionSymbol,TradeType,DTE,StrikePrice,Capa,TradeCount,TotalTradePrice,Option_Price,OI,Volume,VolByOI,modifiedOptionSymbol) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
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
 
		return "Welcome";
		
			
	}
	public void saveData()
	{
		try(Connection conn=connect();PreparedStatement pstat=conn.prepareStatement("Insert into demo1234 values(?,?)"))
		{
			pstat.setString(1, Name);
			pstat.setInt(2, Id);
			
			pstat.executeUpdate();
		}catch(SQLException e){
			System.out.println(e);
		}
		
		
		
	}
	private Connection connect()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","#Padmaja71");
		}catch(SQLException | ClassNotFoundException e) {
			System.out.println(e);
			return null;
		}
	}
	
	@PostMapping("/userRegister")
	public String saveStudent(reg re)
	{
		System.out.println(re);
		student.insert(re);
		return "login";
	}
	
	
}
