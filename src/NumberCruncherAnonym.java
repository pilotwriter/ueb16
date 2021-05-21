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
			if(operation.equalsIgnoreCase("sum")) {
				Consumer<float[]> consObj = new Consumer<float[]>() {

					@Override
					public void accept(float[] values) {
						for (int i = 0; i < values.length - 1; i++) {
							values[i] = values[i] + values[i +1];
						}						
					}
				};
				consObj.accept(getNumbers());
					
				
			}
			else if(operation.equalsIgnoreCase("div")) {
				Consumer<float[]> consObj = new Consumer<float[]>() {

					@Override
					public void accept(float[] values) {
						float [] sorted  = new float[values.length];
						//copy the array
						System.arraycopy(values, 0, sorted, 0, values.length);
						//sort the array
						Arrays.sort(sorted);
					
						int tail = sorted.length -1;
						
						for( int head = 0; head < sorted.length/2; head++) {
							//index of biggest variable
							int max = Arrays.asList(values).indexOf(24.0);
							System.out.println(max);
							//index of smallest variable
//							int min = Arrays.asList(values).indexOf(sorted[head]);
//							System.out.println(max);
//							System.out.println(min);
		//
//							values[max] = values[max] / values[min];
//							tail --;
						}						
					}
				};
				consObj.accept(getNumbers());
					
				
				
			
				
			}
			else if(operation.equalsIgnoreCase("substract")) {
				
				Consumer<float[]> consObj = new Consumer<float[]>() {
					@Override
					public void accept(float[] values) {
						for (int i = 0; i < values.length - 1; i++) {
							values[i] = values[i] - values[i +1];
						}						
					}
				};
				consObj.accept(getNumbers());
				
		
			}	
			else if(operation.equalsIgnoreCase("swirl")) {
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
			
						
				
			}
			else if(operation.equalsIgnoreCase("average")) {
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

		
				
				
			}
			else {
				throw new Exception("No operation with this name is found!");

			}
				
		}
	}
	


	// sum 2 float element, save result a left one
	public void sum() {
		// parameter, parameter, return type
		BiFunction<Float, Float, Float> sumObj = new BiFunction<Float, Float, Float>() {
			@Override
			public Float apply(Float t, Float u) {
				return t + u;
			}
		};
		for (int i = 0; i < this.floatarr.length - 1; i++) {
			floatarr[i] = sumObj.apply(floatarr[i], floatarr[i + 1]);
		}
	}

	// Führt n zufällige Vertauschungen der Datenfelder durch; n ist durch die Länge
	// des
	// float-Arrays gegeben.
	public void swirl(int n) {
		Random rand = new Random();
		
		for (int i = 0; i < n; i++) {
			int index1 = rand.nextInt(n);
			int index2 = rand.nextInt(n);
			float temp = floatarr[index1];
			floatarr[index1] = floatarr[index2];
			floatarr[index2] = temp;
		}
	}
	public void divide() {
		float [] sorted  = new float[floatarr.length];
		//copy the array
		System.arraycopy(floatarr, 0, sorted, 0, floatarr.length);
		//sort the array
		Arrays.sort(sorted);
	
		int tail = sorted.length -1;
		
		for( int head = 0; head < sorted.length/2; head++) {
			//index of biggest variable
			int max = Arrays.asList(floatarr).indexOf(sorted[tail]);
			//index of smallest variable
			int min = Arrays.asList(floatarr).indexOf(sorted[head]);
			System.out.println(max);
			System.out.println(min);

			floatarr[max] = floatarr[max] / floatarr[min];
//			tail --;
		}
//		System.arraycopy(sorted, 0, floatarr, 0, sorted.length);
//		System.out.println(Arrays.toString(floatarr));
	}
	/*
	 * returns the float numbers
	 * 
	 */
	public float[] getNumbers() {
		return this.floatarr;

	}
	
	public void average() {
		//Find the index of biggest number
		int maxIndex =0;
		float max = Float.NEGATIVE_INFINITY;
		for(int i=0;i<floatarr.length;i++) {
			if(floatarr[i] > max) {
				max = floatarr[i];
				maxIndex = i;
			}		
		}
		//get the average
		float total = 0;
		for(int i=0;i<floatarr.length;i++) {
			total = total+floatarr[i];
		}
		//calculate average
		float average = total / floatarr.length;
		//write the average in the place of biggest one
		floatarr[maxIndex] = average;

	}

}