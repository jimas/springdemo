/**
 * 保留小数位
 * 
 * @param num
 * @param point
 * @param flag 标示，仅对point为2时有效，如果flag为true，保留数字格式为##############0.00##，否则为##############0.00
 * @returns
 */
function getRound(num,point,flag){
	alert(num);
	 point = point == undefined ? 0 : point;
	 flag = flag == undefined ? true : flag;
	 
	 if(point == 2 && flag) return getRoundX(num);
	 
	 point = point > 0 ? point : 0;
	 if(isNaN(num)) num = 0;
	 num = parseFloat(num);
	 var a = 1;
	 for(var i=0;i<point;i++){
	 a = a*10;
	 }
	 var num1 = num * a;
	 var num2 = Math.round(num1);//四舍五入
	 var num3 = num2/a + "";
	 num3 = num3.indexOf(".") != -1 ? num3 + '00000000000000000000' : num3 + '.00000000000000000000';
	 
	 return num3.substring(0,num3.indexOf(".")+1+point);
}

function getRoundX(num){
	 var point = 4;
	 if(isNaN(num)) num = 0;
	 num = parseFloat(num);
	 var a = 1;
	 for(var i=0;i<point;i++){
	 a = a*10;
	 }
	 var num1 = num * a;
	 var num2 = Math.round(num1);//四舍五入
	 var num3 = num2/a + "";
	 num3 = num3.indexOf(".") != -1 ? num3 + '00000000000000000000' : num3 + '.00000000000000000000';
	 
	 point = 2;
	 //最多显示4位小数
	 if(num3.substring(num3.indexOf(".")+3,num3.indexOf(".")+4)!="0")
		 point = 3;
	 if(num3.substring(num3.indexOf(".")+4,num3.indexOf(".")+5)!="0"){
		 point = 4;
	 }
		
		 
	 return num3.substring(0,num3.indexOf(".")+1+point);
}

/**
 * 只能输入数字
 * 
 * @param id
 * @param withSign
 * @param point 小数位数限制
 */
function numberLimit(id,withSign,point){
	
	var $e = typeof id == 'string' ? $("#"+id) : $(id);
	
	withSign = withSign == undefined ? true : withSign;
	point = point || false;
	$e.keydown(function(event){
		var keyCode = event.keyCode;
		var cursorPosition = getCursorPosition(this);	//光标位置
		if(keyCode>=112 && keyCode <= 123) return true;//F1-F12
		if(event.ctrlKey && keyCode==67) return true;//ctrl+c
		if(event.ctrlKey && keyCode==86) return true;//ctrl+v
		if(keyCode == 8) return true;	//退格键
		if(keyCode == 37 || keyCode == 39) return true;//左右方向键
		if(keyCode >= 16 && keyCode <= 18) return true;//shift键 、tab键 、alt键 、Caps LocK
		if(keyCode == 9 ) return true;//tab键 
		
		if(point){
			//小数位数限制
			if($(this).val().indexOf(".")>0&&($(this).val().substring($(this).val().indexOf(".")+1).length >= point)){
				var pointIndex = $(this).val().indexOf(".");//小数点位置，从0开始
				if(pointIndex<cursorPosition) return false;	//光标在小数点后面，不能继续输入
			} 
		}
		if(keyCode>=48 && keyCode <= 57) return true;//标准键盘0-9
		if(keyCode>=96 && keyCode <= 105) return true;//小键盘0-9
		if(keyCode==110 || keyCode == 190) return  $(this).val() != "" && $(this).val() != "-" && $(this).val().indexOf(".")==-1;//小数点
		if(keyCode==109 ) return withSign && $(this).val()=="";//负号
		
		return false;
	}).keyup(function(){
		//
	});
}

/**
 * 获得光标的位置
 * 
 * @param element
 */
function getCursorPosition(element){
	
	var cursurPosition = -1;
	try{
		if(element == undefined || element == null) return cursurPosition;
		
		if(element.selectionStart){
			//!IE
	        cursurPosition= element.selectionStart;
	    }else {
	    	//IE
	    	if(document.selection){
	    		var range = document.selection.createRange();
		        range.moveStart("character",-element.value.length);
		        cursurPosition=range.text.length;
	    	}
	    }
	}catch(e){
		console.log(e);
		cursurPosition = 0;
	}
	
	return cursurPosition;
}