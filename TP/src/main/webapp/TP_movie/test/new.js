let spaceList = [
{local:'서울', space: [{s:'강남'},{s:'강변'},{s:'건대입구'},{s:'구로'},{s:'대학로'},{s:'등촌'},{s:'명동'},{s:'미아'},{s:'송파'},{s:'신촌'}] },
{local:'경기', space: [{s:'광교'},{s:'구리'},{s:'김포'},{s:'동수원'},{s: '동탄'},{s:'부천'},{s:'안산'},{s:'야탑'},{s:'의정부'},{s:'인천'},{s:'일산'},{s:'판교'}]},
{local:'충청', space: [{s:'논산'},{s:'대전'},{s:'세종'},{s:'아산'},{s:'천안'},{s:'청주'}]},
{local:'전라', space: [{s:'광양'},{s:'광주'},{s:'목포'},{s:'순천'},{s:'익산'},{s:'전주'},{s:'제주'}]},
{local:'경상', space: [{s:'김해'},{s:'대구'},{s:'마산'},{s:'서면'},{s:'울산'},{s:'창원'}]}
]







 print()

function print(){
	
		html = ``
	
	spaceList.forEach((o)=>{
		
		

		html += `<button> ${o.local}</button>`
				
	})
	
	document.querySelector('.new').innerHTML = html
}