import java.util.Arrays;
import java.util.Random;

public class NumberCruncherTopLevel {
	float[] floatarr;
	//constructor
	public NumberCruncherTopLevel(float[] floatarr) {
		this.floatarr = floatarr;
	}
	
	//Class for Swirl operation
		class Swirl implements CrunchOperation{
			@Override
			public void crunch(float[] values) {
				System.out.println("Array before the swirl  operation is "+ Arrays.toString(floatarr));

				Random rand = new Random();
				
				for (int i = 0; i < values.length; i++) {
					//get first random element
					int index1 = rand.nextInt(values.length);
					//get second random element
					int index2 = rand.nextInt(values.length);
					// Swap process
					float temp = values[index1];
					values[index1] = values[index2];
					values[index2] = temp;
				}
				System.out.println("Array after the swirl  operation is "+ Arrays.toString(floatarr));

			}
		}
		//Class for average operation
		class Average implements CrunchOperation{
			@Override
			public void crunch(float[] values) {
				System.out.println("Array before the average  operation is "+ Arrays.toString(floatarr));

				//Find the index of biggest number
				int maxIndex =0;
				float max = Float.NEGATIVE_INFINITY;
				for(int i=0;i<values.length;i++) {
					if(values[i] > max) {
						max = values[i];
						maxIndex = i;
					}		
				}
				//get the total
				float total = 0;
				for(int i=0;i<values.length;i++) {
					total = total+floatarr[i];
				}
				//calculate average
				float average = total / values.length;
				//write the average in the place of biggest one
				values[maxIndex] = average;
				System.out.println("Array after the average  operation is "+ Arrays.toString(floatarr));

			}
		}
		
		
	//Class for sum operation
	class Sum implements CrunchOperation{
		@Override
		public void crunch(float[] values) {
			System.out.println("Array before the sum  operation is "+ Arrays.toString(floatarr));

			for (int i = 0; i < values.length - 1; i++) {
				values[i] = values[i] + values[i +1];
			}
			System.out.println("Array after the sum  operation is "+ Arrays.toString(floatarr));

		}

	}
	//Class for subtract operation
		class Subtract implements CrunchOperation{
			
			@Override
			public void crunch(float[] values) {
				System.out.println("Array before the subtract  operation is "+ Arrays.toString(floatarr));

				for (int i = 0; i < values.length - 1; i++) {
					values[i] = values[i] - values[i +1];
				}
				System.out.println("Array after the subtract  operation is "+ Arrays.toString(floatarr));

			}
		}
	//Class for div operation
		class Div implements CrunchOperation{
			@Override
			public void crunch(float[] values) {
				System.out.println("Array before the div  operation is "+ Arrays.toString(floatarr));

				Arrays.sort(values);
				int tail = values.length -1;
				
				for( int head = 0; head < values.length/2; head++) {
					//Greatest value is at the end of the array and 
					//smallest one at the head
					values[tail] = values[tail]/ values[head];
					tail--;
				}
				System.out.println("Array before the div  operation is "+ Arrays.toString(floatarr));

			}
		}
	
	//Here we will check the operations names and call correct classes and methods!
	public void crunch(String [] operations) throws Exception {
		
		for(String operation : operations) {
			if(operation.equalsIgnoreCase("sum")) {
				
				Sum sumObj = new Sum();
				sumObj.crunch(floatarr);
				
			}
			else if(operation.equalsIgnoreCase("div")) {
				Div divObj = new Div();
				divObj.crunch(floatarr);
				
			}
			else if(operation.equalsIgnoreCase("subtract")) {
				Subtract sbtObj = new Subtract();
				sbtObj.crunch(floatarr);
				
			}	
			else if(operation.equalsIgnoreCase("swirl")) {
				Swirl swrObj = new Swirl();
				swrObj.crunch(floatarr);
						
				
			}
			else if(operation.equalsIgnoreCase("average")) {
				Average avrObj = new Average();
				avrObj.crunch(floatarr);
				
				
			}
			else {
				throw new Exception("No operation with this name is found!");

			}
			
			
		}
		
	}
	
}
