import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int x = 0;

		System.out.println("당신의 성별을 입력하시오.");
		System.out.print("남성(1)/여성(2) :");
		x = scan.nextInt();

		switch (x) {

		case 1:
			System.out.println("당신의 성별은 남성이군요");
			break;

		case 2:
			System.out.println("당신의 성별은 여성이군요");
			break;

		default:
			System.out.println("범위를 벗어났습니다.");
		}
			

	}

}
