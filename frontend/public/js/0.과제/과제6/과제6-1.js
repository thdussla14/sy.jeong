let userbox = document.querySelector('.userbox')
let monbox = document.querySelector('.monbox')
let userHP = document.querySelector('.userHP')
let monHP = document.querySelector('.monHP')
let logbox = document.querySelector('.logbox')
let logbox2 = document.querySelector('.logbox2')

let 몬스터 = [
	  {m_img : '몬스터.gif'  , hp : 300, left	: 910 , exp : 50  },
	  {m_img : '몬스터2.gif' , hp : 300, left	: 910 , exp : 150 },
	  {m_img : '몬스터3.gif' , hp : 300, left	: 910 , exp : 300 } ]
	  
let 캐릭터 = {
		img		: '게임캐릭터.png' ,
	 	left	: 10,
	 	hp		: 300,
	 	exp		: 0	,	
	 	level	: 1	,	
	 	power	: 20	}	  
	 	

// * [기본/처음] 위치
let u_left = 10 ;
let m_left = 910;
let u_HP = 300;
let m_HP = 300;	 	
	 	
user()
mon()

function mon(){	
	let html =	`<tr colspan="3">
					<th> monster_info </th>
				</tr>`
		
		 html += `<tr>
					<td> monster 좌표 </td> 	<td> : </td> <td> ${m_left} </td>
				</tr>
				<tr>
					<td> monster HP </td> 	<td> : </td> <td> ${m_HP} </td>
				</tr>
				<tr>
					<td> monster exp </td>	<td> : </td> <td> ${몬스터[0].exp} </td>
				</tr>`	
				
	monbox.style.left =`${m_left}px`	
	monHP.innerHTML = `${m_HP}`
	document.querySelector('.m_info').innerHTML=html
}	// fun e
	 	
function user(){
	let html =	`<tr colspan="3">
					<th> user_info </th>
				</tr>`
				
		html +=	`<tr>
					<td> user 좌표 </td> 	<td> : </td> <td> ${u_left} </td>
				</tr>
				<tr>
					<td> user HP  </td> <td> : </td> <td> ${u_HP} </td>
				</tr>
				<tr>
					<td> user exp  </td> <td> : </td> <td> ${캐릭터.exp} </td>
				</tr>
				<tr>
					<td> user level </td> <td> : </td><td> ${캐릭터.level}</td>
				</tr>`
	userbox.style.left = `${u_left}px`//--------------------------------출력	
	userHP.innerHTML = `${u_HP}`		
	document.querySelector('.u_info').innerHTML = html
}	// fun e

// 조작키 설정
document.addEventListener('keydown',(e)=>{
	
	let key = e.keyCode;
	if(key == 37)		//---------------------------------------------왼쪽키
		{u_left -= 10 ; 
		u_left = u_left < 0 ? 0 : u_left ;	
		}
	else if (key == 39)	//--------------------------------------------오른쪽키
		{u_left += 10 ;
		u_left = u_left > 910 ? 910 : u_left ;	
		userbox.style.backgroundImage = `url(img/게임캐릭터_이동.png)`;	
		userbox.style.backgroundSize = `110%`;}
	else if (key == 65)	//-------------------------------------------a 공격키
		{userbox.style.backgroundImage = `url(img/게임캐릭터_공격.png)`;
		 userbox.style.backgroundSize = `100%`	
		
		if(Math.abs(u_left-m_left)<200)//----------------------------공격 타격 
		{alert('공격');
		m_HP -= 50
		monHP.style.width=`${m_HP}px`
		monHP.innerHTML=''}	
		}
	else if (key == 83)	//-------------------------------------------s 방어키
		{userbox.style.backgroundImage = `url(img/게임캐릭터_방어.png)`;
		 userbox.style.backgroundSize = `60%`;	
		 }
		
	userbox.style.left = `${u_left}px`//--------------------------------출력
	
	승부()
	user()
	mon()

})

document.addEventListener('keyup',(e)=>{
		userbox.style.backgroundImage = `url(img/게임캐릭터.png)`
		userbox.style.backgroundSize = `90%`
})
// 몬스터 조작 설정
setInterval(mon_moving,500);

function mon_moving (){
	// 1. 난수
	let rand  = parseInt(Math.random()*50+1);
	let rand2 = parseInt(Math.random()*2);

	if(rand2 == 1){m_left += rand}
	else {m_left -= rand}
		
	if(m_left < 0) {m_left = 0}
	if(m_left > 910) {m_left = 910}
	
	monbox.style.left =`${m_left}px`

	if(Math.abs(u_left-m_left)<50)//------------------------------몬스터 공격 설정
		{u_HP -= 20;
		userHP.style.width=`${u_HP}px`
		userHP.innerHTML=''
		uinfo_HP.innerHTML = `캐릭터 HP : ${u_HP}`;}
	
	승부()	
	user()
	mon()
		
}

function 승부(){

	if(u_HP<=0)
		{userboxbox.style.display='none';
		monbox.style.display='none';
		alert('GAME OVER');}			//-------------------user HP 소진시 GAME OVER
	
	if(m_HP>0){return;}					//-------------------------------몬스터 레벨업
	
	else if(m_HP<=0)
		{몬스터.splice(0,1);
		if(몬스터.length=0){alert('GAME WIN');}}//------------모든 몬스터 퇴치시 GAME WIN
		

	
}



