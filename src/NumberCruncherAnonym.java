import java.util.function.BiFunction;
import java.util.Random;
import java.util.Arrays;
import java.lang.Float;
import java.util.function.Consumer;


public class NumberCruncherAnonym {
	float[] floatarr;

	public NumberCruncherAnonym(float[] floatarr) {
		this.floatarr = floatarr;
	}

	/*
	 * takes the name of the operations and runs the operations according to input
	 * 
	 */

	//Here we will check the operations names and call correct classes and methods!
	public void crunch(String [] operations) throws Exception {
		
		for(String operation : operations) {
			
			/*sum: Summiert die Elemente des Arrays paarweise von 
			 * links nach rechts auf und speichert den neuen Wert 
			 * in dem jeweils rechten Datenfeld. D.h.: 
			 * a[1] = a[0] + a[1]; a[2] =a[1] + a[2] usw.*/
			if(operation.equalsIgnoreCase("sum")) {
				System.out.println("Array before the sum  operation is "+ Arrays.toString(floatarr));
				Consumer<float[]> consObj = new Consumer<float[]>() {

					@Override
					public void accept(float[] values) {
						for (int i = 0; i < values.length - 1; i++) {
							values[i] = values[i] + values[i +1];
						}						
					}
				};
				consObj.accept(getNumbers());
				System.out.println("Array after the sum operation is "+ Arrays.toString(floatarr));

					
				
			}
			else if(operation.equalsIgnoreCase("div")) {
				System.out.println("Array before the div  operation is "+ Arrays.toString(floatarr));
				
				Consumer<float[]> consObj = new Consumer<float[]>() {
					@Override
					public void accept(float[] values) {
						Arrays.sort(values);
						System.out.println("Array after sort"+ Arrays.toString(floatarr));

						
						int tail = values.length -1;
						
						for( int head = 0; head < values.length/2; head++) {
							//Greatest value is at the end of the array and 
							//smallest one at the head
							values[tail] = values[tail]/ values[head];
							tail--;
						}						
					}
				};
				consObj.accept(getNumbers());
				System.out.println("Array before the div  operation is "+ Arrays.toString(floatarr));
				
			}
			else if(operation.equalsIgnoreCase("subtract")) {
				System.out.println("Array before the subtract  operation is "+ Arrays.toString(floatarr));				
				Consumer<float[]> consObj = new Consumer<float[]>() {
					@Override
					public void accept(float[] values) {
						for (int i = 0; i < values.length - 1; i++) {
							values[i] = values[i] - values[i +1];
						}						
					}
				};
				consObj.accept(getNumbers());
				System.out.println("Array after the subtract  operation is "+ Arrays.toString(floatarr));
		
			}	
			/*swirl: Führt n zufällige Vertauschungen der Datenfelder durch; n ist durch die Länge des
				float-Arrays gegeben.
			 * */
			else if(operation.equalsIgnoreCase("swirl")) {
				System.out.println("Array before the swirl  operation is "+ Arrays.toString(floatarr));

				Consumer<float[]> consObj = new Consumer<float[]>() {
					@Override
					public void accept(float[] values) {
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
					}
				};
				consObj.accept(getNumbers());
				System.out.println("Array after the swirl  operation is "+ Arrays.toString(floatarr));

			}
			/*average: Bestimmt den Durchschnitt aller Werte im Array und speichert 
			 * den Durchschnittswert im Datenfeld mit dem größten Wert.*/
			else if(operation.equalsIgnoreCase("average")) {
				System.out.println("Array before the average  operation is "+ Arrays.toString(floatarr));

				Consumer<float[]> consObj = new Consumer<float[]>() {
					@Override
					public void accept(float[] values) {
						// TODO Auto-generated method stub
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
					}
				};
				consObj.accept(getNumbers());
				
				System.out.println("Array after the average  operation is "+ Arrays.toString(floatarr));
				
			}
			else {
				throw new Exception("No operation with this name is found!");

			}
				
		}
	}
	
	/*
	 * returns the float numbers
	 * 
	 */
public float[] getNumbers() {
	return this.floatarr;
}
	

}