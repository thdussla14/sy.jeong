
 let output = '' // 출력 변수
 
 output='' 	
 			
 let line0 = Number( prompt('과제1 줄수'))
 
/* let k = parseInt(line0/2)
 
 for (let i=1; i<=line0 ; i++)
 	{	 
	if(i<=k)
		{// if 참
			for (let j=1  ; j<=k-i+2 ; j++){output += ' '};		
			for (let s=1  ; s<=i*2-1 ; s++){output += '*'};	 
			output += '\n';
		}			
    else{//if 거짓 
			for (let j=1 ; j<=i-k   ; j++){output += ' '};
			for (let s=1 ; s<=line0-(i-k-1)*2 ; s++){output += '*'};		
			output += '\n'; 
		}
	}	
		
 console.log(output)
 
*/
/* 대입 9 k= 4
	    i<=k     	i=1   j= 1 2 3 4   s=1  \n 	k-i=3
          		  	i=2   j= 1 2 3     s=3  \n 	k-i=2
					i=3   j= 1 2       s=5  \n 	k-i=1
					i=4   j= 1         s=7  \n 	k-i=0
-----------------------------------------------------					
		i>k			i=5   j= 0         s=9  \n 	i-k-1 =0
					i=6   j= 1         s=7  \n 	i-k-1 =1
					i=7   j= 1 2       s=5  \n 	i-k-1 =2
					i=8   j= 1 2 3     s=3  \n 	i-k-1 =3
					i=9   j= 1 2 3 4   s=1  \n 	i-k-1 =4


 */
 let k = Math.round(line0/2)
 
 for (let i=1; i<=line0 ; i++)
 	{	 
	if(i<=k)
		{// if 참
			for (let j=1  ; j<=k-i ; j++)  {output += ' '};		
			for (let s=1  ; s<=i*2-1 ; s++){output += '*'};	 
			output += '\n';
		}			
    else{//if 거짓 
			for (let j=1 ; j<=i-k   ; j++)        {output += ' '};
			for (let s=1 ; s<=line0-(i-k)*2 ; s++){output += '*'};		
			output += '\n'; 
		}
	}	
		
 console.log(output)
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 