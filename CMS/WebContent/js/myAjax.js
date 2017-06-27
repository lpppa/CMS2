function getXMLHttpRequest() {
	var xmlhttp;
	if (window.XMLHttpRequest) {
		// 获得当前浏览器【代理对象】
		xmlhttp = new XMLHttpRequest();
	} else {
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	return xmlhttp;
}