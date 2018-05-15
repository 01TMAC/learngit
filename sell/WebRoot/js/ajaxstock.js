// 定义了XMLHttpRequest对象
	var xmlrequest1;
	// 完成XMLHttpRequest对象的初始化
	function createXMLHttpRequest1()
	{
		if(window.XMLHttpRequest)
		{ 
			// DOM 2浏览器
			xmlrequest1 = new XMLHttpRequest();
		}
		else if (window.ActiveXObject)
		{
			// IE浏览器
			try
			{
				xmlrequest1 = new ActiveXObject("Msxml2.XMLHTTP");
			}
			catch (e)
			{
				try
				{
					xmlrequest1= new ActiveXObject("Microsoft.XMLHTTP");
				}
				catch (e)
				{
				}
			}
		}
	}
	
	function changeStock(obj)
	{
		// 初始化XMLHttpRequest对象
		createXMLHttpRequest1();
		// 设置请求响应的URL
		var uri = "/sell/jsp/ajaxstock.jsp";
		var stockName = obj.name;
		var stockAction =obj.src;
		// 设置处理响应的回调函数
		xmlrequest1.onreadystatechange = changeResponse;
		// 设置以POST方式发送请求，并打开连接
		xmlrequest1.open("post", uri, true); 
		// 设置GET请求的请求头
		xmlrequest1.setRequestHeader("Content-Type"
			, "application/x-www-form-urlencoded");
		// 发送请求
		xmlrequest1.send("stockName="+stockName+"&stockAction="+stockAction);
	}
	
	function changeResponse()
	{
		//响应完成且响应正常
		if (xmlrequest1.readyState == 4)
		{
			if (xmlrequest1.status == 200)
			{
				
					document.getElementById("goodsSum").innerHTML=xmlrequest1.responseText;
			}
			else
			{
				//页面不正常
				window.alert("您所请求的页面有异常。");
			}
		}
	}