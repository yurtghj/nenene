import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int x = 0;

		System.out.println("����� ������ �Է��Ͻÿ�.");
		System.out.print("����(1)/����(2) :");
		x = scan.nextInt();

		switch (x) {

		case 1:
			System.out.println("����� ������ �����̱���");
			break;

		case 2:
			System.out.println("����� ������ �����̱���");
			break;

		default:
			System.out.println("������ ������ϴ�.");
		}
			

	}

}
