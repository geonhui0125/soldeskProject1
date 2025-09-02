package dataset;



public class TestMain {
	public static void main(String[] args) {
		DatasetCSV test = DatasetCSV.getInstance();
		System.out.println(test.toString());
		System.out.println("==================cpu==================");
		for(int i = 1;i<test.cpuDataset.size();i++) {
			System.out.println(test.cpuDataset.get(i));
		}
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("==================gpu==================");
		for(int i = 1;i<test.gpuDataset.size();i++) {
			System.out.println(test.gpuDataset.get(i));
		}
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("==================MotherBoard==================");
		for(int i = 1;i<test.motherBoardDataset.size();i++) {
			System.out.println(test.motherBoardDataset.get(i));
		}
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
	}
}
