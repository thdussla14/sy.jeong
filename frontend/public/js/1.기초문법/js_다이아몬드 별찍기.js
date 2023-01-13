
 
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
/* 대입 9 k= 5
	    i<=k     	i=1   j= 1 2 3 4   s=1  \n 	k-i=4      s= 1+2(i-1)=1
          		  	i=2   j= 1 2 3     s=3  \n 	k-i=3      s= 1+2(i-1)=3		
					i=3   j= 1 2       s=5  \n 	k-i=2      s= 1+2(i-1)=5
					i=4   j= 1         s=7  \n 	k-i=1      s= 1+2(i-1)=7				
					i=5   j= 0         s=9  \n  k-i=0      s= 1+2(i-1)=9
		-----------------------------------------------------	
	   i>k  		i=6   j= 1         s=7  \n 	i-k =1    	line-(i-k)*2 = 7
					i=7   j= 1 2       s=5  \n 	i-k =2    	line-(i-k)*2 = 5
					i=8   j= 1 2 3     s=3  \n 	i-k =3    	line-(i-k)*2 = 3
					i=9   j= 1 2 3 4   s=1  \n 	i-k =4    	line-(i-k)*2 = 1

	대입 10 k= 5
	    i<=k     	i=1   j= 1 2 3 4   s=1  \n 	k-i=4      s= 1+2(i-1)=1
          		  	i=2   j= 1 2 3     s=3  \n 	k-i=3      s= 1+2(i-1)=3
					i=3   j= 1 2       s=5  \n 	k-i=2      s= 1+2(i-1)=5
					i=4   j= 1         s=7  \n 	k-i=1      s= 1+2(i-1)=7				
					i=5   j= 0         s=9  \n  k-i=0      s= 1+2(i-1)=9
		-----------------------------------------------------	
	    i>k		    i=6   j= 0         s=9  \n 	i-k-1 =0	(line0-1)-(i-k-1)*2 
					i=7   j= 1         s=7  \n 	i-k-1 =1	(line0-1)-(i-k-1)*2
					i=8   j= 1 2       s=5  \n 	i-k-1 =2	(line0-1)-(i-k-1)*2
					i=9   j= 1 2 3     s=3  \n 	i-k-1 =3	(line0-1)-(i-k-1)*2
					i=10  j= 1 2 3 4   s=1  \n 	i-k-1 =4	(line0-1)-(i-k-1)*2
 */

 let output = '' // 출력 변수
 output='' 				
 let line0 = Number( prompt('과제1 줄수'))
 let k = Math.round(line0/2)
 
 if(line0%2 != 0)
 { for (let i=1; i<=line0 ; i++)
	 	{if(i<=k)
			{// if 참
				for (let j=1  ; j<=k-i  	; j++)	{output += ' '};		
				for (let s=1  ; s<=i*2-1 	; s++)	{output += '*'};	 
				output += '\n';}			
	    else{//if 거짓 
				for (let j=1 ; j<=i-k   	; j++)    {output += ' '};
				for (let s=1 ; s<=line0-(i-k)*2 ; s++){output += '*'};		
				output += '\n';}
		}	// for e
 }	//if e
 else
  { for (let i=1; i<=line0 ; i++)
	 	{ if(i<=k)
			{// if 참
				for (let j=1  ; j<=k-i 		; j++)  {output += ' '};		
				for (let s=1  ; s<=i*2-1 	; s++)	{output += '*'};	 
				output += '\n';}				
	    else{//if 거짓 
				for (let j=1 ; j<=i-k-1   		  ; j++){output += ' '};
				for (let s=1 ; s<=(line0-1)-(i-k-1)*2 ; s++){output += '*'};		
				output += '\n';}
		} //for e	
 } //else e
 
		
 console.log(output)
 
 
 
 
 
 
 //  (line-1)-(i-k-1)*2 = line-1-2i+2k+2 = line-()
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 