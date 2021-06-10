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
	public String display(@RequestParam("filename") CommonsMultipartFile file ,Model model,HttpServletRequest request,HttpSession s) throws FileNotFoundException
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
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:orcl";
        String username = "system";
        String password = "#Padmaja71";
 
        String excelFilePath = path;
 
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
  
            String sql = "INSERT INTO practice7 (name, enrolled, progress) VALUES (?, ?, ?)";
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
                        String name = nextCell.getStringCellValue();
                        statement.setString(1, name);
                        break;
                    case 1:
                        Date enrollDate = nextCell.getDateCellValue();
                        statement.setTimestamp(2, new Timestamp(enrollDate.getTime()));
                    case 2:
                        int progress = (int) nextCell.getNumericCellValue();
                        statement.setInt(3, progress);
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
