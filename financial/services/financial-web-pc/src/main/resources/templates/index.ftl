<!DOCTYPE html>  
  
<html lang="en">  
  
<body>  
    Date: ${time?date}  
    <br>  
    Time: ${time?time}  
    <br>  
    Message: ${message}  
    <br/>
    用户ID：<input type="text" id="uid" value="1"/><input type="button" id="button" value="查询"/>
    <input type="button" value="刷新地址配置" onclick="refreshAddr();"/>
    <br/>
    <div id="result" width="300px" height="300px">
    
    </div>
    
</body>  
   <script src="/js/jquery.min.js"></script>
   <script>
   
   function refreshAddr(){
   		$.post("http://localhost:8001/bus/refresh",function(data){
   			alert("刷新成功！");
   		});
   }
   
		$("#button").click(function(){
	
	$.get("http://192.168.11.55:51016/u/user/test?token=2&uid="+$("#uid").val(),function(data){

			if(data && data.code == 0){
				var str = "<table border=1>";
				var result = data.result;
				str+="<tr><th>ID</th><th>姓名</th><th>手机</th><th>地址</th></tr>";
				str+="<tr><td>"+result.id+"</td><td>"+result.name+"</td><td>"+result.mobile+"</td><td>"+result.address+"</td></tr>";
				if(result.bonusList){
					var len = result.bonusList.length;
					if(len){
					var bonusList = result.bonusList;
						str+="<tr><td colspan=5>红包列表：<br/><table width=100% border=1>";
						str+"<tr><th>&nbsp;</th><th>名字</th><th>金额</th></tr>";
						//获取红包
						for(var i=0; i<len;i++){
							var bonus = bonusList[i];
							str+="<tr><td>"+(i+1)+"</td><td>"+bonus.name+"</td><td>"+bonus.money+"</td></tr>";
						}
						str+="</table></td></tr>";
					}
				}
				
				str+="</table>";
				$("#result").html(str);
			}else{
				$("#result").html(data.code+":"+data.msg);
			}

           
	});
	
	
		  
     }); 

   </script>
   
   
   
<!--
  $.ajax({
		    
         type:"get", 
         
         url:"http://localhost:5555/u/user/test?token=2&uid="+$("#uid").val(), //跨域请求的URL
         
         async:false,

         dataType:"jsonp",

         jsonp:"jsoncallback",

         jsonpCallback:"success_jsonpCallback",
 
         success:function(json){
         	alert(json);
            $("#result").html(json);
         } }); 
         -->
</html>  