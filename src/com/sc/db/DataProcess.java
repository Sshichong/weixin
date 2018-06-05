package com.sc.db;

//不管连接的数据库是什么，都需要导入java.sql包中的相应的类
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import java.sql.ResultSetMetaData;



public class DataProcess {
	private String url="jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=UTF-8"; //数据库服务器的位置
	private String user="root"; //登陆数据库服务器的用户名
	private String password="root";//登陆数据库服务器的密码
	private Connection conn=null;
	private Statement stm=null;
	
	//获取数据，sql是select语句,rows存表的记录
	public Vector getData(String sql){
		Vector rows=new Vector();
		try{
			Class.forName("com.mysql.jdbc.Driver"); //加载数据库驱动
			System.out.println("ok");
			conn=DriverManager.getConnection(url, user, password);//获取连接
			stm=conn.createStatement();//创建执行sql语句的容器
			ResultSet rst=stm.executeQuery(sql); //执行sql语句
			ResultSetMetaData m = rst.getMetaData();
			int x = m.getColumnCount();
			Vector rowData=null; //(1)
			
			while(rst.next()){
				rowData=new Vector(); //创建Vector对象能否放在（1）处实现
				
				for(int i = 1 ; i<=x;i++)
					rowData.add(rst.getString(i));
				rows.add(rowData);
			}
			stm.close();
			conn.close();
		}catch(Exception e){
			System.err.print(e);
		}
		return rows;
	}
	
	/*public Vector getData(String sql){
		Vector rows=new Vector();
		List<Medizin> list =new ArrayList<Medizin>();
		try{
			Class.forName("com.mysql.jdbc.Driver"); //加载数据库驱动
			conn=DriverManager.getConnection(url, user, password);//获取连接
			stm=conn.createStatement();//创建执行sql语句的容器
			ResultSet rst=stm.executeQuery(sql); //执行sql语句
			
			Vector rowData=null; //(1)
    		while(rst.next()){
				Medizin medizin =new Medizin();
				medizin.setMedizin_ID(rst.getInt(1));
				medizin.setMedizin_name(rst.getString(2));
				medizin.setMedizin_anotherName(rst.getString(3));
				medizin.setMedizin_property(rst.getString(4));
				medizin.setMedizin_introduce(rst.getString(5));
				medizin.setMedizin_distribution(rst.getString(6));
				medizin.setMedizin_collectionProcessing(rst.getString(7));
				medizin.setMedizin_disease(rst.getString(8));
				medizin.setMedizin_precautions(rst.getString(9));
				medizin.setMedizin_chemicalComponent(rst.getString(10));
				medizin.setMedizin_referencesChemical(rst.getString(11));
				medizin.setMedizin_referencesClinic(rst.getString(12));
				medizin.setMedizin_referencesPharmacology(rst.getString(13));
				medizin.setMedizin_planCategory(rst.getInt(14));
				medizin.setMedizin_plantSeed(rst.getString(15));
				medizin.setMedizin_plantJuvenile(rst.getString(16));
				medizin.setMedizin_plantAdult(rst.getString(17));
				medizin.setMedizin_plantWilting(rst.getString(18));
				medizin.setMedizin_plantImg(rst.getString(19));
				medizin.setMedizin_forSelect(rst.getString(20));
				list.add(medizin);
				rowData=new Vector(); //创建Vector对象能否放在（1）处实现
				rowData.add(rst.getString(1));
				rowData.add(rst.getString(2));
				rowData.add(rst.getString(3));
				rowData.add(rst.getString(4));
				rowData.add(rst.getString(5));
				rowData.add(rst.getString(6));
				rowData.add(rst.getString(7));
				rowData.add(rst.getString(8));
				rowData.add(rst.getString(9));
				rowData.add(rst.getString(10));
				rowData.add(rst.getString(11));
				rowData.add(rst.getString(12));
				rowData.add(rst.getString(13));
				rowData.add(rst.getString(14));
				rowData.add(rst.getString(15));
				rowData.add(rst.getString(16));
				rowData.add(rst.getString(17));
				rowData.add(rst.getString(18));
				rowData.add(rst.getString(19));
				rowData.add(rst.getString(20));
				rows.add(rowData);
			}
			stm.close();
			conn.close();
		}catch(Exception e){
			System.err.print(e);
		}
		return rows;
	}*/
	
	public int getNum(String sql){
		Vector rows=new Vector();
		int count=0;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //加载数据库驱动
			conn=DriverManager.getConnection(url, user, password);//获取连接
			stm=conn.createStatement();//创建执行sql语句的容器
			ResultSet rst=stm.executeQuery(sql); //执行sql语句
			Vector rowData=null; //(1)
			while(rst.next()){
				rowData=new Vector(); //创建Vector对象能否放在（1）处实现
				rowData.add(rst.getString(1));
				rowData.add(rst.getString(2));
				rowData.add(rst.getString(3));
				rowData.add(rst.getString(4));
				rowData.add(rst.getString(5));
				rowData.add(rst.getString(6));
				rowData.add(rst.getString(7));
				rowData.add(rst.getString(8));
				rowData.add(rst.getString(9));
				rowData.add(rst.getString(10));
				rowData.add(rst.getString(11));
				rowData.add(rst.getString(12));
				rowData.add(rst.getString(13));
				rowData.add(rst.getString(14));
				rowData.add(rst.getString(15));
				rowData.add(rst.getString(16));
				rowData.add(rst.getString(17));
				rowData.add(rst.getString(18));
				rowData.add(rst.getString(19));
				rowData.add(rst.getString(20));
				rows.add(rowData);
				count++;
			}
			stm.close();
			conn.close();
		}catch(Exception e){
			System.err.print(e);
		}
		return count;
	}
	//添加删除更新数据，sql是insert、delete、update语句
	public int update(String sql){
		int num=0;
		try{
			Class.forName("com.mysql.jdbc.Driver"); //加载数据库驱动
			conn=DriverManager.getConnection(url, user, password);//获取连接
			stm=conn.createStatement();//创建执行sql语句的容器
			num=stm.executeUpdate(sql); //执行sql语句
			stm.close();
			conn.close();
		}catch(Exception e){
			System.err.print(e);
		}
		return num;
	}
}
