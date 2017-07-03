<%@ page import="java.io.*,java.sql.*" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
 
<%
 
            String sn=request.getParameter("ver");
 
Class.forName("com.mysql.jdbc.Driver").newInstance();  
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/digidb","root","");  
Statement stmt = con.createStatement();  
PreparedStatement st=con.prepareStatement("select * from digidata where digi_file_title LIKE '%" + sn + "%'OR searchTags LIKE '%"+sn+"%'");
ResultSet rs=st.executeQuery();
                    if(rs.next()==true)
                    { 
                    	do{
                    	     %>
                    	  <div class="w3l-pricing-grids">
                    				<div class="agileits-pricing-grid">
                    					<div class="pricing">
                    			
                    						<div class="pricing-bottom">
                    							
                    							<div class="pricing-bottom-bottom">
                    								<img src="upload/<%=rs.getString("digi_file_URL_front") %>" alt="" style="height:100px;weight:100px"></img>
                    							</div>
                    							
                    							<div class="pricing-bottom-bottom">
                    								<img src="upload/<%=rs.getString("digi_file_URL_back") %>" alt="" style="height:100px;weight:100px"></img>
                    							</div>
                    						</div>
                    					</div>
                    				</div>
                    				</div>
                    	      <%
                    	    	  }
                    	 while(rs.next());
 
                    }else {
 
                        out.println("<font color=blue; size=30px>");
                        out.println("No search tags are avaliable");
                        out.println("</font>");
 
                    }
 
rs.close();
st.close();
con.close();
 
%>