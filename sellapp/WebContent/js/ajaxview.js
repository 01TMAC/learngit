// 定义了XMLHttpRequest对象
	var xmlrequest;
	// 完成XMLHttpRequest对象的初始化
	function createXMLHttpRequest()
	{
		if(window.XMLHttpRequest)
		{ 
			// DOM 2浏览器
			xmlrequest = new XMLHttpRequest();
		}
		else if (window.ActiveXObject)
		{
			// IE浏览器
			try
			{
				xmlrequest = new ActiveXObject("Msxml2.XMLHTTP");
			}
			catch (e)
			{
				try
				{
					xmlrequest = new ActiveXObject("Microsoft.XMLHTTP");
				}
				catch (e)
				{
				}
			}
		}
	}
	
	
	
	// 事件处理函数，点击列表触发
	function change(id)
	{
		// 初始化XMLHttpRequest对象
		createXMLHttpRequest();
		// 设置请求响应的URL
		var uri = "ajaxview.jsp";
		// 设置处理响应的回调函数
		xmlrequest.onreadystatechange = processResponse;
		// 设置以POST方式发送请求，并打开连接
		xmlrequest.open("POST", uri, true); 
		// 设置POST请求的请求头
		xmlrequest.setRequestHeader("Content-Type"
			, "application/x-www-form-urlencoded");
		// 发送请求
		xmlrequest.send("id="+id);
	}
	// 定义处理响应的回调函数
	function processResponse()
	{
		//响应完成且响应正常
		if (xmlrequest.readyState == 4)
		{
			if (xmlrequest.status == 200)
			{
				document.getElementById("goodslist").innerHTML=xmlrequest.responseText;
				
			}
			else
			{
				//页面不正常
				window.alert("您所请求的页面有异常。");
			}
		}
	}