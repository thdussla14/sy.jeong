function Ex1(){
	// 변수 10 개  --> 객체 1개
	let info ={
		data1 :document.querySelector('.data1').value ,
		data2 :document.querySelector('.data2').value ,
		data3 :document.querySelector('.data3').value ,
		data4 :document.querySelector('.data4').value ,
		data5 :document.querySelector('.data5').value ,
		data6 :document.querySelector('.data6').value ,
		data7 :document.querySelector('input[name="data7"]:checked').value,	// radio에서 선택된 버튼의 value
		data8 :document.querySelector('.data8').checked,					// 체크여부 [true/flase]
		data9 :document.querySelector('.data9').value ,
		data10:document.querySelector('.data10').value,	
	}
	console.log(info);	
	$.ajax({ 
         url 	 : "/jspweb/Ex2" , 
         method  : "post" , 
         data 	 : info , 
         success : function( result ){   
			       alert('통신');  
			       if(result=='true'){alert('등록성공');getdata();}
         }
      });
}
getdata();
function getdata(){
	$.ajax({ 
         url 	 : "/jspweb/Ex2" , 
         method  : "get" , 
         success : function( result ){   
			      // console.log(result);  
			      // document.querySelector('.box').innerHTML = result ;
			    let html =`<table border="1">
			    				<tr>
			    					<th>data1</th><th>data2</th><th>data3</th><th>data4</th><th>data5</th>
			    					<th>data6</th><th>data7</th><th>data8</th><th>data9</th><th>data10</th>
			    				</th>`
				result.forEach((o)=>{	// 객체명.forEach((반복변수,반복인덱스)=>{실행문})
					html += `<tr>		
								<th>${o.data1} </th><th>${o.data2}</th><th>${o.data3}</th>
								<th>${o.data4} </th><th>${o.data5}</th><th>${o.data6}</th>
								<th>${o.data7} </th><th>${o.data8}</th><th>${o.data9}</th>
								<th>${o.data10}</th>	
			    			</th>`
				})
					html += `</table>`
					document.querySelector('.box').innerHTML = html;print();
				}  
      });
} 

function Register(){
	// 변수 10 개  --> 객체 1개
	let info ={
		sdata1 :document.querySelector('.sdata1').value ,
		sdata2 :document.querySelector('.sdata2').value ,
		sdata3 :document.querySelector('.sdata3').value ,
		sdata4 :document.querySelector('.sdata4').value ,
		sdata5 :document.querySelector('.sdata5').value ,
		sdata6 :document.querySelector('input[name="sdata6"]:checked').value,	// radio에서 선택된 버튼의 value
		sdata7 :document.querySelector('.sdata7').checked,					// 체크여부 [true/flase]
		sdata8 :document.querySelector('.sdata8').value ,
		sdata9 :document.querySelector('.sdata9').value 
	}
	console.log(info);	
	$.ajax({ 
         url 	 : "/jspweb/Student" , 
         method  : "post" , 
         data 	 : info , 
         success : function( result ){   
			       alert('통신');  
			       if(result=='true'){alert('등록성공');print();}
         }
      });
}

function print(){
	$.ajax({ 
         url 	 : "/jspweb/Student" , 
         method  : "get" , 
         success : function( result ){   
			    let html =`<table border="1">
			    				<tr>
			    					<th>이름     </th><th>전화번호	</th><th>키		</th>
			    					<th>나이     </th><th>등록일 	</th><th>성별		</th>
			    					<th>개인정보동의</th><th>사는지역	</th><th>자기소개	</th>
			    				</th>`
				result.forEach((o)=>{	// 객체명.forEach((반복변수,반복인덱스)=>{실행문})
					html += `<tr>		
								<th>${o.name} </th><th>${o.phone}</th><th>${o.height}</th>
								<th>${o.age}  </th><th>${o.date}</th> <th>${o.sex}</th>
								<th>${o.agree}</th><th>${o.live}</th> <th>${o.introduce}</th>	
			    			</th>`
				})
					html += `</table>`
					document.querySelector('.box2').innerHTML = html;
				}  
      });
} 




