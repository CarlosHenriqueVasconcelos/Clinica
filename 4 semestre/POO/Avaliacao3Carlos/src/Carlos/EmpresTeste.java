package Carlos;

import java.util.Scanner;

public class EmpresTeste {
	
	public static void main(String [ ] args){
		Scanner imput = new Scanner(System.in);
		
		String str1, str2, str3,str4;
		System.out.println("Informe nome da Empresa : ");
		str1 = imput.nextLine();
		System.out.println("Informe o cnpj da Empresa: ");
		str2 = imput.nextLine();
		System.out.println("Informe a inscriçao da Empresa: ");
		str3 = imput.nextLine();
		System.out.println("Informe o dominio da Empresa: ");
		str4 = imput.nextLine();
		
		Empresa empresa1 = new Empresa(str1,str2,str3,str4);
		
		imput.close();
		
	}

}
