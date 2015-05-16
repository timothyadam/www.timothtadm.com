<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="../includes/importer.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<ht:head/>
<title>后台管理管理系统</title>
</head>
<script>
$(document).ready(function () {
$( "#menu" ).menu();
})
  </script>
<style>
 
	body{
		font: 80.0% "Trebuchet MS", sans-serif;
		margin: 55px;
		margin-left :0;
	}
	.demoHeaders {
		margin-top: 2em;
	}
  </style>
</head>
<body>



<ul style="width:150px;" id="menu">
	<li>首页</li>
	<li>Item 2</li>
	<li>Item 3
		<ul>
			<li>Item 3-1</li>
			<li>Item 3-2</li>
			<li>Item 3-3</li>
			<li>Item 3-4</li>
			<li>Item 3-5</li>
		</ul>
	</li>
	<li>Item 4</li>
	<li>Item 5</li>
	<li>Item 6</li>
	<li>Item 7</li>
	<li>Item 8</li>
	<li>Item 9</li>
	<li>Item 10</li>
	<li>Item 10</li>
	<li>Item 10</li>
	<li>Item 11</li>
	<li>Item 12</li>
	<li>Item 13</li>
	<li>Item 14</li>
	<li>Item 15</li>
</ul>
</body>
</html>