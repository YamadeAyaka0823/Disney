//アコーディオン
//$(function(){
//	$("#acordion").accordion({
////		header: "h3",
//		collapsible: true
//	});
//});

$(function(){
	$('.accordion_content').hide();
	$('.accordion_click').click(function(){
		$(this).next().slideToggle();
	});
});