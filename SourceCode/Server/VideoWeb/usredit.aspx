﻿<%@ Page Language="C#" AutoEventWireup="true" CodeFile="usredit.aspx.cs" Inherits="usredit" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1" runat="server">

    <title>用户数据修改</title>
     <meta name="viewport" content="width=device-width,user-scalable=no"/>
    
</head>

<body style="margin-left: 0px; margin-top: 0px; margin-right: 0px; margin-bottom: 0px "> 
    <form id="form1" runat="server">  
    <div id="div1" runat="server" style="width: 1280px; height:720px;  margin-left: 0px; margin-right:  0px; margin-top: 0px; border-right: #000000 0px ; border-top: #000000 0px ; border-left: #000000 0px ; border-bottom: #000000 0px ;" align="center">
     <table style="width: 100%;height:100%">
    
     <tr style="height:150px">
       <td style="width:140px" rowspan="2">
       </td>
       <td style="width:1000px"  >
           <asp:Label ID="Label1" runat="server" Text="用户数据修改" Font-Bold="False" 
               Font-Names="黑体" Font-Size="XX-Large"></asp:Label>
       </td>
       <td style="width:140px" rowspan="2">
       </td>
     </tr>
      <tr style="height:400px">
       
       <td style="width:1000px"  >
           <table style="width: 1000px;height:400px">
               <tr style="height:60px;font-size: 20pt;">
                   <td style="width:200px; " align="left">
                       用户名：
                   </td>
                   <td style="width:500px" align="left">
                        <asp:Label ID="Label4" runat="server" Font-Size="20pt" Height="40px" 
                            Width="480px"></asp:Label>
                   </td>
                   <td style="width:300px"align="left">
                       
                       <asp:Label ID="Label2" runat="server" ForeColor="Red" Height="40px" Width="280px"></asp:Label>
                   </td>
               </tr>
               <tr style="height:60px;font-size: 20pt;">
                     <td style="width:200px; " align="left">
                      密码：
                   </td>
                   <td style="width:500px" align="left">
                       
                            <asp:TextBox ID="TextBox2" runat="server" Font-Size="20pt" Height="40px" 
                            Width="480px" ></asp:TextBox>
                   </td>
                   <td style="width:300px"align="left">
                       
                       <asp:Label ID="Label5" runat="server" ForeColor="Red" Height="40px" Width="280px"></asp:Label>
                   </td>
               </tr>
                <tr style="height:60px;font-size: 20pt;">
                     <td style="width:200px; " align="left">
                      登陆次数：
                   </td>
                   <td style="width:500px" align="left">
                           <asp:TextBox ID="TextBox3" runat="server" Font-Size="20pt" Height="40px" 
                            Width="480px" ></asp:TextBox>
                   </td>
                   <td style="width:300px"align="left">
                       
                       <asp:Label ID="Label7" runat="server" ForeColor="Red" Height="40px" Width="280px"></asp:Label>
                   </td>
               </tr>
               <tr style="height:100px">
                  <td style="width:1280px"  colspan="3" align="right">
                  <asp:Button ID="Button2" runat="server" Text="修改" 
                  style="margin-right:400px; margin-bottom:80px" Height=35px Width=127px 
                   BackColor="Transparent" Font-Size="16pt" ForeColor="Black" onmouseover="change(this)" 
                         onmouseout="rechange(this)" onclick="Button1_Click" />
                </td>
                         </tr>
                   
               </tr>
           </table>
       </td>
     </tr>
     <tr style="height:170px">
       
       <td style="width:1280px"  colspan="3" align="right">
        <asp:ImageButton ID="ImageButton1" runat="server"  OnClick="return_click" 
                       ImageUrl="./image/按键.png" Height=35px Width=127px  BackColor="Transparent" 
                       BorderWidth="0px" BorderStyle="None" onmouseover="changeImg(this)" 
                         onmouseout="rechangeImg(this)" style="margin-right:53px; margin-bottom:80px"/>
      
     </tr>
      </table>
     </div>
           
    <script type="text/javascript">
        function changeImg(btn) //鼠标移入，更换图片
        {
           
            btn.src="./image/点击按键.png";
        }
        function rechangeImg(btn)  //鼠标移出，换回原来的图片
        {
            btn.src="./image/按键.png";
        }
        
        function change(btn) //鼠标移入，更换图片
        {
           
          
          btn.style.color="Blue";
         
        }
        function rechange(btn)  //鼠标移出，换回原来的图片
        {
           
            btn.style.color ="Black"; 
        }
    </script>
   
    </form>
</body>
</html>

