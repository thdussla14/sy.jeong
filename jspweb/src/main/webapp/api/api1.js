console.log('api1 js')
// 1. 공공데이터 전기차 충전소 현황 
getapi1()
function getapi1(){
	
	$.ajax({
		url : "https://api.odcloud.kr/api/15090398/v1/uddi:6fe0e3f2-0285-4999-9edf-995afe19a6ea?page=1&perPage=96&serviceKey=BfP86px%2BpQ0jnkgJQI4pTC4vZ5s%2FfIEcv8qV9zv7bXgmJzqVizTFx4lo1c8P54CXOnRL7F3AxUU%2B%2BaBXSzRpHA%3D%3D",
		method : "get",
		success : (r)=>{
			console.log(r)
			document.querySelector('.totalcount').innerHTML = `전기차 충전소 개수 : `+r.currentCount;
			let html = `<tr>
							<th>번호			</th>
							<th>충전소명		</th>
							<th>시군명		</th>
							<th>운영기관명		</th>
							<th>소재지도로명주소	</th>
							<th>소재지우편번호	</th>
							<th>소재지지번주소	</th>
							<th>경도(WGS84)	</th>
							<th>위도(WGS84)	</th>

						 </tr>`;
			r.data.forEach((o,i)=>{
				// * 필드명에 특수문자가 있는 경우 객체명['필드명'] 호출 
				html += `<tr>
							<td>${i+1} </td>
							<td>${o.충전소명}</td>
							<td>${o.시군명}</td>
							<td>${o.운영기관명}</td>
							<td>${o.소재지도로명주소}</td>
							<td>${o.소재지우편번호}</td>
							<td>${o.소재지지번주소}</td>
							<td>${o['경도(WGS84)']}</td>
							<td>${o['위도(WGS84)']}</td>
	
						 </tr>`

			}) // forEach e
			document.querySelector('.table').innerHTML = html;
		}// success e
	})

}
// 2. 공공데이터 시도별 미세먼지 실시간 현황
getapi2()
function getapi2(){	
	$.ajax({
		url : "https://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty?serviceKey=BfP86px%2BpQ0jnkgJQI4pTC4vZ5s%2FfIEcv8qV9zv7bXgmJzqVizTFx4lo1c8P54CXOnRL7F3AxUU%2B%2BaBXSzRpHA%3D%3D&returnType=json&numOfRows=200&pageNo=1&sidoName=%EA%B2%BD%EA%B8%B0&ver=1.0",
		method : "get",
		success : (r)=>{
			console.log(r)
			console.log(r.response.body.items)
		}// success e
	})
}