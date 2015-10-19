import java.io.*;
import java.util.Scanner;

public class SatPix {

	public static void runSatPix(String inputFileName, String outputFileName) throws IOException
	{
		boolean[][] booleanArr = fileToBoolArray(inputFileName);
		int sizeOfLargestPasture=0;
		int fuckThis;
		for (int i=0;i<booleanArr.length;i++)
		{
			for(int k=0;k<booleanArr[0].length;k++)
			{
				fuckThis=recursivelyMeasureAndMarkPasture(i,k,booleanArr);
				if(fuckThis>sizeOfLargestPasture)
				{
					sizeOfLargestPasture=fuckThis;
				}
			}
		}
		
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outputFileName)));
		out.println(sizeOfLargestPasture);
		out.close();
		}
	
	private static boolean[][] fileToBoolArray(String fileName) throws FileNotFoundException, IOException
	{
		Scanner s=new Scanner(new File(fileName));
		int w=s.nextInt();
		int l=s.nextInt();
		boolean[][] ret=new boolean[w][l];
		
		int index=0;
		for(int i=0;i<l;i++)
		{
			String str=s.next();
			index=0;
			for(int k=0;k<w;k++)
			{
				
				ret[k][i]=(str.charAt(index)=='*');
				index++;
			}
		}
		return ret;
	}

	private static int recursivelyMeasureAndMarkPasture(int row, int col, boolean[][] arr)
	{
		//This recursive method employs the flood-fill algorithm to
		//count the size of a single pasture and "mark" it so it is not double-counted
		int count=0;
		if(row>=0&&row<arr.length&&col>=0&&col<arr[0].length&&arr[row][col]==true)
		{
			count++;
			arr[row][col]=false;
			count+=recursivelyMeasureAndMarkPasture(row+1, col, arr);
			count+=recursivelyMeasureAndMarkPasture(row, col+1, arr);
			count+=recursivelyMeasureAndMarkPasture(row, col-1, arr);
			count+=recursivelyMeasureAndMarkPasture(row-1, col, arr);
		}
		return count;
	}
	
}