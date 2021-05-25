import java.util.Random;
import java.util.Arrays;
import java.lang.Float;


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
				CrunchOperation sum = new CrunchOperation() {
					@Override
					public void crunch(float[] values) {
						System.out.println("Array before the sum  operation is "+ Arrays.toString(floatarr));
						for (int i = 0; i < values.length - 1; i++) {
							values[i] = values[i] + values[i +1];
						}	
							
						System.out.println("Array after the sum operation is "+ Arrays.toString(floatarr));		
					
					}
					
				};
				sum.crunch(floatarr);
			
			}

				/*
				 * divide: Teilt die n/2 größten Werte im Array durch die n/2 Kleinsten und speichert den
					neuen Wert im Datenfeld des jeweils größeren Wertes. D.h. der größte Wert wird durch
					den Kleinsten geteilt. Der Zweitgrößte durch den Zweitkleinsten usw.*/
			else if(operation.equalsIgnoreCase("div")) {

				CrunchOperation div = new CrunchOperation() {
					
					@Override
					public void crunch(float[] values) {
						// TODO Auto-generated method stub
						System.out.println("Array before the div  operation is "+ Arrays.toString(floatarr));
						Arrays.sort(values);
						System.out.println("Array after sort"+ Arrays.toString(floatarr));
						int tail = values.length -1;
						//till the middle of the array
						for( int head = 0; head < values.length/2; head++) {
							//Greatest value is at the end of the array and 
							//smallest one at the head
							values[tail] = values[tail]/ values[head];
							//move head and tail of the array after every  loop
							tail--;
						}
						System.out.println("Array before the div  operation is "+ Arrays.toString(floatarr));
						
					}
				};
				div.crunch(floatarr);
					
			}
			else if(operation.equalsIgnoreCase("subtract")) {
				/*
				 * Analog zu sum nur mit Subtraktion.
				 * */
				CrunchOperation subtract = new CrunchOperation() {
					
					@Override
					public void crunch(float[] values) {
						// TODO Auto-generated method stub
						System.out.println("Array before the subtract  operation is "+ Arrays.toString(floatarr));				
						for (int i = 0; i < values.length - 1; i++) {
							values[i] = values[i] - values[i +1];
						}		
						System.out.println("Array after the subtract  operation is "+ Arrays.toString(floatarr));
					}
				};
				subtract.crunch(floatarr);
		
			}	
			/*swirl: Führt n zufällige Vertauschungen der Datenfelder durch; n ist durch die Länge des
				float-Arrays gegeben.
			 * */
			else if(operation.equalsIgnoreCase("swirl")) {
				
				CrunchOperation swirl = new CrunchOperation() {
					
					@Override
					public void crunch(float[] values) {
						// TODO Auto-generated method stub
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
				};
				swirl.crunch(floatarr);

			}
			/*average: Bestimmt den Durchschnitt aller Werte im Array und speichert 
			 * den Durchschnittswert im Datenfeld mit dem größten Wert.*/
			else if(operation.equalsIgnoreCase("average")) {
				
				CrunchOperation average = new CrunchOperation() {
					
					@Override
					public void crunch(float[] values) {
						// TODO Auto-generated method stub
						System.out.println("Array before the average  operation is "+ Arrays.toString(floatarr));
						//get the index of the max element in the array
						int maxIndex =0;
						//smallest possible float
						float max = Float.NEGATIVE_INFINITY;
						for(int i=0;i<values.length;i++) {
							if(values[i] >= max) {
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
				};
				average.crunch(floatarr);
				
			}
			else {
				throw new Exception("No operation with this name is found!");

			}
				
		}
	}
	
	/*
	 * returns the float array
	 * 
	 */
public float[] getNumbers() {
	return this.floatarr;
}
	

}