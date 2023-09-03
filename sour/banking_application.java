package sour;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
public class banking_application {
	static String b[]=new String[90];
	static String a[]=new String[90];
	static String[] s=new String[90];
	static int top,se,t;
	public static void login() {
		Scanner input=new Scanner(System.in);
		boolean flag=true;
		while(flag) {
		System.out.println("Enter the account number");
		String acno=input.nextLine();
		System.out.println("Enter the password");
		String pass=input.nextLine();
				int i=0;
		try {
			File f=new File("krishna.txt");
			Scanner in=new Scanner(f);
			while(in.hasNextLine()) {
				s[i++]=in.nextLine();
			}
			top=i;
			in.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		for(int j=0;j<top;j++) {
			if(s[j].equals(acno)) {
				b[1]=s[j];
				b[2]=s[j+1];
				b[3]=s[j+2];
				se=j;
				flag=false;
				break;
			}
			else if(!s[j].equals(acno)&&j==top-1) {
				System.out.println("ERROR IN ACCOUNT NUMBER AND TRI AGAIN");
			}
		}
		options();
		last(se,-1);
		}
	}
	public static void last(int se,int r) {
		s[se+2]=b[3];
		if(r!=-1) {
			s[r+2]=a[3];
		}
		try {
			FileWriter f=new FileWriter("krishna.txt");
			
			for(int k=0;k<top;k++) {
				f.write(s[k]+"\n");
			}
			f.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	public static void cashwithdrawl(int withdrawamount) {
		int amount=Integer.valueOf(b[3]);
		if(withdrawamount<=amount) {
			int balence=amount-withdrawamount;
			 b[3]=String.valueOf(balence);
			 System.out.println("Balence in the account is :"+b[3]);
		}
		
	}
	public static void deposit(int depositamount) {
		int amount=Integer.valueOf(b[3]);
		int balence=amount+depositamount;
		b[3]=String.valueOf(balence);
		 System.out.println("Balence in the account is :"+b[3]);
	}
	public static void amount_transfer() {	
		System.out.println("Enter the account number to transfer");
		Scanner input=new Scanner(System.in);
		String transferacno=input.nextLine();
	for(int i=0;i<top;i++) {
		if(s[i].equals(transferacno)) {
			a[1]=s[i];
			a[2]=s[i+1];
			a[3]=s[i+2];
			t=i;
			break;
		}
	}
	System.out.println("Enter the amount to transfer not greater than amount :"+b[3]);
	int transferamount=input.nextInt();
	int sender=Integer.valueOf(b[3]);
	int reciever=Integer.valueOf(a[3]);
	sender-=transferamount;
	reciever+=transferamount;
	b[3]=String.valueOf(sender);
	a[3]=String.valueOf(reciever);
	System.out.println(transferamount+" amount is debited to holder name :"+a[2]);
	System.out.println("Balence is "+b[3]);
	last(se,t);
	}
	
	public static void options() {
		System.out.println("Enter the Choice from the list");
		while(true){
		System.out.println("1.cashwithdrawl\t2.cash deposit\t3.Check Balence\t4.display details\t5.amount transfer\t6.exit");
		Scanner input1=new Scanner(System.in);
		int option=input1.nextInt();
		switch(option) {
		case 1:
			System.out.println("Enter the amount to withdrawl not greater than "+b[3]);
			int withdrawamount=input1.nextInt();
					cashwithdrawl(withdrawamount);break;
		case 2:System.out.println("Enter the amount to deposit");
		int depositamount=input1.nextInt();
		deposit(depositamount);break;
		case 3:System.out.println("Balence in the account is :"+b[3]);break;
		case 4:display(b[1],b[2],b[3]);break;
		case 5:amount_transfer();break;
		case 6:last(se,-1);
		System.out.println("Thanks For Visiting!");
			System.exit(1);
		default:System.out.println("Enter the correct choice");
		}
		}
	}
	public static void signup() {
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the Name ");
		String name=input.nextLine();
		System.out.println("Enter the Account Number: ");
		String aco=input.nextLine();
		System.out.println("Enter the Amount to deposit:");
		String amount=input.nextLine();
		System.out.println("Enter the Address:");
		String address=input.nextLine();
		System.out.println("The Successfully amount is credited");
		writemethod(aco,name,amount);
	}
	public static void display(String aco,String name,String amount) {
		System.out.println("THE DETAILS OF THE PERSON  ");
		System.out.println("Account number: "+aco);
		System.out.println("Name : "+name);
		System.out.println("Amount : "+amount);
	}
	
	public static void writemethod(String aco,String name,String amount) {
		String acon=aco.concat("\n");
		String namen=name.concat("\n");
		String amountn=amount.concat("\n");
		try {
			FileWriter f=new FileWriter("krishna.txt",true);
			f.write(acon);
			f.write(namen);
			f.write(amountn);
			f.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
	}
public static void main(String[] args) {
	while(true) {
	System.out.println("Enter the choice\n");
	System.out.println("1.LOGIN \t2.SIGNIN \t3.EXIT");
	Scanner input=new Scanner(System.in);
	int choice=input.nextInt();
	switch(choice) {
	case 1:login();break;
	case 2:signup();break;
	case 3:System.exit(1);
	}
	}
}
}
