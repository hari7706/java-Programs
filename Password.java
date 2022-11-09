import java.util.Scanner;
class PasswordException extends Exception{
	void message()
	{
		System.out.println("the password should contain blah blah blah");
	}
}
class Password
{
	String password;

	Password(String password)
	{
		this.password =password;

	}
	void validatePassword() throws PasswordException{
		String capitalAlphabets =" ";
		String smallAlphabets ="";
		String numbers ="";
		String characters ="";

		if(password.length()>=8 ){
		for(char a :password.toCharArray()){
			if(a>=65 && a<=90)
			{
				capitalAlphabets +=Character.toString(a);
			}
			else if(a>=97 && a<=122)
			{
				smallAlphabets +=Character.toString(a);
			}
			else if(a>=48 && a<=57)
			{
				numbers +=Character.toString(a);
			}
			else 
			{
				characters +=Character.toString(a);
			}
		}
		if(capitalAlphabets.length()==0 || smallAlphabets.length()==0 || numbers.length()==0 || characters.length()==0)
		{
			throw new PasswordException();
		}
		else
		{
			System.out.println("This is a valid Passoword");
		}
		}
		else{
			throw new PasswordException();
		}
	}
	public static void main(String args[]){
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter your password");
		String pass =sc.nextLine();
		Password p = new Password(pass);

		try{
			p.validatePassword();
		}
		catch(PasswordException e){
			e.message();
			e.printStackTrace();
		}
	
	}
}
