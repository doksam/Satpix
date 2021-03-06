
	import java.io.*;

	public class SatPix {

		public static void main(String[] args) throws IOException
		{
			boolean[][] booleanArr = fileToBoolArray("satpix.in");
			int sizeOfLargestPasture;
			
			Scanner s = new Scanner(new File("satpix.in"));
			
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("satpix.out")));
			out.println(sizeOfLargestPasture);
			out.close();
			}
		
		private static boolean[][] fileToBoolArray(String fileName) throws FileNotFoundException, IOException
		{
			//This helper method converts the input file into a 2D array of booleans
		}

		private static int recursivelyMeasureAndMarkPasture(int row, int col, boolean[][] arr)
		{
			//This recursive method employs the flood-fill algorithm to
			//count the size of a single pasture and "mark" it so it is not double-counted
			return 0;
		}
		
	}

