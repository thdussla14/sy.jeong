let 버튼목록현황 = [null, null, null, null, null, null, null, null, null]

function 클릭이벤트(버튼번호) { 
	if( !알두기(버튼번호,'O') ){return;}
	if( 결과 ()){return;}
	while(true)
		{ let 컴퓨터번호 = parseInt(Math.random()*9+1)		
		if(알두기(컴퓨터번호,'X'))
		{결과();return;} } // w e
} // f e

function 알두기(버튼번호,알모양) { 
		let 버튼목록 = document.querySelectorAll('.버튼')
		if  (버튼목록현황[버튼번호-1] != null){return false;}
		else{버튼목록[버튼번호-1].innerHTML = 알모양;버튼목록현황[버튼번호-1] = 알모양;}
} // f e

function 결과 (){ 
		for (let i=0 ; i<=6 ; i+=3)
		{if(버튼목록현황[i] != null &&버튼목록현황[i]==버튼목록현황[i+1]&&버튼목록현황[i+1]==버튼목록현황[i+2])
		{결과출력(버튼목록현황[i]);return true;}} // for e

		for(let i=0 ; i <=2 ; i++ )	
		{if( 버튼목록현황[i]!=null && 버튼목록현황[i]==버튼목록현황[i+3]&&버튼목록현황[i+3]==버튼목록현황[i+6])
		 {결과출력(버튼목록현황[i]);return true;}} // for e
		
		if( 버튼목록현황[0]!=null && 버튼목록현황[0]==버튼목록현황[4]&&버튼목록현황[4]==버튼목록현황[8])
	 	{결과출력(버튼목록현황[0]);return true;}
		 if( 버튼목록현황[2]!=null && 버튼목록현황[2]==버튼목록현황[4]&&버튼목록현황[4]==버튼목록현황[6])
	 	{결과출력(버튼목록현황[2]);return true;}		

		let 빈자리수 = 0;
		for (버튼 of 버튼목록현황){if(버튼 == null){빈자리수++;}}
		if(빈자리수 == 0){결과출력('-');return true;}
} // f e

function 결과출력 (알모양) { 
		 let 게임판 = document.querySelector('.게임판')
	     if(알모양=='-'){게임판.innerHTML = '무승부'}
	     else(게임판.innerHTML = 알모양 + '승리')
} // f e