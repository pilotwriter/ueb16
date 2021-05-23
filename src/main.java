import java.util.Iterator;

import java.util.Scanner;

import java.util.Arrays;

public class main {
	static float arr[];
	static Scanner scan = new Scanner(System.in);
	static NumberCruncherAnonym anon;
	static NumberCruncherTopLevel topLevel;
	
	

	//Take manual numbers as a string and parse them to float
	public static void stringToFloat(String numbers) {
		arr = new float[numbers.split(" ").length];
		for (int i = 0; i < numbers.split(" ").length; i++) {
			try {
				float f = Float.parseFloat(numbers.split(" ")[i]);
				arr[i] = f;
				
			}
			 catch (NumberFormatException ex){
		            ex.printStackTrace();
		        }
		}
		System.out.println("Your Array is :" + Arrays.toString(arr));
	}

	public static void main(String[] args) throws Exception {

		// TODO Auto-generated method stub
		System.out.println("Please choose an option");
		System.out.println("1)Give the numbers to the fill the arrray");
		System.out.println("2)Fill the array Automatic with random numbers up to 20");
		System.out.println("0)Exit");
		String selectstr = scan.nextLine();
		int select = Integer.parseInt(selectstr);
		//to exit,it is not in a  loop, no additional action required,it will stop automatically.
		if (select == 0) {
			

		} else if (select == 1) {
			//Manual input
			System.out.println("Please write the numbers with one space between them");
			try {
				String nums = scan.nextLine();
				stringToFloat(nums);
				operations();
			}catch(Exception e){
					System.out.println(e);
			}
	
			
			
			// Let user to fill all the number automatically.
		} else if (select == 2) {
			System.out.println("How many elements do you want to add to the array?");
				String amountStr = scan.nextLine();
				int amount  = Integer.parseInt(amountStr);
				//initialize the array 
				arr = new float[amount];
				//fill the array with random floats
				for(int i =0;i<amount;i++) {
					float f = (float) (Math.random()* 20);
					arr[i] = f;
				}
				System.out.println("Created array is :" + Arrays.toString(arr));
				operations();
		} 
		else {
			System.out.println("No Operations with this number found,please start again!");
		}
	}
	
	public static void operations() throws Exception
	{
		System.out.println("Please write your operations with a space between");
		System.out.println("Possible operations are \n Sum,swirl,div,subtract,average");
		String operations = scan.nextLine();
		anon = new NumberCruncherAnonym(arr);
		topLevel = new NumberCruncherTopLevel(arr);
		try {
			anon.crunch(operations.split(" "));
		}

		catch(Exception e) {
		      System.out.println(e);

		}
			
	}
}
