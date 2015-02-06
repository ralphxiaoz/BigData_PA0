import java.io.*;

public class AmazonReview{
	public static void main(String[] args){
		String sourcePath = "/home/o/class/cs129a/assignment4/all.txt"; //path may vary
		String resultPath = "/home/o/class/cs129a/assignment4/Leifeng_20141118.txt"; //path may vary
		
		FileReader fr = null;
		FileWriter fw = null;
		try{
			try{
				fr = new FileReader(sourcePath);
				fw = new FileWriter(resultPath);
			}catch(FileNotFoundException e){
				e.printStackTrace();
			}

			BufferedReader br = new BufferedReader(fr);
			BufferedWriter bw = new BufferedWriter(fw);
			
			String line;
			while((line = br.readLine()) != null){
				
				String subLine;
				
				if (line.indexOf("product/productId: ") != -1) {
					bw.write(line.substring(19)+",");
				}
				if (line.indexOf("review/userId: ") != -1) {
					bw.write(line.substring(15)+",");
				}
				if (line.indexOf("review/score: ") != -1) {
					bw.write(line.substring(14)+"\n");
				}
				
			}
			br.close();
			bw.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}