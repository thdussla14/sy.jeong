package Day07;

import java.util.Scanner;

public class Ex1_회원시스템_배열 {

	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		
		String[] memberList = new String[3]; 
		
		
		while(true) {
			//-------------------------------------------------------------------------------------
			System.out.println("번호\t회원명\t전화번호");
			for (int i=0; i<memberList.length ; i++)
				{if(memberList[i] != null)
					{String[] member = memberList[i].split(",");
					System.out.println(i+"\t"+member[0]+"\t"+member[1]);}

				}
			//-------------------------------------------------------------------------------------
			System.out.println("1. 회원 등록    2. 회원 삭제 : ");
			
			int ch = scanner.nextInt();
			//-------------------------------------------------------------------------------------
			if(ch==1)
				{System.out.println("회원명 : ");		String name = scanner.next();
				System.out.println("전화번호 : ");		String phone = scanner.next();
				
				// push 기능 만들기
				for( int i=0 ; i <memberList.length ; i++)
					{if(memberList[i]==null)
						{memberList[i] = name+","+phone;
						System.out.println((i+1)+"번 회원이 등록 되었습니다.s\t정보 : "+memberList[i]);
						break;}					
					}

				}
			//-------------------------------------------------------------------------------------
			else if(ch==2) 
				{System.out.println("삭제할 번호 / 인덱스 : ");  int no = scanner.nextInt();
				// 배열내 데이터 삭제 기능이 따로 없으므로 null 대입으로 비워주기
				memberList[no] = null;
				// **** 삭제 후 빈자리 채우기 [삭제된 인덱스 뒤 데이터 한칸씩 당기기] ****
				for (int i=no ; i<memberList.length ; i++)
					{if(i+1 == memberList.length) 
						{ memberList[i] = null; break;}
					memberList[i] = memberList[i+1];
					if(memberList[i+1] == null) {break;}
					}
				}
			
			//-------------------------------------------------------------------------------------
			else { break; }
			
			
		}	// while e	
	}	// main e
} //class e
