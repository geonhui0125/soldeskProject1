package dataset;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DatasetCSV {
	private static DatasetCSV dataset = null;
	public List<List<String>> cpuDataset = new ArrayList<>();
	public List<List<String>> gpuDataset = new ArrayList<>();
	public List<List<String>> motherBoardDataset = new ArrayList<>();

	private DatasetCSV(){
		File cpuCSV = new File("src/dataset/cpu_Dataset.csv");
		File gpuCSV = new File("src/dataset/gpu_Dataset.csv");
		File motherBoardCSV = new File("src/dataset/MotherBoard_Dataset.csv");
		BufferedReader[] br = new BufferedReader[3];
		String line = "";
		try {
			br[0]=new BufferedReader(new FileReader(cpuCSV));
			br[1]=new BufferedReader(new FileReader(gpuCSV));
			br[2]=new BufferedReader(new FileReader(motherBoardCSV));
			for(int i = 0;i<br.length;i++) {
				while((line=br[i].readLine())!=null) {
					List<String> newLine = new ArrayList<>();
					String[] lineArr=line.split(",");
					newLine = Arrays.asList(lineArr);
					switch (i) {
					case 0:
						cpuDataset.add(newLine);
						break;
					case 1:
						gpuDataset.add(newLine);
						break;
					case 2:
						motherBoardDataset.add(newLine);
						break;
					default:
						System.out.println("Out of Bound");
					}
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(br[0]!=null||br[1]!=null||br[2]!=null) {
					br[0].close();
					br[1].close();
					br[2].close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	public static DatasetCSV getInstance() {
		if(dataset==null) {
			dataset= new DatasetCSV();
		}
		return dataset;
	}
	@Override
	public String toString() {
		return "DatasetCSV [cpuDataset=" + cpuDataset.size() + ", gpuDataset=" + gpuDataset.size() + ", motherBoardDataset="
				+ motherBoardDataset.size() + "]";
	}

}
