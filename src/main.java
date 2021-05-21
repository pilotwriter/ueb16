import java.util.Iterator;
import java.util.Arrays;
public class main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		float arr[] = new float[]{ 12.5f,24,3,4,5,6,7,8,9 }; 
		NumberCruncherAnonym obj = new NumberCruncherAnonym(arr);
		NumberCruncherTopLevel topObj = new NumberCruncherTopLevel(arr);
		
		String [] operations = new String[] {"Sum"};
		topObj.crunch(operations);
				//obj.crunch(operations);
				
		//obj.average();
		
				
//				for(int i = 0;i< obj.getNumbers().length;i++) {
//					System.out.println(obj.getNumbers()[i]);
//				}
			
	}

}
