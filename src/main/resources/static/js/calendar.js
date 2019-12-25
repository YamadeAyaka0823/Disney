var Date = new Date(); //今日の日付取得
var WeekTable = new Array("日","月","火","水","木","金","土"); //曜日テーブル定義
var MonthTable = new Array(31,28,31,30,31,30,31,31,30,31,30,31); //月テーブル定義
var Year = Date.getFullYear(); //現在の年を取得

if(((Year % 4) == 0 && (Year % 100) != 0) || (Year % 400) == 0){ //うるう年の計算
	MonthTable[1] = 29;
}

var Month = Date.getMonth(); //現在の月を取得
var Today = Date.getDate(); //現在の日にちを取得
Date.setDate(1); //日付を1日にセット
var Week = Date.getDay(); //1日の曜日を取得(上で1日にセットしたから)

var TableLine = Math.ceil((Week + MonthTable[Month])/7); //計算したら5行(テーブルの行数)
var Table = new Array(7 * TableLine); //計算したら35セル(表のセル数分定義)

for(i = 0; i < 7 * TableLine; i++) Table[i] = " ";
for(i = 0; i < MonthTable[Month]; i++) Table[i + Week] = i + 1;

//カレンダーの表示
document.write("<table border='1'>");
document.write("<tr><td colspan='7' bgcolor='#7fffd4'>");
document.write("<strong>", Year, "年", (Month + 1), "月カレンダー</strong>");
document.write("</td></tr>");

document.write("<tr>");
for(i = 0; i < 7; i++){
	document.write("<td align='center' ");
	if(i == 0)document.write("bgcolor = '#fa8072'>");
	else document.write("bgcolor= '#ffebcd'>");
	document.write("<strong>", WeekTable[i], "</strong>");
	document.write("</td>");
}
document.write("</tr>");

for(i = 0; i < TableLine; i++){
	document.write("<tr>");
	for(j = 0; j < 7; j++){
		document.write("<td align='center' ");
		var Dat = Table[j + (i * 7)];
		if(Dat == Today)document.write("bgcolor='#00ffff'>");
		else if(j == 0)document.write("bgcolor='#ffb6c1'>");
		else document.write("bgcolor='white'>");
		document.write("<strong>", Dat, "</strong>");
		document.write("</td>");
	}
	document.write("</tr>");
}
document.write("</table>");