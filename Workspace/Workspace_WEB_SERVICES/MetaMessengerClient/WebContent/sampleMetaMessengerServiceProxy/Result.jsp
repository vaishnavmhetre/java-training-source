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
        String token_4id=  request.getParameter("token27");
            java.lang.String token_4idTemp = null;
        if(!token_4id.equals("")){
         token_4idTemp  = token_4id;
        }
        com.data.model.Message[] getAllMessages24mtemp = sampleMetaMessengerServiceProxyid.getAllMessages(token_4idTemp);
if(getAllMessages24mtemp == null){
%>
<%=getAllMessages24mtemp %>
<%
}else{
        String tempreturnp25 = null;
        if(getAllMessages24mtemp != null){
        java.util.List listreturnp25= java.util.Arrays.asList(getAllMessages24mtemp);
        tempreturnp25 = listreturnp25.toString();
        }
        %>
        <%=tempreturnp25%>
        <%
}
break;
case 29:
        gotMethod = true;
        String username_5id=  request.getParameter("username32");
            java.lang.String username_5idTemp = null;
        if(!username_5id.equals("")){
         username_5idTemp  = username_5id;
        }
        String password_6id=  request.getParameter("password34");
            java.lang.String password_6idTemp = null;
        if(!password_6id.equals("")){
         password_6idTemp  = password_6id;
        }
        java.lang.String login29mtemp = sampleMetaMessengerServiceProxyid.login(username_5idTemp,password_6idTemp);
if(login29mtemp == null){
%>
<%=login29mtemp %>
<%
}else{
        String tempResultreturnp30 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(login29mtemp));
        %>
        <%= tempResultreturnp30 %>
        <%
}
break;
case 36:
        gotMethod = true;
        java.lang.String getRandomUser36mtemp = sampleMetaMessengerServiceProxyid.getRandomUser();
if(getRandomUser36mtemp == null){
%>
<%=getRandomUser36mtemp %>
<%
}else{
        String tempResultreturnp37 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getRandomUser36mtemp));
        %>
        <%= tempResultreturnp37 %>
        <%
}
break;
case 39:
        gotMethod = true;
        String token_7id=  request.getParameter("token42");
            java.lang.String token_7idTemp = null;
        if(!token_7id.equals("")){
         token_7idTemp  = token_7id;
        }
        com.data.model.Message[] getUnreadMessages39mtemp = sampleMetaMessengerServiceProxyid.getUnreadMessages(token_7idTemp);
if(getUnreadMessages39mtemp == null){
%>
<%=getUnreadMessages39mtemp %>
<%
}else{
        String tempreturnp40 = null;
        if(getUnreadMessages39mtemp != null){
        java.util.List listreturnp40= java.util.Arrays.asList(getUnreadMessages39mtemp);
        tempreturnp40 = listreturnp40.toString();
        }
        %>
        <%=tempreturnp40%>
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