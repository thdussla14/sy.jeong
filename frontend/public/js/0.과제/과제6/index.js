// 1. userbox DOM 객체 가져오기
let userbox = document.querySelector('.userbox')
let monbox = document.querySelector('.monbox')

let userHP = document.querySelector('.userHP')
let monHP = document.querySelector('.monHP')

let logbox = document.querySelector('.logbox')
let logbox2 = document.querySelector('.logbox2')

let 몬스터 = [
	  {m_img : '몬스터.gif'  , hp : 100, left	: 910 , exp : 50  },
	  {m_img : '몬스터2.gif' , hp : 200, left	: 910 , exp : 150 },
	  {m_img : '몬스터3.gif' , hp : 300, left	: 910 , exp : 300 } ]

let 캐릭터 = {
		img		: '게임캐릭터.png' ,
	 	left	: 10,
	 	hp		: 100,
	 	exp		: 0	,	
	 	level	: 1	,	
	 	power	: 20	}

// * [기본/처음] 위치
let u_left = 10 ;
let m_left = 910;

let u_HP = 300;
let m_HP = 300;

// 2. 문서 안에서 키 입력 이벤트
// 사용자 이동 함수
document.addEventListener('keydown',(e)=>{
	console.log(e.keyCode)
	let key = e.keyCode;
	if(key == 37)		//왼쪽키
		{u_left -= 10 ; 
		u_left = u_left < 0 ? 0 : u_left ;		// 차감된 왼쪽 좌표가 0보다 작으면 0 고정
		}
	else if (key == 39)	//오른쪽키
		{u_left += 10 ;
		u_left = u_left > 910 ? 910 : u_left ;	
		userbox.style.backgroundImage = `url(img/게임캐릭터_이동.png)`;	// 이동 모션 이미지
		userbox.style.backgroundSize = `110%`;}
	else if (key == 65)	//a 키
		{userbox.style.backgroundImage = `url(img/게임캐릭터_공격.png)`;
		 userbox.style.backgroundSize = `100%`	// 공격 모션 이미지
		
		if(Math.abs(u_left-m_left)<200)
		{alert('공격');
		m_HP -= 50
		monHP.style.width=`${m_HP}px`}
		
		}
	else if (key == 83)	// s 키
		{userbox.style.backgroundImage = `url(img/게임캐릭터_방어.png)`;
		 userbox.style.backgroundSize = `60%`;	// 방어 모션 이미지
		 }
		
	userbox.style.left = `${u_left}px`
	
	승부()
})

document.addEventListener('keyup',(e)=>{
		userbox.style.backgroundImage = `url(img/게임캐릭터.png)`
		userbox.style.backgroundSize = `90%`
})

// 몬스터 이동 함수 [랜덤 -> 1초]
	// 특정 시간마다 함수 실행해주는 함수 : setInterval(()=>{},밀리초(1000/1초))
	
setInterval(mon_moving,500);

function mon_moving (){
	// 1. 난수 +- 10
	let rand  = parseInt(Math.random()*50+1);
	let rand2 = parseInt(Math.random()*2);

	if(rand2 == 1)
		{m_left += rand}
	else {m_left -= rand}
		
	if(m_left < 0) {m_left = 0}
	if(m_left > 910) {m_left = 910}
	
	monbox.style.left =`${m_left}px`

	if(Math.abs(u_left-m_left)<50)
		{u_HP -= 20;
		userHP.style.width=`${u_HP}px`
		uinfo_HP.innerHTML = `캐릭터 HP : ${u_HP}`;}
	승부()
}

user_print()
monster_print()

function user_print(){
	let html =	`<tr colspan="3">
					<th> user_info </th>
				</tr>`
				
		html +=	`<tr>
					<td> user 좌표 </td> 	<td> : </td> <td> ${u_left} </td>
				</tr>
				<tr>
					<td> user HP </td> 	<td> : </td> <td> ${u_HP} </td>
				</tr>
				<tr>
					<td> user exp </td>	<td> : </td> <td> ${캐릭터.exp} </td>
				</tr>
				<tr>
					<td> user level </td> <td> : </td><td> ${캐릭터.level}</td>
				</tr>`
				
	document.querySelector('.u_info').innerHTML = html
	userHP.innetHTML=''
	
} // user fun e

function monster_print(){	
	let html =	`<tr colspan="3">
					<th> monster_info </th>
				</tr>`

	if(m_HP<=0){몬스터.splice(0,1);}

		html += `<tr>
					<td> monster 좌표 </td> 	<td> : </td> <td> ${m_left} </td>
				</tr>
				<tr>
					<td> monster HP </td> 	<td> : </td> <td> ${m_HP} </td>
				</tr>
				<tr>
					<td> monster exp </td>	<td> : </td> <td> ${몬스터[0].exp} </td>
				</tr>`
			
	document.querySelector('.m_info').innerHTML = html	
	document.querySelector('.monbox').style.backgrounImage=`img/${몬스터[0].m_img}`
	
	monHP.innerHTML=''
} // mon fun e


function 승부()
{
	if(u_HP<=0)
			{userbox.style.display='none';
			alert('GAME OVER'); return ;}
	if(m_HP<=0)
			{alert('GAME WIN');
			userbox.style.left = `10px`
			monbox.style.left = `910px`
			 m_HP=몬스터[0].hp 
			 m_left=몬스터[0].left
			 user_print()
			 monster_print()}		
	 
			
}

/*
	함수 형태
		1. 일반함수 	: function 함수명 () { }
		2. 익명함수 	: function () { }
		3. 람다식함수 	: ( ) => { }
		4. 변수함수 	: let 변수명 = ( )=> { }
		
	Math.random()	: 0 ~ 1  사이 실수
	Math.random()*10: 0 ~ 10 사이 실수
		
 */






