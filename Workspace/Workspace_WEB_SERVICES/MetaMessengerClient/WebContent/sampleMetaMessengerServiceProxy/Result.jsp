<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleMetaMessengerServiceProxyid" scope="session" class="com.services.MetaMessengerServiceProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleMetaMessengerServiceProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleMetaMessengerServiceProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleMetaMessengerServiceProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        com.services.MetaMessengerService getMetaMessengerService10mtemp = sampleMetaMessengerServiceProxyid.getMetaMessengerService();
if(getMetaMessengerService10mtemp == null){
%>
<%=getMetaMessengerService10mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
</TABLE>
<%
}
break;
case 15:
        gotMethod = true;
        String name_1id=  request.getParameter("name18");
            java.lang.String name_1idTemp = null;
        if(!name_1id.equals("")){
         name_1idTemp  = name_1id;
        }
        String username_2id=  request.getParameter("username20");
            java.lang.String username_2idTemp = null;
        if(!username_2id.equals("")){
         username_2idTemp  = username_2id;
        }
        String password_3id=  request.getParameter("password22");
            java.lang.String password_3idTemp = null;
        if(!password_3id.equals("")){
         password_3idTemp  = password_3id;
        }
        boolean register15mtemp = sampleMetaMessengerServiceProxyid.register(name_1idTemp,username_2idTemp,password_3idTemp);
        String tempResultreturnp16 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(register15mtemp));
        %>
        <%= tempResultreturnp16 %>
        <%
break;
case 24:
        gotMethod = true;
        String username_4id=  request.getParameter("username27");
            java.lang.String username_4idTemp = null;
        if(!username_4id.equals("")){
         username_4idTemp  = username_4id;
        }
        String password_5id=  request.getParameter("password29");
            java.lang.String password_5idTemp = null;
        if(!password_5id.equals("")){
         password_5idTemp  = password_5id;
        }
        java.lang.String login24mtemp = sampleMetaMessengerServiceProxyid.login(username_4idTemp,password_5idTemp);
if(login24mtemp == null){
%>
<%=login24mtemp %>
<%
}else{
        String tempResultreturnp25 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(login24mtemp));
        %>
        <%= tempResultreturnp25 %>
        <%
}
break;
case 31:
        gotMethod = true;
        String token_6id=  request.getParameter("token34");
            java.lang.String token_6idTemp = null;
        if(!token_6id.equals("")){
         token_6idTemp  = token_6id;
        }
        java.lang.String[] getUnreadMessages31mtemp = sampleMetaMessengerServiceProxyid.getUnreadMessages(token_6idTemp);
if(getUnreadMessages31mtemp == null){
%>
<%=getUnreadMessages31mtemp %>
<%
}else{
        String tempreturnp32 = null;
        if(getUnreadMessages31mtemp != null){
        java.util.List listreturnp32= java.util.Arrays.asList(getUnreadMessages31mtemp);
        tempreturnp32 = listreturnp32.toString();
        }
        %>
        <%=tempreturnp32%>
        <%
}
break;
case 36:
        gotMethod = true;
        String token_7id=  request.getParameter("token39");
            java.lang.String token_7idTemp = null;
        if(!token_7id.equals("")){
         token_7idTemp  = token_7id;
        }
        java.lang.String[] getAllMessages36mtemp = sampleMetaMessengerServiceProxyid.getAllMessages(token_7idTemp);
if(getAllMessages36mtemp == null){
%>
<%=getAllMessages36mtemp %>
<%
}else{
        String tempreturnp37 = null;
        if(getAllMessages36mtemp != null){
        java.util.List listreturnp37= java.util.Arrays.asList(getAllMessages36mtemp);
        tempreturnp37 = listreturnp37.toString();
        }
        %>
        <%=tempreturnp37%>
        <%
}
break;
case 41:
        gotMethod = true;
        java.lang.String getRandomUser41mtemp = sampleMetaMessengerServiceProxyid.getRandomUser();
if(getRandomUser41mtemp == null){
%>
<%=getRandomUser41mtemp %>
<%
}else{
        String tempResultreturnp42 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getRandomUser41mtemp));
        %>
        <%= tempResultreturnp42 %>
        <%
}
break;
case 44:
        gotMethod = true;
        String token_8id=  request.getParameter("token47");
            java.lang.String token_8idTemp = null;
        if(!token_8id.equals("")){
         token_8idTemp  = token_8id;
        }
        String userId_9id=  request.getParameter("userId49");
        int userId_9idTemp  = Integer.parseInt(userId_9id);
        String content_10id=  request.getParameter("content51");
            java.lang.String content_10idTemp = null;
        if(!content_10id.equals("")){
         content_10idTemp  = content_10id;
        }
        boolean sendMessage44mtemp = sampleMetaMessengerServiceProxyid.sendMessage(token_8idTemp,userId_9idTemp,content_10idTemp);
        String tempResultreturnp45 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(sendMessage44mtemp));
        %>
        <%= tempResultreturnp45 %>
        <%
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>